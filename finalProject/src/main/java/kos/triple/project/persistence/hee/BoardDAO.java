package kos.triple.project.persistence.hee;

import java.util.List;
import java.util.Map;

import kos.triple.project.vo.AnswerVO;
import kos.triple.project.vo.BoardVO;
import kos.triple.project.vo.NoticeVO;

public interface BoardDAO {

	/* �Խ�Ʈ */
	
	//�����ͰǼ��� �����´�.
	public int getCount(Map<String, Object> map);
	
	//�۾��⸦ ó���Ѵ�.
	public int boardWritePro_proc(BoardVO vo);

	//���� �ۼ��� ���Ǳ��� �����´�.
	public List<BoardVO> getMyQnAList(Map<String, Object> map);

	//���Ǳۿ����� �亯���� �����´�.
	public List<AnswerVO> getMyQnaAnswerList(int boardNo);

	//���Ǳ��� �������� �����´�.
	public BoardVO getMyQnaDetail(int boardNo);

	//��ϱ��� �����Ѵ�.
	public int deleteBoard_proc(int boardNo);

	//�Խñ��� ��ȸ���� �����Ѵ�.
	public int increaseCount_proc(int boardNo);
	
	// �˻�
	public List<BoardVO> boardGuestSearchPro(Map<String, Object> map);

	/* �Խ�Ʈ */
	
	
	/* ȣ��Ʈ */
	
	//���������� �����´�
	public List<NoticeVO> getNoticeList(Map<String, Object> map);

	//�������� ���⸦ ó���Ѵ�.
	public int noticeWritePro_proc(NoticeVO vo);

	//�Խ�Ʈ�� �������� �����´�.
	public List<BoardVO> getQnAList_proc(Map<String, Object> map);

	//����� �Ѵ�.
	public int answerWriteProc_proc(AnswerVO vo);
	
	//�������� ��ۼ��� ������Ų��.
	public int updateBoardCount(int boardNo);

	//���������� �����´�.
	public NoticeVO noticeDetail_proc(int noticeNo);

	//���������� �����Ѵ�.
	public int noticeModifyPro_proc(NoticeVO vo);

	/* ȣ��Ʈ */
	
	
}
