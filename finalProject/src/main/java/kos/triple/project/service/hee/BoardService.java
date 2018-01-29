package kos.triple.project.service.hee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BoardService {

	/* �Խ�Ʈ */
	
	//�Խñ۾��⸦ ó���Ѵ�.
	void boardWritePro(HttpServletRequest req, Model model);

	//���� �ۼ��� ���� �۵��� �����´�.
	void getMyQnAList(HttpServletRequest req, Model model);

	//�ۼ��� ���� ��������
	void boardDetail(HttpServletRequest req, Model model);

	//�ۼ����� �����Ѵ�.
	void deleteBoard(HttpServletRequest req, Model model);

	//�Խñ� ��ȸ�� ����
	void increaseCount(HttpServletRequest req, Model model);

	// �˻�
	void boardGuestSearchPro(HttpServletRequest req, Model model);
	
	/* �Խ�Ʈ */
	
	
	/* ȣ��Ʈ */
	
	//���������� �����´�.
	void getNoticeList(HttpServletRequest req, Model model);
	
	//�������� �����´�.
	void getQnAList(HttpServletRequest req, Model model);

	//���� ���⸦ ó���Ѵ�.
	void noticeWritePro(HttpServletRequest req, Model model);
	
	//��� ���⸦ ó���Ѵ�.
	void answerWriteProc(HttpServletRequest req, Model model);

	//�������� �����´�.
	void noticeDetail(HttpServletRequest req, Model model);

	//���������� �����Ѵ�.
	void noticeModifyPro(HttpServletRequest req, Model model);

	
	/* ȣ��Ʈ */
	
}
