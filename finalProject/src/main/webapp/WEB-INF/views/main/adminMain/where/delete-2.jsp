<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
th {
	width: 1000px;
}
</style>
</head>
<body>
	<form name="delete-2" method="post" action="delete_Pro">
		<input type="hidden" name="location_num" value="${vo.location_num}">
		<div>
			<table style="width: 1350px;">
				<tr>
					<th colspan="2">장소 사진</th>
					<td style="text-align: left"><img
						src="${images}where/trip_location/${vo.location_img1}"></td>
				</tr>
				<tr>
					<th colspan="2">장소 번호</th>
					<td style="text-align: left">${vo.location_num}</td>
				</tr>
				<tr>
					<th colspan="2">장소 이름</th>
					<td style="text-align: left">${vo.location_name}</td>
				</tr>
				<tr>
					<th colspan="2">장소 위치</th>
					<td colspan="5" style="text-align: left">${vo.location_addr}
				</tr>
				<tr>
					<th colspan="2">장소 정보</th>
					<td colspan="5" style="text-align: left">${vo.detail_info}
				</tr>
				<tr>
					<th colspan="2">장소 사이트</th>
					<td colspan="5" style="text-align: left">${vo.location_web}
				</tr>
				<tr>
					<th colspan="2">장소 좌표</th>
					<td colspan="5" style="text-align: left">${vo.x_coordinate},
						${vo.y_coordinate}
				</tr>
				<tr>
					<th colspan="2">장소 개장 시간</th>
					<td style="text-align: left">${vo.open_time}</td>
				</tr>
				<tr>
					<th colspan="2">장소 폐쇄 시간</th>
					<td style="text-align: left">${vo.close_time}</td>
				</tr>

				<tr>
					<th colspan="2">장소 지역</th>
					<td style="text-align: left">${vo.area}</td>
				</tr>

				<tr>
					<th colspan="2">장소 테마</th>
					<td style="text-align: left">${vo.thema_category}</td>
				</tr>
				<tr>
					<th colspan="2">좋아요 수</th>
					<td style="text-align: left">${vo.like_score}</td>
				</tr>
				<tr>
					<th colspan="7"><input type="submit" value="삭제"> <input
						type="reset" value="취소"></th>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>