package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dao.ItemListDAO;
import com.internousdev.ecsite2.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport {

	private ArrayList<ItemListDTO> itemList;

	public String execute() throws SQLException{
		ItemListDAO itemListDAO = new ItemListDAO();
		itemList = itemListDAO.getItemListInfo();

		return SUCCESS;
	}


	public ArrayList<ItemListDTO> getItemList(){
		return this.itemList;
	}
}
