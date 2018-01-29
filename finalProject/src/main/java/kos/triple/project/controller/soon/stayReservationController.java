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

	// ���� ���� ����
	@RequestMapping(value = "stayReservation")
	public String stayReservation(HttpServletRequest req, Model model) {
		System.out.println("stayReservation()");

		return "reservation/stay/stayReservation_main";
	}

	// ���� ���� �˻�
	@RequestMapping(value = "stay_search")
	public String stay_search(HttpServletRequest req, Model model) {
		System.out.println("stay_search()");

		service.stay_search(req, model);

		return "reservation/stay/stay_search";
	}

	// ������ �� ����
	@RequestMapping(value = "stay_view")
	public String stay_view(HttpServletRequest req, Model model) {
		System.out.println("stay_view()");

		service.stay_view(req, model);

		return "reservation/stay/stay_view";
	}

	// ���� ���� �˻� iframe
	@RequestMapping(value = "stay_room_search")
	public String stay_room_search(HttpServletRequest req, Model model) {
		System.out.println("stay_room_search()");

		service.stay_room_search(req, model);

		return "reservation/stay/stay_room_search";
	}

	// ���� ���� ����
	@RequestMapping(value = "stay_room_view")
	public String stay_room_view(HttpServletRequest req, Model model) {
		System.out.println("stay_room_view()");

		service.stay_room_view(req, model);

		return "reservation/stay/stay_room_view";
	}

	// ���� ���� ���� ó��
	@RequestMapping(value = "stay_room_reservation")
	public String stay_room_reservation(HttpServletRequest req, Model model) {
		System.out.println("stay_room_reservation()");

		service.stay_room_reservation(req, model);

		return "pro/soonPro/stayPro2";
	}

	// ���� ���� ���� ��� ó��
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

	// ������
	// ������ �߰�
	@RequestMapping(value = "stay_add")
	public String stay_add(HttpServletRequest req, Model model) {
		System.out.println("stay_add()");

		return "main/adminMain/stay/stay_add";
	}

	// ������ �߰� ó��
	@RequestMapping(value = "stay_add_Pro")
	public String stay_add_Pro(MultipartHttpServletRequest req, Model model) {
		System.out.println("stay_add_Pro()");

		service.stay_add(req, model);

		return "pro/soonPro/stayPro";
	}

	// ������ ���
	@RequestMapping(value = "stay_list")
	public String stay_list(HttpServletRequest req, Model model) {
		System.out.println("stay_list()");

		service.stay_list(req, model);

		return "main/adminMain/stay/stay_list";
	}

	// ������ ���� ����
	@RequestMapping(value = "stay_list_view")
	public String stay_list_view(HttpServletRequest req, Model model) {
		System.out.println("stay_list_view()");

		service.stay_list_view(req, model);

		return "main/adminMain/stay/stay_list_view";
	}

	// ������ ����
	@RequestMapping(value = "stay_modify")
	public String stay_modify(MultipartHttpServletRequest req, Model model) {
		System.out.println("stay_modify()");

		service.modify(req, model);

		return "pro/soonPro/stayPro";
	}

	// ������ ����
	@RequestMapping(value = "stay_delete")
	public String stay_delete(HttpServletRequest req, Model model) {
		System.out.println("stay_delete()");

		service.delete(req, model);

		return "pro/soonPro/stayPro";
	}

	// ������ ���� �߰�
	@RequestMapping(value = "stay_room_add")
	public String stay_room_add(HttpServletRequest req, Model model) {
		System.out.println("stay_room_add()");

		String stay_no = req.getParameter("stay_no");
		model.addAttribute("stay_no", stay_no);

		return "main/adminMain/stay/stay_room_add";
	}

	// ������ ���� �߰� ó��
	@RequestMapping(value = "stay_room_add_Pro")
	public String stay_room_add_Pro(MultipartHttpServletRequest req, Model model) {
		System.out.println("stay_room_add_Pro()");

		service.stay_room_add(req, model);

		return "pro/soonPro/stayPro";
	}

	// ������ ���� ���
	@RequestMapping(value = "stay_room_list")
	public String stay_room_list(HttpServletRequest req, Model model) {
		System.out.println("stay_room_list()");

		service.stay_room_list(req, model);

		return "main/adminMain/stay/stay_room_list";
	}

	// ������ ���� ���� ����
	@RequestMapping(value = "stay_room_list_view")
	public String stay_room_list_view(HttpServletRequest req, Model model) {
		System.out.println("stay_room_list_view()");

		service.stay_room_list_view(req, model);

		return "main/adminMain/stay/stay_room_list_view";
	}

	// ������ ���� ����
	@RequestMapping(value = "stay_room_modify")
	public String stay_room_modify(MultipartHttpServletRequest req, Model model) {
		System.out.println("stay_room_modify()");

		service.stay_room_modify(req, model);

		return "pro/soonPro/stayPro";
	}

	// ������ ���� ����
	@RequestMapping(value = "stay_room_delete")
	public String stay_room_delete(HttpServletRequest req, Model model) {
		System.out.println("stay_room_delete()");

		service.stay_room_delete(req, model);

		return "pro/soonPro/stayPro";
	}

	// ���� ���� ��Ȳ
	@RequestMapping(value = "stay_reservation_list")
	public String stay_reservation_list(HttpServletRequest req, Model model) {
		System.out.println("stay_reservation_list()");

		service.stay_reservation_list(req, model);

		return "main/adminMain/stay/stay_reservation_list";
	}

	// ���� ���� ���
	@RequestMapping(value = "staySalePage")
	public String stay_reservation_total(HttpServletRequest req, Model model) {
		System.out.println("stay_reservation_total()");

		service.stay_reservation_total(req, model);

		return "main/adminMain/sale/staySale/staySalePage";
	}

}
