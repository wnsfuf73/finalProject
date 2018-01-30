<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!--Google Fonts link-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}slick.css">
<link rel="stylesheet" href="${css}slick-theme.css">
<link rel="stylesheet" href="${css}animate.css">
<link rel="stylesheet" href="${css}fonticons.css">
<link rel="stylesheet" href="${css}font-awesome.min.css">
<link rel="stylesheet" href="${css}bootstrap.css">
<link rel="stylesheet" href="${css}magnific-popup.css">
<link rel="stylesheet" href="${css}bootsnav.css">
<link rel="stylesheet" href="${css}carousel.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--Theme custom css -->
<link rel="stylesheet" href="${css}style.css">
<!--Theme Responsive css-->
<link rel="stylesheet" href="${css}responsive.css" />

<!-- JS includes -->
<script src="${js}vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="${js}vendor/jquery-1.11.2.min.js"></script>
<script src="${js}vendor/bootstrap.min.js"></script>
<script src="${js}isotope.min.js"></script>
<script src="${js}jquery.magnific-popup.js"></script>
<script src="${js}jquery.easing.1.3.js"></script>
<script src="${js}slick.min.js"></script>
<script src="${js}jquery.collapse.js"></script>
<script src="${js}bootsnav.js"></script>
<script src="${js}plugins.js"></script>
<script src="${js}main.js"></script>

<script type="text/javascript">
	//숫자만 입력 받기
	function onlyNumber(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ((keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105)
				|| keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39) {
			return;
		} else {
			alert("숫자만 입력해주세요.");
			return false;
		}
	}
	
	// 숫자가 아닐 시 입력 삭제
	function removeChar(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if (keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39) {
			return;
		} else {
			event.target.value = event.target.value.replace(/[^0-9]/g, "");
		}
	}
</script>
</head>
<body>
	<div class="container">
		<div class="col-md-6">
		<h2>차량 등록</h2>
			<form action="rentAdd" method="post" name="rentAdd" onsubmit="return addcheck();" enctype="multipart/form-data">
				<table class="table">
					<tr>
						<th>렌트카고유번호</th>
						<td><input type="text" name="rent_no" maxlength="10" required="required"></td>
					</tr>
					<tr>
						<th>사용km</th>
						<td><input type="text" name="use_km" maxlength="10" required="required" onkeydown='return onlyNumber(event)'
						onkeyup='removeChar(event)' style='ime-mode: disabled;'></td>
					</tr>
					<tr>
						<th>자동차수량</th>
						<td><input type="text" name="car_count" maxlength="10" required="required" onkeydown='return onlyNumber(event)' 
						onkeyup='removeChar(event)' style='ime-mode: disabled;'></td>
					</tr>
					<tr>
						<th>보험가능여부</th>
						<td><input type="radio" name="insurance" value="가능" required="required">적용가능
						<input type="radio" name="insurance" value="불가능" required="required">불가능</td>
					</tr>
					<tr>
						<th>자동차번호</th>
						<td><input type="text" name="car_num" maxlength="10" required="required"></td>
					</tr>
					<tr>
						<th>이미지</th>
						<td><input type="file" name="car_img" accept="images/car/*" required="required"></td>
					</tr>
					<tr>
						<th colspan="2" style="text-align:center;">
							<button type="submit" class="w3-button w3-black" name="add">추가</button>
							<button type="reset" class="w3-button w3-black" name="reset">취소</button>
						</th>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>