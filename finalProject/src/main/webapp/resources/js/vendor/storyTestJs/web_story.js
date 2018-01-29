/**
 * 
 */

/* web/story.js */

$(document).ready(function(){
	
	//�댁쟾踰꾪듉�쇰줈 �명븳 �щ줈�� 泥섎━ 留됱쓬
	/*if( $('#check_init_load').val() != "")
		return;

	$('#check_init_load').val("YES");*/

	openWindow = true;
	
	noListView = true;
	noListMsg = "寃��됰맂 寃곌낵媛� �놁뒿�덈떎";
	
	if("" == $("#city_no").val())	//�섎씪 �좏깮�� �놁쓣�뚮뒗 �섏씠吏뺣쭔 泥섎━
		fn_go_to_page("", $("#page_no").val());
	
	if("undefined" != typeof $("#sel_city").attr("data-area_div"))
	{
		var area_div = $("#sel_city").attr("data-area_div");
		getAreaList(area_div);
	}
	
	var isClick = false;
	var srch_box = $("#srch_box");
	
	$("#all_menu").click(function(){
		
		if(isClick == false)
		{
			$(this).addClass('all_menu_over');
			isClick = true;
			srch_box.css("visibility", 'visible');
		}
		else
		{ 
			$(this).removeClass('all_menu_over');
			isClick = false;
			srch_box.css("visibility", 'hidden');
		}
	});
	
	$("#srch_btn").click(function(){
		$("#frm_srch").submit();
	});
	
	/*$(window).scroll(function(){
		
		var documentHeight = $(document).height();
		var windowHeight = $(this).height();
		var scrollTop = $(this).scrollTop();
		
		if(documentHeight-windowHeight-scrollTop<50) {
			getList();
		}
	});*/
	
});

function getAreaList(area_div){
	
	$.ajax({
		type:"POST",
		url: "/story/tlog_nation_list.tlg",
		data: {"p_frgn_dv" : area_div},
		success:function(ajaxData){
			
			$("#sel_city").empty();
			$("#sel_city").append("<option value=''>�꾩껜</option>");
			$("#sel_city").append($(ajaxData));
			
			$("#sel_city").change(function(){
				setNationList(1);
			});
			
			if("" != $("#city_no").val()){
				var city_val = $("#city_no").val();
				$("#sel_city").attr("value", city_val);
				setNationList($("#page_no").val());
			}
			
		},
		error:function(msg){
			
		}
	});
}

/**
 * �섎씪 �좏깮�� �≪뀡
 */
function setNationList(page_no)
{
	var ct_no = $("#sel_city").val();
	
	$("#city_no").val(ct_no);
	
	var ct_nm = $("#sel_city option:selected").text();
	var title_tt = ($(".t_srch").text()).split("-")[0];
	if("�꾩껜" != ct_nm) title_tt = title_tt + "-" + ct_nm;
	$(".t_srch").text(title_tt);
		
	var feedData = $("#feed_list").attr("data-feedData");
	feedData = feedData.split("na_cd=")[0];
	feedData = feedData + "na_cd=" + ct_no;
	
	$("#con_list").empty();
	isLast = "NO";
	$("#feed_list").attr("data-feedPage", page_no);
	$("#feed_list").css("display", "block");
	$("#feed_list").attr("data-feedData", feedData);

	getList();
}

/**
 * �섏씠吏� �대룞
 */
function fn_go_to_page(value, page_no)
{
	$("#con_list").css("height", "inherit");
	$("#page_no").val(page_no);
	
	isLast = "NO";
	$("#con_list").empty();
	$("#feed_list").attr("data-feedPage", page_no);
	getList();
	
	$('body,html').scrollTop(0);
}
