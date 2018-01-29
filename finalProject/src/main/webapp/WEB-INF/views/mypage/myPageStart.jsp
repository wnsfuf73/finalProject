<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>    
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<title>동행 마이페이지</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
	<!-- Preloader -->
	<div id="loading">
		<div id="loading-center">
			<div id="loading-center-absolute">
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
			</div>
		</div>
	</div>
	<!--End off Preloader -->

<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">
  <button class="w3-bar-item w3-button w3-large" onclick="w3_close()"> &times;</button>
   
    <!-- 목록 이름은 각자 정해주세요..  -->
    <a href="myPageStart" class="w3-bar-item w3-button">MyPage</a>
	
	<a href="myPlan?pageNum=1" target="contentFrame" class="w3-bar-item w3-button">나의 계획</a>
	<a href="myReview" target="contentFrame" class="w3-bar-item w3-button">리뷰</a>
	<a href="myEssay" target="contentFrame" class="w3-bar-item w3-button">에세이</a>
  	<a href="#" target="contentFrame" class="w3-bar-item w3-button">내 여행 기록</a>
 	
 	<a href="myReservation" target="contentFrame" class="w3-bar-item w3-button">예약 목록</a>
 	
 	<a href="boardList" target="contentFrame" class="w3-bar-item w3-button">나의 QnA</a>
 	<a href="modifyForm" target="contentFrame" class="w3-bar-item w3-button">회원 정보 수정</a>
 	<a href="deleteForm" target="contentFrame" class="w3-bar-item w3-button">회원 탈퇴</a>

</div>
 

 
<div id="main">

<div class="w3-teal" style="background-color:#333!important; margin-bottom: 20px;">
  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()" style="background-color:#333!important">&#9776;</button>
  <div class="w3-container">
  
  	 
	
	
   <h1><a href="myPageStart" style="text-decoration: none;!important;">My Page</a></h1>
    <ul id="nav"> 
 		 <li><a href="epilogueList">이야기</a></li>
 		 
 		 <li><a href="where_main">어디갈까</a></li>
		
		<li>
		<div class="w3-dropdown-hover" style="background-color: #333">
		     <a class="dropdown-toggle"
							data-toggle="dropdown" href="#">예약 </a>
		    <div class="w3-dropdown-content w3-bar-block w3-border">
		      <a href="stayReservation" class="w3-bar-item w3-button" style="color: black;">숙박 예약</a>
		      <a href="airReservation" class="w3-bar-item w3-button" style="color: black;">항공 예약</a>
		      <a href="rentReservation" class="w3-bar-item w3-button" style="color: black;">렌트카 예약</a>
		    </div>
		  </div>
		</li>
 		
 		<c:if test="${sessionScope.mem_id == null}">					
			<script type="text/javascript">
				window.location="main";
			</script>
		</c:if> 
		
		<c:if test="${sessionScope.mem_id != null}">
		
			<li>
			<div class="w3-dropdown-hover" style="background-color: #333">
			     <a class="dropdown-toggle"
								data-toggle="dropdown" href="#">${sessionScope.mem_id}님 </a>
			    <div class="w3-dropdown-content w3-bar-block w3-border">
			      <a href="plan" class="w3-bar-item w3-button" style="color: black;">계획하기</a>
			      <a href="" class="w3-bar-item w3-button" style="color: black;">여행후기</a>
			      <a href="main" class="w3-bar-item w3-button" style="color: black;">메인페이지</a>
			    </div>
			  </div>
			</li>
			
			<li><a href="logout" >로그아웃</a></li>
		</c:if>
	</ul> 
  </div>
</div>


<div class="w3-container">
<div></div>
<div style="position:relative;display:block;height:0;padding:0;overflow:hidden;padding-bottom:56.25%;">
   		<iframe src="myPageHome" name="contentFrame" style="position:absolute;top:0;left:0;bottom:0;height:100%;width:100%;border:0;"></iframe>
</div>

</div>
<script type="text/javascript">

	var iframeSrc= '${setIframe}';

function w3_open() {
	  document.getElementById("main").style.marginLeft = "25%";
	  document.getElementById("mySidebar").style.width = "25%";
	  document.getElementById("mySidebar").style.display = "block";
	  document.getElementById("openNav").style.display = 'none';
	}
function w3_close() {
	  document.getElementById("main").style.marginLeft = "0%";
	  document.getElementById("mySidebar").style.display = "none";
	  document.getElementById("openNav").style.display = "inline-block";
	}



$(function() {
	
	
	if(iframeSrc=='boardList'){
		$("iframe[name='contentFrame']").attr("src",iframeSrc);	
	}
	else if(iframeSrc=='myPlan'){
		$("iframe[name='contentFrame']").attr("src",iframeSrc);	
	}
	
	
	
});

	
</script>

	


    


</body>
</html>