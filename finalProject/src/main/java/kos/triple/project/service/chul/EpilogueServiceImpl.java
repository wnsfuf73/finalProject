package kos.triple.project.service.chul;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.etc.JstringConverter;
import kos.triple.project.etc.PageCalculator;
import kos.triple.project.persistence.chul.EpilogueDAO;
import kos.triple.project.vo.EpilogueDetailVO;
import kos.triple.project.vo.EpilogueFrontVO;
import kos.triple.project.vo.EpilogueVO;
import kos.triple.project.vo.Epilogue_LikeVO;
import kos.triple.project.vo.Epilogue_commentVO;
import kos.triple.project.vo.Epilogue_courseVO;
import kos.triple.project.vo.WhereVO;

@Service
public class EpilogueServiceImpl implements EpilogueService {

	@Autowired
	EpilogueDAO eDao;

	@Override
	public void searchLocaPro(HttpServletRequest req, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();

		String search = req.getParameter("search").replace('"', '\0');
		search = search.trim();
		map.put("search", search);

		List<WhereVO> where = eDao.location(map);

		model.addAttribute("where", where);
	}

	@Override
	public void getNumOfEpilogue(HttpServletRequest req, Model model) {

		int getNumOfEpil = 0;

		String mem_id = (String) req.getSession().getAttribute("mem_id");
		System.out.println("mem_id" + mem_id);
		Map<String, Object> kindMap = new HashMap<String, Object>();

		kindMap.put("kind", null);

		getNumOfEpil = eDao.getNumOfEpilCourse(kindMap);

		++getNumOfEpil;

		// 나중에 이 부분 삭제할것.
		mem_id = "guest";

		model.addAttribute("epilogueNo", getNumOfEpil);
		model.addAttribute("mem_id", mem_id);

	}

	@Override
	public void initialInsert(HttpServletRequest req, Model model) {

		// String mem_id = req.getSession().getAttribute("mem_id");

		Map<String, Object> kindMap = new HashMap<String, Object>();

		kindMap.put("kind", null);

		/* int epilogueNo = eDao.getNumOfEpil(kindMap); */
		int epilogueNo = eDao.epilNumGenerator();

		++epilogueNo;

		// isDomestic == Y means Domestic
		// == N means abroad.
		String isDomestic = req.getParameter("isDomestic");
		System.out.println("++++++++++++isDomestic : " + isDomestic);
		String kind = req.getParameter("selectKind");
		String tour_title = req.getParameter("tour_title");

		Map<String, Object> map = new HashMap<String, Object>();

		// 나중에 mem_id 키 값을 req.getSession().getAttribute() 로 바꿀 것
		map.put("mem_id", "guest");
		map.put("type", isDomestic);
		map.put("kind", kind);
		map.put("epilogueNo", epilogueNo);
		map.put("title", tour_title);

		int isInsert = eDao.initialInsertPro(map);

		model.addAttribute("mem_id", "guest");
		model.addAttribute("epilogueNo", epilogueNo);
		model.addAttribute("isInsert", isInsert);
	}

	@Override
	public void insertEpilCourse(MultipartHttpServletRequest multi, Model model, List<String> uploadFileList) {

		int i = 1;

		Map<String, Object> imgMap = new HashMap<String, Object>();

		for (String k : uploadFileList) {
			imgMap.put("img" + i, k);
			i++;
		}

		String epilogueNo = multi.getParameter("epilogueNo");
		String content = multi.getParameter("course_content");
		String temp_dday = multi.getParameter("dday");

		System.out.println(epilogueNo + "epilogueNo");

		epilogueNo = epilogueNo.replace('"', '\0');
		epilogueNo = epilogueNo.trim();

		String location_name = (new JstringConverter().stringConverter(multi.getParameter("location_name")));

		Map<String, Object> tempMap = new HashMap<String, Object>();

		tempMap.put("location_name", location_name);

		int location_num = eDao.getLocationNum(tempMap);

		String location_numS = String.valueOf(location_num);

		temp_dday = temp_dday.replace('"', '\0');
		temp_dday = temp_dday.trim();

		/*
		 * uploadfile = uploadfile.replace('"', '\0'); uploadfile = uploadfile.trim();
		 */

		java.sql.Date dday = java.sql.Date.valueOf(temp_dday);

		Map<String, Object> epil = new HashMap<String, Object>();

		epil.put("epilogueNo", epilogueNo);

		int visit_order = eDao.getNumOfEpilCour(epil);

		++visit_order;

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("epilogueNo", epilogueNo);
		// location_num 여행지찾기 구현하고 나서 다시 ㄱㄱ
		// map.put("location_num", location_num);
		map.put("location_num", location_numS);
		map.put("content", content);
		map.put("dday", dday);
		map.put("visit_order", visit_order);
		map.put("img1", imgMap.get("img1"));
		map.put("img2", imgMap.get("img2"));
		map.put("img3", imgMap.get("img3"));
		map.put("img4", imgMap.get("img4"));
		// map.put("uploadFile", uploadFile);

		// int isInsert = eDao.insertEpilCoursePro(map);
		int isInsert = eDao.insertEpilogueCourse(map);

		model.addAttribute("isInsert", isInsert);
		multi.setAttribute("epilogueNo", epilogueNo);
	}

	@Override
	public void getEpilCourse(MultipartHttpServletRequest req, Model model) {

		// 현재 후기에 추가된 epilogue_course 목록을 가져올거임.
		String epilogueNo = (String) req.getAttribute("epilogueNo");

		Map<String, Object> map1 = new HashMap<String, Object>();

		map1.put("epilogueNo", epilogueNo);

		// 현재 후기에 추가한 코스의 갯수를 가져와야함. 왜냐하면 rownum의 최대값을 정해주기 위해서
		int numOfEpilCourse = eDao.getNumOfEpilCour(map1);

		Map<String, Object> map2 = new HashMap<String, Object>();

		map2.put("epilogueNo", epilogueNo);
		map2.put("maxRow", numOfEpilCourse);

		List<Epilogue_courseVO> listOfEpilCourse = eDao.getListOfEpilCourse(map2);

		model.addAttribute("listOfEpilCourse", listOfEpilCourse);

	}

	@Override
	public void writeEpilogueProServ(HttpServletRequest req, Model model) {

		String epilogueNo = req.getParameter("epilogueNo");
		String isAbroad = req.getParameter("p_frgn_yn"); // y --> abroad else inter.
		String category = req.getParameter("selectCategory");
		String epilTitle = req.getParameter("epilTitle");
		String epilogue = req.getParameter("epilogue");

		int readnumOfEpil = 0;
		int goodCount = 0;

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("epilogueNo", epilogueNo);
		map.put("isAbroad", isAbroad);
		map.put("category", category);
		map.put("epilTitle", epilTitle);
		map.put("epilogue", epilogue);
		map.put("readnumOfEpil", readnumOfEpil);
		map.put("goodCount", goodCount);
		map.put("security", "Y"); // security 'Y' then public.
		int isUpdated = eDao.writeEpilogueProDao(map);

		model.addAttribute("isUpdated", isUpdated);
	}

	@Override
	public void previewEpilViewServ(HttpServletRequest req, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("epilogueNo", req.getParameter("epilogueNo"));

		List<EpilogueVO> listOfEpil = eDao.previewEpilViewDao(map);

		model.addAttribute("listOfEpil", listOfEpil);

		for (EpilogueVO eVo : listOfEpil) {
			for (Epilogue_courseVO cVo : eVo.getCourses()) {
				System.out.println(cVo.getLocation_num());
				System.out.println(cVo.getWhere().getLocation_name());
			}
		}
	}

	@Override
	public void printEpilogueList(HttpServletRequest req, Model model) {

		int pageSize = 16; // 한 페이지 당 출력 글 개수
		int pageBlock = 10; // 한 블럭 당 페이지 개수

		int numOfEpil = 0; // 글 개수
		int startNum = 0; // 현재 페이지의 글 시작 번호
		int endNum = 0; // 현재 페이지의 글 마지막 번호
		int number = 0; // 출력할 글 번호

		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재 페이지

		int pageCount = 0; // 페이지 개수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		Map<String, Object> kindMap = new HashMap<String, Object>();

		String kind = req.getParameter("kind");

		if (kind != null) {
			kind = (new JstringConverter()).stringConverter(kind);
		}

		System.out.println("kind   :    " + kind);
		kindMap.put("kind", kind);

		// 호출한 후 글 개수 구하기
		/* numOfEpil = eDao.getNumOfEpilCourse(kindMap); */
		numOfEpil = eDao.getNumOfEpil(kindMap);
		System.out.println("numOfEpil: " + numOfEpil);

		pageNum = req.getParameter("pageNum");

		// 첫페이지를 1페이지로 설정
		if (pageNum == null) {
			pageNum = "1";
		}

		// 현재 페이지 currentPage
		currentPage = (Integer.parseInt(pageNum));

		// 페이지 개수
		pageCount = (numOfEpil / pageSize) + (numOfEpil % pageSize > 0 ? 1 : 0); // 페이지 개수 + 나머지

		// 현재 페이지 시작번호
		startNum = (currentPage - 1) * pageSize + 1;

		// 현재 페이지 끝번호
		endNum = startNum + pageSize - 1;

		System.out.println("startNum: " + startNum);
		System.out.println("endNum: " + endNum);

		if (endNum > numOfEpil)
			endNum = numOfEpil;

		// 출력할 글 번호
		number = numOfEpil - (currentPage - 1) * pageSize; //

		System.out.println("number: " + number);
		System.out.println("numOfEpil: " + numOfEpil);
		System.out.println("currentPage: " + currentPage);
		System.out.println("pageSize:" + pageSize);

		if (numOfEpil > 0) {

			// 게시글 목록 조회
			Map<String, Object> numMap = new HashMap<String, Object>();
			Map<String, Object> temp = new HashMap<String, Object>();

			temp.put("epilogueNo", null);

			numMap.put("startNum", startNum);
			numMap.put("endNum", endNum);
			numMap.put("kind", kind);

			List<EpilogueVO> epilList = eDao.printEpilogueListProTest(numMap);
			List<EpilogueVO> epilDetail = eDao.getDetailEpilInfo(numMap);

			int outerIter = 0;
			int innerIter = 0;

			for (EpilogueVO v : epilList) {
				System.out.println("=======" + (outerIter + 1) + "outerLoopStart=========");
				System.out.println("outerIter : " + outerIter);
				System.out.println("epilogueNo : " + v.getEpilogueNo());
				for (Epilogue_courseVO vv : v.getCourses()) {
					System.out.println("=======" + (innerIter + 1) + "InnerLoopStart=========");
					System.out.println("innerIter : " + innerIter);
					innerIter++;
					System.out.println("epilogue_courseNo : " + vv.getEpilogue_courseNo());
					System.out.println("location_name : " + vv.getWhere().getLocation_name());
					System.out.println("epilogueNo : " + vv.getEpilogueNo());
				}
				System.out.println("====================");
				System.out.println();
				outerIter++;
			}

			model.addAttribute("epilList", epilList);
			model.addAttribute("epilDetail", epilDetail);

		}

		// 시작 페이지
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;

		// 마지막 페이지
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCount)
			endPage = pageCount;

		model.addAttribute("numOfEpil", numOfEpil);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("kind", kind);

		if (numOfEpil > 0) {
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("currentPage", currentPage);
		}

	}

	@Override
	public void detailEpilViewServ(HttpServletRequest req, Model model) {

		String selectedEpilogueNo = req.getParameter("epilogueNo");

		System.out.println(selectedEpilogueNo + "selectedEpilogueNo");

		Map<String, Object> epilMap = new HashMap<String, Object>();

		epilMap.put("selectedEpilogueNo", selectedEpilogueNo);

		EpilogueVO eVo = eDao.detailEpilViewDao(epilMap);
		int isUpdated = eDao.updateReadCount(epilMap);

		model.addAttribute("eVo", eVo);
	}

	@Override
	public void writeEpilogue(HttpServletRequest req, Model model) {
		String epilogueNo = req.getParameter("epilogueNo");
		String epilogue = req.getParameter("epilogue");
		String security = req.getParameter("security");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("security : " + security);
		map.put("epilogueNo", epilogueNo);
		map.put("epilogue", epilogue);
		map.put("security", "Y"); // security 'Y' then public.

		int isInserted = eDao.writeEpilogueProDao(map);

		model.addAttribute("isInserted", isInserted);
	}

	@Override
	public void getOneEpilCourse(HttpServletRequest req, Model model) {

		String epilogueNo = req.getParameter("epilogueNo");
		String epilogue_courseNo = req.getParameter("epilogue_courseNo");

		Map<String, Object> epilMap = new HashMap<String, Object>();

		epilMap.put("epilogueNo", epilogueNo);
		epilMap.put("epilogue_courseNo", epilogue_courseNo);

		model.addAttribute("detailEpilCourse", eDao.getOneEpilCourseDao(epilMap));
	}

	@Override
	public void printSearchEpilogueList(HttpServletRequest req, Model model) {

		int pageSize = 16; // 한 페이지 당 출력 글 개수
		int pageBlock = 10; // 한 블럭 당 페이지 개수

		int numOfEpil = 0; // 글 개수
		int startNum = 0; // 현재 페이지의 글 시작 번호
		int endNum = 0; // 현재 페이지의 글 마지막 번호
		int number = 0; // 출력할 글 번호

		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재 페이지

		int pageCount = 0; // 페이지 개수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		Map<String, Object> searchMap = new HashMap<String, Object>();

		String searchPhrase = req.getParameter("searchPhrase");
		String searchKind = req.getParameter("searchKind");

		searchMap.put("searchPhrase", searchPhrase);
		searchMap.put("searchKind", searchKind);

		// 호출한 후 글 개수 구하기
		numOfEpil = eDao.getNumOfEpilCourseSearch(searchMap);
		System.out.println("numOfEpil: " + numOfEpil);

		pageNum = req.getParameter("pageNum");

		// 첫페이지를 1페이지로 설정
		if (pageNum == null) {
			pageNum = "1";
		}

		// 현재 페이지 currentPage
		currentPage = (Integer.parseInt(pageNum));

		// 페이지 개수
		pageCount = (numOfEpil / pageSize) + (numOfEpil % pageSize > 0 ? 1 : 0); // 페이지 개수 + 나머지

		// 현재 페이지 시작번호
		startNum = (currentPage - 1) * pageSize + 1;

		// 현재 페이지 끝번호
		endNum = startNum + pageSize - 1;

		System.out.println("startNum: " + startNum);
		System.out.println("endNum: " + endNum);

		if (endNum > numOfEpil)
			endNum = numOfEpil;

		// 출력할 글 번호
		number = numOfEpil - (currentPage - 1) * pageSize; //

		System.out.println("number: " + number);
		System.out.println("numOfEpil: " + numOfEpil);
		System.out.println("currentPage: " + currentPage);
		System.out.println("pageSize:" + pageSize);

		if (numOfEpil > 0) {

			// 게시글 목록 조회

			searchMap.put("startNum", startNum);
			searchMap.put("endNum", endNum);

			List<EpilogueVO> epilList = eDao.printEpilogueListSearch(searchMap);

			model.addAttribute("epilList", epilList);
		}

		// 시작 페이지
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;

		// 마지막 페이지
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCount)
			endPage = pageCount;

		model.addAttribute("numOfEpil", numOfEpil);
		model.addAttribute("number", number);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("searchPhrase", searchPhrase);
		model.addAttribute("searchKind", searchKind);

		if (numOfEpil > 0) {
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("currentPage", currentPage);
		}
	}

	@Override
	public void getEpilog(HttpServletRequest req, Model model) {

		String num1 = req.getParameter("epilogueNo");
		int num = Integer.parseInt(num1);

		EpilogueVO vo = eDao.getEpilog(num);

		model.addAttribute("epilogVo", vo);

	}

	@Override
	public void getEpilogDetail(HttpServletRequest req, Model model) {

		String num = req.getParameter("epilogueNo");
		String pageNum = req.getParameter("pageNum");

		List<EpilogueDetailVO> epilogueDetailList = eDao.getEpilogDetail(num);

		model.addAttribute("epilogueDetailList", epilogueDetailList);
		model.addAttribute("num", num);
		model.addAttribute("pageNum", pageNum);
	}

	/* 새로만든 메소드...----------------------------------------- */

	@Override
	public void getAllEpilogueList(HttpServletRequest req, Model model) {

		Map<String, Object> map = new HashMap<String, Object>();

		String kind = null;
		if (req.getParameter("kind") != null)
			kind = req.getParameter("kind");
		
		map.put("kind", kind);
		System.out.println(kind);
		String requestPage = req.getParameter("requestPage");
		int dataTotalCount = eDao.epilogueTotalCount(map);
		int blocksize = 10;
		int contentCount = 16;

		int pageNum = requestPage == null ? 1 : Integer.parseInt(requestPage);

		PageCalculator p = new PageCalculator(pageNum, dataTotalCount, blocksize, contentCount);
		System.out.println("dataTotalCount : " + dataTotalCount);
		map.put("start", p.getStart());
		map.put("end", p.getEnd());

		List<EpilogueFrontVO> list = eDao.getAllEpilogueList_proc(map);

		for (EpilogueFrontVO i : list) {

			int num = i.getEpilogueNo();
			i.setCommentCount(eDao.getCommentCount(num));
			i.setVisitOrder(eDao.getCourses(num));
			i.setGoodcount(eDao.getLikeCount(num));
			i.setImg1(eDao.getRepresentImg(num));
		}

		model.addAttribute("blockStartNumber", p.getBlockStartNumber());
		model.addAttribute("startPage", p.getStartPage());
		model.addAttribute("blockEndNumber", p.getBlockEndNumber());
		model.addAttribute("pageNum", p.getRequestPage());
		model.addAttribute("endPage", p.getEndPage());
		model.addAttribute("epilList", list);
		model.addAttribute("kind", kind);

	}

	@Override
	public void getDetailLike(HttpServletRequest req, Model model) {

		String num1 = req.getParameter("epilogueNo");

		int num = Integer.parseInt(num1);

		List<Epilogue_LikeVO> likeList = eDao.getDetailLike_proc(num);
		int likeCnt = eDao.getLikeCount(num);

		model.addAttribute("likeList", likeList);
		model.addAttribute("likeCnt", likeCnt);

	}

	@Override
	public void getDetailComment(HttpServletRequest req, Model model) {

		String num1 = req.getParameter("epilogueNo");

		int num = Integer.parseInt(num1);

		List<Epilogue_commentVO> commentList = eDao.getDetailComment(num);
		int commentCnt = eDao.getCommentCount(num);

		model.addAttribute("commentList", commentList);
		model.addAttribute("commentCnt", commentCnt);

	}

	// 댓글 시작

	@Override
	public List<Epilogue_commentVO> getCommentList_serv(Epilogue_commentVO commentVO) {

		return eDao.getCommentList_proc(commentVO);
	}

	@Override
	public int insertComment_serv(Epilogue_commentVO commentVO, HttpServletRequest req) {

		/*
		 * String curr_id = (String) req.getSession().getAttribute("mem_id");
		 * 
		 * commentVO.setMem_id(curr_id);
		 */

		return eDao.insertComment_proc(commentVO);
	}

	@Override
	public int updateComment_serv(Epilogue_commentVO commentVO, HttpServletRequest req) {

		String curr_id = (String) req.getSession().getAttribute("mem_id");

		return eDao.updateComment_proc(commentVO);
	}

	@Override
	public int deleteComment_serv(Epilogue_commentVO commentVO, HttpServletRequest req) {

		/* String curr_id = (String) req.getSession().getAttribute("mem_id"); */

		if (commentVO.getMem_id().equals("guest")) {
			return eDao.deleteComment_proc(commentVO);
		}

		return 0;
	}
	// 댓긑 끝

	@Override
	public void searchEpilogueList_serv(HttpServletRequest req, Model model) {
		
		Map<String, Object> searchMap = new HashMap<String, Object>();

		String searchPhrase = req.getParameter("searchPhrase");
		String searchKind = req.getParameter("searchKind");
		
		searchPhrase = searchPhrase.substring(searchPhrase.indexOf('"')+1, searchPhrase.lastIndexOf('"'));
		searchKind = searchKind.substring(searchKind.indexOf('"')+1, searchKind.lastIndexOf('"'));
		
		System.out.println("searchPhrase : " + searchPhrase);
		System.out.println("searchKind : " + searchKind);
		
		searchMap.put("searchPhrase", searchPhrase);
		searchMap.put("searchKind", searchKind);

		// 호출한 후 글 개수 구하기
		String requestPage = req.getParameter("requestPage");
		int dataTotalCount = eDao.epilogueTotalCount(searchMap);
		int blockSize = 10;
		int contentCount = 16;
		
		int pageNum = requestPage == null ? 1 : Integer.parseInt(requestPage);
		
		PageCalculator p = new PageCalculator(pageNum, dataTotalCount, blockSize, contentCount);
		
		searchMap.put("start", p.getStart());
		searchMap.put("end", p.getEnd());
		
		List<EpilogueFrontVO> list = eDao.getAllEpilogueList_proc(searchMap);
		
		for (EpilogueFrontVO i : list) {

			int num = i.getEpilogueNo();
			i.setCommentCount(eDao.getCommentCount(num));
			i.setVisitOrder(eDao.getCourses(num));
			i.setGoodcount(eDao.getLikeCount(num));
			i.setImg1(eDao.getRepresentImg(num));
		}
		
		model.addAttribute("epilList", list);
		model.addAttribute("searchKind", searchKind);
		model.addAttribute("searchPhrase", searchPhrase);
		model.addAttribute("blockStartNumber", p.getBlockStartNumber());
		model.addAttribute("startPage", p.getStartPage());
		model.addAttribute("blockEndNumber", p.getBlockEndNumber());
		model.addAttribute("pageNum", p.getRequestPage());
		model.addAttribute("endPage", p.getEndPage());
	}

	@Override
	public int epilogueLike_serv(String epilogueNo) {

		int isLiked = 0;
		
		Map<String, Object> likeMap = new HashMap<String, Object>();
		
		likeMap.put("mem_id", "guest");
		likeMap.put("epilogueNo", epilogueNo);
		
		// 이 글의 좋아요 목록에 현재 아이디가 포함되어 있는지 판별 후, insert 또는 delete 작업을 수행.
		if (eDao.isExistLike(likeMap) == 0) {
			isLiked = eDao.insertEpilogueLike_proc(likeMap);
		}else {
			isLiked = eDao.deleteEpilogueLike_proc(likeMap);
		}
		
		return isLiked;
	}

	@Override
	public List<Epilogue_LikeVO> likeListFunction_serv(String epilogueNo) {

		
		return eDao.likeListFunction_proc(epilogueNo);
	}

}
