<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../setting.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
	li.bottomLine:link    { text-decoration:none }
	li.bottomLine:visited { text-decoration:none }
	li.bottomLine:hover   { text-decoration:underline; color:#73d0f4 }
	li.bottomLine:active  { text-decoration:none }
</style>
<script type="text/javascript">
	function planNoDetail(planNo,planTitle,planContent){
		parent.window.location="myPlanCourseContent?planNo="+planNo+"&pageNum=1&planTitle="+planTitle+"&planContent="+planContent;
	}
</script>
</head>
<body>

<div class="w3-container">
  <div class="w3-card-4" style="width:100%;">
    <header class="w3-container w3-gray">
      <h1>My Plan</h1>
    </header>
	<c:set var="size" value="${fn:length(newPlan)}"/> 
    <div class="w3-container">
       <ul class="w3-ul w3-border">
       	<c:if test="${size==0}">
			<li>등록된 계획이 없습니다.</li>
       	</c:if>
        <c:if test="${size>0}">
			<c:forEach var="vo" items="${newPlan}" varStatus="status" >
        		<li class="bottomLine" onclick="planNoDetail('${vo.planNo}','${vo.planTitle }','${vo.planContent }')">${status.index+1}.${vo.planTitle}</li>
       		</c:forEach>
       	</c:if>
      </ul>	
	
    </div>
	
  </div>
</div>

</body>
</html>
