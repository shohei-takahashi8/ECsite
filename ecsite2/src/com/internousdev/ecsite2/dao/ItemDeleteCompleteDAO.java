package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class ItemDeleteCompleteDAO {

	public void itemDelete(String id) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM item_info_transaction WHERE id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
