<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="stay_room_add" method="post" action="stay_room_add_Pro"
		enctype="multipart/form-data">
		<input type="hidden" name="stay_no" value="${stay_no}">

		<div>
			<table style="width: 450px;">
				<tr>
					<th colspan="2">객실 사진</th>
					<td><input type="file" name="room_img" accept="image/*">
				</tr>
				
				<tr>
					<th colspan="2">객실 이름</th>
					<td colspan="5" style="text-align: left"><input class="input"
						type="text" name="room_name" maxlength="100">
				</tr>
				<tr>
					<th colspan="2">숙박 가능 인원</th>
					<td colspan="5" style="text-align: left"><input type="number" name="standard" min="1" max="10" step="1" value="1">
				</tr>
				<tr>
					<th colspan="2">객실 가격</th>
					<td colspan="5" style="text-align: left"><input type="number" name="sale_price" min="10000" max="2600000" step="10000" value="10000"></td>
				</tr>
				<tr>
					<th colspan="2">객실 정보</th>
					<td colspan="5" style="text-align: left"><textarea
							class="input" rows="5" cols="40" name="room_info"
							style="width: 270px"></textarea></td>
				</tr>
				<tr>
					<th colspan="7"><input type="submit" value="추가"> <input
						type="reset" value="취소"></th>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>