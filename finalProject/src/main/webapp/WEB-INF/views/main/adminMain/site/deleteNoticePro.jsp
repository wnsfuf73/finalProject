<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>
<html>
<body>

	<c:if test="${hostDeleteCnt ==1}">
	<script type="text/javascript">
		alert("글이 삭제 되었습니다");
		window.location="qnaManage";
	</script>
	</c:if>
	
		<c:if test="${hostDeleteCnt !=1}">
	<script type="text/javascript">
		alert("글이 삭제되지 않았습니다\n다시 한번 시도해주세요");
		window.location="qnaManage";
	</script>
		</c:if>
	
</body>
</html>