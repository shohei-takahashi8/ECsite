package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemHistoryDAO;
import com.internousdev.ecsite.dto.BuyItemHistoryDTO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemHistoryAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private ArrayList<BuyItemHistoryDTO> buyItemHistoryList;
	private String errorMsg2 = null;

	public String execute(){

		String result = SUCCESS;
		String userId = ((UserInfoDTO) session.get("loginUser")).getLoginId().toString();
		BuyItemHistoryDAO buyItemHistoryDAO = new BuyItemHistoryDAO();
		buyItemHistoryList = buyItemHistoryDAO.getItemHistory(userId);

		if(buyItemHistoryList.isEmpty()){
			errorMsg2 = "商品購入情報がありません。";
			result = ERROR;
		}


		return result;
	}


	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public ArrayList<BuyItemHistoryDTO> getBuyItemHistoryList(){
		return buyItemHistoryList;
	}

	public String getErrorMsg2(){
		return errorMsg2;
	}

	public void setErrorMsg2(String errorMsg2){
		this.errorMsg2 = errorMsg2;
	}
}
