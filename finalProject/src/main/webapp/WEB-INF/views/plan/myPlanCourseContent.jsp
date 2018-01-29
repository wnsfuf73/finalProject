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
						<table style="width:99%; text-align:center;" class="review_table">
						<thead>
							<tr>
								<th colspan="6" style="height:25px;">
									작성자 : ${mem_id}
									<a style="float:right; font-size:13px;" href="myPlan?pageNum=${pageNum}"> 목록보기 </a>
								</th>
							</tr>
							<tr>
								<th style="width:10%; text-align:center;"> 계획명 </th>
								<th style="width:10%; text-align:center;"> 날짜 </th>
								<th style="width:10%; text-align:center;"> 방문 장소 </th>
							</tr>
						</thead>
								
							<tr>
								<td align="center" colspan="3" style="width:100%; height:auto">
									<div style="width:33%; float:left; height:100%; border-right:1px solid ">
										<c:forEach var="list" items="${dto}">
											<div>
												${list.planTitle}
											</div>
										</c:forEach>
									</div>
									
									<div style="width:33%; float:left; border-right:1px solid">
										<c:forEach var="list" items="${dto}">
											<div>
												${list.dday}
											</div>
										</c:forEach>
									</div>
									
									<div style="width:33%; float:left;">
										<c:forEach var="list" items="${dto}">
											<div>
												${list.location_name}
											</div>
										</c:forEach>
									</div>
								</td>	
							</tr>
							<%-- <tr>
								<td colspan="3">
									<a style="float:right; font-size:13px;" href="modifyPlan?planTitle=${planTitle}&planContent=${planContent}&planNo=${planNo}">수정하기 </a>
								</td>
							</tr> --%>						
						</table>
						
						<!-- 페이지 컨트롤 -->
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