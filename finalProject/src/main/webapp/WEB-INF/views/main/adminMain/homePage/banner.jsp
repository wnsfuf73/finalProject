<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}qnaList.css" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div id="main">

		<br>
		
			
			<div class="w3-container" style="align: center;">
				<!-- 추가 -->
				<center><h2>배너관리</h2></center>
				<hr>

				<table class="w3-table-all" align="center" style="width: 1200px;">
					<thead>
						<tr class="w3-light-grey w3-hover-blue">
							<th>번호</th>
							<th>이미지</th>
							<th>배너명</th>
							<th>배너설명</th>
							<th>배너위치</th>
							<th>URL</th>
							<th>관리</th>
						</tr>
					</thead>
					
				<!-- 게시글이 있으면 -->
					<c:if test="${cnt>0}" >
						<c:forEach var="vo" items="${vos}">
							<tr class="w3-hover-blue">
								
								<td align="center">
									${number}
									<c:set var="number" value="${number-1}"/>
								</td>
								
								<!-- 이미지  -->
								<td align="center">
									<img src="${images}banner/${vo.bannerImg}" style="width:100px; height:100px;">
								</td>
								
			

								<!-- 배너명 -->
								<td align="center">
									${vo.bannerName}
								</td>
								
								<!-- 배너설명 -->
								<td align="center">
									${vo.bannerContent}
								</td>
								
								
								<!-- 배너위치 -->
								<td align="center">
									${vo.bannerLocation}
								</td>
								
								
								<!-- URL  -->
								<td align="center">
									${vo.bannerLink} 
								</td>	
								
								<!-- 관리 -->
								<td align="center">
									<input class="w3-btn w3-ripple w3-indigo" type="button" value="수정"
										onclick="window.location='updateBannerView?bannerNo=${vo.bannerNo}&pageNum=${pageNum}'">	
									<input class="w3-btn w3-ripple w3-indigo" type="button" value="삭제"
										onclick="window.location='deleteBannerPro?bannerNo=${vo.bannerNo}&pageNum=${pageNum}'">										
								</td>					
							
							</tr>
						</c:forEach>
					</c:if>

					<!-- 배너글이 없으면 -->
					<c:if test="${cnt==0 || cnt==null}">
						<tr>
							<td colspan=7" align="center">
								배너글이 없습니다. 글을 작성해 주세요.
							</td>
						</tr>
					</c:if>
			</table>
			
	<!-- 페이지 컨트롤   -->
	<table align="center">
		<th align="center">
			<c:if test="${cnt>0}">
				<!-- 처음[◀◀] / 이전블록[◀] -->
				<c:if test="${startPage > pageBlock}"> 
					<a href="banner">[◀◀]</a> <!-- 첫페이지  -->
					<a href="banner?pageNum=${startPage - pageBlock}">[◀]</a>
				</c:if>
				
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i==currentPage}">
						<span><b>[${i}]</b></span>
					</c:if>
					
					<c:if test="${i!=currentPage}">
						<a href="banner?pageNum=${i}">[${i}]</a>
					</c:if>				
				</c:forEach>
				
				<!-- 다음블록[▶] / 끝 [▶▶] -->
			<c:if test="${pageCount>endPage}">
				<a href="banner?pageNum=${startPage + pageBlock}">[▶]</a>
				<a href="banner?pageNum=${pageCount}">[▶▶]</a>
			</c:if>
		</c:if>	
			
		</th>
	</table>			

				<hr>


				<!-- ** -->
				<div class="w3-row w3-section" align="center">
					<div class="w3-col" style="width: 50px"></div>
					<div class="w3-rest">

						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
					<!-- 배너등록 버튼 -->
						<a href="registerBanner" class="w3-btn w3-ripple w3-blue">배너등록</a>
					<!-- 배너등록 버튼 -->
						
					</div>
				</div>
				<!-- ** -->

			</div>
			<!-- 추가 -->
	</div>
</body>
</html>