<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp" %>

<c:if test="${cnt==1}">
	<script type="text/javascript">
		alert("글삭제 완료");
		window.location="boardList?boardNo="+${boardNo}+"&requestPage="+${requestPage};
	</script>
</c:if>

<c:if test="${cnt==0}">
	<script type="text/javascript">
		alert("문의삭제 실패");
		window.location="boardDetail?boardNo="+${boardNo}+"&requestPage="+${requestPage};
	</script>
</c:if>