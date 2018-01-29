<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 11 -->
<%--     <link  rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
    <script  src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
    <link rel="stylesheet" href="${css}banner.css" />
    <script src="${js}moment-2.10.3.js"></script>
    <script src="${js}bootstrap-datetimepicker.js"></script> --%>

<!-- 11 -->





<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 


<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}qnaList.css" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</head>
<body>

 

    

 
<div id="main">


</div>
<br>
<div class="w3-container"><!-- style="width:1000px" -->
<!-- 추가 -->
 <center><h3 style="color:#333">배너 수정</h3></center> 
<br>
<hr>
<form action="updateBannerPro" method="post" name="updateBannerView" style=" align:center;" enctype="multipart/form-data"> <!-- class="w3-container w3-card-4" -->
  
<input type="hidden" name="bannerNo" value="${vo.bannerNo}">
<input type="hidden" name="pageNum" value="${pageNum}">

   <table align="center">
           <tr>
               <td>이미지</td>
               	<td>
               	<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
		            	<input class="w3-input w3-border" name="bannerImg" type="file"  style="width:600px;" value="${images}banner/${vo.bannerImg}">
					</div>
				</div>
				</td>
           </tr>
 
             <tr>
               <td>배너명</td>
               <td>
				<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
				      <input class="w3-input w3-border" name="bannerName" type="text"  style="width:600px;" value="${vo.bannerName}">
				    </div>
				</div>
			  </td>
           </tr>
           
           
            <tr>
               <td>배너설명</td>
               <td>
				<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
				      <input class="w3-input w3-border" name="bannerContent" type="text"  style="width:600px;" value="${vo.bannerContent }">
				    </div>
				</div>
			  </td>
           </tr>
          
        	 <tr>
               <td>URL</td>
               <td>
				<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
				      <input class="w3-input w3-border" name="bannerLink" type="url"  style="width:600px;" value="${vo.bannerLink}">
				    </div>
				</div>
			  </td>
           </tr>
				
			<tr>
               <td>배너위치</td>
               <td>
				<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
            		<select class="w3-select w3-border" name="bannerLocation" style="width:600px;">
						<option value="mypage">마이페이지</option>
					</select>
				    </div>
				</div>
			  </td>
           </tr> 

           
           
           <tr>
               <td></td> 
               <td>
				<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
				      <input class="w3-button w3-block w3-section w3-blue w3-ripple" style="width: 200px; margin: 0 auto; position:relative; background-color:#3498DB!important" type="submit" value="배너 수정">
				    </div>
				</div>
				</td>
           </tr>
       </table>
</form>
<!-- 추가 -->

</div>


<!-- javascript 추가 시작  -->

    <script type="text/javascript">
        $(function () {
            $('#bannerPeriodStart').datetimepicker();
            $('#bannerPeriodEnd').datetimepicker();
            $("#bannerPeriodStart").on("dp.change", function (e) {
                $('#bannerPeriodEnd').data("DateTimePicker").minDate(e.date);
            });
            $("#bannerPeriodEnd").on("dp.change", function (e) {
                $('#bannerPeriodStart').data("DateTimePicker").maxDate(e.date);
            });
        });
    </script>

<!--javascript  추가 종료 -->
</body>
</html>