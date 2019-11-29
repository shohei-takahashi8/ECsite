package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CreateUserCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute() throws SQLException{
		String result = ERROR;
		int count = 0;

		CreateUserCompleteDAO createUserCompleteDAO = new CreateUserCompleteDAO();
		count = createUserCompleteDAO.createUser(session.get("userId").toString(), session.get("password").toString(), session.get("familyName").toString(), session.get("firstName").toString(), session.get("familyNameKana").toString(), session.get("firstNameKana").toString(), session.get("gender").toString(), session.get("email").toString());

		if(count > 0){
			result = SUCCESS;;
		}

		return result;

	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
