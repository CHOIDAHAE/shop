package com.sh.project.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.project.Utils;
import com.sh.project.db.ProductDAO;
import com.sh.project.vo.ProductVO;

@WebServlet("/productdetail")
public class ProductDetailSev extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		int int_Seq = Utils.parseStringToInt(seq, 0);
		String category = request.getParameter("category");
		int int_Category = Utils.parseStringToInt(category, 0);
		
		System.out.println(int_Seq);
		System.out.println(int_Category);
		
		ProductVO param = new ProductVO();
		param.setSeq(int_Seq);
		param.setCategory(int_Category);
		
		request.setAttribute("detail", ProductDAO.getProductDetail(int_Seq, int_Category));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/product/productdetail.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
