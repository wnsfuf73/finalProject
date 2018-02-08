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
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>




<style type="text/css">
	
	
	
	#coursePath div:nth-child(2n-1) ul li{
		list-style-type: none;
		width: 100px;
		height:80px;
		float: left;
	}
	
	#coursePath div:nth-child(2n) ul li{
		list-style-type: none;
		width: 100px;
		height:80px;
		float: right;
	}
	
	
	/* ul:nth-child(2n-1) li{
		list-style-type: none;
		width: 100px;
		height:100px;
		float: left;
	} */
	/* ul:nth-child(2n) li{
		list-style-type: none;
		width: 100px;
		height:100px;
		float: right;
	} */
	
	a span {
		color: white;
	}
	
	.start{
		background-image: url('${images}story/line/c_start.png');
		background-repeat: no-repeat;
	}
	
	.mid{
		background-image: url('${images}story/line/c_mid.png');
		background-repeat: no-repeat;
	}
	
	.top_down{
		background-image: url('${images}story/line/c_mid_l_b.png');
		background-repeat: no-repeat;
	}

	.down_start{
		background-image: url('${images}story/line/c_mid_t_l.png');
		background-repeat: no-repeat;
	}
	
	.aaa{
		background-image: url('${images}story/line/c_mid.png');
		background-repeat: no-repeat;
	}

</style>

<script type="text/javascript">

	window.onload = function(){
		
	
	}
	 
</script>


</head>

<body style="background-color: #f3f3f3;">


<nav class="navbar navbar-default navbar-fixed white no-background bootsnav text-uppercase" 
style="background-color: #36363b;">

	
	<div class="container">
	
		<!-- Start Header Navigation -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-menu">
				<i class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand" href="main"> 
				<span><b>홈</b></span><img  class="logo logo-display" alt=""> 
				<img class="logo logo-scrolled" alt="">
			</a>
		</div>
		<!-- End Header Navigation -->
	
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="navbar-menu">
			<ul class="nav navbar-nav navbar-right" data-in="fadeInDown"
				data-out="fadeOutUp">
				<li><a href="plan"><span>계획하기</span></a></li>
				<li><a href="epilogueList"><span>이야기</span></a></li>
				<li><a href="where_main"><span>어디갈까</span></a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><span>예약</span> </a>
					<ul class="dropdown-menu">
						<li><a href="stayReservation"><span>숙박 예약</span></a></li>
						<li><a href="airReservation"><span>항공 예약</span></a></li>
						<li><a href="rentReservation"><span>렌트카 예약</span></a></li>
					</ul>
				</li>
			<c:if test="${sessionScope.mem_id == null}">					
							<li><a href="" data-toggle="modal" data-target="#login">로그인</a></li>
							<li><a href="" data-toggle="modal" data-target="#register">회원가입</a></li>
						</c:if>
						<c:if test="${sessionScope.mem_id != null}">
							<li class="dropdown">
							<a class="dropdown-toggle"
								data-toggle="dropdown" href="#">${sessionScope.mem_id}님</a>
								<ul class="dropdown-menu">
									<li><a href="myPageStart">마이페이지</a></li>
									<li><a href="logout" >로그아웃</a></li>
								</ul>
							</li>
						</c:if>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>

		</nav>
		<c:if test="${sessionScope.mem_id == null}">
			<%@include file="../main/modal/loginModal.jsp"%>
			<%@include file="../main/modal/registerModal.jsp"%>
		</c:if>

	<div class="container" style="background-color: #ffffff;">
		<div class="row">
			<div class="col-md-3">
				<span>${epilogVo.title}</span><br>
				<span><small>2018년 01월 25일</small></span><br>
				<span>작성자 : ${epilogVo.mem_id}</span>
			</div>
			<div class="col-md-4 col-md-offset-3 ">
				<span>조회수 : ${epilogVo.readCnt}</span>
			</div>
		</div><hr>
		<div class="row">
			<div class="col-md-11">
				<span>여행코스</span>
			</div>
		</div>
		<div class="row">
			<%-- <div style="width: 720px; height: auto;">
				<c:forEach var="loc" items="${epilogueDetailList}">
					${loc.location_name }<br>
				</c:forEach>
			</div> --%>
		</div>
		<div class="row">
			<div class="col-md-11">
			
			<!-- 
			int epilogueNo;
			String iscomplete;
			String kind;
			String title;
			String img1;
			String img2;
			String img3;
			String img4;
			String location_addr;
			String location_name;
			Date dday;
			int visit_order;
			String mem_id;
			String faceImg;
			String epilogContent;
			String courseContent; -->
			
			<!-- foreach -->
			<c:forEach var="i" items="${epilogueDetailList}">
				<!-- <script type="text/javascript"> 
					location_path.push('${i.location_name}');
				</script> -->
				<div class="container-fluid">
					
					<div class="row">
						<div class="col-md-11">
							<div class="well well-lg" style="background-color: #fbfcfd;">
								<%-- <span>${i.location_name }</span><br><span><small>${i.location_addr }</small></span> --%>
							</div><br>
						</div>
					</div>	
					<div class="row">
						<div class="col-md-11">
							<div id="courseContent">${i.courseContent }</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-11">
							<div class="thumbnail">
								<center>
									<img alt="img1" src="${images}story/${i.img1}" width="100%" height="450px;">
								</center>
								<span>${i.dday}</span>
							</div>
							
							<div class="container-fluid">
								<div class ="row">
									<div class="col-md-3 col-md-offset-1">
										<div class="thumbnail"><img alt="img2" src="${images}story/${i.img2}" width="100%" height="100%"></div>
									</div>
									<div class="col-md-3">
										<div class="thumbnail"><img alt="img3" src="${images}story/${i.img3}" width="100%" height="100%"></div>
									</div>
									<div class="col-md-3">
										<div class="thumbnail"><img alt="img4" src="${images}story/${i.img4}" width="100%" height="100%;"></div>
									</div>
								</div>
							</div>
							
						</div>
						<div class="row">
						<div class="col-md-11">
							<span><p>에필로그</p></span>
							<div id="courseContent">${epilogVo.content }</div>
						</div>
					</div>
					</div>
					
				</div>
				
			</c:forEach>
			<!-- foreach -->
			</div>
		</div>
		<br /><br />
		<div class="row">
			<div class="col-md-6">
				<center>
					<span class="glyphicon glyphicon-thumbs-up"><a id="clickLike" onclick="likeFunction();"> 좋아요</a></span> 
				</center><br>
				<center>
					${likeCnt}
				</center>
			</div>
			<div class="col-md-6">
				<center>
					<span class="glyphicon glyphicon-pencil"> 댓글수</span> 
				</center><br>
				<center>
					<span id="commentCount">${commentCnt}</span>
				</center>
			</div>
		</div>
		
<%-- 		<div class="container">
			<label for="content">이 글을 좋아하는 분들</label>
			<form id="likeInsertForm" name="likeInsertForm">
				<div class="input-group">
					<input type="hidden" id="epilogueNo" name="epilogueNo" value="${epilogVo.epilogueNo}">
					
					<div class="likerList">

					</div>					
				</div>
			</form>
		</div>
		
		<div class="container">
			<div class="likeList">
			
			</div>
		</div> --%>
		
		<br><br>
		<div class="container">
			<label for="content">comment</label>
			<form id="commentInsertForm" name="commentInsertForm">
				<div class="input-group">
					<input type="hidden" id="epilogueNo" name="epilogueNo" value="${epilogVo.epilogueNo}">
					
					<input type="text" class="form-control" id="commentContent" name="commentContent" placeholder="내용을 입력해주세요.">
					
					<span class="input-group-btn">
						<button class="btn btn-default" id="commentInsertBtn" type="button" name="commentInsertBtn">등록</button>
					</span>
				</div>
			</form>
		</div>
		
		<div class="container">
			<div class="commentList">
			
			</div>
		</div>
		
		<%@ include file="./commentDetail.jsp" %>
		
	</div>
	
	<!--Company section-->
	<section id="company" class="company bg-light">
		<div class="container" >
			<div class="row">
				<div class="main_company roomy-100 text-center">
					<h3 class="text-uppercase">동 행</h3>
					<p>가산 다지털 단지 - 한국 소프트웨어 인재 개발원</p>
					<p>010 - 1234 - 5678<br>
					info@poiseidon.lnk</p>
				</div>
			</div>
		</div>
	</section>

	<!-- scroll up-->
	<div class="scrollup">
		<a href="#"><i class="fa fa-chevron-up"></i></a>
	</div>
	<!-- End off scroll up -->
	
	<footer id="footer" class="footer bg-mega">
			<div class="container">
				<div class="row">
					<div class="main_footer p-top-40 p-bottom-30">
						<div class="col-md-6 text-left sm-text-center">
							<p class="wow fadeInRight" data-wow-duration="1s">
								Made with <i class="fa fa-heart"></i> by <a target="_blank"
									href="http://bootstrapthemes.co">Bootstrap Themes</a> 2016. All
								Rights Reserved
							</p>
						</div>
						<div class="col-md-6 text-right sm-text-center sm-m-top-20">
							<ul class="list-inline">
								<li><a href="">Facebook</a></li>
								<li><a href="">Twitter</a></li>
								<li><a href="">Instagram</a></li>
								<li><a href="">Pinterest</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
	</footer>
	
</body>
</html>