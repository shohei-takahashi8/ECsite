package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class BuyItemStockConfirmDAO {

	public int confirmStock(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int currentStock = 0;

		String sql = "SELECT item_stock FROM item_info_transaction WHERE item_name='ノートBook'";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				currentStock = rs.getInt("item_stock");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return currentStock;
	}

}
