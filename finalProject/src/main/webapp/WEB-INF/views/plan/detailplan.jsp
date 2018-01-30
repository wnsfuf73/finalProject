<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${css}bootstrap.min.css">
<link rel="stylesheet" href="${css}myBootstrap.css">
<link rel="stylesheet" href="${css}makeplan.css">
<link rel="stylesheet" href="${css}style.css">
<link rel="stylesheet" href="${css}wrtcss/essay.css">

</head>
<body>
	<!-- 내비게이션 바 -->
	<nav class="[ navbar navbar-fixed-top ][ navbar-bootsnipp animate ]" role="navigation">
    	<div class="[ container ]">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="[ navbar-header ]">
				<div class="[ animbrand ]">
					<a class="[ navbar-brand ][ animate ]" href="main">동행</a>
					<a href="plan">닫기</a>
				</div>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="[ collapse navbar-collapse ]" id="bs-example-navbar-collapse-1">
				<ul>
					<li>지역 선택 -> 상세 일정 만들기</li>
					<c:if test="${sessionScope.mem_id == null}">					
							<li><a href="" data-toggle="modal" data-target="#login">로그인</a></li>
							<li><a href="" data-toggle="modal" data-target="#register">회원가입</a></li>
						</c:if>
						<c:if test="${sessionScope.mem_id != null}">
							<li class="dropdown">
							<a class="dropdown-toggle"
								data-toggle="dropdown" href="#">${sessionScope.mem_id}님</a>
								<ul class="dropdown-menu">
									<li><a href="xxxStart">계획하기</a></li>
									<li><a href="xxxStart">여행후기</a></li>
									<li><a href="myPageStart">마이페이지</a></li>
								</ul>
							</li>
									
							<li><a href="logout" >로그아웃</a></li>
						</c:if>
				</ul>
			</div>
		</div>
		<div class="clear"></div>
	</nav>
	<form name="detailplan_form" method="post" action="detailPlanPro">
	<div class="container">
		<div class="row">
		<br>
			<span>날짜와 지역을 선택하고, 장소를 선택해서 저장하세요.</span>
			<div class="col-md-12">
				<div class="col-md-2">
					<div class="select_date_top">
						<div>선택한 날짜</div>
					</div>
					<div class="select_date_content">
						 <c:set var="length" value="${fn:length(period)}"></c:set>
						 <c:forEach var="date" items="${period}" varStatus="status">
						 <div>
						 	<div class="select_date" id="select_date_here">
								<input type="radio" name="date" value="${date}">${date}
								<c:if test="${status.index==0}">
									<input type="hidden" name="startDate" value="${date}">
								</c:if>
								<c:if test="${status.index==length-1}">
									<input type="hidden" name="endDate" value="${date}">
								</c:if>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-2">
					<div class="select_area_top">
						<div>지역</div>
					</div>
					<div class="select_area_content">
						<div class="select_area">
							<div class="area" id="seoul" onclick="getLocation('서울')">
							서울
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="incheon" onclick="getLocation('인천')">
							인천
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="kyengki" onclick="getLocation('경기')">
							경기
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="kangwon" onclick="getLocation('강원')">
							강원
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="choongbuk" onclick="getLocation('충북')">
							충북
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="choongnam" onclick="getLocation('충남')">
							충남
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="daejeon" onclick="getLocation('대전')">
							대전
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="daegu" onclick="getLocation('대구')">
							대구
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="kyeongbuk" onclick="getLocation('경북')">
							경북
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="kyeongnam" onclick="getLocation('경남')">
							경남
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="ulsan" onclick="getLocation('울산')">
							울산
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="busan" onclick="getLocation('부산')">
							부산
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="kwangju" onclick="getLocation('광주')">
							광주
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="jeonbuk" onclick="getLocation('전북')">
							전북
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="jeonnam" onclick="getLocation('전남')">
							전남
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="jeju" onclick="getLocation('제주도')">
							제주도
							</div>
						</div>
						<div class="select_area">
							<div class="area" id="dokdo" onclick="getLocation('울릉도/독도')">
							울릉도/독도
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-5">
					<div class="select_location_top">
						<div>장소</div>
					</div>
					<div class="select_location_content">
						<div class="select_location" id="location_result">
							
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="plan_button">
									<input type="hidden" name="planNo" value="${planNo}">
									<input type="button" value="작성" onclick="planWrite()">
								</div>
							</div>
						</div>
						<div class="row">							
							<div class="col-md-12">
								<!-- 코스추가장소 -->
								<ul id="courses">
								</ul>
							</div>			
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>	
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${js}bootstrap.js"></script>
<script type="text/javascript">
	
	/* 장소 불러오기  */
	function getLocation(loc){
		$.ajax({
			url : "getLocation?area="+loc ,
			type : 'GET',
			success : function(msg) {
				$("#location_result").html(msg);
			},
			error : function() {
				alert("error");
			}
		})
	}
	
	/* 계획 코스 추가 */
	function locationClick(location_num){
		var loc_name = $("#locName_"+location_num).text();
		var content = "<li onclick='removeNode(this)'>"+
						"<input type=hidden name=locationNum value="+location_num+">"+
						loc_name + "</li>";		//장소의 정보(이름)을 가지고온다.
					 
		var lastNode = $("#courses li:last").text();
		if(lastNode!=loc_name || !lastNode){
			$("#courses").append(content);	//장소 추가
		} else{
			alert("같은장소입니다.");
		}
	}
	
	/* 제이쿼리 */
	$(document).ready(function() {
		/* 여행일정 정하기 ajax */
		$('#btn').click(function() {
	
			var area = $("input:checkbox[name='detail']:checked").val();
			var date = $("input:radio[name='detail']:checkd").val();
			alert(area);
			
			 $.ajax({
				url: "detail_location?area="+area,
				type: 'GET',
				
				success: function(msg) {
					$('#result').html(msg);					
				},				
				error: function() {
					alert('오류');
				}			
			});			 
		});		
	});
	
	/* 계획 코스 삭제 */
	function removeNode(target){
	   var prev = $(target).prev().text();
	   var next = $(target).next().text();

	   if(prev==next){
		   $(target).next().remove();
		}
		
		target.remove();
		
		return false;
	}
	
	/* 상세 계획 작성하기. */
	function planWrite(){
		var selectLocation = $("#courses li").length;

		if(selectLocation==0){
			alert("장소를 선택하세요");
			return false;
		}
		
		var chk_radio = document.getElementsByName('date');
		var sel_type = null;
		for(var i=0; i<chk_radio.length; i++){
			if(chk_radio[i].checked == true){ 
				sel_type = chk_radio[i].value;
				break;
			}
		}

		if(sel_type == null){
            alert("날짜를 선택하세요."); 
			return false;
		}
		
		document.detailplan_form.submit();
		return true;
	}
	
</script>
</body>
</html>