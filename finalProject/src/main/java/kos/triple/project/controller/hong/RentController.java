package kos.triple.project.controller.hong;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kos.triple.project.service.hong.CarServiceImpl;
import kos.triple.project.vo.CarInfoVO;

@Controller
public class RentController {
	
	@Autowired
	CarServiceImpl service;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	//��Ʈī ��� ������
	@RequestMapping(value="rentAddPage")
	public String rentAddPage(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : rentAdd() ===============================");
		
		return "main/adminMain/rentCar/rentAddPage";
	}
	
	//��Ʈī ���  ó��
	@RequestMapping(value="rentAdd")
	public String rentAdd(MultipartHttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : rentAdd() ===============================");
		service.rentAdd(req, model);
		
		return "pro/hongPro/rentAddPro";
	}
	


	//��Ʈī���� ������
	@RequestMapping(value="rentDeletePage")
	public String rentDeletePage(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : rentDelete() ===============================");
		
		
		return "main/adminMain/rentCar/rentDeletePage";
	}
	
	//��Ʈī���� ó��
	@RequestMapping(value="rentDelete")
	public String rentDelete(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : rentDelete() ===============================");
		
		service.rentDelete(req, model);
		
		return "pro/hongPro/rentDeletePro";
	}
	
	//��Ʈī ���� ����Ʈ
	@RequestMapping(value="rentReservationList")
	public String rentReservationList(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : rentReservationList() ===============================");
		service.rentReservationList(req, model);
		
		return "main/adminMain/rentCar/rentReservationList";
	}
	
	//��Ʈī ���� ��� ����Ʈ
	@RequestMapping(value="rentReservationCancelList")
	public String rentReservationCancelList(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : rentDelete() ===============================");
				
		return "main/adminMain/rentCar/rentReservationCancelList";
	}
	
	//��Ʈī ��ȸ ������ - �Խ�Ʈ
	@RequestMapping(value="rentReservation")
	public String rentReservation(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : rent() ===============================");
		
		return "reservation/car/rent";
	}
	
	//��Ʈī��� ������ - �Խ�Ʈ
	@RequestMapping(value="rentList")
	public String carList(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : rentList() ===============================");
		service.rentCar(req, model);
		
		
		return "reservation/car/rentList";

	}	
	
	//��Ʈī��� ������ - ����������
	@RequestMapping(value="getViewDetail")
	public @ResponseBody CarInfoVO getViewDetail(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : getViewDetail() ===============================");
		System.out.println("�Ѱܹ��� �ڵ�����ȣ : " + req.getParameter("car_num"));
		service.getViewDetail(req,model);
		
		CarInfoVO vo = (CarInfoVO) req.getAttribute("vo");
		
		return vo;

	}	
	
	//��Ʈī �����ϱ�
	@RequestMapping(value="rentRequestReservation")
	public String requestReservation(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : requestReservation() ===============================");
		service.rentReservation(req, model);
		
		
		return "reservation/car/rentResComplete";

	}	
	
	//���� ���	
	@RequestMapping(value="carResCancel")
	public ModelAndView carResCancel(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : carResCancel() ===============================");

		service.carResCancel(req, model);
		
		ModelAndView mav = new ModelAndView();
		RedirectView redirectView = new RedirectView("getCarResList");
		redirectView.setContextRelative(true);
		
		mav.setView(redirectView);
		
		return mav;

	}	
	
	//��Ʈī �ݳ�
	@RequestMapping(value="carResReturn")
	public ModelAndView carResReturn(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : carResReturn() ===============================");
		service.carResReturn(req, model);
		ModelAndView mav = new ModelAndView();
		RedirectView redirectView = new RedirectView("getCarResList");
		redirectView.setContextRelative(true);
		
		mav.setView(redirectView);
		
		return mav;
	}
	
	//���
	@RequestMapping(value="carSalePage")
	public String rentTotal(HttpServletRequest req, Model model) {
		
		log.debug("=============================== Method Name : rentTotal() ===============================");
	    service.rentTotal(req, model);
		
		return "main/adminMain/sale/carSale/rentTotal";
	}


}
