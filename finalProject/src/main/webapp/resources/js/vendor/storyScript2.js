/**
 * 
 */

$(document).ready(function(){
	
	
	var fileRepository = new Array();
	
	$('#uploadImg').on('change', function(){
		fileRepository.push(this.files[0]);
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
			
			url:'writeEpilogueStep2Pro',
			data : formData,
			type : 'POST',
			
			processData : false,
			contentType : false,
			
			success : function(result){
				$('#searchText').val("");
				$('#content').val("");
				$('#uploadImg').val("");
				$('#dday').val("");
				fileRepository = [];
				
				// Initialize for input type=file.
				document.getElementyById("uploadImg").select();
				document.selection.clear();
				
				$('.resultContainer').html(result);
			},
			
			error : function(){
				
				alert("코스저장에 실패했습니다.");
			}
			
		});
		
	});
	
//	
	var sel_files = [];
	
	$("#uploadImg").on("change", handleImgFileSelect);
	
	
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

	/*var repository = new Array();
	
	$('#uploadImg').on('change', function(){
		
		repository.push(this.files[0]);
	});
	*/
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
	
});

function fileUploadAction(){
	console.log("fileUploadAction");
	$("#uploadImg").trigger('click');
}

function handleImgFileSelect(e){
	
	sel_files=[];
	$(".imgs_wrap").empty();
	
	var files=e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	var index = 0;
	filesArr.forEach(function(f){
		if(!f.type.match("image.*")){
			alert("확장자는 이미지 확장자만 가능합니다..가 무슨 말이에요?");
			return;
		}
		
		sel_files.push(f);
		
		var reader = new FileReader();
		reader.onload=function(e){
			var html="<a href=\"javascript:void(0);\" onclick=\"deleteImageAction("+index+")\" id=\"img_id_"+index+"\"><img src=\""+e.target.result+"\" data-file'"+f.name+"' class='selProductFile' title='Click to remove'></a>";
			$(".imgs_wrap").append(html);
			index++;
		}
		
		reader.readAsDataURL(f);
	});
}

function deleteImageAction(index){
	console.log("index : " + index);
	sel_files.splice(index, 1);
	
	var img_id = "#uploadImg" + index;
	$(img_id).remove();
	
	console.log(sel_files);
}

function step2Focus(){
	
}

function checkStep2(){
	
	if (document.getElementById('searchText').val() == null){
		alert('여행지를 입력해주세요!');
		document.getElementById('searchText').focus();
		return false;
	}
	
	if (document.getElementById('context').val() == null){
		alert('코스에 대한 이야기를 써주세요!');
		document.getElementById('context').focus();
		return false;
	}
	
	if (document.getElementById('dday').val() == null){
		alert('다녀온 일자를 알려주세요!');
		document.getElementById('dday').focus();
		return false;
	}
}