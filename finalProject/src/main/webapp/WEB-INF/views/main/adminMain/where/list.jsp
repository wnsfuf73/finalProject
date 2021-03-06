<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<table style="width: 1200px" align="center" border="1">
					<tr>
						<th style="text-align: center;">장소 번호</th>
						<th style="text-align: center;">장소 사진</th>
						<th style="text-align: center;">장소 이름</th>
						<th style="text-align: center;">장소 위치</th>
						<th style="text-align: center;">장소 지역</th>
						<th style="text-align: center;">장소 테마</th>
					</tr>

					<!-- 게시글이 있으면 -->
					<c:if test="${cnt > 0}">
						<c:forEach var="vo" items="${vos}">
							<tr>
								<td align="center">${vo.location_num}</td>
								<td align="center"><img
									src="${images}where/trip_location/${vo.location_img1}"
									height="100px;" width="150px"></td>
								<td align="center"><a
									href="modify?location_num=${vo.location_num}&pageNum=${pageNum}&number=${number+1}">
										${vo.location_name} </a></td>

								<td align="center">${vo.location_addr}</td>

								<td align="center">${vo.area}</td>

								<td align="center">${vo.thema_category}</td>
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
				<table style="width: 1200px" align="center">
					<tr>
						<th style="text-align: center;"><c:if test="${cnt > 0}">
								<!-- 처음[◀◀] / 이전 블록[◀] -->
								<c:if test="${startPage > pageBlock}">
									<a href="list">[◀◀]</a>
									<a href="list?pageNum=${startPage - pageBlock}">[◀]</a>
								</c:if>

								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:if test="${i == currentPage}">
										<span><b>[${i}]</b></span>
									</c:if>

									<c:if test="${i != currentPage}">
										<a href="list?pageNum=${i}">[${i}]</a>
									</c:if>
								</c:forEach>

								<!-- 다음[▶] / 끝[▶▶] -->
								<c:if test="${pageCount > endPage}">
									<a href="list?pageNum=${startPage + pageBlock}">[▶]</a>
									<a href="list?pageNum=${pageCount}">[▶▶]</a>
								</c:if>
							</c:if></th>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>