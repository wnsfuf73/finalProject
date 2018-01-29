package kos.triple.project.service.kwak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kos.triple.project.persistence.kwak.MypageDAO;
import kos.triple.project.vo.EssayVO;
import kos.triple.project.vo.ReviewVO;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	MypageDAO dao;

	//������
	@Override
	public void inventoryReviewList(HttpServletRequest req, Model model) {
		int pageSize = 5;	//�� �������� ����� �� ����
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
		
		String mem_id = (String) req.getSession().getAttribute("mem_id");
		
		cnt = dao.getReviewCnt(mem_id);
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
			map.put("mem_id", mem_id);
			
			ArrayList<ReviewVO> dtos = dao.getReviewList(map);
			req.setAttribute("dtos", dtos);	//ū�ٱ��� : �Խñ۸�� ex) ���� �ٱ��� : �Խñ�1��
			/*for(int i=0; i < dtos.size(); i++) {
				System.out.println(dtos.get(0).getReviewview());
				System.out.println(dtos.get(0).getFun());
				System.out.println(dtos.get(0).getNear());
				System.out.println(dtos.get(0).getPrice());
			}*/
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
	
	//�������
	@Override
	public void ReviewDeletePro(HttpServletRequest req, Model model) {
		/*//�ٱ��Ͽ� ���
		ReviewVO dto = new ReviewVO();*/
		
		//�� �޾ƿ���
		int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
		System.out.println(reviewNo);
		
		int cnt = dao.reviewDelete(reviewNo);
		System.out.println("deleteCnt : "+cnt);
		
		model.addAttribute("cnt",cnt);
	}

	//�����̸��
	@Override
	public void inventoryEssayList(HttpServletRequest req, Model model) {
		int pageSize = 5;	//�� �������� ����� �� ����
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

		String mem_id = (String) req.getSession().getAttribute("mem_id");
		
		cnt = dao.getEssayCnt(mem_id);
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
			map.put("mem_id", mem_id);
			
			ArrayList<EssayVO> dtos = dao.getEssayList(map);
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

	//�����̻󼼺���
	@Override
	public void myEssayContent(HttpServletRequest req, Model model) {
		//get������� �ѱ� �� �޾ƿ���
		int essayNo = Integer.parseInt(req.getParameter("essayNo"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		
		//�������� ��������
		EssayVO dto = dao.getEssayContent(essayNo);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("essayNo", essayNo);
		model.addAttribute("number", number);
	}

	//��۵��
	@Override
	public void insertReply(HttpServletRequest req, Model model) {
		int cnt = 0;
		String mem_id = (String) req.getSession().getAttribute("mem_id");
		String replyContent = req.getParameter("replyContent");
		int essayNo = Integer.parseInt(req.getParameter("essayNo"));
		
		System.out.println(mem_id);
		System.out.println(replyContent);
		System.out.println(essayNo);
		EssayVO dto = new EssayVO();
		
		dto.setReplyContent(replyContent);
		dto.setMem_id(mem_id);
		dto.setEssayNo(essayNo);
		
		
		if(replyContent.equals("")) {
			cnt = -1;
		}else {
			cnt = dao.insertReply(dto);
			System.out.println("��� ���cnt : "+cnt);
		}
		
		model.addAttribute("cnt", cnt);
		
	}

	//��۸�Ϻ���
	@Override
	public void replyList(HttpServletRequest req, Model model) {
		
		int essayNo = Integer.parseInt(req.getParameter("essayNo"));
		System.out.println(essayNo);
		
		ArrayList<EssayVO> dtos = dao.replyList(essayNo);
		
		model.addAttribute("dtos", dtos);
	}

	//������ ����
	@Override
	public void myEssayDelpro(HttpServletRequest req, Model model) {
		
		int essayNo = Integer.parseInt(req.getParameter("essayNo"));
		System.out.println("essayNo" + essayNo);
		
		int cnt = dao.essayDelete(essayNo);
		
		model.addAttribute("cnt", cnt);
		
	}

}
