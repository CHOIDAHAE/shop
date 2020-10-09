<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/login.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>IsSHOP-아이디 찾기</title>
</head>
<body>
  <div id="main_top">
    <div class="top_wrap">
      <div class="logo_top">
        <div class="logo_img">
          <a href="/main">isSHOP</a>
        </div>
        <div class="SearchBox">
          <i class="fas fa-search"></i><input type="text" class=""name="search" placeholder="검색">
        </div>
        <div class="icon_group">
          <a href="login"><i class="fas fa-sign-in-alt"></i></a>
          <a href="mypage"><i class="far fa-user"></i></a>
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
     <div class="Login_Top">
      <div class="login">
	    <h1>아이디 찾기</h1>
	    <form class="login_form" id="frm" action="findid" method="post" onsubmit="return submitChk()">
		  <div class="id">
		  	 <input type="text" name="u_nm" placeholder="가입 시 기입한 이름을 입력하시오">
		  </div>
		  <div class="button">
	        <input type="submit" value="찾기">
	  	  </div>
	  	 </form>
	  	 <div style="color:blue; font-weight: bold;">
			<c:forEach var="vo" items="${list_id}">
				<tr>
					<td class="fontCenter">${vo.u_id }</td>
				</tr>
			</c:forEach>
		</div>	
  	  </div>
  	</div>
  </div>
  <div class="side">
    <a href="login"><div class="border"><i class="fas fa-sign-in-alt"></i></div></a>
    <a href="mypage"><div class="border"><i class="far fa-user"></i></div></a>
    <a href="cart"><div class="border"><i class="fas fa-cart-plus"></i></div></a>
    <a href="main"><div class="border"><i class="fas fa-search"></i></div></a>
  </div>
  <footer>
	<div id="footer">
      <span>Copyright &copy; isShop. All Right Reserved.</span>
    </div>
  </footer>
  <script>
  		
  </script>
</body>
</html>