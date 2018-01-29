// Common.js
$(document).ready(function(){

	
	$("#topbtn").hide();
	
	$(function() {
		
		$(window).scroll(function () 
		{
			if ($(this).scrollTop() > 100) {
				$('#topbtn').fadeIn();
			} else {
				$('#topbtn').fadeOut();
			}
		});
		
		$('#btn_top').click(function(){
			$('body,html').animate({scrollTop: 0}, 300);
			return false;
		});
		
		var pos_cmmt = $('#sty_btm').offset();
		
		$('#btn_cmmt').click(function(){
			$('body,html').animate({scrollTop: pos_cmmt.top - 40}, 300);
			return false;
		});
		
	});
	
	//濡쒓렇�몃맂 �ъ슜��
	$('#id_view_logined').click(function(e){
		
		e.preventDefault();
		
		//�뚮┝ 由ъ뀑
		$("#id_lognd_alrim_layer").hide();
		$("#id_view_alrm").removeClass("selected");
		$(this).removeClass("selected");
		
		//�곌린 �앹뾽�� �덉쓣寃쎌슦 �リ린
		$("#write_mask").hide();	
		$("#write_pop").hide();
		
		if($('#id_lognd_layer').css("display") == "none")
		{
			$('#id_lognd_layer').show();
			$('.h_util .c_cmm_logind a').css("background", "url(/web/img/comm/login_id_close.png) no-repeat right");
			
			isEventCheck = true;
			
			$('#wrapper').click(function(){
				
				if( isEventCheck == false )
				{
					$('#wrapper').unbind("click");
					if($('#id_lognd_layer').css("display") != "none")
					{
						$('#id_lognd_layer').hide();
						$('.h_util .c_cmm_logind a').css("background", "url(/web/img/comm/login_id_open.png) no-repeat right");
					}
				}
				isEventCheck = false;
			});
		}
		else
		{
			$('#wrapper').unbind("click");
			$('#id_lognd_layer').hide();
			$('.h_util .c_cmm_logind a').css("background", "url(/web/img/comm/login_id_open.png) no-repeat right");
		}	
	});
	
	//濡쒓렇�몃맂 �ъ슜�� �뚮┝
	$('#id_view_alrm').click(function(e){
		
		e.preventDefault();
		$('#id_lognd_layer').hide();
		
		//�곌린 �앹뾽�� �덉쓣寃쎌슦 �リ린
		$("#write_mask").hide();	
		$("#write_pop").hide();
		
		if($(this).hasClass("selected")){
			$(this).removeClass("selected");
			$("#id_lognd_alrim_layer").hide();
		}else{
			$(this).addClass("selected");
			
			$("#id_lognd_alrim_layer").show();
			
			//�댁븘�댁퐯 �④�
			$("#alrm_new").hide();
			
			//�뚮┝遺덈윭�ㅺ린
			getListAlrm();
		}
	});
	
	$("#alrim_close").click(function(){
		$("#alr_list").empty();
		$('#id_lognd_alrim_layer').hide();
		$('#id_view_alrm').removeClass("selected");
	});
	
	
	$("#temp_list_close").click(function(){
		$("#temp_list_pop").fadeOut();
	});
	
	
	$("#temp_delete").click(function(){
		if(!confirm("�꾩껜 紐⑸줉�� ��젣�섏떆寃좎뒿�덇퉴?"))
			return;
		fn_delete_temp_all();
	});
});


/*�뚮┝由ъ뒪��*/
function getListAlrm(){
	
	$.ajax({
		type:"POST",
		url:"/alrim_list.tlg",
		data:{},
		success:function(ajaxData){
			$("#alr_list").empty();
			$("#alr_list").append(ajaxData);
			
			//�뚮┝�놁쓣��
			var li_size = parseInt($("#alr_list").children().length);
			if(li_size == 0){
				var no_alrim = "<div class='alr_nolist'><div></div></div>";
				$("#alr_list").append(no_alrim);
			}
		},
		error:function(msg){
			
		}
	});
}

var isEventCheck = false;

function openLogin()
{
	$('#btn_cmm_login').trigger('click');
}

function fnOpenLogin()
{
	$('#btn_cmm_login').trigger('click');
}

/**
 * �곌린 �앹뾽
 */
function openWrite()
{
	$("#id_lognd_alrim_layer").hide();
	$("#id_view_alrm").removeClass("selected");
	$("#write_mask").fadeIn();
	$("#write_pop").fadeIn();
}

function closeWirte()
{
	$("#write_mask").fadeOut();
	$("#write_pop").fadeOut();
}

//�꾩떆 ���� 紐⑸줉 �앹뾽
function openTmpTlogList(){
	$("#id_lognd_alrim_layer").hide();
	$("#id_view_alrm").removeClass("selected");
	$.ajax({
		type:"POST",
		url: "/web/story_editing_list.tlg",
		success:function(ajaxData){
			$("#temp_list_con").empty();
			$("#temp_list_con").append($(ajaxData));
			setDeleteEventSet();
			$("#temp_list_pop").fadeIn();
		},
		error:function(msg){
			alert(msg.text());
		} 
	});
	
}
//�꾩떆���λぉ濡� �リ린
function closeTmpTlogList(){
	$("#temp_list_pop").fadeOut();
}

//�꾩떆���� 紐⑸줉�먯꽌 ��젣踰꾪듉 ( 媛쒕퀎��젣 )
function setDeleteEventSet(){
	$(".temp_data_delete").click(function(){
		if(!confirm("��젣�섏떆寃좎뒿�덇퉴?"))
			return;
		fn_delete_temp($(this).attr("del_tm_no"));
	});
}

//�꾩떆���� 湲� ��젣
function fn_delete_temp(tm_no){
	$.ajax({
		type:"POST",
		url: "/web/delete_tlog_editing.tlg",
		data:{"tm_no":tm_no},
		success:function(ajaxData){
			$("#temp_list_con").empty();
			$("#temp_list_con").append($(ajaxData));
			$("#temp_list_pop").show();
			setDeleteEventSet();
		},
		error:function(msg){
			alert(msg.text());
		} 
	});
}

//�꾩떆 ���� 湲� �꾩껜 ��젣
function fn_delete_temp_all(){
	$.ajax({
		type:"POST",
		url: "/web/delete_tlog_editing.tlg",
		data:{"tm_no":"ALL"},
		success:function(ajaxData){
			$("#temp_list_con").empty();
			$("#temp_list_con").append($(ajaxData));
			$("#temp_list_pop").show();
				setDeleteEventSet();
		},
		error:function(msg){
			alert(msg.text());
		} 
	});
}

//�묒꽦以묒씤 �ы뻾湲� �섏젙�섎윭 �ㅽ뀦1濡� 媛�湲�
function select_tlog_mst(tm_no, sty_dv)
{
	if(sty_dv =='TL')
		window.open("/web/step1.tlg?tm_no="+tm_no, "_top");
	else if(sty_dv =='ES')
		window.open("/web/tessay_wrt.tlg?no="+tm_no, "_top");
	else 
		window.open("/web/restr_step1.tlg?tm_no="+tm_no, "_top");
}

//�대�吏� URL
function getFullPath( url ){
	return "https://img.tnote.kr"+url;
}

/**
 * toHtml
 */
function toHtml(value, conts){
	var result = value.replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/\n/g,'<br/>');
	conts.html(result);
}

/*�덈뱶濡쒖씠�� /�꾩씠�곗쑝濡� �대룞*/
function gotoAndroid(){
	window.open('https://play.google.com/store/apps/details?id=com.doresoft.tournote', '_blank');
	return false;
}


function gotoIphone(){
	window.open('https://itunes.apple.com/kr/app/id600750084?mt=8', '_blank');
	return false;
}

/**
 * �댁빞湲� �곸꽭�섏씠吏�濡� �대룞
 * @param tm_no
 */
function fn_CmmGoToStoryDetail(tm_no)
{
	window.open(fn_CmmStoryURL(tm_no), '_top');
}

/**
 * �댁빞湲� �곸꽭�섏씠吏� URL
 * @param tm_no
 */
function fn_CmmStoryURL(tm_no)
{
	return '/story/' + Number(tm_no.substring(1));
}


/**
 * �μ냼 �곸꽭�섏씠吏�濡� �대룞
 * @param tp_no
 */
function fn_CmmGoToPlaceDetail(tp_no)
{
	window.open(fn_CmmPlaceURL(tp_no), '_top');
}


/**
 * �μ냼 �곸꽭�섏씠吏� URL
 * @param tp_no
 */
function fn_CmmPlaceURL(tp_no)
{
	return '/place/' + Number(tp_no.substring(1));
}

/**
 * �꾩떆 �곸꽭�섏씠吏�濡� �대룞
 * @param ct_no
 */
function fn_CmmGoToCityDetail(ct_no)
{
	window.open(fn_CmmCityURL(ct_no), '_top');
}


/**
 * �꾩떆 �곸꽭�섏씠吏� URL
 * @param tp_no
 */
function fn_CmmCityURL(ct_no)
{
	return '/city/' + Number(ct_no.substring(1));
}