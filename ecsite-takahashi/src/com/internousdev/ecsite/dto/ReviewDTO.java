package com.internousdev.ecsite.dto;

public class ReviewDTO {

	private String userId;
	private int point;
	private String title;
	private String review;
	private String registDate;
	private String star;



	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}








}
