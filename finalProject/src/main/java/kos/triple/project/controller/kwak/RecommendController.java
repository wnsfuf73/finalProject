package kos.triple.project.controller.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kos.triple.project.service.kwak.RecommendServiceImpl;

@Controller
public class RecommendController {

	@Autowired
	RecommendServiceImpl Rservice;
	
	//추천시작
	@RequestMapping(value="recommend")
	public String recommend(HttpServletRequest req, Model model) {
		System.out.println("recommend()");
		
		return "main/recommend/recommend";
	}
	
	//관광테마추천목록
	@RequestMapping(value="tourism_thema")
	public String tourism_thema(HttpServletRequest req, Model model) {
		System.out.println("tourism_thema()");
		
		Rservice.tourismSearch(req, model);
		
		return "main/recommend/tourism_thema";
	}
	
	//맛집테마추천목록
	@RequestMapping(value="restaurant_thema")
	public String restaurant_thema(HttpServletRequest req, Model model) {
		System.out.println("restaurant_thema()");
		
		Rservice.restaurantSearch(req, model);
		
		return "main/recommend/restaurant_thema";
	}
	
	//레져테마추천목록
	@RequestMapping(value="leisure_thema")
	public String leisure_thema(HttpServletRequest req, Model model) {
		System.out.println("leisure_thema()");
		
		Rservice.leisureSearch(req, model);
		
		return "main/recommend/leisure_thema";
	}
	
	//힐링테마추천목록
	@RequestMapping(value="healing_thema")
	public String healing_thema(HttpServletRequest req, Model model) {
		System.out.println("healing_thema()");
		
		Rservice.healingSearch(req, model);
		
		return "main/recommend/healing_thema";
	}
	
	//좋아요순테마추천목록
	@RequestMapping(value="like_thema")
	public String like_thema(HttpServletRequest req, Model model) {
		System.out.println("like_thema()");
		
		Rservice.healingSearch(req, model);
		
		return "main/recommend/like_thema";
	}
		
	//조회수순테마추천목록
	@RequestMapping(value="count_thema")
	public String count_thema(HttpServletRequest req, Model model) {
		System.out.println("count_thema()");
		
		Rservice.healingSearch(req, model);
		
		return "main/recommend/count_thema";
	}
}
