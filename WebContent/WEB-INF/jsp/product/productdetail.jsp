<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/pdetail.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>isSHOP-제품상세</title>
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
		<div class="product">
			<div class="img_part">
	     		<img src="img/white.jpg" alt="이미지 준비중입니다.">
	    	</div>
	     	<div class="detail_info">
	     		<div class="product_nm">
	     			${detail.p_nm }
	     		</div>
	     		<div class="product_content">
	     			${detail.info }
	     		</div>
	     	<form action="/cart" name="frm" method="get">
	     		<div class="line"><span>가격</span><span></span>${detail.price } won</div>
	     		<div class="line"><span>수량</span><span><input type="number" name="quntity" value="1"></span></div>
	     		<div class="line"><span>Total
	     		</span><input type="text" id="sum" value= "0"><input type="button" value="확인" onclick="add1(${detail.price}); "></div>
	     		<div class="button_group">
        			<button class="buy" type="button" onclick="location.href=''">구매하기</button>
       				<button class="cart" type="button" onclick="check(${detail.price}); ">장바구니</button>
     		 	</div>
     		 </form>	
	     	</div>
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
  <script>
		function moveToOrder(seq, category, price) {
  			location.href = '/order?seq=' + seq + '&category=' + category
  		}
  		// 총 합게값을 확인하는 함수
  		function add1(price) { 
	  		var q = document.frm.quntity.value; 
	  		var total = (price * q); 
	  		document.getElementById("sum").value = total;
		}
  		// 확인된 합계값을 체크해서 서블릿으로 전달하는 함수 (더 효율적으로 작성될것같은데 생각해봐야할듯!....!)
  		function check(price) {
  			var q = document.frm.quntity.value; 
	  		var total = (price * q);
  			document.getElementById("sum").value = total;
	  		var url = '/cart?total=' + total + '&price=' + price + '&num=' + q;
  			window.location.href = url;
  		}
  
  </script>
</body>
</html>