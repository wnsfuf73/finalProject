<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>
<html>
<body>

<c:if test="${cnt==0}">
	<script type="text/javascript">
		alert("글이 수정되지 않았습니다.");
		window.location="qnaManage";
	</script>
</c:if>

<c:if test="${cnt!=0}">
	<script type="text/javascript">
		alert("글이 수정되었습니다");
		window.location="qnaManage";
	</script>
</c:if>
</body>
</html>