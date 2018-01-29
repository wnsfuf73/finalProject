package kos.triple.project.service.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface RecommendService {
	//관광테마
	public void tourismSearch(HttpServletRequest req, Model model);
	
	//맛집테마추천목록
	public void restaurantSearch(HttpServletRequest req, Model model);
	
	//레져테마추천목록
	public void leisureSearch(HttpServletRequest req, Model model);
	
	//힐링테마추천목록
	public void healingSearch(HttpServletRequest req, Model model);
	
	//좋아요순테마추천목록
	public void likegSearch(HttpServletRequest req, Model model);
	
	//조회수순테마추천목록
	public void countSearch(HttpServletRequest req, Model model);
}
