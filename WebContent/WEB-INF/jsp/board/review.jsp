<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/review.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>isSHOP-후기</title>
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
          <i class="fas fa-search"></i><input type="text" class="" name="search" placeholder="검색">
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
      <div class="review_info">
      <c:forEach var="vo" items="${list }">
	       <div class="hover"  onclick="moveToDetail(${vo.i_board })">
	        <div class="review_header">
	          <span>글번호</span><span>${vo.i_board }</span>
	          <span>작성자</span><span>${vo.u_id }</span>
	          <span>작성일</span><span>${vo.w_dt }</span>
	          <span>조회수</span><span>${vo.hits }</span>
	        </div>
	        <div class="review_detail">
	          <p>${vo.content }</p>
	        </div>
	       </div>
      </c:forEach>
  
		<div id="pageContainer">
      	<c:forEach var="i" begin="1" end="${totalPageCnt }">				
				<a href="/ques?page=${i}">
				<span <c:if test="${i == page}"> </c:if>>				
					${i}
				</span>
				</a>
		</c:forEach>	
      </div>
      <div id="searchContainer">
		<form action="/ques" method="get">
			<div>
				검색 <input type="search" name="search">
				<input type="submit" value="검색">
			</div>				
		</form>
	  </div>
	  
      </div>
      <div class="button">
        <button type="button" onclick="location.href='reviewRegMod'">후기작성</button>
        <button type="button" onclick="location.href='ques'">문의사항</button>
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