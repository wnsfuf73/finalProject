package kos.triple.project.service.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface PlanService {
	
	//plan�ֱ�
	public void insertPlan(HttpServletRequest req, Model model);
	
	//��� �ҷ�����
	public void selectlocation(HttpServletRequest req, Model model);
	
	//��� ���� ��������(������)
	public void getLocation(HttpServletRequest req, Model model);
	
	//��ȹ�ϱ� ����ó��
	public void insertPlanPro(HttpServletRequest req, Model model);
	
	//��ȹ�ϱ� ���ο� ����� �ڽ� ������ ����
	public void selectCourseMain(HttpServletRequest req, Model model);
	
	//��ȹ�ϱ� ���ο� ����� ���ڽ����� ������ ����
	public void selectCourseContent(HttpServletRequest req, Model model);
	
	//���� ��ȹ ������ ����
	public void selectMyPlan(HttpServletRequest req, Model model);
		
	//plan����
	public void updatePlan(HttpServletRequest req, Model model);
}
