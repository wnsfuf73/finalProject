<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>     

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet" href="${css}qnaView.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<title>qna 글 보기</title>
</head>
<style>


</style>
<body>

 
<div id="main">

<div class="w3-teal" style="background-color:#333!important">
</div>

<br>
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
			<th colspan="6" style="text-align: right;">
					<input class="w3-btn w3-ripple w3-blue" type="button" value="답글"	
						onclick="answerWrite()">
					<input class="w3-btn w3-ripple w3-blue" type="button" value="돌아가기"
						onclick="returnList()">	
			</th>
		</tr>
	</table>
   
   	<div class="container" id="answerBox" style="display: none; margin-top: 30px;">
   		<div class="row">
   			<div class="col-md-10 col-md-offset-1">
   				<div id="replayBox">
   				
   					<form action="answerWriteProc" method="POST" name="answerWriteForm">
   						<div class="form-group">
						  <label for="inputtitle">답글 제목</label>
						  <input type="text" class="form-control" name="title" id="inputtitle">
						</div>
   						<div class="form-group">
						  <label for="inputContent">내용</label>
						  <textarea class="form-control" rows="5" id="inputContent"></textarea>
						  <input type="hidden" name="content" id="resultContent">
						</div>
						<div align="right">
							<input class="w3-btn w3-ripple w3-blue" type="button" onclick="checkSubmmit()" value="작성하기">
						</div>
						
						<input type="hidden" name="boardNo" value="${vo.boardNo}">
						<input type="hidden" name="kind" value="${vo.kind}">
   					</form>	
   							
    			</div>
   			</div>
   		</div>
   	</div>
   
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
function returnList() {
	window.location="boardManager";
}

function answerWrite() {
	$("#answerBox").css("display","block");
} 

function checkSubmmit() {
	
	var title = document.getElementById("inputtitle").value
	var content = document.getElementById("inputContent").value
	
	if(!title){
		alert("제목을 작성하세요");
		return false;
	}
	
	if(!content){
		alert("답글내용을 작성하세요");
		return false;
	}
	
	var str = document.getElementById("inputContent").value;
	str = str.replace(/(?:\r\n|\r|\n)/g, '<br />');
	document.getElementById("resultContent").value = str;
	alert("답글작성완료");
	document.answerWriteForm.submit();
	return true;
}

	
</script>


</body>
</html>