package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class CreateUserCompleteDAO {

	public int createUser(String userId, String password, String familyName, String firstName, String familyNameKana, String firstNameKana, String gender, String email) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int count = 0;

		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, regist_date, update_date) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setString(7, gender);
			ps.setString(8, email);
			ps.setString(9, dateUtil.getDate());
			ps.setString(10, dateUtil.getDate());

			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return count;
	}

}
