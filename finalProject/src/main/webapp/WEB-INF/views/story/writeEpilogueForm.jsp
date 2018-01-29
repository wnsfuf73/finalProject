<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../setting.jsp" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
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
<link rel="stylesheet" href="${css}style.css">
<link rel="stylesheet" href="${css}responsive.css" />
	
<style>
* {
	box-sizing: border-box;
}

body {
	background-color: #f1f1f1;
}

#regForm {
	background-color: #ffffff;
	margin: 100px auto;
	font-family: Raleway;
	padding: 40px;
	width: 70%;
	min-width: 300px;
}

h1 {
	text-align: center;
}

input {
	padding: 10px;
	width: 100%;
	font-size: 17px;
	font-family: Raleway;
	border: 1px solid #aaaaaa;
}

/* Mark input boxes that gets an error on validation: */
input.invalid {
	background-color: #ffdddd;
}

/* Hide all steps by default: */
.tab {
	display: none;
}

button {
	background-color: #4CAF50;
	color: #ffffff;
	border: none;
	padding: 10px 20px;
	font-size: 17px;
	font-family: Raleway;
	cursor: pointer;
}

button:hover {
	opacity: 0.8;
}

#prevBtn {
	background-color: #bbbbbb;
}

/* Make circles that indicate the steps of the form: */
.step {
	height: 15px;
	width: 15px;
	margin: 0 2px;
	background-color: #bbbbbb;
	border: none;
	border-radius: 50%;
	display: inline-block;
	opacity: 0.5;
}

.step.active {
	opacity: 1;
}

/* Mark the steps that are finished and valid: */
.step.finish {
	background-color: #4CAF50;
}
</style>
</head>
<body>

	<form id="regForm" action="/action_page.php">
		<!-- One "tab" for each step in the form: -->
		<div class="tab">
			<div class="row">
				<div class="col-md-8">
					<center>
						<img alt="" src="${images}support/epilogStep1Head.png">
					</center>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<center>
						<h4>
							<span class="glyphicon glyphicon-flag"></span><b>&nbsp;&nbsp;여행기
								만들기</b>
						</h4>
					</center>
					<hr>
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-md-5 col-md-offset-1">
					<form action="" name="" method="GET">
						<div class="form-group">
							<label for="tour_title"><span style="font-size: 20px;">여행기
									제목</span></label> <input type="text" class="form-control" id="tour_title">
						</div>
						<br>
						<div class="form-group">
							<label for="tour_type"><span style="font-size: 20px;">여행기
									타입</span></label>
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-6">
										<img class="img-thumbnail" alt=""
											src="${images }support/domesticType.png">
									</div>
									<div class="col-md-6">
										<img class="img-thumbnail" alt=""
											src="${images }support/undomesticType.png">
									</div>
								</div>
								<br>
								<br>
								<div class="row">
									<div class="col-md-6 col-md-offset-1">
										<div class="form-group">
											<img class="rounded mx-auto d-block" alt=""
												src="${images }/support/nextBtnImage.png">
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
		<div class="tab">
			<div class="col-md-9">
				<center>
					<img alt="" src="${images}support/epilogStep2Head.png">
				</center>
				<hr>
			</div>
			<div class="col-md-3"></div>
		</div>
		<div class="row">
			<div class="col-md-9">
				<center>
					<h4>
						<span class="glyphicon glyphicon-pencil"></span><b>&nbsp;&nbsp;여행기
							작성중</b>
					</h4>
				</center>
				<hr>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-9">
				<div class="container-fulid">
					<form action="" name="" method="GET">
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label for="selectIndex">지점선택</label> <select id="selectIndex"
										class="form-control">
										<option>새지점</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="searchText">여행지찾기</label> <input id="searchText"
										type="text" class="form-control">
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label><span style="visibility: hidden;">찾기</span></label> <input
										type="button" value="찾아보기" class="form-control"
										style="width: 100%">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-11">
								<div class="form-group">
									<label for="content">내용 입력</label> <label for="maxSize">(<span>0</span>/500)
									</label>
									<textarea class="form-control" id="content" rows="5"></textarea>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-9 col-md-offset-1">
								<div class="form-group">
									<label for="content">이미지 등록</label>
									<div class="well well-lg">
										<center>
											<input type="file" value="사진추가" class="form-control"
												style="width: 50%"><br> <span><small>한지점당
													4개만 추가할수 있습니다.</small></span>
										</center>
									</div>
								</div>
							</div>
						</div>

						<br>
						<div class="row">
							<div class="col-md-3">
								<label for="reg_date">다녀온 날짜</label> <input id="reg_date"
									type="date" class="form-control">
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>

		<br>
		<div class="row">
			<div class="col-md-2 col-md-offset-1" style="margin-right: 3px;">
				<img class="img-thumbnail" alt=""
					src="${images }support/step2_back.png" height="50">
			</div>
			<div class="col-md-2">
				<img class="img-thumbnail" alt=""
					src="${images }support/saveCorse.png" height="50">
			</div>
			<div class="col-md-2">
				<img class="img-thumbnail" alt=""
					src="${images }support/step2_next.png" height="50">
			</div>
		</div>

		</div>
		<div class="tab">
			<div class="row">
				<div class="col-md-8">
					<center>
						<img alt="" src="${images}support/epilogStep3Head.png">
					</center>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<center>
						<h4>
							<span class="glyphicon glyphicon-floppy-save"></span><b>&nbsp;&nbsp;여행기
								저장</b>
						</h4>
					</center>
					<hr>
				</div>
			</div>
			<br>

			<div class="row">
				<div class="col-md-8">
					<div class="form-group">
						<label for="content">에필로그</label> <label for="maxSize">(<span>0</span>/500)
						</label>
						<textarea class="form-control" id="content" rows="5"></textarea>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-8">
					<form class="form-inline">
						<div class="wrap">
							<input type="radio" id="radio1" class="checkbox"
								name="privarcyRadio"> <label for="radio1"
								class="input-label radio">공개</label> <input type="radio"
								id="radio2" class="checkbox" name="privarcyRadio"> <label
								for="radio2" class="input-label radio">비공개</label>
						</div>
						<script type="text/javascript">
							$("input[name='privarcyRadio']").eq(0).attr(
									"checked", "checked");
						</script>
					</form>
				</div>
			</div>
			<br>
			<br>

			<div class="row">
				<div class="col-md-10">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-3">
								<img class="img-thumbnail" alt=""
									src="${images }support/step3_back.png" height="50">
							</div>
							<div class="col-md-3">
								<img class="img-thumbnail" alt=""
									src="${images }support/step3_save.png" height="50">
							</div>
							<div class="col-md-2 col-offset-1">
								<img class="img-thumbnail" alt=""
									src="${images }support/step3_preview.png" height="50">
							</div>
							<div class="col-md-2">
								<img class="img-thumbnail" alt=""
									src="${images }support/step3_delete.png" height="50">
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div style="overflow: auto;">
			<div style="float: right;">
				<button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
				<button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
			</div>
		</div>
		<!-- Circles which indicates the steps of the form: -->
		<div style="text-align: center; margin-top: 40px;">
			<span class="step"></span> <span class="step"></span> <span
				class="step"></span>
		</div>
	</form>

	<script>
		var currentTab = 0; // Current tab is set to be the first tab (0)
		showTab(currentTab); // Display the crurrent tab

		function showTab(n) {
			// This function will display the specified tab of the form...
			var x = document.getElementsByClassName("tab");
			x[n].style.display = "block";
			//... and fix the Previous/Next buttons:
			if (n == 0) {
				document.getElementById("prevBtn").style.display = "none";
			} else {
				document.getElementById("prevBtn").style.display = "inline";
			}
			if (n == (x.length - 1)) {
				document.getElementById("nextBtn").innerHTML = "Submit";
			} else {
				document.getElementById("nextBtn").innerHTML = "Next";
			}
			//... and run a function that will display the correct step indicator:
			fixStepIndicator(n)
		}

		function nextPrev(n) {
			// This function will figure out which tab to display
			var x = document.getElementsByClassName("tab");
			// Exit the function if any field in the current tab is invalid:
			if (n == 1 && !validateForm())
				return false;
			// Hide the current tab:
			x[currentTab].style.display = "none";
			// Increase or decrease the current tab by 1:
			currentTab = currentTab + n;
			// if you have reached the end of the form...
			if (currentTab >= x.length) {
				// ... the form gets submitted:
				document.getElementById("regForm").submit();
				return false;
			}
			// Otherwise, display the correct tab:
			showTab(currentTab);
		}

		function validateForm() {
			// This function deals with validation of the form fields
			var x, y, i, valid = true;
			x = document.getElementsByClassName("tab");
			y = x[currentTab].getElementsByTagName("input");
			// A loop that checks every input field in the current tab:
			for (i = 0; i < y.length; i++) {
				// If a field is empty...
				if (y[i].value == "") {
					// add an "invalid" class to the field:
					y[i].className += " invalid";
					// and set the current valid status to false
					valid = false;
				}
			}
			// If the valid status is true, mark the step as finished and valid:
			if (valid) {
				document.getElementsByClassName("step")[currentTab].className += " finish";
			}
			return valid; // return the valid status
		}

		function fixStepIndicator(n) {
			// This function removes the "active" class of all steps...
			var i, x = document.getElementsByClassName("step");
			for (i = 0; i < x.length; i++) {
				x[i].className = x[i].className.replace(" active", "");
			}
			//... and adds the "active" class on the current step:
			x[n].className += " active";
		}
	</script>

</body>
</html>
