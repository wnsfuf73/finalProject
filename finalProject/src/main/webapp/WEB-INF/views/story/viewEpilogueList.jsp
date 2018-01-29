<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>




<c:choose>
	<c:when test="${kind == null}">
		<h3>전체여행기</h3>
	</c:when>
	<c:when test="${kind != null }">
		<c:if test="${kind eq 'healing' }">
			<h3>힐링여행기</h3>
		</c:if>
		<c:if test="${kind eq 'travel' }">
			<h3>관광여행기</h3>
		</c:if>
		<c:if test="${kind eq 'leisure' }">
			<h3>레져여행기</h3>
		</c:if>
		<c:if test="${kind eq 'eat' }">
			<h3>맛집여행기</h3>
		</c:if>
	</c:when>
</c:choose>
<c:forEach var="epil" items="${epilList}" varStatus="status">
	<input type="hidden" id="epilNum" name="epilNum"
		value="${epil.epilogueNo}">
	<a id="epilogueBox"
		href="epilogueDetail?epilogueNo=${epil.epilogueNo}&pageNum=${pageNum}">
		<div class="col-sm-3">
			<p>${epil.title}</p>
			<input type="hidden" id="selectedEpilNum" name="selectedEpilNum"
				value="${epil.epilogueNo}"> <img class="thumbnail"
				src="/project/resources/images/story/story${epil.img1}"
				style="width: 190px; height: 280px;">

			<c:forEach var="info" items="${epil.visitOrder}" varStatus="status">
				<p>
					<b>${status.index + 1}</b><small>${info}</small>
				</p>
			</c:forEach>
			<p>
				<fmt:formatDate value="${epil.reg_date}" />
				에 다녀왔다시발
			</p>
			<span id="otherPart">좋아요 : ${epil.goodcount}   댓글 : ${epil.commentCount}</span>
		</div>
	</a>
</c:forEach>