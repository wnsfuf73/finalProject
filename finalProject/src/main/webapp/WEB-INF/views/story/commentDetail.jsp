<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>


<script>
	// 안되면 epilogueNo = $('input[type=hidden][name=epilogueNo]').val()
	var epilogueNo = $('#epilogueNo').val();

	$('#commentInsertBtn').on('click', function() {

		var insertData = $('#commentInsertForm').serialize();
		commentInsert(insertData);

	});

	function commentList() {

		$
				.ajax({

					url : 'commentList',
					type : 'get',
					data : {
						'epilogueNo' : epilogueNo
					},
					success : function(data) {

						var comment = '';

						$
								.each(
										data,
										function(key, value) {

											comment += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
											comment += '<div class="commentInfo'+value.epilogue_commentNo+'">'
													+ '작성자 : '
													+ value.mem_id;
											comment += '<a onclick="commentUpdate('
													+ value.epilogue_commentNo
													+ ',\''
													+ value.content
													+ '\',\''
													+ value.mem_id
													+ '\');"> 수정 </a>';
											comment += '<a onclick="commentDelete('
													+ value.epilogue_commentNo
													+ ',\''
													+ value.mem_id
													+ '\');"> 삭제 </a> </div>';
											comment += '<div class="commentContent'+value.epilogue_commentNo+'"> <p> 내용 : '
													+ value.content + '</p>';
											comment += '</div></div>';

										});

						$('.commentList').html(comment);
					}
				});
	}

	function commentInsert(insertData) {


		$.ajax({

			url : 'insertComment',
			type : 'GET',
			data : insertData,
			success : function(data) {
				if (data == 1) {
					commentList();
					$('#commentContent').val("");
					
					var curCount = $('#commentCount').text();
					curCount = parseInt(curCount)+1;
					$('#commentCount').html(curCount);				
				}
			}

		});

	}

	function commentUpdate(epilogue_commentNo, content, mem_id) {

		var comment = '';

		$
				.ajax({

					url : 'getCurrentId',

					success : function(data) {
						if (data === mem_id) {
							comment += '<div class="input-group">';
							comment += '<input type="text" id="commentContent'+epilogue_commentNo+'" class="form-control" name="commentContent'+epilogue_commentNo+'" value="'+content+'" />';
							comment += '<input type="hidden" class="form-control" id="commentContentWriter'+epilogue_commentNo+'" name="commentContentWriter'+epilogue_commentNo+'" value="'+mem_id+'" />';
							comment += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="updateCommentProc('
									+ epilogue_commentNo
									+ ');">수정</button> </span>';
							comment += '</div>';

							$('.commentContent' + epilogue_commentNo).html(
									comment);
						} else {
							alert('남의 댓글을 수정 할 수 없어요!');
							window.history.back();
						}
					},

				});
	}

	function updateCommentProc(epilogue_commentNo) {


		var updateContent = $('[name=commentContent' + epilogue_commentNo + ']')
				.val();
		var mem_id = $('[name=commentContentWriter' + epilogue_commentNo + ']')
				.val();
		
		if(updateContent === ""){
			alert('내용을 입력해주세요');
			return false;
		}
		
		$.ajax({

			url : 'updateComment',
			type : 'post',
			data : {
				'commentContent' : updateContent,
				'epilogue_commentNo' : epilogue_commentNo,
				'mem_id' : mem_id
			},
			success : function(data) {

				if (data == 1) {
					commentList(epilogueNo);
				} else {
					alert('글 수정에 실패했습니다.');
					window.history.back();
				}
			},
			
			error : function(){
				alert('에러가 발생했습니다.');
			}

		});
	}
	
function likeFunction(){
		
		
		// current mem_id fixed to 'guest'
		// it will be fixed by current user's id.
		
		$.ajax({
		
			url : 'epilogueLike',
			data : {'epilogueNo' : epilogueNo},	
			
			success : function(data){
				if (data==1) likeListFunction();
			},
			
			error : function(){
				alert('error')		
			}
		
		});
	}
	
	function likeListFunction(){
		
		$.ajax({
			
			url : 'likeListFunction',
			data : {'epilogueNo' : epilogueNo},
			
			success : function(data){
				
				var likeMember = "";
				
				$.each(data, function(key, value){
					
					likeMember += '<div class="likeMember" style="display:flex;">';
					likeMember += '<div class="member">';
					likeMember += '<p>' + value.mem_id + '</p>';
					likeMember += '</div></div>';
					
				});
				
				$('.likerList').html(likeMember);
				
			},
			
			error : function(){
				alert('error');
			}
			
		});
	}
	
	function commentDelete(epilogue_commentNo, mem_id) {

		$.ajax({

			url : 'getCurrentId',

			success : function(data) {
				if(data === mem_id){
					$.ajax({
						url : 'deleteComment',
						type : 'POST',
						data : {
							'epilogue_commentNo' : epilogue_commentNo,
							'mem_id' : mem_id
						},
	
						success : function(data) {
							if (data == 1){
								commentList(epilogueNo);
							
								var curCount = $('#commentCount').text();
								curCount = parseInt(curCount)-1;
								$('#commentCount').html(curCount);	
							}
							else {
								alert('삭제에 실패했습니다!');
							}
						}
					});
				}else{
					alert('남의 댓글을 삭제할 수 없어요!');
				}
			},
			
			error : function(){
				alert('댓글 삭제에 실패했습니다.');
			}
		})
	}

	$(document).ready(function() {
		commentList();
		likeListFunction();
	})
	
	
	
</script>

<br><br><br>

