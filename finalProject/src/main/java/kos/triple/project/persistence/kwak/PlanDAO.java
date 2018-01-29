package kos.triple.project.persistence.kwak;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kos.triple.project.vo.PlanCourseVO;
import kos.triple.project.vo.PlanVO;
import kos.triple.project.vo.WhereVO;

public interface PlanDAO {
	
	//plan�߰�
	public int insertPlan(PlanVO dto);
	
	//��� ���� ���ϱ�
	public int getLocationCnt();
	
	//��� ��� ��ȸ
	public ArrayList<WhereVO> getLocationList();

	//��� ���� ��������(������)
	public List<WhereVO> getLocation_proc(String area);
	
	//planNo ���������
	public PlanVO getPlanNo();
	
	//��ȹ�ڽ� �ֱ�
	public int insertPlan_Course(PlanCourseVO dto);
	
	//�ڽ��������ϱ�
	public int getMainCourseCnt();
	
	//�ڽ������ȸ
	public ArrayList<PlanVO> getMainCourseList(Map<String, Object> map);

	//���ڽ����������
	public ArrayList<PlanCourseVO> getCourseContent(int planNo);

	//���� ��ȹ ���� ���ϱ�
	public int getMyPlanCnt(String mem_id);

	//���� ��ȹ ����Ʈ ���ϱ�
	public ArrayList<PlanVO> getMyPlanList(Map<String, Object> map);
	
	//plan�߰�
	public int updatePlan(PlanVO dto);

}
