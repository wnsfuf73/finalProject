<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<form name="add" method="post" action="add_Pro"
		enctype="multipart/form-data">

		<div>
			<table style="width: 1200px;">
				<tr>
					<th colspan="2">장소 사진1</th>
					<td>
						<input type="file" name="where_Images1" accept="image/*">
					</td>
					<th colspan="2">장소 사이트</th>
					<td style="text-align: left"><input class="input"
						type="text" name="where_Web" maxlength="150" placeholder="없으면 안적으셔도 됩니다.">
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">장소 사진2</th>
					<td>
						<input type="file" name="where_Images2" accept="image/*">
					</td>
					<th colspan="2">장소 X좌표</th>
					<td style="text-align: left"><input class="input"
						type="text" name="where_X" maxlength="20">
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">장소 사진3</th>
					<td>
						<input type="file" name="where_Images3" accept="image/*">
					</td>
					<th colspan="2">장소 Y좌표</th>
					<td style="text-align: left"><input class="input"
						type="text" name="where_Y" maxlength="20">
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">장소 사진4</th>
					<td>
						<input type="file" name="where_Images4" accept="image/*">
					</td>
					<th colspan="2">장소 개장 시간</th>
					<td style="text-align: left"><input class="input"
						type="text" name="where_Open" maxlength="10">
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">장소 이름</th>
					<td style="text-align: left">
						<input class="input" type="text" name="where_Name" maxlength="100">
					</td>
					<th colspan="2">장소 폐쇄 시간</th>
					<td style="text-align: left">
						<input class="input" type="text" name="where_Close" maxlength="10">
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">장소 위치</th>
					<td style="text-align: left">
					<input class="input" type="text" name="where_Address" maxlength="300">
					</td>
					<th colspan="2">장소 지역</th>
					<td style="text-align: left">
						<select class="input" name="where_Area">
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
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">장소 정보</th>
					<td style="text-align: left">
						<textarea class="input" rows="5" cols="40" name="where_Info"
							style="width: 270px">
						</textarea>
					</td>
					<th colspan="2">장소 테마</th>
					<td style="text-align: left">
						<select class="input" name="where_Thema">
								<option value="관광">관광</option>
								<option value="맛집">맛집</option>
								<option value="레져">레져</option>
								<option value="힐링">힐링</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
				<tr>
					<th colspan="7">
						<button type="submit" class="w3-button w3-black">추가</button>
						<button type="reset" class="w3-button w3-black">취소</button>
					</th>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>