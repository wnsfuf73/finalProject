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
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">


<!--For Plugins external css-->
<!--<link rel="stylesheet" href="${css}plugins.css" />-->

<!--Theme custom css -->
<link rel="stylesheet" href="${css}style.css">
<!--<link rel="stylesheet" href="${css}colors/maron.css">-->

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
<script src="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
<!-- 달력을 한국어로 표시 -->
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/i18n/datepicker-ko.js"></script>
<script type="text/javascript">
$(function() {
	
	$.datepicker.setDefaults($.datepicker.regional['ko']);//달력을 한국어로 표시
 	$( "#datepicker" ).datepicker({
 		datefomat:'yyyy-mm-dd', //날짜형식
 		showAnim : 'show',//에니메이션
 		minDate:'+0', //오늘날짜 이전 선택불가
     	maxDate:'+3m', //최고 3달후까지 선택가능
     	changeMonth: true, //월을 이동하기 위한 선택상자 표시여부
     	onClose:function(selectedDate){
     		//시작일이 닫힐때 종료일의 선택할수있는 최소 날짜를 선택한 시작일로 지정
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
 	})
   
	$("#timepicker").timepicker({
		interval: 60, 
	   	timeFormat: "HH:mm",
	   	minHour: 08,
	   	maxHour: 20,
	   	dynamic: false
   	});
	
	$("#return_timepicker").timepicker({
	   	interval: 60, 
	   	timeFormat: "HH:mm",
	   	minHour: 08,
	   	maxHour: 20,
	   	dynamic: false
   	});
	
});
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
		
		<br>
		<div class="container">
		 <form action="rentList" method="post" name="rentForm">
			<h2>차량 예약</h2>
				<div class="row">
				    <div class="col-sm-1">
				    	대여일 :
				    </div>
				    <div class="col-sm-2">
				    	<input type="text" id="datepicker" required="required" name="rental_day">
				    </div>
				    <div class="col-sm-1">
				    	대여 시간 : 
				    </div>
				    <div class="col-sm-2">
				    	<input type="text" style="display: inline-block;" name="rental_time" id="timepicker" required="required" placeholder="시간을 선택하세요">
				    </div>				    
				    <div class="col-sm-1">
						반납일 :
				    </div>
				    <div class="col-sm-2">
				    	 <input type="text" id="datepickerEnd" required="required" name="return_day">
				    </div>
				    <div class="col-sm-1">
				    	반납 시간 : 
				    </div>
				    <div class="col-sm-2">
				    	<input type="text" style="display: inline-block;" name="return_time" id="return_timepicker" required="required" placeholder="시간을 선택하세요">
				    </div>	    			    			
				</div>
				<br>
				<div class="row">
					 <div class="col-sm-1">
						차량유형 :		    
				    </div>
				    <div class="col-sm-6">
						 전체<input type="radio" name="car_kind" value="전체" checked="checked">
						 소형<input type="radio" name="car_kind" value="소형"> 
			   	 	          중형<input type="radio" name="car_kind" value="중형"> 
						 대형<input type="radio" name="car_kind" value="대형">
						SUV<input type="radio" name="car_kind" value="SUV"> 
					        스포츠<input type="radio" name="car_kind" value="스포츠">			    
				    </div>
				</div>
				<div class="row">
					<center><button type="submit" class="btn btn-default btn-lg">조회</button></center>
				</div>
				</form>
		 
		</div>

		<%@include file="../../main/sample/footer.jsp" %>
	</div>
</body>
</html>