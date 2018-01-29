<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../../../setting.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${css}responsive.css" />
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="w3-container">
		<!-- style="width:1000px" -->
		<!-- 추가 -->
		<center>
			<h3 style="color: #333">공지 사항</h3>
		</center>
		<br>
		<hr>
		<form action="" method="POST" name="noticeModifyForm"
			style="align: center;" onsubmit="contentReplace()">

			<table align="center">
				<tr>
					<td>유형</td>
					<td>
						<div class="w3-row w3-section">
							<div class="w3-col" style="width: 50px"></div>
							<div class="w3-rest">
								<select class="w3-select w3-border"
									style="width: 600px;">
									<option value="" disabled selected>공지</option>
								</select>
							</div>
						</div>
					</td>
				</tr>

				<tr>
					<td>제목</td>
					<td>
						<div class="w3-row w3-section">
							<div class="w3-col" style="width: 50px"></div>
							<div class="w3-rest">
								<input class="w3-input w3-border" name="title" type="text" value="${noticeVO.title }"
									style="width: 600px;">
							</div>
						</div>
					</td>
				</tr>


				<tr>
					<td>작성자</td>
					<td>
						<div class="w3-row w3-section">
							<div class="w3-col" style="width: 50px"></div>
							<div class="w3-rest">
								<input type="hidden" name="mem_id" value="${sessionScope.mem_id}">
								<input readonly="readonly" class="w3-input w3-border"
									type="text" style="width: 600px;"
									value="관리자">
							</div>
						</div>
					</td>
				</tr>

				<tr>
					<td>내용</td>
					<td>
						<div class="w3-row w3-section">
							<div class="w3-col" style="width: 50px"></div>
							<div class="w3-rest">
								<textarea class="w3-input w3-border" id="contentBox"
									style="height: 400px; width: 600px;">${noticeVO.content }</textarea>
								<input type="hidden" id="iuputContent" name="content">
							</div>
						</div>
					</td>
				</tr>

				<tr>
					<td></td>
					<td>
						<div class="w3-row w3-section">
							<div class="w3-col" style="width: 50px"></div>
							<div class="w3-rest">
								<ul class="list-inline">
									<li>
									<input class="w3-button w3-block w3-section w3-blue w3-ripple"
										style="width: 200px; margin: 0 auto; position: relative; background-color: #3498DB !important"
										type="button" value="수정" onclick="modifyNotice('${noticeVO.noticeNo}')">
									</li>
									<li>
									<input class="w3-button w3-block w3-section w3-blue w3-ripple"
									style="width: 200px; margin: 0 auto; position: relative; background-color: #3498DB !important"
									value="돌아가기" onclick="window.history.back()">
									</li>
								</ul>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
		<!-- 추가 -->

	</div>


	<script type="text/javascript">
		
		
		function modifyNotice(noticeNo){
			
			var title = document.noticeModifyForm.title.value;
			var content = contentReplace();
			
			$.ajax({
				url: "noticeModifyPro?noticeNo="+noticeNo+"&title="+title+"&content="+content
				,type:"GET"
				,success:function(msg){
					if(msg==1){
						alert("수정성공");
					}
					else{
						alert("수정실패");
					}
				},
				error:function(){
					alert("수정실패");
				}
			})
			
		}
	
		function contentReplace() {
			var str = document.getElementById("contentBox").value;
			str = str.replace(/(?:\r\n|\r|\n)/g, '<br />');
			document.getElementById("iuputContent").value = str;
			var result = document.getElementById("iuputContent").value;
			
			return result;
		}
		

	</script>

</body>
</html>