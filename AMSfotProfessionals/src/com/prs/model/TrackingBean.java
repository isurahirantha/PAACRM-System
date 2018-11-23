package com.prs.model;

import java.sql.Date;
import java.sql.Time;

public class TrackingBean {

	


	private int auto_id;
	private String user_id;
	private String ip;
	private Time log_time;
	private Date log_date;
	

	
	public TrackingBean(){}



	public TrackingBean(int auto_id, String user_id, String ip, Time log_time, Date log_date) {
		super();
		this.auto_id = auto_id;
		this.user_id = user_id;
		this.ip = ip;
		this.log_time = log_time;
		this.log_date = log_date;
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



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public Time getLog_time() {
		return log_time;
	}



	public void setLog_time(Time log_time) {
		this.log_time = log_time;
	}



	public Date getLog_date() {
		return log_date;
	}



	public void setLog_date(Date log_date) {
		this.log_date = log_date;
	}



	@Override
	public String toString() {
		return "TrackingBean [auto_id=" + auto_id + ", user_id=" + user_id + ", ip=" + ip + ", log_time=" + log_time
				+ ", log_date=" + log_date + "]";
	}

	
	
	
}
