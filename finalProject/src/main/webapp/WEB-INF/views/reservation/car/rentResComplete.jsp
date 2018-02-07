<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		
<script src="${js}vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



<script type="text/javascript">
	$(function(){
		$("#myPageBtn").click(function() {
			window.location='myPageStart'
		});
		$("#homeBtn").click(function() {
			window.location='main'
		});		
	})
	
 	
</script>

<style type="text/css">
	#myPageBtn{   
		border: #7acce4 3px solid;
	    background-color: white;
	    font-size: 30px;
	    font-weight: 100;
	    color:#7acce4;
	}
	#homeBtn {
		border: #7acce4 3px solid;
	    background-color: white;
	    font-size: 30px;
	    font-weight: 100;
	    background-color: 7acce4;
	} 
</style>
<title>Insert title here</title>
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

	<%@include file="../../main/sample/header.jsp" %>
		<!--End off Home Sections-->
				<div class="container">	
				<div class="row">
					<div class="col-md-12">
						<center>
							<img src="${images}air/reserCompleteImg.png">
						</center>
					</div>
				</div><br>
				<div class="row">
					<div class="col-md-12">
						<center>
							<h2>렌트카 예약이 정상적으로 완료되었습니다.</h2>
						</center>
					</div>
				</div><br>
				<div class="row">
					<div class="col-md-3 col-md-offset-3">
						<button class="btn btn-block btn-outline-info" id="myPageBtn">마이페이지</button>
					</div>
					<div class="col-md-3">
						<button class="btn btn-block btn-outline-info" id="homeBtn">홈으로</button>
					</div>
				</div><br><br>
			
				<div class="row">
					<div class="col-md-12">
						<div class="well well-lg">
							<h5><span class="fa fa-car">구매정보</span></h5>
							<hr>
							<ul class="list-group">
							  <li class="list-group-item">차량 : ${vo.car_name}</li>
							  <li class="list-group-item">예약일시 : ${vo.rental_day} ${vo.rental_time}</li>
							  <li class="list-group-item">반납일시 : ${vo.return_day} ${vo.return_time}</li>
							  <li class="list-group-item">운전자 : ${vo.name}</li>
							  <li class="list-group-item">전화번호 : ${vo.phone1} - ${vo.phone2} - ${vo.phone3}</li>
							</ul>	
						</div>
					</div>
				</div>	
				<div class="row">
					<div class="col-md-12">
						<div class="well well-lg">
							<h5><span class="glyphicon glyphicon-shopping-cart">결제정보</span></h5>
							<hr>
							<ul class="list-group">
							  <li class="list-group-item">결제방법 : ${vo.paymethod}</li>
							  <li class="list-group-item">결제금액 : ${vo.price} 원</li>
							</ul>	
						</div>
					</div>
				</div>			
			</div>		

	

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