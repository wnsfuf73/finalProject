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
	
	//��õ����
	@RequestMapping(value="recommend")
	public String recommend(HttpServletRequest req, Model model) {
		System.out.println("recommend()");
		
		return "main/recommend/recommend";
	}
	
	//�����׸���õ���
	@RequestMapping(value="tourism_thema")
	public String tourism_thema(HttpServletRequest req, Model model) {
		System.out.println("tourism_thema()");
		
		Rservice.tourismSearch(req, model);
		
		return "main/recommend/tourism_thema";
	}
	
	//�����׸���õ���
	@RequestMapping(value="restaurant_thema")
	public String restaurant_thema(HttpServletRequest req, Model model) {
		System.out.println("restaurant_thema()");
		
		Rservice.restaurantSearch(req, model);
		
		return "main/recommend/restaurant_thema";
	}
	
	//�����׸���õ���
	@RequestMapping(value="leisure_thema")
	public String leisure_thema(HttpServletRequest req, Model model) {
		System.out.println("leisure_thema()");
		
		Rservice.leisureSearch(req, model);
		
		return "main/recommend/leisure_thema";
	}
	
	//�����׸���õ���
	@RequestMapping(value="healing_thema")
	public String healing_thema(HttpServletRequest req, Model model) {
		System.out.println("healing_thema()");
		
		Rservice.healingSearch(req, model);
		
		return "main/recommend/healing_thema";
	}
	
	//���ƿ���׸���õ���
	@RequestMapping(value="like_thema")
	public String like_thema(HttpServletRequest req, Model model) {
		System.out.println("like_thema()");
		
		Rservice.healingSearch(req, model);
		
		return "main/recommend/like_thema";
	}
		
	//��ȸ�����׸���õ���
	@RequestMapping(value="count_thema")
	public String count_thema(HttpServletRequest req, Model model) {
		System.out.println("count_thema()");
		
		Rservice.healingSearch(req, model);
		
		return "main/recommend/count_thema";
	}
}
