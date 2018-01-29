<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>     
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<title>qna 작성</title>
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

<div class="w3-container"><!-- style="width:1000px" -->
<!-- 추가 -->
 <center><h3 style="color:#333">1:1 문의</h3></center> 
<br>
<hr>
<form action="boardWritePro" method="post" name="boardWriteForm" style=" align:center;" onsubmit="contentReplace()"> 
  
   <table align="center">
           <tr>
               <td>문의유형</td>
               	<td>
               	<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
		             <select class="w3-select w3-border" name="kind" style="width:600px;">
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
				      <input readonly="readonly" class="w3-input w3-border" name="mem_id" type="text"  style="width:600px;" value="${sessionScope.mem_id}">
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
				      <textarea class="w3-input w3-border" id="contentBox" style="height:400px; width:600px;" ></textarea>
				      <input type="hidden" id="iuputContent" name="content">
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

</div>

<script type="text/javascript">
	function contentReplace() {
		var str = document.getElementById("contentBox").value;
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br />');
		document.getElementById("iuputContent").value = str;
		return false;
	}
</script>

</body>
</html>