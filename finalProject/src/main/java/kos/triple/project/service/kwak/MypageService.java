package kos.triple.project.service.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MypageService {
	
	//������
	public void inventoryReviewList(HttpServletRequest req, Model model);
	
	//�������
	public void ReviewDeletePro(HttpServletRequest req, Model model);

	//�����̸��
	public void inventoryEssayList(HttpServletRequest req, Model model);
	
	//�����̻󼼺���
	public void myEssayContent(HttpServletRequest req, Model model);
	
	//��۵��
	public void insertReply(HttpServletRequest req, Model model);
	
	//��۸�Ϻ���
	public void replyList(HttpServletRequest req, Model model);
	
	//������ ����
	public void myEssayDelpro(HttpServletRequest req, Model model);
}
