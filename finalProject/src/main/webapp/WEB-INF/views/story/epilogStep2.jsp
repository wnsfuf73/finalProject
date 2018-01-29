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
			<div class="col-md-9">
				<center>
				<img alt="" src="${images}support/epilogStep2Head.png">
				</center>
				<hr>
			</div>
			<div class="col-md-3">
			
			</div>
		</div>
		<div class="row">
			<div class="col-md-9">
				<center><h4><span class="glyphicon glyphicon-pencil"></span><b>&nbsp;&nbsp;여행기 작성중</b></h4></center>
				<hr>
			</div>
		</div><br>
		<div class="row">
			<div class="col-md-9">
				<div class="container-fulid">
					<form action="" name="" method="GET" >
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label for="selectIndex">지점선택</label>
									<select id="selectIndex" class="form-control">
										<option>새지점</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="searchText">여행지찾기</label>
									<input id="searchText" type="text" class="form-control">
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									<label><span style="visibility: hidden;">찾기</span></label>
									<input type="button" value="찾아보기" class="form-control" style="width: 100%">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-11">
								<div class="form-group">
									<label for="content">내용 입력</label>
									<label for="maxSize">(<span>0</span>/500)</label>
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
												<input type="file" value="사진추가" class="form-control" style="width: 50%"><br>
												<span><small>한지점당 4개만 추가할수 있습니다.</small></span>
											</center>
										</div>
									</div>
							</div>
						</div>
						
						<br>
						<div class="row">
							<div class="col-md-3">
								<label for="reg_date">다녀온 날짜</label>
								<input id="reg_date" type="date"  class="form-control">
							</div>			
						</div>
						
					</form>
				</div>
			</div>
		</div>
		
		<br>
		<div class="row">
			<div class="col-md-2 col-md-offset-1" style="margin-right: 3px;">
				<img class="img-thumbnail" alt="" src="${images }support/step2_back.png" height="50">
			</div>		
			<div class="col-md-2">
				<img class="img-thumbnail" alt="" src="${images }support/saveCorse.png" height="50">
			</div>		
			<div class="col-md-2">
				<img class="img-thumbnail" alt="" src="${images }support/step2_next.png" height="50">
			</div>			
		</div>
		

	</div>


</body>
</html>