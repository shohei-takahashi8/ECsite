package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class UserDetailsDAO {

	public ArrayList<UserInfoDTO> getUserDetailsInfo(String id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();

		String sql = "SELECT * FROM login_user_transaction WHERE id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				UserInfoDTO dto = new UserInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdated_date(rs.getString("updated_date"));
				dto.setAdmin_flg(rs.getString("admin_flg"));
				userInfoDTO.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return userInfoDTO;
	}
}
