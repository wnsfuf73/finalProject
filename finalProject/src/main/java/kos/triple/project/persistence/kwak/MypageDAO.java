package kos.triple.project.persistence.kwak;

import java.util.ArrayList;
import java.util.Map;

import kos.triple.project.vo.EssayVO;
import kos.triple.project.vo.ReviewVO;

public interface MypageDAO {
	
	//���䰹�����ϱ�
	public int getReviewCnt(String mem_id);

	//���� ��� ��ȸ
	public ArrayList<ReviewVO> getReviewList(Map<String, Object> map);
	
	//�������
	public int reviewDelete(int reviewNo);
	
	//�����̰������ϱ�
	public int getEssayCnt(String mem_id);
	
	//���� ��� ��ȸ
	public ArrayList<EssayVO> getEssayList(Map<String, Object> map);
	
	//������ �󼼺���
	public EssayVO getEssayContent(int essayNo);
	
	//�����̴�۵��
	public int insertReply(EssayVO dto);
	
	//��� ��� ��ȸ
	public ArrayList<EssayVO> replyList(int essayNo);

	//������ ������ ��� ��� ��ȸ
	public int delReplyList(int essayNo);
	
	//������ ����
	public int essayDelete(int essayNo);
}
