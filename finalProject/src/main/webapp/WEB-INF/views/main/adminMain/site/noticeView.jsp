<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">

<link rel="stylesheet" href="${css}qnaView.css"/>

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

 
<div id="main">


<br>
<div class="w3-container" >
<!-- 추가 -->
 <center><h3 style="color:#333">글 보기</h3></center> 
<br>
<hr>
<form name="noticeView">	
	<table align="center">
		<tr>
			<th style="width:150px"> 유형 </th>
			<td colspan="5"> ${vo.category}</td>
		</tr>
	
	
		<tr>
			<th style="width:150px"> 글제목</th>
			<td colspan="5"> ${vo.title}</td>
			
		</tr>

		<tr>
			<th style="width:200px"> 작성자</th>
			<td style="width:200px"> ${vo.mem_id}</td>
			
			<th style="width:200px"> 작성일</th>
			<td style="width:200px"> 
				<fmt:formatDate type="both" pattern="yyyy-MM-dd" value="${vo.reg_date}"/>
			</td>
			
			<th style="width:200px"> 조회수</th>
			<td style="width:200px"> ${vo.readcnt}</td>
		</tr>	
		
		
		<tr>
			<th> 글내용</th>
			<td colspan="5"> ${vo.content}</td>
		</tr>
		
	
		<tr>
			<th colspan="6" align="center">
			<!-- jsp 만들 부분  -->
				<input class="w3-btn w3-ripple w3-blue" type="button" value="수정"
					onclick="window.location='updateNoticeView?noticeNo=${vo.noticeNo}&pageNum=${pageNum}'">
				<input class="w3-btn w3-ripple w3-blue" type="button" value="삭제"
					onclick="window.location='deleteNoticePro?noticeNo=${vo.noticeNo}&pageNum=${pageNum}'">	
				<input class="w3-btn w3-ripple w3-blue" type="button" value="답글쓰기"
					onclick="window.location='qnaReplyWrite?noticeNo=${vo.noticeNo}&ref=${vo.ref}&ref_step=${vo.ref_step}&ref_level=${vo.ref_level}'">		
				<input class="w3-btn w3-ripple w3-blue" type="button" value="목록보기"
					onclick="window.location='qnaManage?pageNum=${pageNum}'">
			</th>
		</tr>
	</table>
   
</form>
<!-- 추가 -->

</div>

</div>

	


    


</body>
</html>