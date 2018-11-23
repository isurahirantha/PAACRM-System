package com.prs.model;

import java.sql.Date;

public class PExperienceBean {

	private int auto_date_id;
	private String user_id;
	private String aria;
	private String place;
	private Date from_date;
	private Date to_date;
	
	public PExperienceBean() {}

	public PExperienceBean(int auto_date_id, String user_id, String aria, String place, Date from_date, Date to_date) {
		super();
		this.auto_date_id = auto_date_id;
		this.user_id = user_id;
		this.aria = aria;
		this.place = place;
		this.from_date = from_date;
		this.to_date = to_date;
	}

	public int getAuto_date_id() {
		return auto_date_id;
	}

	public void setAuto_date_id(int auto_date_id) {
		this.auto_date_id = auto_date_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAria() {
		return aria;
	}

	public void setAria(String aria) {
		this.aria = aria;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	@Override
	public String toString() {
		return "PExperienceBean [auto_date_id=" + auto_date_id + ", user_id=" + user_id + ", aria=" + aria + ", place="
				+ place + ", from_date=" + from_date + ", to_date=" + to_date + "]";
	}
	
	
	
}
