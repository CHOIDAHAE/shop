package com.sh.project.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.project.Utils;
import com.sh.project.db.BoardDAO;
import com.sh.project.vo.QBoardVO;
import com.sh.project.vo.RBoardVO;
import com.sh.project.vo.UserVO;

@WebServlet("/RboardDel")
public class ReviewDelSev extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에 값세팅
				HttpSession hs = request.getSession();
				UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
				if(loginUser == null) {
					response.sendRedirect("/login");
					return;
				}
				
				RBoardVO param = new RBoardVO();
				
				String i_board = request.getParameter("i_board");
				int intBoard = Utils.parseStringToInt(i_board, 0);
				if(intBoard == 0) {
					return;
				}
				
				param.setI_board(intBoard);
				param.setIdx(loginUser.getIdx());
				int result = BoardDAO.delRBoard(param);
				if(result == 0 ) {
					return;
				}
				response.sendRedirect("/review");
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
