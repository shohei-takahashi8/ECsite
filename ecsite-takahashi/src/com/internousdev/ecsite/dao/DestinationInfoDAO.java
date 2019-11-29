package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.DestinationInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class DestinationInfoDAO {

	public List<DestinationInfoDTO> getDestinationInfo(String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<DestinationInfoDTO> destinationInfoList = new ArrayList<DestinationInfoDTO>();

		String sql = "SELECT * FROM destination_info WHERE user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				DestinationInfoDTO dto = new DestinationInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setEmail(rs.getString("email"));
				dto.setTelNumber(rs.getString("tel_number"));
				dto.setAddress(rs.getString("user_address"));
				destinationInfoList.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return destinationInfoList;
	}


}
