package com.sh.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sh.project.vo.ProductVO;
import com.sh.project.vo.UserVO;

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

	/*==========================adminlogin===================================*/
	
	public static int doadminLogin(UserVO param) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM user WHERE u_id = ? AND idx = 0";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getU_id());
			rs = ps.executeQuery();
			
			if (rs.next()) {
					String pw = rs.getString("u_pw");
					if (pw.equals(param.getU_pw())) {
						result = 1;  // 로그인 성공
						
						String u_nm = rs.getString("u_nm");
						int idx = rs.getInt("idx");
						
						param.setU_pw(null);
						param.setU_nm(u_nm);
						param.setIdx(idx);
						
					} else {
						result = 3;  // 비밀번호 틀림
					}
			 } else {
				 result = 2; // 아이디 없음
			 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return result;
	}
}
