package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;


public class AddCartDAO {

	//重複した商品がなければ挿入
	public int addCart(String userId, String productId, String productCount) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int count = 0;

		String sql = "INSERT INTO cart_info(user_id, product_id, product_count, regist_date, update_date) VALUES(?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, productId);
			ps.setString(3, productCount);
			ps.setString(4, dateUtil.getDate());
			ps.setString(5, dateUtil.getDate());
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return count;
	}

	//重複した商品があれば更新
	public int updateProductCount(String userId, String productId, String productCount){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "UPDATE cart_info SET product_count=(product_count + ?), update_date = now() WHERE user_id=? AND product_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,productCount);
			ps.setString(2,userId);
			ps.setString(3,productId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	//DB内に重複あるかチェック
	public boolean isExistsCartInfo(String userId, String productId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;

		String sql = "SELECT COUNT(id) as COUNT FROM cart_info WHERE user_id=? AND product_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, productId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				if(rs.getInt("COUNT") > 0) {
					result = true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return result;
	}

}
