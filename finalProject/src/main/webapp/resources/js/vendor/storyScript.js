/**
 * 
 */

// writeEpilogueStep1. 
// Start
$(document).ready(function(){
	$('#nDomestic').on('click', function(){
		
		var src=($(this).attr('src') === '/project/resources/images/support/domestic.png')
					? '/project/resources/images/support/selected_domesticType.png'
				    : '/project/resources/images/support/domestic.png';
		
		$(this).attr('src', src);
		$('#nAbroad').attr('src', '/project/resources/images/support/abroad.png');
		$('#isDomestic').val('Y');
		
		if ($('#nDomestic').attr('src') === '/project/resources/images/support/domestic.png'){
			$('#isDomestic').val('');
		}
		
	});
	
	$('#nAbroad').on('click', function(){
		
		var src = ($(this).attr('src') === '/project/resources/images/support/abroad.png')
				  ? '/project/resources/images/support/selectAbroad.png'
				  : '/project/resources/images/support/abroad.png';
		
		$(this).attr('src', src);
		$('#nDomestic').attr('src', '/project/resources/images/support/domestic.png');
		$('#isDomestic').val('N');
		
		if ($('#nAbroad').attr('src') === '/project/resources/images/support/abroad.png'){
			$('#isDomestic').val('');
		}
	});
	
})

function checkFirstStep(){
	
	if (document.getElementById('tour_title').value == ""){
		alert('제목을 입력해주세요.');
		document.getElementById('tour_title').focus();
		return false;
	}
	
	if (document.getElementById('isDomestic').value == ""){
		alert('여행기 타입을 선택해주세요.');
		return false;
	}
}

function titleFocus(){
	
	document.getElementById('tour_title').focus();
	
}

//End

// writeEpilogueStep2
// START