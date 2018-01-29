package kos.triple.project.persistence.hee;

import java.util.List;
import java.util.Map;

import kos.triple.project.vo.AnswerVO;
import kos.triple.project.vo.BoardVO;
import kos.triple.project.vo.NoticeVO;

public interface BoardDAO {

	/* 게스트 */
	
	//데이터건수를 가져온다.
	public int getCount(Map<String, Object> map);
	
	//글쓰기를 처리한다.
	public int boardWritePro_proc(BoardVO vo);

	//내가 작성한 문의글을 가져온다.
	public List<BoardVO> getMyQnAList(Map<String, Object> map);

	//문의글에대한 답변글을 가져온다.
	public List<AnswerVO> getMyQnaAnswerList(int boardNo);

	//문의글의 상세정보를 가져온다.
	public BoardVO getMyQnaDetail(int boardNo);

	//등록글을 삭제한다.
	public int deleteBoard_proc(int boardNo);

	//게시글의 조회수를 증가한다.
	public int increaseCount_proc(int boardNo);
	
	// 검색
	public List<BoardVO> boardGuestSearchPro(Map<String, Object> map);

	/* 게스트 */
	
	
	/* 호스트 */
	
	//공지사항을 가져온다
	public List<NoticeVO> getNoticeList(Map<String, Object> map);

	//공지사항 쓰기를 처리한다.
	public int noticeWritePro_proc(NoticeVO vo);

	//게스트의 질문글을 가져온다.
	public List<BoardVO> getQnAList_proc(Map<String, Object> map);

	//답글을 한다.
	public int answerWriteProc_proc(AnswerVO vo);
	
	//질문글의 답글수를 증가시킨다.
	public int updateBoardCount(int boardNo);

	//공지사항을 가져온다.
	public NoticeVO noticeDetail_proc(int noticeNo);

	//공지사항을 수정한다.
	public int noticeModifyPro_proc(NoticeVO vo);

	/* 호스트 */
	
	
}
