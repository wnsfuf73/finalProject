package kos.triple.project.persistence.kwak;

import java.util.ArrayList;

import kos.triple.project.vo.EssayVO;
import kos.triple.project.vo.ReviewVO;
import kos.triple.project.vo.WhereVO;

public interface EssayDAO {

	//에세이 추가
	public int insertEssay(EssayVO dto);
	
	//장소검색
	public ArrayList<WhereVO> reviewSearch(String reviewSearch);
	
	//리뷰저장
	public int insertReview(ReviewVO dto);
}
