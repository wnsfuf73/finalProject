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
	
	//나의 리뷰 목록보기
	@RequestMapping(value="myReview")
	public String myReview(HttpServletRequest req, Model model) {
		System.out.println("myReview()");
		
		Mservice.inventoryReviewList(req, model);
		
		return "mypage/myReview";
	}

	//나의 리뷰 삭제 폼
	@RequestMapping(value="myReviewDelete")
	public String myReviewDelete(HttpServletRequest req, Model model) {
		System.out.println("myReviewDelete()");
		
		//목록 보기
		Mservice.inventoryReviewList(req, model);
		
		return "mypage/myReviewDelete";
	}
	
	//나의 리뷰 삭제 폼
	@RequestMapping(value="myReviewDeletePro")
	public String myReviewDeletePro(HttpServletRequest req, Model model) {
		System.out.println("myReviewDeletePro()");
		
		//목록 보기
		Mservice.ReviewDeletePro(req, model);
		
		return "mypage/myReviewDeletePro";
	}

	//나의 에세이
	@RequestMapping(value="myEssay")
	public String myEssay(HttpServletRequest req, Model model) {
		System.out.println("myEssay()");
		
		//에세이목록 보기
		Mservice.inventoryEssayList(req, model);
		
		return "mypage/myEssay";
	}
	
	//나의 에세이 상세보기
	@RequestMapping(value="myEssayContent")
	public String myEssayContent(HttpServletRequest req, Model model) {
		System.out.println("myEssayContent()");
		
		//에세이목록 보기
		Mservice.myEssayContent(req, model);
		
		Mservice.replyList(req, model);
		
		return "mypage/myEssayContent";
	}
	
	//에세이 댓글
	@RequestMapping(value="myEssayReply")
	public String myEssayReply(HttpServletRequest req, Model model) {
		System.out.println("myEssayReply()");
		
		Mservice.myEssayContent(req, model);
		//에세이목록 보기
		Mservice.insertReply(req, model);
		Mservice.replyList(req, model);
		
		return "mypage/myEssayContent";
	}
	
	//에세이 삭제
	@RequestMapping(value="myEssayDelpro")
	public String myEssayDelpro(HttpServletRequest req, Model model) {
		System.out.println("myEssayDelete()");
		
		//목록 보기
		Mservice.myEssayDelpro(req, model);
		
		return "mypage/myEssayDelpro";
	}

}