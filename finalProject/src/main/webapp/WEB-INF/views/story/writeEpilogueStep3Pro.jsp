<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../setting.jsp" %>

<c:if test="${isInserted == 1}">
	<script>
		alert('글 작성에 성공했습니다.');
		window.location='main';
	</script>
</c:if>
<c:if test="${isInserted != 1 }">
	<script>
		alert('글 작성에 실패했습니다');
		window.history.back();
	</script>
</c:if>

