package com.sh.project.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.project.Utils;
import com.sh.project.db.AdminDAO;
import com.sh.project.vo.ProductVO;

@WebServlet("/updateproduct")
public class UpdateProductSev extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/updateproduct.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p_nm = request.getParameter("p_nm");
		String category = request.getParameter("category");
		int intcategory = Utils.parseStringToInt(category, 0);
		String price = request.getParameter("price");
		int intprice = Utils.parseStringToInt(price, 0);
		String info = request.getParameter("info");
		
		
		if (p_nm.length() == 0 || info.length() == 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('상품명 또는 상세정보를 입력해주세요')");
			script.println("history.back(-1)");
			script.println("</script>");
		} else {
		
		ProductVO vo = new ProductVO();
		vo.setP_nm(p_nm);
		vo.setCategory(intcategory);
		vo.setPrice(intprice);
		vo.setInfo(info);
		
		AdminDAO.updateProduct(vo);
		
		response.sendRedirect("/main");
		}
		
		
	}

}
