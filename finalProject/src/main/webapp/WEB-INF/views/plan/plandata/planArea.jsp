<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${css}wrtcss/essay.css">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div id="essay_in_content">
				<div id="essay_container">
					<form name="plan_form" method="post" action="reviewPro">
						<div class="review_bottom">
							<ul class="find_place">
								<li class="plan_title">여행 주제</li>
								<li class="find_place_logo_input">
									<input type="text" id="review_find" name="searchcontent" value="${planTitle}">
								</li>
							</ul>
							<ul>
								<li class="plan_date">시작 날짜&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;마지막 날짜</li>
								<li>
									<input type="date" id="review_date1" name="startDate" >&ensp;&ensp;<input type="date" id="review_date1" name="endDate">
								</li>
								<li style="text-align:center" class="detailplan_btn">
									<input type="button" class="btn btn-default" value="상세계획만들기" id="detail_btn"
				onclick="window.location='detailplan?planNo=${planNo}&startDate='+document.plan_form.startDate.value+'&endDate='+document.plan_form.endDate.value">
								</li>
							</ul>
						</div>
					</form>
				</div>
			</div>							
		</div>
	</div>
</div>
</body>
</html>