package com.internousdev.ecsite2.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteConfirmAction extends ActionSupport {

	private String id;
	private String currentLoginId;

	public String execute(){
		currentLoginId = getLoginId(id);
		return SUCCESS;
	}


	//ログインID取得メソッド
	public String getLoginId(String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String loginId = null;
		String sql = "SELECT login_id FROM login_user_transaction WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				loginId = rs.getString("login_id");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return loginId;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getCurrentLoginId(){
		return currentLoginId;
	}

	public void setCurrentLoginId(String currentLoginId){
		this.currentLoginId = currentLoginId;
	}


}
