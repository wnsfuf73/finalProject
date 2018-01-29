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

	//���䰹�����ϱ�
	@Override
	public int getReviewCnt(String mem_id) {
		int cnt = 0;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.getReviewCnt(mem_id);
		
		return cnt;
	}

	//���� ��� ��ȸ
	@Override
	public ArrayList<ReviewVO> getReviewList(Map<String, Object> map) {
		ArrayList<ReviewVO> dtos = null;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		dtos = dao.getReviewList(map);
		
		return dtos;
	}
	
	//�������
	@Override
	public int reviewDelete(int reviewNo) {
		int cnt = 0;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.reviewDelete(reviewNo);
		System.out.println("deleteCnt : "+cnt);
		
		return cnt;
	}

	//�����̰������ϱ�
	@Override
	public int getEssayCnt(String mem_id) {
		int cnt = 0;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.getEssayCnt(mem_id);
		
		return cnt;
	}

	//������ ��� ��ȸ
	@Override
	public ArrayList<EssayVO> getEssayList(Map<String, Object> map) {
		ArrayList<EssayVO> dtos = null;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		dtos = dao.getEssayList(map);
		
		return dtos;
	}

	//������ �󼼺���
	@Override
	public EssayVO getEssayContent(int essayNo) {
		//�ٱ��� ����
		EssayVO dto = new EssayVO();
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		dto = dao.getEssayContent(essayNo);
		
		return dto;
	}
	
	//�����̴�۵��
	@Override
	public int insertReply(EssayVO dto) {
		int cnt = 0;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.insertReply(dto);
		
		return cnt;
	}
	
	//��� ��� ��ȸ
	@Override
	public ArrayList<EssayVO> replyList(int essayNo) {
		ArrayList<EssayVO> dtos = null;
		
		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		dtos = dao.replyList(essayNo);
		
		return dtos;
	}

	//������ ������ ��� ��� ��ȸ 
	@Override
	public int delReplyList(int essayNo) {
		int cnt = 0;

		MypageDAO dao = sqlSession.getMapper(MypageDAO.class);
		cnt = dao.delReplyList(essayNo);
		
		return cnt;
	}
	
	//������ ����
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
