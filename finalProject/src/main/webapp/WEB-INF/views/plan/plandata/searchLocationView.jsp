<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	
		<div class="container-fluid">
		
			<c:forEach var="i" items="${locationInfo}">
			<div class="row" onclick="locationClick('${i.location_num}')" style="margin-top:10px">
				
				<div class="col-md-4">
					<p><span id="locName_${i.location_num}">${i.location_name }</span></p>
					<hr>
					<img class="img-thumbnail" src="${images}where/trip_location/${i.location_img1}" alt="장소이미지" 
					width="150" height="150"><br>
					<span><small>주소 : ${i.location_addr}</small></span>
					
				</div>
				<div class="col-md-8">
					<p style="font-size:11px;">${i.detail_info }</p>
				</div>
			</div>
			<hr>
			</c:forEach>
			
		</div>
	
</body>
</html>