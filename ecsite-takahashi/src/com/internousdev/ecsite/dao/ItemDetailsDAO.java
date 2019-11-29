package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemDetailsDTO;
import com.internousdev.ecsite.util.DBConnector;


public class ItemDetailsDAO {


	public List<ItemDetailsDTO> getItemDetails(String id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ItemDetailsDTO> itemDetailsList = new ArrayList<ItemDetailsDTO>();

		String sql = "SELECT product_name, product_name_kana, product_description, price, image_file_path, DATE_FORMAT(release_date, '%Y/%m/%d') AS release_date, release_company FROM product_info WHERE product_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				ItemDetailsDTO dto = new ItemDetailsDTO();
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setProductDesc(rs.getString("product_description"));
				dto.setPrice(rs.getString("price"));
				dto.setItemImage(rs.getString("image_file_path"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				itemDetailsList.add(dto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return itemDetailsList;
	}
}
