package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String userType;
	private Map<String, Object> session;

	public String execute() throws SQLException {
		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(), session.get("loginPassword").toString(), session.get("userName").toString(), session.get("userType").toString());

		return SUCCESS;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
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

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
