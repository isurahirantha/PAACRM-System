package com.prs.model;

import java.sql.Date;

public class BookingBean {

	private int schedule_id;
	private String professional_id;
	private int auto_id;
	private String client_id;
	private Date date_booked;
	private String time_from;
	private String time_to;
	private String professional_name;
	private String client_name;
	private Boolean isConfirmed;
	private String random_code;

	public BookingBean(){}

	public BookingBean(int schedule_id, String professional_id, int auto_id, String client_id, Date date_booked,
			String time_from, String time_to, String professional_name, String client_name, Boolean isConfirmed,
			String random_code) {
		super();
		this.schedule_id = schedule_id;
		this.professional_id = professional_id;
		this.auto_id = auto_id;
		this.client_id = client_id;
		this.date_booked = date_booked;
		this.time_from = time_from;
		this.time_to = time_to;
		this.professional_name = professional_name;
		this.client_name = client_name;
		this.isConfirmed = isConfirmed;
		this.random_code = random_code;
	}

	public int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getProfessional_id() {
		return professional_id;
	}

	public void setProfessional_id(String professional_id) {
		this.professional_id = professional_id;
	}

	public int getAuto_id() {
		return auto_id;
	}

	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public Date getDate_booked() {
		return date_booked;
	}

	public void setDate_booked(Date date_booked) {
		this.date_booked = date_booked;
	}

	public String getTime_from() {
		return time_from;
	}

	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}

	public String getTime_to() {
		return time_to;
	}

	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}

	public String getProfessional_name() {
		return professional_name;
	}

	public void setProfessional_name(String professional_name) {
		this.professional_name = professional_name;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public Boolean getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public String getRandom_code() {
		return random_code;
	}

	public void setRandom_code(String random_code) {
		this.random_code = random_code;
	}

	@Override
	public String toString() {
		return "BookingBean [schedule_id=" + schedule_id + ", professional_id=" + professional_id + ", auto_id="
				+ auto_id + ", client_id=" + client_id + ", date_booked=" + date_booked + ", time_from=" + time_from
				+ ", time_to=" + time_to + ", professional_name=" + professional_name + ", client_name=" + client_name
				+ ", isConfirmed=" + isConfirmed + ", random_code=" + random_code + "]";
	}
	
	
	
}
