package kos.triple.project.service.hee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BoardService {

	/* 게스트 */
	
	//게시글쓰기를 처리한다.
	void boardWritePro(HttpServletRequest req, Model model);

	//내가 작성한 문의 글들을 가져온다.
	void getMyQnAList(HttpServletRequest req, Model model);

	//작성한 글의 상세페이지
	void boardDetail(HttpServletRequest req, Model model);

	//작성글을 삭제한다.
	void deleteBoard(HttpServletRequest req, Model model);

	//게시글 조회수 증가
	void increaseCount(HttpServletRequest req, Model model);

	// 검색
	void boardGuestSearchPro(HttpServletRequest req, Model model);
	
	/* 게스트 */
	
	
	/* 호스트 */
	
	//공지사항을 가져온다.
	void getNoticeList(HttpServletRequest req, Model model);
	
	//질문글을 가져온다.
	void getQnAList(HttpServletRequest req, Model model);

	//공지 쓰기를 처리한다.
	void noticeWritePro(HttpServletRequest req, Model model);
	
	//답글 쓰기를 처리한다.
	void answerWriteProc(HttpServletRequest req, Model model);

	//공지글을 가져온다.
	void noticeDetail(HttpServletRequest req, Model model);

	//공지사항을 수정한다.
	void noticeModifyPro(HttpServletRequest req, Model model);

	
	/* 호스트 */
	
}
