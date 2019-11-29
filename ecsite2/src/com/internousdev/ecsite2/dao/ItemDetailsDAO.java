package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.ItemInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class ItemDetailsDAO {

	public ArrayList<ItemInfoDTO> getItemDetailInfo(String id) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ItemInfoDTO> itemInfoDTO = new ArrayList<ItemInfoDTO>();

		String sql = "SELECT * FROM item_info_transaction WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				ItemInfoDTO dto = new ItemInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
				itemInfoDTO.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return itemInfoDTO;
	}

}
