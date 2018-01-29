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

	/* �Խ�Ʈ */
	
	//�Խ��� ����
	@RequestMapping(value = "boardList")
	public String boardList(HttpServletRequest req, Model model) {
		System.out.println("boardList()");
		
		service.getMyQnAList(req,model);
		
		return "board/boardList";

	}
	
	
	//�������������� �Խ��� ����
	@RequestMapping(value = "myPageBoardList")
	public String myPageBoardList(HttpServletRequest req, Model model) {
		System.out.println("boardList()");
		
		service.getMyQnAList(req,model);
		
		model.addAttribute("setIframe","boardList");
				
		return "mypage/myPageStart";

	}
	
	//�۾�����
	@RequestMapping(value = "boardWriteForm")
	public String boardWriteForm(HttpServletRequest req, Model model) {
		System.out.println("boardWriteForm()");
		
		return "board/boardWriteForm";
	}
	
	//�۾���ó��
	@RequestMapping(value = "boardWritePro")
	public String boardWritePro(HttpServletRequest req, Model model) {
		System.out.println("boardWritePro()");
		
		service.boardWritePro(req,model);
		
		return "pro/heePro/boardWritePro";
	}
	
	//�ۻ󼼺���
	@RequestMapping(value = "boardDetail")
	public String boardDetail(HttpServletRequest req, Model model) {
		System.out.println("boardDetail()");
		
		service.boardDetail(req,model);
		
		return "board/boardDetail";
	}
	
	//�ۻ���
	@RequestMapping(value = "deleteBoard")
	public String deleteBoard(HttpServletRequest req, Model model) {
		System.out.println("deleteBoard()");
		
		service.deleteBoard(req,model);
		
		return "pro/heePro/deleteBoardPro";
	}
	
	//�Խñ� ��ȸ�� ����
	@RequestMapping(value = "increaseCount")
	public @ResponseBody String increaseCount(HttpServletRequest req, Model model) {
		System.out.println("deleteBoard()");
		
		service.increaseCount(req,model);
		String cnt = (String)req.getAttribute("cnt");
		
		return cnt;
	}
	
	//�۰˻�
	@RequestMapping(value = "boardGuestSearchPro")
	public String boardGuestSearchPro(HttpServletRequest req, Model model) {
		System.out.println("boardGuestSearchPro()");
		
		service.boardGuestSearchPro(req, model);
		
		return "pro/heePro/boardGuestSearchPro";
	}
	
	
	/* �Խ�Ʈ */
	
	
	/* ȣ��Ʈ */
	
	//���� & QnA ���� ����
	@RequestMapping(value = "boardManager")
	public String boardManager(HttpServletRequest req, Model model) {
		System.out.println("boardManager()");
		
		service.getNoticeList(req,model);
		service.getQnAList(req, model);
		
		return "main/adminMain/board/boardManagerStart";
	}
	
	//�������������� �̵�
	@RequestMapping(value = "noticeWriteForm")
	public String noticeWriteForm(HttpServletRequest req, Model model) {
		System.out.println("noticeWriteForm()");
		
		return "main/adminMain/board/noticeWriteForm";
	}
	
	//�������� ó��
	@RequestMapping(value = "noticeWritePro")
	public String noticeWritePro(HttpServletRequest req, Model model) {
		System.out.println("noticeWritePro()");
		
		service.noticeWritePro(req,model);
		
		return "pro/heePro/noticeWritePro";
	
	}
	
	//�������� ��������
	@RequestMapping(value = "noticeDetail")
	public String noticeDetail(HttpServletRequest req, Model model) {
		System.out.println("noticeDetail()");
		service.noticeDetail(req,model);
		return "main/adminMain/board/noticeDetail";
	
	}
	
	//�������� ����
	@RequestMapping(value="noticeModifyPro")
	public @ResponseBody String noticeModifyPro(HttpServletRequest req, Model model) {
		System.out.println("noticeModifyPro()");
		
		service.noticeModifyPro(req,model);
		String cnt = req.getAttribute("cnt").toString(); 
		return cnt;
	
	}
	
	//�������� ���������� ���������ΰ���
	@RequestMapping(value = "boardSelectDetail")
	public String boardSelectDetail(HttpServletRequest req, Model model) {
		System.out.println("boardSelectDetail()");
		
		service.boardDetail(req,model);
		return "main/adminMain/board/boardSelectDetail";
		
	}
	
	//�ۿ����� ����� �ۼ�.
	@RequestMapping(value = "answerWriteProc")
	public ModelAndView answerWriteProc(HttpServletRequest req, Model model) {
		System.out.println("answerWriteProc()");
		
		service.answerWriteProc(req,model);
		
		RedirectView rd = new RedirectView("boardManager");
		ModelAndView mav = new ModelAndView();
		mav.setView(rd);
		
		return mav;
		
	}
	
	
	/* ȣ��Ʈ */
	
}
