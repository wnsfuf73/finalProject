<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>

<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>동행... 당신의 이야기</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="favicon.ico">

<!--Google Fonts link-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i"
	rel="stylesheet">

<link rel="stylesheet" href="${css}slick.css">
<link rel="stylesheet" href="${css}slick-theme.css">
<link rel="stylesheet" href="${css}animate.css">
<link rel="stylesheet" href="${css}fonticons.css">
<link rel="stylesheet" href="${css}font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.css">
<link rel="stylesheet" href="${css}magnific-popup.css">
<link rel="stylesheet" href="${css}bootsnav.css">
<link rel="stylesheet" href="${css}carousel.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${css}style.css">
<link rel="stylesheet" href="${css}responsive.css" />

<script src="${js}vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



<script type="text/javascript">
	
 	function paymentProc(){
		
		var form = document.radioForm;
 		var radioLength = form.payRadio.length;
 		 
	 	for (i=0;i<radioLength ;i++){
	 		if(form.payRadio[i].checked == true){
	 			document.airResProcForm.payMethod.value = form.payRadio[i].value;
	 			break;
	 		}
	 	}
 		
 		if(radioLength == i){
 			alert("결제수단선택하세요");
 			return false;
 		}
 		
 		if(! ( $("#permitCheck").prop("checked") )){
 			alert("동의하세요");
 			return false;
 		}
 		
 		$("form[name='airResProcForm']").submit();
 	}
	
</script>


</head>

<body data-spy="scroll" data-target=".navbar-collapse">

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

		<%@include file="../../main/sample/header.jsp" %>

		<!-- 본문내용 작성자 : 유준렬 -->
		<br>

		<div class="container">

			<div class="row">
				<div class="col-md-12">
					<center>
						<img src="${images }air/reserImg.png">
					</center>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
					<br><br>
					<div class="well well-lg" style="background-color: white">
						
						<h4><span class="glyphicon glyphicon-ok" aria-hidden="true">결제정보</span></h4>
						<hr style="border: 2px solid #98b9ca;">
							<div class="well well-lg">
							
								<form name="radioForm" class="form-inline">
									  <div class="form-group">
									    <input type="radio" name="payRadio" value="계좌이체">&nbsp;계좌이체 
									  </div>
									  <div class="form-group">
									  	<input type="radio" name="payRadio" value="신용카드">&nbsp;신용카드 
									  </div>
									  <div class="form-group">
									  	 <input type="radio" name="payRadio" value="무통장입금">&nbsp;무통장입금 
									  </div>
									  <div class="form-group">
									  	 <input type="radio" name="payRadio" value="휴대폰">&nbsp;휴대폰 
									  </div>
								</form> 
								
							</div>
						<div class="container">
							<div class="col-md-12">
							<form class="form-inline" action="/action_page.php">
							  <div class="form-group">
							    <label for="name">결제자 이름 : </label>
							    <input type="text" class="form-control" id="name" >
							  </div>
							  <div class="form-group">
							    <label for="tel">연락처 : </label>
							    <input type="tel" class="form-control" id="tel" >
							  </div>
							   <div class="form-group">
							  	<label for="email">이메일 : </label>
							    <input type="email" class="form-control" id="email" >
							   </div>
							</form>

							</div>
						</div>
						<div class="well well-lg" style="background-color: #e3e2e7">
							<ul class='list-inline'>
							  <li><div class="checkbox"><input type="checkbox" id="permitCheck">&nbsp;<b>주문 개인정보 수집동의</b></div></li>
							</ul>
						</div>
						<div class="container">
							<div class="col-md-12 col-md-offset-6">
	  							<div class="center-block" style="width: auto;">
									<img alt="결제하기" src="${images }air/airpaymentImg.png" onclick="paymentProc()">
								
									<form style="display: none;" action="airResProc" method="POST" name="airResProcForm">
										<input type="hidden" name="airPlaneNo" value="${vo.airPlaneNo }">
										<input type="hidden" name="startLocation" value="${vo.startLocation }">
										<input type="hidden" name="endLocation" value="${vo.endLocation }">
										<input type="hidden" name="price" value="${vo.price }">
										<input type="hidden" name="seatLevel_adult" value="${vo.seatLevel_adult }">
										<input type="hidden" name="seatLevel_student" value="${vo.seatLevel_student }">
										<input type="hidden" name="seatLevel_baby" value="${vo.seatLevel_baby }">
										<input type="hidden" name="adult" value="${vo.adult }">
										<input type="hidden" name="student" value="${vo.student }">
										<input type="hidden" name="baby" value="${vo.baby }">
										<input type="hidden" name="memSize" value="${vo.adult+vo.student+vo.baby }">
										<input type="hidden" name="mem_id" value="${sessionScope.mem_id }">
										<input type="hidden" name="startTime" value="${startTime }">
										<input type="hidden" name="endTime" value="${endTime }">
										<input type="hidden" name="payMethod">
									</form>
								</div>
							</div>
						</div>
					</div>
				
				</div>
			</div>
		</div>
		
		<!-- 
		
	<!-- 본문내용 작성자 : 유준렬 -->

	<%@include file="../../main/sample/footer.jsp" %>


	<!-- JS includes -->
	<script src="${js}vendor/jquery-1.11.2.min.js"></script>
	<script src="${js}vendor/bootstrap.min.js"></script>
	<script src="${js}isotope.min.js"></script>
	<script src="${js}jquery.magnific-popup.js"></script>
	<script src="${js}jquery.easing.1.3.js"></script>
	<script src="${js}slick.min.js"></script>
	<script src="${js}jquery.collapse.js"></script>
	<script src="${js}bootsnav.js"></script>
	<script src="${js}plugins.js"></script>
	<script src="${js}main.js"></script>

</body>
</html>