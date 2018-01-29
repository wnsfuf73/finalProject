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
<!-- 	<h4>QnA 관리</h4> -->
	
<div id="main">

		<br>
		
		<form action="qnaSearchPro" method="post" name="qnaList">
			
			<div class="w3-container" style="align: center;">
				<!-- 추가 -->
				<center><h2>공지사항 | QnA</h2></center>
				<hr>

				<table class="w3-table-all" align="center" style="width: 1000px;">
					<thead>
						<tr class="w3-light-grey w3-hover-blue">
							<th>번호</th>
							<th>문의 유형</th>
							<th>제목</th>
							<th>아이디</th>
							<th>작성일</th>
							<th>조회수</th>
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
								
								<!-- 문의 유형  -->
								<td align="center">
									${vo.category}
								</td>
								
								<td>
									 <!-- 추가 부분 -->
									 <c:if test="${vo.ref_level>1}"> <!-- 들여쓰기 > 1  -->
									 	<c:set var="wid" value="${(vo.ref_level-1) * 10}" /> <!-- dto.ref_level : 공백 -->
										<img src="${images}qna/level.gif" border="0" width="${wid}" height="15">
									 </c:if>
									 
									 <!-- 들여쓰기 > 0 : 답변글  -->
									 <c:if test="${vo.ref_level > 0}">
									 	 <img src="${images}qna/re.gif" border="0" width="20" height="15">
									 </c:if>
									 
									 <!-- 추구 부분 end -->
									 <!-- 글제목  -->
									<a href="noticeView?noticeNo=${vo.noticeNo}&pageNum=${pageNum}&number=${number+1}">${vo.title} </a>
									
									<!-- hot 이미지 추가 -->
									<c:if test="${vo.readcnt>10}">
										<img src="${images}qna/hot.gif" border="0" width="20" height="15">
									</c:if>								
								</td>
	

								<!-- 작성자 -->
								<td align="center">
									${vo.mem_id}
								</td>
								

								
								<!-- 작성일 -->
								<td align="center">
									<fmt:formatDate type="both" pattern="yyyy-MM-dd" value="${vo.reg_date}"/>			
								</td>
								
								
								<!-- 조회수  -->
								<td align="center">
									${vo.readcnt} 
								</td>							
							
							</tr>
							</c:forEach>
					</c:if>

					<!-- 게시글이 없으면 -->
					<c:if test="${cnt==0 || cnt==null}">
						<tr>
							<td colspan="6" align="center">
								게시글이 없습니다. 글을 작성해 주세요.
							</td>
						</tr>
					</c:if>
			</table>
			
	<!-- 페이지 컨트롤 재고관리,  <table style="width:1000px" align="center"> -->
	<table align="center">
		<th align="center">
			<c:if test="${cnt>0}">
				<!-- 처음[◀◀] / 이전블록[◀] -->
				<c:if test="${startPage > pageBlock}"> 
					<a href="qnaManage">[◀◀]</a> <!-- 첫페이지  -->
					<a href="qnaManage?pageNum=${startPage - pageBlock}">[◀]</a>
				</c:if>
				
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i==currentPage}">
						<span><b>[${i}]</b></span>
					</c:if>
					
					<c:if test="${i!=currentPage}">
						<a href="qnaManage?pageNum=${i}">[${i}]</a>
					</c:if>				
				</c:forEach>
				
				<!-- 다음블록[▶] / 끝 [▶▶] -->
			<c:if test="${pageCount>endPage}">
				<a href="qnaManage?pageNum=${startPage + pageBlock}">[▶]</a>
				<a href="qnaManage?pageNum=${pageCount}">[▶▶]</a>
			</c:if>
		</c:if>	
			
		</th>
	</table>			

				<hr>


				<!-- ** -->
				<div class="w3-row w3-section" align="center">
					<div class="w3-col" style="width: 50px"></div>
					<div class="w3-rest">

						<!-- 검색조건1 -->
						<select class="w3-select w3-border" name="selectOpt1" style="width: 200px;">
							<option value="" disabled selected>선택</option>
							<option value="결제">결제</option>
							<option value="숙박">숙박</option>
							<option value="여행">여행</option>
							<option value="예약">예약</option>
							<option value="사이트 이용">사이트 이용</option>
						</select>
						<!-- 검색조건1 -->


						<!-- 검색조건2 -->
						<select class="w3-select w3-border" name="selectOpt2" style="width: 200px;">
							<option value="" disabled selected>선택</option>
							<option value="all">전체</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
						</select>
						<!-- 검색조건2 -->


						<!-- 검색 폼*** -->
						<input type="text" class="search" name="searchOpt" placeholder="검색어를 입력해주세요" style="width: 200px;">
						&nbsp;
						<!-- 검색 버튼 -->
						<input class="w3-btn w3-ripple w3-blue" type="submit" value="검색">
						<!-- 검색 버튼 -->
						<!-- 검색 폼*** -->
						
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
					<!-- 글쓰기 버튼 -->
						<a href="noticeWrite" class="w3-btn w3-ripple w3-blue" >공지 쓰기</a>
					<!-- 글쓰기 버튼 -->
						
					</div>
				</div>
				<!-- ** -->

			</div>
			<!-- 추가 -->
			</form>
	</div>
</body>
</html>