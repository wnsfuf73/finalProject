<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../setting.jsp"%>

<c:if test="${epilList!=null}">
	<c:choose>
		<c:when test="${searchKind == null}">
			검색결과 : ${searchPhrase}
		</c:when>
		<c:when test="${searchKind != null }">
			<c:if test="${searchKind eq 'healing' }">
				<h3>힐링여행기 : ${searchPhrase}</h3>
			</c:if>
			<c:if test="${searchKind eq 'travel' }">
				<h3>관광여행기 : ${searchPhrase}</h3>
			</c:if>
			<c:if test="${searchKind eq 'leisuer' }">
				<h3>레져여행기 : ${searchPhrase}</h3>
				.
			</c:if>
			<c:if test="${searchKind eq 'eat' }">
				<h3>맛집여행기 : ${searchPhrase}</h3>
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
</c:if>
<c:if test="${epilList == null}">
	<p>검색결과가 없습니다.</p>
</c:if>