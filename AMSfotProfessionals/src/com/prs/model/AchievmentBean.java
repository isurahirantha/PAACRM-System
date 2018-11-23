package com.prs.model;

import java.sql.Date;

public class AchievmentBean {

	private int auto_id;
	private String	user_id;
	private String	title;
	private String	institute;
	private Date	duedate;
	

	public AchievmentBean(){}

	public AchievmentBean(int auto_id, String user_id, String title, String institute, Date duedate) {
		super();
		this.auto_id = auto_id;
		this.user_id = user_id;
		this.title = title;
		this.institute = institute;
		this.duedate = duedate;
		
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}



	@Override
	public String toString() {
		return "AchievmentBean [auto_id=" + auto_id + ", user_id=" + user_id + ", title=" + title + ", institute="
				+ institute + ", duedate=" + duedate + "]";
	}
	
	
}
