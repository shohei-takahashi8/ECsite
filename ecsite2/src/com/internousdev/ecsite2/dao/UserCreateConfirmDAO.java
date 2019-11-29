package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.internousdev.ecsite2.util.DBConnector;


public class UserCreateConfirmDAO {

	public Set<String> getUserId() throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		Set<String> set = new HashSet<String>();

		String sql = "select login_id from login_user_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				set.add(rs.getString("login_id"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return set;

	}

}
