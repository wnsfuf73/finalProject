<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form name="stay_room_list_view" method="post" action="stay_room_modify"
		enctype="multipart/form-data">
		<input type="hidden" name="room_no" value="${vo.room_no}">
		<div>
			<table style="width: 1200px;" border="1">
				<tr>
					<th>객실 사진</th>
					<td align="center"><img
						src="${images}stay/stay_location_room/${vo.room_img}"
						height="50%"></td>
					<td><input type="file" name="room_img" accept="image/*"></td>
				</tr>
				<tr>
					<th colspan="2">객실 이름</th>
					<td colspan="5" style="text-align: left">
					<input class="input"
						type="text" name="room_name" value="${vo.room_name}" maxlength="100">
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박 가능 인원</th>
					<td colspan="5" style="text-align: left">
						<input type="number" name="standard" min="1" max="10" step="1" value="${vo.standard}">
					</td>
				</tr>
				<tr>
					<th colspan="2">객실 가격</th>
					<td colspan="5" style="text-align: left">
						<input type="number" name="sale_price" min="10000" max="2600000" step="10000" value="${vo.sale_price}">
					</td>
				</tr>
				<tr>
					<th colspan="2">객실 정보</th>
					<td colspan="5" style="text-align: left">
						<textarea class="input" rows="5" cols="40" name="room_info" style="width: 270px">
							${vo.room_info}
						</textarea>
					</td>
				</tr>
				
				<tr>
					<th colspan="3"><input type="submit" value="수정">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="button" onclick="window.location='stay_room_delete?room_no=${vo.room_no}'" value="객실 삭제"></th>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>