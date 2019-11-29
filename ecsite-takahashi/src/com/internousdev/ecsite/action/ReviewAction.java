package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailsDAO;
import com.internousdev.ecsite.dao.ReviewDAO;
import com.internousdev.ecsite.dto.ItemDetailsDTO;
import com.internousdev.ecsite.dto.ReviewDTO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewAction extends ActionSupport implements SessionAware {

	private String productId;
	private int point;
	private String title;
	private String review;
	private List<String> errorMessageList = new ArrayList<String>();
	private List<ItemDetailsDTO> itemDetailsList;
	private List<ReviewDTO> reviewList;
	private Map<String,Object> session;

	public String execute() {
		String result = ERROR;
		int count = 0;
		String userId = ((UserInfoDTO) session.get("loginUser")).getLoginId().toString();

		if(title.isEmpty()) {
			errorMessageList.add("タイトルを入力してください。");
		}
		if(review.isEmpty()) {
			errorMessageList.add("レビュー内容を入力してください。");
		}

		ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
		ReviewDAO reviewDAO = new ReviewDAO();

		if(!errorMessageList.isEmpty()) {
			itemDetailsList = itemDetailsDAO.getItemDetails(productId);
			reviewList = reviewDAO.getReview(productId);
			return result;
		}

		count = reviewDAO.insertReview(userId, productId, point, title, review);
		if(count > 0) {
			itemDetailsList = itemDetailsDAO.getItemDetails(productId);
			result = SUCCESS;
		}

		return result;
	}


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public List<ItemDetailsDTO> getItemDetailsList() {
		return itemDetailsList;
	}

	public List<ReviewDTO> getReviewList() {
		return reviewList;
	}

	public void setItemDetailsList(List<ItemDetailsDTO> itemDetailsList) {
		this.itemDetailsList = itemDetailsList;
	}

	public List<String> getErrorMessageList() {
		return errorMessageList;
	}

	public void setErrorMessageList(List<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
