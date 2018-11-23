package com.prs.utils;


import java.util.Date;
import java.sql.Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class TimeSee {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int year = now.get(Calendar.YEAR); 
		int moth = now.get(Calendar.MONTH);
		int date = now.get(Calendar.DATE); 
		Date d =  now.getTime();
		Time t = ServletFunctions.getNowTime();
		System.out.println(t);
		System.out.println(year+"-"+moth+"-"+date);
		
		System.out.println(moth);
		System.out.println(date);
		System.out.println(d);

		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String ti = "22:12:22";
		try {
			java.sql.Time timeValue = new java.sql.Time(formatter.parse(ti).getTime());
			System.out.println(timeValue);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("HH:mm:ss");
		String str = "12:22:10";
		LocalTime time = LocalTime.parse(str, formatterr);
		System.out.println(time);
		
		Time tt = ServletFunctions.strToTime("08:10:12");
		System.out.println(tt);
	}

}
