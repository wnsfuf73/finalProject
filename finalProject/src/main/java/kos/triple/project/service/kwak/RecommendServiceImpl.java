package kos.triple.project.service.kwak;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kos.triple.project.persistence.kwak.RecommendDAO;
import kos.triple.project.vo.RecommendVO;

@Service
public class RecommendServiceImpl implements RecommendService {
	
	@Autowired
	RecommendDAO dao;

	//관광테마
	@Override
	public void tourismSearch(HttpServletRequest req, Model model) {
		String category = "travel";
		
		ArrayList<RecommendVO> dtos = dao.tourismSearch(category);
		model.addAttribute("dtos",dtos);
	}

	//맛집테마추천목록
	@Override
	public void restaurantSearch(HttpServletRequest req, Model model) {
		String category = "eat";
		
		ArrayList<RecommendVO> dtos = dao.restaurantSearch(category);
		model.addAttribute("dtos",dtos);
		
	}

	//레져테마추천목록
	@Override
	public void leisureSearch(HttpServletRequest req, Model model) {
		String category = "leisure";
		
		ArrayList<RecommendVO> dtos = dao.leisureSearch(category);
		model.addAttribute("dtos",dtos);
		
	}

	//레져테마추천목록
	@Override
	public void healingSearch(HttpServletRequest req, Model model) {
		String category = "healing";
		
		ArrayList<RecommendVO> dtos = dao.healingSearch(category);
		model.addAttribute("dtos",dtos);
		
	}

	//좋아요순테마추천목록
	@Override
	public void likegSearch(HttpServletRequest req, Model model) {
		
		ArrayList<RecommendVO> dtos = dao.likeSearch();
		model.addAttribute("dtos",dtos);
		
	}

	//조회수순테마추천목록
	@Override
	public void countSearch(HttpServletRequest req, Model model) {
		
		ArrayList<RecommendVO> dtos = dao.countSearch();
		model.addAttribute("dtos",dtos);
		
	}
}
