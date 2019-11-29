package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserInfoDAO {

	public UserInfoDTO select(String loginId, String password) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info WHERE user_id=? AND password=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				userInfoDTO.setLoginId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setGender(rs.getString("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return userInfoDTO;
	}


	public int checkDuplicate(String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "SELECT * FROM user_info WHERE user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = 1;
			}

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
