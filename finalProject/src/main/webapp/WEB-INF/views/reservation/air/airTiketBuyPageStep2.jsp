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

	<div class="culmn">
		<!--Home page style-->
		<nav
			class="navbar navbar-default navbar-fixed white no-background bootsnav text-uppercase">
			<!-- Start Top Search -->
			<div class="top-search">
				<div class="container">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-search"></i></span>
						<input type="text" class="form-control" placeholder="Search">
						<span class="input-group-addon close-search"><i
							class="fa fa-times"></i></span>
					</div>
				</div>
			</div>
			<!-- End Top Search -->

			<div class="container">
				<!-- Start Atribute Navigation -->
				<div class="attr-nav">
					<ul>
						<li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
					</ul>
				</div>
				<!-- End Atribute Navigation -->

				<!-- Start Header Navigation -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#navbar-menu">
						<i class="fa fa-bars"></i>
					</button>
					<a class="navbar-brand" href="main"> 
					홈<img src="#" class="logo logo-display" alt=""> 
					<img src="#" class="logo logo-scrolled" alt="">
					</a>
				</div>
				<!-- End Header Navigation -->

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="nav navbar-nav navbar-right" data-in="fadeInDown"
						data-out="fadeOutUp">
						<li><a href="plan">계획하기</a></li>
						<li><a href="epilogueList">이야기</a></li>
						<li><a href="where_main">어디갈까</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">예약 </a>
							<ul class="dropdown-menu">
								<li><a href="stayReservation">숙박 예약</a></li>
								<li><a href="airReservation">항공 예약</a></li>
								<li><a href="rentReservation">렌트카 예약</a></li>
							</ul></li>
						<c:if test="${sessionScope.mem_id == null}">
							<li><a href="" data-toggle="modal" data-target="#login">로그인</a></li>
							<li><a href="" data-toggle="modal" data-target="#register">회원가입</a></li>
						</c:if>
						<c:if test="${sessionScope.mem_id != null}">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">${sessionScope.mem_id}님</a>
								<ul class="dropdown-menu">
									<li><a href="plan">계획하기</a></li>
									<li><a href="xxxStart">여행후기</a></li>
									<li><a href="myPageStart">마이페이지</a></li>
								</ul></li>

							<li><a href="logout">로그아웃</a></li>
						</c:if>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>

		</nav>
		<c:if test="${sessionScope.mem_id == null}">
			<%@include file="../../main/modal/loginModal.jsp"%>
			<%@include file="../../main/modal/registerModal.jsp"%>
		</c:if>

		<!--Home Sections-->

		<section id="hello" class="home bg-mega">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="${images}travel/Travel1.jpg" alt="travel1">
						<div class="carousel-caption">
							<h3>New York</h3>
							<p>The atmosphere in New York is lorem ipsum.</p>
						</div>
					</div>

					<div class="item">
						<img src="${images}travel/Travel2.jpg" alt="travel2">
						<div class="carousel-caption">
							<h3>Chicago</h3>
							<p>Thank you, Chicago - A night we won't forget.</p>
						</div>
					</div>

					<div class="item">
						<img src="${images}travel/Travel3.jpg" alt="travel3">
						<div class="carousel-caption">
							<h3>LA</h3>
							<p>Even though the traffic was a mess, we had the best time.</p>
						</div>
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>

		</section>
		<!--End off Home Sections-->

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

	<!--Company section-->
	<section id="company" class="company bg-light">
		<div class="container">
			<div class="row">
				<div class="main_company roomy-100 text-center">
					<h3 class="text-uppercase">동 행</h3>
					<p>가산 다지털 단지 - 한국 소프트웨어 인재 개발원</p>
					<p>
						010 - 1234 - 5678<br> info@poiseidon.lnk
					</p>
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