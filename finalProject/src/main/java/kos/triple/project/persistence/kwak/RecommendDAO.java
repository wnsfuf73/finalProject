package kos.triple.project.persistence.kwak;

import java.util.ArrayList;

import kos.triple.project.vo.RecommendVO;

public interface RecommendDAO {
	
	//관광테마 검색
	public ArrayList<RecommendVO> tourismSearch(String category);
	
	//맛집테마 검색
	public ArrayList<RecommendVO> restaurantSearch(String category);
	
	//레져테마 검색
	public ArrayList<RecommendVO> leisureSearch(String category);
	
	//힐링테마 검색
	public ArrayList<RecommendVO> healingSearch(String category);
	
	//좋아요순테마 검색
	public ArrayList<RecommendVO> likeSearch();
	
	//조회수순테마 검색
	public ArrayList<RecommendVO> countSearch();
}
