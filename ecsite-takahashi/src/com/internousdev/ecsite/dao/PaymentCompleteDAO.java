package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class PaymentCompleteDAO {

	public int buyItem(String userId, String productId, String itemCount,String price, int destinationId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int count = 0;

		String sql = "INSERT INTO purchase_history_info SET user_id=?, product_id=?, product_count=?,price=?, destination_id=?, regist_date=?, update_date=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, productId);
			ps.setString(3, itemCount);
			ps.setString(4, price);
			ps.setInt(5, destinationId);
			ps.setString(6, dateUtil.getDate());
			ps.setString(7, dateUtil.getDate());
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
