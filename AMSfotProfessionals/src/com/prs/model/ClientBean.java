/**
 * 
 */
package com.prs.model;

/**
 * @author Isura
 *
 */
public class ClientBean {
	
	private int auto_id;
	private String user_id;
	private String phone;
	private String address;
	
	public ClientBean(int auto_id, String user_id, String phone, String address) {
		super();
		this.auto_id = auto_id;
		this.user_id = user_id;
		this.phone = phone;
		this.address = address;
	}

	public ClientBean() {
		// TODO Auto-generated constructor stub
	}

	public int getauto_id() {
		return auto_id;
	}

	public void setauto_id(int auto_id) {
		this.auto_id = auto_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ClientBean [auto_id=" + auto_id + ", user_id=" + user_id + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	
	
	
}
