package kos.triple.project.controller.soon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kos.triple.project.service.soon.stayReservationService;

@Controller
public class stayReservationController {

	@Autowired
	stayReservationService service;

	// ¼÷¹Ú ¿¹¾à ¸ÞÀÎ
	@RequestMapping(value = "stayReservation")
	public String stayReservation(HttpServletRequest req, Model model) {
		System.out.println("stayReservation()");

		return "reservation/stay/stayReservation_main";
	}

	// ¼÷¹Ú ¿¹¾à °Ë»ö
	@RequestMapping(value = "stay_search")
	public String stay_search(HttpServletRequest req, Model model) {
		System.out.println("stay_search()");

		service.stay_search(req, model);

		return "reservation/stay/stay_search";
	}

	// ¼÷¹ÚÁö »ó¼¼ º¸±â
	@RequestMapping(value = "stay_view")
	public String stay_view(HttpServletRequest req, Model model) {
		System.out.println("stay_view()");

		service.stay_view(req, model);

		return "reservation/stay/stay_view";
	}

	// ¼÷¹Ú °´½Ç °Ë»ö iframe
	@RequestMapping(value = "stay_room_search")
	public String stay_room_search(HttpServletRequest req, Model model) {
		System.out.println("stay_room_search()");

		service.stay_room_search(req, model);

		return "reservation/stay/stay_room_search";
	}

	// ¼÷¹Ú °´½Ç ¿¹¾à
	@RequestMapping(value = "stay_room_view")
	public String stay_room_view(HttpServletRequest req, Model model) {
		System.out.println("stay_room_view()");

		service.stay_room_view(req, model);

		return "reservation/stay/stay_room_view";
	}

	// ¼÷¹Ú °´½Ç ¿¹¾à Ã³¸®
	@RequestMapping(value = "stay_room_reservation")
	public String stay_room_reservation(HttpServletRequest req, Model model) {
		System.out.println("stay_room_reservation()");

		service.stay_room_reservation(req, model);

		return "pro/soonPro/stayPro2";
	}

	// ¼÷¹Ú °´½Ç ¿¹¾à Ãë¼Ò Ã³¸®
	@RequestMapping(value = "stayResCancel")
	public ModelAndView stayResCancel(HttpServletRequest req, Model model) {
		System.out.println("stayResCancel()");

		service.stayResCancel(req, model);

		ModelAndView mav = new ModelAndView();

		RedirectView redirectView = new RedirectView("getStayResList");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
	}

	// °ü¸®ÀÚ
	// ¼÷¹ÚÁö Ãß°¡
	@RequestMapping(value = "stay_add")
	public String stay_add(HttpServletRequest req, Model model) {
		System.out.println("stay_add()");

		return "main/adminMain/stay/stay_add";
	}

	// ¼÷¹ÚÁö Ãß°¡ Ã³¸®
	@RequestMapping(value = "stay_add_Pro")
	public String stay_add_Pro(MultipartHttpServletRequest req, Model model) {
		System.out.println("stay_add_Pro()");

		service.stay_add(req, model);

		return "pro/soonPro/stayPro";
	}

	// ¼÷¹ÚÁö ¸ñ·Ï
	@RequestMapping(value = "stay_list")
	public String stay_list(HttpServletRequest req, Model model) {
		System.out.println("stay_list()");

		service.stay_list(req, model);

		return "main/adminMain/stay/stay_list";
	}

	// ¼÷¹ÚÁö ¼¼ºÎ °ü¸®
	@RequestMapping(value = "stay_list_view")
	public String stay_list_view(HttpServletRequest req, Model model) {
		System.out.println("stay_list_view()");

		service.stay_list_view(req, model);

		return "main/adminMain/stay/stay_list_view";
	}

	// ¼÷¹ÚÁö ¼öÁ¤
	@RequestMapping(value = "stay_modify")
	public String stay_modify(MultipartHttpServletRequest req, Model model) {
		System.out.println("stay_modify()");

		service.modify(req, model);

		return "pro/soonPro/stayPro";
	}

	// ¼÷¹ÚÁö »èÁ¦
	@RequestMapping(value = "stay_delete")
	public String stay_delete(HttpServletRequest req, Model model) {
		System.out.println("stay_delete()");

		service.delete(req, model);

		return "pro/soonPro/stayPro";
	}

	// ¼÷¹ÚÁö °´½Ç Ãß°¡
	@RequestMapping(value = "stay_room_add")
	public String stay_room_add(HttpServletRequest req, Model model) {
		System.out.println("stay_room_add()");

		String stay_no = req.getParameter("stay_no");
		model.addAttribute("stay_no", stay_no);

		return "main/adminMain/stay/stay_room_add";
	}

	// ¼÷¹ÚÁö °´½Ç Ãß°¡ Ã³¸®
	@RequestMapping(value = "stay_room_add_Pro")
	public String stay_room_add_Pro(MultipartHttpServletRequest req, Model model) {
		System.out.println("stay_room_add_Pro()");

		service.stay_room_add(req, model);

		return "pro/soonPro/stayPro";
	}

	// ¼÷¹ÚÁö °´½Ç ¸ñ·Ï
	@RequestMapping(value = "stay_room_list")
	public String stay_room_list(HttpServletRequest req, Model model) {
		System.out.println("stay_room_list()");

		service.stay_room_list(req, model);

		return "main/adminMain/stay/stay_room_list";
	}

	// ¼÷¹ÚÁö °´½Ç ¼¼ºÎ °ü¸®
	@RequestMapping(value = "stay_room_list_view")
	public String stay_room_list_view(HttpServletRequest req, Model model) {
		System.out.println("stay_room_list_view()");

		service.stay_room_list_view(req, model);

		return "main/adminMain/stay/stay_room_list_view";
	}

	// ¼÷¹ÚÁö °´½Ç ¼öÁ¤
	@RequestMapping(value = "stay_room_modify")
	public String stay_room_modify(MultipartHttpServletRequest req, Model model) {
		System.out.println("stay_room_modify()");

		service.stay_room_modify(req, model);

		return "pro/soonPro/stayPro";
	}

	// ¼÷¹ÚÁö °´½Ç »èÁ¦
	@RequestMapping(value = "stay_room_delete")
	public String stay_room_delete(HttpServletRequest req, Model model) {
		System.out.println("stay_room_delete()");

		service.stay_room_delete(req, model);

		return "pro/soonPro/stayPro";
	}

	// ¼÷¹Ú ¿¹¾à ÇöÈ²
	@RequestMapping(value = "stay_reservation_list")
	public String stay_reservation_list(HttpServletRequest req, Model model) {
		System.out.println("stay_reservation_list()");

		service.stay_reservation_list(req, model);

		return "main/adminMain/stay/stay_reservation_list";
	}

	// ¼÷¹Ú ¿¹¾à °á»ê
	@RequestMapping(value = "staySalePage")
	public String stay_reservation_total(HttpServletRequest req, Model model) {
		System.out.println("stay_reservation_total()");

		service.stay_reservation_total(req, model);

		return "main/adminMain/sale/staySale/staySalePage";
	}

}
