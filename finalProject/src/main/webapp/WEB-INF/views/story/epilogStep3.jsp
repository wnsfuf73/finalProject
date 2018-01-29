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
<style type="text/css">
	/* 인풋 */
	.checkbox[type=checkbox], .checkbox[type=radio] {display:none;}
	label.input-label { 
	  display: inline-block;
	  font-size: 13px;
	  cursor: pointer;
	  }
	label.input-label::before {
	  display: inline-block;
	  margin:0 20px;
	  font-family: FontAwesome;
	  font-size: 20px;
	  color: rgba(4, 120, 193,0.2);
	  -webkit-transition: transform 0.2s ease-out, color 0.2s ease;
	  -moz-transition: transform 0.2s ease-out, color 0.2s ease;
	  -ms-transition: transform 0.2s ease-out, color 0.2s ease;
	  -o-transition: transform 0.2s ease-out, color 0.2s ease;
	  transition: transform 0.2s ease-out, color 0.2s ease;
	  -webkit-transform: scale3d(0.8,0.8,1);
	  -moz-transform: scale3d(0.8,0.8,1);
	  -ms-transform: scale3d(0.8,0.8,1);
	  -o-transform: scale3d(0.8,0.8,1);
	  transform: scale3d(0.8,0.8,1);
	}
	label.input-label.checkbox::before {
	  content: "\f0c8";
	}
	label.input-label.radio::before {
	  content: "\f111";
	}
	input.checkbox + label.input-label:hover::before {
	  -webkit-transform: scale3d(1,1,1);
	  -moz-transform: scale3d(1,1,1);
	  -ms-transform: scale3d(1,1,1);
	  -o-transform: scale3d(1,1,1);
	  transform: scale3d(1,1,1);
	}
	
	input.checkbox + label.input-label:active::before {
	  -webkit-transform: scale3d(1.5,1.5,1);
	  -moz-transform: scale3d(1.5,1.5,1);
	  -ms-transform: scale3d(1.5,1.5,1);
	  -o-transform: scale3d(1.5,1.5,1);
	  transform: scale3d(1.5,1.5,1);
	}
	
	input.checkbox:checked + label.input-label::before {
	  display: inline-block; 
	  font-family: FontAwesome; 
	  color:#0478c1;
	  -webkit-transform: scale3d(1,1,1);
	  -moz-transform: scale3d(1,1,1);
	  -ms-transform: scale3d(1,1,1);
	  -o-transform: scale3d(1,1,1);
	  transform: scale3d(1,1,1);
	}
	input.checkbox:checked + label.input-label.checkbox::before {
	    content:"\f14a";
	}
	input.checkbox:checked + label.input-label.radio::before {
	    content:"\f058";
	}
</style>

</head>
<body>
	
	
	<div class="container">
	
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
				<center><h4><span class="glyphicon glyphicon-floppy-save"></span><b>&nbsp;&nbsp;여행기 저장</b></h4></center>
				<hr>
			</div>
		</div><br>
		
		<div class="row">
			<div class="col-md-8">
				<div class="form-group">
					<label for="content">에필로그</label>
					<label for="maxSize">(<span>0</span>/500)</label>
				    <textarea class="form-control" id="content" rows="5"></textarea>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-8">
			<form class="form-inline">
				<div class="wrap">
					<input type="radio" id="radio1" class="checkbox" name="privarcyRadio">
		   			<label for="radio1" class="input-label radio">공개</label>
		   			<input type="radio" id="radio2" class="checkbox" name="privarcyRadio">
		   			<label for="radio2" class="input-label radio">비공개</label>
		   		</div>
				<script type="text/javascript">
					$("input[name='privarcyRadio']").eq(0).attr("checked","checked");
				</script>
			</form>
			</div>
		</div>
		<br><br>
		
		<div class="row">
			<div class="col-md-10">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-3">
						<img class="img-thumbnail" alt="" src="${images }support/step3_back.png" height="50">
					</div>
					<div class="col-md-3">
						<img class="img-thumbnail" alt="" src="${images }support/step3_save.png" height="50">
					</div>
					<div class="col-md-2 col-offset-1">
						<img class="img-thumbnail" alt="" src="${images }support/step3_preview.png" height="50">
					</div>
					<div class="col-md-2">
						<img class="img-thumbnail" alt="" src="${images }support/step3_delete.png" height="50">
					</div>
				</div>
			</div>
			</div>
		</div>
		
	</div>


</body>
</html>