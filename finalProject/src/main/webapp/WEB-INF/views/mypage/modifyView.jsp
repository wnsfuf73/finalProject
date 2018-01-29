<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet" href="${css}updateInfoView.css" />
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
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
$(function() {
	
	$("#btnModifyInfo").click(function() {
		var pwd = document.modifyView.InputPassword.value;
		var rePwd = document.modifyView.reInputPassword.value;
		
		if(pwd==rePwd){
			$("form[name='modifyView']").submit();
		}
		else {
			alert("비밀번호가 다릅니다.");
			return false;
		}
		
	});
	
});
</script>
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

<c:if test="${cnt==1}">
 <div class="w3-container">
		<form action="modifyPro" method="post" name="modifyView" onsubmit="return modifyViewCheck()" enctype="multipart/form-data">
			<table>
				<tr>
					<th>아이디</th>
					<td>
						<input class="input" type="text" name="mem_id" value="${vo.getMem_id()}"  style="width:400px; height:40px;" readonly>
					</td>
				</tr>

				<tr>
					<th>비밀번호</th>
					<td>
						<input class="input" type="password" id="InputPassword" name="password" maxlength="15" value="${vo.getPassword()}" required="required">
					</td>
				</tr>

				<tr>
					<th>비밀번호 확인</th>
					<td>
						<input class="input" type="password" id="reInputPassword" name="password" maxlength="15" value="${vo.getPassword()}" required="required">
						<font name="check" size="2" color="red"></font>
					</td>
				</tr>

				<tr>
					<th>이름</th>
					<td>
						<input class="input" type="text" name="name" id="username" maxlength="20" value="${vo.getName()}" required="required">
					</td>
				</tr>

				<tr>
					<th>이메일</th>
					<td>
						<input class="inputEmail" type="text" id="InputEmail1" name="email1" maxlength="10" value="${vo.getEmail1()}"  required="required"> 
						@ 
						<input class="inputEmail" type="text" id="InputEmail2" name="email2" maxlength="20" value="${vo.getEmail2()}"  required="required">
					</td>
				</tr>

				<tr>
					<th>핸드폰 번호</th>
					<td>
						<input class="inputHp" type="text" id="InputHp1"name="phone1" maxlength="3" value="${vo.getPhone1()}"  required="required">
								-
						<input class="inputHp" type="text" id="InputHp2" name="phone2" maxlength="4" value="${vo.getPhone2()}"  required="required">
								-
						<input class="inputHp" type="text" id="InputHp3" name="phone3" maxlength="4" value="${vo.getPhone3()}"  required="required">
					</td>
				</tr>
				
				
				<tr>
					<th>생년월일</th>
					<td>
						<c:if test="${vo.getBirth()!=null}">
							${vo.getBirth()}
						</c:if>
						<c:if test="${vo.getBirth()==null}">
							<input class="inputBirth" type="date" name="birth" style="width:400px; height:40px;">
						</c:if>
					</td>	
					
				</tr>
				
				
				<tr>
					<th>성별</th>
					<td>
					
						<input class="inputGender" type="radio" name="sex" value="${vo.getSex()}"  required="required" readonly>남자
							&nbsp;&nbsp;&nbsp;
						<input class="inputGender" type="radio" name="sex" value="${vo.getSex()}"  required="required" readonly>여자
						
						<c:if test="${vo.getSex()=='남자'}">
							 <script type="text/javascript">$("input[name='sex']").eq(0).prop("checked",true) </script>
						</c:if>
						<c:if test="${vo.getSex()=='여자'}">
							<script type="text/javascript">$("input[name='sex']").eq(1).prop("checked",true) </script>
						</c:if>	
					
					</td>
				</tr>
				
				<tr>
					<th>등급</th>
					<td>
						<input class="inputGrade" type="text" name="grade" value="${vo.getGrade()}"  style="width:400px; height:40px;" readonly>
					</td>
				</tr>
				
				
				<%-- <tr>
					<th>프로필 사진</th>
					<td>
						<c:if test="${vo.getFaceImg()==null}">
							<input class="inputFaceImg" type="file" id="faceImg" name="faceImg">
						</c:if> 
						
						<c:if test="${vo.getFaceImg()!=null }">
						 	<img src="${images}profile/${vo.getFaceImg()}" style="width:200px; height:100px;">
						 	<input class="inputFaceImg" type="file" name="faceImg" id="faceImg">
						</c:if> 
					</td>
				</tr> --%>

				

				<tr>
					<th>소개</th>
					<td>
						<c:if test="${vo.getIntroduce()==null}">
							<textarea name="introduce" id="InputIntroduce" maxlength="100" style="width:400px; "></textarea>
						</c:if>
						
						<c:if test="${vo.getIntroduce()!=null}">
							<textarea name="introduce" id="InputIntroduce" maxlength="100" style="width:400px;">${vo.getIntroduce()}</textarea>
						</c:if>
					</td>
				</tr>		
			
				<tr>
					<th colspan="2">
						<input class="inputButton" id="btnModifyInfo" type="submit"  value="수정">
						<input class="inputButton" type="reset" value="취소">
						<input class="inputButton" type="button" value="수정취소" onclick="window.history.back(-2)">
					</th> 
				</tr>
			</table>
		</form>
	 </div> 
 </c:if>	
</div>	

 <c:if test="${cnt!=1}">
 	<script type="text/javascript">
		alert("비밀번호가 일치하지 않습니다");
		window.history.back();
	</script>
 </c:if>



</body>
</html>