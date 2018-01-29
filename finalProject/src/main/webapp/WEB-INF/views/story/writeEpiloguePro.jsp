<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>

<c:if test="${isUpdate != 0}">
	<script type="text/javascript">
		alert("후기가 정상적으로 저장되었습니다.");
		alert("메인으로 이동합니다.");
		window.location="main";
	</script>
</c:if>
<c:if test="${isUpdate == 0 }">
	<script type="text/javascript">
		alert("후기 저장에 실패했습니다.");
		alert("잠시 후 다시 시도해주세요");
		window.history.back();
	</script>
</c:if>