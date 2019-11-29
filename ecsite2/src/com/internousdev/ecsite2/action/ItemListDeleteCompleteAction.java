package com.internousdev.ecsite2.action;

import java.sql.SQLException;

import com.internousdev.ecsite2.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport {

	private String message;


	public String execute() throws SQLException{
		delete();
		return SUCCESS;
	}


	public void delete() throws SQLException {
		ItemListDeleteCompleteDAO itemListDeleteCompleteDAO = new ItemListDeleteCompleteDAO();
		int ret = itemListDeleteCompleteDAO.itemListDelete();

		if(ret > 0) {
			setMessage("商品情報を正しく削除しました。");
		}else if(ret == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}


	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}




}
