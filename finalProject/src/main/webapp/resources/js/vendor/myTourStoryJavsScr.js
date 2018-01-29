/**
 * 
 */

$(document).ready(function(){
	$('#modalSearchIcon').click(function(){
		
		
		var searchPhase = JSON.stringify($('#wantSearch').val());
		$.ajax({
			
			url : 'ajaxSearchTest',
			type : 'GET',
			data : {"search" : searchPhase}, /*이걸로 parameter를 컨트롤러로 넘길 수 있다..*/
			
			success : function(msg){
				$('#modalbody').html(msg);
			},
			
			error : function(){
				alert('error');
			}
		});
		
	});
	
	/*$('#saveCourseBtn').click(function(){
		
		
		var epilogueNo = JSON.stringify($('#epilogueNo').val());
		var dday = JSON.stringify($('#dday').val());
		var location_num = JSON.stringify($('.selected input[type=hidden][name=location_num]').val());
		var content = JSON.stringify($('#epilContent').val());
		
		var formData = new FormData();
		
		formData.append('epilogueNo', epilogueNo);
		formData.append('dday', dday);
		formData.append('location_num', location_num);
		formData.append('content', content);
		formData.append('uploadFile', document.getElementById('atch_file').files[0]);
		
		$.ajax({
			url : 'writeEpilCourse',
			type : 'POST',
			data : formData,
			
			processData : false,
			contentType : false,
			
			success : function(msg){
				alert("코스저장이 완료되었습니다.");
				$('#searchBar').val("");
				$('#epilContent').val("");
				$('#atch_file').val("");
				$('#output').val("");
				$('#dday').val("");
				$('#wantSearch').val("");
				$('.sidebar-nav').html(msg);
			},
			
			error : function(){
				alert('error');
			}
			
		});
		
	});
	*/
	
	$('#previewModalBtn').click(function(){
		
		var epilogueNo = $('#epilogueNo').val();
		
		$.ajax({
			
			url : 'previewEpilogue',
			type:'GET',
			data : {'epilogueNo' : epilogueNo},
			
			success : function(content){
				
				$('#previewModalContent').html(content);
			},
			
			error:function(){
				alert('call preview content failed.');
			}
			
		});
		
	});
	
	$('#category_box a').each(function(){
		$(this).click(function(){
			
			var targetId = JSON.stringify($(this).attr('id'));

			var param = new Array();
			
			param.kind = targetId;
			
			$.ajax({
				
				url : 'viewEpilogueList',
				type : 'GET',
				data : {"kind" : targetId},
				
				success : function(result){
					$('#resultList').html(result);
				},
				
				error : function(){
					alert('error occurred');
				}
				
			});
			
		});
	});
	
	$('#resultList a').each(function(){
		$(this).click(function(){
			
			$(this).addClass("selectedList");
			
			var targetValue = JSON.stringify($(".selectedList input[type=hidden][name=selectedEpilNum]").val());
			
			$(this).siblings().removeClass("selectedList");
			
			
			
			$.ajax({
				
				url:'detailEpilView',
				type:'GET',
				data:{'selectedEpilogueNo' : targetValue},
				
				success:function(){
					
				},
				
				error:function(){
					
				}
				
			});
			
			
			
		});
	});
});
