<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>

<c:forEach var="list" items="${dtos_stay}">
	<tr>
		<td>${list.seq}</td>
		<td>${list.stay_name}</td>
		<td>${list.room_name}</td>
		<fmt:parseDate var="check_in" value="${list.check_in}"
			pattern="yyyy-MM-dd" scope="page" />
		<fmt:formatDate var="Check_in" value="${check_in}"
			pattern="yyyy-MM-dd" />
		<td>${Check_in}</td>
		<fmt:parseDate var="check_out" value="${list.check_out}"
			pattern="yyyy-MM-dd" scope="page" />
		<fmt:formatDate var="Check_out" value="${check_out}"
			pattern="yyyy-MM-dd" />
		<td>${Check_out}</td>
		<td>${list.stay_people}</td>
		<td>${list.pay_method}</td>
		<td>${list.room_sale_price}</td>
		<td>${list.reservation_date}</td>
		<c:set var="time" value="${checkMap[list.reservation_no]}" />
		<c:if test="${time == 0}">
			<td><button class="btn btn-primary"
					onclick="stayResCancel('${list.reservation_no}')">예약취소</button></td>
		</c:if>
		<c:if test="${time == 1}">
			<td><button class="btn btn-primary" disabled="disabled">숙박중</button></td>
		</c:if>
		<c:if test="${time == 2}">
			<td>숙박 완료</td>
		</c:if>

	</tr>
</c:forEach>
<tr>
	<td colspan="10" style="text-align: center;"><c:if
			test="${blockStartNumber_stay!=1}">
			<input type="button" value="[◀◀]"
				onclick="getStayResList('${startPage_stay}')">
			<input type="button" value="[◀]"
				onclick="getStayResList('${blockStartNumber_stay-1}')">
		</c:if> <c:forEach var="n" begin="${blockStartNumber_stay}"
			end="${blockEndNumber_stay}">
			<c:if test="${n!=pageNum_stay}">
				<a href="#" onclick="getStayResList('${n}')">${n}</a>
			</c:if>
			<c:if test="${n==pageNum_stay}">
				<b>${n}</b>
			</c:if>
		</c:forEach> <c:if test="${blockEndNumber_stay!=endPage_stay}">
			<input type="button" value="[▶]"
				onclick="getStayResList('${blockEndNumber_stay+1}')">
			<input type="button" value="[▶▶]"
				onclick="getStayResList('${endPage_stay}')">
		</c:if></td>
</tr>