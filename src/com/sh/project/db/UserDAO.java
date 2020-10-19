package com.sh.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sh.project.vo.UserVO;

public class UserDAO {
	
	public static int joinUser(UserVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO user (u_nm, u_id, u_pw) VALUES (?, ?, ?)";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getU_nm());
			ps.setString(2, param.getU_id());
			ps.setString(3, param.getU_pw());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			
		} finally {
			DbBridge.close(con, ps);
		}
		
		return result;
	}
	
	public static int doLogin(UserVO param) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM user WHERE u_id = ?";
		
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
	
	// 1 : id중복
	// 0 : 회원가입 성공
	public static int check(String id) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT u_id FROM user";
		
		try {
				con = DbBridge.getCon();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while (rs.next()) {
						if (rs.getString("u_id").equals(id)) {
								result = 1;
						}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return result;
	}
	
	// 아이디 찾기
	public static List<UserVO> findID(String nm) {
		List<UserVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT u_id FROM user WHERE u_nm = ?";
		
		try {
				con = DbBridge.getCon();
				ps = con.prepareStatement(sql);
				ps.setString(1, nm);
				
				rs = ps.executeQuery();
				
				while (rs.next()) {
					
					String u_id = rs.getString("u_id");
					
					UserVO vo = new UserVO();
					vo.setU_id(u_id);
					
					list.add(vo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return list;
	}
	
	// 비밀번호 찾기
		public static String findPW(String nm, String id) {
			String pw = "";
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String sql = "SELECT concat(substr(u_pw,1,3),\"..\") u_pw FROM user WHERE u_nm = ? AND u_id = ? ";
			
			try {
					con = DbBridge.getCon();
					ps = con.prepareStatement(sql);
					ps.setString(1, nm);
					ps.setString(2, id);
					
					rs = ps.executeQuery();
					
					if (rs.next()) {
						
						pw = rs.getString("u_pw");						

					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbBridge.close(con, ps, rs);
			}
			return pw;
		}
}