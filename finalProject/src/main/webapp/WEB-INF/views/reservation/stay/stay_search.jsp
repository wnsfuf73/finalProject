<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>

<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>Pouseidon - Free HTML5 Model Agency Bootstrap Template</title>
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

<link rel="stylesheet" href="${css}slick.css">
<link rel="stylesheet" href="${css}slick-theme.css">
<link rel="stylesheet" href="${css}animate.css">
<link rel="stylesheet" href="${css}fonticons.css">
<link rel="stylesheet" href="${css}font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.css">
<link rel="stylesheet" href="${css}magnific-popup.css">
<link rel="stylesheet" href="${css}bootsnav.css">
<link rel="stylesheet" href="${css}carousel.css">
<link rel="stylesheet" href="${css}stayReservation.css">

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

		<section id="stayReservation_main">
			<div class="container">
				<br>
				<form name="stayReservation_main" method="post" action="stay_search"
					onsubmit="">
					<div class="row">
						<div class="col-md-12">
						<div class="input-group">
							<input type="search" class="form-control input-lg" id="search" name="search"
								placeholder="원하시는 숙소를 입력해 주세요.">
								<div class="input-group-btn"><button class="btn btn-default" type="submit" style="height:46px;"><i class="glyphicon glyphicon-search"></i></button>
								</div>
								</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-2">숙박 종류:</div>

						<div class="col-md-2">
						<label class="radio-inline">
							<input type="radio" name="stay_kind" value="all" checked>전체</label>
							
						</div>

						<div class="col-md-2">
							<label class="radio-inline"><input type="radio" name="stay_kind" value="호텔">호텔</label>
						</div>

						<div class="col-md-2">
							<label class="radio-inline"><input type="radio" name="stay_kind" value="펜션">펜션</label>
						</div>

						<div class="col-md-2">
							<label class="radio-inline"><input type="radio" name="stay_kind" value="리조트">리조트</label>
						</div>

						<div class="col-md-2">
							<label class="radio-inline"><input type="radio" name="stay_kind" value="게스트하우스">게스트하우스</label>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-2">숙박 등급:</div>

						<div class="col-md-2">
							<label class="radio-inline"><input type="radio" name="stay_class" value="all" checked>전체</label>
						</div>

						<div class="col-md-2">
							<label class="radio-inline"><input type="radio" name="stay_class" value="3성">3등급</label>
						</div>

						<div class="col-md-2">
							<label class="radio-inline"><input type="radio" name="stay_class" value="4성">4등급</label>
						</div>

						<div class="col-md-2">
							<label class="radio-inline"><input type="radio" name="stay_class" value="5성">5등급</label>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-2">숙박 인원:</div>

						<div class="col-md-2">
							<input type="number" min="1" max="10" value="1"
								name="stay_people">
						</div>
					</div>
				</form>
			</div>
		</section>

		<!-- 검색 -->
		<section>
			<div>
				<table style="width: 1700px" align="center" border="1">
					<tr align="center">
						<td style="width: 15%">숙박 사진</td>
						<td style="width: 15%">숙박 이름</td>
						<td style="width: 30%">숙박 위치</td>
						<td style="width: 10%">숙박 등급</td>
						<td style="width: 10%">숙박 종류</td>
						<td style="width: 10%">객실 이름</td>
						<td style="width: 10%">객실 가격</td>
					</tr>
					<c:if test="${vos != null}">
					<c:forEach var="vo" items="${vos}">
						<tr>
							<td align="center"><img
								src="${images}stay/stay_location/${vo.stay_img1}" height="30%"></td>
							<td align="center"><a href="stay_view?stay_no=${vo.stay_no}">
									${vo.stay_name} </a></td>

							<td align="center">${vo.stay_address}</td>

							<td align="center">${vo.stay_class}</td>

							<td align="center">${vo.stay_kind}</td>

							<td align="center">${vo.room_name}</td>

							<td align="center">${vo.sale_price}원</td>

						</tr>
					</c:forEach>
					</c:if>
					<c:if test="${vos == null}">
					<tr>
						<td>
							찾으시는 숙소가 없습니다.
						</td>
					</tr>
					</c:if>
				</table>
			</div>
		</section>

		<br>
		<!--Company section-->

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

	<script src="${js}stayReservation.js"></script>

</body>
</html>