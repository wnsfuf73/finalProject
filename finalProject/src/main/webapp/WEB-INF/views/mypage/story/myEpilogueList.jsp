<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style type="text/css">
	#myStory  div{
		float: left;
		/* margin: 20px 20px;
		margin-left: 30px;
		 */text-align: center;
		
	}
	
	div{
		width: 100%;
		text-align: center;
	}
	
</style>
<script type="text/javascript">
	
	function detailMyStory(epilogueNo){
		
		
		
	}
	
	function deleteMyStory(epilogueNo){
		
		if(confirm("이야기를 삭제합니다.")){
			
			$.ajax({
				url:"deleteMyStory?epilogueNo="+epilogueNo
				,type:'GET'
				,success:function(msg){
					if(msg==1){
						$("#card_"+epilogueNo).remove();
						alert("이야기를 삭제했습니다.");
					}
					else{
						alert("삭제실패");
					}
				}
				,error:function(){
					alert("error");
				}
			})
			
		}
		
	}
	

</script>
</head>
<body>
<h2>나의 이야기</h2>
<div id="myStory">

	<c:forEach var="vo" items="${myEpilogue}" >
	
 	  <div class="w3-card-4 w3-light-grey" style="width:33%" id="card_${vo.epilogueNo}">
	    <div class="w3-container w3-center">
		  <fmt:formatDate var="time" value="${vo.reg_date}" pattern="yyyy년 MM월 dd일"/>
	      <h4>${vo.title}</h4>
	      <img src="${images}story/story${vo.img1}" alt="이미지" style="width:80%">
	      <h5>${time}에 다녀옴...</h5>
	      <div class="w3-section">
	        <button class="w3-button w3-green" onclick="detailMyStory('${vo.epilogueNo}')">상세보기</button>
	        <button class="w3-button w3-red" onclick="deleteMyStory('${vo.epilogueNo}')">삭제하기</button>
	      </div>
	    </div>
	  </div>
	  
  </c:forEach>
  
</div>

<br><br>
<div class="w3-bar">
	<c:if test="${blockStartNumber!=1}">
		<a href="myEpilogueList?requestPage=${startPage}" class="w3-button">&laquo;&laquo;</a>
		<a href="myEpilogueList?requestPage=${blockStartNumber-1}" class="w3-button">&laquo;</a>
	</c:if>
	<c:forEach var="n" begin="${blockStartNumber}" end="${blockEndNumber}">
		<c:if test="${n!=pageNum}">
			<a class="w3-button" href="myEpilogueList?requestPage=${n}">${n}</a>
		</c:if>
		<c:if test="${n==pageNum}">
			<b>${n}</b>
		</c:if>
	</c:forEach>
	<c:if test="${blockEndNumber!=endPage}">
		<a href="myEpilogueList?requestPage=${blockEndNumber+1}" class="w3-button">&raquo;</a>
		<a href="myEpilogueList?requestPage=${endPage}" class="w3-button">&raquo;&raquo;</a>
	</c:if>
</div>

</body>
</html>