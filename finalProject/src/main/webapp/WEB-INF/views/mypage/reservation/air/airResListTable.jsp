<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>
<c:if test="${fn:length(voList_air)>0}">
	<c:forEach var="airRes" items="${voList_air }">
		<tr>
			<td>${airRes.seq }</td>
			<td>${airRes.startLocation }</td>
			<td>${airRes.endLocation }</td>
			<fmt:formatDate var="st" value="${airRes.startTime}"
			pattern="yyyy-MM-dd HH:mm" />
			<td>${st}</td>
			<fmt:formatDate var="et" value="${airRes.endTime}"
			pattern="yyyy-MM-dd HH:mm" />
			<td>${et}</td>
			<td>
				${airRes.memSize}
				<small>
					(${airRes.adult }|${airRes.student }|${airRes.baby })
				</small>
			</td>
			<td>
				<small>(
					<c:if test="${airRes.seatLevel_adult=='nomal'}">일반|</c:if>
					<c:if test="${airRes.seatLevel_adult=='highClass'}">고급|</c:if>
					<c:if test="${airRes.seatLevel_adult=='premium'}">프리미엄|</c:if>
					<c:if test="${airRes.seatLevel_adult=='noSelect'}">x|</c:if>
					
					<c:if test="${airRes.seatLevel_student=='nomal'}">일반|</c:if>
					<c:if test="${airRes.seatLevel_student=='highClass'}">고급|</c:if>
					<c:if test="${airRes.seatLevel_student=='premium'}">프리미엄|</c:if>
					<c:if test="${airRes.seatLevel_student=='noSelect'}">x|</c:if>
					
					<c:if test="${airRes.seatLevel_baby =='nomal'}">일반|</c:if>
					<c:if test="${airRes.seatLevel_baby=='highClass'}">고급|</c:if>
					<c:if test="${airRes.seatLevel_baby=='premium'}">프리미엄|</c:if>
					<c:if test="${airRes.seatLevel_baby=='noSelect'}">x|</c:if>
					)
				</small>
			</td>
			<td>${airRes.price }</td>
			<td>${airRes.payMethod}</td>
			<fmt:formatDate var="resTime" value="${airRes.resTime}"
			pattern="yyyy-MM-dd HH:mm" />
			<td>${resTime}</td>
			<td>
				<button class="btn btn-primary" onclick="airResCancel('${airRes.airPlaneNo}','${airRes.airResNo}')">예약취소</button>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="11" style="text-align: center;">
			<c:if test="${blockStartNumber_air!=1}">
				<input type="button" value="[◀◀]" onclick="getAirResList('${startPage_air}')">
				<input type="button" value="[◀]" onclick="getAirResList('${blockStartNumber_air-1}')">
			</c:if>
			<c:forEach var="n" begin="${blockStartNumber_air}" end="${blockEndNumber_air}">
				<c:if test="${n!=pageNum_air}">
					<a href="#" onclick="getAirResList('${n}')">${n}</a>
				</c:if>
				<c:if test="${n==pageNum_air}">
					<b>${n}</b>
				</c:if>
			</c:forEach>
			<c:if test="${blockEndNumber_air!=endPage_air}">
				<input type="button" value="[▶]" onclick="getAirResList('${blockEndNumber_air+1}')">
				<input type="button" value="[▶▶]" onclick="getAirResList('${endPage_air}')">
			</c:if>
		</td>
	</tr>
</c:if>
<c:if test="${fn:length(voList_air)==0}">
	<tr>
		<td colspan="11" style="text-align: center;">예약목록이 없습니다.</td>
	</tr>
</c:if>