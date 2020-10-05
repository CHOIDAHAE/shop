package com.sh.project.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.project.db.BoardDAO;
import com.sh.project.vo.UserVO;


@WebServlet("/review")
public class ReviewSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		
		if(loginUser == null) {
				response.sendRedirect("/login");
				return;
		}
		
		request.setAttribute("list", BoardDAO.getRBoardList());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/review.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}