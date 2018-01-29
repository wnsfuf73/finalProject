<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../setting.jsp" %>


<c:forEach var="list" items="${dtos_car}">
						<c:if test="${list.car_count <= 0}">
							<tr>
								<td>${list.seq}</td>
								<td>${list.rental_day} ${list.rental_time}</td>
								<td>${list.return_day} ${list.return_time}</td>
								<td>${list.car_name}</td>
								<td><fmt:formatNumber value="${list.price}" groupingUsed="true"/></td>
								<td>${list.paymethod}</td>
								<c:set var="resCheck" value="${resMap[list.rent_no]}"/>
								<c:if test="${resCheck == 0}">
									<td><button class="btn btn-primary" onclick="carResCancel('${list.rent_no}')">예약취소</button></td>
								</c:if>
								<c:if test="${resCheck == 1}">
									<td>
										<button type="button" class="btn btn-primary" disabled="disabled">이용중</button>
										<button class="btn btn-primary" onclick="carResReturn('${list.rent_no}')">반납하기</button>
									</td>
								</c:if>
							</tr>
						</c:if>
					</c:forEach>			
						<tr>
							<td id="pagingArea" colspan="7" style="text-align: center;">
								
								<input type="hidden" value="${blockStartNumber_car}">
								<c:if test="${blockStartNumber_car!=1}">
									<input type="button" value="[◀◀]" onclick="getCarResList('${startPage_car}')">
									<input type="button" value="[◀]" onclick="getCarResList('${blockStartNumber_car-1}')">
								</c:if>
								<c:forEach var="n" begin="${blockStartNumber_car}" end="${blockEndNumber_car}">
									<c:if test="${n!=pageNum_car}">
										<a href="#" onclick="getCarResList('${n}')">${n}</a>
									</c:if>
									<c:if test="${n==pageNum_car}">
										<b>${n}</b>
									</c:if>
								</c:forEach>
								<c:if test="${blockEndNumber_car!=endPage_car}">
									<input type="button" value="[▶]" onclick="getCarResList('${blockEndNumber_car+1}')">
									<input type="button" value="[▶▶]" onclick="getCarResList('${endPage_car}')">
								</c:if>
							</td>
						</tr>