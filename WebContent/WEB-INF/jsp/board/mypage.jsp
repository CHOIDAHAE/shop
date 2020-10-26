<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/mypage.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>isSHOP-마이페이지</title>
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
          <a href="mypage?idx=${loginUser.idx}"><i class="far fa-user"></i></a>
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
     	<div class="mypage">
     	  <p class="mypage_title">마이페이지</p>
     		<div class="mypage_info">
		  	  <table class="mypage_2">
		  	    <caption>나의 정보</caption>
		  		  <tr>
		  			<th>이름</th>
		  			<th>아이디</th>
		  		  </tr>
				  <tr class="pointer trSelected">
					<td class="fontCenter">${mypage.u_nm }</td>
					<td>${mypage.u_id }</td>
				  </tr>
		      </table>
		      <table class="mypage_2">
		       <caption>나의 문의사항</caption>
		  		<tr>
		  			<th>제목</th>
		  			<th>내용</th>
		  			<th>작성일자</th>
		  		</tr>
		  		<c:forEach var="vo" items="${mypageQ}">
				  <tr class="pointer trSelected">
					<td class="fontCenter">${fn:substring(vo.title, 0, 6)}</td>
					<td>${fn:substring(vo.content, 0, 6)}</td>
					<td>${vo.w_dt }</td>
				  </tr>
				</c:forEach>
		      </table>
		      
		  <div id="pageContainer">
					<c:forEach var="i" begin="1" end="${totalPageCnt }">				
						<a href="/mypage?page=${i}&idx=${loginUser.idx}">
						<span <c:if test="${i == page}">class="selected"</c:if>>				
						${i}
						</span>
						</a>
						</c:forEach>			
			  		</div>	
		  </div>
		  
		<div class="button">
        <button type="button" onclick="location.href='review'">후기사항</button>
        <button type="button" onclick="location.href='ques'">문의사항</button>
      </div>
  	</div>
  	</div>
  <div class="side">
    <%
      	if(session.getAttribute("loginUser") != null){
    %>
      <a href="mypage?idx=${loginUser.idx}"><div class="border"><i class="far fa-user"></i></div></a>
      <a href="cart"><div class="border"><i class="fas fa-cart-plus"></i></div></a>
      <a href="main"><div class="border"><i class="fas fa-search"></i></div></a>
    <%
    	} else {
    %>
      <a href="login"><div class="border"><i class="fas fa-sign-in-alt"></i></div></a>
      <a href="mypage"><div class="border"><i class="far fa-user"></i></div></a>
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