package kos.triple.project.service.kwak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kos.triple.project.persistence.kwak.MypageDAO;
import kos.triple.project.vo.EssayVO;
import kos.triple.project.vo.ReviewVO;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	MypageDAO dao;

	//리뷰목록
	@Override
	public void inventoryReviewList(HttpServletRequest req, Model model) {
		int pageSize = 5;	//한 페이지당 출력할 글 갯수
		int pageBlock = 3;	//한 블럭당 페이지 갯수
		
		int cnt = 0;	// 글 갯수
		int start = 0;	// 현재 페이지 글 시작번호
		int end = 0;	// 현재 페이지 글 마지막 번호
		int number = 0;	//출력할 글 번호
		String pageNum = null;	//페이지 번호
		int currentPage = 0;	//현재 페이지
		
		int pageCount = 0;	//페이지 개수
		int startPage = 0;	//시작페이지
		int endPage = 0;	//마지막 페이지
		
		String mem_id = (String) req.getSession().getAttribute("mem_id");
		
		cnt = dao.getReviewCnt(mem_id);
		System.out.println("글갯수cnt : "+cnt);
		
		pageNum = req.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";	//첫 페이지를 1페이지로 설정
		}
		System.out.println(pageNum);
		currentPage = Integer.parseInt(pageNum);	// 현재페이지
		System.out.println(pageNum);
		//pageCnt = 12 / 5 + 1; //나머지 2건이 1페이지로 할당되므로 3페이지
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);	//페이지개수 + 나머지
		
		// 1 = (1-1) * 5 + 1
		// 6 = (2-1) * 5 + 1
		// 11 = (3-1) * 5 + 1
		// 21 = (5-1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1;	//현재 페이지 시작번호
		
		// 5 = 1 + 5 - 1
		// 10 = 6 + 5 - 1
		end = start + pageSize - 1;	//현재 페이지 끝 번호
		//end = currentPage * pageSize;
		
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		if(end > cnt) end = cnt;
		
		// 1 = 21 - (5-1) * 5;
		number = cnt - (currentPage -1) * pageSize; //출력할 글번호.. 최신글(큰페이지)가 1페이지 출력할 글번호
		
		System.out.println("number : " + number);
		System.out.println("cnt : " + cnt);
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageSize : " + pageSize);
		
		if(cnt > 0) {
			//게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("mem_id", mem_id);
			
			ArrayList<ReviewVO> dtos = dao.getReviewList(map);
			req.setAttribute("dtos", dtos);	//큰바구니 : 게시글목록 ex) 작은 바구니 : 게시글1건
			/*for(int i=0; i < dtos.size(); i++) {
				System.out.println(dtos.get(0).getReviewview());
				System.out.println(dtos.get(0).getFun());
				System.out.println(dtos.get(0).getNear());
				System.out.println(dtos.get(0).getPrice());
			}*/
		}
		startPage = (currentPage / pageBlock) * pageBlock + 1;	//(5/3) * 3 + 1 = 4
		if(currentPage % pageBlock == 0) startPage -= pageBlock; //(5%3)==0
		
		endPage = startPage + pageBlock - 1; //4 + 3 - 1 = 6
		if(endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("cnt", cnt);	// 글개수
		model.addAttribute("number", number);	// 페이지번호
		model.addAttribute("pageNum", pageNum); // 글번호
		
		if(cnt > 0) {
			model.addAttribute("startPage", startPage);		//시작페이지
			model.addAttribute("endPage", endPage);			//마지막페이지
			model.addAttribute("pageBlock", pageBlock);		//출력할페이지개수
			model.addAttribute("pageCount", pageCount);		//페이지개수
			model.addAttribute("currentPage", currentPage);	//현재페이지
		}
		
	}
	
	//리뷰삭제
	@Override
	public void ReviewDeletePro(HttpServletRequest req, Model model) {
		/*//바구니에 담기
		ReviewVO dto = new ReviewVO();*/
		
		//값 받아오기
		int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
		System.out.println(reviewNo);
		
		int cnt = dao.reviewDelete(reviewNo);
		System.out.println("deleteCnt : "+cnt);
		
		model.addAttribute("cnt",cnt);
	}

	//에세이목록
	@Override
	public void inventoryEssayList(HttpServletRequest req, Model model) {
		int pageSize = 5;	//한 페이지당 출력할 글 갯수
		int pageBlock = 3;	//한 블럭당 페이지 갯수
		
		int cnt = 0;	// 글 갯수
		int start = 0;	// 현재 페이지 글 시작번호
		int end = 0;	// 현재 페이지 글 마지막 번호
		int number = 0;	//출력할 글 번호
		String pageNum = null;	//페이지 번호
		int currentPage = 0;	//현재 페이지
		
		int pageCount = 0;	//페이지 개수
		int startPage = 0;	//시작페이지
		int endPage = 0;	//마지막 페이지

		String mem_id = (String) req.getSession().getAttribute("mem_id");
		
		cnt = dao.getEssayCnt(mem_id);
		System.out.println("글갯수cnt : "+cnt);
		
		pageNum = req.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";	//첫 페이지를 1페이지로 설정
		}
		System.out.println(pageNum);
		currentPage = Integer.parseInt(pageNum);	// 현재페이지
		System.out.println(pageNum);
		//pageCnt = 12 / 5 + 1; //나머지 2건이 1페이지로 할당되므로 3페이지
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0);	//페이지개수 + 나머지
		
		// 1 = (1-1) * 5 + 1
		// 6 = (2-1) * 5 + 1
		// 11 = (3-1) * 5 + 1
		// 21 = (5-1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1;	//현재 페이지 시작번호
		
		// 5 = 1 + 5 - 1
		// 10 = 6 + 5 - 1
		end = start + pageSize - 1;	//현재 페이지 끝 번호
		//end = currentPage * pageSize;
		
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		if(end > cnt) end = cnt;
		
		// 1 = 21 - (5-1) * 5;
		number = cnt - (currentPage -1) * pageSize; //출력할 글번호.. 최신글(큰페이지)가 1페이지 출력할 글번호
		
		System.out.println("number : " + number);
		System.out.println("cnt : " + cnt);
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageSize : " + pageSize);
		
		if(cnt > 0) {
			//게시글 목록 조회
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			map.put("mem_id", mem_id);
			
			ArrayList<EssayVO> dtos = dao.getEssayList(map);
			req.setAttribute("dtos", dtos);	//큰바구니 : 게시글목록 ex) 작은 바구니 : 게시글1건
	
		}
		startPage = (currentPage / pageBlock) * pageBlock + 1;	//(5/3) * 3 + 1 = 4
		if(currentPage % pageBlock == 0) startPage -= pageBlock; //(5%3)==0
		
		endPage = startPage + pageBlock - 1; //4 + 3 - 1 = 6
		if(endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("cnt", cnt);	// 글개수
		model.addAttribute("number", number);	// 페이지번호
		model.addAttribute("pageNum", pageNum); // 글번호
		
		if(cnt > 0) {
			model.addAttribute("startPage", startPage);		//시작페이지
			model.addAttribute("endPage", endPage);			//마지막페이지
			model.addAttribute("pageBlock", pageBlock);		//출력할페이지개수
			model.addAttribute("pageCount", pageCount);		//페이지개수
			model.addAttribute("currentPage", currentPage);	//현재페이지
		}
		
	}

	//에세이상세보기
	@Override
	public void myEssayContent(HttpServletRequest req, Model model) {
		//get방식으로 넘긴 값 받아오기
		int essayNo = Integer.parseInt(req.getParameter("essayNo"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		int number = Integer.parseInt(req.getParameter("number"));
		
		//상세페이지 가져오기
		EssayVO dto = dao.getEssayContent(essayNo);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("essayNo", essayNo);
		model.addAttribute("number", number);
	}

	//댓글등록
	@Override
	public void insertReply(HttpServletRequest req, Model model) {
		int cnt = 0;
		String mem_id = (String) req.getSession().getAttribute("mem_id");
		String replyContent = req.getParameter("replyContent");
		int essayNo = Integer.parseInt(req.getParameter("essayNo"));
		
		System.out.println(mem_id);
		System.out.println(replyContent);
		System.out.println(essayNo);
		EssayVO dto = new EssayVO();
		
		dto.setReplyContent(replyContent);
		dto.setMem_id(mem_id);
		dto.setEssayNo(essayNo);
		
		
		if(replyContent.equals("")) {
			cnt = -1;
		}else {
			cnt = dao.insertReply(dto);
			System.out.println("댓글 등록cnt : "+cnt);
		}
		
		model.addAttribute("cnt", cnt);
		
	}

	//댓글목록보기
	@Override
	public void replyList(HttpServletRequest req, Model model) {
		
		int essayNo = Integer.parseInt(req.getParameter("essayNo"));
		System.out.println(essayNo);
		
		ArrayList<EssayVO> dtos = dao.replyList(essayNo);
		
		model.addAttribute("dtos", dtos);
	}

	//에세이 삭제
	@Override
	public void myEssayDelpro(HttpServletRequest req, Model model) {
		
		int essayNo = Integer.parseInt(req.getParameter("essayNo"));
		System.out.println("essayNo" + essayNo);
		
		int cnt = dao.essayDelete(essayNo);
		
		model.addAttribute("cnt", cnt);
		
	}

}
