<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<form name="stay_add" method="post" action="stay_add_Pro"
		enctype="multipart/form-data">

		<div>
			<table style="width: 1200px;">
				<tr>
					<th colspan="2">숙박지 사진1</th>
					<td><input type="file" name="stay_Images1" accept="image/*">
					<th colspan="2">숙박지 인터넷</th>
					<td style="text-align: left"><input class="input"
						type="text" name="stay_internet" maxlength="300">
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 사진2</th>
					<td><input type="file" name="stay_Images2" accept="image/*">
					<th colspan="2">숙박지 주차</th>
					<td style="text-align: left"><input class="input"
						type="text" name="stay_parking" maxlength="300">
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 사진3</th>
					<td><input type="file" name="stay_Images3" accept="image/*">
					<th colspan="2">숙박지 체크인</th>
					<td style="text-align: left"><input class="input"
						type="text" name="stay_check_in" maxlength="300">
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 사진4</th>
					<td><input type="file" name="stay_Images4" accept="image/*">
					<th colspan="2">숙박지 체크아웃</th>
					<td style="text-align: left"><input class="input"
						type="text" name="stay_check_out" maxlength="300">
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 사진5</th>
					<td><input type="file" name="stay_Images5" accept="image/*">
					<th colspan="2">숙박지 종류</th>
					<td style="text-align: left"><select class="input"
						name="stay_kind">
							<option value="호텔">호텔</option>
							<option value="펜션">펜션</option>
							<option value="리조트">리조트</option>
							<option value="게스트하우스">게스트하우스</option>
					</select></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 사진6</th>
					<td><input type="file" name="stay_Images6" accept="image/*"></td>
					<th colspan="2">숙박지 등급</th>
					<td style="text-align: left"><select class="input"
						name="stay_class">
							<option value="3성">3성</option>
							<option value="4성">4성</option>
							<option value="5성">5성</option>
					</select></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 이름</th>
					<td style="text-align: left"><input class="input" type="text"
						name="stay_Name" maxlength="100"></td>
					<th colspan="2">숙박지 X좌표</th>
					<td style="text-align: left"><input class="input"
						type="text" name="stay_X" maxlength="20">
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 주소</th>
					<td style="text-align: left"><input class="input" type="text"
						name="stay_Address" maxlength="300"></td>
					<th colspan="2">숙박지 Y좌표</th>
					<td style="text-align: left"><input class="input"
						type="text" name="stay_Y" maxlength="20">
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 번호</th>
					<td colspan="4" style="text-align: left"><input class="input"
						type="text" name="stay_tell" maxlength="300"></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 일반사항</th>
					<td style="text-align: left"><textarea class="input" rows="5"
							cols="40" name="stay_general_details" style="width: 270px"></textarea></td>
					<th colspan="2">숙박지 편의시설</th>
					<td style="text-align: left"><textarea
							class="input" rows="5" cols="40" name="stay_amenities"
							style="width: 270px"></textarea></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="2">숙박지 정보</th>
					<td style="text-align: left"><textarea
							class="input" rows="5" cols="40" name="stay_Info"
							style="width: 270px"></textarea></td>
					<th colspan="2">숙박지 서비스</th>
					<td style="text-align: left"><textarea
							class="input" rows="5" cols="40" name="stay_service"
							style="width: 270px"></textarea></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>
				<tr>
					<th colspan="6"><button type="submit" class="w3-button w3-black">추가</button> <button
						type="reset" class="w3-button w3-black">취소</button></th>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>