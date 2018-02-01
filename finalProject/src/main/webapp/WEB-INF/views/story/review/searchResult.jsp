<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${css}wrtcss/essay.css">

<title>Insert title here</title>
</head>
<body>
<c:if test="${dtos != null}">
<c:forEach var="dto" items="${dtos}">
	<div class="place_item">
		<img class="place_data_img" src="${images}where/trip_location/${dto.location_img1}">
		<div class="place_data_info">
			<ul>
				<li>
					<span id="location_name">${dto.location_name}
						<input type="hidden" id="location_name" value="${dto.location_name}">
						<input type="hidden" name="location_num" value="${dto.location_num}">
					</span>
				</li>
			</ul>
			<ul>
				<li>
					<span class="detail_info">${dto.detail_info}</span><br>
					<span class="location_addr">${dto.location_addr}</span>
				</li>
			</ul>
		</div>
		<p class="cate_info">${dto.thema_category}</p>
	</div>
</c:forEach>
</c:if>

<c:if test="${dtos==null}">
	<div class="place_item">
		검색결과가 없습니다. 검색어를 확인해주세요.
	</div>
</c:if>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->

<%-- <script src="${js}vendor/jquery-1.11.2.min.js"></script> --%>

<script type="text/javascript">
	/* 검색결과 검색창으로 넘기기 */
	$(document).ready(function(){
		$('.place_item').each(function(){	
			$(this).click(function(){			
				$(this).addClass("selected");					
	
				var targetValue = $(".selected input[id=location_name]").val();
				var location_num = $(".selected input[name=location_num]").val();
				//alert(location_num);
				
				$("input[type=text][name=searchcontent]").val(targetValue);
				/*  hidden으로  location_num 넘기기 */
				$("input[type=hidden][name=location_num]").val(location_num);
	
				$(this).siblings().removeClass("selected");				
	
				$('#search').css("display", "none");
			});
		});
	});
</script>
</body>
</html>