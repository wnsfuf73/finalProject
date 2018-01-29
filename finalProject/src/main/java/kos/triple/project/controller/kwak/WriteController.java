package kos.triple.project.controller.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.service.kwak.EssayServiceImpl;

@Controller
public class WriteController {

	@Autowired
	EssayServiceImpl Eservice;
	
	//에세이 쓰기
	@RequestMapping(value="essay_wrt")
	public String essay_wrt(HttpServletRequest req, Model model) {
		System.out.println("essay_wrt()");
		
		return "story/essay/essay_wrt";
	}
	
	//에세이 쓰기
	@RequestMapping(value="essayPro")
	public String essayPro(MultipartHttpServletRequest req, Model model) {
		System.out.println("essayPro()");
		
		Eservice.inserEssay(req, model);
		
		return "story/essay/essayPro";
	}
	
	//리뷰쓰기
	@RequestMapping(value="reviewForm")
	public String reviewForm(HttpServletRequest req, Model model) {
		System.out.println("reviewForm()");
		
		return "story/review/reviewForm";
	}
	
	//리뷰장소검색
	@RequestMapping(value="reviewSearch")
	public String reviewSearch(HttpServletRequest req, Model model) {
		
		Eservice.reviewSearch(req, model);
		//ArrayList<WhereVO> dtos = (ArrayList<WhereVO>)req.getAttribute("dtos");
		
		return "story/review/searchResult";
	}
	
	//리뷰 저장 처리
	@RequestMapping(value="reviewPro")
	public String reviewPro(MultipartHttpServletRequest req, Model model) {
		System.out.println("reviewPro()");
		
		Eservice.reviewPro(req, model);
		
		return "story/review/reviewPro";
	}
}
