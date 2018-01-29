<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인증키 입력 확인</title>
</head>
<body>

	<c:if test="${cnt==1}">
		<script type="text/javascript">
			alert("인증번호가 확인되었습니다");
			var url = "modifyPwd?mem_id=${mem_id}";
			window.location=url;
		</script>	
	</c:if>


	<c:if test="${cnt==0 }">
		<script type="text/javascript">
			alert("등록되지 않은 인증번호입니다 \n다시 한번 확인해주세요");
			window.location="findPwd";
		</script>
	</c:if>
	
	
	
	

</body>
</html>