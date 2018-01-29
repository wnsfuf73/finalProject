<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp" %>

<c:if test="${cnt==1}">
	<script type="text/javascript">
		alert("글작성 완료");
		window.location="boardList";
	</script>
</c:if>
<c:if test="${cnt==0}">
	<script type="text/javascript">
		alert("문의작성 실패");
		window.location="boardWriteForm";
	</script>
</c:if>