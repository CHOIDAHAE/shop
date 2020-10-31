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
import com.sh.project.vo.QBoardVO;
import com.sh.project.vo.RBoardVO;
import com.sh.project.vo.UserVO;


@WebServlet("/mypage")
public class MypageSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에 값세팅
				HttpSession hs = request.getSession();
				UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
				if(loginUser == null) {
						response.sendRedirect("/login");
						return;
				}
				int page = 1;
				
				String strPage = request.getParameter("page");
				if (strPage != null) {
						page = Integer.parseInt(strPage);
				}
				int cnt = 5;
				int sIdx = (page - 1) * cnt;
				
				String idx = request.getParameter("idx");
				int int_idx = Utils.parseStringToInt(idx, 0);
					
				UserVO param = new UserVO();
				param.setIdx(int_idx);
				
				QBoardVO param1 = new QBoardVO();
				param1.setIdx(int_idx);
				param1.setsIdx(sIdx);
				param1.setRowCnt(cnt);
				
				request.setAttribute("mypage", BoardDAO.mypageinfo(int_idx));
				request.setAttribute("mypageQ", BoardDAO.mypageQ(param1));
				request.setAttribute("totalPageCnt", BoardDAO.getQTotalPage(param1));
				
								
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/mypage.jsp");
				rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
