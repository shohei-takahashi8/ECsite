package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.ItemDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteCompleteAction extends ActionSupport {

	private String id;
	public String execute() throws SQLException{

		ItemDeleteCompleteDAO itemDeleteCompleteDAO = new ItemDeleteCompleteDAO();
		itemDeleteCompleteDAO.itemDelete(id);
		return SUCCESS;

	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

}
