package kos.triple.project.controller.kwak;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kos.triple.project.etc.DateProcess;
import kos.triple.project.service.kwak.PlanServiceImpl;
import kos.triple.project.vo.WhereVO;

@Controller
public class PlanController {

	@Autowired
	PlanServiceImpl pservice;
	
	
	//��ȹ�ϱ� ������
	@RequestMapping(value="plan", method=RequestMethod.GET)
	public String plan(HttpServletRequest req, Model model) {
		System.out.println("plan()");
		
		pservice.selectCourseMain(req, model);
		
		return "plan/plan";
	}
	
	//��ȹ�ϱ� ������
	@RequestMapping(value="makeplan", method=RequestMethod.GET)
	public ModelAndView makeplan(HttpServletRequest req, Model model) {
		System.out.println("makeplan()");
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		ModelAndView mav = new ModelAndView();
		RedirectView rd = null;
		
		if(mem_id==null) {
			rd = new RedirectView("loginForce");
		}
		else {
			rd = new RedirectView("makeplanGo");
		}

		mav.setView(rd);
		
		return mav;
	}
	
	@RequestMapping(value="makeplanGo", method=RequestMethod.GET)
	public String makeplanGo(HttpServletRequest req, Model model) {
		System.out.println("makeplanGo()");
		return "plan/makeplan";
	}
	
	//��ȹ�ϱ�ٸ���� �ڽ� �󼼺���
	@RequestMapping(value="planCourseContent", method=RequestMethod.GET)
	public String planCourseContent(HttpServletRequest req, Model model) {
		System.out.println("planCourseContent()");
		
		pservice.selectCourseContent(req, model);
		
		return "plan/planCourseContent";
	}
	
	//1��° plan insert
	@RequestMapping(value="insertPlan")
	public String insertPlan(HttpServletRequest req, Model model) {
		System.out.println("insertPlan()");	
		
		pservice.insertPlan(req, model);
		
		return "plan/plandata/planArea";		
	}
	
	//detailplan
	@RequestMapping(value="detailplan")
	public String detailplan(HttpServletRequest req, Model model) {
		int planNo = Integer.parseInt(req.getParameter("planNo"));
		
		List<String> dateList = new ArrayList<String>();
		System.out.println("detailplan()");
		
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String choiceDate = req.getParameter("choiceDate");
		choiceDate = choiceDate == null ? "noChoice" : choiceDate;
		
		System.out.println("���۳�¥" + startDate);
		System.out.println("���ó�¥ " + choiceDate);
		System.out.println("���ᳯ¥" + endDate);
		
		String[] start = (String[])startDate.split("-");
		String[] end = (String[])endDate.split("-");
		

		DateProcess d = new DateProcess();
		long days = d.diffOfDate(start[0]+start[1]+start[2],end[0]+end[1]+end[2]);
		System.out.println(days+"�ѱⰣ");
		
		String date = startDate;
		System.out.println(date);
		System.out.println("-----------");
		for(int i=0; i<days; i++) {
			if(i==0) {
				date = d.stringDate(date,0);
			}
			else {
				date = d.stringDate(date,1);
			}
			System.out.println(date);
			if(!choiceDate.equals(date)) {
				dateList.add(date);
			}
		}
		
		model.addAttribute("choiceDate",choiceDate);
		model.addAttribute("period",dateList);
		model.addAttribute("planNo", planNo);
		return "plan/detailplan";
	}
	
	//�ڽ��� ����
	@RequestMapping(value="detailPlanPro")
	public String detailPlanPro(HttpServletRequest req, Model model) {
		System.out.println("detailPlanPro()");
		//���۳�¥ ���ᳯ¥ 
		//���ó�¥
		
		pservice.insertPlanPro(req, model);
		
		return "plan/plandata/detailPlanPro";
	}
	
	//detail_location
	@RequestMapping(value="detail_location")
	public String detail_location(HttpServletRequest req, Model model) {
		System.out.println("detail_location()");
		
		String area = req.getParameter("area");
		System.out.println(area);
		
		pservice.selectlocation(req, model);
		
		return "plan/plandata/detail_location";
	}
	
	//��һѷ��ֱ�
	@RequestMapping(value="getLocation")
	public String getLocation(HttpServletRequest req, Model model) {
		System.out.println("getLocation()");
		
		pservice.getLocation(req,model);
		List<WhereVO> voList = (List<WhereVO>)req.getAttribute("WhereVOList");
		
		model.addAttribute("locationInfo",voList);
		return "plan/plandata/searchLocationView";
	}
	
	//���� ��ȹ����
	@RequestMapping(value="myPlan")
	public String myPlan(HttpServletRequest req, Model model) {
		System.out.println("myPlan()");
		
		pservice.selectMyPlan(req, model);
		
		return "plan/myPlan";
	}
	
	
	//�������������� ���ǰ�ȹ(����������ó��)
	@RequestMapping("myPagePlan")
	public String myPagePlan(HttpServletRequest req, Model model) {
		System.out.println("myPagePlan()");
		
		pservice.selectMyPlan(req, model);
		
		model.addAttribute("setIframe","myPlan");
		return "mypage/myPageStart";
	}
	
	//���� �󼼰�ȹ����
	@RequestMapping(value="myPlanCourseContent")
	public String myPlanCourseContent(HttpServletRequest req, Model model) {
		System.out.println("myPlanCourseContent()");
		
		pservice.selectCourseContent(req, model);
		
		return "plan/myPlanCourseContent";
	}
	
	//��ȹ ����
	@RequestMapping(value="modifyPlan")
	public String modifyPlan(HttpServletRequest req, Model model) {
		System.out.println("modifyPlan()");
		
		String planTitle = req.getParameter("planTitle");
		String planContent = req.getParameter("planContent");
		int planNo = Integer.parseInt(req.getParameter("planNo"));
		
		model.addAttribute("planTitle", planTitle);
		model.addAttribute("planContent", planContent);
		model.addAttribute("planNo", planNo);
		
		return "plan/modifyPlan";
	}
	
	//��ȹ��� ���� ����
	@RequestMapping(value="updatePlan")
	public String updatePlan(HttpServletRequest req, Model model) {
		System.out.println("updatePlan()");	
		
		pservice.updatePlan(req, model);
		pservice.selectCourseContent(req, model);
		
		return "plan/plandata/planAreaModify";		
	}
	
	//detailplan
	@RequestMapping(value="detailModifyPlan")
	public String detailModifyPlan(HttpServletRequest req, Model model) {
		
		int planNo = Integer.parseInt(req.getParameter("planNo"));
		
		List<String> dateList = new ArrayList<String>();
		System.out.println("detailModifyPlan()");
		
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String choiceDate = req.getParameter("choiceDate");
		choiceDate = choiceDate == null ? "noChoice" : choiceDate;
		
		System.out.println("���۳�¥" + startDate);
		System.out.println("���ó�¥ " + choiceDate);
		System.out.println("���ᳯ¥" + endDate);
		
		String[] start = (String[])startDate.split("-");
		String[] end = (String[])endDate.split("-");
		

		DateProcess d = new DateProcess();
		long days = d.diffOfDate(start[0]+start[1]+start[2],end[0]+end[1]+end[2]);
		System.out.println(days+"�ѱⰣ");
		
		String date = startDate;
		System.out.println(date);
		System.out.println("-----------");
		for(int i=0; i<days; i++) {
			if(i==0) {
				date = d.stringDate(date,0);
			}
			else {
				date = d.stringDate(date,1);
			}
			System.out.println(date);
			if(!choiceDate.equals(date)) {
				dateList.add(date);
			}
		}
		
		model.addAttribute("choiceDate",choiceDate);
		model.addAttribute("period",dateList);
		model.addAttribute("planNo", planNo);
		return "plan/detailplan";
	}
}
