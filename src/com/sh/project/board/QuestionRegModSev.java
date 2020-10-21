package com.sh.project.board;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.sh.project.vo.UserVO;


@WebServlet("/quesrem")
public class QuestionRegModSev extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/login");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/questionsRegMod.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String b_pw = request.getParameter("b_pw");
		int intb_pw = Utils.parseStringToInt(b_pw, 0);
		int idx = loginUser.getIdx();		
		
		if (title.length() == 0 || content.length() == 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('제목 또는 내용을 입력해주세요')");
			script.println("history.back(-1)");
			script.println("</script>");
		} else if (title.length() > 20){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('제목이 20자를 초과했습니다.')");
			script.println("history.back(-1)");
			script.println("</script>");
		} else if (intb_pw > 10000 || intb_pw < 1000) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호는 4자리로 입력해주세요.')");
			script.println("history.back(-1)");
			script.println("</script>");
		} else {
		
		QBoardVO param = new QBoardVO();
		param.setTitle(title);
		param.setContent(content);
		param.setB_pw(intb_pw);
		param.setIdx(idx);

		BoardDAO.insertQBoard(param);

		response.sendRedirect("/ques");
		
		}
	}

}