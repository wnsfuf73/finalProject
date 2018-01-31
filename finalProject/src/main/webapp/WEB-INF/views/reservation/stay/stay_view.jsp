<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>

<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<style>
#map {
	height: 400px;
	width: 100%;
}
</style>

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
<link rel="stylesheet" href="${css}where.css">
<script src="${js}vendor/jquery-1.11.2.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!--Theme custom css -->
<link rel="stylesheet" href="${css}style.css">
<!--<link rel="stylesheet" href="${css}colors/maron.css">-->

<!--Theme Responsive css-->
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
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
					<a class="navbar-brand" href="index"> 홈<img src="#"
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

		<section id="hello" class="model-banner bg-mega" style="height: 70px;">
			<div class="overlay"></div>
		</section>
		<!--End off Home Sections-->

		<!--Model Details Section-->
		<section id="m_details" class="m_details roomy-100 fix">
			<div class="container">
				<div class="row">
					<div class="main_details">
						<div class="col-md-6">
							<div class="m_details_img">
								<img src="${images}stay/stay_location/${vo.stay_img1}" alt="" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="m_details_content m-bottom-40">
								<h2>${vo.stay_name}</h2>
								<p>${vo.stay_introduce}</p>
							</div>
							<hr />
							<div class="person_details m-top-40"></div>
						</div>
					</div>
				</div>
				<!-- End off row -->
			</div>
			<!-- End off container -->
			<div class="container">
				<div class="row">
					<table>
						<tr>
							<th width="10%">종류:</th>
							<td>${vo.stay_class}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>등급:</th>
							<td>${vo.stay_kind}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>주소:</th>
							<td>${vo.stay_address}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>전화 번호:</th>
							<td>${vo.stay_cellphone}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>일반 사항:</th>
							<td>${vo.stay_general_details}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>편의 시설:</th>
							<td>${vo.stay_amenities}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>서비스:</th>
							<td>${vo.stay_service}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>인터넷:</th>
							<td>${vo.stay_internet}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>주차:</th>
							<td>${vo.stay_parking}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>체크 인:</th>
							<td>${vo.stay_check_in}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
						<tr>
							<th>체크 아웃:</th>
							<td>${vo.stay_check_out}</td>
						</tr>
						<tr>
							<td><br></td>
							<td><br></td>
						</tr>
					</table>
				</div>
			</div>
		</section>
		<!-- End off Model Details Section -->
		<c:if test="${vo.stay_img2 !=null}">
			<!--Gallery Section-->
			<section id="gallery" class="gallery margin-top-120 bg-grey">
				<!-- Gallery container-->
				<div class="container">
					<div class="row">
						<div class="main-gallery roomy-80">
							<div class="col-md-12 m-bottom-70">
								<div class="head_title text-left sm-text-center wow fadeInDown">
									<h2>다른 사진들</h2>
									<h5>
										<em>Other Picture...</em>
									</h5>
									<div class="separator_left"></div>
								</div>
							</div>


							<div style="clear: both;"></div>


							<div class="row">
								<div class="main_cbrand text-center">
									<div class="col-md-2 col-sm-4 col-xs-6">
										<div class="cbrand_item m-bottom-10">
											<a href="${images}stay/stay_location/${vo.stay_img1}"
												class="popup-img text-blue m-top-40"><img
												src="${images}stay/stay_location/${vo.stay_img1}" alt="" /></a>
										</div>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-6">
										<div class="cbrand_item m-bottom-10">
											<a href="${images}stay/stay_location/${vo.stay_img2}"
												class="popup-img text-blue m-top-40"><img
												src="${images}stay/stay_location/${vo.stay_img2}" alt="" /></a>
										</div>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-6">
										<div class="cbrand_item m-bottom-10">
											<a href="${images}stay/stay_location/${vo.stay_img3}"
												class="popup-img text-blue m-top-40"><img class=""
												src="${images}stay/stay_location/${vo.stay_img3}" alt="" /></a>
										</div>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-6">
										<div class="cbrand_item m-bottom-10">
											<a href="${images}stay/stay_location/${vo.stay_img4}"
												class="popup-img text-blue m-top-40"><img
												src="${images}stay/stay_location/${vo.stay_img4}" alt="" /></a>
										</div>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-6">
										<div class="cbrand_item m-bottom-10">
											<a href="${images}stay/stay_location/${vo.stay_img5}"
												class="popup-img text-blue m-top-40"><img
												src="${images}stay/stay_location/${vo.stay_img5}" alt="" /></a>
										</div>
									</div>
									<div class="col-md-2 col-sm-4 col-xs-6">
										<div class="cbrand_item m-bottom-10">
											<a href="${images}stay/stay_location/${vo.stay_img6}"
												class="popup-img text-blue m-top-40"><img
												src="${images}stay/stay_location/${vo.stay_img6}" alt="" /></a>
										</div>
									</div>
								</div>
							</div>
							<!-- End off row -->

							<div style="clear: both;"></div>

						</div>
					</div>
				</div>
				<!-- Portfolio container end -->
			</section>
		</c:if>
		<c:if test="${vo.stay_img2 == null}">
		</c:if>
		<br>
		<section>
			<div class="container">
				<div class="row">
					<div class="col-md-12 m-bottom-70">
						<div class="head_title text-left sm-text-center wow fadeInDown">
							<form name="room_search" action="stay_room_search"
								target="stay_room_search">
								<input type="hidden" name="stay_no" value="${vo.stay_no}">
								<h2>객실 검색</h2>
								<input type="text" id="datepicker" name="start_date"
									required="required"> ~ <input type="text"
									id="datepickerEnd" name="end_date" required="required">
								<input type="submit" value="검색">
								<div class="separator_left"></div>
							</form>
						</div>
					</div>

					<div style="clear: both;"></div>

					<div class="stay_room_list">
						<iframe src="" name="stay_room_search" style="width: 1200px;">
						</iframe>
					</div>
				</div>
			</div>
		</section>
		<br>
		<!-- End off portfolio section -->
		<section>
			<div class="container">
				<div class="row">
					<div class="col-md-12 m-bottom-70">
						<div class="head_title text-left sm-text-center wow fadeInDown">
							<h2>장소 위치</h2>
							<div class="separator_left"></div>
							<div style="clear: both;"></div>
							<br>
							<div id="map"></div>
							<!--Company section-->
							<br>
						</div>
					</div>


				</div>
			</div>
		</section>

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
	</div>

	<!-- JS includes -->
	<script>
	$(function() {
		$.datepicker.setDefaults($.datepicker.regional['ko']);//달력을 한국어로 표시
	 	$("#datepicker").datepicker({
	 		datefomat:'yyyy-mm-dd', // 날짜형식
	 		showAnim : 'show',// 애니메이션
	 		minDate:'+0', // 최소 오늘날짜 이전 선택불가
	     	maxDate:'+3m', // 최고 3달후까지 선택가능
	     	changeMonth: true, // 월을 이동하기 위한 선택상자 표시여부
	     	onClose:function(selectedDate){
	     		// 시작일이 닫힐때 종료일의 선택할수있는 최소 날짜를 선택한 시작일로 지정
	     		$("#datepickerEnd").datepicker("option","minDate",selectedDate)
	     	}
		});
	 	
	 	$("#datepickerEnd").datepicker({
	 		dateformat:'yyyy-mm-dd',
	 		showAnim : 'show',
	 		changeMonth: true,
	 		onClose:function(selectedDate){
	 			$("#datepicker").datepicker("option","maxDate",selectedDate)
	 		}
	 	});
	});
	
	function change_parent_url(url) {
		document.location = url;
	}
	
	// 구글 맵
	function initMap() {
		var uluru = {
			lat : ${vo.stay_x},
			lng : ${vo.stay_y}
		};
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 15,
			center : uluru
		});

		var contentString = '<div id="content">'
				+ '<div id="siteNotice">'
				+ '</div>'
				+ '<h5 id="firstHeading" class="firstHeading">${vo.stay_name}</h5>'
				+ '<div id="bodyContent">'
				+ '주소 : ${vo.stay_address}<br>'
				+ '전화 번호 : ${stay_cellphone}<br>'
				+ '체크 인 : ${vo.stay_check_in}<br>'
				+ '체크 아웃 : ${vo.stay_check_out}<br>'
				+ '좌표 : ${vo.stay_x}, ${vo.stay_y}'
				+ '</div>' + '</div>';
			var infowindow = new google.maps.InfoWindow({
			content : contentString
		});
			var marker = new google.maps.Marker({
			position : uluru,
			map : map,
			title : 'Uluru (Ayers Rock)'
		});
		marker.addListener('click', function() {
			infowindow.open(map, marker);
		});
	};
	</script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAu8_5LRl659ZkNDhSI_RKnCDK0jzFryak&callback=initMap">
		
	</script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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


	<script src="${js}stayReservation.js"></script>

	<!-- 달력을 한국어로 표시 -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
</body>
</html>