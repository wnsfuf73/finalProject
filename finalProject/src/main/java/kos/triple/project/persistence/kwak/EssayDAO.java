package kos.triple.project.persistence.kwak;

import java.util.ArrayList;

import kos.triple.project.vo.EssayVO;
import kos.triple.project.vo.ReviewVO;
import kos.triple.project.vo.WhereVO;

public interface EssayDAO {

	//������ �߰�
	public int insertEssay(EssayVO dto);
	
	//��Ұ˻�
	public ArrayList<WhereVO> reviewSearch(String reviewSearch);
	
	//��������
	public int insertReview(ReviewVO dto);
}
