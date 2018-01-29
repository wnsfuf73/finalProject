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
<style type="text/css">
	table thead tr th{
		text-align: center;
	}
</style>
<script type="text/javascript">

	function noticeDetail(noticeNo) {
		window.location="noticeDetail?noticeNo="+noticeNo;	
	}

	$(document).ready(function(){
		
		
		  $("#noticeInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#noticeListt tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		  
		  $("#qnaInput").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#qnaListt tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			});
	});
	
</script>

</head>

<body>
<!-- 	<h4>QnA 관리</h4> -->
	<div id="main">
		<div style="margin-top: 30px; margin-left: 30px;">
			<center><h2>공지사항  | QnA</h2></center>
			<hr>
		</div>
		
		<div class="w3-container" style="align: center;">
					<div style="margin-left: 100px;"><h3>공지사항</h3></div><br>
					<input class="w3-input w3-border w3-padding" type="text" placeholder="검색어를 입력하세요" id="noticeInput" onkeyup="myNoticeFunction()"
						style="width:1000px; height:30px; margin:0 auto;">	
						
					<br>
					
					<table class="table" align="center" style="text-align:center; width: 1000px;">
						<thead>
							<tr class="w3-light-grey w3-hover-blue">
								<th width="10%">글번호</th>
								<th width="40%">제목</th>
								<th width="15%">조회수</th>
								<th width="20%">작성일</th>
							</tr>
						</thead>
						<tbody id="noticeListt">
							<c:forEach var="vo" items="${noticeList}" varStatus="status">
								<tr class="w3-hover-blue" onclick="noticeDetail('${vo.noticeNo}','${pageNum}')">
									<td>
										${status.index+1}
									</td>
									<td>${vo.title }</td>
									<td>${vo.readCount }</td>
									<fmt:formatDate var="time" value="${vo.reg_Date}" pattern="yyyy-MM-dd HH 시  mm 분"/>
									<td>${time}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr align="center">
								<td colspan="4" style="text-align: center;">
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
							<c:if test="${fn:length(noticeList)==0}">
								<tr>
									<td colspan="11" style="text-align: center;">작성글이 없습니다.</td>
								</tr>
							</c:if>
							<tr>
								<td colspan="4" style="text-align: right;"><a href="noticeWriteForm" class="w3-btn w3-ripple w3-blue" >공지 쓰기</a></td>
							</tr>
						</tfoot>
				</table>
	
		</div>
		
		<div class="w3-container" style="align: center;">
					<div style="margin-left: 100px;"><h3>QnA</h3></div><br>
					
					<input class="w3-input w3-border w3-padding" type="text" placeholder="검색어를 입력하세요" id="qnaInput" onkeyup="myQnaFunction()"
						style="width:1000px; height:30px; margin:0 auto;">
					<br>	
					
					<table class="table" align="center" style="text-align:center; width: 1000px;">
						<thead>
							<tr class="w3-light-grey w3-hover-blue">
								<th width="10%">글번호</th>
								<th width="10%">문의 유형</th>
								<th width="30%">제목</th>
								<th width="15%">조회수</th>
								<th width="15%">답글수</th>
								<th width="20%">작성일</th>
							</tr>
						</thead>
						<tbody id="qnaListt">
							<c:forEach var="vo" items="${boardList}" varStatus="status">
								<tr class="w3-hover-blue" onclick="boardSelectDetail('${vo.boardNo}','${pageNum}')">
									<td>
										${status.index+1}
									</td>
									<td>${vo.kind }</td>
									<td>${vo.title }</td>
									<td id="board_count_${vo.boardNo}">${vo.readCount }</td>
									<td>${vo.answerCount }</td>
									<fmt:formatDate var="time" value="${vo.reg_Date}" pattern="yyyy-MM-dd HH 시  mm 분"/>
									<td>${time}</td>
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
							<c:if test="${fn:length(boardList)==0}">
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
				
					</div>
				</div>
				<!-- ** -->
	
		</div>
	</div>
	<script type="text/javascript">
	
		function boardSelectDetail(boardNo,pageNum){
			
			$.ajax({
				url:"increaseCount?boardNo="+boardNo,
				type:"GET",
				success:function(){
					var x = $("#board_count_"+boardNo).text();
					x = parseInt(x)+1;
					$("#board_count_"+boardNo).html(x);
					
					window.location="boardSelectDetail?boardNo="+boardNo+"&requestPage="+pageNum;
				},
				error:function(){
					alert("error");
				}
			})
			
		}
		
		function noticeDetail(noticeNo,pageNum) {
			
			window.location="noticeDetail?noticeNo="+noticeNo;
			
			
			/* $.ajax({
				url:"noticeDetail?noticeNo="+noticeNo,
				type:"GET",
				success:function(){
					var x = $("#board_count_"+boardNo).text();
					x = parseInt(x)+1;
					$("#board_count_"+boardNo).html(x);
					
					window.location="boardSelectDetail?boardNo="+boardNo+"&requestPage="+pageNum;
				},
				error:function(){
					alert("error");
				}
			}) */
			
		}
		
	</script>
	
	
	
</body>
</html>