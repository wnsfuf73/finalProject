<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>동행 공지사항</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	
	<c:if test="${noticeVO==null}"><script type="text/javascript"> window.close();</script> </c:if>
	
	<div class="w3-container" style="margin-top: 30px;">
		<div class="w3-card-4" style="width: 100%;">
			<header class="w3-container w3-gray">
			<h1>${noticeVO.title }</h1>
			</header>
			
			<div class="w3-container">
				<div class="w3-panel w3-border w3-light-grey w3-round-large">
					<p>
						${noticeVO.content}
					</p>
				</div>
			</div>

			<footer class="w3-container w3-white">
			<h5><fmt:formatDate value="${noticeVO.reg_Date}" pattern="yyyy-MM-dd HH:MM"/> 등록</h5>
			</footer>
		</div>
	</div>

</body>
</html>