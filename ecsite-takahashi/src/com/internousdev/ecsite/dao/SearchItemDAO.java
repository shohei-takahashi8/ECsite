package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.SearchItemDTO;
import com.internousdev.ecsite.util.DBConnector;


public class SearchItemDAO {

	private List<SearchItemDTO> searchItemList = new ArrayList<SearchItemDTO>();

	public List<SearchItemDTO> searchItem(String[] searchItem) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT product_id, product_name, price, image_file_path FROM product_info";

		if (!searchItem[0].equals("")) {
			for (int i=0; i<searchItem.length; i++) {
				if (i==0) {
					sql += " WHERE product_name LIKE '%" + searchItem[i] + "%'";
				} else {
					sql += " and product_name LIKE '%" + searchItem[i] + "%'";
				}
			}
		}


		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				SearchItemDTO dto = new SearchItemDTO();

				dto.setId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setPrice(rs.getString("price"));
				dto.setItemImage(rs.getString("image_file_path"));

				searchItemList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return searchItemList;
	}
}
