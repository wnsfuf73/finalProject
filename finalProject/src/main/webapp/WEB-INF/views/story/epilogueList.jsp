<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>이야기</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--Google Fonts link-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i"
	rel="stylesheet">
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="${css}slick.css">
<link rel="stylesheet" href="${css}slick-theme.css">
<link rel="stylesheet" href="${css}animate.css">
<link rel="stylesheet" href="${css}fonticons.css">
<link rel="stylesheet" href="${css}font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.css">
<link rel="stylesheet" href="${css}magnific-popup.css">
<link rel="stylesheet" href="${css}bootsnav.css">
<link rel="stylesheet" href="${css}carousel.css">
<link rel="stylesheet" href="${css}storyCss/storyModal.css">

<link rel="stylesheet" href="${css}style.css">
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
						<!-- <li><a href="epilogueList">이야기</a></li> -->
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

	<!--Home Sections-->
	
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
						<li class="travel"><a href="isLogin_travel"
							target="_top">여행기</a></li>
						<li class="essay"><a href="isLogin_essay" target="_top">에세이</a></li>
						<li class="review"><a href="isLogin_reviewForm" target="_top">리뷰</a></li>
					</ul>
				</div>
				<div class="write_btm"></div>
			</div>
		</div>
	
	<div class="container">
		



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
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-10">
					<h2>
						<small>여행기</small>
						<!-- <div id="category_box" class="category_box" style="display:flex;float:right;">
							<a id="" href="#"><p style="font-size:8px;">전체</p></a>
							<a id="eat" href="#"><p style="font-size:8px;">맛집</p></a>
							<a id="travel" href="#"><p style="font-size:8px;">관광</p></a>
							<a id="leisure" href="#"><p style="font-size:8px;">레져</p></a>
							<a id="healing" href="#"><p style="font-size:8px;">힐링</p></a>
						</div> -->
					</h2>
					<hr>
					<div id="searchBar">
					<div class="form-group">
						<input type="text" style="width:50%" id="searchPhrase">
						<input type="button" value="검색하기" class=".btn-info" id="requestSearchBtn" name="requestSearchBtn">
					</div>	
						<div id="searchKind">
							<label><input type="radio" name="searchKind" value="">전체검색</label>
							<label><input type="radio" name="searchKind" value="eat">맛집검색</label>
							<label><input type="radio" name="searchKind" value="travel">관광검색</label>
							<label><input type="radio" name="searchKind" value="leisure">레져검색</label>
							<label><input type="radio" name="searchKind" value="healing">힐링검색</label>
						</div>
						
					</div>
					<hr>
					<div class="epilogue_container" style="width: 100%; height: 100%;">
						<div class="epilogue" style="width: 100%; margin-left: 5px;">
							<div id="resultList" class="row">
							<c:choose>
								<c:when test="${kind == null}">
									<h3>전체여행기</h3>
								</c:when>
								<c:when test="${kind != null }">
									<c:if test="${kind eq 'healing' }">
										<h3>힐링여행기</h3>
									</c:if>
									<c:if test="${kind eq 'travel' }">
										<h3>관광여행기</h3>
									</c:if>
									<c:if test="${kind eq 'leisure' }">
										<h3>레져여행기</h3>
									</c:if>
									<c:if test="${kind eq 'eat' }">
										<h3>맛집여행기</h3>
									</c:if>
								</c:when>
								<%-- <c:when test="${kind!=null and kind=='healing'}">
									<h3>힐링여행기</h3>
								</c:when>
								<c:when test="${kind!=null and kind=='travel' }">
									<h3>관광여행기</h3>
								</c:when>
								<c:when test="${kind!=null and kind=='leisure'}">
									<h3>레져여행기</h3>
								</c:when>
								<c:when test="${kind!=null and kind=='eat'}">
									<h3>맛집여행기</h3>
								</c:when> --%>
							</c:choose> 
								<div class="col-md-12">
								<c:forEach var="epil" items="${epilList}" varStatus="status">
									<c:if test="${status.index%3==0}">
											<div style="clear: both;">
											</div>
										</c:if>
										<div style="float: left; margin: 10px 10px;
											    border-color: #6a98bf;
											    border-radius: 10px;
											    border-style: solid;">
											    
											<a id="epilogueBox" href="epilogueDetail?epilogueNo=${epil.epilogueNo}&pageNum=${pageNum}">
												<p>${epil.title}</p> 
												<img class="thumbnail"
												src="/project/resources/images/story/${epil.img1}"
												style="width: 250px; height: auto;">
												<div>
													<center><span class="glyphicon glyphicon-flag">여행순서</span></center>
													<br>
													<ul class="list-group">
															<c:forEach var="info" items="${epil.visitOrder}" varStatus="status">
														   <li class="list-group-item">
																<b>${status.index+1}.</b><small>&nbsp;&nbsp;${info}</small>
															</li>
															</c:forEach>
													</ul>
												</div>
												<p>
													<fmt:formatDate value="${epil.reg_date}" />
													에 다녀옴
												</p>
												<span id="otherPart">좋아요 : ${epil.goodcount}   댓글 : ${epil.commentCount}</span>
											</a>
										</div>
										
								</c:forEach>
								</div>
 							</div>
						</div>
					</div>

				</div>
				<div class="col-sm-2" style="padding-right: 0;">
					<br> <br> <br>
					<ul class="nav nav-pills nav-stacked">
						<li><a id="openWrite"><img src="/project/resources/images/story/quick_menu_01.png"></a></li>
						<li><a href="myPageBoardList"><img src="/project/resources/images/story/quick_menu_04.png"></a></li>
					</ul>
					<br>
				</div>
			</div>
			
			
			<br><br><br>
			<!-- 페이지 컨트롤 재고관리, 다 쓰기...ㅜㅜ -->
			<table style="width: 960px" align="center">
				<tr>
					<td style="text-align: center;">
					<c:if test="${blockStartNumber!=1}">
						<input type="button" value="[◀◀]" onclick="window.location='epilogueList?requestPage=${startPage}'">
						<input type="button" value="[◀]" onclick="window.location='epilogueList?requestPage=${blockStartNumber-1}'">
					</c:if>
					<c:forEach var="n" begin="${blockStartNumber}" end="${blockEndNumber}">
						<c:if test="${n!=pageNum}">
							<a href="epilogueList?requestPage=${n}">${n}</a>
						</c:if>
						<c:if test="${n==pageNum}">
							<b>${n}</b>
						</c:if>
					</c:forEach>
					<c:if test="${blockEndNumber!=endPage}">
						<input type="button" value="[▶]" onclick="window.location='epilogueList?requestPage=${blockEndNumber+1}'">
						<input type="button" value="[▶▶]" onclick="window.location='epilogueList?requestPage=${endPage}'">
					</c:if>
					</td>
				</tr>
			</table>
			<br><br><br>
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
		
		<script src="${js}/vendor/storyScript3.js?ver=1.2"></script>
		

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