<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<div class="container">
	<div class="row">
		<h4>숙박예약목록</h4>
		<table class="table">
			<thead>
				<tr>
					<td>예약 번호</td>
					<td>호텔 이름</td>
					<td>객실 이름</td>
					<td>체크 인</td>
					<td>체크 아웃</td>
					<td>숙박 인원</td>
					<td>결제 수단</td>
					<td>총 가격</td>
					<td>예약 날짜</td>
					<td>예약자</td>
					<td>현재 상태</td>
				</tr>
			</thead>
			<tbody id="stay_res_list">
				<c:forEach var="list" items="${dtos_stay}">
					<tr>
						<td>${list.reservation_no}</td>
						<td>${list.stay_name}</td>
						<td>${list.room_name}</td>
						<fmt:parseDate var="check_in" value="${list.check_in}" pattern="yyyy-MM-dd" scope="page"/>
						<fmt:formatDate var="Check_in" value="${check_in}" pattern="yyyy-MM-dd"/>
						<td>${Check_in}</td>
						<fmt:parseDate var="check_out" value="${list.check_out}" pattern="yyyy-MM-dd" scope="page"/>
						<fmt:formatDate var="Check_out" value="${check_out}" pattern="yyyy-MM-dd"/>
						<td>${Check_out}</td>
						<td>${list.stay_people}</td>
						<td>${list.pay_method}</td>
						<td>${list.room_sale_price}</td>
						<td>${list.reservation_date}</td>
						<td>${list.mem_id}</td>
						<c:set var="time" value="${checkMap[list.reservation_no]}"/>
						<c:if test="${time == 0}">
							<td>예약중</td>
						</c:if>
						<c:if test="${time == 1}">
							<td>숙박중</td>
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
</div>