<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>    
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet" href="${css}kwakmypage.css">
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
	
	<a href="myPlan?pageNum=1" class="w3-bar-item w3-button">나의 계획</a>
	<a href="myReview" class="w3-bar-item w3-button">리뷰</a>
	<a href="myEssay" class="w3-bar-item w3-button">에세이</a>
  	
  	<a href="#" class="w3-bar-item w3-button">내 여행 기록</a>
 	
 	<a href="myReservation" class="w3-bar-item w3-button">예약 목록</a>
 	
 	<a href="boardList" class="w3-bar-item w3-button">나의 QnA</a>
 	<a href="modifyForm" class="w3-bar-item w3-button">회원 정보 수정</a>
 	<a href="deleteForm" class="w3-bar-item w3-button">회원 탈퇴</a>

</div>
 

    

 
<div id="main">

<div class="w3-teal" style="background-color:#333!important">
  <button id="openNav" class="w3-button w3-teal w3-xlarge" onclick="w3_open()" style="background-color:#333!important">&#9776;</button>
  <div class="w3-container">
  
  	 
	
	
   <h1><a href="myPageStart" style="text-decoration: none;!important;">My Page</a></h1>
    <ul id="nav"> 
 		 <li><a href="story_write_myTourStory">이야기</a></li>
 		 
 		 <li><a href="where_main">어디갈까</a></li>
  		 
  		 <li><a href="recomandStart">추천여행기</a></li>
 		 
 		<li>
 		 	<a href="#">예약</a>
 		 		<ul>
					<li><a href="stayReservation">숙박 예약</a></li>
					<li><a href="airReservation">항공 예약</a></li>
					<li><a href="rentReservation">렌트카 예약</a></li>
		  		</ul>
 		 </li>
 		
 		<c:if test="${sessionScope.mem_id == null}">					
			<script type="text/javascript">
				window.location="main";
			</script>
		</c:if> 
		
		<c:if test="${sessionScope.mem_id != null}">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">${sessionScope.mem_id}님</a>
					<ul class="dropdown-menu">
						<li><a href="plan">계획하기</a></li>
						<li><a href="xxxStart">여행후기</a></li>
					</ul>
			</li>
			
			<li><a href="logout" >로그아웃</a></li>
		</c:if>
	</ul> 
  </div>
</div>

<!-- 가운데 내용 -->
<div class="w3-container">
	<div>
		<h2>MyEssay</h2>
		<table style="width:100%" align="center" class="review_table">
		<thead>
			<tr>
				<th colspan="6" align="center" style="height:25px">
					글목록(글개수 : ${cnt})&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="myEssayDelete">삭제</a>

				</th>
			</tr>
			<tr>
				<th style="width:3%"> 번호 </th>
				<th style="width:15%"> 사진 </th>
				<th style="width:10%"> 제목 </th>
				<th style="width:10%"> 작성자 </th>
				<th style="width:10%"> 공개여부(1:Y, 2:N) </th>
			</tr>
		</thead>	
			<!-- 댓글이 있으면 -->
			<c:if test="${cnt > 0}">
				<c:forEach var="dto" items="${dtos}">
					<tr>
						<th align="center">	${number} 
						<c:set var="number" value="${number-1}"/>
						</th>
						
						<td align="center"><a href="myEssayContent?essayNo=${dto.essayNo}&pageNum=${pageNum}&number=${number}&essayImg=${dto.essayImg}"> 
						<img width="100%" src="${images}essay/${dto.essayImg}"></a></td>	
													
						<td align="center"><a href="myEssayContent?essayNo=${dto.essayNo}&pageNum=${pageNum}&number=${number}&essayImg=${dto.essayImg}">${dto.essayTitle}</a></td>
						
						<td align="center"> ${dto.mem_id} </td>
						
						<td align="center">${dto.security}</td>

					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${cnt == 0}">	<!-- 댓글이 없으면 -->
				<tr>
					<td colspan="6" align="center">
						재고가 없습니다. 재고를 추가해주세요.
					</td>
				</tr>
			</c:if>
		</table>
		<!-- 페이지 컨트롤 -->
	   <table style="width:100%" align="center">
	      <th align="center">
	         <c:if test="${cnt > 0 }">
	            <!-- 처음[◀◀] / 이전블록 [◀] 특수문자 : ㅁ 한자키 -->
	            <c:if test="${startPage > pageBlock }">
	               <a href="myReview"> <img src="${images}review/left_double.png" width="14px"> </a>
	               <a href="myReview?pageNum=${startPage - pageBlock}"> <img src="${images}review/left_arrow.png" width="14px"> </a>
	            </c:if>
	            
	            <c:forEach var="i" begin="${startPage}" end="${endPage}">
	               <c:if test="${i == currentPage}">
	                  <span><b>${i}</b></span>
	               </c:if>
	               <c:if test="${i != currentPage}">
	                  <a href="myReview?pageNum=${i}">${i}</a>
	               </c:if>
	            </c:forEach>
	            
	            <!-- 다음블록[▶] / 끝[▶▶] -->
	            <c:if test="${pageCount > endPage }">
	               <a href="myReview?pageNum=${startPage + pageBlock}"> <img src="${images}review/right_arrow.png" width="14px"> </a>
	               <a href="myReview?pageNum=${pageCount}"> <img src="${images}review/right_double.png" width="14px"> </a>               
	            </c:if>
	         </c:if>
	      </th>
	   </table>
	</div>
</div>

</div>

	
<script type="text/javascript">
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
	
	
</script>

</body>
</html>