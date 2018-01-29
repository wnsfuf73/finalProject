/**
 * 
 */

$(document).ready(function(){
	
	
	$('#storeEpilogueBtn').on('click', function(){

		if($('#epilogue').val() == null){
			alert('에필로그를 작성해주세요..');
			document.getElementById('epilogue').focus();
			return false;
		}
		
		$.ajax({
			url : 'writeEpilogueStep3Pro',
			type : 'POST',
			data : {'epilogueNo' : $('#epilogueNo').val(),
					 'epilogue' : $('#epilogue').val(),
					 'security' : $(':input[name="privarcyRadio"]:checked').val()
				   } ,
			
			success : function(data){
				alert('글 작성에 성공했습니다!');
				alert('메인페이지로 이동합니다.');
				window.location='main';
			},
			
			error : function(){
				alert('글 작성에 실패했습니다..');
			}
			
		});	
	});
	
	
	$('#selectedEpilNum').on(function(){
		
		$.ajax({
			
			url : 'getNumLikeAndCmt',
			type : 'GET',
			data : {'epilogueNo' : $('#epilNum').val()},
			
			success : function(data){
				
				html = '';
				
				html += '<p>좋아요  '; 
				html += data.numOfLike; 
				html += '   댓글  ' ;
				html += data.numOfCmt;
				html += '</p>';
				
				$('#otherPart').html(html);
			},
			
			error : function(){
				alert('fail');
			}
			
		});
		
	});
	
	$('#category_box a').each(function(){
		$(this).click(function(){
			$.ajax({
				
				url : 'viewEpilogueList',
				type : 'GET',
				data : {"kind" : $(this).attr('id')},
				
				success : function(result){
					$('#resultList').html(result);
				},
				
				error : function(){
					alert('error occurred');
				}
				
			});
			
		});
	});
	
	$('#requestSearchBtn').on('click', function(){
		
		$.ajax({
			
			url : 'requestSearchEpilogue',
			type : 'GET',
			data : {
				'searchPhrase' : JSON.stringify($('#searchPhrase').val()),
				'searchKind' : JSON.stringify($(':input:radio[name=searchKind]:checked').val())
			},
			
			success : function(result){
				$('#resultList').html(result);
			},
			
			error : function(){
				alert('error');
			}
			
		});
		
	});
	
	$('#openWrite').click(function(){
		
		$('#write_mask').css("display", "block");
		$('#write_pop').css("display", "block");
		
	});
	
	$('#closeWrite').click(function(){
		$('#write_mask').css("display", "none");
		$('#write_pop').css("display", "none");
	});
	
})
