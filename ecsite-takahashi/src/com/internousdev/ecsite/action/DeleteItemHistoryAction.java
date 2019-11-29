package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemHistoryDAO;
import com.internousdev.ecsite.dao.DeleteItemHistoryDAO;
import com.internousdev.ecsite.dto.BuyItemHistoryDTO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteItemHistoryAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private String[] deleteList;
	private ArrayList<BuyItemHistoryDTO> buyItemHistoryList;
	private String errorMsg = null;
	private String errorMsg2 = null;

	public String execute(){

		String result = ERROR;
		int count = 0;

		DeleteItemHistoryDAO deleteItemHistoryDAO = new DeleteItemHistoryDAO();
		BuyItemHistoryDAO buyItemHistoryDAO = new BuyItemHistoryDAO();
		if(deleteList != null){
			for(String id:deleteList){
				count += deleteItemHistoryDAO.deleteItemHistory(id);
			}

			if(count > 0){
				String userId = ((UserInfoDTO) session.get("loginUser")).getLoginId().toString();
				buyItemHistoryList = buyItemHistoryDAO.getItemHistory(userId);
				result = SUCCESS;
			}
		}else{
			errorMsg = "削除したい項目にチェックをいれてください。";
			String userId = ((UserInfoDTO) session.get("loginUser")).getLoginId().toString();
			buyItemHistoryList = buyItemHistoryDAO.getItemHistory(userId);
		}

		//buyItemHistoryListのチェック
		if(buyItemHistoryList.isEmpty()){
			errorMsg2 = "商品購入情報がありません。";
		}

		return result;
	}



	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String[] getDeleteList(){
		return deleteList;
	}

	public void setDeleteList(String[] deleteList){
		this.deleteList = deleteList;
	}

	public ArrayList<BuyItemHistoryDTO> getBuyItemHistoryList(){
		return buyItemHistoryList;
	}

	public String getErrorMsg(){
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg){
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg2(){
		return errorMsg2;
	}

	public void setErrorMsg2(String errorMsg2){
		this.errorMsg2 = errorMsg2;
	}


}
