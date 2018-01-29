package kos.triple.project.persistence.hee;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.AnswerVO;
import kos.triple.project.vo.BoardVO;
import kos.triple.project.vo.NoticeVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	/* 게스트 */
	
	@Override //글쓰기를 처리한다.
	public int boardWritePro_proc(BoardVO vo) {
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.boardWritePro_proc(vo);
	
	}

	@Override
	public List<BoardVO> getMyQnAList(Map<String, Object> map) {

		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.getMyQnAList(map);
	
	}

	@Override
	public List<AnswerVO> getMyQnaAnswerList(int boardNo) {
	
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		
		return dao.getMyQnaAnswerList(boardNo);

	}

	@Override
	public int getCount(Map<String, Object> map) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.getCount(map);
	}

	@Override
	public BoardVO getMyQnaDetail(int boardNo) {
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.getMyQnaDetail(boardNo);
	}

	@Override
	public int deleteBoard_proc(int boardNo) {
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.deleteBoard_proc(boardNo);
	
	}

	@Override
	public int increaseCount_proc(int boardNo) {
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.increaseCount_proc(boardNo);
	
	}
	
	// 추가==> 검색
	@Override
	public List<BoardVO> boardGuestSearchPro(Map<String, Object> map) {
		
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.boardGuestSearchPro(map);
	}

	/* 게스트 */

	/* 호스트 */
	
	@Override
	public List<NoticeVO> getNoticeList(Map<String, Object> map) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.getNoticeList(map);
	}

	@Override
	public int noticeWritePro_proc(NoticeVO vo) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.noticeWritePro_proc(vo);
	}

	@Override
	public List<BoardVO> getQnAList_proc(Map<String, Object> map) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.getQnAList_proc(map);
	}

	@Override
	public int answerWriteProc_proc(AnswerVO vo) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.answerWriteProc_proc(vo);
	}

	@Override
	public int updateBoardCount(int boardNo) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.updateBoardCount(boardNo);
	}

	@Override
	public NoticeVO noticeDetail_proc(int noticeNo) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.noticeDetail_proc(noticeNo);
	}

	@Override
	public int noticeModifyPro_proc(NoticeVO vo) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.noticeModifyPro_proc(vo);
	}


	

	/* 호스트 */
	
}
