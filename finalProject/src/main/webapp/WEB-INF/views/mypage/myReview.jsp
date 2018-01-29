<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>    
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet" href="${css}kwakmypage.css">
<title>Insert title here</title>
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


    

 
<div id="main">

<!-- 가운데 내용 -->
<div class="w3-container">
	<div>
		<h2>MyReview</h2>
		<table style="width:100%" class="review_table">
		<thead>
			<tr>
				<th colspan="6" align="center" style="height:25px">
					글목록(글개수 : ${cnt})&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="myReviewDelete">삭제</a>

				</th>
			</tr>
			<tr>
				<th style="width:3%"> 번호 </th>
				<th style="width:15%"> 사진 </th>
				<th style="width:10%"> 장소이름 </th>
				<th style="width:10%"> 작성자 </th>
				<th style="width:10%"> 평점 </th>
				<th style="width:10%"> 방문일자 </th>
			</tr>
		</thead>	
			<!-- 재고가 있으면 -->
			<c:if test="${cnt > 0}">
				<c:forEach var="dto" items="${dtos}">
					<tr>
						<th align="center">	${number} 
						<c:set var="number" value="${number-1}"/>
						</th>
						
						<td align="center"><img width="100%" src="${images}review/${dto.reviewImg}"> </td>	
													
						<td align="center">${dto.location_name}</td>
						
						<td align="center">${dto.mem_id} </td>
						
						<td align="center">${(dto.reviewview+dto.fun+dto.near+dto.price)/4}</td>
						
						<td align="center">${dto.regdate} </td>
						
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${cnt == 0}">	<!-- 재고가 없으면 -->
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