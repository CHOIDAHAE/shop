package com.sh.project.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.project.Utils;
import com.sh.project.db.BoardDAO;
import com.sh.project.vo.RBoardVO;


@WebServlet("/reviewDetail")
public class ReviewDetailSev extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i_board = request.getParameter("i_board");
		int int_Iboard = Utils.parseStringToInt(i_board, 0);
		
		RBoardVO param = new RBoardVO();
		param.setI_board(int_Iboard);
		
		BoardDAO.updateRBoardHits(param);
		request.setAttribute("detail", BoardDAO.getRBoard(int_Iboard));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/reviewdetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}