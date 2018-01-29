package kos.triple.project.controller.hee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kos.triple.project.service.hee.BoardService;

@Controller
public class BoardController {

	
	@Autowired
	BoardService service;

	/* 게스트 */
	
	//게시판 진입
	@RequestMapping(value = "boardList")
	public String boardList(HttpServletRequest req, Model model) {
		System.out.println("boardList()");
		
		service.getMyQnAList(req,model);
		
		return "board/boardList";

	}
	
	
	//마이페이지에서 게시판 진입
	@RequestMapping(value = "myPageBoardList")
	public String myPageBoardList(HttpServletRequest req, Model model) {
		System.out.println("boardList()");
		
		service.getMyQnAList(req,model);
		
		model.addAttribute("setIframe","boardList");
				
		return "mypage/myPageStart";

	}
	
	//글쓰기폼
	@RequestMapping(value = "boardWriteForm")
	public String boardWriteForm(HttpServletRequest req, Model model) {
		System.out.println("boardWriteForm()");
		
		return "board/boardWriteForm";
	}
	
	//글쓰기처리
	@RequestMapping(value = "boardWritePro")
	public String boardWritePro(HttpServletRequest req, Model model) {
		System.out.println("boardWritePro()");
		
		service.boardWritePro(req,model);
		
		return "pro/heePro/boardWritePro";
	}
	
	//글상세보기
	@RequestMapping(value = "boardDetail")
	public String boardDetail(HttpServletRequest req, Model model) {
		System.out.println("boardDetail()");
		
		service.boardDetail(req,model);
		
		return "board/boardDetail";
	}
	
	//글삭제
	@RequestMapping(value = "deleteBoard")
	public String deleteBoard(HttpServletRequest req, Model model) {
		System.out.println("deleteBoard()");
		
		service.deleteBoard(req,model);
		
		return "pro/heePro/deleteBoardPro";
	}
	
	//게시글 조회수 증가
	@RequestMapping(value = "increaseCount")
	public @ResponseBody String increaseCount(HttpServletRequest req, Model model) {
		System.out.println("deleteBoard()");
		
		service.increaseCount(req,model);
		String cnt = (String)req.getAttribute("cnt");
		
		return cnt;
	}
	
	//글검색
	@RequestMapping(value = "boardGuestSearchPro")
	public String boardGuestSearchPro(HttpServletRequest req, Model model) {
		System.out.println("boardGuestSearchPro()");
		
		service.boardGuestSearchPro(req, model);
		
		return "pro/heePro/boardGuestSearchPro";
	}
	
	
	/* 게스트 */
	
	
	/* 호스트 */
	
	//공지 & QnA 관리 진입
	@RequestMapping(value = "boardManager")
	public String boardManager(HttpServletRequest req, Model model) {
		System.out.println("boardManager()");
		
		service.getNoticeList(req,model);
		service.getQnAList(req, model);
		
		return "main/adminMain/board/boardManagerStart";
	}
	
	//공지쓰기폼으로 이동
	@RequestMapping(value = "noticeWriteForm")
	public String noticeWriteForm(HttpServletRequest req, Model model) {
		System.out.println("noticeWriteForm()");
		
		return "main/adminMain/board/noticeWriteForm";
	}
	
	//공지쓰기 처리
	@RequestMapping(value = "noticeWritePro")
	public String noticeWritePro(HttpServletRequest req, Model model) {
		System.out.println("noticeWritePro()");
		
		service.noticeWritePro(req,model);
		
		return "pro/heePro/noticeWritePro";
	
	}
	
	//공지사항 상세페이지
	@RequestMapping(value = "noticeDetail")
	public String noticeDetail(HttpServletRequest req, Model model) {
		System.out.println("noticeDetail()");
		service.noticeDetail(req,model);
		return "main/adminMain/board/noticeDetail";
	
	}
	
	//공지사항 수정
	@RequestMapping(value="noticeModifyPro")
	public @ResponseBody String noticeModifyPro(HttpServletRequest req, Model model) {
		System.out.println("noticeModifyPro()");
		
		service.noticeModifyPro(req,model);
		String cnt = req.getAttribute("cnt").toString(); 
		return cnt;
	
	}
	
	//질문글을 선택했을때 상세페이지로간다
	@RequestMapping(value = "boardSelectDetail")
	public String boardSelectDetail(HttpServletRequest req, Model model) {
		System.out.println("boardSelectDetail()");
		
		service.boardDetail(req,model);
		return "main/adminMain/board/boardSelectDetail";
		
	}
	
	//글에대한 답글을 작성.
	@RequestMapping(value = "answerWriteProc")
	public ModelAndView answerWriteProc(HttpServletRequest req, Model model) {
		System.out.println("answerWriteProc()");
		
		service.answerWriteProc(req,model);
		
		RedirectView rd = new RedirectView("boardManager");
		ModelAndView mav = new ModelAndView();
		mav.setView(rd);
		
		return mav;
		
	}
	
	
	/* 호스트 */
	
}
