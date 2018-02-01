<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
//ajax 페이지요청
function getStayResList(requestPage) {
	$.ajax({
		url : "getStayResList?requestPage=" + requestPage,
		type : 'GET',
		success : function(msg) {
			$("#stay_res_list").html(msg);
		},
		error : function() {
			alert("error");
		}
	})
}

function getAirResList(requestPage) {
	$.ajax({
		url : "getAirResList?requestPage=" + requestPage,
		type : 'GET',
		success : function(msg) {
			$("#air_res_list").html(msg);
		},
		error : function() {
			alert("error");
		}
	})
}

function getCarResList(requestPage) {
	$.ajax({
		url : "getCarResList?requestPage=" + requestPage,
		type : 'GET',
		success : function(msg) {
			$("#car_res_list").html(msg);
		},
		error : function() {
			alert("error");
		}
	})
}

//ajax 페이지요청
//예약 취소
function airResCancel(airplaneNo, airResNo) {
	if (confirm("예약을 취소하겠습니까?")) {
		$.ajax({
			url : "airResCancel?airplaneNo=" + airplaneNo + "&airResNo=" + airResNo,
			type : 'GET',
			success : function(msg) {
				$("#air_res_list").html(msg);
			},
			error : function() {
				alert("error");
			}
		})
	}
	return false;
}
	
//렌트카 반납
function carResReturn(rent_no){
	if(confirm("차량을 반납하시겠습니까?")){
		$.ajax({
			url : "carResReturn?rent_no="+rent_no,
			type : 'GET',
			success : function(msg){
				$("#car_res_list").html(msg);
			}
			,error : function(){
				alert("error");
			}
		})
	}
	return false;
}

//렌트카 취소
function carResCancel(rent_no) {
	if (confirm("예약을 취소하겠습니까?")) {
		$.ajax({
			url : "carResCancel?rent_no=" + rent_no,
			type : 'GET',
			success : function(msg) {
				$("#car_res_list").html(msg);
			},
			error : function() {
				alert("error");
			}
		})
	}
}

function stayResCancel(reservation_no) {
	if (confirm("예약을 취소하겠습니까?")) {
		$.ajax({
			url : "stayResCancel?reservation_no=" + reservation_no,
			type : 'GET',
			success : function(msg) {
				$("#stay_res_list").html(msg);
			},
			error : function() {
				alert("error");
			}
		})
	}
	return false;
}

//렌트카 반납
function carResReturn(rent_no) {
	if (confirm("차량을 반납하시겠습니까?")) {
		$.ajax({
			url : "carResReturn?rent_no=" + rent_no,
			type : 'GET',
			success : function(msg) {
				$("#car_res_list").html(msg);
			},
			error : function() {
				alert("error");
			}
		})
	}
}
</script>
</head>
<body>
	<h2>나의 예약 목록</h2>
	<br>
	<br>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#search").on("keyup",function() {
				var value = $(this).val().toLowerCase();
				$("#air_res_list tr").filter(function() {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				});
				$("#car_res_list tr").filter(function() {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				});
				$("#stay_res_list tr").filter(function() {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				});
			});

			if ($('#rentTable tbody tr').length == 1) {
				$("#pagingArea").html("");
			};
		});
	</script>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-6">
				<input class="form-control" id="search" type="text"
					placeholder="Search..">
			</div>
		</div>
		<div class="row">
			<h4>숙박예약목록</h4>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>호텔 이름</th>
						<th style="width: 200px;">객실 이름</th>
						<th>체크 인</th>
						<th>체크 아웃</th>
						<th>숙박 인원</th>
						<th>결제 수단</th>
						<th>총 가격</th>
						<th>예약 날짜</th>
						<th>예약 취소</th>
					</tr>
				</thead>
				<tbody id="stay_res_list">
					<c:forEach var="list" items="${dtos_stay}">
						<tr>
							<td>${list.seq}</td>
							<td>${list.stay_name}</td>
							<td>${list.room_name}</td>
							<fmt:parseDate var="check_in" value="${list.check_in}"
								pattern="yyyy-MM-dd" scope="page" />
							<fmt:formatDate var="Check_in" value="${check_in}"
								pattern="yyyy-MM-dd" />
							<td>${Check_in}</td>
							<fmt:parseDate var="check_out" value="${list.check_out}"
								pattern="yyyy-MM-dd" scope="page" />
							<fmt:formatDate var="Check_out" value="${check_out}"
								pattern="yyyy-MM-dd" />
							<td>${Check_out}</td>
							<td>${list.stay_people}</td>
							<td>${list.pay_method}</td>
							<td>${list.room_sale_price}</td>
							<td>${list.reservation_date}</td>
							<c:set var="time" value="${checkMap[list.reservation_no]}" />
							<c:if test="${time == 0}">
								<td><button class="btn btn-primary"
										onclick="stayResCancel('${list.reservation_no}')">예약취소</button></td>
							</c:if>
							<c:if test="${time == 1}">
								<td><button class="btn btn-primary" disabled="disabled">숙박중</button></td>
							</c:if>
							<c:if test="${time == 2}">
								<td>숙박 완료</td>
							</c:if>

						</tr>
					</c:forEach>
					<tr>
						<td colspan="10" style="text-align: center;"><c:if
								test="${blockStartNumber_stay!=1}">
								<input type="button" value="[◀◀]"
									onclick="getStayResList('${startPage_stay}')">
								<input type="button" value="[◀]"
									onclick="getStayResList('${blockStartNumber_stay-1}')">
							</c:if> <c:forEach var="n" begin="${blockStartNumber_stay}"
								end="${blockEndNumber_stay}">
								<c:if test="${n!=pageNum_stay}">
									<a href="#" onclick="getStayResList('${n}')">${n}</a>
								</c:if>
								<c:if test="${n==pageNum_stay}">
									<b>${n}</b>
								</c:if>
							</c:forEach> <c:if test="${blockEndNumber_stay!=endPage_stay}">
								<input type="button" value="[▶]"
									onclick="getStayResList('${blockEndNumber_stay+1}')">
								<input type="button" value="[▶▶]"
									onclick="getStayResList('${endPage_stay}')">
							</c:if></td>
					</tr>
				</tbody>
			</table>
		</div>
		<hr>

		<div class="row">
			<h4>항공예약목록</h4>

			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>출발지</th>
						<th>도착지</th>
						<th>출발일시</th>
						<th>도착일시</th>
						<th>인원<br> <small>(성인|학생|유아)</small></th>
						<th>좌석등급<br> <small>(성인|학생|유아)</small></th>
						<th>결제금액</th>
						<th>결제수단</th>
						<th>결제일시</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="air_res_list">

					<c:if test="${fn:length(voList_air)>0}">
						<c:forEach var="airRes" items="${voList_air }">
							<tr>
								<td>${airRes.seq }</td>
								<td>${airRes.startLocation }</td>
								<td>${airRes.endLocation }</td>
								<fmt:formatDate var="st" value="${airRes.startTime}"
									pattern="yyyy-MM-dd HH:mm" />
								<td>${st}</td>
								<fmt:formatDate var="et" value="${airRes.endTime}"
									pattern="yyyy-MM-dd HH:mm" />
								<td>${et}</td>
								<td>${airRes.memSize}<small> (${airRes.adult }|${airRes.student }|${airRes.baby })
								</small>
								</td>
								<td><small>( <c:if
											test="${airRes.seatLevel_adult=='nomal'}">일반|</c:if> <c:if
											test="${airRes.seatLevel_adult=='highClass'}">고급|</c:if> <c:if
											test="${airRes.seatLevel_adult=='premium'}">프리미엄|</c:if> <c:if
											test="${airRes.seatLevel_adult=='noSelect'}">x|</c:if> <c:if
											test="${airRes.seatLevel_student=='nomal'}">일반|</c:if> <c:if
											test="${airRes.seatLevel_student=='highClass'}">고급|</c:if> <c:if
											test="${airRes.seatLevel_student=='premium'}">프리미엄|</c:if> <c:if
											test="${airRes.seatLevel_student=='noSelect'}">x|</c:if> <c:if
											test="${airRes.seatLevel_baby =='nomal'}">일반|</c:if> <c:if
											test="${airRes.seatLevel_baby=='highClass'}">고급|</c:if> <c:if
											test="${airRes.seatLevel_baby=='premium'}">프리미엄|</c:if> <c:if
											test="${airRes.seatLevel_baby=='noSelect'}">x|</c:if> )
								</small></td>
								<td>${airRes.price }</td>
								<td>${airRes.payMethod}</td>
								<fmt:formatDate var="resTime" value="${airRes.resTime}"
									pattern="yyyy-MM-dd HH:mm" />
								<td>${resTime}</td>
								<td>
									<jsp:useBean id="sysdate" class="java.util.Date" /> 
									<fmt:formatDate var="x" value="${airRes.startTime}" pattern="yyyy-MM-dd HH:mm" />
									<fmt:formatDate var="y" value="${sysdate}" pattern="yyyy-MM-dd HH:mm" /> 
									
									<c:if test="${x>y}">
										<button class="btn btn-primary" onclick="airResCancel('${airRes.airPlaneNo}','${airRes.airResNo}')">예약취소</button>
									</c:if> 
									<c:if test="${x<y}">
										<button class="btn btn-primary" disabled="disabled">결제완료</button>
									</c:if>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="11" style="text-align: center;"><c:if
									test="${blockStartNumber_air!=1}">
									<input type="button" value="[◀◀]"
										onclick="getAirResList('${startPage_air}')">
									<input type="button" value="[◀]"
										onclick="getAirResList('${blockStartNumber_air-1}')">
								</c:if> <c:forEach var="n" begin="${blockStartNumber_air}"
									end="${blockEndNumber_air}">
									<c:if test="${n!=pageNum_air}">
										<a href="#" onclick="getAirResList('${n}')">${n}</a>
									</c:if>
									<c:if test="${n==pageNum_air}">
										<b>${n}</b>
									</c:if>
								</c:forEach> <c:if test="${blockEndNumber_air!=endPage_air}">
									<input type="button" value="[▶]"
										onclick="getAirResList('${blockEndNumber_air+1}')">
									<input type="button" value="[▶▶]"
										onclick="getAirResList('${endPage_air}')">
								</c:if></td>
						</tr>
					</c:if>
					<c:if test="${fn:length(voList_air)==0}">
						<tr>
							<td colspan="11" style="text-align: center;">예약목록이 없습니다.</td>
						</tr>
					</c:if>
				</tbody>

			</table>



		</div>
		<hr>

		<div class="row">
			<h4>렌트예약목록</h4>
			<table id="rentTable" class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>대여일</th>
						<th>반납일</th>
						<th>차량</th>
						<th>결제금액</th>
						<th>결제수단</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody id="car_res_list">
					<c:forEach var="list" items="${dtos_car}">
						<c:if test="${list.car_count <= 0}">
							<tr>
								<td>${list.seq}</td>
								<td>${list.rental_day}${list.rental_time}</td>
								<td>${list.return_day}${list.return_time}</td>
								<td>${list.car_name}</td>
								<td><fmt:formatNumber value="${list.price}"
										groupingUsed="true" /></td>
								<td>${list.paymethod}</td>
								<c:set var="resCheck" value="${resMap[list.rent_no]}" />
								<c:if test="${resCheck == 0}">
									<td><button class="btn btn-primary"
											onclick="carResCancel('${list.rent_no}')">예약취소</button></td>
								</c:if>
								<c:if test="${resCheck == 1}">
									<td>
										<button type="button" class="btn btn-primary"
											disabled="disabled">이용중</button>
										<button class="btn btn-primary"
											onclick="carResReturn('${list.rent_no}')">반납하기</button>
									</td>
								</c:if>
							</tr>
						</c:if>
					</c:forEach>
					<tr>
						<td id="pagingArea" colspan="7" style="text-align: center;">

							<input type="hidden" value="${blockStartNumber_car}"> <c:if
								test="${blockStartNumber_car!=1}">
								<input type="button" value="[◀◀]"
									onclick="getCarResList('${startPage_car}')">
								<input type="button" value="[◀]"
									onclick="getCarResList('${blockStartNumber_car-1}')">
							</c:if> <c:forEach var="n" begin="${blockStartNumber_car}"
								end="${blockEndNumber_car}">
								<c:if test="${n!=pageNum_car}">
									<a href="#" onclick="getCarResList('${n}')">${n}</a>
								</c:if>
								<c:if test="${n==pageNum_car}">
									<b>${n}</b>
								</c:if>
							</c:forEach> <c:if test="${blockEndNumber_car!=endPage_car}">
								<input type="button" value="[▶]"
									onclick="getCarResList('${blockEndNumber_car+1}')">
								<input type="button" value="[▶▶]"
									onclick="getCarResList('${endPage_car}')">
							</c:if>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<hr>
	</div>
</body>
</html>