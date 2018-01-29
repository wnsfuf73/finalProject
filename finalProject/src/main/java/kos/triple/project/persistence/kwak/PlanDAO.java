package kos.triple.project.persistence.kwak;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kos.triple.project.vo.PlanCourseVO;
import kos.triple.project.vo.PlanVO;
import kos.triple.project.vo.WhereVO;

public interface PlanDAO {
	
	//plan추가
	public int insertPlan(PlanVO dto);
	
	//장소 갯수 구하기
	public int getLocationCnt();
	
	//장소 목록 조회
	public ArrayList<WhereVO> getLocationList();

	//장소 정보 가져오기(지역별)
	public List<WhereVO> getLocation_proc(String area);
	
	//planNo 가지고오기
	public PlanVO getPlanNo();
	
	//계획코스 넣기
	public int insertPlan_Course(PlanCourseVO dto);
	
	//코스갯수구하기
	public int getMainCourseCnt();
	
	//코스목록조회
	public ArrayList<PlanVO> getMainCourseList(Map<String, Object> map);

	//상세코스가지고오기
	public ArrayList<PlanCourseVO> getCourseContent(int planNo);

	//나의 계획 갯수 구하기
	public int getMyPlanCnt(String mem_id);

	//나의 계획 리스트 구하기
	public ArrayList<PlanVO> getMyPlanList(Map<String, Object> map);
	
	//plan추가
	public int updatePlan(PlanVO dto);

}
