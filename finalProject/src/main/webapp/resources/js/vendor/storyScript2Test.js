/**
 * 
 */

$(document).ready(function(){
	
	var fileRepository = new Array();
	
	$('#uploadImg').on('change', function(){
		
		fileRepository.push($('input[type=file]')[0].files[0]);
	
	});

	$('#saveCourseBtn').on('click', function(){
		
		var epilogueNo = JSON.stringify($('#epilogueNo').val());
		var location_name = JSON.stringify($('#searchText').val());
		var course_content = JSON.stringify($('#content').val());
		var dday = JSON.stringify($('#dday').val()); 
		
		if ($('#searchText').val() === ""){
			alert('여행지를 입력해주세요!');
			return false;
		}
		
		if ($('#content').val() === ""){
			alert('내용을 입력해주세요!')
			return false;
		}
		
		if ($('#dday').val() === ""){
			alert('날짜를 입력해주세요!!');
			return false;
		}
		
		var formData = new FormData();
		
		formData.append('epilogueNo', epilogueNo);
		formData.append('location_name', location_name);
		formData.append('course_content', course_content);
		formData.append('dday', dday);
		
		
		
		for (var i = 0; i < fileRepository.length; i++){
			formData.append('uploadFiles', fileRepository[i]);
		}
		
		$.ajax({
			
			type:'POST',
			url : 'writeEpilogueStep2Pro',
			data : formData,
			cache : false,
			contentType : false,
			processData : false,
			
			success: function(data){
				alert("코스저장");
				$('.resultContainer').html(data);
				
			},
			
			error : function(exception){
				alert('Exception : ' + exception);
			}
			
		});
		
		fileRepository = new Array();
		
	});
	
	
$('body').on("change", '#selectIndexes',function(){
		
		$('#epilogue_courseNo').val($('#selectIndexes option:selected').val());
		
		if($('#selectIndexes option:selected').val() == ""){
			$('#searchText').val('');
			$('#content').val('');
			$('#dday').val('');
			$('.imgs_wrap').empty();
			
			$('#updateCourseBtn').css('display', 'none');
			$('#saveCourseBtn').css('display', 'inline-block');
			
			
			return;
		}
		
		$.ajax({
			
			url : 'getDetailCourseInfo',
			type : 'GET',
			data : {'epilogueNo' : $('#epilogueNo').val(),
					'epilogue_courseNo' : $('#selectIndexes option:selected').val() },
			
			success : function(result){
				
				$('#searchText').val(result.where.location_name);
				$('#content').val(result.content);
				
				var html = '';
				if (result.img1 != null)
					html += '<img src="/project/resources/images/story/"+result.img1>';
				if (result.img2 != null)
					html += '<img src="/project/resources/images/story/"+result.img2>';
				if (result.img3 != null)		
					html += '<img src="/project/resources/images/story/"+result.img3>';
				if (result.img4 != null)
					html += '<img src="/project/resources/images/story/"+result.img4>';
				

				$('#updateCourseBtn').css('display', 'inline-block');
				$('#saveCourseBtn').css('display', 'none');
				
				
				$('#imgs_wrap').after(html);
				$('#dday').val(result.dday);
				
			},
			error : function(){
				alert('error sipal!!!');
			}
			
		});
	});
	
	$('#updateCourseBtn').on('click', function(){
		
		var formData = new FormData();
		
		formData.append('epilogue_courseNo', $('#epilogue_courseNo').val());
		formData.append('searchText', $('#searchText').val());
		formData.append('content', $('#content').val());
		formData.append('dday', $('#dday').val());
		
		for (var i = 0; i < repository.length; i++){
			formData.append('uploadUpdateFiles', repository[i]);
		}
		
		$.ajax({
			
			url:'updateCourseInfo',
			data : formData,
			type : 'POST',
			
			processData : false,
			contentType : false,
			
			success : function(result){
	
				if(result==true){
					alert('수정이 완료되었습니다.');
				}
				
			},
			
			error : function(){
				alert('error');
			}
		
		});
	});
})
