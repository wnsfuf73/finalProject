<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>

<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>비밀번호 찾기</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--Google Fonts link-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}slick.css">
<link rel="stylesheet" href="${css}slick-theme.css">
<link rel="stylesheet" href="${css}animate.css">
<link rel="stylesheet" href="${css}fonticons.css">
<link rel="stylesheet" href="${css}font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.css">
<link rel="stylesheet" href="${css}magnific-popup.css">
<link rel="stylesheet" href="${css}bootsnav.css">
<link rel="stylesheet" href="${css}carousel.css">
<link rel="stylesheet" href="${css}where.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${css}style.css">
<link rel="stylesheet" href="${css}responsive.css" />
<script src="${js}vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	
	$(function() {
		
		$("#btnModifyPwd").click(function() {
			var x = document.findpwdForm.password.value;
			var y = document.findpwdForm.checkNewPassword.value;
			
			if(x==y){
				$("form[name='findpwdForm']").submit();
			}
			else{
				alert("비밀번호가 다릅니다.");
				return false;
			}
			
		});
		
	});	

	
</script>


</head>

<body data-spy="scroll" data-target=".navbar-collapse">


<div style="width:600px; height:400px; margin: 0 auto; position:relative;">
  <div class="w3-container w3-Indigo">
  
    <h4 style="color:white!important; font-weight:normal!important; width:500px!important;">비밀번호 변경</h4>

  </div>
      <br>

  <form class="w3-container" action="modifyPwdProc" method="post" name="findpwdForm" style="align:center; ">
     <p>      
   		<label class="w3-text-black"><b>새 비밀번호</b></label>
    	<input class="w3-input w3-border w3-white" id="newPassword" name="password" type="password" 
    		required="required">
    </p>
    <p>     
    	<label class="w3-text-black"><b>새 비밀번호 확인</b></label>
   		<input class="w3-input w3-border w3-white" name="checkNewPassword" type="password" required="required">
   		<input type="hidden" name="mem_id" value="${mem_id}">
   	</p>
  	<p> <button class="w3-btn w3-Indigo" id="btnModifyPwd" name="btnModifyPwd" value="확인">확인</button></p>
  </form>
</div>


	<br>
		<br>
		<br>

		<section id="company" class="company bg-light">
			<div class="container">
				<div class="row">
					<div class="main_company roomy-100 text-center">
						<h3 class="text-uppercase">동 행</h3>
						<p>가산 다지털 단지 - 한국 소프트웨어 인재 개발원</p>
						<p>010 - 1234 - 5678<br>
						info@poiseidon.lnk</p>
					</div>
				</div>
			</div>
		</section>


		<!-- scroll up-->
		<div class="scrollup">
			<a href="#"><i class="fa fa-chevron-up"></i></a>
		</div>
		<!-- End off scroll up -->


		<footer id="footer" class="footer bg-mega">
			<div class="container">
				<div class="row">
					<div class="main_footer p-top-40 p-bottom-30">
						<div class="col-md-6 text-left sm-text-center">
							<p class="wow fadeInRight" data-wow-duration="1s">
								Made with <i class="fa fa-heart"></i> by <a target="_blank"
									href="http://bootstrapthemes.co">Bootstrap Themes</a> 2016. All
								Rights Reserved
							</p>
						</div>
						<div class="col-md-6 text-right sm-text-center sm-m-top-20">
							<ul class="list-inline">
								<li><a href="">Facebook</a></li>
								<li><a href="">Twitter</a></li>
								<li><a href="">Instagram</a></li>
								<li><a href="">Pinterest</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</footer>
	
</body>
</html>