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
import com.sh.project.vo.QBoardVO;
import com.sh.project.vo.RBoardVO;


@WebServlet("/quesDetail")
public class QuestionDetailSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i_board = request.getParameter("i_board");
		int int_Iboard = Utils.parseStringToInt(i_board, 0);
		
		System.out.println("i_board : " + int_Iboard);
		QBoardVO param = new QBoardVO();
		param.setI_board(int_Iboard);
		
		
		
		BoardDAO.updateQBoardHits(param);
		request.setAttribute("detail", BoardDAO.getQBoard(int_Iboard));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/questiondetail.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}