<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>

<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>동행... 당신의 이야기</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="icon" type="image/png" href="favicon.ico">

<!--Google Fonts link-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">

<link rel="stylesheet" href="${css}slick.css">
<link rel="stylesheet" href="${css}slick-theme.css">
<link rel="stylesheet" href="${css}animate.css">
<link rel="stylesheet" href="${css}fonticons.css">
<link rel="stylesheet" href="${css}font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.css">
<link rel="stylesheet" href="${css}bootsnav.css">
<link rel="stylesheet" href="${css}carousel.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--Theme custom css -->
<link rel="stylesheet" href="${css}style.css">
<!--Theme Responsive css-->
<link rel="stylesheet" href="${css}responsive.css" />

<!-- JS includes -->
<script src="${js}vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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

<!-- <script type="text/javascript">
	window.onload = function() {
		window.open("mainNotice"
				,"_blank"
				,"toolbar=yes,scrollbars=yes,resizable=yes,top=100,left=100,width=400,height=250");	
	}

</script> -->
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
						<li><a href="plan">계획하기</a></li>
						<li><a href="epilogueList">여행후기</a></li>
						<li><a href="where_main">여행지소개</a></li>
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
								<li><a href="epilogueList">여행후기</a></li>
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
		<c:if test="${sessionScope.mem_id == null}">
			<%@include file="modal/loginModal.jsp"%>	
			<%@include file="modal/registerModal.jsp"%>
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
					<div class="item active" style="max-width:auto!important; height:800px!important;">
						<img src="${images}travel/main/21.jpg" alt="travel1">
						<div class="carousel-caption">
							<h3>New York</h3>
							<p>The atmosphere in New York is lorem ipsum.</p>
						</div>
					</div>

					<div class="item" style="max-width:auto!important; height:800px!important;">
						<img src="${images}travel/main/8.jpg" alt="travel2" >
						<div class="carousel-caption">
							<h3>Chicago</h3>
							<p>Thank you, Chicago - A night we won't forget.</p>
						</div>
						
					</div>

					<div class="item" style="max-width:auto!important; height:800px!important;">
						<img src="${images}travel/main/55.jpg" alt="travel3">
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


		<!--About Sections-->
		<section id="feature" class="feature p-top-100">
			<div class="container">
				<div class="row">
					<div class="main_feature">

						<div class="col-md-6 m-top-120">
							<!-- Head Title -->
							<div class="feature_content wow fadeIn m-top-40">
								<jsp:useBean id="now" class="java.util.Date" />
								<fmt:formatDate var="mm" value="${now}" pattern="MM" />
								<h3><span color=#2786FF>${mm}월의</span> 베스트 여행기</h3>
							</div>
							<div class="separator_left"></div>
							<div class="head_title">
								<h2>${bestTravel.title }</h2>
	
								<h5>
									<fmt:formatDate var="regDate" value="${bestTravel.reg_date}" pattern="yyyy-MM-dd a hh:mm" />
									<em>${regDate }</em>&emsp;<em>|</em>&emsp; 
									<em>작성자 : ${bestTravel.mem_id}</em>
								</h5>
							</div>
							<!-- End off Head Title -->
							<div class="feature_btns m-top-30">
								<a href="epilogueDetail?epilogueNo=${bestTravel.epilogueNo}&pageNum=1" class="btn btn-default text-uppercase">여행기 보기 <i
									class="fa fa-long-arrow-right"></i>
								</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="feature_photo wow fadeIn sm-m-top-40">
								<div class="photo_border"></div>
								<div class="feature_img">
									<img src="${images}story/${bestTravelImg}" alt="" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--End off row-->
			</div>
			<!--End off container -->

			<br><br>
			<hr />
			
			<!-- 추천여행기  -->
			<!--Our Work Section-->
<%-- 			<div class="container">
				<div class="row">
				
				<div  class="head_title text-left sm-text-center wow fadeInDown">
					<h2><span>추천</span> 여행기</h2>
					<h5>
						<em>Some our recent works is here. Discover them now!</em>
					</h5>
					<div class="separator_left"></div>
				</div>
				
					<div class="main_work">

						<div class="col-md-7 col-md-offset-5 col-sm-12 col-xs-12">
							<div class="work_item">
								<div class="row">
									<div
										class="col-md-7 col-sm-12 col-xs-12 text-right pull-right sm-text-center">
										<div class="work_item_img">
											<img src="${images}travel/beanang.jpg" alt="" />
										</div>
									</div>
									<div
										class="col-md-5 col-sm-12 col-xs-12 text-right pull-left sm-text-center">
										<div class="work_item_details m-top-80 sm-m-top-20">
											<h4>독립문 크다</h4>
											<div class="work_separator1"></div>
											<p class="m-top-40 sm-m-top-10">2018-01-06 | Traveler Jk
												Lim</p>
										</div>
										<div class="feature_btns m-top-30">
											<a href="" class="btn btn-default text-uppercase">여행기 보기
												<i class="fa fa-long-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End off work-item -->

						<div class="col-md-7 col-sm-12 col-xs-12">
							<div class="work_item">
								<div class="row">
									<div class="col-md-7 col-sm-12 col-xs-12">
										<div class="work_item_img sm-text-center sm-m-top-40">
											<img src="${images}travel/BestTravel3.jpg" alt="" />
										</div>
									</div>
									<div
										class="col-md-5 col-sm-12 col-xs-12 text-left pull-left sm-text-center">
										<div class="work_item_details m-top-80 sm-m-top-20">
											<h4>교촌한옥마을</h4>
											<div class="work_separator2"></div>
											<p class="m-top-40 sm-m-top-10">2018-01-06 | Traveler 몽이</p>
										</div>
										<div class="feature_btns m-top-30">
											<a href="" class="btn btn-default text-uppercase"><i
												class="fa fa-long-arrow-left"></i> 여행기 보기 </a>
										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End off work-item -->

						<div class="col-md-7 col-md-offset-5 col-sm-12 col-xs-12">
							<div class="work_item">
								<div class="row">
									<div
										class="col-md-7 col-sm-12 col-xs-12 text-right pull-right sm-text-center">
										<div class="work_item_img sm-m-top-40">
											<img src="${images}travel/BestTravel4.jpg" alt="" />
										</div>
									</div>
									<div
										class="col-md-5 col-sm-12 col-xs-12 text-right pull-left sm-text-center">
										<div class="work_item_details m-top-80 sm-m-top-20">
											<h4>I Love Paris Every Moment</h4>
											<div class="work_separator1"></div>
											<p class="m-top-40 sm-m-top-10">2018년 01월 07일 | Traveler
												스칼렛</p>
										</div>
										<div class="feature_btns m-top-30">
											<a href="" class="btn btn-default text-uppercase">여행기 보기
												<i class="fa fa-long-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- End off work-item -->

						<div class="col-md-7 col-sm-12 col-xs-12">
							<div class="work_item">
								<div class="row">
									<div class="col-md-7 col-sm-12 col-xs-12">
										<div class="work_item_img sm-text-center sm-m-top-40">
											<img src="${images}travel/BestTravel5.jpg" alt="" />
										</div>
									</div>
									<div
										class="col-md-5 col-sm-12 col-xs-12 text-left pull-left sm-text-center">
										<div class="work_item_details m-top-80 sm-m-top-20">
											<h4>부산 해운대 여행</h4>
											<div class="work_separator2"></div>
											<p class="m-top-40 sm-m-top-10">2017년 12월 29일 | Traveler
												정우기</p>
										</div>
										<div class="feature_btns m-top-30">
											<a href="" class="btn btn-default text-uppercase"><i
												class="fa fa-long-arrow-left"></i> 여행기 보기 </a>
										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End off work-item -->

					</div>
				</div>
			</div>

			<hr /> --%>
			<!-- 추천여행기 주석  -->			


			<!-- 추천리스트 주석 -->
			<c:if test="${sessionScope.mem_id!=null }">
			<div class="container">
				<div class="row">
					<div  class="head_title text-left sm-text-center wow fadeInDown">
						<h2><span>${sessionScope.mem_id}</span>님의 추천리스트 만들기</h2>
						<h5>
							<em>we're recommended for you!!</em>
						</h5>
						<div class="separator_left"></div>
					</div>

					<div class="service_content_area" id="result">
						<!-- 왼쪽메뉴 -->
						<div class="col-md-4 service_left wow fadeInLeft">
							<!-- Service -->
						</div>
						<!-- /END Service LEFT -->

						<!-- 추천목록 뿌리는 버튼 -->
						<div class="col-md-4 sm-m-top-40 sm-text-center">
							<div class="service-img wow bounceIn">
								<div class="recomm_div">
									<span id="recomm_id">${sessionScope.mem_id}</span>님의 추천 목록 보기
									<div style="height:100%">
										<a style="margin-top:130px;"type="button" id="recomm_btn" class="btn btn-default text-uppercase">보기</a>
									</div>
								</div>
							</div>
						</div>

						<!-- 오른쪽 메뉴 -->
						<div class="col-md-4 service_right wow fadeInRight sm-m-top-40">
							<!-- Service -->
						</div>
						<!-- /END Service RIGHT -->
					</div>
					
				</div>
				<!--End off row -->
			</div>
			</c:if>
			<!-- 추천리스트 주석 -->

		</section>
		<!--End off About section -->
		<hr>
		<!--Testimonial Section-->
		<section id="testimonial" class="testimonial fix roomy-100">
			<!-- 사용자추천 주석 -->
<%-- 			<div class="container">
				<div class="row">
					<div class="main_testimonial text-center">
						<h2><span>사용자</span> 추천</h2>
						<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
							<Br>
							<div class="carousel-inner" role="listbox">
								<div class="item active testimonial_item">
									<div class="col-sm-10 col-sm-offset-1">

										<div class="test_authour">
											<img class="img-circle" src="${images}user/user1.jpg" alt="" width="100px" height="100px"/>
											<h5 class="m-top-20">임순묵</h5>
										</div>

										<div class="row">
											<div class="main_counter text-center">
												<div class="col-md-4">
													<div class="counter_item">
														<h5 class="statistic-counter">
															<em> 128 </em>
														</h5>
														<div class="separator_small"></div>
														<h5>추천수</h5>
													</div>
												</div>
												<div class="col-md-4">
													<div class="counter_item sm-m-top-40">
														<h5 class="statistic-counter">
															<em>124</em>
														</h5>
														<div class="separator_small"></div>
														<h5>이야기</h5>
													</div>
												</div>
												<div class="col-md-4">
													<div class="counter_item sm-m-top-40">
														<h5 class="statistic-counter">
															<em>76</em>
														</h5>
														<div class="separator_small"></div>
														<h5>좋아요</h5>
													</div>
												</div>
											</div>
										</div>
										<!--End off row-->
									</div>
								</div>
								<div class="item testimonial_item">
									<div class="col-sm-10 col-sm-offset-1">

										<div class="test_authour">
											<img class="img-circle" src="${images}user/user2.jpg" alt="" width="100px" height="100px"/>
											<h5 class="m-top-20">곽호선</h5>
										</div>

										<div class="row">
											<div class="main_counter text-center">
												<div class="col-md-4">
													<div class="counter_item">
														<h5 class="statistic-counter">
															<em> 180 </em>
														</h5>
														<div class="separator_small"></div>
														<h5>추천수</h5>
													</div>
												</div>
												<div class="col-md-4">
													<div class="counter_item sm-m-top-40">
														<h5 class="statistic-counter">
															<em>154</em>
														</h5>
														<div class="separator_small"></div>
														<h5>이야기</h5>
													</div>
												</div>
												<div class="col-md-4">
													<div class="counter_item sm-m-top-40">
														<h5 class="statistic-counter">
															<em>100</em>
														</h5>
														<div class="separator_small"></div>
														<h5>좋아요</h5>
													</div>
												</div>
											</div>
										</div>
										<!--End off row-->


									</div>
								</div>
								<div class="item testimonial_item">
									<div class="col-sm-10 col-sm-offset-1">

										<div class="test_authour">
											<img class="img-circle" src="${images}user/user3.jpg" alt="" width="100px" height="100px"/>
											<h5 class="m-top-20">조홍희</h5>
										</div>

										<div class="row">
											<div class="main_counter text-center">
												<div class="col-md-4">
													<div class="counter_item">
														<h5 class="statistic-counter">
															<em> 250 </em>
														</h5>
														<div class="separator_small"></div>
														<h5>추천수</h5>
													</div>
												</div>
												<div class="col-md-4">
													<div class="counter_item sm-m-top-40">
														<h5 class="statistic-counter">
															<em>200</em>
														</h5>
														<div class="separator_small"></div>
														<h5>이야기</h5>
													</div>
												</div>
												<div class="col-md-4">
													<div class="counter_item sm-m-top-40">
														<h5 class="statistic-counter">
															<em>150</em>
														</h5>
														<div class="separator_small"></div>
														<h5>좋아요</h5>
													</div>
												</div>
											</div>
										</div>
										<!--End off row-->

									</div>
								</div>

							</div>

							<!-- Controls -->
							<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev"> 
								<span class="fa fa-long-arrow-left" aria-hidden="true"></span> 
								<span class="sr-only">Previous</span>
							</a> 
							<span class="slash">/</span> 
							<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
								<span class="fa fa-long-arrow-right" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
							</a>

						</div>
					</div>
				</div>
				<!--End off row-->
			</div> --%>
			<!-- 사용자추천 주석 -->
			
			<!--End off container -->

			<br />
			<hr />
			
			<!-- 하단 호리즌이미지 -->
			<%-- <div class="container">
				<div class="row">
					<div class="main_cbrand text-center">
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="cbrand_item m-bottom-10">
								<a href=""><img src="${images}brand-img1.png" alt="" /></a>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="cbrand_item m-bottom-10">
								<a href=""><img src="${images}brand-img2.png" alt="" /></a>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="cbrand_item m-bottom-10">
								<a href=""><img class="" src="${images}brand-img3.png"
									alt="" /></a>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="cbrand_item m-bottom-10">
								<a href=""><img src="${images}brand-img4.png" alt="" /></a>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="cbrand_item m-bottom-10">
								<a href=""><img src="${images}brand-img5.png" alt="" /></a>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="cbrand_item m-bottom-10">
								<a href=""><img src="${images}brand-img1.png" alt="" /></a>
							</div>
						</div>
					</div>
				</div>
				<!-- End off row -->
			</div> --%>
			<!-- 하단 호리즌이미지 주석-->
			<!-- End off container -->
		</section>
		<!--End off Testimonial section -->

		<!--Gallery Section-->
		<section id="gallery" class="gallery margin-top-120 bg-grey">
			<!-- Gallery container-->
			<div class="container">
				<div class="row">
					<div class="main-gallery roomy-80">
						<div class="col-md-12">
							<div  class="head_title text-left sm-text-center wow fadeInDown">
								<h2><span>여행</span> 갤러리</h2>
								<h5>
									<em>Some our recent works is here. Discover them now!</em>
								</h5>
								<div class="separator_left"></div>
							</div>
						</div>
						<div class="col-md-12 m-bottom-60">
							<div class="filters-button-group text-right sm-text-center">
								<button class="button is-checked" data-filter="*"><span class="glyphicon glyphicon-picture"></span></button>
								<button class="button" data-filter=".metal"><span class="glyphicon glyphicon-facetime-video"></span></button>
								<button class="button" data-filter=".transition"><span class="glyphicon glyphicon-eye-open"></span></button>
						<!-- 		<button class="button" data-filter=".alkali"><span class="glyphicon glyphicon-picture"></span></button>
								<button class="button" data-filter=".ar"><span class="glyphicon glyphicon-picture"></span></button> -->
							</div>
						</div>

						<div style="clear: both;"></div>

						<div class="grid text-center">
							<div class="grid-item transition metal ium"
								style="width: 370px; height: 409px;">
								<img alt="" src="${images}travel/main/70.jpg">
								<div class="grid_hover_area text-center">
									<div class="grid_hover_text m-top-110">
										<h4 class="text-blue">동행's gallery</h4>
										<h5 class="text-blue">
											<em>go whith..</em>
										</h5>
										<a href="${images}travel/main/70.jpg"
											class="popup-img text-blue m-top-40">View 
											<i class="fa fa-long-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- End off grid Hover area -->
							</div>
							<!-- End off grid item -->

							<div class="grid-item metalloid "
								style="width: 370px; height: 582px;">
								<img alt="" src="${images}travel/main/66.jpg">
								<div class="grid_hover_area text-center">
									<div class="grid_hover_text m-top-150">
										<h4 class="text-blue">동행's gallery</h4>
										<h5 class="text-blue">
											<em>go whith..</em>
										</h5>
										<a href="${images}travel/main/66.jpg"
											class="popup-img text-blue m-top-40">View 
											<i class="fa fa-long-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- End off grid Hover area -->
							</div>
							<!-- End off grid item -->

							<div class="grid-item post-transition metal numberGreaterThan50"
								style="width: 370px; height: 249px;">
								<img alt="" src="${images}travel/main/58.jpg">
								<div class="grid_hover_area text-center">
									<div class="grid_hover_text m-top-50">
										<h4 class="text-blue">동행's gallery</h4>
										<h5 class="text-blue">
											<em>go whith..</em>
										</h5>
										<a href="${images}travel/main/58.jpg"
											class="popup-img text-blue m-top-40">View <i
											class="fa fa-long-arrow-right"></i></a>
									</div>
								</div>
								<!-- End off grid Hover area -->
							</div>
							<!-- End off grid item -->

							<div class="grid-item alkali ar"
								style="width: 370px; height: 533px;">
								<img alt="" src="${images}travel/main/68.JPG">
								<div class="grid_hover_area text-center">
									<div class="grid_hover_text m-top-50">
										<h4 class="text-blue">동행's gallery</h4>
										<h5 class="text-blue">
											<em>go whith..</em>
										</h5>
										<a href="${images}travel/main/68.JPG"
											class="popup-img text-blue m-top-40">View <i
											class="fa fa-long-arrow-right"></i></a>
									</div>
								</div>
								<!-- End off grid Hover area -->
							</div>
							<!-- End off grid item -->

							<div class="grid-item post-transition metal ium"
								style="width: 370px; height: 380px;">
								<img alt="" src="${images}travel/main/65.jpg">
								<div class="grid_hover_area text-center">
									<div class="grid_hover_text m-top-150">
										<h4 class="text-blue">동행's gallery</h4>
										<h5 class="text-blue">
											<em>go whith..</em>
										</h5>
										<a href="${images}travel/main/65.jpg"
											class="popup-img text-blue m-top-50">View <i
											class="fa fa-long-arrow-right"></i></a>
									</div>
								</div>
								<!-- End off grid Hover area -->
							</div>
							<!-- End off grid item -->


							<div class="grid-item metal ar"
								style="width: 370px; height: 361px;">
								<img alt="" src="${images}travel/main/43.jpg">
								<div class="grid_hover_area text-center">
									<div class="grid_hover_text m-top-110">
										<h4 class="text-blue">동행's gallery</h4>
										<h5 class="text-blue">
											<em>go whith..</em>
										</h5>
										<a href="${images}travel/main/43.jpg"
											class="popup-img text-blue m-top-40">View 
											<i class="fa fa-long-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- End off grid Hover area -->
							</div>
							<!-- End off grid item -->

						</div>

						<div style="clear: both;"></div>

					</div>
				</div>
			</div>
			<!-- Portfolio container end -->
		</section>
		<!-- End off portfolio section -->	

		
		
		<!--Models section-->
		<section id="models" class="models bg-grey roomy-80">
			<div class="container">
				<div class="row">
					<div class="main_models text-center">
						<div class="col-md-12">
							<div class="head_title text-left sm-text-center wow fadeInDown">
								<h2>이달의 <span>축제</span></h2>
								<h5>
									<em>FESTIVAL</em>
								</h5>
								<div class="separator_left"></div>
							</div>
						</div>

						<div class="col-md-3 col-sm-6">
							<div class="model_item m-top-30">
								<div class="model_img">
									<img src="${images}travel/main/71.jpg" alt="" width="270px"
										height="270px" />
									<div class="model_caption">
										<h5 class="text-blue">대구 등불 축제 2018</h5>
									</div>
								</div>
							</div>
						</div>
						<!-- End off col-md-3 -->

						<div class="col-md-3 col-sm-6">
							<div class="model_item m-top-30">
								<div class="model_img">
									<img src="${images}travel/main/75.jpg" alt="" width="270px"
										height="270px" />
									<div class="model_caption">
										<h5 class="text-blue">튤립 축제 2018</h5>
									</div>
								</div>
							</div>
						</div>
						<!-- End off col-md-3 -->

						<div class="col-md-3 col-sm-6">
							<div class="model_item m-top-30">
								<div class="model_img">
									<img src="${images}travel/main/73.jpg" alt="" width="270px"
										height="270px" />
									<div class="model_caption">
										<h5 class="text-blue">벚꽃 축제 2018</h5>
									</div>
								</div>
							</div>
						</div>
						<!-- End off col-md-3 -->

						<div class="col-md-3 col-sm-6">
							<div class="model_item m-top-30">
								<div class="model_img">
									<img src="${images}travel/main/76.jpg" alt="" width="270px"
										height="270px" />
									<div class="model_caption">
										<h5 class="text-blue">순천만 갈대 축제 2018</h5>
									</div>
								</div>
							</div>
						</div>
						<!-- End off col-md-3 -->

						<div class="col-md-3 col-sm-6">
							<div class="model_item m-top-30">
								<div class="model_img">
									<img src="${images}travel/main/77.jpg" alt="" width="270px"
										height="270px" />
									<div class="model_caption">
										<h5 class="text-blue">불꽃 축제 2018</h5>
									</div>
								</div>
							</div>
						</div>
						<!-- End off col-md-3 -->

						<div class="col-md-3 col-sm-6">
							<div class="model_item m-top-30">
								<div class="model_img">
									<img src="${images}travel/main/78.jpg" alt="" width="270px"
										height="270px" />
									<div class="model_caption">
										<h5 class="text-blue">보성 녹차 대축제 2018</h5>
									</div>
								</div>
							</div>
						</div>
						<!-- End off col-md-3 -->

						<div class="col-md-3 col-sm-6">
							<div class="model_item m-top-30">
								<div class="model_img">
									<img src="${images}travel/main/80.JPG" alt="" width="270px"
										height="270px" />
									<div class="model_caption">
										<h5 class="text-blue">해운대 모레 축제 2018</h5>
									</div>
								</div>
							</div>
						</div>
						<!-- End off col-md-3 -->

						<div class="col-md-3 col-sm-6">
							<!-- 모두보기 주석 -->
							<!-- <div class="model_item meet_team m-top-30">
								<a href="">모두 보기<i class="fa fa-long-arrow-right"></i></a>
							</div> -->
							<!-- 모두보기 주석 -->
						</div>
						<!-- End off col-md-3 -->

					</div>
				</div>
			</div>
		</section>

		<!--Company section-->

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
<script type="text/javascript">
	/* 추천 ajax */
	$(document).ready(function() {
		$('#recomm_btn').click(function() {
			
		/* 	var planTitle = $("input[name='planTitle']").val();
			var planContent = $("textarea[name='planContent']").val(); */
		
			 $.ajax({
				url: "recommend",
				type: 'GET',
				
				success: function(msg) {
					$('#result').html(msg);					
				},				
				error: function() {
					alert('오류');
				}			
			});			 
		});		
	});
</script>
</body>
</html>