<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/main.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>isSHOP</title>
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
    <div class="shopMainImg">
      <img src="img/shopMainImg.jpg" alt="shopMainimg">
    </div>
    <div class="best">
      <div class="best_product_title">
        WEEKLY BEST
      </div>
      <div class="best_product_img">
        <div class="img_border">
            <img src="img/shirts.jpg" alt="shirt">
            <div class="product_info">
              <div class="product_title">
                모건 jacket
              </div>
              <div class="product_price">
                158,000 won
              </div>
              <div class="product_detail">
                울90% 쓰리버튼의 핸드메이드 자켓
                자켓과 로오트의 중간인 힙을 넉넉히 덮어주는 하프기장
                어디든 쉽게 코디할 수 있는 데일리 자켓으로 추천!
              </div>
            </div>
        </div>
        <div class="img_border">
          <img src="img/shirts.jpg" alt="shirts">
          <div class="product_info">
            <div class="product_title">
              라보 - made knit ops
            </div>
            <div class="product_price">
              34,200 won
            </div>
            <div class="product_detail">
              롱 원피스를 좋아하는 만큼
              원사와 컬러염색, 내부 디테일까지
              하나 신경써서 만든 제작원피스
            </div>
          </div>
        </div>
        <div class="img_border">
          <img src="img/dress.jpg" alt="dress">
          <div class="product_info">
            <div class="product_title">
              라보 - made knit ops
            </div>
            <div class="product_price">
              34,200 won
            </div>
            <div class="product_detail">
              롱 원피스를 좋아하는 만큼
              원사와 컬러염색, 내부 디테일까지
              하나 신경써서 만든 제작원피스
            </div>
          </div>
        </div>
        <div class="img_border">
          <img src="img/dress.jpg" alt="dress">
          <div class="product_info">
            <div class="product_title">
              라보 - made knit ops
            </div>
            <div class="product_price">
              34,200 won
            </div>
            <div class="product_detail">
              롱 원피스를 좋아하는 만큼
              원사와 컬러염색, 내부 디테일까지
              하나 신경써서 만든 제작원피스
            </div>
          </div>
        </div>
        <div class="img_border">
          <img src="img/white.jpg" alt="white">
          <div class="product_info">
            <div class="product_title">
              라보 - made knit ops
            </div>
            <div class="product_price">
              34,200 won
            </div>
            <div class="product_detail">
              롱 원피스를 좋아하는 만큼
              원사와 컬러염색, 내부 디테일까지
              하나 신경써서 만든 제작원피스
            </div>
          </div>
        </div>
        <div class="img_border">
          <img src="img/white.jpg" alt="white">
        </div>
        <div class="img_border">
          <img src="img/white.jpg" alt="white">
        </div>
        <div class="img_border">
          <img src="img/white.jpg" alt="white">
        </div>
      </div>
    </div>
    <div class="new">
      <div class="new_product_title">
        NEW PRODUCT
      </div>
      <div class="new_product_img">
        <div class="img_border">
          <img src="img/shirts.jpg" alt="shirts">
          <div class="product_info">
            <div class="product_title">
              라보 - made knit ops
            </div>
            <div class="product_price">
              34,200 won
            </div>
            <div class="product_detail">
              롱 원피스를 좋아하는 만큼
              원사와 컬러염색, 내부 디테일까지
              하나 신경써서 만든 제작원피스
            </div>
          </div>
        </div>
        <div class="img_border">
          <img src="img/shirts.jpg" alt="shirts">
        </div>
        <div class="img_border">
          <img src="img/dress.jpg" alt="dress">
        </div>
        <div class="img_border">
          <img src="img/dress.jpg" alt="dress">
        </div>
        <div class="img_border">
          <img src="img/white.jpg" alt="white">
          <div class="product_info">
            <div class="product_title">
              라보 - made knit ops
            </div>
            <div class="product_price">
              34,200 won
            </div>
            <div class="product_detail">
              롱 원피스를 좋아하는 만큼
              원사와 컬러염색, 내부 디테일까지
              하나 신경써서 만든 제작원피스
            </div>
          </div>
        </div>
        <div class="img_border">
          <img src="img/white.jpg" alt="white">
        </div>
        <div class="img_border">
          <img src="img/white.jpg" alt="white">
        </div>
        <div class="img_border">
          <img src="img/white.jpg" alt="white">
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
  <script>
		function moveToDetail(u_nm) {
			location.href = '/mypage?u_nm=' + u_nm
		}
  </script>
</body>
</html>