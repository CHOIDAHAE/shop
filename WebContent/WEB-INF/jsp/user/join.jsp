<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/join.css">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&family=Poiret+One&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/2ec8d568d7.js" crossorigin="anonymous"></script>
  <title>isSHOP-회원가입</title>
</head>
<body>
  <div id="main_top">
    <div class="top_wrap">
      <div class="logo_top">
        <div class="logo_img">
          <a href="main">isSHOP</a>
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
	    <h1>회원가입</h1>
	      <form class="join_form" id="frm" action="join" method="post" onsubmit="return submitChk()">
		      <div class="nm">
			  	 <input type="text" name="u_nm" placeholder="이름">
			  </div>
			  <div class="id">
			  	 <input type="text" name="u_id" placeholder="아이디">
			  </div>
			  <div class="pw">
			  	 <input type="password" name="u_pw" placeholder="비밀번호">
			  </div>
			  <div class="pw">
			  	 <input type="password" name="re_pw" placeholder="비밀번호 확인">
			  </div>
			  <div class="button">
		        <input type="submit" value="회원가입">
		  	  </div>
		  	  <div class="search">
		  	  	<a href="findid"><span>아이디 찾기</span></a><a href="findpw"><span>비밀번호 찾기</span></a>
		  	  </div>
		  </form>
  	  </div>
  	  <div id="msg"></div>
  	  <div class="check"> ${emsg} </div>
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
  	function submitChk(){
  		if(itemChk(frm.u_nm)){
  			return false
  		} else if(itemChk(frm.u_id)){
  			return false
  		} else if(itemChk(frm.u_pw)){
  			return false
  		} else if(frm.u_pw.value != frm.re_pw.value){
  			msg.innerHTML = '입력하신 비빌번호가 일치하지 않습니다.'
			return false
  		}
  	}
  	
  	function itemChk(ele) {
		if(ele.value.length == 0) {
			ele.focus()
			msg.innerHTML = ele.placeholder + '을(를) 입력해 주세요'				
			return true
		}			
	}
  </script>
  
  
</body>
</html>