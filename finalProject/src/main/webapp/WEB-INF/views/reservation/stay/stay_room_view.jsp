<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>

<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>Pouseidon - Free HTML5 Model Agency Bootstrap Template</title>
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


		<%@include file="../../main/sample/header.jsp" %>

		<!--Model Details Section-->
		<section id="m_details" class="m_details roomy-100 fix">
			<div class="container">
				<div class="row">
					<div class="main_details">
						<div class="col-md-6">
							<div class="m_details_img">
								<img src="${images}stay/stay_location_room/${vo.room_img}"
									alt="" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="m_details_content m-bottom-40">
								<h2>${vo.room_name}</h2>
								<p>기준 인원 : ${vo.standard}</p>
								<p>객실 가격 : ${vo.sale_price}</p>
								<p>객실 설명 : ${vo.room_info}</p>
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
					<form name="stay_room_view" method="post" action="stay_room_reservation" onsubmit="">
					<input type="hidden" name="stay_no" value="${vo.stay_no}">
					<input type="hidden" name="room_no" value="${vo.room_no}">
					<input type="hidden" name="check_in" value="${check_in}">
					<input type="hidden" name="check_out" value="${check_out}">
					<input type="hidden" name="total_price" value="${total_price}">
					<input type="hidden" name="mem_id" value="${sessionScope.mem_id}">
						<table>
							<tr>
								<th width="10%">체크 인:</th>
								<td>&ensp;${check_in}</td>
							</tr>
							<tr>
								<td><br></td>
								<td><br></td>
							</tr>
							<tr>
								<th>체크 아웃:</th>
								<td>&ensp;${check_out}</td>
							</tr>
							<tr>
								<td><br></td>
								<td><br></td>
							</tr>
							<tr>
								<th>숙박 인원:</th>
								<td>&ensp;<input type="number" min="1" max="${vo.standard}" value="1" name="stay_people"></td>
							</tr>
							<tr>
								<td><br></td>
								<td><br></td>
							</tr>
							<tr>
								<th>결제 방법:</th>
								<td>&ensp;<input type="radio" name="pay_method" value="신용카드" checked>신용카드&ensp;
								<input type="radio" name="pay_method" value="체크카드">체크카드&ensp;
								<input type="radio" name="pay_method" value="무통장입금">무통장입금&ensp;
								<input type="radio" name="pay_method" value="현금결제">현금결제&ensp;
								<input type="radio" name="pay_method" value="휴대폰결제">휴대폰결제&ensp;</td>
							</tr>
							<tr>
								<td><br></td>
								<td><br></td>
							</tr>
							<tr>
								<th>결제 금액:</th>
								<td>&ensp;${total_price}</td>
							</tr>
							<tr>
								<td><br></td>
								<td><br></td>
							</tr>
							<tr>
								<td><input type="submit" value="결제"></td>
								<td><input type="button" value="취소" onclick="window.history.back();"></td>
							</tr>
							<tr>
								<td><br></td>
								<td><br></td>
							</tr>
						</table>
					</form>
				</div>

			</div>

		</section>
		<!-- End off Model Details Section -->
		

		<%@include file="../../main/sample/footer.jsp" %>
	<!-- JS includes -->

	<script type="text/javascript">
		function change_parent_url(url) {
			document.location = url;
		}
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

	<script src="${js}bootstrap.green.min.js"></script>

	<script src="${js}stayReservation.js"></script>


</body>
</html>