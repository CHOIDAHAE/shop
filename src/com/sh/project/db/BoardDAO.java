package com.sh.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sh.project.vo.QBoardVO;
import com.sh.project.vo.RBoardVO;
import com.sh.project.vo.UserVO;

public class BoardDAO {
/*==============================insert=================================*/
	public static int insertQBoard(QBoardVO param) {
		int result = 0;

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO q_board "
					+ " (title, content, idx) "
					+ " VALUES "
					+ " (?, ?, ?) ";

		try {
				con = DbBridge.getCon();
				ps = con.prepareStatement(sql);
				ps.setString(1, param.getTitle());
				ps.setString(2, param.getContent());
				ps.setInt(3, param.getIdx());

				result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps);
		}
		return result;
	}
	
	public static int insertRBoard(RBoardVO param) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO r_board(title, content, idx) VALUES (?, ?, ?)";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getContent());
			ps.setInt(3, param.getIdx());
			
			result = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps);
		}
		
		return result;
		
		
	}
	
	/*============================update=================================*/
	
	
	public static int updateRBoardHits(RBoardVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE r_board SET hits = hits +1 WHERE i_board = ?";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_board());
			
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con,ps);
		}
		return result;
		
	}
	
	public static int updateQBoardHits(QBoardVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE q_board SET hits = hits +1 WHERE i_board = ?";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_board());
			
			result=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con,ps);
		}
		return result;
		
	}
	
	
	
	
	
	
	
	/*==============================read=================================*/
	public static List<RBoardVO> getRBoardList(RBoardVO param){
		List<RBoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.i_board, A.w_dt, A.title, A.content, A.hits, B.u_id FROM r_board A INNER JOIN user B ON A.idx = B.idx ";

		if(param.getSearch() != null) {
			sql += " WHERE content LIKE '%" + param.getSearch() + "%' ";
		}
		sql += " ORDER BY w_dt DESC LIMIT ?, ?";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getsIdx());
			ps.setInt(2, param.getRowCnt());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String content = rs.getString("content");
				String title = rs.getString("title");
				String w_dt = rs.getString("w_dt");
				String u_id = rs.getString("u_id");
				int hits = rs.getInt("hits");
				
				RBoardVO vo = new RBoardVO();
				vo.setI_board(i_board);
				vo.setContent(content);
				vo.setTitle(title);
				vo.setW_dt(w_dt);
				vo.setU_id(u_id);
				vo.setHits(hits);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		
		return list;
		
	}
	
	public static List<QBoardVO> getQBoardList(QBoardVO param){
		List<QBoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.i_board, A.w_dt, A.title, A.content, A.hits, B.u_id FROM q_board A INNER JOIN user B ON A.idx = B.idx";

		if(param.getSearch() != null) {
			sql += " WHERE content LIKE '%" + param.getSearch() + "%' ";
		}		
		sql += " ORDER BY w_dt DESC LIMIT ?, ?";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getsIdx());
			ps.setInt(2, param.getRowCnt());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String content = rs.getString("content");
				String title = rs.getString("title");
				String w_dt = rs.getString("w_dt");
				String u_id = rs.getString("u_id");
				int hits = rs.getInt("hits");
				
				QBoardVO vo = new QBoardVO();
				vo.setI_board(i_board);
				vo.setContent(content);
				vo.setTitle(title);
				vo.setW_dt(w_dt);
				vo.setU_id(u_id);
				vo.setHits(hits);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		
		return list;
		
	}
	
	public static RBoardVO getRBoard(int i_board) {
		RBoardVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT A.title, A.w_dt, A.m_dt, A.content, A.hits, A.idx, B.u_id FROM r_board A INNER JOIN user B ON A.idx = B.idx WHERE A.i_board = ? ORDER BY w_dt DESC";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, i_board);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String w_dt = rs.getString("w_dt");
				String m_dt = rs.getString("m_dt");
				String u_id = rs.getString("u_id");
				int hits = rs.getInt("hits");
				int idx = rs.getInt("idx");
				
				vo = new RBoardVO();
				vo.setI_board(i_board);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setW_dt(w_dt);
				vo.setM_dt(m_dt);
				vo.setU_id(u_id);
				vo.setHits(hits);
				vo.setIdx(idx);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return vo;
	}
	
	public static QBoardVO getQBoard(int i_board) {
		QBoardVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT A.title, A.w_dt, A.m_dt, A.content, A.hits, A.idx, B.u_id FROM q_board A INNER JOIN user B ON A.idx = B.idx WHERE A.i_board = ? ORDER BY w_dt DESC";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, i_board);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String w_dt = rs.getString("w_dt");
				String m_dt = rs.getString("m_dt");
				String u_id = rs.getString("u_id");
				int hits = rs.getInt("hits");
				int idx = rs.getInt("idx");
				
				
				vo = new QBoardVO();
				vo.setI_board(i_board);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setW_dt(w_dt);
				vo.setM_dt(m_dt);
				vo.setU_id(u_id);
				vo.setHits(hits);
				vo.setIdx(idx);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return vo;
	}
	
	public static int getTotalPageCnt(int cnt) {
		int totalPageCnt = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT CEIL(COUNT(i_board) / 10) AS cnt FROM q_board";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				totalPageCnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		
		return totalPageCnt;
		
	}
	
	public static int getTotalRPageCnt(int cnt) {
		int totalPageCnt = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT CEIL(COUNT(i_board) / 10) AS cnt FROM r_board";

		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			if(rs.next()) {
				totalPageCnt = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}

		return totalPageCnt;

	}
	
	public static UserVO mypageinfo(int idx) {
		UserVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT u_nm, u_id FROM user WHERE idx = ? ";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String u_nm = rs.getString("u_nm");
				String u_id = rs.getString("u_id");
				
				vo = new UserVO();
				vo.setU_nm(u_nm);
				vo.setU_id(u_id);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return vo;
	}
	
	public static List<QBoardVO> mypageQ(QBoardVO param) {
		List<QBoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT title, content, w_dt FROM q_board WHERE idx = ? ";
		sql += " ORDER BY w_dt DESC LIMIT ?, ? ";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIdx());
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getRowCnt());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String w_dt = rs.getString("w_dt");
				
				QBoardVO vo = new QBoardVO();
				vo.setTitle(title);
				vo.setContent(content);
				vo.setW_dt(w_dt);
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return list;
	}
	
	public static List<RBoardVO> mypageR(RBoardVO param) {
		List<RBoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT title, content, w_dt FROM r_board WHERE idx = ? ";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIdx());
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getRowCnt());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String w_dt = rs.getString("w_dt");
				
				RBoardVO vo = new RBoardVO();
				vo.setTitle(title);
				vo.setContent(content);
				vo.setW_dt(w_dt);
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return list;
	}
	
	public static int getQTotalPage(QBoardVO param) {
		int totalPageCnt = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT CEIL(COUNT(i_board) / ?) AS cnt FROM q_board ";

		try {
				con = DbBridge.getCon();
				ps = con.prepareStatement(sql);
				ps.setInt(1, param.getRowCnt());
				rs = ps.executeQuery();

				if(rs.next()) {
						totalPageCnt = rs.getInt("cnt");
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}

		return totalPageCnt;
}
	
	
	/*==============================delete=================================*/
	
	public static int delQBoard(QBoardVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM q_board WHERE i_board = ? AND idx = ?";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_board());
			ps.setInt(2, param.getIdx());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps);
		}
		
		return result;
	}
	
	public static int delRBoard(RBoardVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM r_board WHERE i_board = ? AND idx = ?";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_board());
			ps.setInt(2, param.getIdx());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}