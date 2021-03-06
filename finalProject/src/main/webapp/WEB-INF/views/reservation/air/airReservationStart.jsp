<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<%@ include file="../../../../resources/session/sessionCheck.jsp" %>

<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>Pouseidon - Free HTML5 Model Agency Bootstrap Template</title>
<meta name="description" content="">
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
<link rel="stylesheet" href="${css}magnific-popup.css">
<link rel="stylesheet" href="${css}bootsnav.css">
<link rel="stylesheet" href="${css}carousel.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${css}style.css">
<link rel="stylesheet" href="${css}responsive.css" />

<style type="text/css">
	/* 인풋 */
.checkbox[type=checkbox], .checkbox[type=radio] {display:none;}
label.input-label { 
  display: inline-block;
  font-size: 13px;
  cursor: pointer;
  }
label.input-label::before {
  display: inline-block;
  margin:0 20px;
  font-family: FontAwesome;
  font-size: 20px;
  color: rgba(4, 120, 193,0.2);
  -webkit-transition: transform 0.2s ease-out, color 0.2s ease;
  -moz-transition: transform 0.2s ease-out, color 0.2s ease;
  -ms-transition: transform 0.2s ease-out, color 0.2s ease;
  -o-transition: transform 0.2s ease-out, color 0.2s ease;
  transition: transform 0.2s ease-out, color 0.2s ease;
  -webkit-transform: scale3d(0.8,0.8,1);
  -moz-transform: scale3d(0.8,0.8,1);
  -ms-transform: scale3d(0.8,0.8,1);
  -o-transform: scale3d(0.8,0.8,1);
  transform: scale3d(0.8,0.8,1);
}
label.input-label.checkbox::before {
  content: "\f0c8";
}
label.input-label.radio::before {
  content: "\f111";
}
input.checkbox + label.input-label:hover::before {
  -webkit-transform: scale3d(1,1,1);
  -moz-transform: scale3d(1,1,1);
  -ms-transform: scale3d(1,1,1);
  -o-transform: scale3d(1,1,1);
  transform: scale3d(1,1,1);
}

input.checkbox + label.input-label:active::before {
  -webkit-transform: scale3d(1.5,1.5,1);
  -moz-transform: scale3d(1.5,1.5,1);
  -ms-transform: scale3d(1.5,1.5,1);
  -o-transform: scale3d(1.5,1.5,1);
  transform: scale3d(1.5,1.5,1);
}

input.checkbox:checked + label.input-label::before {
  display: inline-block; 
  font-family: FontAwesome; 
  color:#0478c1;
  -webkit-transform: scale3d(1,1,1);
  -moz-transform: scale3d(1,1,1);
  -ms-transform: scale3d(1,1,1);
  -o-transform: scale3d(1,1,1);
  transform: scale3d(1,1,1);
}
input.checkbox:checked + label.input-label.checkbox::before {
    content:"\f14a";
}
input.checkbox:checked + label.input-label.radio::before {
    content:"\f058";
}
</style>

<script src="${js}vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">


	
	$(function(){
		
		$("#airPlaneSearch").click(function(){
			
			var f = document.airReservationForm;
	
			var urlAddr = "airPlaneSearch?seatLevel="+f.seatLevel.value+
						"&startAirport_Key="+f.startAirport_Key.value+
						"&endAirport_Key="+f.endAirport_Key.value+
						"&s_fromDate="+f.s_fromDate.value+
						"&s_toDate="+f.s_toDate.value
			$.ajax({
				url: urlAddr,
				type: 'GET',
				
				success: function(msg) {
					$("#searchResult").html(msg);		
				},				
				error: function() {
					alert('오류');
				}			
			});	
			
			return false;
		})
	
	})
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

		<%@include file="../../main/sample/header.jsp" %>
		
		<!-- 본문내용 작성자 : 유준렬 -->
		<br>
		<div class="container">
					
			<div class="row">
					<div class="col-md-5">
						<h4><span class="glyphicon glyphicon-plane">항공권예매</span></h4><br>
    					<form action="" method="POST" name="airReservationForm">
		    				<div class="well well-lg">
								<div>
								<label>좌석등급</label>
									 <select name="seatLevel" class="form-control">
										<option value="all">전체</option>
										<option value="nomal">일반석</option>
										<option value="high">고급석</option>
										<option value="premium">프리미엄</option>
									  </select>
								</div>
								<hr>
									<div>
										<label>출발</label>
										<select id="startAirport" name="startAirport_Key" class="form-control">
												<option value="noSelect">선택</option>
												<c:forEach var="airPort" items="${airPortList}">
													<option value="${airPort.airportNo}">${airPort.airportName}</option>
												</c:forEach>
											</select>
										<label>도착</label>
										<select id="endAirport" name="endAirport_Key" class="form-control">
												<option value="noSelect">선택</option>
												<c:forEach var="airPort" items="${airPortList}">
													<option value="${airPort.airportNo}">${airPort.airportName}</option>
												</c:forEach>
											</select>
									</div>   					
		     							<hr>
		     						<div class="container-fluid">
		     							<div class="row">
											<div class="col-md-6">
											<label>출발일</label><input id="fromDate" type="date" name="s_fromDate" class="form-control">
											</div>
											<div class="col-md-6">
											<label>도착일</label><input id="toDate" type="date" name="s_toDate" class="form-control">
											</div>
										</div>
									</div>
										<hr>
									<div class="container-fluid">
										<div class="row">
											<div class="col-md-6 col-md-offset-8">		
		     									<button class="btn btn-success btn-lg" id="airPlaneSearch">항공편 조회</button>
		     								</div>
		     							</div>
		     						</div>
		     					<hr>
     						</div>
     						</form>
     					</div>
     				<div class="col-md-6">
     					<h4><span class="glyphicon glyphicon-map-marker">공항위치정보</span></h4><br>
   						<div class="container-fluid">
   							<div class="row">
   								<div class="well well-lg">
   									<form class="form-inline">
   										<div class="wrap">
   											<c:set var="index" value="0"></c:set>
	   										<c:forEach var="i" items="${airPortList}">
		   											<input type="radio" id="${i.airportNo}_id" class="checkbox" name="airPortWeather" onchange="mapView(${i.xPos},${i.yPos})">
		   											 <label for="${i.airportNo}_id" class="input-label radio">${i.airportName}</label>
		   										<c:set var="index" value="${index+1}"></c:set>
		   										<c:if test="${index%5==0}"><br></c:if>
		   									</c:forEach>
	   									</div>
	   										<script type="text/javascript">
	   											$("input[name='airPortWeather']").eq(0).attr("checked","checked");
											</script>
   									</form>
   								</div>
   							</div>
   							<div class="row">
   								<div id="map" style="width: 100%; height:350px;"></div>
   								<script type="text/javascript">
   									var uluru = {}
									uluru.lat=37.5580888
									uluru.lng=126.8023983
   								
   									function mapView(x,y){
   										uluru.lat=x
   										uluru.lng=y
   										initMap();
   									}
   								
									function initMap(){
										
										var map = new google.maps.Map(document.getElementById("map"),{
											zoom:14,
											center:uluru
										});
										
										var marker = new google.maps.Marker({
											position:uluru,
											map:map
										});
									}
								</script>
								<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKRKVVsBAnmA_ZwgCV6PC3jQY31z89kXg&callback=initMap"
								 async defer></script>
   							</div>
   						</div>
    				</div>
    		
	    	</div>
			<div class="row">
				<div class="col-md-12">
					<div id="searchResult"></div>				
				</div>
			</div>
		</div>
		<!-- 본문내용 작성자 : 유준렬 -->	
		
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