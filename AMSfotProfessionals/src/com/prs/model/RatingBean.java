package com.prs.model;

public class RatingBean {

	private int auto_id;
	private String professionals_id,buyer_id, buyer_name;
	private int rate;
	private String review;
	
	public RatingBean(){}

	public RatingBean(int auto_id, String professionals_id, String buyer_id, String buyer_name, int rate, String review) {
		super();
		this.auto_id = auto_id;
		this.professionals_id = professionals_id;
		this.buyer_id = buyer_id;
		this.buyer_name = buyer_name;
		this.rate = rate;
		this.review = review;
	}

	

	public int getAuto_id() {
		return auto_id;
	}

	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}

	public String getProfessionals_id() {
		return professionals_id;
	}

	public void setProfessionals_id(String professionals_id) {
		this.professionals_id = professionals_id;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	/**
	 * LoginBean firstname + Lastname = buyer_name
	 */
	public String getBuyer_name() {
		return buyer_name;
	}
	
	/**
	 * LoginBean firstname + Lastname = buyer_name
	 * @param buyer_name
	 */
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "RatingBean [auto_id=" + auto_id + ", professionals_id=" + professionals_id + ", buyer_id=" + buyer_id
				+ ", rate=" + rate + ", review=" + review + "]";
	}
	
	
	
}
