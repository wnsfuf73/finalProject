package kos.triple.project.persistence.kwak;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.EssayVO;
import kos.triple.project.vo.ReviewVO;

@Repository
public class MypageDAOImpl implements MypageDAO{
	
	@Autowired
	private SqlSession sqlSession;

	//리뷰갯수구하기
	@Override
	public int getReviewCnt(String mem_id) {
		int cnt = 0;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.getReviewCnt(mem_id);
		
		return cnt;
	}

	//리뷰 목록 조회
	@Override
	public ArrayList<ReviewVO> getReviewList(Map<String, Object> map) {
		ArrayList<ReviewVO> dtos = null;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		dtos = dao.getReviewList(map);
		
		return dtos;
	}
	
	//리뷰삭제
	@Override
	public int reviewDelete(int reviewNo) {
		int cnt = 0;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.reviewDelete(reviewNo);
		System.out.println("deleteCnt : "+cnt);
		
		return cnt;
	}

	//에세이갯수구하기
	@Override
	public int getEssayCnt(String mem_id) {
		int cnt = 0;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.getEssayCnt(mem_id);
		
		return cnt;
	}

	//에세이 목록 조회
	@Override
	public ArrayList<EssayVO> getEssayList(Map<String, Object> map) {
		ArrayList<EssayVO> dtos = null;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		dtos = dao.getEssayList(map);
		
		return dtos;
	}

	//에세이 상세보기
	@Override
	public EssayVO getEssayContent(int essayNo) {
		//바구니 생성
		EssayVO dto = new EssayVO();
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		dto = dao.getEssayContent(essayNo);
		
		return dto;
	}
	
	//에세이댓글등록
	@Override
	public int insertReply(EssayVO dto) {
		int cnt = 0;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.insertReply(dto);
		
		return cnt;
	}
	
	//댓글 목록 조회
	@Override
	public ArrayList<EssayVO> replyList(int essayNo) {
		ArrayList<EssayVO> dtos = null;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		dtos = dao.replyList(essayNo);
		
		return dtos;
	}

	//에세이 삭제용 댓글 목록 조회 
	@Override
	public int delReplyList(int essayNo) {
		int cnt = 0;

		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.delReplyList(essayNo);
		
		return cnt;
	}
	
	//에세이 삭제
	@Override
	public int essayDelete(int essayNo) {
		int cnt = 0;
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		
		int chkCnt = dao.delReplyList(essayNo);
		
		if(chkCnt != 0) {
			cnt = -1;
		}else {
			cnt = dao.essayDelete(essayNo);
		}
		System.out.println("essaydel : "+cnt);
		return cnt;
	}

}
