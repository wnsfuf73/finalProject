package kos.triple.project.service.hee;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kos.triple.project.etc.PageCalculator;
import kos.triple.project.persistence.hee.BoardDAO;
import kos.triple.project.vo.AnswerVO;
import kos.triple.project.vo.BoardVO;
import kos.triple.project.vo.NoticeVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO dao;

	/* 게스트 */
	
	@Override //게시글쓰기를 처리한다.
	public void boardWritePro(HttpServletRequest req, Model model) {
		
		String kind = req.getParameter("kind");
		String title = req.getParameter("title");
		String mem_id = req.getParameter("mem_id");
		String content = req.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setBoardNo(0);
		vo.setKind(kind);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMem_id(mem_id);
		vo.setReadCount(0);
		vo.setAnswerCount(0);
		vo.setReg_Date(new Timestamp(new Date().getTime()));
		
		int cnt = dao.boardWritePro_proc(vo);
		model.addAttribute("cnt",cnt);
	}


	@Override //내가 작성한 문의글을 가져온다.
	public void getMyQnAList(HttpServletRequest req, Model model) {

		String requestPage = req.getParameter("requestPage");
		int dataTotalCount = 0;
		int blockSize = 3;
		int contentCount = 10;
		int pageNum = requestPage == null ? 1 : Integer.parseInt(requestPage);
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		if(mem_id==null) {
			req.setAttribute("cnt",0);
			return;
		}
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("method","getMyQnAList");
		map.put("mem_id",mem_id);
		
		dataTotalCount = dao.getCount(map);
		PageCalculator p = new PageCalculator(pageNum, dataTotalCount, blockSize, contentCount);
		
		map.put("start",p.getStart());
		map.put("end",p.getEnd());
		
		List<BoardVO> qnaList = dao.getMyQnAList(map);
		
		model.addAttribute("startPage",p.getStartPage());
		model.addAttribute("endPage",p.getEndPage());
		model.addAttribute("blockStartNumber",p.getBlockStartNumber());
		model.addAttribute("blockEndNumber",p.getBlockEndNumber());
		model.addAttribute("pageNum",p.getRequestPage());
		
		model.addAttribute("qnaList",qnaList);
	}


	@Override
	public void boardDetail(HttpServletRequest req, Model model) {

		String boardNoString = req.getParameter("boardNo");
		String requestPage = req.getParameter("requestPage");
		int boardNo = Integer.parseInt(boardNoString);
		BoardVO vo = dao.getMyQnaDetail(boardNo);
		List<AnswerVO> answerList = dao.getMyQnaAnswerList(boardNo);
		
		model.addAttribute("pageNum",requestPage);
		model.addAttribute("vo",vo);
		model.addAttribute("answerList",answerList);
		
	}

	@Override
	public void deleteBoard(HttpServletRequest req, Model model) {

		String boardNoString = req.getParameter("boardNo");
		String requestPage = req.getParameter("requestPage");
		int boardNo = Integer.parseInt(boardNoString);
		
		int cnt = dao.deleteBoard_proc(boardNo);
		
		model.addAttribute("boardNo",boardNo);
		model.addAttribute("requestPage",requestPage );
		model.addAttribute("cnt",cnt);
	
	}

	@Override
	public void increaseCount(HttpServletRequest req, Model model) {
		
		String boardNoString = req.getParameter("boardNo");
		int boardNo = Integer.parseInt(boardNoString);
		int cnt = dao.increaseCount_proc(boardNo);
		req.setAttribute("cnt",Integer.toString(cnt));
	}
	
	@Override
	public void boardGuestSearchPro(HttpServletRequest req, Model model) {
		
		String requestPage = req.getParameter("requestPage");
		int dataTotalCount = 0;
		int blockSize = 3;
		int contentCount = 10;
		int pageNum = requestPage == null ? 1 : Integer.parseInt(requestPage);
		
		String mem_id = (String) req.getSession().getAttribute("mem_id"); 
	
		List<BoardVO> vos = null;
		
		String selectOpt1 = req.getParameter("selectOpt1");
		String selectOpt2 = req.getParameter("selectOpt2");
		String searchOpt = req.getParameter("searchOpt");
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("method","getMyQnAList");
		map.put("mem_id", mem_id);
		map.put("selectOpt1", selectOpt1);
		map.put("selectOpt2", selectOpt2);
		map.put("searchOpt", searchOpt);
		
		dataTotalCount = dao.getCount(map);
		PageCalculator p = new PageCalculator(pageNum, dataTotalCount, blockSize, contentCount);
		
		map.put("start",p.getStart());
		map.put("end",p.getEnd());
		
		if (dao.boardGuestSearchPro(map) != null) {	
			vos = dao.boardGuestSearchPro(map);
		}
		model.addAttribute("vos", vos);
		model.addAttribute("startPage",p.getStartPage());
		model.addAttribute("endPage",p.getEndPage());
		model.addAttribute("blockStartNumber",p.getBlockStartNumber());
		model.addAttribute("blockEndNumber",p.getBlockEndNumber());
		model.addAttribute("pageNum",p.getRequestPage());
		
	}

	/* 게스트 */
	

	/* 호스트 */

	@Override
	public void getNoticeList(HttpServletRequest req, Model model) {
		
		String requestPage = req.getParameter("requestPage");
		int dataTotalCount = 0;
		int blockSize = 3;
		int contentCount = 10;
		int pageNum = requestPage == null ? 1 : Integer.parseInt(requestPage);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("method","getNoticeList");
		
		dataTotalCount = dao.getCount(map);
		PageCalculator p = new PageCalculator(pageNum, dataTotalCount, blockSize, contentCount);
		
		map.put("start",p.getStart());
		map.put("end",p.getEnd());
		
		
		List<NoticeVO> noticeList = dao.getNoticeList(map);

		model.addAttribute("startPage",p.getStartPage());
		model.addAttribute("endPage",p.getEndPage());
		model.addAttribute("blockStartNumber",p.getBlockStartNumber());
		model.addAttribute("blockEndNumber",p.getBlockEndNumber());
		model.addAttribute("pageNum",p.getRequestPage());
		
		model.addAttribute("noticeList",noticeList);
	}

	
	@Override
	public void getQnAList(HttpServletRequest req, Model model) {
		
		String requestPage = req.getParameter("requestPage");
		int dataTotalCount = 0;
		int blockSize = 3;
		int contentCount = 10;
		int pageNum = requestPage == null ? 1 : Integer.parseInt(requestPage);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("method","getQnAList");
		
		dataTotalCount = dao.getCount(map);
		PageCalculator p = new PageCalculator(pageNum, dataTotalCount, blockSize, contentCount);
		
		map.put("start",p.getStart());
		map.put("end",p.getEnd());
		
		
		List<BoardVO> voList = dao.getQnAList_proc(map);

		model.addAttribute("startPage",p.getStartPage());
		model.addAttribute("endPage",p.getEndPage());
		model.addAttribute("blockStartNumber",p.getBlockStartNumber());
		model.addAttribute("blockEndNumber",p.getBlockEndNumber());
		model.addAttribute("pageNum",p.getRequestPage());
		
		model.addAttribute("boardList",voList);
		
		
	}

	@Override
	public void noticeWritePro(HttpServletRequest req, Model model) {
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeNo(0);
		vo.setReadCount(0);
		vo.setReg_Date(new Timestamp(new Date().getTime()));
		vo.setTitle(title);
		vo.setContent(content);
		
		int cnt = dao.noticeWritePro_proc(vo);
		model.addAttribute("cnt",cnt);
		
	}


	@Override
	public void answerWriteProc(HttpServletRequest req, Model model) {
		
		String boardNoString = req.getParameter("boardNo");
		int boardNo = Integer.parseInt(boardNoString);
		String kind = req.getParameter("kind");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Timestamp reg_Date = new Timestamp(new Date().getTime());
		
		AnswerVO vo = new AnswerVO();
		vo.setBoardNo(boardNo);
		vo.setKind(kind);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setReg_date(reg_Date);
		
		
		int cnt = dao.answerWriteProc_proc(vo);
		if(cnt==1) {
			cnt = dao.updateBoardCount(vo.getBoardNo());
		}
		
		model.addAttribute("cnt",cnt);

	}


	@Override
	public void noticeDetail(HttpServletRequest req, Model model) {
		
		String noticeNoString = req.getParameter("noticeNo");
		int noticeNo = Integer.parseInt(noticeNoString);
		NoticeVO vo = dao.noticeDetail_proc(noticeNo);
		vo.setContent(vo.getContent().replaceAll("<br />","\n"));
		model.addAttribute("noticeVO",vo);
	}


	@Override
	public void noticeModifyPro(HttpServletRequest req, Model model) {
		
		String noticeNoString = req.getParameter("noticeNo");
		int noticeNo = Integer.parseInt(noticeNoString);
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeVO vo = new NoticeVO();
		vo.setNoticeNo(noticeNo);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setReg_Date(new Timestamp(new Date().getTime()));
		
		int cnt = dao.noticeModifyPro_proc(vo);
		req.setAttribute("cnt",cnt);
		
	}


	/* 호스트 */
}
