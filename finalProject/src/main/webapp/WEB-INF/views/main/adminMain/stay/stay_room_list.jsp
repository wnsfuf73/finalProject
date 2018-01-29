<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div>
		<table style="width: 1400px" align="center">
			<tr>
				<th style="width: 10%">객실 번호</th>
				<th style="width: 30%">객실 사진</th>
				<th style="width: 20%">객실 이름</th>
				<th style="width: 10%">기준 인원</th>
				<th style="width: 20%">객실 가격</th>
			</tr>

			<c:forEach var="vo" items="${vos}">
				<tr>
					<td align="center">${vo.room_no}</td>
					<td align="center"><img src="${images}stay/stay_location_room/${vo.room_img}"
						height="50%"></td>
					<td align="center"><a
						href="stay_room_list_view?room_no=${vo.room_no}">
							${vo.room_name} </a></td>
						<td align="center">${vo.standard}</td>
						<td align="center">${vo.sale_price}</td>
					</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>