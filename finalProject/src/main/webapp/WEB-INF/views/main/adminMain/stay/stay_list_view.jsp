<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form name="stay_list_view" method="post" action="stay_modify"
		enctype="multipart/form-data">
		<input type="hidden" name="stay_no" value="${vo.stay_no}">
		<div>
			<table style="width: 1200px;" border="1">
				<tr>
					<th>숙박지 사진1</th>
					<td align="center"><img
						src="${images}stay/stay_location/${vo.stay_img1}"
						height="50%"></td>
					<td><input type="file" name="stay_Images1" accept="image/*"></td>
				</tr>
				<tr>
					<th>숙박지 사진2</th>
					<td align="center"><img
						src="${images}stay/stay_location/${vo.stay_img2}"
						height="50%"></td>
					<td><input type="file" name="stay_Images2" accept="image/*"></td>
				</tr>
				<tr>
					<th>숙박지 사진3</th>
					<td align="center"><img
						src="${images}stay/stay_location/${vo.stay_img3}"
						height="50%"></td>
					<td><input type="file" name="stay_Images3" accept="image/*"></td>
				</tr>
				<tr>
					<th>숙박지 사진4</th>
					<td align="center"><img
						src="${images}stay/stay_location/${vo.stay_img4}"
						height="50%"></td>
					<td><input type="file" name="stay_Images4" accept="image/*"></td>
				</tr>
				<tr>
					<th>숙박지 사진5</th>
					<td align="center"><img
						src="${images}stay/stay_location/${vo.stay_img5}"
						height="50%"></td>
					<td><input type="file" name="stay_Images5" accept="image/*"></td>
				</tr>
				<tr>
					<th>숙박지 사진6</th>
					<td align="center"><img
						src="${images}stay/stay_location/${vo.stay_img6}"
						height="50%"></td>
					<td><input type="file" name="stay_Images6" accept="image/*"></td>
				</tr>
				<tr>
					<th colspan="2">숙박지 이름</th>
					<td colspan="5" style="text-align: left">
					<input class="input"
						type="text" name="stay_Name" value="${vo.stay_name}" maxlength="100"></td>
				</tr>
				<tr>
					<th colspan="2">숙박지 주소</th>
					<td colspan="5" style="text-align: left"><input class="input"
						type="text" name="stay_Address" value="${vo.stay_address}">
				</tr>
				<tr>
					<th colspan="2">숙박지 번호</th>
					<td colspan="5" style="text-align: left"><input class="input"
						type="text" name="stay_tell" maxlength="300" value="${vo.stay_cellphone}">
				</tr>
				<tr>
					<th colspan="2">숙박지 정보</th>
					<td colspan="5" style="text-align: left"><textarea
							class="input" rows="5" cols="40" name="stay_Info"
							style="width: 270px">${vo.stay_introduce}</textarea></td>
				</tr>
				<tr>
					<th colspan="2">숙박지 일반사항</th>
					<td colspan="5" style="text-align: left"><textarea
							class="input" rows="5" cols="40" name="stay_general_details"
							style="width: 270px">${vo.stay_general_details}</textarea></td>
				</tr>
				<tr>
					<th colspan="2">숙박지 편의시설</th>
					<td colspan="5" style="text-align: left"><textarea
							class="input" rows="5" cols="40" name="stay_amenities"
							style="width: 270px">${vo.stay_amenities}</textarea></td>
				</tr>
				<tr>
					<th colspan="2">숙박지 서비스</th>
					<td colspan="5" style="text-align: left"><textarea
							class="input" rows="5" cols="40" name="stay_service"
							style="width: 270px">${vo.stay_service}</textarea></td>
				</tr>
				<tr>
					<th colspan="2">숙박지 인터넷</th>
					<td colspan="5" style="text-align: left"><input class="input"
						type="text" name="stay_internet" maxlength="300" value="${vo.stay_internet}">
				</tr>
				<tr>
					<th colspan="2">숙박지 주차</th>
					<td colspan="5" style="text-align: left"><input class="input"
						type="text" name="stay_parking" maxlength="300" value="${vo.stay_parking}">
				</tr>
				<tr>
					<th colspan="2">숙박지 체크인</th>
					<td colspan="5" style="text-align: left"><input class="input"
						type="text" name="stay_check_in" maxlength="300" value="${vo.stay_check_in}">
				</tr>
				<tr>
					<th colspan="2">숙박지 체크아웃</th>
					<td colspan="5" style="text-align: left"><input class="input"
						type="text" name="stay_check_out" maxlength="300" value="${vo.stay_check_out}">
				</tr>
				<tr>
					<th colspan="2">숙박지 종류</th>
					<td colspan="5" style="text-align: left">${vo.stay_kind}<select class="input"
						name="stay_kind">
							<option value="호텔">호텔</option>
							<option value="펜션">펜션</option>
							<option value="리조트">리조트</option>
							<option value="게스트하우스">게스트하우스</option>
					</select></td>
				</tr>
				<tr>
					<th colspan="2">숙박지 등급</th>
					<td colspan="5" style="text-align: left">${vo.stay_class}<select class="input"
						name="stay_class">
							<option value="3성">3성</option>
							<option value="4성">4성</option>
							<option value="5성">5성</option>
					</select></td>
				</tr>
				<tr>
					<th colspan="2">숙박지 X좌표</th>
					<td colspan="5" style="text-align: left"><input class="input"
						type="text" name="stay_X" maxlength="20" value="${vo.stay_x}">
				</tr>
				<tr>
					<th colspan="2">숙박지 Y좌표</th>
					<td colspan="5" style="text-align: left"><input class="input"
						type="text" name="stay_Y" maxlength="20" value="${vo.stay_y}">
				</tr>
				<tr>
					<th colspan="3"><input type="submit" value="수정">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="button" onclick="window.location='stay_room_add?stay_no=${vo.stay_no}'" value="객실 추가">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="button" onclick="window.location='stay_room_list?stay_no=${vo.stay_no}'" value="객실 목록">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
					<input type="button" onclick="window.location='stay_delete?stay_no=${vo.stay_no}'" value="삭제"></th>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>