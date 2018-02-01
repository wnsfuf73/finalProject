package kos.triple.project.controller.chul;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.etc.ServerSetting;
import kos.triple.project.persistence.chul.EpilogueDAO;
import kos.triple.project.service.chul.EpilogueService;
import kos.triple.project.vo.Epilogue_LikeVO;
import kos.triple.project.vo.Epilogue_commentVO;
import kos.triple.project.vo.Epilogue_courseVO;

@Controller
public class EpilogueController {

	@Autowired
	EpilogueService eService;
	@Autowired
	EpilogueDAO eDao;
	
	
	@RequestMapping(value="isLogin_travel")
	public String isLogin_travel(HttpServletRequest req, Model model) {
		
		if (req.getSession().getAttribute("mem_id")!=null) {
			return "story/writeEpilogueStep1";
		}else {
			return "main/loginForm";
		}
	}
	
	@RequestMapping(value="isLogin_essay")
	public String isLogin_essay(HttpServletRequest req, Model model) {
		
		if (req.getSession().getAttribute("mem_id")!=null) {
			return "story/essay/essay_wrt";
		}else {
			return "main/loginForm";
		}
	
	}
	
	@RequestMapping(value="isLogin_reviewForm")
	public String isLogin_reviewForm(HttpServletRequest req, Model model) {
		
		if (req.getSession().getAttribute("mem_id")!=null) {
			return "story/review/reviewForm";
		}else {
			return "main/loginForm";
		}
	
	}
	
	@RequestMapping(value="getCurrentId")
	@ResponseBody
	public String getCurrentId(HttpServletRequest req) {
		
		// ㅇㅋㅇㅋ
		/*req.getSession().setAttribute("mem_id", "guest");*/
		
		String curr_id = (String) req.getSession().getAttribute("mem_id");
		
		return curr_id;
	}
	
	
	// 작성하기 클릭 후 첫 페이지.
	// 이상하게 initialInsert가 두번 호출되어버림...

	// 이야기 클릭시 전체여행기 보임
	@RequestMapping(value = "epilogueList")
	public String EpilogueList(HttpServletRequest req, Model model) {

		//eService.printEpilogueList(req, model);
		eService.getAllEpilogueList(req,model);
		
		return "story/epilogueList";
	}

	// 작성하기 -> 여행지 찾기 -> 여행지 찾기 모달창 및 검색결과.
	// value and return value will be changed to another name.
	@RequestMapping(value = "ajaxSearchTest")
	public String ajaxSearchTest(HttpServletRequest req, Model model) {

		// 모달창에서 받은 검색어를 search라는 속성에 추가. 이제 이걸 가지고 dao에서 검색결과를 가지고 올 수 있다.
		// Call a Service
		eService.searchLocaPro(req, model);

		return "story/ajaxSearchTest";
	}

	// 이야기작성 -> 코스저장하기 버튼 클릭시에 아래 메소드 실행.
	// ajax에 의해 호출된다.
	@RequestMapping(value = "writeEpilCourse")
	public String writeEpilCourse(MultipartHttpServletRequest multi, Model model) {

		List<String> uploadFileList = new ArrayList<String>();

		String root = multi.getSession().getServletContext().getRealPath("/");
		System.out.println(root + "rootPath");
		/* String path = root + "resources/upload"; */

		String path = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\story\\story";

		String newFileName = "";

		File dir = new File(path);

		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		Iterator<String> files = multi.getFileNames();

		while (files.hasNext()) {
			String uploadFile = files.next();

			System.out.println(uploadFile + "uploadFile");

			MultipartFile mFile = multi.getFile(uploadFile);
			String fileName = mFile.getOriginalFilename();
			System.out.println("real file name is : " + fileName);
			newFileName = System.currentTimeMillis() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);

			try {
				mFile.transferTo(new File(path + newFileName));

				uploadFileList.add(newFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		eService.insertEpilCourse(multi, model, uploadFileList);
		eService.getEpilCourse(multi, model);

		return "story/writeEpilCourse";
	}

	@RequestMapping(value = "writeEpiloguePro")
	public String writeEpiloguePro(HttpServletRequest req, Model model) {

		eService.writeEpilogueProServ(req, model);

		return "story/writeEpiloguePro";
	}

	@RequestMapping(value = "previewEpilogue")
	public String previewEpilogue(HttpServletRequest req, Model model) {

		eService.previewEpilViewServ(req, model);

		return "story/previewEpilogue";
	}

	@RequestMapping(value = "epilogueListTest")
	public String EpilogueListTest() {

		return "story/epilogueListTest";
	}

	@RequestMapping(value = "viewEpilogueList")
	public String viewEpilogueList(HttpServletRequest req, Model model) {

		System.out.println("viewEpilogueList");

		//eService.printEpilogueList(req, model);
		eService.getAllEpilogueList(req,model);
		
		
		return "story/viewEpilogueList";
	}

	@RequestMapping(value = "detailEpilView")

	public String detailEpilView(HttpServletRequest req, Model model) {

		eService.detailEpilViewServ(req, model);

		return "story/detailEpilView";
	}

	@RequestMapping(value = "writeEpilogue")
	public String writeEpilogue(HttpServletRequest req, Model model) {

		eService.writeEpilogue(req, model);

		return "story/writeEpilogueProTest";
	}

	@RequestMapping(value = "writeEpilogueForm")
	public String writeEpilogueForm(HttpServletRequest req, Model model) {

		return "story/writeEpilogueForm";
	}

	@RequestMapping(value = "writeEpilogueStep1")
	public String epilogStep1(HttpServletRequest req, Model model) {

		return "story/writeEpilogueStep1";
	}

	@RequestMapping(value = "writeEpilogueStep2")
	public String epilogStep2(HttpServletRequest req, Model model) {

		// 여기서 initialInsert 해야할 듯함.
		// epilogueNo 는 step2 부터 부여받음.
		eService.initialInsert(req, model);

		return "story/writeEpilogueStep2";
	}

	@RequestMapping(value = "writeEpilogueStep3")
	public String epilogStep3(HttpServletRequest req, Model model) {

		model.addAttribute("epilogueNo", req.getParameter("epilogueNo"));	
		
		return "story/writeEpilogueStep3";
	}
	
	@RequestMapping(value = "writeEpilogueStep3Pro")
	public String writeEpilogueStep3Pro(HttpServletRequest req, Model model) {
		
		eService.writeEpilogue(req, model);
		
		return "story/writeEpilogueStep3Pro";
	}

	@RequestMapping(value = "writeEpilogueStep2Pro")
	public String writeEpilogueStep2Pro(MultipartHttpServletRequest multi, Model model)
			throws IllegalStateException, IOException {

		List<String> uploadFileList = new ArrayList<String>();

		String root = multi.getSession().getServletContext().getRealPath("/");
		System.out.println(root + "rootPath");
		/* String path = root + "resources/upload"; */

		String path = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\story\\story";

		String newFileName = "";

		File dir = new File(path);

		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		List<MultipartFile> mf = multi.getFiles("uploadFiles");
		
		
		// 무슨 상황이죠?
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				String originalFileName = mf.get(i).getOriginalFilename();
				newFileName = System.currentTimeMillis() + "."
						+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

				mf.get(i).transferTo(new File(path + newFileName));

				uploadFileList.add(newFileName);
			}
		}
		
		eService.insertEpilCourse(multi, model, uploadFileList);
		eService.getEpilCourse(multi, model);

		return "story/writeEpilogueStep2Pro";
	}

	/*
	 * @RequestMapping(value="getDetailCourseInfo") public String
	 * getDetailCourseInfo(HttpServletRequest req, Model model) {
	 * 
	 * eService.getOneEpilCourse(req, model);
	 * 
	 * return "story/getDetailCourseInfo"; }
	 */

	@RequestMapping(value = "getDetailCourseInfo")
	public @ResponseBody Epilogue_courseVO getDetailCourseInfo(@RequestParam("epilogueNo") String epilogueNo,
			@RequestParam("epilogue_courseNo") String epilogue_courseNo) {

		Map<String, Object> epilMap = new HashMap<String, Object>();

		epilMap.put("epilogueNo", epilogueNo);
		epilMap.put("epilogue_courseNo", epilogue_courseNo);

		Epilogue_courseVO eVo = eDao.getOneEpilCourseDao(epilMap);

		System.out.println(eVo.getWhere().getLocation_name());

		return eVo;

	}

	@RequestMapping(value = "updateCourseInfo")
	public @ResponseBody boolean updateCourseInfo(MultipartHttpServletRequest multi)
			throws IllegalStateException, IOException {

		List<String> uploadFileList = new ArrayList<String>();

		String root = multi.getSession().getServletContext().getRealPath("/");
		System.out.println(root + "rootPath");
		/* String path = root + "resources/upload"; */

		String path = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\story\\story";

		String newFileName = "";

		File dir = new File(path);

		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		List<MultipartFile> mf = multi.getFiles("uploadUpdateFiles");

		// 무슨 상황이죠?
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				String originalFileName = mf.get(i).getOriginalFilename();
				newFileName = System.currentTimeMillis() + "."
						+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

				mf.get(i).transferTo(new File(path + newFileName));
				System.out.println(newFileName + "newFileName");
				uploadFileList.add(newFileName);
			}
		}


		String epilogue_courseNo = multi.getParameter("epilogue_courseNo");

		String location_name = multi.getParameter("searchText");

		String content = multi.getParameter("content");

		Map<String, Object> tempMap = new HashMap<String, Object>();

		tempMap.put("location_name", location_name);

		int location_num = eDao.getLocationNum(tempMap);

		String location_numS = String.valueOf(location_num);

		String dday = multi.getParameter("dday");
		System.out.println(dday + "dday");

		java.sql.Date day = java.sql.Date.valueOf(dday);

		Map<String, Object> epil = new HashMap<String, Object>();

		epil.put("epilogue_courseNo", epilogue_courseNo);
		epil.put("location_num", location_numS);
		epil.put("content", content);
		epil.put("dday", day);

		int i = 1;

		Map<String, Object> imgMap = new HashMap<String, Object>();

		for (String k : uploadFileList) {
			imgMap.put("img" + i, k);
			i++;
		}

		for (int j = 1; j < uploadFileList.size(); j++) {

			epil.put("img" + j, uploadFileList.get(--j));
			System.out.println("img" + j + "     " + uploadFileList.get(--j));

		}

		int isUpdate = eDao.updateCourseInfoPro(epil);

		if (isUpdate == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(value="detailEpilogueView")
	public String detailEpilogueView(HttpServletRequest req, Model model) {
		
		eService.detailEpilViewServ(req, model);
		
		return "story/detailEpilogueView";
	}
	
	@RequestMapping(value="getNumLikeAndCmt")
	public @ResponseBody Map<String, Object> getNumLikeAndCmt(@RequestParam("epilogueNo") String epilogueNo){
		
		System.out.println("getNumLikeAndCmt");
		
		Map<String, Object> numberMap = new HashMap<String, Object>();
		
		numberMap.put("epilogueNo", epilogueNo);
		
		int numOfLike = eDao.getNumOfLike(numberMap);
		int numOfCmt = eDao.getNumOfCmt(numberMap);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		returnMap.put("numOfLike", numOfLike);
		returnMap.put("numOfCmt", numOfCmt);
		
		return returnMap;
	}
	
	@RequestMapping(value="requestSearchEpilogue")
	public String requestSearchEpilogue(HttpServletRequest req, Model model) {
		
		/*eService.printSearchEpilogueList(req, model);*/
		eService.searchEpilogueList_serv(req, model);
		
		
		return "story/requestSearchEpilogue";
	}
	
	@RequestMapping(value="template")
	public String template() {
		
		return "story/template";
	}
	
	@RequestMapping(value="epilogueDetail")
	public String epilogDetail(HttpServletRequest req , Model model) {
	
		eService.getEpilog(req,model);
		eService.getEpilogDetail(req,model);
		eService.getDetailLike(req,model);
		eService.getDetailComment(req,model);
		
		return "story/epilogueDetail";
		
	}
	
	@RequestMapping(value="commentList")
	@ResponseBody
	public List<Epilogue_commentVO> getCommentList(@RequestParam("epilogueNo") String epilogueNo){
		
		Epilogue_commentVO commentVO = new Epilogue_commentVO();
		
		commentVO.setEpilogueNo(Integer.parseInt(epilogueNo));
		
		return eService.getCommentList_serv(commentVO);
	}
	 	
	@RequestMapping(value="insertComment")
	@ResponseBody
	public int insertComment(@RequestParam("epilogueNo") String epilogueNo, @RequestParam("commentContent") String content,HttpServletRequest req) {
		
		// 글쓴이는 현재 로그인한 사람..
		
		
		Epilogue_commentVO commentVO = new Epilogue_commentVO();
		
		commentVO.setEpilogueNo(Integer.parseInt(epilogueNo));
		commentVO.setMem_id((String) req.getSession().getAttribute("mem_id"));
		/*commentVO.setMem_id("guest");*/
		commentVO.setContent(content);
		
		return eService.insertComment_serv(commentVO, req);
		
	}
	
	@RequestMapping(value="updateComment")
	@ResponseBody
	public int updateComment(@RequestParam("epilogue_commentNo") String epilogue_commentNo, @RequestParam("mem_id") String mem_id, @RequestParam("commentContent") String commentContent, HttpServletRequest req) {
		
		
		// 작성자 mem_id 와 현재 로그인한 mem_id 를 비교한다.
		// TODO..
		// 수정할 글의 epilogue_commentNo 를 받는다.
		int commentNo = Integer.parseInt(epilogue_commentNo);
		
		Epilogue_commentVO commentVO = new Epilogue_commentVO();
		
		commentVO.setMem_id(mem_id);
		commentVO.setEpilogue_commentNo(commentNo);
		commentVO.setContent(commentContent);
		
		return eService.updateComment_serv(commentVO, req);
	}
	
	@RequestMapping(value="deleteComment")
	@ResponseBody
	public int deleteComment(@RequestParam String epilogue_commentNo, @RequestParam String mem_id, HttpServletRequest req) {
		
		Epilogue_commentVO commentVO = new Epilogue_commentVO();
		
		int commentNo = Integer.parseInt(epilogue_commentNo);
		
		commentVO.setMem_id(mem_id);
		commentVO.setEpilogue_commentNo(commentNo);
		
		return eService.deleteComment_serv(commentVO, req);
	}
	
	@RequestMapping(value="epilogueLike")
	@ResponseBody
	public int epilogueLike(@RequestParam("epilogueNo") String epilogueNo, HttpServletRequest req){
		System.out.println("epilogueLike");
		return eService.epilogueLike_serv(epilogueNo, req);
	}
	
	@RequestMapping(value="likeListFunction")
	@ResponseBody
	public List<Epilogue_LikeVO> likeListFunction(@RequestParam("epilogueNo") String epilogueNo){
		System.out.println("likeListFunction");
		return eService.likeListFunction_serv(epilogueNo);
	}
	
	@RequestMapping(value="myPageStory")
	public String myPageStory(HttpServletRequest req, Model model) {
		
		eService.getEpilog(req,model);
		eService.getEpilogDetail(req,model);
		eService.getDetailLike(req,model);
		eService.getDetailComment(req,model);
		
		return "story/epilogueDetail";
	}
}