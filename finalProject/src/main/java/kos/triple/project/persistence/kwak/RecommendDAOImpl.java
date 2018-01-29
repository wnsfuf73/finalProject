package kos.triple.project.persistence.kwak;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.RecommendVO;

@Repository
public class RecommendDAOImpl implements RecommendDAO{

	@Autowired
	private SqlSession sqlSession;

	//�����׸� �˻�
	@Override
	public ArrayList<RecommendVO> tourismSearch(String category) {
		ArrayList<RecommendVO> dtos = null;
		
		RecommendDAO dao = sqlSession.getMapper(RecommendDAO.class);
		dtos = dao.tourismSearch(category);
		
		return dtos;
	}

	//�����׸� �˻�
	@Override
	public ArrayList<RecommendVO> restaurantSearch(String category) {
		
		ArrayList<RecommendVO> dtos = null;
		
		RecommendDAO dao = sqlSession.getMapper(RecommendDAO.class);
		dtos = dao.restaurantSearch(category);
		
		return dtos;
	}

	//�����׸� �˻�
	@Override
	public ArrayList<RecommendVO> leisureSearch(String category) {
		
		ArrayList<RecommendVO> dtos = null;
		
		RecommendDAO dao = sqlSession.getMapper(RecommendDAO.class);
		dtos = dao.leisureSearch(category);
		
		return dtos;
	}

	//�����׸� �˻�
	@Override
	public ArrayList<RecommendVO> healingSearch(String category) {
		ArrayList<RecommendVO> dtos = null;
		
		RecommendDAO dao = sqlSession.getMapper(RecommendDAO.class);
		dtos = dao.healingSearch(category);
		
		return dtos;
	}

	//���ƿ���׸� �˻�
	@Override
	public ArrayList<RecommendVO> likeSearch() {
		ArrayList<RecommendVO> dtos = null;
		
		RecommendDAO dao = sqlSession.getMapper(RecommendDAO.class);
		dtos = dao.likeSearch();
		
		return dtos;
	}

	//��ȸ�����׸� �˻�
	@Override
	public ArrayList<RecommendVO> countSearch() {
		ArrayList<RecommendVO> dtos = null;
		
		RecommendDAO dao = sqlSession.getMapper(RecommendDAO.class);
		dtos = dao.countSearch();
		
		return dtos;
	}
}
