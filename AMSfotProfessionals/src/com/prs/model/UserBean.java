package com.prs.model;

import java.sql.Date;

public class UserBean {
	
	private int auto_id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Date birthday;
	private int gender;
	private int usertype;
	private String user_id;
	private String reset_key;
	
	public UserBean(int auto_id, String firstname, String lastname, String email, String password, Date birthday,
			int gender, int usertype, String user_id, String reset_key) {
		super();
		this.auto_id = auto_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.usertype = usertype;
		this.user_id = user_id;
		this.reset_key = reset_key;
	}

	public UserBean() {
	}

	public int getAuto_id() {
		return auto_id;
	}

	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReset_key() {
		return reset_key;
	}

	public void setReset_key(String reset_key) {
		this.reset_key = reset_key;
	}

	@Override
	public String toString() {
		return "UserBean [auto_id=" + auto_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", password=" + password + ", birthday=" + birthday + ", gender=" + gender + ", usertype="
				+ usertype + ", user_id=" + user_id + ", reset_key=" + reset_key + "]";
	}
	
	
}
