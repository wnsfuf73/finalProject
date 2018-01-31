<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>

<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>계획하기</title>
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
<link rel="stylesheet" href="${css}kwak.css">
<link rel="stylesheet" href="${css}kwakmypage.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<!--For Plugins external css-->
<!--<link rel="stylesheet" href="${css}plugins.css" />-->

<!--Theme custom css -->
<link rel="stylesheet" href="${css}style.css">
<!--<link rel="stylesheet" href="${css}colors/maron.css">-->

<!--Theme Responsive css-->
<link rel="stylesheet" href="${css}responsive.css" />

<script src="${js}vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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
						<img src="#"class="logo logo-scrolled" alt="">
					</a>
				</div>
				<!-- End Header Navigation -->

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="nav navbar-nav navbar-right" data-in="fadeInDown"
						data-out="fadeOutUp">
						<!-- <li><a href="plan">계획하기</a></li> -->
						<li><a href="epilogueList">이야기</a></li>
						<li><a href="where_main">어디갈까</a></li>
						<!-- <li><a href="recomandStart">추천여행기</a></li> -->
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
									<li><a href="myPageStart">마이페이지</a></li>
									<li><a href="logout" >로그아웃</a></li>
								</ul>
							</li>
						</c:if>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>

		</nav>
		<c:if test="${sessionScope.mem_id == null}">
			<%@include file="../main/modal/loginModal.jsp"%>	
			<%@include file="../main/modal/registerModal.jsp"%>
		</c:if>
		<!-- ================메인  HEAD화면================= -->
		<section class="plan_head">
			<div id="head" class="main_head">
				<div class="head_wrap">
					<div class="head_title">
						일정을 같이 계획해 보아요.
					</div>
					<div class="head_img">
						<div class="head_img1">
						<img src="${images}plan/head/bag.jpg">
						</div>
						<div class="head_img2">
							<img src="${images}plan/head/plane.jpg">
						</div>
						<div class="head_img3">
							<img src="${images}plan/head/car.jpg">
						</div>
					</div>
					<div class="clear">
					</div>
					<div class="head_button_box">
						<a href="makeplan" class="head_button">
							<div class="head_button_in">
								<img alt="" src="${images}plan/head/calendar.png">
								<span>일정 만들기</span>
								<div class="clear"></div>
							</div>
						</a>
						<a href="myPagePlan" class="head_button">
							<div class="head_button_in">
								<img alt="" src="${images}plan/head/search.png">
								<span>나의 일정보기</span>
								<div class="clear"></div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<div class="clear"></div><br />
			<div class="container-fluid">
				<div class="row">
					<div class="plan_title">
						<h4>
						<span class="glyphicon glyphicon-flag" style="font-size: 20px;">
							<b>다른 사람들은 어떻게 계획을 세웠을까?</b>
						</span>
						</h4>
					</div>
				</div>
			</div>
			<!-- 다른 사람들 일정보기 -->
			<div id="plan_content">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-1"></div>
							<div class="col-md-10">
								<div>
									<table style="width:100%; text-align:center;" class="review_table">
									<thead>
										<tr>
											<th colspan="6" style="height:25px; text-align:center;">
												글목록(글개수 : ${cnt})							
											</th>
										</tr>
										<tr>
											<th style="width:10%; text-align:center;"> 계획명 </th>
											<th style="width:10%; text-align:center;"> 작성자 </th>
											<th style="width:10%; text-align:center;"> 줄거리 </th>
										</tr>
									</thead>	
										<!-- 계획이 있으면 -->
										<c:if test="${cnt > 0}">
											<c:forEach var="dto" items="${dtos}">
												<tr>
													<td align="center">
														<a href="planCourseContent?planNo=${dto.planNo}&pageNum=${pageNum}" class="plancourselistA">${dto.planTitle}</a>
													</td>	
																				
													<td align="center">
														<a href="planCourseContent?planNo=${dto.planNo}&pageNum=${pageNum}" class="plancourselistA">${dto.mem_Id}</a>
													</td>
													
													<td align="center">
													<a href="planCourseContent?planNo=${dto.planNo}&pageNum=${pageNum}" class="plancourselistA">
														${dto.planContent}
														<input type="hidden" name="planNo" value="${dto.planNo}">
													</a>
													</td>
													
												</tr>
											</c:forEach>
										</c:if>
										
										<c:if test="${cnt == 0}">	<!-- 계획이 없으면 -->
											<tr>
												<td colspan="6" align="center">
													계획이 없습니다.
												</td>
											</tr>
										</c:if>
									</table>
									<!-- 페이지 컨트롤 -->
								   <table style="width:100%" align="center">
								      <th align="center" style="text-align:center;">
								         <c:if test="${cnt > 0 }">
								            <!-- 처음[◀◀] / 이전블록 [◀] 특수문자 : ㅁ 한자키 -->
								            <c:if test="${startPage > pageBlock }">
								               <a href="plan"> <img src="${images}review/left_double.png" width="14px"> </a>
								               <a href="plan?pageNum=${startPage - pageBlock}"> <img src="${images}review/left_arrow.png" width="14px"> </a>
								            </c:if>
								            
								            <c:forEach var="i" begin="${startPage}" end="${endPage}">
								               <c:if test="${i == currentPage}">
								                  <span><b style="color:#337ab7;">${i}</b></span>
								               </c:if>
								               <c:if test="${i != currentPage}">
								                  <a href="plan?pageNum=${i}" style="color:#797979;">${i}</a>
								               </c:if>
								            </c:forEach>
								            
								            <!-- 다음블록[▶] / 끝[▶▶] -->
								            <c:if test="${pageCount > endPage }">
								               <a href="plan?pageNum=${startPage + pageBlock}"> <img src="${images}review/right_arrow.png" width="14px"> </a>
								               <a href="plan?pageNum=${pageCount}"> <img src="${images}review/right_double.png" width="14px"> </a>               
								            </c:if>
								         </c:if>
								      </th>
								   </table>
								</div>
							</div>
						<div class="col-md-1"></div>
					</div>
				</div>
			</div>
		</section>
		<!-- 메인화면 HEAD End -->
		
		<br /><br />

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
	</div>

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
	
</body>
</html>