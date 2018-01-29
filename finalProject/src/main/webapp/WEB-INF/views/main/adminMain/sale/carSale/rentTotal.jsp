<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<h2><center>결산</center></h2>


<div class="container">
	<div class="row">
		<h3>총매출액(렌트) : ${priceMap['total']}</h3>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div id="firstChat"></div>
		</div>
		<div class="col-md-6">
			<div id="secondChat"></div>
		</div>
	</div>
	<div class="row">
		<form action="carSalePage" method="post" name="totalForm">
			<!--  <select name="year">
				<option>2018</option>
				<option>2019</option>
				<option>2020</option>
				<option>2021</option>
				<option>2022</option>
				<option>2023</option>
			</select>
			<input type="submit" value="확인"> -->
			<input type="submit" value="◀" onClick="javascript:this.form.year.value--;">
			<input type="text" name="year" class="year"  value="${today}" size="2" style="text-align:center;">
			<input type="submit" value="▶" onClick="javascript:this.form.year.value++;">
		</form>
		<div class="col-md-12">
			<div id="finalChart"></div>
		</div>
	</div> 
</div>

<script type="text/javascript">

	// 로딩 완료시 함수 실행하여 차트 생성
	google.charts.setOnLoadCallback(drawChartFirst);
	google.charts.setOnLoadCallback(drawChartSecond);
	google.charts.setOnLoadCallback(drawChartFinal);
	// 차트 옵션을 전역으로 설정했습니다. 설정을 바꿔보는 예제를 만들기 위해서요.
	var firstChart_options = {
		title : '차종별 가격 차트',
		width : 600,
		height : 400,
		bar : {
			groupWidth : '50%' 
		},
		legend : {
			position : 'bottom' 
		},
		 series: {
            0: { color: '#a561bd' },
            1: { color: '#c784de' },
            2: { color: '#f1ca3a' },
            3: { color: '#2980b9' },
            4: { color: '#e67e22' }
          }

	};

	function drawChartFirst(){
		var data = google.visualization.arrayToDataTable(	
		[
			['Element', '가격별'], 
			['소형', ${priceMap['소형']}],
			['중형', ${priceMap['중형']}],
			['대형', ${priceMap['대형']}],
			['SUV', ${priceMap['SUV']}],
			['스포츠', ${priceMap['스포츠']}],
		]);

		var firstChart = new google.visualization.ColumnChart(document.getElementById('firstChat'));
		firstChart.draw(data, firstChart_options);
	}
  
	// 두번째 차트 
	
	var secondChart_options = {
		title : '차종별 판매건수비율',
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
			['Element', '판매건수'],
			['소형', ${kindMap['소형']}],
			['중형', ${kindMap['중형']}],
			['대형', ${kindMap['대형']}],
			['SUV', ${kindMap['SUV']}],
			['스포츠', ${kindMap['스포츠']}],
		]);

		var secondChart = new google.visualization.PieChart(document.getElementById('secondChat'));
		secondChart.draw(data, secondChart_options);
	}
	
	//세번째차트
	
	var finalChart_options = {
		title : '${today}년 월별 가격 차트'/* '${printYear}' */,
		width : 900,
		height : 500,
		bar : {
			groupWidth : '50%' 
		},
		legend : {
			position : 'bottom' 
		}
	};

	function drawChartFinal(){
		var data = google.visualization.arrayToDataTable([
			['Element', '월별'],
			['1',${dateMap['01']}],
			['2',${dateMap['02']}],
			['3',${dateMap['03']}],
			['4',${dateMap['04']}],
			['5',${dateMap['05']}],
			['6',${dateMap['06']}],
			['7',${dateMap['07']}],
			['8',${dateMap['08']}],
			['9',${dateMap['09']}],
			['10',${dateMap['10']}],
			['11',${dateMap['11']}],
			['12',${dateMap['12']}],
			
		]);
		var finalChart = new google.visualization.LineChart(document.getElementById('finalChart'));
		finalChart.draw(data, finalChart_options);
	}
	
</script>

</body>
</html>
