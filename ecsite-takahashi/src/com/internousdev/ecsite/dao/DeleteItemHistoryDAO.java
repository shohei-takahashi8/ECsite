package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class DeleteItemHistoryDAO {

	public int deleteItemHistory(String id){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count= 0;


		String sql = "DELETE FROM purchase_history_info WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return count;
	}
}
