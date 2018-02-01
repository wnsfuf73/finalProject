$(function() {
		
		
		$(".where_manager").css("display","none");
		$(".reservation_manager").css("display","none");
		$(".sale_manager").css("display","none");
		
		$("iframe").attr("src","boardManager");
		
		//홈페이지 관리 클릭
		$("#homeManage_click").click(function(){
			$(".homepage_manager").css("display","block");
			$(".where_manager").css("display","none");
			$(".reservation_manager").css("display","none");
			$(".sale_manager").css("display","none");
			$("iframe").attr("src","boardManager");
			
		})
		

		//여행지관리 클릭
		$("#where_click").click(function(){
			
			$(".homepage_manager").css("display","none");
			$(".where_manager").css("display","block");
			$(".reservation_manager").css("display","none");
			$(".sale_manager").css("display","none");
			
			$("iframe").attr("src","add");
			return false;
		})
		
		//항공예약관리 클릭
		$("#airplane_click").click(function(){
			$(".reservation_manager").css("display","block");
			$(".homepage_manager").css("display","none");
			$(".where_manager").css("display","none");
			$(".sale_manager").css("display","none");
			
			var content = "<h4>항공 예약 관리 </h4>" +
						  "<ul class='nav nav-pills nav-stacked'>" +
						  "<li><a href='airReservationList' target='contentFrame'>예약 리스트 보기</a></li>" +
				 		  "<li><a href='airPlaneAdd' target='contentFrame'>항공 노선 추가</a></li>" +
						  "<li><a href='airOperationChange' target='contentFrame'>항공 운행 정보 변경</a></li>" +
						  "</ul><br>";
      
			$(".reservation_manager_content").html(content);
			$("iframe").attr("src","airReservationList");
		})
		
		
		// 숙박관리 클릭
		$("#stay_click").click(
			function() {
				$(".reservation_manager").css("display", "block");
			$(".homepage_manager").css("display", "none");
			$(".where_manager").css("display", "none");
			$(".sale_manager").css("display","none");
	
			var content = "<h4>숙박 예약 관리 </h4>"
					+ "<ul class='nav nav-pills nav-stacked'>"
					+ "<li><a href='stay_reservation_list' target='contentFrame'>숙박 예약 현황</a></li>"
					+ "<li><a href='stay_add' target='contentFrame'>숙박지 추가</a></li>"
					+ "<li><a href='stay_list' target='contentFrame'>숙박지 관리</a></li>"
					+ "</ul><br>";
	
			$(".reservation_manager_content").html(content);
			$("iframe").attr("src","stay_reservation_list");
		})
		
		//렌트카관리클릭
		$("#car_click").click(function(){
			$(".reservation_manager").css("display","block");
			$(".homepage_manager").css("display","none");
			$(".where_manager").css("display","none");
			$(".sale_manager").css("display","none");
			
			var content = "<h4>렌트카 예약 관리 </h4>" +
						  "<ul class='nav nav-pills nav-stacked'>" +
						  "<li><a href='rentReservationList' target='contentFrame'>렌트카 예약 리스트</a></li>" +
				 		  "<li><a href='rentAddPage' target='contentFrame'>차량 등록</a></li>" +
						  "<li><a href='rentDeletePage' target='contentFrame'>차량 삭제</a></li>" +
						  "</ul><br>";

			$(".reservation_manager_content").html(content);
			$("iframe").attr("src","rentReservationList");
		})
		
		$("#sale_click").click(function() {
			
			$(".sale_manager").css("display","block");
			$(".homepage_manager").css("display","none");
			$(".where_manager").css("display","none");
			$(".reservation_manager").css("display","none");
			
			var content = "<h4>결산</h4><hr>" +
			  "<ul class='nav nav-pills nav-stacked'>" +
			  "<li><a href='salePage' target='contentFrame'>전체</a></li>" +
			  "<li><a href='staySalePage' target='contentFrame'>숙박</a></li>" +
			  "<li><a href='airSalePage' target='contentFrame'>항공</a></li>" +
			  "<li><a href='carSalePage' target='contentFrame'>렌트</a></li>" +
			  "</ul><br>";

			$(".sale_manager_content").html(content);
			
			$("iframe").attr("src","salePage");
			return false;
		})
		
})