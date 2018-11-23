package com.prs.model;

import java.sql.Date;

public class EducationBean {

	private int auto_id;
	private String user_id;
	private String name;
	private String degree;
	private Date fromTime;
	private Date toTime;
	
	
	public EducationBean(){}


	public EducationBean(int auto_id, String user_id, String name, String degree, Date fromTime, Date toTime) {
		super();
		this.auto_id = auto_id;
		this.user_id = user_id;
		this.name = name;
		this.degree = degree;
		this.fromTime = fromTime;
		this.toTime = toTime;
	}


	public int getAuto_id() {
		return auto_id;
	}


	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	public Date getFromTime() {
		return fromTime;
	}


	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}


	public Date getToTime() {
		return toTime;
	}


	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}



	
	
	
	
}
