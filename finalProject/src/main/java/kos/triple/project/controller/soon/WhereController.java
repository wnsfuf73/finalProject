package kos.triple.project.controller.soon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.service.soon.WhereService;

@Controller
public class WhereController {

	@Autowired
	WhereService service;

	// ��𰥱� ��������
	@RequestMapping(value = "where_main")
	public String where_main(HttpServletRequest req, Model model) {
		System.out.println("where_main()");

		return "where/where_main";
	}

	// ��𰥱� ��������
	@RequestMapping(value = "where_main2")
	public String where_main2(HttpServletRequest req, Model model) {
		System.out.println("where_main2()");

		return "where/where_main_thema/where_main2";
	}

	// ��𰥱� ��������
	@RequestMapping(value = "where_main3")
	public String where_main3(HttpServletRequest req, Model model) {
		System.out.println("where_main3()");

		return "where/where_main_thema/where_main3";
	}

	// ��𰥱� ��������
	@RequestMapping(value = "where_main4")
	public String where_main4(HttpServletRequest req, Model model) {
		System.out.println("where_main4()");

		return "where/where_main_thema/where_main4";
	}

	// ��𰥱� ��� ���
	@RequestMapping(value = "where_iframe")
	public String seoul(HttpServletRequest req, Model model) {
		System.out.println("where_iframe()");

		service.Where_main(req, model);

		return "where/where_iframe";
	}

	// �󼼺���
	@RequestMapping(value = "detail_view")
	public String detail_view(HttpServletRequest req, Model model) {
		System.out.println("detail_view()");

		service.detail_view(req, model);

		return "where/detail_view";
	}

	// �󼼺��� - ��
	@RequestMapping(value = "detail_view_score")
	public String detail_view_score(HttpServletRequest req, Model model) {
		System.out.println("detail_view_score()");

		service.detail_view_score(req, model);

		return "pro/soonPro/wherePro2";
	}

	// �˻�
	@RequestMapping(value = "search")
	public String search(HttpServletRequest req, Model model) {
		System.out.println("search()");

		service.search(req, model);

		return "where/where_search";
	}

	@RequestMapping(value = "contactus")
	public String contactus(HttpServletRequest req, Model model) {
		System.out.println("contactus()");

		return "where/contactus";
	}

	/* ������ ������ */
	// ������ ���� ������
	@RequestMapping(value = "list")
	public String list(HttpServletRequest req, Model model) {
		System.out.println("list()");

		service.Where_list(req, model);

		return "main/adminMain/where/list";
	}

	// ������ �߰� ������
	@RequestMapping(value = "add")
	public String add(HttpServletRequest req, Model model) {
		System.out.println("add()");
		return "main/adminMain/where/add";
	}

	// ������ �߰� ó�� ������
	@RequestMapping(value = "add_Pro")
	public String add_Pro(MultipartHttpServletRequest req, Model model) {
		System.out.println("add_Pro()");

		service.Where_add(req, model);

		return "pro/soonPro/wherePro";
	}

	// ������ ����-1 ������
	@RequestMapping(value = "delete-1")
	public String delete_1(HttpServletRequest req, Model model) {
		System.out.println("delete-1()");
		return "main/adminMain/where/delete-1";
	}

	// ������ ����-2 ������
	@RequestMapping(value = "delete-2")
	public String delete_2(HttpServletRequest req, Model model) {
		System.out.println("delete-2()");

		service.Where_check(req, model);

		return "main/adminMain/where/delete-2";
	}

	// ������ ���� ó�� ������
	@RequestMapping(value = "delete_Pro")
	public String manager_book_DeletePro(HttpServletRequest req, Model model) {
		System.out.println("delete_Pro()");

		service.Where_delete(req, model);

		return "pro/soonPro/wherePro";
	}

	// ������ ���� ������ - 1
	@RequestMapping(value = "modify")
	public String modify(HttpServletRequest req, Model model) {
		System.out.println("modify()");

		service.Where_modify(req, model);

		return "main/adminMain/where/modify";
	}

	// ������ ���� ������ - 2
	@RequestMapping(value = "modify_Pro")
	public String modify_Pro(MultipartHttpServletRequest req, Model model) {
		System.out.println("modify_Pro()");

		service.Where_modify_Pro(req, model);

		return "pro/soonPro/wherePro";
	}
}
