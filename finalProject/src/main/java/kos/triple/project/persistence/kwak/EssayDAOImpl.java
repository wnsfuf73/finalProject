package kos.triple.project.persistence.kwak;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.EssayVO;
import kos.triple.project.vo.ReviewVO;
import kos.triple.project.vo.WhereVO;

@Repository
public class EssayDAOImpl implements EssayDAO {
	
	@Autowired
	private SqlSession sqlSession;

	//������ �߰�
	@Override
	public int insertEssay(EssayVO dto) {
		int cnt=0;
		
		EssayDAO dao = sqlSession.getMapper(EssayDAO.class);
		cnt = dao.insertEssay(dto);
		
		return cnt;
	}

	//��Ұ˻�
	@Override
	public ArrayList<WhereVO> reviewSearch(String reviewSearch) {
		//ū�ٱ���
		ArrayList<WhereVO> dtos = null;
		
		EssayDAO dao = sqlSession.getMapper(EssayDAO.class);
		dtos = dao.reviewSearch(reviewSearch);
		
		return dtos;
	}

	//��������
	@Override
	public int insertReview(ReviewVO dto) {
		int cnt = 0;
		
		EssayDAO dao = sqlSession.getMapper(EssayDAO.class);
		cnt = dao.insertReview(dto);
		
		return cnt;
	}



}
