package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.UserDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteCompleteAction extends ActionSupport {

	private String id;

	public String execute() throws SQLException {
		UserDeleteCompleteDAO userDeleteCompleteDAO = new UserDeleteCompleteDAO();
		userDeleteCompleteDAO.userDelete(id);

		return SUCCESS;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

}
