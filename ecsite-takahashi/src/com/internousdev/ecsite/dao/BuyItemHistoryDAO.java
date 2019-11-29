package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemHistoryDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemHistoryDAO {

	public ArrayList<BuyItemHistoryDTO> getItemHistory(String userId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<BuyItemHistoryDTO> buyItemHistoryList = new ArrayList<BuyItemHistoryDTO>();

		String sql = "SELECT pi.product_name, pi.product_name_kana, pi.image_file_path, pi.release_company, DATE_FORMAT(pi.release_date,'%Y/%m/%d') AS release_date, phi.id, phi.price, phi.product_count FROM product_info pi LEFT JOIN purchase_history_info phi ON pi.product_id=phi.product_id WHERE phi.user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				BuyItemHistoryDTO dto = new BuyItemHistoryDTO();
				int price = Integer.parseInt(rs.getString("price"));
				int count = Integer.parseInt(rs.getString("product_count"));
				String totalPrice = String.format("%,d", price * count);

				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("product_name"));
				dto.setItemNameKana(rs.getString("product_name_kana"));
				dto.setItemImage(rs.getString("image_file_path"));
				dto.setCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setPrice(rs.getString("price"));
				dto.setCount(rs.getString("product_count"));
				dto.setTotalPrice(totalPrice);
				buyItemHistoryList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return buyItemHistoryList;
	}

}
