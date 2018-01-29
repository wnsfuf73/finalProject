<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>    
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet" href="${css}updateInfoForm.css" />
<title>회원 정보 수정</title>
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


 <div class="w3-container">
	<form action="modifyView" method="post" name="modifyView" onsubmit="pwdCheck()">
		<table>
					<br>
						<center><h3 style="color:#333">회원 정보 변경</h3></center>
					<hr>
					<br>

			<tr>
				<td><center><input class="input" type="password" name="password" maxlength="15" placeholder="비밀번호를 입력하세요"></center></td>
				<td><input class="inputButton" type="submit" value="확인"><td>
			</tr>
			
		</table>
	</form>
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