package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailsDAO;
import com.internousdev.ecsite.dao.ReviewDAO;
import com.internousdev.ecsite.dto.ItemDetailsDTO;
import com.internousdev.ecsite.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailsAction extends ActionSupport implements SessionAware {

	private String id;
	private Map<String,Object> session;
	private List<ItemDetailsDTO> itemDetailsList;
	private List<ReviewDTO> reviewList;



	public String execute() {
		ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
		itemDetailsList = itemDetailsDAO.getItemDetails(id);

		ReviewDAO reviewDAO = new ReviewDAO();
		reviewList = reviewDAO.getReview(id);
		for (int j=0; j<reviewList.size(); j++) {
			StringBuilder sb = new StringBuilder("");
			for (int i=0; i<reviewList.get(j).getPoint(); i++) {
				sb.append("★");
			}
			reviewList.get(j).setStar(sb.toString());
		}

		return SUCCESS;


	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<ItemDetailsDTO> getItemDetailsList() {
		return itemDetailsList;
	}

	public void setItemDetailsList(List<ItemDetailsDTO> itemDetailsList) {
		this.itemDetailsList = itemDetailsList;
	}

	public List<ReviewDTO> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewDTO> reviewList) {
		this.reviewList = reviewList;
	}


}
