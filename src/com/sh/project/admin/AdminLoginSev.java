package com.sh.project.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.project.db.AdminDAO;
import com.sh.project.db.UserDAO;
import com.sh.project.vo.UserVO;

@WebServlet("/adminlogin")
public class AdminLoginSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = request.getParameter("error");
		if(error != null) {
			String errorMsg = "";
			switch(error) {
			case "0" :
				errorMsg = "알 수 없는 에러 발생";
				break;
			case "2":
				errorMsg = "관리자가 아닙니다.";
				break;
			case "3":
				errorMsg = "비밀번호를 확인해 주세요";
				break;
			}
			request.setAttribute("msg", errorMsg);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin/adminlogin.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");

		UserVO param = new UserVO();
		param.setU_id(u_id);
		param.setU_pw(u_pw);

		int result = AdminDAO.doadminLogin(param);
		
		if(result == 1) {
			HttpSession hs = request.getSession();
			hs.setAttribute("adminloginUser", param);
			hs.setAttribute("u_nm", param.getU_nm());
			response.sendRedirect("/admin");
			return;
		}
		response.sendRedirect("/adminlogin?error=" + result);
	}

}
