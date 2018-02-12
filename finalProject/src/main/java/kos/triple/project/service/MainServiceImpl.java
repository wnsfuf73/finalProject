package kos.triple.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kos.triple.project.etc.PageCalculator;
import kos.triple.project.persistence.MainDAO;
import kos.triple.project.vo.BannerVO;
import kos.triple.project.vo.EpilogueMyVO;
import kos.triple.project.vo.EpilogueVO;
import kos.triple.project.vo.NoticeVO;
import kos.triple.project.vo.PlanVO;

@Service
public class MainServiceImpl implements MainService{

	@Inject
	MainDAO dao;
	
	//철환이형 서비스로...
	@Override
	public void myNewStory(HttpServletRequest req, Model model) {
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		List<EpilogueVO> newStory = dao.myNewStory_proc(mem_id);
		model.addAttribute("newStory", newStory);
	}
	
	//호선이 서비스로
	@Override
	public void myNewPlan(HttpServletRequest req, Model model) {
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		List<PlanVO> newPlan = dao.myNewPlan_proc(mem_id);
		model.addAttribute("newPlan", newPlan);
	}
	

	@Override
	public void getMyFaceImg(HttpServletRequest req, Model model) {
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		String faceImg = dao.getMyFaceImg_proc(mem_id);
		
		model.addAttribute("faceImg",faceImg);
	}

	@Override
	public void getBanner(HttpServletRequest req, Model model) {
		
		String bannerLocation = req.getParameter("bannerLocation");
		String bannerSeqString = req.getParameter("bannerSeq");
		
		int bannerSeq =  bannerSeqString == null ? 1 : Integer.parseInt(bannerSeqString);
		
		Map<String ,Object> map = new HashMap<String,Object>();
		map.put("bannerLocation", bannerLocation);
		map.put("bannerSeq",bannerSeq );
		
		BannerVO banner = dao.getBanner_proc(map);
		
		req.setAttribute("bannerVO",banner);
	}

	@Override
	public void getBannerCount(HttpServletRequest req, Model model) {

		String bannerLocation = req.getParameter("bannerLocation");
		int count = dao.getBannerCount_proc(bannerLocation);
		req.setAttribute("bannerCount", Integer.toString(count));
	}

	@Override
	public void getNewNotice(HttpServletRequest req, Model model) {

		NoticeVO vo = dao.getNewNotice_proc();
		model.addAttribute("noticeVO",vo);
		
	}

	@Override
	public void myEpilogueList(HttpServletRequest req, Model model) {
		String requestPage = req.getParameter("requestPage");
		int pageNum = requestPage == null ? 1 : Integer.parseInt(requestPage);
		int dataTotalCount = 0;
		int blockSize = 4;
		int contentCount = 5;
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mem_id",mem_id);
		map.put("method","myEpilogueList");
		dataTotalCount = dao.getTotalCount(map);
		
		PageCalculator p = new PageCalculator(pageNum,dataTotalCount,blockSize,contentCount);
		
		map.put("start",p.getStart());
		map.put("end",p.getEnd());
		
		List<EpilogueMyVO> vo = dao.myEpilogueList_proc(map); 
		int index=0;
		for(EpilogueMyVO i : vo) {
			int epilogueNo = i.getEpilogueNo();
			String img1 = dao.getEpilogue_Img1(epilogueNo);
			System.out.println("iimg : " + img1);
			i.setImg1(img1);
			vo.set(index++,i);
		}
		
	
		/*System.out.println("---------------------");
		for(EpilogueMyVO i : vo) {
			System.out.println("img1 : " + i.getImg1());
		}*/
		
		model.addAttribute("myEpilogue",vo);
		
		model.addAttribute("pageNum",p.getRequestPage());
		model.addAttribute("blockStartNumber",p.getBlockStartNumber());
		model.addAttribute("blockEndNumber",p.getBlockEndNumber());
		model.addAttribute("startPage",p.getStartPage());
		model.addAttribute("endPage",p.getEndPage());
		
	}

	
	@Override
	public void deleteMyStory(HttpServletRequest req, Model model) {

		String epilogueNoString = req.getParameter("epilogueNo");
		int epilogueNo = Integer.parseInt(epilogueNoString);
		int cnt = dao.deleteStoryComment(epilogueNo);
		cnt = dao.deleteMyStory_proc(epilogueNo);
		req.setAttribute("cnt",Integer.toString(cnt));
	}
	
	@Override
	public void getHomePageBestTravel(HttpServletRequest req, Model model) {

		EpilogueVO vo = dao.getHomePageBestTravel();
		
		int epilogueNo = vo.getEpilogueNo();
		String img1 = dao.getEpilogue_Img1(epilogueNo);
		
		model.addAttribute("bestTravelImg",img1);
		model.addAttribute("bestTravel",vo);
	}
	
}
