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
import com.sh.project.db.ProductDAO;
import com.sh.project.vo.CartVO;
import com.sh.project.vo.OrderVO;
import com.sh.project.vo.ProductVO;
import com.sh.project.vo.UserVO;


@WebServlet("/order")
public class OrderSev extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//세션에 값세팅
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser == null) {
				response.sendRedirect("/login");
				return;
		}
				
		String seq = request.getParameter("seq");
		int int_Seq = Utils.parseStringToInt(seq, 0);
		String category = request.getParameter("category");
		int int_Category = Utils.parseStringToInt(category, 0);
		
		String order_idx = request.getParameter("order_idx");
		String idx = request.getParameter("idx");
		int intidx = Utils.parseStringToInt("idx", 0);
		String name = request.getParameter("name");
		String num = request.getParameter("num");
		int intnum = Utils.parseStringToInt("num", 0);
		String price = request.getParameter("price");
		int intprice = Utils.parseStringToInt("price", 0);
		String total = request.getParameter("total");
		int inttotal = Utils.parseStringToInt("total", 0);
		
		ProductVO param = new ProductVO();
		param.setSeq(int_Seq);
		param.setCategory(int_Category);
		
		
		if (intnum != 0 && intprice != 0 && inttotal != 0) {
			OrderVO vo = new OrderVO();
			vo.setNum(intnum);
			vo.setName(name);
			vo.setPrice(intprice);
			vo.setTotal(inttotal);
			vo.setIdx(intidx);

			ProductDAO.insertOrder(vo);
			response.sendRedirect("/order");
			return;
		}
		
		System.out.println("seq="+seq);
		System.out.println("category="+category);
		System.out.println("intidx="+intidx);
		System.out.println("name="+name);
		System.out.println("intprice="+intprice);
		System.out.println("inttotal="+inttotal);
		
		request.setAttribute("detail", ProductDAO.getProductDetail(int_Seq, int_Category));
		request.setAttribute("order", ProductDAO.getOrderProduct(intidx));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/order.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
