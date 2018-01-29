<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>

<script type="text/javascript">
	alert("작성이 완료되었습니다.");

	window.onload = function(){
		
		var startDate = document.getElementById("fowordForm").startDate.value;
		var endDate = document.getElementById("fowordForm").endDate.value;
		var choiceDate = document.getElementById("fowordForm").choiceDate.value;
		
		if(startDate==endDate && startDate==choiceDate && choiceDate==endDate){
			window.location="plan";
		}
		else{
			document.getElementById("fowordForm").submit();
		}
		
	}
		
</script>

<form action="detailplan" id="fowordForm" method="POST">
	<input type="hidden" name="planNo" value="${planNo}">
	<input type="hidden" name="startDate" value="${startDate}">
	<input type="hidden" name="endDate" value="${endDate}">
	<input type="hidden" name="choiceDate" value="${day}">
</form>

