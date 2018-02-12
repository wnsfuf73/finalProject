<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
<link rel="stylesheet" href="${css}bootsnav.css">
<link rel="stylesheet" href="${css}carousel.css">
<link rel="stylesheet" href="${css}style.css">
<link rel="stylesheet" href="${css}responsive.css" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script type="text/javascript">
	
	function paymentProc(){
		
		var form = document.radioForm;
 		var radioLength = form.payRadio.length;
 		 
	 	for (i=0;i<radioLength ;i++){
	 		if(form.payRadio[i].checked == true){
	 			break;
	 		}
	 	}
 		
 		if(radioLength == i){
 			$("#choicePaymentMethod").modal('show');
 			return false;
 		}
 		
		if(! ( $("#permitCheck").prop("checked") )){
			$("#privacyAgree").modal('show');
 			return false;
 		}
		else{
			$("#paymentProcModal").modal('show');
		}
 		
	}
	
 	function choicePayMethod(methodValue){
 		
 		window.android.choicePayMethod(methodValue);
 		return true;
 	}
	
</script>
<style type="text/css">
.paymethodElement{
	margin-top:5px;
	margin-right: 20px;
}
.form-group {
    margin-top: 15px;
}


.modal {
  text-align: center;
  padding: 0!important;
}

.modal:before {
  content: '';
  display: inline-block;
  height: 100%;
  vertical-align: middle;
  margin-right: -4px;
}

.modal-dialog {
  display: inline-block;
  text-align: left;
  vertical-align: middle;
}

</style>

</head>

<body style="padding-top:10px;">

		<!-- 본문내용 작성자 : 유준렬 -->
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="well well-xs" style="background-color: white">
						
						<h4><span class="glyphicon glyphicon-ok" aria-hidden="true">결제정보</span></h4>
						<hr style="border: 2px solid #98b9ca;">
							<div class="well well-xs"style="
												    padding-top: 0px;
												    padding-left: 0px;
												    padding-right: 0px;
												    padding-bottom: 0px;
												    margin-bottom: 0px;
												">
								<form name="radioForm" class="form-inline">
									  <div class="form-group" style="text-align: center;">
									    <span class="paymethodElement"><input type="radio" name="payRadio" value="계좌이체" onclick="choicePayMethod('계좌이체')">&nbsp;계좌이체</span>
									    <span class="paymethodElement"><input type="radio" name="payRadio" value="신용카드" onclick="choicePayMethod('신용카드')">&nbsp;신용카드 </span>
									  </div>
									  <div class="form-group" style="text-align: center;">
									  	<span class="paymethodElement"><input type="radio" name="payRadio" value="무통장입금" onclick="choicePayMethod('무통장입금')">&nbsp;무통장입금 </span>
									  	 <span class="paymethodElement"><input type="radio" name="payRadio" value="휴대폰" onclick="choicePayMethod('휴대폰')">&nbsp;휴대폰 </span>
									  </div>
								</form> 
								
							</div>
						<div class="container">
							<div class="col-xs-12">
							<form class="form-inline" action="#">
							  <div class="form-group">
							    <label for="name">결제자 이름 : </label>
							    <input type="text" class="form-control" id="name" >
							  </div>
							  <div class="form-group">
							    <label for="tel">연락처 : </label>
							    <input type="tel" class="form-control" id="tel" >
							  </div>
							   <div class="form-group">
							  	<label for="email">이메일 : </label>
							    <input type="email" class="form-control" id="email" >
							   </div>
							</form>

							</div>
						</div>
						<div class="well well-xs" 
								style="background-color: #ffffff; 
										border:none;
										padding: 5px 30px;
    									border: none;">
							<ul class='list-inline'>
							  <li>
							  	<div class="checkbox">
							  		<input type="checkbox" id="permitCheck">&nbsp;<b>주문 개인정보 수집동의</b>
							  	</div>
							  </li>
							</ul>
						</div>
						<div class="container">
							<div class="col-xs-12">
	  							<div class="center-block" style="width: auto;">
									<img alt="결제하기" src="${images }air/airpaymentImg.png" onclick="paymentProc()">
								</div>
							</div>
						</div>
					</div>
				
				</div>
			</div>
		</div>
		
		<!-- 
		
	<!-- 본문내용 작성자 : 유준렬 -->
  
  
    <!-- Modal -->
  <div class="modal fade" id="privacyAgree" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">진행할수 없음</h4>
        </div>
        <div class="modal-body">
          <p>개인정보 수집에 동의해주세요</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
    <!-- Modal -->
  <div class="modal fade" id="choicePaymentMethod" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">진행할수 없음</h4>
        </div>
        <div class="modal-body">
            <p>결제수단을 선택하세요</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  
    <!-- Modal -->
  <div class="modal fade" id="paymentProcModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">결제진행</h4>
        </div>
        <div class="modal-body">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;결제를 하시겠습니까?&nbsp;&nbsp;&nbsp;&nbsp;</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" 
           onclick="window.android.paymentProc();">결제</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
        </div>
      </div>
    </div>
  </div>
  
</body>
</html>