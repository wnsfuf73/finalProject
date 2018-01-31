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
	.well well-lg {
		border: none;
	}
	
</style>

<script type="text/javascript">
	
	var myPagebannerCount = 0;
	var rotateValue = 0;
	var syncFunction;
	
	$(function() {
		
		$.ajax({
			url : "getBannerCount?bannerLocation=mypage" ,
			type : 'GET',
			success : function(bannerCount) {
				myPagebannerCount = parseInt(bannerCount);
				rotateValue = myPagebannerCount;
				
				if(myPagebannerCount>1){
					syncFunction = setInterval(getBanner,2500);
				}
				else if(myPagebannerCount==1){
					rotateValue = 1;
					getBanner();
				} 
				//alert(myPagebannerCount);
			},
			error : function() {
				
			}
		})

		
	});
	
	$(window).on("beforeunload", function(){
		    clearInterval(syncFunction);
	}); 
	
	function getBanner(){
		
		$.ajax({
			
			url : "getBanner?bannerLocation=mypage&bannerSeq="+ rotateValue,
			type : 'GET',
			success : function(banner) {
				rotateValue--;
				if(rotateValue==0){
					rotateValue=myPagebannerCount;
				}
				
				var img = banner.bannerImg;
				var link = banner.bannerLink;
				
				$("#bannerImage").attr("src",'${images}banner/'+img);
				$("#bannerImage").attr("onclick","window.open('"+link+"')");
				/* 
				private int bannerNo;
				private String bannerName;
				private String bannerImg;
				private String bannerContent;
				private String bannerLocation;
				private String bannerLink;
				private int seq; */
				
			},
			error : function() {
				
			}
			
		})	
	
	}
	
	function previewFile() {
		
		  var preview = document.getElementById("faceImgView");
		  var file    = document.querySelector('input[type=file]').files[0];
		  var reader  = new FileReader();

		  reader.addEventListener("load", function () {
		    preview.src = reader.result;
		  	alert(document.getElementById("faceImg").value);
		  	
		    var formData = new FormData();
		    formData.append('uploadFile', $("input[name='uploadFile']")[0].files[0]);
		  	
		  	$.ajax({
		  		url:"faceImgUpload"
		  		,type:"POST"
		  		,data:formData
		  		,dataType:'json'
		  		,processData:false
		  		,contentType:false
		  		,success:function(){
		  			alert("성공")
		  		}
		  		,error:function(){
		  			alert("실패")
		  		}
		  	})
		  	
		  }, false);

		  if (file) {
		    reader.readAsDataURL(file);
		  }
	}
	
	
	

</script>

</head>
<body>
	
	<div class="container" style="margin-top: 40px;">
		<div class="row">
			<div class="col-md-4" style="border:1px solid #ccc; ">
				<div>
					<h4><span>프로필</span></h4>
					<div style="height:210px; text-align: center">
						<br><img id="faceImgView" class="img-circle" width="150" height="150" alt="프로필이미지" src="${images}userFaceImg/${faceImg}">
						<span style="position: relative;left: -50px;top: 60px;z-index: 9999;">
							<label for="faceImg">
							<img class="img-circle"
								alt="클릭" src="${images}myPage/profile.png">
							</label>
							<input id="faceImg" name="uploadFile" type="file" style="visibility: hidden;" onchange="previewFile();">
						</span>
					</div>
				</div>
				<hr>
				<div style="height:210px; ">
					<!-- <h4><span>내 이야기</span></h4> -->
					<div id="myStory" style="height: 100%">
						<iframe src="myNewStory" width="100%" height="100%"
						frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0>
						</iframe>
					</div>
				</div>
				<hr>
				<div style="height:210px; ">
					<!-- <h4><span>내 계획</span></h4> -->
					<div id="myPlan" style="height: 100%">
						<iframe src="myNewPlan" width="100%" height="100%"
						frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0>
						</iframe>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6">
							<div class="well well-lg" style="height: 162px; background-color: #f8f8f8; padding: 0px 0px;">
								<center><img onclick="window.location='boardList'" src="${images}myPage/myQna.gif"></center>
							</div>
							<div class="well well-lg" style="height: 162px; background-color: #f8f8f8; padding: 0px 0px;">
								<center><img onclick="window.location='modifyForm'" src="${images}myPage/modifyChange.gif"><center>
							</div>
						</div>
						<div class="col-md-6">
							<div class="well well-lg" style="height:330px; background-color: #ffffff; padding: 0px 0px;">
								<center><img id="bannerImage" src="${images}myPage/bannerLodding.gif" style="position: absolute; top: 0; left: 0; width: 95%; height: 95%;border-radius: 15px;"></center>
							</div>
						</div>
					</div>
					<div class="row" style="margin-bottom: 30px; border-bottom: 1px solid #ccc;">
						<div class="col-md-6">
							<div class="well well-lg" style="height: 162px; background-color: #f8f8f8;padding: 0px 0px;">
								<center><img onclick="window.location='deleteForm'" src="${images}myPage/joinOut.gif" alt="회원탈퇴"></center>
							</div>
						</div>
						<div class="col-md-6">
							<div class="well well-lg" style="height: 162px; background-color: #ffffff; padding: 0px 0px;">
								<center>
									<br><br><img onclick="parent.window.location='main'" src="${images}myPage/homeButton.png" alt="홈버튼"><br>
									<span style="color: rgb(143,143,143);"><b>메인페이지</b></span>
								</center>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="container-fluid"> 
								<h5>예약바로가기</h5>
								<div class="row">
									<div class="col-md-4" style="width:160px; border-right: 1px solid #ccc;">
										<img onclick="window.location='myReservation'" src="${images}myPage/stayReservation.png" width="150" height="150">
									</div>
									<div class="col-md-4" style="width:160px; border-right: 1px solid #ccc;">
										<img onclick="window.location='myReservation'" src="${images}myPage/airPlaneReservation.png"  width="150" height="150">
									</div>
									<div class="col-md-4" style="width:160px; border-right: 1px solid #ccc;">
										<img onclick="window.location='myReservation'" src="${images}myPage/rentReservation.png"  width="150" height="150">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>	
			
		</div>
		
	
	
	
	<hr>
	
	<!-- 하단 -->	
		<div class="row">
			<div class="col-md-12">
			<section id="company" class="company bg-light">
				<div class="container">
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
			</div>
		</div>
	</div>	
	
	
	
</body>
</html>