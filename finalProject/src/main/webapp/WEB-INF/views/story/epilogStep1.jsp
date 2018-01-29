<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	
	
	<div class="container">
	
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
				<center><h4><span class="glyphicon glyphicon-flag"></span><b>&nbsp;&nbsp;여행기 만들기</b></h4></center>
				<hr>
			</div>
		</div><br>
		
		<div class="row">
			<div class="col-md-5 col-md-offset-1">
				<form action="" name="" method="GET">
				  <div class="form-group">
				    <label for="tour_title"><span style="font-size: 20px;">여행기 제목</span></label>
				    <input type="text" class="form-control" id="tour_title">
				  </div><br>
				  <div class="form-group">
				    <label for="tour_type"><span style="font-size: 20px;">여행기 타입</span></label>
			    	<div class="container-fluid">
			    		<div class="row">
			    			<div class="col-md-6">
			    				<img class="img-thumbnail" alt="" src="${images }support/domesticType.png">
			    			</div>
			    			<div class="col-md-6">
			    				<img class="img-thumbnail" alt="" src="${images }support/undomesticType.png">
			    			</div>
			    		</div><br><br>
			    		<div class="row">
			    			<div class="col-md-6 col-md-offset-1">
			    			 <div class="form-group">
				   				<img class="rounded mx-auto d-block" alt="" src="${images }/support/nextBtnImage.png">
				   			</div>
				   			</div>
			    		</div>
			    	</div>
				  </div>
				</form>
			</div>
		</div>
		

	</div>


</body>
</html>