<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<title>Pouseidon - Free HTML5 Model Agency Bootstrap Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="favicon.ico">
<!--Google Fonts link-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i"
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
<style type="text/css">
  table {
    border-collapse: collapse;
    width: 100%;
	}
	
	th, td {
	    padding: 8px;
	    text-align: left;
	    border-bottom: 1px solid #ddd;
	}
	#paging,tr,th{
		text-align:center;
	 }
</style>
<!--For Plugins external css-->
<!--<link rel="stylesheet" href="${css}plugins.css" />-->
<!--Theme custom css -->
<link rel="stylesheet" href="${css}style.css">
<!--<link rel="stylesheet" href="${css}colors/maron.css">-->
<!--Theme Responsive css-->
<link rel="stylesheet" href="${css}responsive.css" />
<script src="${js}vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body data-spy="scroll" data-target=".navbar-collapse">
	<!-- Preloader -->
	<div id="loading">
		<div id="loading-center">
			<div id="loading-center-absolute">
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
				<div class="object"></div>
			</div>
		</div>
	</div>
	
		<%@include file="../../main/sample/header.jsp" %>
		<!-- 렌트카 리스트 -->
		<div class="container">
		<br>
			<form action="" method="post" name="rentCarForm">
			<h3>${rental_day}일 ${rental_time}분부터  ${return_day}일 ${return_time}분까지 ${car_kind}차량 검색 결과 입니다.</h3>
				
				<c:forEach var="car" items="${dtos}">
				<hr>			
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-3">
								<img src="/project/resources/images/car/${car.car_img}" width="200px" height="150px">
							</div>
							<div class="col-md-6">
							<br>
								<table class="table table-condensed">	
									<tr>
										<td style="width:270px;">차량이름</td>
										<td id="car_name">${car.car_name}</td>
									</tr>
									<tr>
										<td style="width:270px;">차량종류</td>
										<td id="car_kind">${car.car_kind}</td>
									</tr>																	
									<tr>
										<td style="width:270px;">1일가격</td>
										<td id="${car.car_num}_car_price"><fmt:formatNumber value="${car.car_price}" groupingUsed="true"/></td>			
									</tr>
									<tr>
										<td style="color:red;">총 가격</td>
											<c:if test="${rental_s == return_s}">
												<c:set var="total2" value="${(car.car_price*diffDats)}"/>												
												<td id="${car.car_num }_total"><fmt:formatNumber value="${total2}" groupingUsed="true"/></td>
											</c:if>
											<c:if test="${return_s < rental_s}">
												<c:set var="total" value="${(car.car_price*diffDats) + (car.car_addprice*ch)}" />												
												<td id="${car.car_num }_total"><fmt:formatNumber value="${total}" groupingUsed="true"/></td>		
									        </c:if>
									        <c:if test="${return_s > rental_s}">
									        	<c:set var="total1" value="${(car.car_price*diffDats) + (car.car_addprice*t)}"/>
									        	<td id="${car.car_num }_total"><fmt:formatNumber value="${total1}" groupingUsed="true"/></td>
									        </c:if>
									</tr>				
								</table>
							</div>
							<br>
							<div class="col-md-3">
								<c:set var="rentNum" value="${checkMap[car.rent_no]}"/>										
								<c:if test="${rentNum == 0}">
									<button type="button" class="btn btn-lg btn-primary" disabled="disabled">예약불가능</button>
								</c:if>
								<c:if test="${rentNum == 1}">
									<button type="button" class="btn btn-default btn-lg" onclick="showDetailCarInfo('${car.car_num}')">상세보기</button>
								</c:if>
								<c:if test="${rentNum == 2}">
									<button type="button" class="btn btn-lg btn-primary" disabled="disabled">예약불가능</button>
								</c:if>
								<c:if test="${rentNum == 3}">
									<button type="button" class="btn btn-default btn-lg" onclick="showDetailCarInfo('${car.car_num}')">상세보기</button>
								</c:if>
								<c:if test="${rentNum == 4}">
									<button type="button" class="btn btn-lg btn-primary" disabled="disabled">예약불가능</button>
								</c:if>
								<c:if test="${rentNum == null}">
									<button type="button" class="btn btn-default btn-lg" onclick="showDetailCarInfo('${car.car_num}')">상세보기</button>
								</c:if>
							</div>
						</div>
					</div> 				
				</c:forEach>
				<!-- 페이지 컨트롤 -->
				<div class="row">
					<div class="col-md-12">
						<table id="paging">
							<tr>
								<th align="center">
										<!-- 처음[◀◀] / 이전 블록[◀] -->
									<c:if test="${blockStartNumber!=1}">
										<input type="button" value="[◀◀]" onclick="window.location='rentList?requestPage=${startPage}&car_kind=${car_kind}&rental_day=${rental_day}&return_day=${return_day}&rental_time=${rental_time}&return_time=${return_time}'">
										<input type="button" value="[◀]" onclick="window.location='rentList?requestPage=${blockStartNumber-1}&car_kind=${car_kind}&rental_day=${rental_day}&return_day=${return_day}&rental_time=${rental_time}&return_time=${return_time}'">
									</c:if>
									<c:forEach var="n" begin="${blockStartNumber}" end="${blockEndNumber}">
										<c:if test="${n!=pageNum}">
											<a href="rentList?requestPage=${n}&car_kind=${car_kind}&rental_day=${rental_day}&return_day=${return_day}&rental_time=${rental_time}&return_time=${return_time}">${n}</a>
										</c:if>
										<c:if test="${n==pageNum}">
											<b>${n}</b>
										</c:if>
									</c:forEach>
									<c:if test="${blockEndNumber!=endPage}">
										<input type="button" value="[▶]" onclick="window.location='rentList?requestPage=${blockEndNumber+1}&car_kind=${car_kind}&rental_day=${rental_day}&return_day=${return_day}&rental_time=${rental_time}&return_time=${return_time}'">
										<input type="button" value="[▶▶]" onclick="window.location='rentList?requestPage=${endPage}&car_kind=${car_kind}&rental_day=${rental_day}&return_day=${return_day}&rental_time=${rental_time}&return_time=${return_time}'">
									</c:if>	
								</th>
							</tr>
						</table>
					</div>
				</div>			
			</form>
		</div>
	<!-- 렌트카 리스트 종료 -->
	
	<!-- 상세보기 모달 시작-->
		<div class="row">
			<div class="modal" id="carDetailModal" tabindex="-1">
				<div class="modal-dialog" style="z-index:9999">				
					<div class="modal-content">
						<form action="rentRequestReservation" name="carDetailModalForm" method="post" >
						<input type="hidden" name="rental_day" value="${rental_day}">
						<input type="hidden" name="return_day" value="${return_day}">
						<input type="hidden" name="rental_time" value="${rental_time}">
						<input type="hidden" name="return_time" value="${return_time}">
						<input type="hidden" name ="car_name">
						<input type="hidden" name="rent_no">
						<input type="hidden" name="mem_id" value="${mem_id}">
						<input type="hidden" name="brand_name">
						<input type="hidden" name="car_kind">
						<input type="hidden" name="insurance">
						<input type="hidden" name="fuel">
						<input type="hidden" name="car_price">
						<input type="hidden" name="car_addprice">
						<input type="hidden" name="total1">
						
							<div class="modal-header">
								<h4>차량 상세정보</h4>
							</div>
							<div class="modal-body">						
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-6">
											<img src="" width="350px" height="300px" id="car_img">
										</div>
										<div class="col-md-6">
											<br>
											<table class="table table-condensed">	
												<tr>
													<td>차량이름</td>
													<td id="car_name">${vo.car_name}</td>
												</tr>
												<tr>
													<td>차량브랜드</td>
													<td id="car_brand">${vo.brand_name}</td>
												</tr>
												<tr>
													<td>차량종류</td>
													<td id="car_kind">${vo.car_kind}</td>
												</tr>
													
												<tr>
													<td>보험</td>
													<td id="insurance">${vo.insurance}</td>
												</tr>
																	
												<tr>
													<td>연료상태</td>
													<td id="fuel">${vo.fuel}</td>
												</tr>
												<tr>
													<td>1일가격</td>
													<td id="car_price"><fmt:formatNumber value="${vo.car_price}" groupingUsed="true"/></td>			
												</tr>
												<tr>
													<td>시간당추가가격</td>
													<td id="car_addprice"><fmt:formatNumber type="number" value="${vo.car_addprice}" groupingUsed="true"/></td>		
												</tr>
												<tr>	
													<td style="color:red;">총가격</td>
														<c:if test="${rental_s == return_s}">
															<c:set var="total2" value="${(car.car_price*diffDats)}"/>												
															<td id="total">${total2}</td>
														</c:if>
 														<c:if test="${return_s < rental_s}">
															<c:set var="total" value="${(car.car_price*diffDats) + (car.car_addprice*ch)}" />
															<td id="total">${total}</td>		
												        </c:if>
												        <c:if test="${return_s > rental_s}">
												        	<c:set var="total1" value="${(car.car_price*diffDats) + (car.car_addprice*t)}"/>
												        	<td id="total">${total1}</td>
												        </c:if>
												</tr>				
											</table>
										</div>
									</div>
								</div> 
							<div class="row">
								<div class="col-md-12">		
								<br>		
									<h4>정보 입력</h4>			
									<table class="table table-condensed">
										<tr>
											<td>성명</td>
											<td colspan="3"><input type="text" name="name" style="width:100px;" required="required"></td>
										</tr>
										<tr>
											<td>휴대폰</td>
											<td colspan="3"><input type="text" name="phone1" style="width:100px;" required="required"> -
											<input type="text" name="phone2" style="width:100px;" required="required"> -
											<input type="text" name="phone3" style="width:100px;" required="required"></td>
										</tr>
										<tr>
											<td>면허종류</td>
											<td>
												<select required="required" name="driver_kind">
													<option>선탁하세요</option>
													<option>1종보통</option>
													<option>2종보통</option>
												</select>
											</td>
											<td>면허 유효일자</td>
											<td>
												<select required="required" name="driver1">
													<option>선택</option>
													<option>2018</option>
													<option>2019</option>
													<option>2020</option>
													<option>2021</option>
													<option>2022</option>
												</select>
												<select required="required" name="driver2">
													<option>선택</option>
													<option>01</option>
													<option>02</option>
													<option>03</option>
													<option>04</option>
													<option>05</option>
													<option>06</option>
													<option>07</option>
													<option>08</option>
													<option>09</option>
													<option>10</option>
													<option>11</option>
													<option>12</option>
												</select>
												<select required="required" name="driver3">
													<option>선택</option>
													<option>01</option>
													<option>02</option>
													<option>03</option>
													<option>04</option>
													<option>05</option>
													<option>06</option>
													<option>07</option>
													<option>08</option>
													<option>09</option>
													<option>10</option>
													<option>11</option>
													<option>12</option>
													<option>13</option>
													<option>14</option>
													<option>15</option>
													<option>16</option>
													<option>17</option>
													<option>18</option>
													<option>19</option>
													<option>20</option>
													<option>21</option>
													<option>22</option>
													<option>23</option>
													<option>24</option>
													<option>25</option>
													<option>26</option>
													<option>27</option>
													<option>28</option>
													<option>29</option>
													<option>30</option>
													<option>31</option>
												</select>
											</td>
										</tr>
										<tr>
											<td>E-mail</td>
											<td colspan="3"><input type="text" name="email1" required="required"> @ <input type="text" name="email2" required="required"></td>
										</tr>
									</table>
								</div>
							</div>
						
							<div class="row">
								<div class="col-md-12">
									<h4>결제 수단</h4>
										<input type="radio" name="payment" value="신용카드" checked="checked">신용카드 &ensp;&ensp;
										<input type="radio" name="payment" value="계좌이체">계좌이체 &ensp;&ensp;
										<input type="radio" name="payment" value="무통장입금">무통장입금 &ensp;&ensp;
										<input type="radio" name="payment" value="핸드폰결제">핸드폰결제 
								</div>
							</div>
								
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-default btn-sm">예약하기</button>
								<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">닫기</button>
							</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 상세보기 모달 종료 -->
	<script type="text/javascript">
		function showDetailCarInfo(car_num){
			
			$.ajax({
				url : "getViewDetail?car_num="+car_num
				,type : 'GET'
				,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
				,success : function(vo) {
					
					var car_addPrice = document.getElementById("car_addprice").innerHTML=vo.car_addprice;
					
					$("form[name='carDetailModalForm'] img").attr("src","/project/resources/images/car/"+vo.car_img);
					$("form[name='carDetailModalForm'] #car_name").html(vo.car_name);
					$("form[name='carDetailModalForm'] #car_kind").html(vo.car_kind);				
					document.getElementById("car_brand").innerHTML=vo.brand_name;
					document.getElementById("car_addprice").innerHTML=car_addPrice.toLocaleString();
					document.getElementById("insurance").innerHTML=vo.insurance;
					document.getElementById("fuel").innerHTML=vo.fuel;

					//총가격 (list에 뿌려진 총가격을 모달로 넘기기)
					var totalPrice = $("#"+car_num+"_total").text();
					$("#total").html(totalPrice);
					
					//리스트에 뿌려져있는 차량가격을 모달로 넘기기
					var dayPrice = $("#"+car_num+"_car_price").text();
					$("#car_price").html(dayPrice);
						
					$("#carDetailModal").modal('show');
					
					$("form[name='carDetailModalForm'] input[name='car_name']").attr("value",vo.car_name);
					$("form[name='carDetailModalForm'] input[name='rent_no']").attr("value",vo.rent_no);
					$("form[name='carDetailModalForm'] input[name='car_kind']").attr("value",vo.car_kind);
					$("form[name='carDetailModalForm'] input[name='brand_name']").attr("value",vo.brand_name);
					$("form[name='carDetailModalForm'] input[name='insurance']").attr("value",vo.insurance);
					$("form[name='carDetailModalForm'] input[name='fuel']").attr("value",vo.fuel);
					$("form[name='carDetailModalForm'] input[name='car_price']").attr("value",vo.car_price);
					$("form[name='carDetailModalForm'] input[name='car_addprice']").attr("value",vo.car_addprice);
					$("form[name='carDetailModalForm'] input[name='total1']").attr("value",totalPrice);
					
				}
				,error : function() {
					alert('error');
				}
			})
			
		}		
		
	</script>
		<%@include file="../../main/sample/footer.jsp" %>
	<!-- JS includes -->
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
</body>
</html>