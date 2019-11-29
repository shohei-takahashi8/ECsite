package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class BuyItemCompleteDAO {

	public void buyItemInfo(String item_transaction_id, String total_price, String total_count, String user_master_id, String pay) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();

		String sql = "INSERT INTO user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date) VALUES(?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());
			ps.execute();

		}catch(Exception e){
			e.printStackTrace();
		}finally {
			con.close();
		}
	}

	public void updateStock(String total_count) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int newStock = countStock(total_count);

		String sql = "UPDATE item_info_transaction SET item_stock=? WHERE item_name='NoteBook'";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newStock);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

	public int countStock(String total_count){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int newStock = 0;

		String sql = "SELECT item_stock FROM item_info_transaction WHERE item_name='NoteBook'";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
			int currentStock = Integer.parseInt(rs.getString("item_stock"));
			int totalCount = Integer.parseInt(total_count);
			newStock = currentStock - totalCount;
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return newStock;

	}


}




