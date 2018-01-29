<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet" href="${css}qnaList.css" />
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>qna 목록</title>
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


	<form action="boardGuestSearchPro" method="POST" name="boardGuestSearchProForm">
			
		<div class="w3-container" style="align: center;">
				<!-- 추가 -->
			<center><h2>QnA</h2></center>
				<hr>

				<table class="w3-table-all" align="center" style="text-align:center; width: 1000px;">
					<thead>
						<tr class="w3-light-grey w3-hover-blue">
							<th width="5%">글번호</th>
							<th width="10%">문의 유형</th>
							<th width="20%">제목</th>
							<th width="5%">조회수</th>
							<th width="5%">답글수</th>
							<th width="20%">작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${qnaList}" varStatus="status">
							<tr class="w3-hover-blue" onclick="boardDetail('${vo.boardNo}','${pageNum}')">
								<td>${status.index+1}</td>
								<td>${vo.kind }</td>
								<td>${vo.title }</td>
								<td>${vo.readCount }</td>
								<td>${vo.answerCount }</td>
								<td>${vo.reg_Date }</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr align="center">
							<td colspan="6" style="text-align: center;">
								<c:if test="${blockStartNumber!=1}">
									<input type="button" value="[◀◀]" onclick="window.location='boardList?requestPage=${startPage}'">
									<input type="button" value="[◀]" onclick="window.location='boardList?requestPage=${blockStartNumber-1}'">
								</c:if>
								<c:forEach var="n" begin="${blockStartNumber}" end="${blockEndNumber}">
									<c:if test="${n!=pageNum}">
										<a href="boardList?requestPage=${n}">${n}</a>
									</c:if>
									<c:if test="${n==pageNum}">
										<b>${n}</b>
									</c:if>
								</c:forEach>
								<c:if test="${blockEndNumber!=endPage}">
									<input type="button" value="[▶]" onclick="window.location='boardList?requestPage=${blockEndNumber+1}'">
									<input type="button" value="[▶▶]" onclick="window.location='boardList?requestPage=${endPage}'">
								</c:if>	
							</td>
						</tr>
						<c:if test="${fn:length(qnaList)==0}">
							<tr>
								<td colspan="11" style="text-align: center;">작성글이 없습니다.</td>
							</tr>
						</c:if>
					</tfoot>
			</table>

			<hr>


			<!-- ** -->
			<div class="w3-row w3-section" align="center">
				<div class="w3-col" style="width: 50px"></div>
				<div class="w3-rest">
		
					<!-- 검색조건1 -->
					<select class="w3-select w3-border" name="selectOpt1" style="width: 200px;">
						<option value="결제">결제</option>
						<option value="숙박">숙박</option>
						<option value="여행">여행</option>
						<option value="예약">예약</option>
						<option value="사이트이용">사이트이용</option>
					</select>
					<!-- 검색조건1 -->
		
		
					<!-- 검색조건2 -->
					<select class="w3-select w3-border" name="selectOpt2" style="width: 200px;">
						<option value="all">전체</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<!-- 검색조건2 -->
		
		
					<!-- 검색 폼*** -->
					<input type="text" class="search" name="searchOpt" id= "searchOpt" placeholder="검색어를 입력해주세요" style="width: 200px;">
					&nbsp;
					<!-- 검색 버튼 -->
					<input class="w3-btn w3-ripple w3-blue" id=searchbtn" onclick="searchClick()" value="검색">
					<!-- 검색 버튼 -->
					<!-- 검색 폼*** -->
					
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
				<!-- 글쓰기 버튼 -->
					<a href="boardWriteForm" class="w3-btn w3-ripple w3-blue" >글쓰기</a>
				<!-- 글쓰기 버튼 -->
					
				</div>
			</div>
			<!-- ** -->

		</div>
	</form>
	<!-- 추가 -->


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
		
		function boardDetail(boardNo,pageNum){
			
			$.ajax({
				url:"increaseCount?boardNo="+boardNo,
				type:"GET",
				success:function(){
					window.location="boardDetail?boardNo="+boardNo+"&requestPage="+pageNum;
				},
				error:function(){
					alert("error");
				}
			})
			
		}
		
		
		// 검색어 입력안할 시
		function searchClick(){
			var searchOpt = $("#searchOpt");
			if(searchOpt.val()=="") {
				alert("검색어를 입력하세요");
				return false;
			}
			else{
				document.boardGuestSearchProForm.submit();
			}
			
		}
			
		
		
	</script>







</body>
</html>