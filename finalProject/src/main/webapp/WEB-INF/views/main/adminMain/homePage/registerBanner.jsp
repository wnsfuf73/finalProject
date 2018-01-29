<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%-- <link rel="stylesheet" href="${css}bootstrap.mypage.css"> --%>
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
 <center><h3 style="color:#333">배너 등록</h3></center> 
<br>
<hr>
<form action="registerBannerPro" method="post" name="registerBanner" style=" align:center;" enctype="multipart/form-data"> <!-- class="w3-container w3-card-4" -->
  
   <table align="center">
           <tr>
               <td>이미지</td>
               	<td>
               	<div class="w3-row w3-section">
				  <div class="w3-col" style="width:50px"></div>
				    <div class="w3-rest">
		            	<input class="w3-input w3-border" name="bannerImg" type="file"  style="width:600px;">
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
				      <input class="w3-input w3-border" name="bannerName" type="text"  style="width:600px;">
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
				      <input class="w3-input w3-border" name="bannerContent" type="text"  style="width:600px;">
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
				      <input class="w3-input w3-border" name="bannerLink" type="url"  style="width:600px;">
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
				      <input class="w3-button w3-block w3-section w3-blue w3-ripple" style="width: 200px; margin: 0 auto; position:relative; background-color:#3498DB!important" type="submit" value="배너 등록">
				    </div>
				</div>
				</td>
           </tr>
       </table>
</form>
<!-- 추가 -->

</div>


</body>
</html>