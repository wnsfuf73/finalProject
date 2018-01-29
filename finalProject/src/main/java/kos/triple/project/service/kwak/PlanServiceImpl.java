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
	
	//plan�ֱ�
	@Override
	public void insertPlan(HttpServletRequest req, Model model) {
		//id�� �޾ƿ���
		String id = (String)req.getSession().getAttribute("mem_id");
		String title = req.getParameter("planTitle");
		String content = req.getParameter("planContent");		
		
		//�ٱ��� ����
		PlanVO dto = new PlanVO();
		
		//planVO �ٱ��Ͽ� ����
		dto.setMem_Id(id);
		dto.setPlanTitle(title);
		dto.setPlanContent(content);
		
		//dao���� insertó��
		int cnt = dao.insertPlan(dto);
		int planNo = dao.getPlanNo().getPlanNo();
		
		System.out.println("planNo -----> "+planNo);
		
		model.addAttribute("cnt"+cnt);
		System.out.println("insertPlancnt : "+cnt);
		
		model.addAttribute("planTitle",title);
		model.addAttribute("planNo", planNo);
	
	}

	//��� �ҷ�����
	@Override
	public void selectlocation(HttpServletRequest req, Model model) {
		
		int cnt = 0;	//��� ���� ���ϱ�
		
		//��Ұ��� ���ϱ�
		cnt = dao.getLocationCnt();
		System.out.println("��Ұ��� : "+cnt);
		
		if(cnt > 0) {
			//�Խñ� ��ȸ
			ArrayList<WhereVO> dtos = dao.getLocationList();
			model.addAttribute("dtol",dtos);
			System.out.println("���dtos : "+dtos);
			
			model.addAttribute("cnt",cnt);
		}
	}
	
	//��� ���� ��������(������)
	public void getLocation(HttpServletRequest req, Model model) {
		
		String area = req.getParameter("area");
		System.out.println(area);
		
		List<WhereVO> voList = dao.getLocation_proc(area);
		
		
		req.setAttribute("WhereVOList",voList);
	}

	//��ȹ�ϱ� ����ó��
	@Override
	public void insertPlanPro(HttpServletRequest req, Model model) {
		//�ٱ��� ����
	
		List<PlanCourseVO> courseList = new ArrayList<PlanCourseVO>();
		
		// �� �޾ƿ���
		int planNo = Integer.parseInt(req.getParameter("planNo"));
		/*req.getParameterValues(name)*/
		String[] dday = req.getParameterValues("date");
		String[] location_num = req.getParameterValues("locationNum");
		String day = null;
		System.out.println("planNo : "+planNo);
		
	
		for(int i=0; i<location_num.length; i++) {
			PlanCourseVO tmp = new PlanCourseVO();
			tmp.setLocation_num(location_num[i]); //�湮���
			tmp.setPlanOrder(i+1);//�湮����
			
			for(int j=0; j<dday.length; j++) {
				java.sql.Date planday = java.sql.Date.valueOf(dday[j]);
				tmp.setDday(planday);
				day=planday.toString();
				//System.out.println("date: "+planday);
			}//�湮��¥
			tmp.setPlanNo(planNo); //��ȹ��ȣ
			
			courseList.add(tmp);
			//System.out.println("locationNum : "+location_num[i]);
		}
		
		/*System.out.println("-----------------start--------------");
		for(PlanCourseVO i : courseList) {
			System.out.println("�湮���" + i.getLocation_num());
			System.out.println("�湮����" + i.getPlanOrder());
			System.out.println("�湮��¥" + i.getDday());
			System.out.println("��ȹ��ȣ" + i.getPlanNo());
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
		
		model.addAttribute("startDate",req.getParameter("startDate")); //���۳�¥
		model.addAttribute("endDate",req.getParameter("endDate")); //��������¥
		model.addAttribute("day",day); //�����ѳ�¥
		model.addAttribute("planNo",planNo); //��ȹ��ȣ
		
		model.addAttribute("cnt",token);
		
	}

	//��ȹ�ϱ� ���ο� ����� �ڽ� ������ ����
	@Override
	public void selectCourseMain(HttpServletRequest req, Model model) {
		
		int pageSize = 10;	//�� �������� ����� �� ����
		int pageBlock = 3;	//�� ���� ������ ����
		
		int cnt = 0;	// �� ����
		int start = 0;	// ���� ������ �� ���۹�ȣ
		int end = 0;	// ���� ������ �� ������ ��ȣ
		int number = 0;	//����� �� ��ȣ
		String pageNum = null;	//������ ��ȣ
		int currentPage = 0;	//���� ������
		
		int pageCount = 0;	//������ ����
		int startPage = 0;	//����������
		int endPage = 0;	//������ ������
		
		
		cnt = dao.getMainCourseCnt();
		System.out.println("�۰���cnt : "+cnt);
		
		pageNum = req.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";	//ù �������� 1�������� ����
		}
		System.out.println(pageNum);
		currentPage = Integer.parseInt(pageNum);	// ����������
		System.out.println(pageNum);
		//pageCnt = 12 / 5 + 1; //������ 2���� 1�������� �Ҵ�ǹǷ� 3������
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);	//���������� + ������
		
		// 1 = (1-1) * 5 + 1
		// 6 = (2-1) * 5 + 1
		// 11 = (3-1) * 5 + 1
		// 21 = (5-1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1;	//���� ������ ���۹�ȣ
		
		// 5 = 1 + 5 - 1
		// 10 = 6 + 5 - 1
		end = start + pageSize - 1;	//���� ������ �� ��ȣ
		//end = currentPage * pageSize;
		
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		if(end > cnt) end = cnt;
		
		// 1 = 21 - (5-1) * 5;
		number = cnt - (currentPage -1) * pageSize; //����� �۹�ȣ.. �ֽű�(ū������)�� 1������ ����� �۹�ȣ
		
		System.out.println("number : " + number);
		System.out.println("cnt : " + cnt);
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageSize : " + pageSize);
		
		if(cnt > 0) {
			//�Խñ� ��� ��ȸ
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			
			ArrayList<PlanVO> dtos = dao.getMainCourseList(map);
			req.setAttribute("dtos", dtos);	//ū�ٱ��� : �Խñ۸�� ex) ���� �ٱ��� : �Խñ�1��

		}
		startPage = (currentPage / pageBlock) * pageBlock + 1;	//(5/3) * 3 + 1 = 4
		if(currentPage % pageBlock == 0) startPage -= pageBlock; //(5%3)==0
		
		endPage = startPage + pageBlock - 1; //4 + 3 - 1 = 6
		if(endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("cnt", cnt);	// �۰���
		model.addAttribute("number", number);	// ��������ȣ
		model.addAttribute("pageNum", pageNum); // �۹�ȣ
		
		if(cnt > 0) {
			model.addAttribute("startPage", startPage);		//����������
			model.addAttribute("endPage", endPage);			//������������
			model.addAttribute("pageBlock", pageBlock);		//���������������
			model.addAttribute("pageCount", pageCount);		//����������
			model.addAttribute("currentPage", currentPage);	//����������
		}
	}

	//��ȹ�ϱ� ���ο� ����� ���ڽ����� ������ ����
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

	//���� ��ȹ ������ ����
	@Override
	public void selectMyPlan(HttpServletRequest req, Model model) {
		int pageSize = 10;	//�� �������� ����� �� ����
		int pageBlock = 3;	//�� ���� ������ ����
		
		int cnt = 0;	// �� ����
		int start = 0;	// ���� ������ �� ���۹�ȣ
		int end = 0;	// ���� ������ �� ������ ��ȣ
		int number = 0;	//����� �� ��ȣ
		String pageNum = null;	//������ ��ȣ
		int currentPage = 0;	//���� ������
		
		int pageCount = 0;	//������ ����
		int startPage = 0;	//����������
		int endPage = 0;	//������ ������
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		
		cnt = dao.getMyPlanCnt(mem_id);
		System.out.println("myPlan�۰���cnt : "+cnt);
		
		pageNum = req.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";	//ù �������� 1�������� ����
		}
		System.out.println(pageNum);
		currentPage = Integer.parseInt(pageNum);	// ����������
		System.out.println(pageNum);
		//pageCnt = 12 / 5 + 1; //������ 2���� 1�������� �Ҵ�ǹǷ� 3������
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);	//���������� + ������
		
		// 1 = (1-1) * 5 + 1
		// 6 = (2-1) * 5 + 1
		// 11 = (3-1) * 5 + 1
		// 21 = (5-1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1;	//���� ������ ���۹�ȣ
		
		// 5 = 1 + 5 - 1
		// 10 = 6 + 5 - 1
		end = start + pageSize - 1;	//���� ������ �� ��ȣ
		//end = currentPage * pageSize;
		
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		if(end > cnt) end = cnt;
		
		// 1 = 21 - (5-1) * 5;
		number = cnt - (currentPage -1) * pageSize; //����� �۹�ȣ.. �ֽű�(ū������)�� 1������ ����� �۹�ȣ
		
		System.out.println("number : " + number);
		System.out.println("cnt : " + cnt);
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageSize : " + pageSize);
		
		if(cnt > 0) {
			//�Խñ� ��� ��ȸ
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("mem_id", mem_id);
			
			ArrayList<PlanVO> dtos = dao.getMyPlanList(map);
			req.setAttribute("dtos", dtos);	//ū�ٱ��� : �Խñ۸�� ex) ���� �ٱ��� : �Խñ�1��

		}
		startPage = (currentPage / pageBlock) * pageBlock + 1;	//(5/3) * 3 + 1 = 4
		if(currentPage % pageBlock == 0) startPage -= pageBlock; //(5%3)==0
		
		endPage = startPage + pageBlock - 1; //4 + 3 - 1 = 6
		if(endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("cnt", cnt);	// �۰���
		model.addAttribute("number", number);	// ��������ȣ
		model.addAttribute("pageNum", pageNum); // �۹�ȣ
		
		if(cnt > 0) {
			model.addAttribute("startPage", startPage);		//����������
			model.addAttribute("endPage", endPage);			//������������
			model.addAttribute("pageBlock", pageBlock);		//���������������
			model.addAttribute("pageCount", pageCount);		//����������
			model.addAttribute("currentPage", currentPage);	//����������
		}
		
	}

	//plan����
	@Override
	public void updatePlan(HttpServletRequest req, Model model) {
		//id�� �޾ƿ���
		String id = (String)req.getSession().getAttribute("mem_id");
		String title = req.getParameter("planTitle");
		String content = req.getParameter("planContent");
		int planNo = Integer.parseInt(req.getParameter("planNo"));
		System.out.println("planNo -------- : "+planNo);
		
		//�ٱ��� ����
		PlanVO dto = new PlanVO();
		
		//planVO �ٱ��Ͽ� ����
		dto.setMem_Id(id);
		dto.setPlanTitle(title);
		dto.setPlanContent(content);
		dto.setPlanNo(planNo);
		
		//dao���� insertó��
		int cnt = dao.updatePlan(dto);
		
		
		model.addAttribute("cnt"+cnt);
		System.out.println("insertPlancnt : "+cnt);
		
		model.addAttribute("planTitle",title);
		model.addAttribute("planNo", planNo);
		
	}
}
