package com.sh.project.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.project.Utils;
import com.sh.project.db.ProductDAO;
import com.sh.project.vo.CartVO;
import com.sh.project.vo.UserVO;


@WebServlet("/cart")
public class CartSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에 값세팅
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser == null) {
				response.sendRedirect("/login");
				return;
		}
		String num = request.getParameter("num");
		int int_num = Utils.parseStringToInt(num, 0);
		String price = request.getParameter("price");
		int int_price = Utils.parseStringToInt(price, 0);
		String total = request.getParameter("total");
		int int_total = Utils.parseStringToInt(total, 0);
		int idx = loginUser.getIdx();
		String name = request.getParameter("name");
		
		System.out.println(int_num);
		System.out.println(int_price);
		System.out.println(int_total);
		System.out.println(name);

		if (int_num != 0 && int_price != 0 && int_total != 0) {
			CartVO param = new CartVO();
			param.setNum(int_num);
			param.setName(name);
			param.setPrice(int_price);
			param.setTotal(int_total);
			param.setIdx(idx);

			ProductDAO.insertCart(param);
			response.sendRedirect("/cart");
			return;
		}
		
		request.setAttribute("cart_list", ProductDAO.getCartList());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/cart.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
