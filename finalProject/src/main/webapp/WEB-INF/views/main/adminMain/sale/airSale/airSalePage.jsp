<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../setting.jsp" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<style type="text/css">
		#yearButton{
		    width: max-content;
		    height: max-content;
		    padding: 0px 0px;
		    position: absolute;
		    bottom: 0px;
		    right: 300px;
		}
		
		.yearButton {
			-moz-box-shadow: 3px 4px 0px 0px #9fb4f2;
			-webkit-box-shadow: 3px 4px 0px 0px #9fb4f2;
			box-shadow: 3px 4px 0px 0px #9fb4f2;
			background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #7892c2), color-stop(1, #476e9e));
			background:-moz-linear-gradient(top, #7892c2 5%, #476e9e 100%);
			background:-webkit-linear-gradient(top, #7892c2 5%, #476e9e 100%);
			background:-o-linear-gradient(top, #7892c2 5%, #476e9e 100%);
			background:-ms-linear-gradient(top, #7892c2 5%, #476e9e 100%);
			background:linear-gradient(to bottom, #7892c2 5%, #476e9e 100%);
			filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#7892c2', endColorstr='#476e9e',GradientType=0);
			background-color:#7892c2;
			-moz-border-radius:8px;
			-webkit-border-radius:8px;
			border-radius:8px;
			border:1px solid #4e6096;
			display:inline-block;
			cursor:pointer;
			color:#ffffff;
			font-family:Arial;
			font-size:17px;
			padding:7px 25px;
			text-decoration:none;
			text-shadow:0px 1px 0px #283966;
		}
		.yearButton:hover {
			background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #476e9e), color-stop(1, #7892c2));
			background:-moz-linear-gradient(top, #476e9e 5%, #7892c2 100%);
			background:-webkit-linear-gradient(top, #476e9e 5%, #7892c2 100%);
			background:-o-linear-gradient(top, #476e9e 5%, #7892c2 100%);
			background:-ms-linear-gradient(top, #476e9e 5%, #7892c2 100%);
			background:linear-gradient(to bottom, #476e9e 5%, #7892c2 100%);
			filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#476e9e', endColorstr='#7892c2',GradientType=0);
			background-color:#476e9e;
		}
		.yearButton:active {
			position:relative;
			top:1px;
		}
	</style>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		google.charts.load('current', {packages:['corechart']});
	</script>

<title>결산</title>

</head>
<body>


<h2><center>항공 결산</center></h2>


<div class="container">
	<div class="row">
		<div class="col-md-6">
			<div id="firstChat"></div>
		</div>
		<div class="col-md-6">
			<div id="secondChat"></div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div id="finalChart"></div>
		</div>
	</div>
</div>
<!-- 
firstChat
	secondChat
	finalChat -->

<script type="text/javascript">
	// 로딩 완료시 함수 실행하여 차트 생성
	google.charts.setOnLoadCallback(drawChartFirst);
	google.charts.setOnLoadCallback(drawChartSecond);
	google.charts.setOnLoadCallback(drawChartFinal);
	// 차트 옵션을 전역으로 설정했습니다. 설정을 바꿔보는 예제를 만들기 위해서요.
	var firstChart_options = {
		title : '항목별',
		width : 600,
		height : 400,
		bar : {
			groupWidth : '50%' 
		},
		legend : {
			position : 'bottom' 
		}
	};

	function drawChartFirst(){
		var data = google.visualization.arrayToDataTable([
			['Element', '요일별'],
			['월', ${firstChat['월']}],
			['화', ${firstChat['화']}],
			['수', ${firstChat['수']}],
			['목', ${firstChat['목']}],
			['금', ${firstChat['금']}],
			['토', ${firstChat['토']}],
			['일', ${firstChat['일']}],
		]);

		var firstChart = new google.visualization.ColumnChart(document.getElementById('firstChat'));
		firstChart.draw(data, firstChart_options);
	}

	// 두번째 차트 
	
	var secondChart_options = {
		title : '총매출비율',
		width : 600,
		height : 400,
		bar : {
			groupWidth : '100%' //이 값을 수정하면 폭이 달라짐
		}
		,
		series: {
	        0: { color: '#a561bd' },
	        1: { color: '#c784de' },
		}
	}

	function drawChartSecond(){
		var data = google.visualization.arrayToDataTable([
			['Element', '결제수단'],
			['계좌이체', ${secondChat['계좌이체']}],
			['신용카드', ${secondChat['신용카드']}],
			['무통장입금',${secondChat['무통장입금']}],
			['핸드폰',${secondChat['핸드폰']}],
		]);

		var secondChart = new google.visualization.PieChart(document.getElementById('secondChat'));
		secondChart.draw(data, secondChart_options);
	}
	
	//세번째차트
	
	var finalChart_options = {
		title : '기간별'/* '${printYear}' */,
		width : 900,
		height : 500,
		bar : {
			groupWidth : '50%' 
		},
		legend : {
			position : 'top' 
		}
	};

	function drawChartFinal(){
		var data = google.visualization.arrayToDataTable([
			['월별', '판매금액'],
			['1',${finalChat['01']}],
			['2',${finalChat['02']}],
			['3',${finalChat['03']}],
			['4',${finalChat['04']}],
			['5',${finalChat['05']}],
			['6',${finalChat['06']}],
			['7',${finalChat['07']}],
			['8',${finalChat['08']}],
			['9',${finalChat['09']}],
			['10',${finalChat['10']}],
			['11',${finalChat['11']}],
			['12',${finalChat['12']}],
			
		]);
		var finalChart = new google.visualization.LineChart(document.getElementById('finalChart'));
		finalChart.draw(data, finalChart_options);
	}
	
</script>

</body>
</html>
