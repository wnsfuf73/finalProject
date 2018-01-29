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

	//plan�߰�
	@Override
	public int insertPlan(PlanVO dto) {

		int cnt = 0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.insertPlan(dto);

		System.out.println(cnt==1 ? "plan�߰� ����":"plan�߰� ����");
		
		return cnt;
	}

	//��� ���� ���ϱ�
	@Override
	public int getLocationCnt() {
		int cnt = 0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.getLocationCnt();
		
		return cnt;
	}

	//��� ��� ��ȸ
	@Override
	public ArrayList<WhereVO> getLocationList() {
		
		ArrayList<WhereVO> dtos = null;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dtos = dao.getLocationList();
		
		return dtos;
	}

	//��� ���� ��������(������)
	@Override
	public List<WhereVO> getLocation_proc(String area) {
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		List<WhereVO> voList = dao.getLocation_proc(area);
		return voList;
	}

	//planNo ���������
	@Override
	public PlanVO getPlanNo() {

		PlanVO dto = new PlanVO();
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dto = dao.getPlanNo();
		
		return dto;
	}
	
	//�ڽ�����
	@Override
	public int insertPlan_Course(PlanCourseVO dto) {
		int cnt = 0;
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.insertPlan_Course(dto);
		return cnt;
	}

	//�ڽ��������ϱ�
	@Override
	public int getMainCourseCnt() {
		int cnt =0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.getMainCourseCnt();
		
		return cnt;
	}

	//�ڽ������ȸ
	@Override
	public ArrayList<PlanVO> getMainCourseList(Map<String, Object> map) {
		ArrayList<PlanVO> dtos = null;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dtos = dao.getMainCourseList(map);
		
		return dtos;
	}

	//���ڽ����������
	@Override
	public ArrayList<PlanCourseVO> getCourseContent(int planNo) {
		//�ٱ��� ����
		ArrayList<PlanCourseVO> dto = new ArrayList<PlanCourseVO>();
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dto = dao.getCourseContent(planNo);
		
		return dto;
	}

	//���� ��ȹ ���� ���ϱ�
	@Override
	public int getMyPlanCnt(String mem_id) {
		int cnt =0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.getMyPlanCnt(mem_id);
		
		return cnt;
	}

	//���� ��ȹ ����Ʈ ���ϱ�
	@Override
	public ArrayList<PlanVO> getMyPlanList(Map<String, Object> map) {
		ArrayList<PlanVO> dtos = null;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		dtos = dao.getMyPlanList(map);
		
		return dtos;
	}

	//plan�߰�
	@Override
	public int updatePlan(PlanVO dto) {
		int cnt = 0;
		
		PlanDAO dao = sqlSession.getMapper(PlanDAO.class);
		cnt = dao.updatePlan(dto);

		System.out.println(cnt==1 ? "plan���� ����":"plan���� ����");
		
		return cnt;
	}
}
