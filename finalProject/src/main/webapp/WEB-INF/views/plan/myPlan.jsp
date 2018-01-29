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
	<div class="row">
		<div class="col-md-12">
			<div class="col-md-1"></div>
				<div class="col-md-10">
					<div>
						<table style="width:100%; text-align:center;" class="review_table">
						<thead>
							<tr>
								<th colspan="6" style="height:25px; text-align:center;">
									글목록(글개수 : ${cnt})							
								</th>
							</tr>
							<tr>
								<th style="width:10%; text-align:center;"> 계획명 </th>
								<th style="width:10%; text-align:center;"> 작성자 </th>
								<th style="width:10%; text-align:center;"> 줄거리 </th>
							</tr>
						</thead>	
							<!-- 재고가 있으면 -->
							<c:if test="${cnt > 0}">
								<c:forEach var="dto" items="${dtos}">
									<tr>
										<td align="center">
											<a href="myPlanCourseContent?planNo=${dto.planNo}&pageNum=${pageNum}&planTitle=${dto.planTitle}&planContent=${dto.planContent}" class="plancourselistA">${dto.planTitle}</a>
										</td>	
																	
										<td align="center">
											<a href="myPlanCourseContent?planNo=${dto.planNo}&pageNum=${pageNum}&planTitle=${dto.planTitle}&planContent=${dto.planContent}" class="plancourselistA">${dto.mem_Id}</a>
										</td>
										
										<td align="center">
										<a href="myPlanCourseContent?planNo=${dto.planNo}&pageNum=${pageNum}&planTitle=${dto.planTitle}&planContent=${dto.planContent}" class="plancourselistA">
											${dto.planContent}
											<input type="hidden" name="planNo" value="${dto.planNo}">
										</a>
										</td>
										
									</tr>
								</c:forEach>
							</c:if>
							
							<c:if test="${cnt == 0}">	<!-- 계획이 없으면 -->
								<tr>
									<td colspan="6" align="center">
										계획이 없습니다.
									</td>
								</tr>
							</c:if>
						</table>
						<!-- 페이지 컨트롤 -->
					   <table style="width:100%" align="center">
					      <th align="center" style="text-align:center;">
					         <c:if test="${cnt > 0 }">
					            <!-- 처음[◀◀] / 이전블록 [◀] 특수문자 : ㅁ 한자키 -->
					            <c:if test="${startPage > pageBlock }">
					               <a href="myPlan"> <img src="${images}review/left_double.png" width="14px"> </a>
					               <a href="myPlan?pageNum=${startPage - pageBlock}"> <img src="${images}review/left_arrow.png" width="14px"> </a>
					            </c:if>
					            
					            <c:forEach var="i" begin="${startPage}" end="${endPage}">
					               <c:if test="${i == currentPage}">
					                  <span><b style="color:#337ab7;">${i}</b></span>
					               </c:if>
					               <c:if test="${i != currentPage}">
					                  <a href="myPlan?pageNum=${i}" style="color:#797979;">${i}</a>
					               </c:if>
					            </c:forEach>
					            
					            <!-- 다음블록[▶] / 끝[▶▶] -->
					            <c:if test="${pageCount > endPage }">
					               <a href="myPlan?pageNum=${startPage + pageBlock}"> <img src="${images}review/right_arrow.png" width="14px"> </a>
					               <a href="myPlan?pageNum=${pageCount}"> <img src="${images}review/right_double.png" width="14px"> </a>               
					            </c:if>
					         </c:if>
					      </th>
					   </table>
					</div>
				</div>
			<div class="col-md-1"></div>
		</div>
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