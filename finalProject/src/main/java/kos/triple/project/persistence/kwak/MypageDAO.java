package kos.triple.project.persistence.kwak;

import java.util.ArrayList;
import java.util.Map;

import kos.triple.project.vo.EssayVO;
import kos.triple.project.vo.ReviewVO;

public interface MypageDAO {
	
	//리뷰갯수구하기
	public int getReviewCnt(String mem_id);

	//리뷰 목록 조회
	public ArrayList<ReviewVO> getReviewList(Map<String, Object> map);
	
	//리뷰삭제
	public int reviewDelete(int reviewNo);
	
	//에세이갯수구하기
	public int getEssayCnt(String mem_id);
	
	//리뷰 목록 조회
	public ArrayList<EssayVO> getEssayList(Map<String, Object> map);
	
	//에세이 상세보기
	public EssayVO getEssayContent(int essayNo);
	
	//에세이댓글등록
	public int insertReply(EssayVO dto);
	
	//댓글 목록 조회
	public ArrayList<EssayVO> replyList(int essayNo);

	//에세이 삭제용 댓글 목록 조회
	public int delReplyList(int essayNo);
	
	//에세이 삭제
	public int essayDelete(int essayNo);
}
