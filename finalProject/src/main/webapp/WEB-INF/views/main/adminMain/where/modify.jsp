<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<form name="modify" method="post" action="modify_Pro"
		enctype="multipart/form-data">
		<input type="hidden" name="location_num" value="${vo.location_num}">
		<div>
			<table style="width: 1300px;">
				<tr>
					<th>장소 사진1</th>
					<td align="center"><img
						src="${images}where/trip_location/${vo.location_img1}"
						height="200px" width="300px;"></td>
					<td><input type="file" name="where_Images1" accept="image/*"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 사진2</th>
					<td align="center"><img
						src="${images}where/trip_location/${vo.location_img2}"
						height="200px" width="300px;"></td>
					<td><input type="file" name="where_Images2" accept="image/*"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 사진3</th>
					<td align="center"><img
						src="${images}where/trip_location/${vo.location_img3}"
						height="200px" width="300px;"></td>
					<td><input type="file" name="where_Images3" accept="image/*"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 사진4</th>
					<td align="center"><img
						src="${images}where/trip_location/${vo.location_img4}"
						height="200px" width="300px;"></td>
					<td><input type="file" name="where_Images4" accept="image/*"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 이름</th>
					<td colspan="2" style="text-align: left">
					<input class="input"
						type="text" name="where_Name" value="${vo.location_name}" maxlength="100" size="120"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 위치</th>
					<td colspan="2" style="text-align: left"><input class="input"
						type="text" name="where_Address" value="${vo.location_addr}"
						maxlength="300" size="120"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 정보</th>
					<td colspan="2" style="text-align: left"><textarea
							class="input" rows="5" cols="40" name="where_Info"
							style="width: 1105px">${vo.detail_info}</textarea></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 사이트</th>
					<td colspan="2" style="text-align: left"><input class="input"
						type="text" name="where_Web" value="${vo.location_web}"
						maxlength="150" size="120"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 X좌표</th>
					<td colspan="2" style="text-align: left"><input class="input"
						type="text" name="where_X" value="${vo.x_coordinate}"
						maxlength="20" size="120"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 Y좌표</th>
					<td colspan="2" style="text-align: left"><input class="input"
						type="text" name="where_Y" value="${vo.y_coordinate}"
						maxlength="20" size="120"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 개장 시간</th>
					<td colspan="2" style="text-align: left"><input class="input"
						type="text" name="where_Open" value="${vo.open_time}"
						maxlength="10" size="120"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 폐쇄 시간</th>
					<td colspan="2" style="text-align: left"><input class="input"
						type="text" name="where_Close" value="${vo.close_time}"
						maxlength="10" size="120"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 지역</th>
					<td colspan="2" style="text-align: left">${vo.area}&emsp;<select
						class="input" name="where_Area">
							<option value="서울">서울</option>
							<option value="울산">울산</option>
							<option value="전남">전남</option>
							<option value="부산">부산</option>
							<option value="경기">경기</option>
							<option value="경북">경북</option>
							<option value="대구">대구</option>
							<option value="강원">강원</option>
							<option value="경남">경남</option>
							<option value="인천">이천</option>
							<option value="충북">충북</option>
							<option value="제주">제주</option>
							<option value="광주">광주</option>
							<option value="충남">충남</option>
							<option value="울릉도/독도">울릉도/독도</option>
							<option value="대전">대전</option>
							<option value="전북">전북</option>
					</select></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th>장소 테마</th>
					<td colspan="2" style="text-align: left">${vo.thema_category}&emsp;<select
						class="input" name="where_Thema">
							<option value="관광">관광</option>
							<option value="맛집">맛집</option>
							<option value="레져">레져</option>
							<option value="힐링">힐링</option>
					</select></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="3">
						<button type="submit" class="w3-button w3-black">수정</button>
						<button type="reset" class="w3-button w3-black">취소</button>
					</th>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>