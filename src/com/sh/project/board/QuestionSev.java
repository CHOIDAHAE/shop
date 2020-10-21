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
import com.sh.project.vo.QBoardVO;
import com.sh.project.vo.UserVO;


@WebServlet("/ques")
public class QuestionSev extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		
		if(loginUser == null) {
				response.sendRedirect("/login");
				return;
		}
		
		
		String search = request.getParameter("search");
		
		
		
		int page = 1;
		String strPage = request.getParameter("page");
		if(strPage != null) {
			page = Integer.parseInt(strPage);
		}
		int cnt = 10; //content view count
		int sIdx = (page - 1) * cnt;
		
		QBoardVO param = new QBoardVO();
		param.setSearch(search);
		param.setsIdx(sIdx);
		param.setRowCnt(cnt);
		
		request.setAttribute("page", page);
		
		request.setAttribute("totalPageCnt", BoardDAO.getTotalPageCnt(cnt));
		request.setAttribute("list", BoardDAO.getQBoardList(param));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/questions.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}