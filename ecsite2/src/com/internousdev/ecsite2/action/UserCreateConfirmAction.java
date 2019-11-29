package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String userType;
	private Map<String, Object> session;
	private String errorMessage;

	public String execute() throws SQLException{
		String result = SUCCESS;

		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))
				&& !(userType.equals(""))) {
				session.put("loginUserId", loginUserId);
				session.put("loginPassword", loginPassword);
				session.put("userName", userName);
				session.put("userType", userType);
			}else {
				setErrorMessage("未入力の項目があります。");
				result = ERROR;
			}

		UserCreateConfirmDAO userCreateConfirmDAO = new UserCreateConfirmDAO();
		Set<String> set = new HashSet<String>();
		set = userCreateConfirmDAO.getUserId();
		for(String s:set){
			if(s.equals(loginUserId)){
				result = ERROR;
				setErrorMessage("すでに登録されているログインIDです。");
			}
		}


		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserType(){
		return userType;
	}

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}




