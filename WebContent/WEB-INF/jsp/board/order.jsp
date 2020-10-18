<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/cart.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>isSHOP-주문목록</title>
</head>
<body>
  <div id="main_top">
    <div class="top_wrap">
      <%
      	if(session.getAttribute("loginUser") != null){
      %>
        <div class="welcome">${ loginUser.u_nm }님 환영합니다.
        <a href="logout"><span class="logout">로그아웃</span></a></div>
      <%
    	} else {
      %>
        <div class="welcome"><a href="login">로그인</a>이 필요합니다.</div>
      <%		
    	}
      %>
      <div class="logo_top">
        <div class="logo_img">
          <a href="main">isSHOP</a>
        </div>
        <div class="SearchBox">
          <i class="fas fa-search"></i><input type="text" class=""name="search" placeholder="검색">
        </div>
        <div class="icon_group">
          <a href="login"><i class="fas fa-sign-in-alt"></i></a>
          <a href="/mypage?idx=${loginUser.idx}"><i class="far fa-user"></i></a>
          <a href="cart"><i class="fas fa-cart-plus"></i></a>
        </div>
      </div>
      </div>
      <div class="category">
        <div class="top_wrap">
          <span><a href="outer">OUTER</a></span>
          <span><a href="top">TOP</a></span>
          <span><a href="bottom">BOTTOM</a></span>
          <span><a href="shoes">SHOES</a></span>
          <span><a href="ques">BOARD</a></span>
        </div>
      </div>
    </div>
	<div id="main_bottom">
     <div class="cart">
	    <p class="cart_title">주문내역</p>
	    <div class="cart_info">
		  <table>
		  	<thead>
		  		<tr>
		  			<th>주문번호</th>
		  			<th>상품명</th>
		  			<th>가격</th>
		  			<th>수량</th>
					<th>합계</th>
		    	</tr>
		    </thead>
		    <tbody>	  		
		    	<tr>
		  			<td>${detail.seq }</td>
		  			<td>${detail.p_nm }</td>
		  			<td>${detail.price }won</td>
		  			<td>${order.number }</td>
					<td>${order.total }</td>
		    	</tr>
		    </tbody>
  	    </table>
  	  </div>
  	  <div class="order_info">
  	  	<h2 class="order_title">주문정보</h2>
  	  	<form action="#" method="post">
		  <table class="order_table">
		  		<tr>
		  			<th>주문하시는 분</th>
		  			<td name="u_nm">${ loginUser.u_nm }</td>
		  			
		    	</tr>	
		    	<tr>
		    		<th>주소</th>
		  			<td name="address" class="address">
						<input type="text">
					</td>
		    	</tr>
		    	<tr>
		    		<th>휴대전화</th>
		  			<td class="p_nm">
		  			<select name="p_num_first">
		  				<option value='' selected>==선택==</option>
		  				<option value='010'>010</option>
		  				<option value='02'>02</option>
		  				<option value='054'>054</option>
		  				<option value='053'>053</option>
		  			</select>
		  			-
		  			<input name="p_num_second" type="text">
		  			-
		  			<input name="p_num_third" type="text">
		  			</td>
		    	</tr>
		    	<tr>
		   		 	<th>이메일</th>
		  			<td name="email" class="email"><input type="email" placeholder="email을 입력해주세요(ex.abc@naver.com)"></td>
		    	</tr>
  	    </table>
  	    <div class="button"><input type="submit" value="구매하기"></div>
  	  </div>
  	  </form>
  	 </div>
  	</div>
  <div class="side">
    <%
      	if(session.getAttribute("loginUser") != null){
    %>
      <a href="/mypage?idx=${loginUser.idx}"><div class="border"><i class="far fa-user"></i></div></a>
      <a href="cart"><div class="border"><i class="fas fa-cart-plus"></i></div></a>
      <a href="main"><div class="border"><i class="fas fa-search"></i></div></a>
    <%
    	} else {
    %>
      <a href="login"><div class="border"><i class="fas fa-sign-in-alt"></i></div></a>
      <a href="/mypage?idx=${loginUser.idx}"><div class="border"><i class="far fa-user"></i></div></a>
      <a href="cart"><div class="border"><i class="fas fa-cart-plus"></i></div></a>
      <a href="main"><div class="border"><i class="fas fa-search"></i></div></a>
    <%		
    	}
    %>
  </div>
  <footer>
    <div id="footer">
      <span>Copyright &copy; isShop. All Right Reserved.</span>
    </div>
  </footer>
</body>
</html>