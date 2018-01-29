<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${css}bootstrap.css">
</head>
<body>
	<table style="width: 1150px" class="table table-bordered">
		<tr align="center">
			<td style="width: 15%">객실 사진</td>
			<td style="width: 10%">객실 이름</td>
			<td style="width: 15%">객실 정보</td>
			<td style="width: 10%">숙박 인원</td>
			<td style="width: 10%">객실 가격</td>
			<td style="width: 15%" colspan="2">총 가격</td>
		</tr>
		<c:forEach var="r_vo" items="${vos}">
			<tr>
				<td align="center" style="vertical-align: middle"><img
					src="${images}stay/stay_location_room/${r_vo.room_img}"
					height="60%"></td>
				<td align="center" style="vertical-align: middle">${r_vo.room_name}</td>

				<td align="center" style="vertical-align: middle">${r_vo.room_info}</td>

				<td align="center" style="vertical-align: middle">${r_vo.standard}</td>
				
				<td align="center" style="vertical-align: middle">${r_vo.sale_price}원</td>
				
				<c:set var="total_price" value="${r_vo.sale_price*diffDats}"/>
				<td align="center" style="vertical-align: middle">${total_price}원</td>

				<td align="center" style="vertical-align: middle">
					<c:if test="${sessionScope.mem_id == null}">
						로그인이<br>필요합니다.
					</c:if>
					<c:if test="${sessionScope.mem_id != null}">
						<c:set var="stayNum" value="${checkMap[r_vo.room_no]}"/>										
						<c:if test="${stayNum == 0}">
							<input type="button" class="btn btn-default btn-lg" disabled="disabled" value="객실 없음">
						</c:if>
						<c:if test="${stayNum == 1}">
							<input type="button" class="btn btn-default btn-lg"
							onclick="javascript:parent.change_parent_url('stay_room_view?room_no=${r_vo.room_no}&total_price=${total_price}&check_in=${check_in}&check_out=${check_out}')" value="예약 하기">
						</c:if>
						<c:if test="${stayNum == 2}">
							<input type="button" class="btn btn-default btn-lg" disabled="disabled" value="객실 없음">
						</c:if>
						<c:if test="${stayNum == 3}">
							<input type="button" class="btn btn-default btn-lg"
							onclick="javascript:parent.change_parent_url('stay_room_view?room_no=${r_vo.room_no}&total_price=${total_price}&check_in=${check_in}&check_out=${check_out}')" value="예약 하기">
						</c:if>
						<c:if test="${stayNum == 4}">
							<input type="button" class="btn btn-default btn-lg" disabled="disabled" value="객실 없음">
						</c:if>
						<c:if test="${stayNum == null}">
							<input type="button" class="btn btn-default btn-lg"
							onclick="javascript:parent.change_parent_url('stay_room_view?room_no=${r_vo.room_no}&total_price=${total_price}&check_in=${check_in}&check_out=${check_out}')" value="예약 하기">
						</c:if>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>