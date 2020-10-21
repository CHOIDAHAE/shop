package com.sh.project.board;

import java.io.IOException;

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

@WebServlet("/cartDel")
public class CartDelSev extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/login");
			return;
		}

		String c_board = request.getParameter("c_board");
		int int_c_board = Utils.parseStringToInt(c_board, 0);

		if(int_c_board == 0) { 
			return;
		}

		CartVO param = new CartVO();
		param.setC_board(int_c_board);

		ProductDAO.delCartList(param);
		response.sendRedirect("/cart");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}