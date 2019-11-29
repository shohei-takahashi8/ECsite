package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport {

	private String message;

	public String execute() throws SQLException{
		delete();
		return SUCCESS;
	}


	public void delete() throws SQLException {
		UserListDeleteCompleteDAO userListDeleteCompleteDAO = new UserListDeleteCompleteDAO();
		int ret = userListDeleteCompleteDAO.userListDelete();

		if(ret > 0){
			message = "ユーザー情報が正しく削除されました。";
		}else if(ret == 0){
			message = "ユーザー情報の削除に失敗しました。";
		}
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}


}
