<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>     

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet" href="${css}qnaView.css"/>

<title>qna 글 보기</title>
</head>
<style>


</style>
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

<div class="w3-container" ><!-- style="width:1000px" -->
<!-- 추가 -->
 <center><h3 style="color:#333">글 보기</h3></center> 
<br>
<hr>
	
	<table align="center">
	
	
		<tr>
			<th style="width:150px"> 문의 유형</th>
			<td colspan="5"> ${vo.kind}</td>
		</tr>
	
	
		<tr>
			<th style="width:150px"> 글제목</th>
			<td colspan="5"> ${vo.title}</td>
			
		</tr>

		<tr>
			<th style="width:200px"> 작성자</th>
			<td style="width:200px"> ${vo.mem_id}</td>
			
			<th style="width:200px"> 작성일</th>
			<td style="width:200px" align="center"> 
				<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm" value="${vo.reg_Date}"/>
			</td>
			
			<th style="width:200px"> 조회수</th>
			<td style="width:200px"> ${vo.readCount}</td>
		</tr>	
		
		
		<tr>
			<th> 글내용</th>
			<td colspan="5"> ${vo.content}</td>
		</tr>
		
		
		<tr>
			<th colspan="6" >
					<input class="w3-btn w3-ripple w3-blue" type="button" value="삭제"	
						onclick="deleteBoard('${vo.boardNo}','${pageNum}')">
					<input class="w3-btn w3-ripple w3-blue" type="button" value="목록보기"
						onclick="returnList('${pageNum}')">
			</th>
		</tr>
		
		<tr>
			<td colspan="6">
				<c:forEach var="answer" items="${answerList}" varStatus="status">
					
					<div class="w3-container">
					<h4>${answer.title}</h4>
					  <div class="w3-panel w3-border w3-light-grey w3-round-large">
					    <p>${answer.content}</p>
					  </div>
					</div>
					
				</c:forEach>
			</td>
		</tr>
	</table>
			
<!-- 추가 -->

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

/* function modifyBoardForm(boardNo,pageNum){
	window.location="modifyBoardForm?boardNo="+boardNo+"&requestPage="+pageNum;
} */

function deleteBoard(boardNo,pageNum){
	window.location="deleteBoard?boardNo="+boardNo+"&requestPage="+pageNum;
}
	
function returnList(pageNum){
	window.location="boardList?requestPage="+pageNum;
}
	
</script>


</body>
</html>