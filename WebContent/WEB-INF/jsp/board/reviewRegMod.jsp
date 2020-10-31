<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/review.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>isSHOP-후기쓰기</title>
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
    <div class="review_part">
      <p class="review_title">REVIEW</p>
      <div class="reviewRegMod_info">
      	<form action="/reviewRegMod" method="post">
	        <div class="reviewRegMod_header">
	          <div class="writer"><span>작성자</span><span> ${ loginUser.u_nm }</span></div>
	          <div class="writer"><span>제목</span><input type="text" name="title" placeholder="20자 이하"></div>
	        </div>
	        <div class="reviewRegMod_detail">
	         <div class="writer"><span>내용</span></div><textarea name="content"></textarea>
	        </div>
	        <div class="write_button"><input type="submit" value="글쓰기" class="write"></div>
	        
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
</body>
</html>