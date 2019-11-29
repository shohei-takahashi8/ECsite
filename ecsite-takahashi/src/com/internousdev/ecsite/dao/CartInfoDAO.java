package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.CartInfoDTO;
import com.internousdev.ecsite.util.DBConnector;


public class CartInfoDAO {


	public List<CartInfoDTO> getCartInfo(String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<CartInfoDTO> cartInfoList = new ArrayList<CartInfoDTO>();

		String sql = "SELECT pi.product_id, pi.product_name, pi.product_name_kana, pi.image_file_path, pi.price, pi.release_company, DATE_FORMAT(pi.release_date, '%Y/%m/%d') AS release_date, ci.product_count, ci.id FROM cart_info ci LEFT JOIN product_info pi ON pi.product_id = ci.product_id WHERE ci.user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO dto = new CartInfoDTO();
				int price = Integer.parseInt(rs.getString("price"));
				int itemCount = Integer.parseInt(rs.getString("product_count"));
				int totalPrice = price * itemCount;

				dto.setId(rs.getInt("id"));
				dto.setProductId(rs.getString("product_id"));
				dto.setItemName(rs.getString("product_name"));
				dto.setItemNameKana(rs.getString("product_name_kana"));
				dto.setItemImage(rs.getString("image_file_path"));
				dto.setPrice(rs.getString("price"));
				dto.setCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setItemCount(rs.getString("product_count"));
				dto.setTotalPrice(totalPrice);
				cartInfoList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return cartInfoList;
	}


	public int deleteCartInfo(String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "DELETE FROM cart_info WHERE user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userId);

			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return count;




	}

}
