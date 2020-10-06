<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/product.css">
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
	     			DB p_nm 연결, 모건 jacket
	     		</div>
	     		<div class="product_content">
	     			DB상품설명 울90% 쓰리버튼의 핸드메이드 자켓과 롱코트의 중간인 힙을 넉넉히 덮어주는 하프기장. 어디든 쉽게 코디할 수 있는 데일리자켓으로 추천!
	     		</div>
	     		<div class="line"><span>가격</span><span></span>15,8000 won</div>
	     		<div class="line"><span>수량</span><span><input type="number" value="1"></span></div>
	     		<div class="line"><span>총 상품금액</span><span>SUM 결과 연결</span></div>
	     		<div class="button_group">
        			<button class="buy" type="button" onclick="location.href='reviewRegMod'">구매하기</button>
       				<button class="cart" type="button" onclick="location.href='ques'">장바구니</button>
     		 	</div>
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
</body>
</html>