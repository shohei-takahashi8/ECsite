package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ReviewDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;


public class ReviewDAO {

	public int insertReview(String userId, String productId, int point, String title, String review) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int count = 0;

		String sql = "INSERT INTO review_info(user_id, product_id, point, title, review, regist_date) VALUES(?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, productId);
			ps.setInt(3, point);
			ps.setString(4, title);
			ps.setString(5,review);
			ps.setString(6, dateUtil.getDate());

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


	public List<ReviewDTO> getReview(String productId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();

		String sql = "SELECT user_id, point, title, review, DATE_FORMAT(regist_date, '%Y/%m/%d') AS regist_date FROM review_info WHERE product_id=? ORDER BY RAND() LIMIT 3";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, productId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setUserId(rs.getString("user_id"));
				dto.setPoint(rs.getInt("point"));
				dto.setTitle(rs.getString("title"));
				dto.setReview(rs.getString("review"));
				dto.setRegistDate(rs.getString("regist_date"));
				reviewList.add(dto);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return reviewList;
	}


}
