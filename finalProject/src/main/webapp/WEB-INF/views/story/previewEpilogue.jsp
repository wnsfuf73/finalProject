<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="..\setting.jsp"%>

<c:if test="${listOfEpil != null }">
	<div class="modal-header"
		style="width: 790px; background-color: #fff; border-radius: 5px; border: 1px solid #E5E3E0; float: left;">
		<div class="modal-title-container">
			<div class="sty_cover">
				<input type="hidden" id="user_id" value="${listOfEpil[0].mem_id}">
				<input type="hidden" id="user_num" value=""> <input
					type="hidden" id="user_img" value="${listOfEpil[0].member.faceImg}">
				<div class="sty_top" style="height: 124px;">
					<div class="info_left"
						style="display: inline-block; width: 442px; margin: 24px 0 24px 24px;">
						<div class="title"
							style="font-size: 16px; color: #0088f0; font-weight: bold;">${listOfEpil[0].title}</div>
						<div class="date" style="font-size: 12px; color: #bcc4c4;"><fmt:formatDate value="${listOfEpil[0].reg_date}" pattern="yyyy-MM-dd"/></div>
						<div class="user" style="margin-top: 9px;">
							<a href="" target="_top" style=""> <img alt="willbeattach"
								style="width: 32px; height: 32px; border-radius: 4px; display: inline-block; float: left; vertical-align: middle; border: 0 none;">
							</a>
							<div class="huser_id"
								style="display: inline-block; height: 30px; margin-left: 5px;">
								<span
									style="font-size: 12px; display: block; font-style: italic; color:">travler</span>
								<span class="name"
									style="color: #343434; font-weight: bold; font-style: normal; display: block; font-size: 12px;">${listOfEpil[0].member.mem_id}</span>
							</div>
						</div>
					</div>
					<div class="info_right"
						style="display: inline-block; float: right; margin: 24px 22px 0 0;">

					</div>
				</div>
			</div>
		</div>
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<div id="priviewModalBody" class="modal-body">
		<c:forEach var="list" items="${listOfEpil}">
			<c:forEach var="epil" items="${list.courses}" varStatus="stauts">
			<div class="sty_course"
				style="border-top: 1px solid #e2e2e2; margin-top: 7px; position: relative">
				<div class="title"
					style="height: 29px; line-height: 29px; font-weight: bold; padding-left: 10px; border-bottom: 1px solid #e2e2e2;">
					<span class="tt_course" style="float: left;">여행코스</span> <span
						class="date"
						style="font-size: 12px; color: #bcc4c4; font-weight: normal; margin-left: 5px; float: left;"></span>
					<fmt:formatDate value="${epil.dday}" pattern="yyyy-MM-dd" />
				</div>
				<div style="clear: both"></div>
				<div class="course_con"
					style="padding: 35px 35px 17px 35px; background: url('/project/resources/images/story/c_course_bg_patten.png'); overflow: hidden;">
					<ul class="course" id="id_top_info_course" data_frgn="false"
						style="display: block; -webkit-margin-before: 1em; -webkit-margin-after: 1em; -webkit-margin-start: 0px; -webkit-margin-end: 0px; -webkit-padding-start: 40px;">
						<li class="left c_start" num="-1" title="start"
							style="background: url('/project/resources/images/story/c_start.png') no-repeat; float: left; width: 120px; height: 80px; cursor: pointer; postion: relative;"></li>
						<li class="left c_mid" num="0" title="test"
							style="background: url('/project/resources/images/story/c_mid.png') no-repeat; float: left; width: 120px; height: 80px; cursor: pointer; postion: relative;">
							<span>${epil.where.location_name}</span>
						</li>
						<li class="left c_end_l" num="1" title="end"
							style="background: url('/project/resources/images/story/c_end_l.png') no-repeat; float: left; width: 120px; height: 80px; cursor: pointer; postion: relative;"></li>
					</ul>
				</div>
			</div>
			<div class="sty_con"
				style="float: left; width: 792px; border-top: 1px solid #e2e2e2;">
				<div class="sty_cont"
					style="position: relative; width: 100%; float: left">
					<div class="sty_list"
						style="width: 561px; float: left; border-right: 1px solid #e2e2e2; padding-bottom: 10px;">
						여행지 정보
						<div class="sty_conts"
							style="border-bottom: none; padding-left: 10px; padding-right: 10px; position: relative">
							<a class="qcourse_0" name="qcourse_0"
								style="postion: absolute; top: -40px;"></a>
							<div class="sty_info">
								<div class="sty_plc" dv_map_view="0" vw_no="1"
									style="background: url('/project/resources/images/story/c_bg_place.png') no-repeat; float: left; padding: 5px; margin-top: 15px;">
									<a href="#"
										style="width: 530px; display: block; float: left; position: relative;">
										<img class="img_cate"
										src="/project/resources/images/story/c00801.png"
										style="width: 50px; height: 50px; display: inline-block; float: left; vertical-align: middle; border: 0 none;">
										<div class="plc_info"
											style="display: inline-block; margin-left: 10px; width: 345px; float: left;">
											<span class="plc_nm"
												style="color: #4fc316; font-weight: bold; margin-top: 8px; font-size: 16px; line-height: 18px; display: block;">${epil.where.location_name}</span>
											<span class="plc_addr"
												style="display: inline-block; color: #6e6e6e; font-size: 12px;">
												${epil.where.location_addr}</span>
										</div>
										<div class="plc_num"
											style="display: inline-block; float: left; margin-top: 7px;">
											<div class="plc_flag"
												style="width: 15px; height: 15px; display: inline-block; background: url('/project/resources/images/story/c_ico_point.png') no-repeat; float: left; margin-top: 2px;"></div>
											<span class="plc_addr"
												style="display: inline-block; float: left; margin-left: 6px; color: #ff7800; font-size: 12px;">${epil.visit_order}지점</span>
											<!-- epilogue_course - visit_order에서 따올수있다. -->
										</div>
										<div class="plc_here"
											style="width: 41px; height: 48px; display: inline-block; background: url('/project/resources/images/story/c_ico_hrer.png') no-repeat; float: right; text-indent: -10000px; margin-right: 4px;">

										</div>
									</a>
								</div>
								<div class="sty_cont"
									style="clear: both; padding-top: 18px; padding-bottom: 20px; width: 520px; padding: 15px 10px 20px 10px; line-height: 22px; position: relative; float: left;">${epil.content}</div>
								<!-- epilogue-content. -->
							</div>
							<a name="qcourse_0"></a>
							<div class="cont_btm"
								style="font-size: 12px; padding-top: 3px; padding-bottom: 7px; clear: both;">
								<span class="btm_date" style="color: #acacac;"><fmt:formatDate
										value="${listOfEpil[0].reg_date }" pattern="yyyy-MM-dd" /></span>
							</div>
						</div>
						<!-- 에필로그 -->
					</div>
					<div class="sty_right" id="sty_right"
						style="float: left; width: 215px; background-color: #fff; margin-right: 8px;">
						<div class="view_map"
							style="font-size: 11px; margin-top: 11px; margin-bottom: 7px; margin-right: 11px; text-align: right;">
							<a id="detail_map"
								style="display: inline-block; width: 74px; height: 16px; background: url('/project/resources/images/story/c_font_4_map_open.png') no-repeat;">
							</a>
						</div>
						<div id="trace_no_map" class="trace_no_map"
							style="width: 208px; height: 200px; background: url('/project/resources/images/story/c_un_map.png') no-repeat; postion: absolute; margin-left: 4px; z-index: 1;">
						</div>
						<div id="trace_map" class="trace_map"
							style="height: 200px; background-color: #fff; margin-left: 10px; margin-right: 10px; margin-bottom: 10px;"></div>
						<div id="trace_cont" class="trace_cont" style="margin: 10px;">
							<ul id="trace_list" class="trace_list">
								<li class="point"
									style="display: list-item; text-align: -webkit-match-parent">
									<div class="cont_top" style="display: none;">
										<span class="trace_num"
											style="color: #ff7800; font-weight: bold;">${epil.visit_order}지점</span>
										<span class="trace_date"
											style="font-size: 11px; float: right; color: #acacac;">${epil.dday}</span>
									</div>
									<div class="cont_mid" style="margin-top: 5px">
										<div class="icon"
											style="width: 18px; height: 20px; display: inline-block; float: left; background: url('/project/resources/images/story/c_ico_here_map.png') no-repeat;"></div>
										<div class="cont_con"
											style="display: inline-block; margin-left: 5px; width: 185px;">
											<div class="tp_nm"
												style="color: #48be17; font-weight: bold; font-size: 16px;">${epil.where.location_name}</div>
											<div class="tp_addr" style="font-size: 12px; color: #6e6e6e;">${epil.where.location_addr}</div>
											<div class="lat" style="display: none;">${epil.where.x_coordinate }</div>
											<div class="lon" style="display: none;">${epil.where.y_coordinate }</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					</div>
					</div>
				</c:forEach>
		</c:forEach>
	</div>
	<div class="sty_btom" style="clear: both;"></div>
	<a id="abc"></a>
</c:if>
<c:if test="${listOfEpil == null }">
	
	<div class="modal-header"
		style="width: 790px; background-color: #fff; border-radius: 5px; border: 1px solid #E5E3E0; float: left;">
		<div class="modal-title-container">
			<div class="sty_cover">
				<input type="hidden" id="user_id" value=""> <input
					type="hidden" id="user_num" value=""> <input type="hidden"
					id="user_img" value=""> master info
				<div class="sty_top" style="height: 124px;">
					<div class="info_left"
						style="display: inline-block; width: 442px; margin: 24px 0 24px 24px;">
						<div class="title"
							style="font-size: 16px; color: #0088f0; font-weight: bold;">title</div>
						db에서 epilogue title 가져오기
						<div class="date" style="font-size: 12px; color: #bcc4c4;">date</div>
						<div class="user" style="margin-top: 9px;">
							<a href="" target="_top" style=""> <img alt="willbeattach"
								style="width: 32px; height: 32px; border-radius: 4px; display: inline-block; float: left; vertical-align: middle; border: 0 none;">
							</a>
							<div class="huser_id"
								style="display: inline-block; height: 30px; margin-left: 5px;">
								<span
									style="font-size: 12px; display: block; font-style: italic; color:">travler</span>
								<span class="name"
									style="color: #343434; font-weight: bold; font-style: normal; display: block; font-size: 12px;">username</span>
								member db에서 유저네임 가져오기
							</div>
						</div>
					</div>
					<div class="info_right"
						style="display: inline-block; float: right; margin: 24px 22px 0 0;">

					</div>
				</div>
			</div>
		</div>
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<div id="priviewModalBody" class="modal-body">
		db에서 epilogue_course에 관한 것들 가져오기. 아마 c:foreach 써야겠지
		<div class="sty_course"
			style="border-top: 1px solid #e2e2e2; margin-top: 7px; position: relative">
			<div class="title"
				style="height: 29px; line-height: 29px; font-weight: bold; padding-left: 10px; border-bottom: 1px solid #e2e2e2;">
				<span class="tt_course" style="float: left;">여행코스</span> <span
					class="date"
					style="font-size: 12px; color: #bcc4c4; font-weight: normal; margin-left: 5px; float: left;"></span>
				epilogue_course 에 dday에 있는 정보 가져올것
			</div>
			<div style="clear: both"></div>
			<div class="course_con"
				style="padding: 35px 35px 17px 35px; background: url('/project/resources/images/story/c_course_bg_patten.png'); overflow: hidden;">
				<ul class="course" id="id_top_info_course" data_frgn="false"
					style="display: block; -webkit-margin-before: 1em; -webkit-margin-after: 1em; -webkit-margin-start: 0px; -webkit-margin-end: 0px; -webkit-padding-start: 40px;">
					<li class="left c_start" num="-1" title="start"
						style="background: url('/project/resources/images/story/c_start.png') no-repeat; float: left; width: 120px; height: 80px; cursor: pointer; postion: relative;"></li>
					<li class="left c_mid" num="0" title="test"
						style="background: url('/project/resources/images/story/c_mid.png') no-repeat; float: left; width: 120px; height: 80px; cursor: pointer; postion: relative;">
						<span>test</span>
					</li>
					<li class="left c_end_l" num="1" title="end"
						style="background: url('/project/resources/images/story/c_end_l.png') no-repeat; float: left; width: 120px; height: 80px; cursor: pointer; postion: relative;"></li>
				</ul>
			</div>
		</div>
		<div class="sty_con"
			style="float: left; width: 792px; border-top: 1px solid #e2e2e2;">
			<div class="sty_cont"
				style="position: relative; width: 100%; float: left">
				<div class="sty_list"
					style="width: 561px; float: left; border-right: 1px solid #e2e2e2; padding-bottom: 10px;">
					여행지 정보
					<div class="sty_conts"
						style="border-bottom: none; padding-left: 10px; padding-right: 10px; position: relative">
						<a class="qcourse_0" name="qcourse_0"
							style="postion: absolute; top: -40px;"></a>
						<div class="sty_info">
							<div class="sty_plc" dv_map_view="0" vw_no="1"
								style="background: url('/project/resources/images/story/c_bg_place.png') no-repeat; float: left; padding: 5px; margin-top: 15px;">
								<a href="#"
									style="width: 530px; display: block; float: left; position: relative;">
									<img class="img_cate"
									src="/project/resources/images/story/c00801.png"
									style="width: 50px; height: 50px; display: inline-block; float: left; vertical-align: middle; border: 0 none;">
									<div class="plc_info"
										style="display: inline-block; margin-left: 10px; width: 345px; float: left;">
										<span class="plc_nm"
											style="color: #4fc316; font-weight: bold; margin-top: 8px; font-size: 16px; line-height: 18px; display: block;">test</span>
										장소명--location_name <span class="plc_addr"
											style="display: inline-block; color: #6e6e6e; font-size: 12px;">test
											address</span> address -- in trip_location_info table
									</div>
									<div class="plc_num"
										style="display: inline-block; float: left; margin-top: 7px;">
										<div class="plc_flag"
											style="width: 15px; height: 15px; display: inline-block; background: url('/project/resources/images/story/c_ico_point.png') no-repeat; float: left; margin-top: 2px;"></div>
										<span class="plc_addr"
											style="display: inline-block; float: left; margin-left: 6px; color: #ff7800; font-size: 12px;">1지점</span>
										epilogue_course - visit_order에서 따올수있다.
									</div>
									<div class="plc_here"
										style="width: 41px; height: 48px; display: inline-block; background: url('/project/resources/images/story/c_ico_hrer.png') no-repeat; float: right; text-indent: -10000px; margin-right: 4px;">

									</div>
								</a>
							</div>
							<div class="sty_cont"
								style="clear: both; padding-top: 18px; padding-bottom: 20px; width: 520px; padding: 15px 10px 20px 10px; line-height: 22px; position: relative; float: left;">하하</div>
							epilogue-content.
						</div>
						<a name="qcourse_0"></a>
						<div class="cont_btm"
							style="font-size: 12px; padding-top: 3px; padding-bottom: 7px; clear: both;">
							<span class="btm_date" style="color: #acacac;"></span>
						</div>
					</div>
					에필로그
				</div>
				<div class="sty_right" id="sty_right"
					style="float: left; width: 215px; background-color: #fff; margin-right: 8px;">
					<div class="view_map"
						style="font-size: 11px; margin-top: 11px; margin-bottom: 7px; margin-right: 11px; text-align: right;">
						<a id="detail_map"
							style="display: inline-block; width: 74px; height: 16px; background: url('/project/resources/images/story/c_font_4_map_open.png') no-repeat;">
						</a>
					</div>
					<div id="trace_no_map" class="trace_no_map"
						style="width: 208px; height: 200px; background: url('/project/resources/images/story/c_un_map.png') no-repeat; postion: absolute; margin-left: 4px; z-index: 1;">
					</div>
					<div id="trace_map" class="trace_map"
						style="height: 200px; background-color: #fff; margin-left: 10px; margin-right: 10px; margin-bottom: 10px;"></div>
					<div id="trace_cont" class="trace_cont" style="margin: 10px;">
						<ul id="trace_list" class="trace_list">
							<li class="point"
								style="display: list-item; text-align: -webkit-match-parent">
								<div class="cont_top" style="display: none;">
									<span class="trace_num"
										style="color: #ff7800; font-weight: bold;">1지점</span> <span
										class="trace_date"
										style="font-size: 11px; float: right; color: #acacac;">2018년01월16일</span>
								</div>
								<div class="cont_mid" style="margin-top: 5px">
									<div class="icon"
										style="width: 18px; height: 20px; display: inline-block; float: left; background: url('/project/resources/images/story/c_ico_here_map.png') no-repeat;"></div>
									<div class="cont_con"
										style="display: inline-block; margin-left: 5px; width: 185px;">
										<div class="tp_nm"
											style="color: #48be17; font-weight: bold; font-size: 16px;">location_name</div>
										<div class="tp_addr" style="font-size: 12px; color: #6e6e6e;">address</div>
										<div class="lat" style="display: none;">x-coordinate</div>
										<div class="lon" style="display: none;">y-coordinate</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="sty_btom" style="clear: both;"></div>
			<a id="abc"></a>
			</div>
			</div>
</c:if>