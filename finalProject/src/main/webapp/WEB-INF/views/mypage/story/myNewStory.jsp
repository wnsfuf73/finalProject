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
	function epilogDetail(epilogueNo){
		parent.parent.window.location="epilogueDetail?epilogueNo="+epilogueNo+"&pageNum=1";
	}
</script>
</head>
<body>

<div class="w3-container">
  <div class="w3-card-4" style="width:100%;">
    <header class="w3-container w3-gray">
      <h1>My Story</h1>
    </header>
	<c:set var="size" value="${fn:length(newStory)}"/> 
    <div class="w3-container">
       <ul class="w3-ul w3-border">
       	<c:if test="${size==0}">
			<li>등록된 이야기가 없습니다.</li>
       	</c:if>
        <c:if test="${size>0}">
			<c:forEach var="vo" items="${newStory}" varStatus="status" >
        		<li class="bottomLine" onclick="epilogDetail('${vo.epilogueNo}')">${status.index+1}.${vo.title}</li>
       		</c:forEach>
       	</c:if>
      </ul>
    </div>

  </div>
</div>

</body>
</html>
