package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ChangePassDAO {

	//入力されたパスワードがDBに登録されているものと同じか確認
	public String checkPass(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String password = null;

		String sql = "SELECT password FROM user_info WHERE user_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				password = rs.getString("password");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return password;
	}

	//パスワード変更
	public int changePass(String loginId, String newPass) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "UPDATE user_info SET password=? WHERE user_id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPass);
			ps.setString(2, loginId);
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
