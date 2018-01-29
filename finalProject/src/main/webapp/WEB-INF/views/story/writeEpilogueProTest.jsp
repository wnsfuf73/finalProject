<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
	var isInserted = ${isInserted};
	
	if (isInserted == 1){
		alert("글 작성이 완료되었습니다.");
		window.location="epilogueTest";
	}
	
	if (isInserted == 0){
		alert("글 작성에 실패했습니다.");
		window.history.back();
	}
</script>