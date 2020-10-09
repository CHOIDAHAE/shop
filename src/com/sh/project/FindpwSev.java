package com.sh.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sh.project.db.UserDAO;
import com.sh.project.vo.UserVO;

@WebServlet("/findpw")
public class FindpwSev extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/user/findPW.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_nm = request.getParameter("u_nm");
		String u_id = request.getParameter("u_id");
		
		if (u_nm.length() == 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이름을 입력해 주세요.')");
			script.println("location.href='findpw';");
			script.println("</script>");
		} else if (u_id.length() == 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('아이디를 입력해 주세요.')");
			script.println("location.href='findpw';");
			script.println("</script>");
		}
		
		List<UserVO> u_pw = UserDAO.findPW(u_nm, u_id);
		
		System.out.println("u_pw = " + u_pw);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter script = response.getWriter();
		
    	script.println("<script>");
        script.println("alert('"+u_nm+"님이 찾으시는 비밀번호는 "+u_pw+" 입니다.')");
    	script.println("location.href='login';");
    	script.println("</script>");
		
	}

}