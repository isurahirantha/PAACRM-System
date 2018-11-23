package com.prs.model;

import java.sql.Date;

public class MsgBean {

	private int auto_id;
	private String professional_id;
	private String client_id;
	private String message;
	private Boolean isClient;
	private Date date_msg;
	private String time_msg;
	
	public MsgBean(){}

	public MsgBean(int auto_id, String professional_id, String client_id, String message, Boolean isClient, Date date_msg,
			String time_msg) {
		super();
		this.auto_id = auto_id;
		this.professional_id = professional_id;
		this.client_id = client_id;
		this.message = message;
		this.isClient = isClient;
		this.date_msg = date_msg;
		this.time_msg = time_msg;
	}

	public int getAuto_id() {
		return auto_id;
	}

	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}

	public String getProfessional_id() {
		return professional_id;
	}

	public void setProfessional_id(String professional_id) {
		this.professional_id = professional_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getisClient() {
		return isClient;
	}

	public void setisClient(Boolean isClient) {
		this.isClient = isClient;
	}

	public Date getDate_msg() {
		return date_msg;
	}

	public void setDate_msg(Date date_msg) {
		this.date_msg = date_msg;
	}

	public String getTime_msg() {
		return time_msg;
	}

	public void setTime_msg(String time_msg) {
		this.time_msg = time_msg;
	}

	@Override
	public String toString() {
		return "MsgBean [auto_id=" + auto_id + ", professional_id=" + professional_id + ", client_id=" + client_id
				+ ", message=" + message + ", isClient=" + isClient + ", date_msg=" + date_msg + ", time_msg=" + time_msg
				+ "]";
	}


	
	
	
}
