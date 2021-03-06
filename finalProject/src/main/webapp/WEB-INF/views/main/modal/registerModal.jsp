<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link rel="icon" type="image/png" href="favicon.ico">

<!--Google Fonts link-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">

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
	
	// 아이디와 비밀번호가 맞지 않을 경우 가입 버튼 비활성화를 위한 변수 설정
	var idCheck = 0;
	var pwdCheck = 0;

	// 아이디 중복
	function checkId() {
		var idPtr = document.getElementById("InputId");
		var idValue = idPtr.value;
		var send_url = "idCheck?id=" + idValue;
		$.ajax({

			url : send_url,
			type : 'GET',

			success : function(resultCnt) {

				if (resultCnt == '0') {
					alert("이미 사용중인 아이디 입니다");
					idPtr.value = "";
				} else {
					document.getElementById("InputPassword1").focus();
					alert("사용 가능한 아이디 입니다");
				}
			},
			error : function() {
				alert("error");
			}

		})

	}

	// 입력 확인 및 비밀번호 일치 여부
	$(function() {

		$("#signupbtn").click(function() {

			var name = $("#username");

			if (name.val() == "") {
				alert("이름을 입력하세요");
				return false;
			}

			var id = $("#InputId");

			if (id.val() == "") {
				alert("아이디를 입력하세요");
				return false;
			}

			var password = $("#InputPassword1");

			if (password.val() == "") {
				alert("비밀번호를 입력하세요");
				return false;
			}

			var repassword = $("#InputPassword2");

			if (repassword.val() == "") {
				alert("비밀번호를 입력하세요");
				return false;
			}

			if ($("#InputPassword1").val() != $("#InputPassword2").val()) {
				alert("비밀번호가 일치하지 않습니다");
				$("#InputPassword1").val("");
				$("#InputPassword2").val("");
				return false;
			}

			var email = $("#InputEmail");

			if (email.val() == "") {
				alert("이메일을 입력하세요");
				return false;
			}

			var birth = $("#InputBirthday");

			if (birth.val() == "") {
				alert("생년월일을 입력하세요");
				return false;
			}

/* 			var hp = $("#InputHp");

			if (hp.val() == "") {
				alert("휴대폰 번호를 입력하세요");
				return false;
			} */

		});

	});
</script>
</head>
<body>
	<!-- 모달 추가 시작 register -->
	<div class="row">
		<div class="modal" id="register" tabindex="-1">
			<!-- #model로 지정했으므로 id="model" -->
			<div class="modal-dialog" style="z-index: 9999">
				<div class="modal-content" style="height: 950px">
					<div class="modal-header">
						회원가입
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" style="text-align: center;">

						<!-- 회원가입 -->
						<div class="col-md-12">
							<form action="register" method="post" style="display: block;" name="registerForm" enctype="multipart/form-data">
								<div class="form-group">
									<label for="username">사용자 이름</label> 
										<input type="text" class="form-control" id="username" placeholder="이름을 입력하세요" name="name">
								</div>

								<div class="form-group">
									<label for="InputId">아이디</label> 
										<input type="text" class="form-control" id="InputId" placeholder="아이디(영문+숫자/6~15이내)" name="mem_id" onchange="checkId()" >
								</div>

								<div class="form-group">
									<label for="InputPassword1">비밀번호</label> 
										<input type="password" class="form-control" id="InputPassword1" placeholder="비밀번호(영문+숫자/6~15이내)" name="password" >
								</div>

								<div class="form-group">
									<label for="InputPassword2">비밀번호 확인</label> 
									<input type="password" class="form-control" id="InputPassword2" placeholder="비밀번호 확인" name="password" onchange="checkPwd();">
								</div>

								<div class="form-group">
									<label for="InputEmail">이메일 주소</label> 
										<input type="email" class="form-control" id="InputEmail" placeholder="이메일(비밀번호 분실 시 필요합니다)" name="email" >
								</div>

								<div class="form-group">
									<label for="InputBirthday">생년월일</label> 
										<input type="date" class="form-control" id="InputBirthday"  name="birth" style="height:35px;" >
								</div>

								<div class="form-group">
									<label for="InputGender">성별</label>
									&nbsp;&nbsp;&nbsp; 
									<label> <!-- checked -->
										<input name="sex" type="radio" id="InputMale" value="남자" checked> 남자
									</label> 
									&nbsp;&nbsp;&nbsp; 
									<label>
										<input name="sex" type="radio" id="InputFemale" value="여자"> 여자
									</label>
								</div>

								<!-- div class="form-group">
									<label for="username">휴대폰 인증</label>
									<div class="input-group">
										<input type="tel" class="form-control" id="InputHp" placeholder="- 없이 입력하세요" name="phone">
										<span class="input-group-btn">
											<button class="btn btn-success">
												인증번호 전송<i class="fa fa-mail-forward spaceLeft"></i>
											</button>
										</span>
									</div>
								</div>

								<div class="form-group">
									<label for="username">인증번호 입력</label>
									<div class="input-group">
										<input type="text" class="form-control" id="InputReHp" placeholder="인증번호를 입력하세요"> 
										<span class="input-group-btn">
											<button class="btn btn-success">
												인증번호 입력<i class="fa fa-edit spaceLeft"></i>
											</button>
										</span>
									</div>
								</div> -->

								<div class="form-group">
									<label>약관 동의</label>
									<div data-toggle="buttons">
										<label class="btn btn-primary active"> 
											<span class="glyphicon glyphicon-ok"></span> 
											<input id="agree" type="checkbox" autocomplete="off" checked>
										</label> 
											<a href="#">이용약관</a>에 동의합니다.
									</div>
								</div>

								<div class="form-group text-center">
									<button type="submit" id="signupbtn" class="btn btn-info" onclick="alert('회원가입완료')">
										회원가입<i class="fa fa-check spaceLeft"></i>
									</button>
									<button type="reset" class="btn btn-warning">
										가입취소<i class="fa fa-times spaceLeft"></i>
									</button>
								</div>

							</form>
						</div>
						<!-- 회원가입 종료 -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 모달 추가 종료 register -->

</body>
</html>