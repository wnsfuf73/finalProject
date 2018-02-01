<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>

<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>Pouseidon - Free HTML5 Model Agency Bootstrap Template</title>
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

<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>

</head>

<body data-spy="scroll" data-target=".navbar-collapse">
	<!-- onload="step2Focus()" -->


	<!-- Preloader -->
	<!-- 
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
 -->
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
					<a class="navbar-brand" href="main"> 홈<img src="#"
						class="logo logo-display" alt=""> <img src="#"
						class="logo logo-scrolled" alt="">
					</a>
				</div>
				<!-- End Header Navigation -->

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="nav navbar-nav navbar-right" data-in="fadeInDown"
						data-out="fadeOutUp">
						<li><a href="plan">계획하기</a></li>
						<li><a href="epilogueList">이야기</a></li>
						<li><a href="whereStart">어디갈까</a></li>
						<li><a href="recomandStart">추천여행기</a></li>
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
									<li><a href="xxxStart">계획하기</a></li>
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


		<!-- 모달 추가 시작 login -->
		<div class="row">
			<div class="modal" id="login" tabindex="-1">
				<!-- #model로 지정했으므로 id="model" -->
				<div class="modal-dialog" style="z-index: 9999">
					<div class="modal-content">
						<div class="modal-header">
							로그인
							<button class="close" data-dismiss="modal">&times;</button>
						</div>

						<div class="modal-body" style="text-align: center;">
							<center>
								<img src="${images}/Login.png">
							</center>
							<form id="login-form" action="login" method="post" role="form"
								style="display: block;">

								<div class="form-group">
									<input type="text" name="userId" id="userId" tabindex="1"
										class="form-control" placeholder="아이디" value="">
								</div>

								<div class="form-group">
									<input type="password" name="userPassword" id="userPassword"
										tabindex="2" class="form-control" placeholder="비밀번호" value="">
								</div>

								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<input type="submit" name="login-submit" id="login-submit"
												tabindex="4" class="btn btn-success" value="로그인">
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="row">
										<div class="col-lg-12">
											<div class="text-center">
												<a href="https://phpoll.com/recover" tabindex="5"
													class="forgot-password"> 아이디 | 비밀번호 찾기</a>
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



	</div>

	<!-- 모달 추가 시작 register -->
	<div class="row">
		<div class="modal" id="register" tabindex="-1">
			<!-- #model로 지정했으므로 id="model" -->
			<div class="modal-dialog" style="z-index: 9999">
				<div class="modal-content" style="height: 950px">
					<div class="modal-header">
						회원가입
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" style="text-align: center;">

						<!-- 회원가입 -->
						<div class="col-md-12">
							<form role="form" action="register" method="post" role="form"
								style="display: block;">
								<div class="form-group">
									<label for="username">사용자 이름</label> <input type="text"
										class="form-control" id="username" placeholder="이름을 입력해 주세요"
										name="name">
								</div>

								<!-- 
		vo.setEmail1(req.getParameter("email1"));
		vo.setEmail1(req.getParameter("email2"));
		vo.setSex(req.getParameter("sex"));
		vo.setPhone1(req.getParameter("phone1"));
		vo.setPhone2(req.getParameter("phone2"));
		vo.setPhone3(req.getParameter("phone3"));
		vo.setBirth(req.getParameter("birth"));
		vo.setGrade(req.getParameter("grade"));
		vo.setFaceImg(req.getParameter("faceImg"));
		vo.setIntroduce(req.getParameter("introduce")); -->

								<div class="form-group">
									<label for="InputId">아이디</label>
									<!-- <div id="chkIdOk"><span class="glyphicon glyphicon-ok"></span></div>
						<div id="chkIdRemove"><span class="glyphicon glyphicon-remove"></span></div> -->
									<div id="chkIdMsg"></div>
									<input type="text" class="form-control" id="InputId"
										placeholder="아이디(영문+숫자/6~15이내)" required="required"
										name="mem_id">
								</div>

								<div class="form-group">
									<label for="InputPassword1">비밀번호</label> <input type="password"
										class="form-control" id="InputPassword1"
										placeholder="비밀번호(영문+숫자/6~15이내)" required="required"
										name="password">
								</div>

								<div class="form-group">
									<label for="InputPassword2">비밀번호 확인</label>
									<!-- <div id="chkPwdOk"><span class="glyphicon glyphicon-ok"></span></div>
						<div id="chkPwdRemove"><span class="glyphicon glyphicon-remove"></span></div> -->
									<div id="chkPwdMsg"></div>
									<input type="password" class="form-control" id="InputPassword2"
										placeholder="비밀번호 확인" required="required">
									<!-- <p class="help-block">비밀번호 확인을 위해 다시 한번 입력 해 주세요</p> -->
								</div>

								<div class="form-group">
									<label for="InputEmail">이메일 주소</label> <input type="email"
										class="form-control" id="InputEmail"
										placeholder="E-Mail(비밀번호 분실 시 필요합니다)" required="required"
										name="email">
								</div>

								<div class="form-group">
									<label for="InputBirthday">생년월일</label> <input type="date"
										class="form-control" id="InputBirthday"
										placeholder="생년월일을 선택해 주세요" required="required" name="birth">
								</div>

								<div class="form-group">
									<label for="InputGender">성별</label>&nbsp;&nbsp;&nbsp; <label>
										<input name="sex" type="radio" value="Male" checked>
										남자
									</label> &nbsp;&nbsp;&nbsp; <label><input name="sex"
										type="radio" value="Female"> 여자</label>
								</div>

								<div class="form-group">
									<label for="username">휴대폰 인증</label>
									<div class="input-group">
										<input type="tel" class="form-control" id="username"
											placeholder="- 없이 입력해 주세요" name="phone"> <span
											class="input-group-btn">
											<button class="btn btn-success">
												인증번호 전송<i class="fa fa-mail-forward spaceLeft"></i>
											</button>
										</span>
									</div>
								</div>

								<div class="form-group">
									<label for="username">인증번호 입력</label>
									<div class="input-group">
										<input type="text" class="form-control" id="username"
											placeholder="인증번호"> <span class="input-group-btn">
											<button class="btn btn-success">
												인증번호 입력<i class="fa fa-edit spaceLeft"></i>
											</button>
										</span>
									</div>
								</div>

								<div class="form-group">
									<label>약관 동의</label>
									<div data-toggle="buttons">
										<label class="btn btn-primary active"> <span
											class="fa fa-check"></span> <input id="agree" type="checkbox"
											autocomplete="off" checked>
										</label> <a href="#">이용약관</a>에 동의합니다.
									</div>
								</div>

								<div class="form-group text-center">
									<button type="submit" class="btn btn-info">
										회원가입<i class="fa fa-check spaceLeft"></i>
									</button>
									<button type="submit" class="btn btn-warning">
										가입취소<i class="fa fa-times spaceLeft"></i>
									</button>
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


	<!--Home Sections-->

	<div class="container">
		<div id="write_mask" style="display: none;"></div>
		<div id="write_pop" class="write_pop" style="display: none;">
			<div class="write_cover">
				<div class="write_top"></div>
				<div class="write_mid">
					<div class="write_btn">
						<a id="closeWrite" class="write_close"></a>
					</div>
					<div class="mid_top">
						<div class="top_tt"></div>
					</div>
					<ul class="mid_btns">
						<li class="travel"><a href="story_write_myTourStory"
							target="_top">여행기</a></li>
						<li class="essay"><a href="/web/tessay_wrt.tlg" target="_top">T에세이</a></li>
						<li class="review"><a href="/web/review_info.tlg"
							target="_top">리뷰</a></li>
					</ul>
				</div>
				<div class="write_btm"></div>
			</div>
		</div>


		<div class="modal fade" id="searchModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog" role="document" style="z-index: 9999;">
				<div class="modal-content" style="margin-top: 50%">
					<div class="modal-header">
						<div class="modal-title-container">
							<h5 class="modal-title" id="exampleModalLongTitle">여행지 검색</h5>
						</div>
						<div class="searchLocation" style="display: flex;">
							<input maxlength="130" id="wantSearch" name="wantSearch"
								style="width: 30%;" type="text" class="form-control" /> <a
								id="modalSearchIcon" class="searchIcon"><img
								src="/project/resources/images/story/magnifier.svg"
								style="width: 30px; height: 30px; margin-left: 1.5%;"></a>
							<!-- enter키 눌러도 기능하게 해야되는데.. -->
						</div>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div id="modalbody" class="modal-body"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-primary">검색완료</button>
					</div>
				</div>
			</div>
		</div>




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
		<br> <br> <br> <br> <br>

		<div class="container">

			<div class="row">
				<div class="col-md-9">
					<center>
						<img alt="" src="${images}support/epilogStep2Head.png">
					</center>
					<hr>
				</div>
				<div class="col-md-3"></div>
			</div>
			<div class="row">
				<div class="col-md-9">
					<center>
						<h4>
							<span class="glyphicon glyphicon-pencil"></span><b>&nbsp;&nbsp;여행기
								작성중</b>
						</h4>
					</center>
					<hr>
				</div>
			</div>
			<br>
			<form action="writeEpilogueStep3" name="writeEpilogueStep2"
				id="writeEpilogueStep2" method="POST" onsubmit="return checkStep2()">
				<div class="row">
					<div class="col-md-9">
						<div class="container-fulid">
							<input type="hidden" id="epilogueNo" name="epilogueNo"
								value="${epilogueNo}">
							<div class="resultContainer">
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<label for="selectIndex">지점선택</label> <select
												id="selectIndexs" class="form-control">
												<option>새지점</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="searchText">여행지찾기</label> <input id="searchText"
										type="text" name="searchText" readonly class="form-control"><span
										style="visibility: hidden;">찾기</span></label> <input type="button"
										data-toggle="modal" data-target="#searchModal" value="찾아보기"
										class="form-control" style="width: 30%"> <label>
								</div>
							</div>
							<div class="col-md-2"></div>
							<br>
							<div class="row">
								<div class="col-md-11">
									<div class="form-group">
										<label for="content">내용 입력</label> <label for="maxSize">(<span>0</span>/500)
										</label>
										<textarea class="form-control" id="content" rows="5"></textarea>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-9 col-md-offset-1">
									<div class="form-group">
										<label for="content">이미지 등록</label>
										<div id="imageContainer" class="well well-lg">
											<center>
												<input id="uploadImg" type="file" name="uploadImg[]"
													value="사진추가" class="form-control" style="width: 50%"
													required="" multiple><br> <span><small>한지점당
														4개만 추가할수 있습니다.</small></span>
											</center>
											<div class="imgs_wrap" style="display: inline-block;">
												<span><small>이미지 미리보기</small></span>
											</div>
										</div>
									</div>
								</div>
							</div>

							<br>
							<div class="row">
								<div class="col-md-3">
									<label for="reg_date">다녀온 날짜</label> <input id="dday"
										type="date" class="form-control">
								</div>
							</div>


						</div>
					</div>
				</div>

				<br>
				<div class="row">
					<div class="col-md-2 col-md-offset-1" style="margin-right: 3px;">
						<img class="img-thumbnail" alt=""
							src="${images }support/step2_back.png" height="50"
							onclick="window.history.back();"
							>
					</div>
					<div class="col-md-2" id="saveOrUdtBtn">
						<img id="saveCourseBtn" class="img-thumbnail" alt=""
							src="${images }support/saveCorse.png" height="50"> <img
							id="updateCourseBtn" style="display: none;" class="img-thumbnail"
							alt="" src="${images }support/saveCorse.png" height="50">
					</div>
					<div class="col-md-2">
						<button type="submit">
							<img class="img-thumbnail" alt=""
								src="${images }support/step2_next.png" height="50">
						</button>
					</div>
				</div>
			</form>

		</div>


		<!-- 페이지 컨트롤 재고관리, 다 쓰기...ㅜㅜ -->
		<table style="width: 960px" align="center">
			<th align="center"><c:if test="${numOfEpil>0}">
					<!-- 처음[◀◀] / 이전블록[◀] -->
					<c:if test="${startPage > pageBlock}">
						<a href="epilogueList">[◀◀]</a>
						<!-- 첫페이지  -->
						<a href="epilogueList?pageNum=${startPage - pageBlock}">[◀]</a>
					</c:if>

					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i==currentPage}">
							<span><b>[${i}]</b></span>
						</c:if>

						<c:if test="${i!=currentPage}">
							<a href="epilogueList?pageNum=${i}">[${i}]</a>
						</c:if>
					</c:forEach>

					<!-- 다음블록[▶] / 끝 [▶▶] -->
					<c:if test="${pageCount>endPage}">
						<a href="epilogueList?pageNum=${startPage + pageBlock}">[▶]</a>
						<a href="epilogueList?pageNum=${pageCount}">[▶▶]</a>
					</c:if>
				</c:if></th>
		</table>

		<footer class="container-fluid">
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
		</footer>


		<hr>


		<!--Company section-->



		<!-- scroll up-->
		<div class="scrollup">
			<a href="#"><i class="fa fa-chevron-up"></i></a>
		</div>




		<!-- End off scroll up -->


		<!-- <footer id="footer" class="footer bg-mega"
			style="display: relative; margin-top: 20%;">
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
 -->

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

	<script src="${js}vendor/storyScript.js?ver=1.1"></script>
	<%-- <script src="${js}vendor/storyScript2.js?ver=1.2"></script> --%>
	<script src="${js}vendor/myTourStoryJavsScr.js?ver=1.1"></script>

	<script src="${js}vendor/storyScript2Test.js"></script>

	<script src="${js}bootstrap.green.min.js"></script>

	<!-- story javascript -->


	<script type="text/javascript">
		var checkFirst = false;
		var lastKeyword = "";
		var loopSendKeyword = false;

		function checkId() {
			if (checkFirst == false) {
				setTimeOut("sendId();", 500);
				loopSendKeyword = true;
			}
			checkFirst = true;
		}

		function checkPwd() {
			var f1 = document.registerForm[0];
			var pwd1 = fl.inputPassword1.value;
			var pwd2 = f1.inputPassword2.value;

			if (pwd1 != pwd2) {
				document.getElementById('chkPwdMsg').innerHTML = "동일한 비밀 번호를 입력해주세요";
			} else {
				document.getElementById('chkPwdMsg').innerHTML = "비밀번호가 확인 되었습니다"
			}
		}

		function sendId() {
			if (loopSendKeyword == false)
				return;

			var keyword = document.registerForm.inputId.value;
			if (keyword == "") {
				lastKeyWord = "";
				document.getElementById('chkIdMsg').innerHTML = "아이디를 입력해주세요";
			} else if (keyword != lasyKeyWord) {
				lastKeyWord = keyword;

				if (keyword != "") {
					var params = encodeURIComponent(keyword);
					sendRequest("confirmId", params, displayResult, 'POST');

				} else {

				}
			}
			sendTimeout("sendId();", 500);
		}

		function displayResult() {
			if (httpRequest.readyState == 4) {
				if (httpRequest.status == 200) {
					var resultTest = httpRequest.responseText;
					var listView = document.getElementBy('chkIdMsg');

					if (resultText == 0) {
						listView.innerHTML = "사용할 수 있는 아이디 입니다";
					} else {
						listView.innerHTML = "사용할 수 없는 아이디 입니다";
					}
				} else {
					result.innerHTML = "에러발생";
				}
			}
		}
	</script>
</body>
</html>