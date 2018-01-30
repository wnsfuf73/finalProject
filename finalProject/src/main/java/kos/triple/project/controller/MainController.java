package kos.triple.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kos.triple.project.service.MainService;
import kos.triple.project.service.chul.EpilogueService;
import kos.triple.project.vo.BannerVO;

@Controller
public class MainController {
	
	@Autowired
	MainService service;

	//main페이지
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main(HttpServletRequest req, Model model) {
		System.out.println("main()");
		
		service.getHomePageRecomandList(req,model);
		
		return "main/main";
	}
	
	//main페이지
	@RequestMapping(value="mainNotice")
	public String mainNotice(HttpServletRequest req, Model model) {
		System.out.println("mainNotice()");
		
		service.getNewNotice(req,model);
		
		return "main/mainNotice";
		
	}
	
	//관리자페이지
	@RequestMapping(value="adminMain")
	public String adminMain() {
		return "main/adminMain";
	}
	
	//로그아웃
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "main/main";
	}
	
	//로그인페이지
	@RequestMapping(value="loginForce")
	public String loginForce(HttpServletRequest req) {
		
		return "main/loginForm";
	}
	
	//마이페이지 시작화면
	@RequestMapping(value="myPageHome")
	public String myPageHome(HttpServletRequest req , Model model) {
		
		service.getMyFaceImg(req,model);
		
		return "mypage/myPageHome";
	}
	
	@RequestMapping(value="getBanner")
	public @ResponseBody BannerVO getBannerMyPage(HttpServletRequest req , Model model){
		
		service.getBanner(req,model);
		BannerVO bannerVO = (BannerVO)req.getAttribute("bannerVO");
		return bannerVO;
	
	}
	
	@RequestMapping(value="getBannerCount")
	public @ResponseBody String getBannerMyPageCount(HttpServletRequest req , Model model){
		String count = "0";
		service.getBannerCount(req,model);
		count = (String)req.getAttribute("bannerCount");
		return count;
	
	}
	
	//철환이형 컨트롤러로 옮긴다.
	@RequestMapping(value="myNewStory")
	public String myNewStory(HttpServletRequest req , Model model) {
		
		service.myNewStory(req,model);
		
		return "mypage/story/myNewStory";
	}
	
	@RequestMapping(value="myEpilogueList")
	public String myEpilogueList(HttpServletRequest req , Model model) {
		
		service.myEpilogueList(req,model);
		
		return "mypage/story/myEpilogueList";
	}
	
	@RequestMapping(value="deleteMyStory")
	public @ResponseBody String deleteMyStory(HttpServletRequest req, Model model) {
		String cnt = "0";
		service.deleteMyStory(req,model);
		
		cnt = (String)req.getAttribute("cnt");
		
		return cnt;
	}
	
	
	//철환이형 컨트롤러로 옮긴다.
	
	//호선이 컨트롤러로 옮긴다.
	@RequestMapping(value="myNewPlan")
	public String myNewPlan(HttpServletRequest req , Model model) {
		
		service.myNewPlan(req,model);
		
		return "mypage/plan/myNewPlan";
	}
	
}


