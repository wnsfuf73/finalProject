<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="${css}bootstrap.mypage.css">
<link rel="stylesheet" href="${css}qnaList.css" />
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- 글쓰기 실패 -->
	<c:if test="${cnt == 1 }">
		<script type="text/javascript">
			alert("글이 등록되었습니다.");	
			window.location="qnaManage";
		</script>	
	</c:if>
	
	<!-- 글쓰기 성공  -->
	<c:if test="${cnt != 1 }">
		<script type="text/javascript">
			alert("글이 등록되지 않았습니다. 다시 한번 작성해주세요.");
			window.location="qnaManage";
		</script>
	</c:if>


</body>
</html>