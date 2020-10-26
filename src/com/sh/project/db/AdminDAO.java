package com.sh.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sh.project.vo.ProductVO;

public class AdminDAO {
	
/*==========================insert===================================*/
	
	public static int updateProduct(ProductVO param) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO product(seq, p_nm, price, info, category, p_img) select ifnull(max(seq), 0) + 1, ?, ?, ?, ?, ? from product where category = ?";
		
		try {
			con = DbBridge.getCon();
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, param.getP_nm());
			ps.setInt(2, param.getPrice());
			ps.setString(3, param.getInfo());
			ps.setInt(4, param.getCategory());
			ps.setString(5, param.getP_img());
			ps.setInt(6, param.getCategory());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps);
		}
		return result;
	}
}
