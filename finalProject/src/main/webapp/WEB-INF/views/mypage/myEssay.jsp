<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>    
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet" href="${css}kwakmypage.css">

<script src="${script}script.js"></script>
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
		<h2>MyEssay</h2>
		<table style="width:100%" align="center" class="review_table">
		<thead>
			<tr>
				<th colspan="6" align="center" style="height:25px">
					글목록(글개수 : ${cnt})
				</th>
			</tr>
			<tr>
				<th style="width:3%"> 번호 </th>
				<th style="width:15%"> 사진 </th>
				<th style="width:10%"> 제목 </th>
				<th style="width:10%"> 작성자 </th>
				<th style="width:10%"> 공개여부(1:Y, 2:N) </th>
				<th style="width:7%"> 삭제 </th>
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
						
						<td>
						<a href="myEssayDelpro?essayNo=${dto.essayNo}" onclick="return delconfirm()">삭제</a></td>

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

function delconfirm(){
	var i = confirm("정말로 삭제하시겠습니까?");
	if(i == true){
	}else{
		window.location = "myEssay";
	}
}
	
</script>

</body>
</html>