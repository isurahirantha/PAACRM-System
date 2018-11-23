package com.prs.model;

public class ImageBean {
 private int id;
 private String filename;
 private String pathname;
 private String user_id;

 public ImageBean(int id, String filename, String pathname, String user_id) {
	super();
	this.id = id;
	this.filename = filename;
	this.pathname = pathname;
	this.user_id = user_id;
}
 
 public ImageBean(){}

 
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFilename() {
	return filename;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public String getPathname() {
	return pathname;
}

public void setPathname(String pathname) {
	this.pathname = pathname;
}

public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

@Override
public String toString() {
	return "ImageBean [id=" + id + ", filename=" + filename + ", pathname=" + pathname + ", user_id=" + user_id + "]";
}


 
}
