<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${css}wrtcss/essay.css">
</head>
<body>
<c:if test="${dtos != null}">
<c:forEach var="dto" items="${dtos}">
	<div class="place_item">
		<img class="place_data_img" src="${images}story/story${dto.img1}">
		<div class="place_data_info">
			<ul>
				<li>
					<span id="location_name">${dto.title}
						<%-- <input type="hidden" id="location_name" value="${dto.location_name}">
						<input type="hidden" name="location_num" value="${dto.location_num}"> --%>
					</span>
				</li>
			</ul>
			<ul>
				<li>
					<span class="detail_info">${dto.content}</span><br>
					<%-- <span class="location_addr">${dto.location_addr}</span> --%>
				</li>
			</ul>
		</div>
		<p class="cate_info">${dto.kind}</p>
	</div>
</c:forEach>
</c:if>

<c:if test="${dtos==null}">
	<div class="place_item">
		검색결과가 없습니다. 검색어를 확인해주세요.
	</div>
</c:if>
</body>
</html>