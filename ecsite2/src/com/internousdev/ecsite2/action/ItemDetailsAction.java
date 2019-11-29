package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Map;

import com.internousdev.ecsite2.dao.ItemDetailsDAO;
import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailsAction extends ActionSupport {

	private String id;
	ArrayList<ItemInfoDTO> itemInfo;

	public String execute() throws SQLException{
		ItemDetailsDAO itemDetailsDAO = new ItemDetailsDAO();
		itemInfo = itemDetailsDAO.getItemDetailInfo(id);
		return SUCCESS;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public ArrayList<ItemInfoDTO> getItemInfo(){
		return itemInfo;
	}

}
