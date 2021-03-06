<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% pageContext.setAttribute("replaceChar","\n"); %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/review.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>isSHOP-문의사항</title>
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
      <div class="detail_review_info">
      	<div class="detail"><span>글번호</span> ${detail.i_board }</div>
   	 	<div class="detail"><span>제목</span> ${detail.title }</div>
		<div class="detail"><span>작성일시</span> ${detail.w_dt }</div>
		<div class="detail"><span>수정일시</span> ${detail.m_dt }</div>
		<div class="detail"><span>조회수</span> ${detail.hits }</div>
		<div class="detail"><span>내용</span></div>
		<div class="detail_content">${fn:replace(detail.content, replaceChar, "<br/>") }</div>
      
      <c:if test="${loginUser.idx == detail.idx }">
	      <div class="moddel">
	      	<button onclick="clkMod()">수정</button>
	      	<button onclick="clkDelBtn(${detail.i_board})">삭제</button>
	      </div>
      </c:if>
      
      </div>
      
      <div class="button">
        <button type="button" onclick="location.href='quesrem'">문의작성</button>
        <button type="button" onclick="location.href='ques'">돌아가기</button>
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
  	function clkMod(){
  		location.href='/quesrem?i_board=' + ${detail.i_board}
  	}
  	function clkDelBtn(i_board){
  		var result = confirm(i_board + '번 글을 삭제하시겠습니까?')
  		if(result){
  			location.href = '/boardDel?i_board=' + i_board
  		}
  	}
  </script>
</body>
</html>