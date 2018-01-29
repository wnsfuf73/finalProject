<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>

<html class="no-js" lang="en" style="overflow-y:scroll">
<head>
<meta charset="utf-8">
<title>Pouseidon - Free HTML5 Model Agency Bootstrap Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="-1"/>

<link rel="icon" type="image/png" href="favicon.ico">

<!--Google Fonts link-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">

<link rel="stylesheet" href="${css}slick.css">
<link rel="stylesheet" href="${css}slick-theme.css">
<link rel="stylesheet" href="${css}animate.css">
<link rel="stylesheet" href="${css}fonticons.css">
<link rel="stylesheet" href="${css}font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.css">
<link rel="stylesheet" href="${css}magnific-popup.css">
<link rel="stylesheet" href="${css}bootsnav.css">
<link rel="stylesheet" href="${css}carousel.css">
<link rel="stylesheet" href="${css}kwak.css">
<link rel="stylesheet" href="${css}wrtcss/essay.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<!--For Plugins external css-->
<!--<link rel="stylesheet" href="${css}plugins.css" />-->

<!--Theme custom css -->
<link rel="stylesheet" href="${css}style.css">
<!--<link rel="stylesheet" href="${css}colors/maron.css">-->

<!--Theme Responsive css-->
<link rel="stylesheet" href="${css}responsive.css" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script src="${js}vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

<script src="//code.jquery.com/jquery.min.js"></script> <!-- 제이쿼리 1.x 최신 버전 로드 -->

<!-- 별 -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="${js}review/jquery.raty.js"></script>
<script type="text/javascript">

</script>
</head>

<body data-spy="scroll" data-target=".navbar-collapse">
<div>
<!-- <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
	source.uhoon.co.kr
	<ins class="adsbygoogle"
		 style="display:inline-block;width:468px;height:60px"
		 data-ad-client="ca-pub-4169082997566429"
		 data-ad-slot="5725636632"></ins>
	<script>
	(adsbygoogle = window.adsbygoogle || []).push({});
</script> -->

</div>

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


		<nav class="navbar navbar-default navbar-fixed white no-background bootsnav text-uppercase"
				style="background:#32546B">
			

			<div class="container">
			

				<!-- Start Header Navigation -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#navbar-menu">
						<i class="fa fa-bars"></i>
					</button>
					<a class="navbar-brand" href="main"> 
						홈<img src="#" class="logo logo-display" alt=""> 
						<img src="#"class="logo logo-scrolled" alt="">
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
							</ul>
						</li>
					<c:if test="${sessionScope.mem_id == null}">					
						<li><a href="" data-toggle="modal" data-target="#login">로그인</a></li>
						<li><a href="" data-toggle="modal" data-target="#register">회원가입</a></li>
					</c:if>
					<c:if test="${sessionScope.mem_id != null}">
						<li class="dropdown">
						<a class="dropdown-toggle"
							data-toggle="dropdown" href="#">${sessionScope.mem_id}님</a>
							<ul class="dropdown-menu">
								<li><a href="plan">계획하기</a></li>
								<li><a href="">여행후기</a></li>
								<li><a href="myPageStart">마이페이지</a></li>
							</ul>
						</li>
								
						<li><a href="logout" >로그아웃</a></li>
					</c:if>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>

		</nav>
		
		<!-- 리뷰 -->
		
		<div id="essayContent">
			<div id="review_in_content">
				<div id="review_container">
					<div class="review_title_zone">
						리뷰쓰기
					</div>
					<form name="review" method="post" action="reviewPro" enctype="multipart/form-data">
						<div class="review_bottom">
							<ul class="find_place">
								<li class="find_place_logo">여행지 찾기</li>
								<li class="find_place_logo_input">
									<input type="text" id="review_find" data-target="#search" data-toggle="modal" name="searchcontent">
									<input type="hidden" name="location_num" value="location_num">
									<a id="place_find" data-target="#search" data-toggle="modal"></a>
								</li>
							</ul>
							<div>
								<ul>
									<li class="log_type">이 장소에 대한 나의 평가는?</li>
									<li>
										<div class="rating_section">
											<ul>
												<li class="viewimg"><div id="star1" style="width:150px"></div></li>
												<li class="funimg"><div id="star2" style="width:150px"></div></li>
												<li class="nearimg"><div id="star3" style="width:150px"></div></li>
												<li class="priceimg"><div id="star4" style="width:150px"></div></li>
											</ul>
										</div>
										<div class="review_avg">
											<span id="avg"><span id="displayStarRating" name="reviewAvg"></span></span>
										</div>
									</li>
									<li class="review_text"><b>내용입력</b></li>
									<li>
										<textarea class="review_textarea" id="review_text1" name="review_text" maxlength="1000" 
											placeholder="소감, Tip, 좋은점, 문제점 등 (1000자 이내)" style="overflow: hidden;
											word-wrap: break-word; height: 100px;"></textarea>
									</li>
									<li>
										<div>
											<div class="insert_image">
												<input type="file" class="upload" id="imgFile" name="simg" multiple="true">
											</div>
											<ul>
												<li class="review_img">이미지등록</li>
												<li>
													<div class="add_image">
														
													</div>
												</li>
											</ul>
										</div>
									</li>
									<li class="date_logo">다녀온 날짜</li>
									<li>
										<input type="date" id="review_date1" name="review_date">
									</li>
									<li style="text-align:center">
										<input type="submit" id="review_button" class="button" value="저장">
									</li>
								</ul>
								<input type="hidden" name="view" value="0">
								<input type="hidden" name="fun" value="0">
								<input type="hidden" name="near" value="0">
								<input type="hidden" name="price" value="0">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		


		<!-- scroll up-->
		<div class="scrollup">
			<a href="#"><i class="fa fa-chevron-up"></i></a>
		</div>
		<!-- End off scroll up -->

	</div>

	<!-- JS includes -->
	<script src="${js}vendor/bootstrap.min.js"></script>

	<script src="${js}isotope.min.js"></script>
	<script src="${js}jquery.magnific-popup.js"></script>
	<script src="${js}jquery.easing.1.3.js"></script>
	<script src="${js}slick.min.js"></script>
	<script src="${js}jquery.collapse.js"></script>
	<script src="${js}bootsnav.js"></script>

	<script src="${js}plugins.js"></script>
	<script src="${js}main.js"></script>
	
	
	<!-- 모달 추가 시작 login -->
	<div class="row">
		<div class="modal" id="login" tabindex="-1"  >
			<!-- #model로 지정했으므로 id="model" -->
			<div class="modal-dialog" style="z-index:9999">
				<div class="modal-content">
					<div class="modal-header">
						로그인
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					
					<div class="modal-body" style="text-align: center;">
					<center><img src="${images}/Login.png"></center>
						<form id="login-form" action="login" method="post" role="form" style="display: block;">
							
							<div class="form-group">
								<input type="text" name="mem_id" id="userId" tabindex="1" class="form-control" placeholder="아이디" value="">
							</div>
							
							<div class="form-group">
								<input type="password" name="password" id="userPassword" tabindex="2" class="form-control" placeholder="비밀번호" value="">
							</div>
							
							<div class="form-group">
								<div class="row">
									<div class="col-sm-6 col-sm-offset-3">
										<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="btn btn-success" value="로그인">
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<div class="row">
									<div class="col-lg-12">
										<div class="text-center">
											<a href="findIdAndPwd" tabindex="5" class="forgot-password"> 아이디 | 비밀번호 찾기</a>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>	
<!-- 모달 추가 종료 login-->		
		
		
<!-- 모달 추가 시작 register -->
	<div class="row">
		<div class="modal" id="register" tabindex="-1">
			<!-- #model로 지정했으므로 id="model" -->
			<div class="modal-dialog" style="z-index:9999">
				<div class="modal-content" style="height:950px">
					<div class="modal-header">
						회원가입
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" style="text-align: center;">
		
			<!-- 회원가입 -->
			<div class="col-md-12">
				<form role="form" action="register" method="post" role="form" style="display: block;">
					<div class="form-group">
						<label for="username">사용자 이름</label> 
						<input type="text" class="form-control" id="username" placeholder="이름을 입력해 주세요" name="name">
					</div>

					<div class="form-group">
						<label for="InputId">아이디</label> 
						<input type="text" class="form-control" id="InputId" placeholder="아이디(영문+숫자/6~15이내)" required="required" name="mem_id" onchange="checkId()">
					</div>

					<div class="form-group">
						<label for="InputPassword1">비밀번호</label> 
						<input type="password" class="form-control" id="InputPassword1" placeholder="비밀번호(영문+숫자/6~15이내)" required="required" name="password">
					</div>

					<div class="form-group">
						<label for="InputPassword2">비밀번호 확인</label> 
						<input type="password" class="form-control" id="InputPassword2" placeholder="비밀번호 확인" required="required"  name="password" onchange="checkPwd()">
					</div>

					<div class="form-group">
						<label for="InputEmail">이메일 주소</label> 
						<input type="email" class="form-control" id="InputEmail" placeholder="E-Mail(비밀번호 분실 시 필요합니다)" required="required" name="email">
					</div>

					<div class="form-group">
						<label for="InputBirthday">생년월일</label> 
						<input type="date" class="form-control" id="InputBirthday" placeholder="생년월일을 선택해 주세요" required="required" name="birth">
					</div>

					<div class="form-group">
						<label for="InputGender">성별</label>&nbsp;&nbsp;&nbsp; 
						<label> <input name="sex" type="radio" value="Male" checked> 남자  </label>
						&nbsp;&nbsp;&nbsp; 
						<label><input name="sex" type="radio" value="Female"> 여자</label>
					</div>

					<div class="form-group">
						<label for="username">휴대폰 인증</label>
						<div class="input-group">
							<input type="tel" class="form-control" id="InputHp" placeholder="- 없이 입력해 주세요" name="phone"> <!-- username -->
							<span class="input-group-btn">
								<button class="btn btn-success">
									인증번호 전송<i class="fa fa-mail-forward spaceLeft"></i>
								</button>
							</span>
						</div>
					</div>

					<div class="form-group">
						<label for="username">인증번호 입력</label>
						<div class="input-group">
							<input type="text" class="form-control" id="InputReHp" placeholder="인증번호"> <span class="input-group-btn"> <!-- id="username" -->
								<button class="btn btn-success">
									인증번호 입력<i class="fa fa-edit spaceLeft"></i>
								</button>
							</span>
						</div>
					</div>

					<div class="form-group">
						<label>약관 동의</label>
						<div data-toggle="buttons">
							<label class="btn btn-primary active"> 
							<span class="fa fa-check"></span> 
							<input id="agree" type="checkbox" autocomplete="off" checked>
							</label> <a href="#">이용약관</a>에 동의합니다.
						</div>
					</div>

					<div class="form-group text-center">
						<button type="submit" id="signupbtn" class="btn btn-info" >회원가입<i class="fa fa-check spaceLeft"></i></button>
						<button type="reset" class="btn btn-warning">가입취소<i class="fa fa-times spaceLeft"></i></button>
					</div>

				</form>
				</div>
				<!-- 회원가입 종료 -->
					</div>
				</div>
			</div>
		</div>
	</div>		
	<!-- 모달 추가 종료 register -->	
	<!-- 리뷰장소검색 모달 -->
	<div class="row">
		<div class="modal" id="search" tabindex="-1">
			<div class="modal-dialog" style="z-index:9999">
				<div class="modal-content">
					<div class="modal-header">여행지 검색
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" style="text-align: center;">
						<form id="review_search_form" action="reviewSearchPro" method="post" style="display: block;">
							<div class="search_div">
								<input type="text" id="reviewSearch" name="searchContent">
								<a id="reviewSearcha"></a>
							</div>
							<div class="place_line"></div>
							
							<div class="modal_review_search" id="searchResult"></div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
<!-- 별점 -->
<script type="text/javascript">
	/* 별점 */
	$(function() {

		$('div#star1').raty({
			path : "/project/resources/images/review"
			,width : 200
			,click: function(score1, evt) {
				var score2 = $('div#star2 input[type=hidden]').val();
				var score3 = $('div#star3 input[type=hidden]').val();
				var score4 = $('div#star4 input[type=hidden]').val();
				
				if(score1 != 0){
					$("#displayStarRating").html(score1);
				}
				if(score2 != 0){
					var avg= (parseFloat(score1) +parseFloat(score2))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score3 != 0){
					var avg= (parseFloat(score1) +parseFloat(score3))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score4 != 0){
					var avg= (parseFloat(score1) +parseFloat(score4))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score2 != 0 && score3 !=0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score3))/3.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score2 != 0 && score4 !=0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score4))/3.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score2 != 0 && score3 !=0 && score4 != 0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score3) + parseFloat(score4))/4.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
			
				document.review.view.value=score1;
			}
		
			
		});
		
		$('div#star2').raty({
			
			path : "/project/resources/images/review"
			,width : 200
			,click: function(score2, evt) {
				var score1 = $('div#star2 input[type=hidden]').val();
				var score3 = $('div#star3 input[type=hidden]').val();
				var score4 = $('div#star4 input[type=hidden]').val();
				
				if(score2 != 0){
					$("#displayStarRating").html(score2);
				}
				if(score1 != 0){
					var avg= (parseFloat(score1) +parseFloat(score2))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score3 != 0){
					var avg= (parseFloat(score2) +parseFloat(score3))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score4 != 0){
					var avg= (parseFloat(score2) +parseFloat(score4))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score1 != 0 && score3 !=0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score3))/3.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score1 != 0 && score4 !=0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score4))/3.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score1 != 0 && score3 !=0 && score4 != 0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score3) + parseFloat(score4))/4.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				document.review.fun.value=score2;
			}
		});
		
		$('div#star3').raty({
			
			path : "/project/resources/images/review"
			,width : 200
			,click: function(score3, evt) {
				var score1 = $('div#star2 input[type=hidden]').val();
				var score2 = $('div#star3 input[type=hidden]').val();
				var score4 = $('div#star4 input[type=hidden]').val();
				
				if(score3 != 0){
					$("#displayStarRating").html(score3);
				}
				if(score1 != 0){
					var avg= (parseFloat(score1) +parseFloat(score3))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score2 != 0){
					var avg= (parseFloat(score3) +parseFloat(score2))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score4 != 0){
					var avg= (parseFloat(score3) +parseFloat(score4))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score1 != 0 && score2 !=0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score3))/3.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score1 != 0 && score4 !=0){
					var avg= (parseFloat(score1) + parseFloat(score4) + parseFloat(score3))/3.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score1 != 0 && score2 !=0 && score4 != 0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score3) + parseFloat(score4))/4.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				document.review.near.value=score3;
			}
		});
		
		$('div#star4').raty({
		
			path : "/project/resources/images/review"
			,width : 200
			,click: function(score4, evt) {
				var score1 = $('div#star2 input[type=hidden]').val();
				var score2 = $('div#star3 input[type=hidden]').val();
				var score3 = $('div#star4 input[type=hidden]').val();
				
				if(score4 != 0){
					$("#displayStarRating").html(score4);
				}
				if(score1 != 0){
					var avg= (parseFloat(score1) +parseFloat(score4))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score2 != 0){
					var avg= (parseFloat(score4) +parseFloat(score2))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score3 != 0){
					var avg= (parseFloat(score4) +parseFloat(score3))/2.0;

					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score1 != 0 && score2 !=0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score4))/3.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score1 != 0 && score3 !=0){
					var avg= (parseFloat(score1) + parseFloat(score3) + parseFloat(score4))/3.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score2 != 0 && score3 !=0){
					var avg= (parseFloat(score2) + parseFloat(score3) + parseFloat(score4))/3.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				if(score1 != 0 && score2 !=0 && score3 != 0){
					var avg= (parseFloat(score1) + parseFloat(score2) + parseFloat(score3) + parseFloat(score4))/4.0;
	
					$("#displayStarRating").html(avg.toFixed(1));
				}
				document.review.price.value=score4;
			}
		});
	});
	
	
	/* 검색결과 */
	$(document).ready(function() {
		$('#reviewSearcha').click(function() {
			
			var reviewSearch = $("input[name='searchContent']").val();
			
			$.ajax({
				url:"reviewSearch?reviewSearch="+reviewSearch,
				type:'GET',
				
				success:function(msg){
					/* $('#modal_review_search').html(msg); */
					/* for(var i=0; i<msg.length; i++){ */
					/* alert(msg[i].location_name); */
					$('#searchResult').html(msg);	
				},
				error:function(){
					alert('오류');
				}
			});
			
		});		
	});
	
</script>
</html>