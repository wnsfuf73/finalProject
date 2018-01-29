package kos.triple.project.persistence.kwak;

import java.util.ArrayList;

import kos.triple.project.vo.RecommendVO;

public interface RecommendDAO {
	
	//�����׸� �˻�
	public ArrayList<RecommendVO> tourismSearch(String category);
	
	//�����׸� �˻�
	public ArrayList<RecommendVO> restaurantSearch(String category);
	
	//�����׸� �˻�
	public ArrayList<RecommendVO> leisureSearch(String category);
	
	//�����׸� �˻�
	public ArrayList<RecommendVO> healingSearch(String category);
	
	//���ƿ���׸� �˻�
	public ArrayList<RecommendVO> likeSearch();
	
	//��ȸ�����׸� �˻�
	public ArrayList<RecommendVO> countSearch();
}
