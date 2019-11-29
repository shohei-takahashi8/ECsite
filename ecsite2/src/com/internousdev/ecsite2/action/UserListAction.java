package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dao.UserListDAO;
import com.internousdev.ecsite2.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport {

	private ArrayList<UserListDTO> userList;

	public String execute() throws SQLException{

		UserListDAO userListDAO = new UserListDAO();
		userList = userListDAO.getUserListInfo();

		return SUCCESS;
	}


	public ArrayList<UserListDTO> getUserList(){
		return userList;
	}
}
