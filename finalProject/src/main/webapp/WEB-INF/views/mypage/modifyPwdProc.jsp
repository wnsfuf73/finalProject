<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ successModifyPwd == 1 }">
		<script type="text/javascript">
   			alert("비밀번호가 변경되었습니다. ");
   			window.location="main";
   		</script>
	</c:if>
	<c:if test="${ successModifyPwd == 0 }">
		<script type="text/javascript">
   			alert("비밀번호가 변경되지 않았습니다\n다시 한번 시도해주요");
   		</script>
	</c:if>
</body>
</html>