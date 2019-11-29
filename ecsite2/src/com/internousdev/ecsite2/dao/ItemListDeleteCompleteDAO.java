package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	public int itemListDelete() throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int ret = 0;

		String sql = "DELETE FROM item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ret = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return ret;

	}

}
