<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
<div class="w3-container">

  <div class="w3-card-4" style="width:50%;">
    <header class="w3-container" style="background-color: #eee">
      <h1>${noticeVO.title}</h1>
    </header>

    <div class="w3-container">
      <p>
      	${noticeVO.content}
      </p>
    </div>
    
	<fmt:formatDate var="time" value="${noticeVO.reg_Date}" pattern="yyyy-MM-dd HH 시  mm 분"/>
    <footer class="w3-container" style="background-color: #eee">
      <h5>작성일시 : ${time}</h5>
    </footer>
  </div>
</div>

</body>
</html>
