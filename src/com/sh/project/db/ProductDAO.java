package com.sh.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sh.project.vo.ProductVO;

public class ProductDAO {
	public static ProductVO getProductDetail(int num, int cate) {
		ProductVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM  product WHERE seq = ? and category = ?";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, cate);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int seq = rs.getInt("seq");
				String p_nm = rs.getString("p_nm");
				int price = rs.getInt("price");
				String info = rs.getString("info");
				int category = rs.getInt("category");
				String p_img = rs.getString("p_img");
				
				vo = new ProductVO();
				vo.setSeq(seq);
				vo.setP_nm(p_nm);
				vo.setPrice(price);
				vo.setInfo(info);
				vo.setCategory(category);
				vo.setP_img(p_img);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return vo;
	}
	
	public static List<ProductVO> getProductList(int cate){
		List<ProductVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * from product WHERE category = ?";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cate);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int idx = rs.getInt("idx");
				int seq = rs.getInt("seq");
				String p_nm = rs.getString("p_nm");
				int price = rs.getInt("price");
				String info = rs.getString("info");
				int category = rs.getInt("category");
				String p_img = rs.getString("p_img");
				
				ProductVO vo = new ProductVO();
				vo.setIdx(idx);
				vo.setSeq(seq);
				vo.setP_nm(p_nm);
				vo.setPrice(price);
				vo.setInfo(info);
				vo.setCategory(category);
				vo.setP_img(p_img);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
