package kos.triple.project.service.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface PlanService {
	
	//plan넣기
	public void insertPlan(HttpServletRequest req, Model model);
	
	//장소 불러오기
	public void selectlocation(HttpServletRequest req, Model model);
	
	//장소 정보 가져오기(지역별)
	public void getLocation(HttpServletRequest req, Model model);
	
	//계획하기 저장처리
	public void insertPlanPro(HttpServletRequest req, Model model);
	
	//계획하기 메인에 사람들 코스 가지고 오기
	public void selectCourseMain(HttpServletRequest req, Model model);
	
	//계획하기 메인에 사람들 상세코스정보 가지고 오기
	public void selectCourseContent(HttpServletRequest req, Model model);
	
	//나의 계획 가지고 오기
	public void selectMyPlan(HttpServletRequest req, Model model);
		
	//plan수정
	public void updatePlan(HttpServletRequest req, Model model);
}
