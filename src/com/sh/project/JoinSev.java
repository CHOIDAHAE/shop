package com.sh.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.project.db.UserDAO;
import com.sh.project.vo.UserVO;


@WebServlet("/join")
public class JoinSev extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = request.getParameter("error");
		if(error != null) {
			String msg = "아이디 중복입니다.";
			request.setAttribute("emsg", msg);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/join.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_nm = request.getParameter("u_nm");
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		
		int rlt = UserDAO.check(u_id);
		
		if(rlt == 1) {
			response.sendRedirect("/join?error=" + rlt);
		} else {
			
			UserVO vo = new UserVO();
			vo.setU_id(u_id);
			vo.setU_nm(u_nm);
			vo.setU_pw(u_pw);
		
			int result = UserDAO.joinUser(vo);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('회원가입이 완료되었습니다.')");
			script.println("location.href='login';");
			script.println("</script>");
		}
	}

}