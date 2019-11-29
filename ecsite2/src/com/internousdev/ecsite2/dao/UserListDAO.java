package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.UserListDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class UserListDAO {

	public ArrayList<UserListDTO> getUserListInfo() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();

		String sql = "SELECT * FROM login_user_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				UserListDTO dto = new UserListDTO();
				dto.setId(rs.getInt("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("updated_date"));
				dto.setUserType(rs.getString("admin_flg"));
				userListDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return userListDTO;
	}

}
