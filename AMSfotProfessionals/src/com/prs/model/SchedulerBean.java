/**
 * 
 */
package com.prs.model;

import java.sql.Date;
import java.sql.Time;


/**
 * @author Isura
 *	Scheduler App Beans Class
 */
public class SchedulerBean {
	private int id;
	private String user_id;
	private Date date_available;
	private int day;
	private int month;
	private int year;
	private String time_from;
	private String time_to;
	private int just_call_me;
	private int seats;
	
	
	//Constructor
	public SchedulerBean(){}

/*
	public SchedulerBean(int id, String user_id, Date date_available, int day, int month, int year, String time_from,
			String time_to, int just_call_me, int seats) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.date_available = date_available;
		this.day = day;
		this.month = month;
		this.year = year;
		this.time_from = time_from;
		this.time_to = time_to;
		this.just_call_me = just_call_me;
		this.seats = seats;
	}
*/

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public Date getDate_available() {
		return date_available;
	}


	public void setDate_available(Date date_available) {
		this.date_available = date_available;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
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


	public int getJust_call_me() {
		return just_call_me;
	}


	public void setJust_call_me(int just_call_me) {
		this.just_call_me = just_call_me;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	@Override
	public String toString() {
		return "SchedulerBean [id=" + id + ", user_id=" + user_id + ", date_available=" + date_available + ", day="
				+ day + ", month=" + month + ", year=" + year + ", time_from=" + time_from + ", time_to=" + time_to
				+ ", just_call_me=" + just_call_me + ", seats=" + seats + "]";
	}

	
}
