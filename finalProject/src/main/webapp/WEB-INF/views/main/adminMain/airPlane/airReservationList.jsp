<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>항공 예약 리스트</title>
</head>
<body>
	<h4>항공 예약 리스트</h4>
	<div class="container">
		
		<div class="row">
			<h4>항공예약목록</h4>
			<input class="form-control" id="airSearch" type="text" placeholder="Search..">
			<table class="table" >
				<thead>
					<tr>
						<td>번호</td>
						<td>출발지</td>
						<td>도착지</td>
						<td>인원<small>(성인|학생|유아)</small></td>
						<td>좌석등급<small>(성인|학생|유아)</small></td>
						<td>결제금액</td>
						<td>결제수단</td>
						<td>결제일시</td>
					</tr>
				</thead>
				<tbody id="air_res_list">
					<c:forEach var="airRes" items="${voList }">
						<tr>
							<td>${airRes.seq }</td>
							<td>${airRes.startLocation }</td>
							<td>${airRes.endLocation }</td>
							<td>
								${airRes.memSize}
								<small>
									(${airRes.adult }|${airRes.student }|${airRes.baby })
								</small>
							</td>
							<td>
								<small>(
									<c:if test="${airRes.seatLevel_adult=='nomal'}">일반|</c:if>
									<c:if test="${airRes.seatLevel_adult=='highClass'}">고급|</c:if>
									<c:if test="${airRes.seatLevel_adult=='premium'}">프리미엄|</c:if>
									<c:if test="${airRes.seatLevel_adult=='noSelect'}">x|</c:if>
									
									<c:if test="${airRes.seatLevel_student=='nomal'}">일반|</c:if>
									<c:if test="${airRes.seatLevel_student=='highClass'}">고급|</c:if>
									<c:if test="${airRes.seatLevel_student=='premium'}">프리미엄|</c:if>
									<c:if test="${airRes.seatLevel_student=='noSelect'}">x|</c:if>
									
									<c:if test="${airRes.seatLevel_baby =='nomal'}">일반|</c:if>
									<c:if test="${airRes.seatLevel_baby=='highClass'}">고급|</c:if>
									<c:if test="${airRes.seatLevel_baby=='premium'}">프리미엄|</c:if>
									<c:if test="${airRes.seatLevel_baby=='noSelect'}">x|</c:if>
									)
								</small>
							</td>
							<td>${airRes.price }</td>
							<td>${airRes.payMethod}</td>
							<td>${airRes.resTime }</td>
						<tr>
					</c:forEach>
					<tr>
					
						<td colspan="8" style="text-align: center;">
							<c:if test="${blockStartNumber!=1}">
								<input type="button" value="[◀◀]" onclick="window.location=airReservationList?requestPage=${startPage}">
								<input type="button" value="[◀]" onclick="window.location=airReservationList?requestPage=${blockStartNumber-1}">
							</c:if>
							<c:forEach var="n" begin="${blockStartNumber}" end="${blockEndNumber}">
								<c:if test="${n!=pageNum}">
									<a href="airReservationList?requestPage=${n}">${n}</a>
								</c:if>
								<c:if test="${n==pageNum}">
									<b>${n}</b>
								</c:if>
							</c:forEach>
							<c:if test="${blockEndNumber!=endPage}">
								<input type="button" value="[▶]" onclick="window.location=airReservationList?requestPage=${blockEndNumber+1}">
								<input type="button" value="[▶▶]" onclick="window.location=airReservationList?requestPage=${endPage}">
							</c:if>
						</td>
					</tr>
				</tbody>

			</table>
			<script type="text/javascript">
			$(document).ready(function(){
			  $("#airSearch").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#air_res_list tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			});
			</script>
	
		</div>
	
	</div>
	
</body>
</html>
	
	
	
	
</body>
</html>