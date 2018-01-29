<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div>
		<table style="width: 1700px" align="center">
			<tr>
				<th style="width: 10%">장소 번호</th>
				<th style="width: 20%">장소 사진</th>
				<th style="width: 25%">장소 이름</th>
				<th style="width: 25%">장소 위치</th>
				<th style="width: 10%">장소 등급</th>
				<th style="width: 10%">장소 종류</th>
			</tr>

			<!-- 게시글이 있으면 -->
			<c:if test="${cnt > 0}">
				<c:forEach var="vo" items="${vos}">
					<tr>
						<td align="center">${number}<c:set var="number"
								value="${number-1}" /> (${vo.stay_no})
						</td>
						<td align="center"><img src="${images}stay/stay_location/${vo.stay_img1}"
							height="10%"></td>
						<td align="center"><a
							href="stay_list_view?stay_no=${vo.stay_no}&pageNum=${pageNum}&number=${number+1}">
								${vo.stay_name} </a></td>

						<td align="center">${vo.stay_address}</td>

						<td align="center">${vo.stay_class}</td>

						<td align="center">${vo.stay_kind}</td>

					</tr>
				</c:forEach>
			</c:if>

			<!-- 게시글이 없으면 -->
			<c:if test="${cnt == 0}">
				<tr>
					<td colspan="6" align="center">장소가 없습니다. 장소를 추가해 주세요.</td>
				</tr>
			</c:if>
		</table>

		<!-- 페이지 컨트롤 -->
		<table style="width: 1400px" align="center">
			<tr>
				<th align="center"><c:if test="${cnt > 0}">
						<!-- 처음[◀◀] / 이전 블록[◀] -->
						<c:if test="${startPage > pageBlock}">
							<a href="stay_list_view">[◀◀]</a>
							<a href="stay_list_view?pageNum=${startPage - pageBlock}">[◀]</a>
						</c:if>

						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:if test="${i == currentPage}">
								<span><b>[${i}]</b></span>
							</c:if>

							<c:if test="${i != currentPage}">
								<a href="stay_list_view?pageNum=${i}">[${i}]</a>
							</c:if>
						</c:forEach>

						<!-- 다음[▶] / 끝[▶▶] -->
						<c:if test="${pageCount > endPage}">
							<a href="stay_list_view?pageNum=${startPage + pageBlock}">[▶]</a>
							<a href="stay_list_view?pageNum=${pageCount}">[▶▶]</a>
						</c:if>
					</c:if></th>
			</tr>
		</table>
	</div>
</body>
</html>