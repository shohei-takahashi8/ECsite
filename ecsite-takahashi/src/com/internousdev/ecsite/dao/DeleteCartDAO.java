package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;


public class DeleteCartDAO {

	public int deleteCart(String id, String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "DELETE FROM cart_info WHERE id=? AND user_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, userId);
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
