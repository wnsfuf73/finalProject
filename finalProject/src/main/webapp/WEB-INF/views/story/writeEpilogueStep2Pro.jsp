<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="row">
	<div class="col-md-3">
		<div class="form-group">
			<input type="hidden" name="epilogue_courseNo" id="epilogue_courseNo"
				value=""> <label for="selectIndex">지점선택</label> <select
				id="selectIndexes" class="form-control">
				<option value="">새지점</option>
				<c:forEach var="oneCourse" items="${listOfEpilCourse}">
					<option class="" id="" value="${oneCourse.epilogue_courseNo}">${oneCourse.visit_order}
						지점</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="col-md-6">
		<div class="form-group">
			<label for="searchText">여행지찾기</label> 
			<a id="searchBox"><input id="searchText"
				type="text" name="searchText" readonly class="form-control"><span
				style="visibility: hidden;">찾기</span></label> <input type="button"
				data-toggle="modal" data-target="#searchModal" value="찾아보기"
				class="form-control" style="width: 30%"> <label>
			</a>
		</div>
	</div>
</div>
<br>
<div class="row">
	<div class="col-md-11">
		<div class="form-group">
			<label for="content">내용 입력</label> <label for="maxSize">(<span>0</span>/500)
			</label>
			<textarea class="form-control" id="content" rows="5" value=""></textarea>
		</div>
	</div>
</div>
<br>
<div class="row">
	<div class="col-md-9 col-md-offset-1">
		<div class="form-group">
			<label for="content">이미지 등록</label>
			<div class="well well-lg">
				<center>
					<input id="uploadImg" type="file" value="사진추가" class="form-control"
						style="width: 50%"><br> <span><small>한지점당
							4개만 추가할수 있습니다.</small></span>
				</center>
				<div class="imgs_wrap" style="display: inline-block;">
					<span><small>이미지 미리보기</small></span>
				</div>
			</div>
		</div>
	</div>
</div>
<br>
