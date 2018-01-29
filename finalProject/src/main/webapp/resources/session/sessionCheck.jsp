<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.mem_id==null}">
	<script type="text/javascript">
		window.location="loginForce";
	</script>
</c:if>
