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


</div>
<br>
<div class="w3-container"><!-- style="width:1000px" -->
<!-- 추가 -->
 <center><h3 style="color:#333">공지사항 | QnA</h3></center> 
<br>
<hr>
<!-- NAME : noticeWrite  -->
<form action="qnaReplyWritePro" method="post" name="qnaReplyWrite" style=" align:center;"> <!-- class="w3-container w3-card-4" -->
  
  <input type="hidden" name="noticeNo" value="${noticeNo}">
  <input type="hidden" name="ref" value="${ref}">
  <input type="hidden" name="ref_step" value="${ref_step}">
  <input type="hidden" name="ref_level" value="${ref_level}">
  
   <table align="center">
  <tr>
               <td>문의유형</td>
               	<td>
               	<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
		             <select class="w3-select w3-border" name="category" style="width:600px;">
							<option value="" disabled selected>선택</option>
							<option value="결제">결제</option>
							<option value="숙박">숙박</option>
							<option value="여행">여행</option>
							<option value="예약">예약</option>
							<option value="사이트이용">사이트 이용</option>
					</select>
					</div>
				</div>
				</td>
           </tr>
 
             <tr>
               <td>제목</td>
               <td>
				<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
				      <input class="w3-input w3-border" name="title" type="text"  style="width:600px;">
				    </div>
				</div>
			  </td>
           </tr>
 
          
        	 <tr>
               <td>작성자</td>
               <td>
				<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
				      <input class="w3-input w3-border" name="mem_id" type="text"  style="width:600px;" value="${vo.mem_id}">
				    </div>
				</div>
			  </td>
           </tr>
           
           <tr>
               <td>내용</td>
               <td>
				<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
				      <textarea class="w3-input w3-border" name="content" style="height:400px; width:600px;" ></textarea>
				    </div>
				</div>
			   </td>
           </tr>
          
           <tr>
               <td></td> 
               <td>
				<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
				      <input class="w3-button w3-block w3-section w3-blue w3-ripple" style="width: 200px; margin: 0 auto; position:relative; background-color:#3498DB!important" type="submit" value="등록">
				    </div>
				</div>
				</td>
           </tr>
       </table>
</form>
<!-- 추가 -->

</div>


</body>
</html>