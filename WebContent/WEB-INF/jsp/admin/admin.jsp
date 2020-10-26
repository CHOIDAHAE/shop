<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/admin.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>isSHOP-회원관리</title>
</head>
<body>
  <div id="main_top">
    <div class="top_wrap">
	  <%
    	if(session.getAttribute("adminloginUser") != null){
      %>
        <div class="welcome">${ adminloginUser.u_nm }님 환영합니다.
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
    <div class="admin_part">
      <p class="admin_title">회원 관리</p>
      <p class="list_title"><i class="fas fa-users"></i>회원 리스트</p>
      <div class="admin_info">
      	<table>
      		<tr>
      			<th style="width:100px;">회원번호(idx)</th>
      			<th style="width:150px;">이름</th>
      			<th style="width:150px;">아이디</th>
      			<th style="width:200px;">게시글목록?</th>
      			<th style="width:100px;">삭제버튼?(강퇴기능?)</th>
      		</tr>
	      	<tr>
	      		<td>이름 DB</td>
	      		<td>아이디 DB</td>
	      		<td>DB</td>
	      		<td>DB</td>
	      		<td><button>삭제</button></td>
	      	</tr>
      	</table>
      </div>
      
      <p class="list_title"><i class="fas fa-list-ul"></i>회원 게시글</p>
      <p class=""></p>
      <div class="admin_info">
      	<table>
      		<tr>
      			<th style="width:100px;">회원번호(idx)</th>
      			<th style="width:150px;">이름</th>
      			<th style="width:150px;">아이디</th>
      			<th style="width:200px;">게시글목록?</th>
      			<th style="width:100px;">삭제버튼?(강퇴기능?)</th>
      		</tr>
	      	<tr>
	      		<td>이름 DB</td>
	      		<td>아이디 DB</td>
	      		<td>DB</td>
	      		<td>DB</td>
	      		<td><button>삭제</button></td>
	      	</tr>
      	</table>
      </div>
      
      <div class="button">
        <button type="button" onclick="location.href='updateproduct'">상품등록</button>
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
		function moveToDetail(i_board) {
			location.href = '/reviewDetail?i_board=' + i_board
		}
  </script>
</body>
</html>