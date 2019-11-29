package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class CreateDestinationCompleteDAO {

	public int createDestination(String userId, String familyName, String firstName, String familyNameKana, String firstNameKana, String address, String telNumber, String email) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int count = 0;

		String sql = "INSERT INTO destination_info(user_id, family_name, first_name, family_name_kana, first_name_kana, email, tel_number, user_address, regist_date, update_date) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, familyName);
			ps.setString(3, firstName);
			ps.setString(4, familyNameKana);
			ps.setString(5, firstNameKana);
			ps.setString(6, email);
			ps.setString(7, telNumber);
			ps.setString(8, address);
			ps.setString(9, dateUtil.getDate());
			ps.setString(10, dateUtil.getDate());

			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		finally {
			con.close();
		}

		return count;
	}

}
