package kos.triple.project.service.chul;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.vo.Epilogue_LikeVO;
import kos.triple.project.vo.Epilogue_commentVO;

public interface EpilogueService {
	
	public void searchLocaPro(HttpServletRequest req, Model model);
	
	public void getNumOfEpilogue(HttpServletRequest req, Model model);
	
	public void initialInsert(HttpServletRequest req, Model model);

	public void insertEpilCourse(MultipartHttpServletRequest multi, Model model, List<String> uploadFileList);
	
	public void getEpilCourse(MultipartHttpServletRequest req, Model model);
	
	public void writeEpilogueProServ(HttpServletRequest req, Model model);
	
	public void previewEpilViewServ(HttpServletRequest req, Model model);

	public void printEpilogueList(HttpServletRequest req, Model model);

	public void detailEpilViewServ(HttpServletRequest req, Model model);

	public void writeEpilogue(HttpServletRequest req, Model model);

	public void getOneEpilCourse (HttpServletRequest req, Model model);

	public void printSearchEpilogueList (HttpServletRequest req, Model model);

	public void getEpilog(HttpServletRequest req, Model model);

	public void getEpilogDetail(HttpServletRequest req, Model model);
	
	// 댓글 시작
	
	public List<Epilogue_commentVO> getCommentList_serv(Epilogue_commentVO commentVO);
	
	public int insertComment_serv (Epilogue_commentVO commentVO, HttpServletRequest req);
	
	public int updateComment_serv (Epilogue_commentVO commentVO, HttpServletRequest req);
	
	public int deleteComment_serv (Epilogue_commentVO commentVO, HttpServletRequest req);
	
	
	// 댓글 끝

	/* 새로만든...... */
	/* 이야기를 가져온다...... */
	public void getAllEpilogueList(HttpServletRequest req, Model model);

	public void getDetailLike(HttpServletRequest req, Model model);

	public void getDetailComment(HttpServletRequest req, Model model);

	public void searchEpilogueList_serv(HttpServletRequest req, Model model);

	public int epilogueLike_serv(String epilogueNo, HttpServletRequest req);

	public List<Epilogue_LikeVO> likeListFunction_serv(String epilogueNo);
}
