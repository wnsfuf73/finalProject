package kos.triple.project.service.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MypageService {
	
	//리뷰목록
	public void inventoryReviewList(HttpServletRequest req, Model model);
	
	//리뷰삭제
	public void ReviewDeletePro(HttpServletRequest req, Model model);

	//에세이목록
	public void inventoryEssayList(HttpServletRequest req, Model model);
	
	//에세이상세보기
	public void myEssayContent(HttpServletRequest req, Model model);
	
	//댓글등록
	public void insertReply(HttpServletRequest req, Model model);
	
	//댓글목록보기
	public void replyList(HttpServletRequest req, Model model);
	
	//에세이 삭제
	public void myEssayDelpro(HttpServletRequest req, Model model);
}
