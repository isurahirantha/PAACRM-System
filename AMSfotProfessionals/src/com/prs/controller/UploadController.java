package com.prs.controller;

import java.io.File;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.prs.dao.QueryFactory;
import com.prs.model.ImageBean;
import com.prs.utils.ServletFunctions;

@WebServlet("/UploadController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)

public class UploadController extends HttpServlet {
	public static final String UPLOAD_DIR = "profimages";
    public String dbFileName = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   	
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Part part = request.getPart("pic_path");//
        String fileName = extractFileName(part);//file name

        /**
         * *** Get The Absolute Path Of The Web Application ****
         */
        String applicationPath = getServletContext().getRealPath("");
        String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
        System.out.println("applicationPath:" + applicationPath);
        System.out.println("uploadPath:" + uploadPath);
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
        //String savePath = uploadPath + File.separator + fileName;
        String savePath = "C:\\Users\\Isura\\Dropbox\\projects\\AMS\\AMSfotProfessionals\\WebContent\\profimages"+ File.separator + fileName;
        System.out.println("savePath: " + savePath);
        String sRootPath = new File(savePath).getAbsolutePath();
        System.out.println("sRootPath: " + sRootPath);
        part.write(savePath + File.separator);
        File fileSaveDir1 = new File(savePath);
        /*if you may have more than one files with same name then you can calculate some random characters
         and append that characters in fileName so that it will  make your each image name identical.*/
        dbFileName = UPLOAD_DIR + File.separator + fileName;
        part.write(savePath + File.separator);
        //out.println(id+" "+firstName+" "+lastName+" "+fileName+" "+savePath);
        /*
         You need this loop if you submitted more than one file
         for (Part part : request.getParts()) {
         String fileName = extractFileName(part);
         part.write(savePath + File.separator + fileName);
         }*/
        
        int result=0; 
        HttpSession session = request.getSession();
        ImageBean ibean = new ImageBean();
        ibean.setFilename(dbFileName);
        ibean.setPathname(savePath);
        ibean.setUser_id(session.getAttribute("User-ID").toString());
        System.out.println(ibean.toString());
        result = QueryFactory.getImageQueries().updateQuery(ibean);
        System.out.println(result);
        
		String user_id = session.getAttribute("User-ID").toString();
		//If Upload Success
        if(result==1){
        		String action = request.getParameter("profile");   	
    			ServletFunctions.dispatchProfessionalInfo(request, response, user_id);	
  			
    			String uri = "edit-seller-profile.jsp?upload=ok";
    			RequestDispatcher rd = request.getRequestDispatcher(uri);
    			rd.forward(request, response); 
    			//If Upload NOT Success	
    	}else{
				ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
				String uri = "edit-seller-profile.jsp?upload=notok";
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response); 
    	}

    }
    
    //file name of the upload file is included in content-disposition header like this:
    //form-data; name="dataFile"; filename="PHOTO.JPG"

    private String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

}