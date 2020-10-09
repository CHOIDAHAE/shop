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
import com.sh.project.db.BoardDAO;
import com.sh.project.vo.RBoardVO;
import com.sh.project.vo.UserVO;

@WebServlet("/reviewRegMod")
public class ReviewRegModSev extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/login");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/reviewRegMod.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		
		int idx = loginUser.getIdx();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String b_pw = request.getParameter("b_pw");
		int intb_pw = Utils.parseStringToInt(b_pw, 0);
		
		RBoardVO rVO = new RBoardVO();
		rVO.setTitle(title);
		rVO.setContent(content);
		rVO.setB_pw(intb_pw);
		rVO.setIdx(idx);
		
		BoardDAO.insertRBoard(rVO);
		
		response.sendRedirect("/review");
	}

}