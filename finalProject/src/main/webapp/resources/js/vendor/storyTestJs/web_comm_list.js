/**
 * 
 */

//由ъ뒪�� 媛��몄삤湲� ajax
var flag = true;	//以묐났 �ъ슜�섏� �딄린 �꾪빐��..
var isLast = "NO";
var isfeedCheck = false;
var isMyHome = false;
var noListView = false;
var noListMsg = "";
var currentTab = "";
var useMsnry = true;
var openWindow = false;

function getList()
{
	if(isLast == "YES") return false;
	
	var feedBT = "#feed_list";
	var feedURL = $(feedBT).attr("data-feedURL");
	var feedPage = parseInt($(feedBT).attr("data-feedPage"));
	var feedTargetDiv = "#con_list";
	var ajaxLoading = "<img src='/web/img/comm/loading.gif'/>";
	var txtMoreFeed = $(feedBT).html();

	var dataObj = {};
	
	dataObj['page_no'] = feedPage;
	
	//�섎㉧吏� Data
	var feedData = $(feedBT).attr("data-feedData");
	var dataArray = feedData.split("&");

	for(var i = 0; i < dataArray.length; i++)
	{
		var data = dataArray[i];
		var arry = data.split("=");
		
		var data_name = arry[0];
		var data_value = arry[1];
		
		dataObj[data_name] = data_value;
	}
	
	$(feedBT).empty();
	$(feedBT).append(ajaxLoading);
	if(flag){
		
		flag = false;
		
		$.ajax({
			type:"POST",
			url: feedURL,
			data: dataObj,
			success:function(ajaxData){
				//var result = $(ajaxData).filter("result");
				//var result = ajaxData;
				
				isLast = $(ajaxData).filter("#hid_ajax_is_last").attr("value");
				
				//$(feedTargetDiv).append($(ajaxData).hide().fadeIn(2000));
				//$(feedTargetDiv).append($(ajaxData).css("opacity", 0));
				var item = $(ajaxData).hide().fadeIn(1000);
				$(feedTargetDiv).append(item);
				
				if (isLast == "YES"){
					//$(feedBT).remove();
					$(feedBT).css("display", "none");
					
					//�덉뿉 異붿쿇�� �꾪빐�� �덉씪�뚮쭔 泥댄겕
					if(isfeedCheck && $(feedBT).attr("data-feedPage") == "1"){
						var child_size = parseInt($(feedTargetDiv).children().length);
						if(child_size <= 1) {
							setRecmmd();
						}
					}
				}
				else
				{
					$(feedBT).attr("data-feedPage", (feedPage+1));
					$(feedBT).empty();
					$(feedBT).append(txtMoreFeed);
				}
				
				if(currentTab == "Feed"){
					
					if(parseInt($(feedTargetDiv).children().length) > 2)
						$("#list_recmmd").empty();
					else{
						$("#list_recmmd").css("display", "block");
						flag = true;
						return;
					}
				}
					
				
				// 移대뱶(醫뗭븘��)
				$(".con_list .card .cover").hide();

				$(".con_list .card").unbind("mouseenter");
				$(".con_list .card").unbind("mouseleave");
				
				$(".con_list .card").mouseenter(function(){
					if(currentTab == "Scrap"){
						var height = ($(this).children().children(".cover").height() - 50) / 2;
						$(this).children().children(".cover").children().children().css("top", height);
					}
					
					$(this).find(".cover").fadeIn(200);
				});
				
				$(".con_list .card").mouseleave(function(){
					$(this).find(".cover").fadeOut(200);
				});
				
				
				/**
				 * �댁뿬�됯린 �쇰븣留�
				 */
				if(isMyHome)
				{
					//�댁뿬�됯린�쇰븣 
					if("MyStory" == currentTab || "Essay" == currentTab)
					{
						$(".con_list .sty_btns").css("display", "block");
						
						$(".con_list .sty_btns .sty_modify").click(function(){	//�섏젙
							modifyStory($(this).parent());
							return false;
						});
						
						$(".con_list .sty_btns .sty_delete").click(function(){	//��젣
							deleteStory($(this).parent());
							return false;
						});
						
						$(".con_list .user").css("display", "none");
					}
					
					$(".review_cover .btns .btn_modify").unbind("click");
					$(".review_cover .btns .review_delete").unbind("click");
					
					//由щ럭�곌린
					if("Review" == currentTab)
					{
						$(".review_cover .btn_modify").css("display", "block");
						
						$(".review_cover .btns .review_modify").click(function(){
							location.href = "/web/review_info.tlg?tl_no=" + $(this).parent().attr("data_tl_no");
							return false;
						});
						
						$(".review_cover .btns .review_delete").click(function(){
							deleteReview($(".review_cover .btn_modify").attr("data_tl_no"));
							return false;
						});
					}
					
					$(".con_list .card .grup_modify").unbind("click");
					$(".con_list .card .grup_delete").unbind("click");
					
					//蹂닿��⑥씪�� (�댁빞湲�)
					if("Scrap" == currentTab)
					{
						$(".con_list .card .cover_btn").css("display", "block");
						
						$(".con_list .card .grup_modify").click(function(){	//蹂닿��⑥씠��

							scrapGrupList($(this).parent());
							return false;
						});
						
						$(".con_list .card .grup_delete").click(function(){	//��젣
							

							if("TL" == sc_gr_dv)
								deleteScrapSty($(this).parent());
							else if("TP" == sc_gr_dv)	
								deleteScrapPlc($(this).parent());
						
							return false;
						});
					}
				}
				
				if("MyStory" == currentTab) $(".con_list .user").css("display", "none");
				
				//由щ럭�곌린
				if("Review" == currentTab)
				{
					$(".review_cont .con li a").unbind("click");
					
					$(".review_cont .con li a").click(function(){
						setImgView($(this));
					});
					
					$(".review_cont .help").unbind("click");
					
					$(".review_cont .help").click(function(){
						helpReview($(this));
					});
				}
				
				//NOList
				if(noListView){
					
					var list_size = $(feedTargetDiv).children().length;
					
					if(list_size < 2){
						
						var noList = "<div class='no_list'><div class='" + currentTab + "'></div><span>" + noListMsg + "</span></div>";
						$(feedTargetDiv).append(noList);
						
						flag = true;
						return;
					}
				}
				
				
				if(useMsnry){
					
					// �ㅽ겕濡� to �쇰뱶 紐⑥뼱 ~ �댁젣 �섍쾶
					var container = document.querySelector('#con_list');
					var msnry = new Masonry( container, {
					  // options
					  columnWidth: 200,
					  itemSelector: '.item'
					});
					msnry.layout();
					
					$("img").load(function() {
						
						var container = document.querySelector('#con_list');
						var msnry = new Masonry( container, {
						  // options
						  columnWidth: 200,
						  itemSelector: '.item'
						});
						msnry.layout();
									
					});
				}
				
				$(".item a[data-url]").unbind("click");
				$(".item a[data-url]").click(function(){
					var url = $(this).attr("data-url");
					//window.location = url;
					window.open(url, '_top');
					return false;
				});
				
				$(".user img[data-url]").unbind("click");
				$(".user img[data-url]").click(function(){
					var url = $(this).attr("data-url");
					//window.location = url;
					window.open(url, '_top');
					return false;
				});
				
				//$(feedTargetDiv + ">div").animate({"opacity" : 1}, 1000);
				
				flag = true;
			},
			error:function(msg){
				
				var result = $(msg).find("resultCode").text();
				
				if("Rcmmd" == currentTab){
					
					if("ERROR.2" == result){
						alert("�쒖뒪�� 以�鍮꾩쨷");
					}else{
						var noList = "<div class='no_list'><div class='" + currentTab + "'></div><span>" + noListMsg + "</span></div>";
						$(feedTargetDiv).append(noList);
						$(feedTargetDiv).css("height", "inherit");
						$(feedBT).empty();
					}
					isLast = "YES";
				}
				flag = true;
			} 
		});
	}
}