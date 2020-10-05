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


@WebServlet("/findid")
public class FindidSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/findID.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_nm = request.getParameter("u_nm");
		
		if (u_nm.length() == 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이름을 입력해 주세요.')");
			script.println("location.href='findid';");
			script.println("</script>");
		}
		List<UserVO> u_id = UserDAO.findID(u_nm);
		
		if (u_id.size() == 0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('회원가입이 필요합니다.')");
			script.println("location.href='join';");
			script.println("</script>");
		}
		else {
			request.setAttribute("list_id", u_id);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/findID.jsp");
			rd.forward(request, response);
		}
	}

}