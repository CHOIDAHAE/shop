package com.sh.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sh.project.vo.CartVO;
import com.sh.project.vo.OrderVO;
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
	
	public static List<ProductVO> getNewProductList(){
		List<ProductVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM product order by idx desc limit 12";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
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
	
	//------------------------------------------------- Cart (insert)
	public static int insertCart(CartVO param) {
			int result = 0;

			Connection con = null;
			PreparedStatement ps = null;

			String sql = " INSERT INTO cart (idx, name, num, price, total) VALUES (?, ?, ?, ?, ?) ";

			try {
					con = DbBridge.getCon();
					ps = con.prepareStatement(sql);
					ps.setInt(1, param.getIdx());
					ps.setString(2, param.getName());
					ps.setInt(3, param.getNum());
					ps.setInt(4, param.getPrice());
					ps.setInt(5, param.getTotal());

					result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DbBridge.close(con, ps);
			}
			return result;
	}
	
	public static List<CartVO> getCartList(int idx) {
		List<CartVO> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT * FROM cart  WHERE idx = ?";

		try {
				con = DbBridge.getCon();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()) {
					int c_board = rs.getInt("c_board");
					String name = rs.getString("name");
					int num = rs.getInt("num");
					int price = rs.getInt("price");
					int total = rs.getInt("total");

					CartVO vo = new CartVO();
					vo.setC_board(c_board);
					vo.setName(name);
					vo.setNum(num);
					vo.setPrice(price);
					vo.setTotal(total);

					list.add(vo);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return list;
}
	
	
//=================================Order(insert)=========
	
	public static int insertOrder(OrderVO param) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO uorder (idx, price, num, total, name) VALUES (?, ?, ?, ?, ?)";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIdx());
			ps.setInt(2, param.getPrice());
			ps.setInt(3, param.getNum());
			ps.setInt(4, param.getTotal());
			ps.setString(5, param.getName());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps);
		} 
		return result;
	}
	
	public static List<OrderVO> getOrderProduct(int uidx){
		List<OrderVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM uorder WHERE idx = ?";
		
		try {
			con = DbBridge.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ps.setInt(1, uidx);
			
			while(rs.next()) {
				int order_idx = rs.getInt("order_idx");
				int idx = rs.getInt("idx");
				int price = rs.getInt("price");
				int num = rs.getInt("num");
				int total = rs.getInt("total");
				String name = rs.getString("name");
				
				OrderVO vo = new OrderVO();
				vo.setOrder_idx(order_idx);
				vo.setIdx(idx);
				vo.setPrice(price);
				vo.setNum(num);
				vo.setTotal(total);
				vo.setName(name);
				
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps, rs);
		}
		return list;
	}
	
	
	//------------------------------------------------- Delete (삭제)

	public static int delCartList(CartVO param) {
		int result = 0;

		Connection con = null;
		PreparedStatement ps = null;

		String sql = " DELETE FROM cart WHERE c_board = ? ";

		try {
				con = DbBridge.getCon();
				ps = con.prepareStatement(sql);
				ps.setInt(1, param.getC_board());

				result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbBridge.close(con, ps);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}