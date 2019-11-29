package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dao.UserDetailsDAO;
import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport {

	private String id;
	private ArrayList<UserInfoDTO> userInfo;

	public String execute() throws SQLException{

		UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
		userInfo = userDetailsDAO.getUserDetailsInfo(id);

		return SUCCESS;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public ArrayList<UserInfoDTO> getUserInfo(){
		return userInfo;
	}
}
