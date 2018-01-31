<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../setting.jsp" %>

<c:if test="${isInserted == 1}">
	<script type="text/javascript">
		alert('글작성 완료');
		if(confirm("작성글을 확인하겠습니까?")){
			window.location="myEpilogueListDirectmyPage";
		}else{
			window.location="epilogueList";
		}
	</script>
</c:if>
<c:if test="${isInserted != 1 }">
	<script>
		alert('글 작성에 실패했습니다');
		window.history.back();
	</script>
</c:if>

