package kos.triple.project.service.kwak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kos.triple.project.persistence.kwak.PlanDAO;
import kos.triple.project.vo.PlanCourseVO;
import kos.triple.project.vo.PlanVO;
import kos.triple.project.vo.WhereVO;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	PlanDAO dao;
	
	//plan넣기
	@Override
	public void insertPlan(HttpServletRequest req, Model model) {
		//id값 받아오기
		String id = (String)req.getSession().getAttribute("mem_id");
		String title = req.getParameter("planTitle");
		String content = req.getParameter("planContent");		
		
		//바구니 생성
		PlanVO dto = new PlanVO();
		
		//planVO 바구니에 저장
		dto.setMem_Id(id);
		dto.setPlanTitle(title);
		dto.setPlanContent(content);
		
		//dao에서 insert처리
		int cnt = dao.insertPlan(dto);
		int planNo = dao.getPlanNo().getPlanNo();
		
		System.out.println("planNo -----> "+planNo);
		
		model.addAttribute("cnt"+cnt);
		System.out.println("insertPlancnt : "+cnt);
		
		model.addAttribute("planTitle",title);
		model.addAttribute("planNo", planNo);
	
	}

	//장소 불러오기
	@Override
	public void selectlocation(HttpServletRequest req, Model model) {
		
		int cnt = 0;	//장소 갯수 구하기
		
		//장소갯수 구하기
		cnt = dao.getLocationCnt();
		System.out.println("장소갯수 : "+cnt);
		
		if(cnt > 0) {
			//게시글 조회
			ArrayList<WhereVO> dtos = dao.getLocationList();
			model.addAttribute("dtol",dtos);
			System.out.println("장소dtos : "+dtos);
			
			model.addAttribute("cnt",cnt);
		}
	}
	
	//장소 정보 가져오기(지역별)
	public void getLocation(HttpServletRequest req, Model model) {
		
		String area = req.getParameter("area");
		System.out.println(area);
		
		List<WhereVO> voList = dao.getLocation_proc(area);
		
		
		req.setAttribute("WhereVOList",voList);
	}

	//계획하기 저장처리
	@Override
	public void insertPlanPro(HttpServletRequest req, Model model) {
		//바구니 생성
	
		List<PlanCourseVO> courseList = new ArrayList<PlanCourseVO>();
		
		// 값 받아오기
		int planNo = Integer.parseInt(req.getParameter("planNo"));
		/*req.getParameterValues(name)*/
		String[] dday = req.getParameterValues("date");
		String[] location_num = req.getParameterValues("locationNum");
		String day = null;
		System.out.println("planNo : "+planNo);
		
	
		for(int i=0; i<location_num.length; i++) {
			PlanCourseVO tmp = new PlanCourseVO();
			tmp.setLocation_num(location_num[i]); //방문장소
			tmp.setPlanOrder(i+1);//방문순서
			
			for(int j=0; j<dday.length; j++) {
				java.sql.Date planday = java.sql.Date.valueOf(dday[j]);
				tmp.setDday(planday);
				day=planday.toString();
				//System.out.println("date: "+planday);
			}//방문날짜
			tmp.setPlanNo(planNo); //계획번호
			
			courseList.add(tmp);
			//System.out.println("locationNum : "+location_num[i]);
		}
		
		/*System.out.println("-----------------start--------------");
		for(PlanCourseVO i : courseList) {
			System.out.println("방문장소" + i.getLocation_num());
			System.out.println("방문순서" + i.getPlanOrder());
			System.out.println("방문날짜" + i.getDday());
			System.out.println("계획번호" + i.getPlanNo());
			System.out.println("------------1------------");
		}*/
		
		System.out.println("------------------------");
		int[] cnt = new int[courseList.size()];
		int index = 0;
		for(PlanCourseVO i : courseList) {
			cnt[index++] = dao.insertPlan_Course(i);
		}
		
		int token = 0;
		
		for(int i:cnt) {
			if(i==0) {
				token=0;
				break;
			}else {
				token=1;
			}
		}
		
		model.addAttribute("startDate",req.getParameter("startDate")); //시작날짜
		model.addAttribute("endDate",req.getParameter("endDate")); //마지막날짜
		model.addAttribute("day",day); //선택한날짜
		model.addAttribute("planNo",planNo); //계획번호
		
		model.addAttribute("cnt",token);
		
	}

	//계획하기 메인에 사람들 코스 가지고 오기
	@Override
	public void selectCourseMain(HttpServletRequest req, Model model) {
		
		int pageSize = 10;	//한 페이지당 출력할 글 갯수
		int pageBlock = 3;	//한 블럭당 페이지 갯수
		
		int cnt = 0;	// 글 갯수
		int start = 0;	// 현재 페이지 글 시작번호
		int end = 0;	// 현재 페이지 글 마지막 번호
		int number = 0;	//출력할 글 번호
		String pageNum = null;	//페이지 번호
		int currentPage = 0;	//현재 페이지
		
		int pageCount = 0;	//페이지 개수
		int startPage = 0;	//시작페이지
		int endPage = 0;	//마지막 페이지
		
		
		cnt = dao.getMainCourseCnt();
		System.out.println("글갯수cnt : "+cnt);
		
		pageNum = req.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";	//첫 페이지를 1페이지로 설정
		}
		System.out.println(pageNum);
		currentPage = Integer.parseInt(pageNum);	// 현재페이지
		System.out.println(pageNum);
		//pageCnt = 12 / 5 + 1; //나머지 2건이 1페이지로 할당되므로 3페이지
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);	//페이지개수 + 나머지
		
		// 1 = (1-1) * 5 + 1
		// 6 = (2-1) * 5 + 1
		// 11 = (3-1) * 5 + 1
		// 21 = (5-1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1;	//현재 페이지 시작번호
		
		// 5 = 1 + 5 - 1
		// 10 = 6 + 5 - 1
		end = start + pageSize - 1;	//현재 페이지 끝 번호
		//end = currentPage * pageSize;
		
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		if(end > cnt) end = cnt;
		
		// 1 = 21 - (5-1) * 5;
		number = cnt - (currentPage -1) * pageSize; //출력할 글번호.. 최신글(큰페이지)가 1페이지 출력할 글번호
		
		System.out.println("number : " + number);
		System.out.println("cnt : " + cnt);
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageSize : " + pageSize);
		
		if(cnt > 0) {
			//게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			
			ArrayList<PlanVO> dtos = dao.getMainCourseList(map);
			req.setAttribute("dtos", dtos);	//큰바구니 : 게시글목록 ex) 작은 바구니 : 게시글1건

		}
		startPage = (currentPage / pageBlock) * pageBlock + 1;	//(5/3) * 3 + 1 = 4
		if(currentPage % pageBlock == 0) startPage -= pageBlock; //(5%3)==0
		
		endPage = startPage + pageBlock - 1; //4 + 3 - 1 = 6
		if(endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("cnt", cnt);	// 글개수
		model.addAttribute("number", number);	// 페이지번호
		model.addAttribute("pageNum", pageNum); // 글번호
		
		if(cnt > 0) {
			model.addAttribute("startPage", startPage);		//시작페이지
			model.addAttribute("endPage", endPage);			//마지막페이지
			model.addAttribute("pageBlock", pageBlock);		//출력할페이지개수
			model.addAttribute("pageCount", pageCount);		//페이지개수
			model.addAttribute("currentPage", currentPage);	//현재페이지
		}
	}

	//계획하기 메인에 사람들 상세코스정보 가지고 오기
	@Override
	public void selectCourseContent(HttpServletRequest req, Model model) {
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int planNo = Integer.parseInt(req.getParameter("planNo"));
		String planTitle = req.getParameter("planTitle");
		String planContent = req.getParameter("planContent");
		
		ArrayList<PlanCourseVO> dto = dao.getCourseContent(planNo);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("planNo", planNo);
		model.addAttribute("planTitle", planTitle);
		model.addAttribute("planContent", planContent);
		
	}

	//나의 계획 가지고 오기
	@Override
	public void selectMyPlan(HttpServletRequest req, Model model) {
		int pageSize = 10;	//한 페이지당 출력할 글 갯수
		int pageBlock = 3;	//한 블럭당 페이지 갯수
		
		int cnt = 0;	// 글 갯수
		int start = 0;	// 현재 페이지 글 시작번호
		int end = 0;	// 현재 페이지 글 마지막 번호
		int number = 0;	//출력할 글 번호
		String pageNum = null;	//페이지 번호
		int currentPage = 0;	//현재 페이지
		
		int pageCount = 0;	//페이지 개수
		int startPage = 0;	//시작페이지
		int endPage = 0;	//마지막 페이지
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		
		cnt = dao.getMyPlanCnt(mem_id);
		System.out.println("myPlan글갯수cnt : "+cnt);
		
		pageNum = req.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";	//첫 페이지를 1페이지로 설정
		}
		System.out.println(pageNum);
		currentPage = Integer.parseInt(pageNum);	// 현재페이지
		System.out.println(pageNum);
		//pageCnt = 12 / 5 + 1; //나머지 2건이 1페이지로 할당되므로 3페이지
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);	//페이지개수 + 나머지
		
		// 1 = (1-1) * 5 + 1
		// 6 = (2-1) * 5 + 1
		// 11 = (3-1) * 5 + 1
		// 21 = (5-1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1;	//현재 페이지 시작번호
		
		// 5 = 1 + 5 - 1
		// 10 = 6 + 5 - 1
		end = start + pageSize - 1;	//현재 페이지 끝 번호
		//end = currentPage * pageSize;
		
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		if(end > cnt) end = cnt;
		
		// 1 = 21 - (5-1) * 5;
		number = cnt - (currentPage -1) * pageSize; //출력할 글번호.. 최신글(큰페이지)가 1페이지 출력할 글번호
		
		System.out.println("number : " + number);
		System.out.println("cnt : " + cnt);
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageSize : " + pageSize);
		
		if(cnt > 0) {
			//게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("mem_id", mem_id);
			
			ArrayList<PlanVO> dtos = dao.getMyPlanList(map);
			req.setAttribute("dtos", dtos);	//큰바구니 : 게시글목록 ex) 작은 바구니 : 게시글1건

		}
		startPage = (currentPage / pageBlock) * pageBlock + 1;	//(5/3) * 3 + 1 = 4
		if(currentPage % pageBlock == 0) startPage -= pageBlock; //(5%3)==0
		
		endPage = startPage + pageBlock - 1; //4 + 3 - 1 = 6
		if(endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("cnt", cnt);	// 글개수
		model.addAttribute("number", number);	// 페이지번호
		model.addAttribute("pageNum", pageNum); // 글번호
		
		if(cnt > 0) {
			model.addAttribute("startPage", startPage);		//시작페이지
			model.addAttribute("endPage", endPage);			//마지막페이지
			model.addAttribute("pageBlock", pageBlock);		//출력할페이지개수
			model.addAttribute("pageCount", pageCount);		//페이지개수
			model.addAttribute("currentPage", currentPage);	//현재페이지
		}
		
	}

	//plan수정
	@Override
	public void updatePlan(HttpServletRequest req, Model model) {
		//id값 받아오기
		String id = (String)req.getSession().getAttribute("mem_id");
		String title = req.getParameter("planTitle");
		String content = req.getParameter("planContent");
		int planNo = Integer.parseInt(req.getParameter("planNo"));
		System.out.println("planNo -------- : "+planNo);
		
		//바구니 생성
		PlanVO dto = new PlanVO();
		
		//planVO 바구니에 저장
		dto.setMem_Id(id);
		dto.setPlanTitle(title);
		dto.setPlanContent(content);
		dto.setPlanNo(planNo);
		
		//dao에서 insert처리
		int cnt = dao.updatePlan(dto);
		
		
		model.addAttribute("cnt"+cnt);
		System.out.println("insertPlancnt : "+cnt);
		
		model.addAttribute("planTitle",title);
		model.addAttribute("planNo", planNo);
		
	}
}
