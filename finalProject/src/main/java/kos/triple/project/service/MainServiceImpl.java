package kos.triple.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kos.triple.project.persistence.MainDAO;
import kos.triple.project.vo.BannerVO;
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
	public void getHomePageRecomandList(HttpServletRequest req, Model model) {
		// TODO Auto-generated method stub
		
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

	
	
	
}
