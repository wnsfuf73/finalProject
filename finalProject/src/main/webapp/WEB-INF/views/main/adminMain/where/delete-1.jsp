<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
	<form name="delete-1" method="post" action="delete-2">
		<div>

			<div>
				<table style="width:1000px;">
					<tr>
						<th colspan="2">장소 삭제</th>
					</tr>
					<tr>
						<th style="width:20%">장소 번호</th>
						<td align="left"><input type="text" name="location_num"></td>
					</tr>
					<tr>
						<th colspan="2">
							<input type="submit" value="확인">
							<input type="reset" value="취소">
						</th>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>