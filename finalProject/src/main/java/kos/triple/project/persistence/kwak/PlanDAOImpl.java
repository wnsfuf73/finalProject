package kos.triple.project.persistence.kwak;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.PlanCourseVO;
import kos.triple.project.vo.PlanVO;
import kos.triple.project.vo.WhereVO;

@Repository
public class PlanDAOImpl implements PlanDAO {
	
	@Autowired
	private SqlSession sqlSession;

	//plan추가
	@Override
	public int insertPlan(PlanVO dto) {

		int cnt = 0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.insertPlan(dto);

		System.out.println(cnt==1 ? "plan추가 성공":"plan추가 실패");
		
		return cnt;
	}

	//장소 갯수 구하기
	@Override
	public int getLocationCnt() {
		int cnt = 0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.getLocationCnt();
		
		return cnt;
	}

	//장소 목록 조회
	@Override
	public ArrayList<WhereVO> getLocationList() {
		
		ArrayList<WhereVO> dtos = null;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dtos = dao.getLocationList();
		
		return dtos;
	}

	//장소 정보 가져오기(지역별)
	@Override
	public List<WhereVO> getLocation_proc(String area) {
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		List<WhereVO> voList = dao.getLocation_proc(area);
		return voList;
	}

	//planNo 가지고오기
	@Override
	public PlanVO getPlanNo() {

		PlanVO dto = new PlanVO();
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dto = dao.getPlanNo();
		
		return dto;
	}
	
	//코스저장
	@Override
	public int insertPlan_Course(PlanCourseVO dto) {
		int cnt = 0;
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.insertPlan_Course(dto);
		return cnt;
	}

	//코스갯수구하기
	@Override
	public int getMainCourseCnt() {
		int cnt =0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.getMainCourseCnt();
		
		return cnt;
	}

	//코스목록조회
	@Override
	public ArrayList<PlanVO> getMainCourseList(Map<String, Object> map) {
		ArrayList<PlanVO> dtos = null;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dtos = dao.getMainCourseList(map);
		
		return dtos;
	}

	//상세코스가지고오기
	@Override
	public ArrayList<PlanCourseVO> getCourseContent(int planNo) {
		//바구니 생성
		ArrayList<PlanCourseVO> dto = new ArrayList<PlanCourseVO>();
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dto = dao.getCourseContent(planNo);
		
		return dto;
	}

	//나의 계획 갯수 구하기
	@Override
	public int getMyPlanCnt(String mem_id) {
		int cnt =0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.getMyPlanCnt(mem_id);
		
		return cnt;
	}

	//나의 계획 리스트 구하기
	@Override
	public ArrayList<PlanVO> getMyPlanList(Map<String, Object> map) {
		ArrayList<PlanVO> dtos = null;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dtos = dao.getMyPlanList(map);
		
		return dtos;
	}

	//plan추가
	@Override
	public int updatePlan(PlanVO dto) {
		int cnt = 0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.updatePlan(dto);

		System.out.println(cnt==1 ? "plan수정 성공":"plan수정 실패");
		
		return cnt;
	}
}
