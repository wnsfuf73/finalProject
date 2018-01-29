package kos.triple.project.controller.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kos.triple.project.service.kwak.MypageServiceImpl;

@Controller
public class MypageController {

	@Autowired
	MypageServiceImpl Mservice;
	
	//���� ���� ��Ϻ���
	@RequestMapping(value="myReview")
	public String myReview(HttpServletRequest req, Model model) {
		System.out.println("myReview()");
		
		Mservice.inventoryReviewList(req, model);
		
		return "mypage/myReview";
	}

	//���� ���� ���� ��
	@RequestMapping(value="myReviewDelete")
	public String myReviewDelete(HttpServletRequest req, Model model) {
		System.out.println("myReviewDelete()");
		
		//��� ����
		Mservice.inventoryReviewList(req, model);
		
		return "mypage/myReviewDelete";
	}
	
	//���� ���� ���� ��
	@RequestMapping(value="myReviewDeletePro")
	public String myReviewDeletePro(HttpServletRequest req, Model model) {
		System.out.println("myReviewDeletePro()");
		
		//��� ����
		Mservice.ReviewDeletePro(req, model);
		
		return "mypage/myReviewDeletePro";
	}

	//���� ������
	@RequestMapping(value="myEssay")
	public String myEssay(HttpServletRequest req, Model model) {
		System.out.println("myEssay()");
		
		//�����̸�� ����
		Mservice.inventoryEssayList(req, model);
		
		return "mypage/myEssay";
	}
	
	//���� ������ �󼼺���
	@RequestMapping(value="myEssayContent")
	public String myEssayContent(HttpServletRequest req, Model model) {
		System.out.println("myEssayContent()");
		
		//�����̸�� ����
		Mservice.myEssayContent(req, model);
		
		Mservice.replyList(req, model);
		
		return "mypage/myEssayContent";
	}
	
	//������ ���
	@RequestMapping(value="myEssayReply")
	public String myEssayReply(HttpServletRequest req, Model model) {
		System.out.println("myEssayReply()");
		
		Mservice.myEssayContent(req, model);
		//�����̸�� ����
		Mservice.insertReply(req, model);
		Mservice.replyList(req, model);
		
		return "mypage/myEssayContent";
	}
	
	//������ ����
	@RequestMapping(value="myEssayDelpro")
	public String myEssayDelpro(HttpServletRequest req, Model model) {
		System.out.println("myEssayDelete()");
		
		//��� ����
		Mservice.myEssayDelpro(req, model);
		
		return "mypage/myEssayDelpro";
	}

}