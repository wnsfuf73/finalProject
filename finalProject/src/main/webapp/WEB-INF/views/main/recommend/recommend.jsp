<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="service_content_area">
			<!-- Service LEFT SIDE -->
			<div class="col-md-4 service_left wow fadeInLeft">
			
				<!-- 관광테마목록 -->
				<div class="service_items">
					<div class="row" id="tourism_thema">
						<!-- ICON -->
						<div class="col-xs-3">
							<div class="hexagon">
								<div class="about-content">
									<img src="${images}recommend/tourism.png" alt="tourism">
								</div>
							</div>
						</div>

						<div class="col-xs-9">
							<div class="text-left service_left_text">
								<h4 class="main-color">관광 테마 추천 목록 보기</h4>
								<p>관광 테마에 있는 여행기들을 <br>보여줍니다.</p>
							</div>
						</div>
					</div>
				</div>
				

				<!-- 맛집테마목록 -->
				<div class="service_items">
					<div class="row" id="restaurant_thema">
						<!-- ICON -->
						<div class="col-xs-3">
							<div class="hexagon">
								<div class="about-content">
									<img src="${images}recommend/restaurant.png" alt="restaurant">
								</div>
							</div>
						</div>

						<div class="col-xs-9">
							<div class="text-left service_left_text">
								<h4 class="main-color">맛집 테마 추천 목록 보기</h4>
								<p>맛집 테마에 있는 여행기들을<br>보여줍니다.</p>
							</div>
						</div>

					</div>
				</div>
				<!-- end Single Service item -->

				<!-- 레져테마목록 -->
				<div class="service_items">
					<div class="row" id="leisure_thema">
						<!-- ICON -->
						<div class="col-xs-3">
							<div class="hexagon">
								<div class="about-content">
									<img src="${images}recommend/leisure.png" alt="leisure">
								</div>
							</div>
						</div>

						<div class="col-xs-9">
							<div class="text-left service_left_text">
								<h4 class="main-color">레져 테마 목록 보기</h4>
								<p>레져 테마에 있는 여행기들을<br>보여줍니다.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /END Service LEFT -->

			<!-- 추천목록 뿌리는 버튼 -->
			<div class="col-md-4 sm-m-top-40 sm-text-center">
				<div class="service-img wow bounceIn" id="result2" style="height:406px; overflow-x: hidden; overflow-y: auto;">
					<!-- ....................................................................... -->
				</div>
			</div>

			<!-- Service RIGHT -->
			<div class="col-md-4 service_right wow fadeInRight sm-m-top-40">

				<!-- 힐링테마목록 -->
				<div class="service_items">
					<div class="row" id="healing_thema">

						<div class="col-xs-9">
							<div class="service_right_text p-l-15 text-right">
								<h4 class="main-color">힐링 테마 보기 목록</h4>
								<p>힐링 테마에 있는 여행기들을<br>보여줍니다.</p>
							</div>
						</div>

						<!-- ICON -->
						<div class="col-xs-3">
							<div class="hexagon">
								<div class="about-content">
									<img src="${images}recommend/healing.png" alt="healing">
								</div>
							</div>
						</div>

					</div>

				</div>
				<!-- end Single Service item -->



				<!-- 좋아요순 목록 -->
				<div class="service_items">
					<div class="row" id="like_thema">

						<div class="col-xs-9">
							<div class="service_right_text p-l-15 text-right">
								<h4 class="main-color">좋아요순 목록 보기</h4>
								<p>좋아요 순서대로 여행기를<br>보여줍니다.</p>
							</div>
						</div>


						<!-- ICON -->
						<div class="col-xs-3">
							<div class="hexagon">
								<div class="about-content">
									<img src="${images}recommend/like.png" alt="like">
								</div>
							</div>
						</div>

					</div>

				</div>
				<!-- end Single Service item -->

				<!-- 조회수순 목록 보기 -->
				<div class="service_items" id="count_thema">
					<div class="row">
						<div class="col-xs-9">
							<div class="service_right_text p-l-15 text-right">
								<h4 class="main-color">조회수순 목록 보기</h4>
								<p>조회수 많은 순서대로 여행기를<br>보여줍니다.</p>
							</div>
						</div>

						<!-- ICON -->
						<div class="col-xs-3">
							<div class="hexagon">
								<div class="about-content">
									<img src="${images}recommend/count.png" alt="count">
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- end Single Service item -->
			</div>
			<!-- /END Service RIGHT -->
	</div>
</div>
<!--End off row -->
</div>
<script type="text/javascript">
	/* 관광테마목록  ajax */
	$(document).ready(function() {
		$('#tourism_thema').click(function() {
			
			 $.ajax({
				url: "tourism_thema",
				type: 'GET',
				
				success: function(msg) {
					$('#result2').html(msg);					
				},				
				error: function() {
					alert('오류');
				}			
			});			 
		});		
	});
	
	/* 맛집테마목록  ajax */
	$(document).ready(function() {
		$('#restaurant_thema').click(function() {
			 $.ajax({
				url: "restaurant_thema",
				type: 'GET',
				
				success: function(msg) {
					$('#result2').html(msg);					
				},				
				error: function() {
					alert('오류');
				}			
			});			 
		});		
	});
	
	/* 레져테마목록  ajax */
	$(document).ready(function() {
		$('#leisure_thema').click(function() {
			 $.ajax({
				url: "leisure_thema",
				type: 'GET',
				
				success: function(msg) {
					$('#result2').html(msg);					
				},				
				error: function() {
					alert('오류');
				}			
			});			 
		});		
	});
	
	/* 힐링테마목록  ajax */
	$(document).ready(function() {
		$('#healing_thema').click(function() {
			 $.ajax({
				url: "healing_thema",
				type: 'GET',
				
				success: function(msg) {
					$('#result2').html(msg);					
				},				
				error: function() {
					alert('오류');
				}			
			});			 
		});		
	});
	
	/* 좋아요순테마목록  ajax */
	$(document).ready(function() {
		$('#like_thema').click(function() {
			 $.ajax({
				url: "like_thema",
				type: 'GET',
				
				success: function(msg) {
					$('#result2').html(msg);					
				},				
				error: function() {
					alert('오류');
				}			
			});			 
		});		
	});
	
	/* 조회수순테마목록  ajax */
	$(document).ready(function() {
		$('#count_thema').click(function() {
			 $.ajax({
				url: "count_thema",
				type: 'GET',
				
				success: function(msg) {
					$('#result2').html(msg);					
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