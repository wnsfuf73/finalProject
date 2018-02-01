package kos.triple.project.controller.joon;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kos.triple.project.service.joon.AirReservationService;
import kos.triple.project.vo.AirPlaneVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.SeatPriceVO;

@Controller
public class AirReservationController {
	
	@Autowired
	AirReservationService service;
	
	/* Ŭ���̾�Ʈ ������ */
	
	
	/* Ŭ���̾�Ʈ ������ */
	@RequestMapping(value="airReservation")
	public String airReservation(HttpServletRequest req, Model model) {
		
		service.getAirPortInfo(req,model);
		
		return "reservation/air/airReservationStart";
	}
	
	@RequestMapping(value="airPlaneSearch")
	public String airPlaneSearch(HttpServletRequest req ,Model model) {
		System.out.println("airPlaneSearch() ");
		
		System.out.println(req.getParameter("seatLevel"));
		System.out.println(req.getParameter("startAirport_Key"));
		System.out.println(req.getParameter("endAirport_Key"));
		System.out.println(req.getParameter("s_fromDate"));
		System.out.println(req.getParameter("s_toDate"));
		
		service.airPlaneSearch(req,model);
		
		
		return "reservation/air/searchResult";
	}
	
	//Ƽ�ϱ��Ź�ư������ �̵���������
	@RequestMapping(value="airTiketBuyPageStep1")
	public String airTiketBuyPage(HttpServletRequest req ,Model model) {
		
		System.out.println("airTiketBuyPageStep1() ");
	
		service.getReserVationInfo(req,model);
		
		return "reservation/air/airTiketBuyPageStep1";
	}
	
	
	//Ƽ�ϱ��Ź�ư������ �̵���������
	@RequestMapping(value="airReservating")
	public String airReservating(HttpServletRequest req ,Model model) {
		
		System.out.println("airReservating() ");
		
		String airPlaneNo = req.getParameter("airPlaneNo");
		String startLocation = req.getParameter("startLocation");
		String endLocation = req.getParameter("endLocation");
		
		String price = req.getParameter("price");
		price = price == null ? "0" : price;
		
		String adult = req.getParameter("adult");
		adult = adult == null ? "0" : adult;
		
		String student = req.getParameter("student");
		student = student == null ? "0" : student;
		
		String baby = req.getParameter("baby");
		baby = baby == null ? "0" : baby;
		
		String seatLevel_adult = req.getParameter("seatLevel_adult");
		String seatLevel_student = req.getParameter("seatLevel_student");
		String seatLevel_baby = req.getParameter("seatLevel_baby");
		String startTime = req.getParameter("startTime");
		String endTime = req.getParameter("endTime");
		
		System.out.println("Ƽ�ϱ��Ź�ư������ : " + startTime);
		System.out.println("Ƽ�ϱ��Ź�ư������ : " + endTime);
		AirReservationDetailVO vo = new AirReservationDetailVO();
		
		vo.setAirPlaneNo(airPlaneNo);
		vo.setStartLocation(startLocation);
		vo.setEndLocation(endLocation);
		
		vo.setPrice(Integer.parseInt(price));
		
		vo.setAdult(Integer.parseInt(adult));
		vo.setStudent(Integer.parseInt(student));
		vo.setBaby(Integer.parseInt(baby));
		
		vo.setSeatLevel_adult(seatLevel_adult);
		vo.setSeatLevel_student(seatLevel_student);
		vo.setSeatLevel_baby(seatLevel_baby);
		
		model.addAttribute("vo",vo);
		model.addAttribute("startTime",startTime);
		model.addAttribute("endTime",endTime);
		
		return "reservation/air/airTiketBuyPageStep2";
	}
	
//�����ϱ� ��ư Ŭ�� -> �����Ϸ�
	@RequestMapping(value="airResProc")
	public String airResProc(HttpServletRequest req ,Model model) {
	
		service.airResProc(req,model);
		
		return "reservation/air/airTiketBuyPageStep3";
	}
	
	//���� �¼��� �����´�.
	@RequestMapping(value="getRemainSeat")
	public @ResponseBody AirPlaneVO getRemainSeat(HttpServletRequest req) {
	
		AirPlaneVO vo = null;
		
		service.getRemainSeat(req);
		
		vo = (AirPlaneVO)req.getAttribute("vo");
		System.out.println("---------------------");
		System.out.println(vo.getAirPlaneNo());
		System.out.println(vo.getNomal());
		System.out.println(vo.getHighClass());
		System.out.println(vo.getPremium());
		System.out.println("---------------------");
		
		return vo;
	}
	
	//���� ��ҹ�ư�� ��������
	//window.location="airResCancel?airplaneNo="+airplaneNo+"&airResNo="+airResNo;
	@RequestMapping(value="airResCancel")
	public ModelAndView airResCancel(HttpServletRequest req , Model model) {
		
		
		//���ó��
		service.airResCancelProc(req, model);
		
		
		ModelAndView mav = new ModelAndView();
		
		RedirectView redirectView = new RedirectView("getAirResList");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
	}
	
	
	/* Ŭ���̾�Ʈ ������ */
	
	/* ������������ */
	
	//�װ�������
	@RequestMapping(value="airReservationList")
	public String airReservationList(HttpServletRequest req , Model model) {
		System.out.println("airReservationList()");
		
		service.getAirReserVationList(req,model);
		
		return "main/adminMain/airPlane/airReservationList";
	}
	
	//�װ�������Ҹ��
	@RequestMapping(value="airReservationCancelList")
	public String airReservationCancelList() {
		System.out.println("airReservationCancelList()");
		return "main/adminMain/airPlane/airReservationCancelList";
	}		
	
	
	//�װ��뼱�߰�
	@RequestMapping(value="airPlaneAdd")
	public String airPlaneAdd(HttpServletRequest req, Model model) {
		System.out.println("airPlaneAdd()");
		
		service.deadPlaneCollection(req,model);
		service.getAirPortInfo(req,model);
		service.getAirPlane(req,model);
		
		return "main/adminMain/airPlane/airPlaneAdd";
		
	}		
	
	//�װ�������������
	@RequestMapping(value="airOperationChange")
	public String airOperationChange(HttpServletRequest req , Model model) {
		System.out.println("airOperationChange()");
		
		service.getAirPlaneAll(req,model);
		service.getAirPortInfo(req,model);
		service.getSeatDefaultPrice(req,model);
		return "main/adminMain/airPlane/airOperationChange";
	}		
	
	//�� ���׻����� �Ÿ��� ����
	@RequestMapping(value="getMoveDistance")
	public @ResponseBody String getMoveDistance(HttpServletRequest req) {
		System.out.println("getMoveDistance()");
		
		service.getMoveDistance(req);
		
		String result = (String)req.getAttribute("distance");
		return result;
	}
	
	//��θ� ������
	@RequestMapping(value="setRoute")
	public ModelAndView setRoute(HttpServletRequest req , ModelAndView mav) {
		System.out.println("setRoute() ");
		
		service.setRoute(req);
		
		RedirectView redirectView = new RedirectView("airOperationChange");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
	}
	
	//��μ����� �����
	@RequestMapping(value="setRouteCancel")
	public ModelAndView setRouteCancel(HttpServletRequest req , ModelAndView mav) {
		System.out.println("setRouteCancel() ");
		
		service.setRouteCancel(req);
		
		RedirectView redirectView = new RedirectView("airOperationChange");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
	}
	
	//�⺻�������μ���(������������)
	@RequestMapping(value="setSeatPrice")
	public ModelAndView setSeatPrice(HttpServletRequest req , ModelAndView mav) {
		System.out.println("setSeatPrice() ");
		
		service.setSeatPrice(req);
		
		RedirectView redirectView = new RedirectView("airOperationChange");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
	}
	
	//�Է��Ѱ�������å��
	@RequestMapping(value="setCustomSeatPrice")
	public ModelAndView setCustomSeatPrice(HttpServletRequest req , ModelAndView mav) {
		System.out.println("setCustomSeatPrice() ");
		
		service.setCustomSeatPrice(req);
		
		RedirectView redirectView = new RedirectView("airOperationChange");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
	}
	
	//å���� ���� ������ ��������
	@RequestMapping(value="getSeatPriceInfo")
	public @ResponseBody SeatPriceVO getSeatPriceInfo(HttpServletRequest req) {
		System.out.println("getSeatPriceInfo() ");
		
		service.getSeatPriceInfo(req);
		
		SeatPriceVO vo = (SeatPriceVO)req.getAttribute("seatPriceVO");
		return vo;
	}
	
	//å����Ŀ���Ұ��� �����ϱ�
	@RequestMapping(value="modifySeatPrice")
	public ModelAndView modifySeatPrice(HttpServletRequest req , ModelAndView mav) {
		System.out.println("modifySeatPrice() ");
		
		service.modifySeatPrice(req);
		
		RedirectView redirectView = new RedirectView("airOperationChange");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
	}
	
	//�⺻���� ������Ʈ�ϱ�
	@RequestMapping(value="setDefaultPriceUpdate")
	public @ResponseBody String setDefaultPriceUpdate(HttpServletRequest req ,  @RequestBody Map<String,Object> map) {
		
		map.forEach((k,v)->{
			System.out.println(k + " : " + v);
		});
		
		service.setDefaultPriceUpdate(req,map);
		int cnt = (Integer)req.getAttribute("isSuccess");
		
		return Integer.toString(cnt);
	}
	
	//����������������
	@RequestMapping(value="getAirPortInfo")
	public String getAirPortInfo(HttpServletRequest req , Model model) {
		System.out.println("getAirPortInfo()");
		service.getAirPortInfo(req,model);
		return "main/adminMain/airPlane/airOperationChange";
	}		
	
	//�װ����߰�
	@RequestMapping(value="addAirPlane",produces = "application/text; charset=utf8")
	public @ResponseBody String addAirPlane(HttpServletRequest req) {
		
		System.out.println("addAirPlane() ");
		
		service.addAirPlane(req);
		
		String result = (String)req.getAttribute("result");
		return result;
	}
	
	//�װ������
	@RequestMapping(value="deleteAirplane")
	public ModelAndView deleteAirplane(HttpServletRequest req , ModelAndView mav) {
		
		System.out.println("deleteAirplane() ");
		
		
		service.deleteAirPlane(req);
		
		RedirectView redirectView = new RedirectView("airPlaneAdd");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
	}
	
	//�װ�����������(�װ���������������)
	@RequestMapping(value="modifyAirPlaneShow")
	@ResponseBody public AirPlaneVO modifyAirPlaneShow(HttpServletRequest req) {
		System.out.println("modifyAirPlaneShow() ");
		
		service.getAirPlaneOne(req);

		AirPlaneVO vo = (AirPlaneVO)req.getAttribute("airPlane");
		
		return vo;
	}
	
	//�װ�����������(�װ�������ϱ�)
	@RequestMapping(value="modifyAirPlane")
	public ModelAndView modifyAirPlane(HttpServletRequest req , ModelAndView mav) {
		System.out.println("modifyAirPlane() ");
		
		service.modifyAirPlane(req);
		
		RedirectView redirectView = new RedirectView("airPlaneAdd");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
	}
	
	@RequestMapping(value="airSalePage")
	public String carSalePage(HttpServletRequest req , Model model) {
		
		System.out.println("airSalePage() ");
		
		service.getChatDataCustom_Air1(req, model);
		service.getChatDataCustom_Air2(req, model);
		service.getChatDataCustom_Air3(req, model);
		service.getAirTotalPrice(req,model);
		return "main/adminMain/sale/airSale/airSalePage";
	
	}
	/* ������������ */
	
}