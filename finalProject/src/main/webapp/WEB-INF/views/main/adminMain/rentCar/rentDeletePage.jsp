<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${css}bootstrap.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>	
	<div class="container">
		<div class="col-md-4">
			<form action="rentDelete" method="post" name="rentDeleteForm"> 
			<h2>차량삭제</h2>
				<table class="table">
					<tr>
						<th>차량번호</th>
						<td><input type="text" name="car_num" required="required"></td>					
					</tr>
					<tr>
						<th colspan="2" style="text-align:center;">
							<button type="submit" class="w3-button w3-black" id="rentDel_button">확인</button>
							<button type="reset" class="w3-button w3-black" name="reset">취소</button>
						</th>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>