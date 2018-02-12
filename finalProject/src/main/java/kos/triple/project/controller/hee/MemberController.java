package kos.triple.project.controller.hee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kos.triple.project.service.hee.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	//ȸ������ó��
	@RequestMapping(value="register")
	public ModelAndView register(HttpServletRequest req , Model model) {
		System.out.println("register()");
		
		ModelAndView mav = new ModelAndView();
		RedirectView redirectView = new RedirectView("main");
		redirectView.setContextRelative(true);
		
		mav.setView(redirectView);
		service.inputMemberPro(req, model);
		
		return mav;
	}
	
	// ���̵� �ߺ�
	@RequestMapping(value="idCheck")
	public @ResponseBody String idCheck(HttpServletRequest req , Model model) {
		System.out.println("idCheck()");
		
		String cnt = "0";
		
		service.confirmId(req, model);
		cnt = (String)req.getAttribute("cnt");
		
		return cnt;
	}

	//�α���ó��
	@RequestMapping(value="login")
	public String login(HttpServletRequest req , Model model) {
		System.out.println("login()");
		
		service.loginPro(req, model);

		return "main/loginRedirect";
		
	}
	
	// ���̵� ã��
	@RequestMapping(value="findId")
	public String findId(HttpServletRequest req , Model model) {
		System.out.println("findId()");

		return "mypage/findId";
	}
	
	// ��й�ȣ ã��  ******** ����
	@RequestMapping(value="findPwd")
	public String findPwd(HttpServletRequest req , Model model) {
		System.out.println("findPwd()");

		return "mypage/findPwd";
	}
	
	// ��й�ȣ ã�� ��� ������(������ȣ ��)
	@RequestMapping(value="findPwdResult")
	public String findPwdResult(HttpServletRequest req , Model model) {
		System.out.println("findPwdResult()");
		
		service.getPwd(req, model);
		
		return "mypage/findPwdResult";
		
	}
	
	// ��й�ȣ ã�� �̸��� �ڵ� ������ ******** �߰�
	@RequestMapping(value="findPwdEmailChk")
	public String findPwdEmailChk(HttpServletRequest req , Model model) {
		System.out.println("findPwdEmailChk()");
		
		service.findPwdEmailChk(req, model);

		return "mypage/findPwdEmailChk";
	}	
	
	// ����Ű �Է� Ȯ�� ************* �߰�
	@RequestMapping(value="inputKeyPro")
	public String inputKeyPro(HttpServletRequest req , Model model) {
		System.out.println("inputKeyPro()");
		
		service.inputkeyPro(req, model);
		
		return "mypage/inputKeyPro";
		
	}
	
	// ��й�ȣ ���� ************* �߰�
	@RequestMapping(value="modifyPwd")
	public String modifyPwd(HttpServletRequest req , Model model) {
		System.out.println("modifyPwd()");
		
		String mem_id = req.getParameter("mem_id");
		model.addAttribute("mem_id",mem_id);
		
		return "mypage/modifyPwd";
	}	
		
	
	// ������ȣ Ȯ�� �� ��й�ȣ ���� ó��
	@RequestMapping(value="modifyPwdProc")
	public String modifyPwdProc(HttpServletRequest req , Model model) {
		System.out.println("modifyPwdProc()");
		
		service.setUserPassword(req,model);
		
		int cnt = (Integer)req.getAttribute("cnt");
		
		model.addAttribute("successModifyPwd",cnt);
		
		return "mypage/modifyPwdProc";
	}
		
	
	// ���̵� ã�� ��� ������
	@RequestMapping(value="findIdResult")
	public String findIdResult(HttpServletRequest req , Model model) {
		System.out.println("findIdResult()");
		
		service.getId(req, model);
		
		return "mypage/findIdResult";
		
	}
	
	
	// ���� ������
	@RequestMapping(value="myPageStart")
	public String myPageStart(HttpServletRequest req , Model model) {
		System.out.println("myPageStart()");
		
		return "mypage/myPageStart";
		
	}
	
	// ȸ�� ���� ���� ��
	@RequestMapping(value="modifyForm")
	public String modifyForm(HttpServletRequest req , Model model) {
		System.out.println("modifyForm()");
		
		return "mypage/modifyForm";
		
	}
	
	// ȸ�� ���� ���� �� ������
	@RequestMapping(value="modifyView")
	public String modifyView(HttpServletRequest req , Model model) {
		System.out.println("modifyView()");
		
		service.modifyView(req, model);
		
		return "mypage/modifyView";
		
	}
	
	// ȸ�� ���� ���� ó�� ������
	@RequestMapping(value="modifyPro")
	public String modifyPro(MultipartHttpServletRequest req , Model model) {
		System.out.println("modifyPro()");
		
		service.modifyPro(req, model);
		
		return "mypage/modifyPro";
		
	}

	// ȸ�� Ż�� ������
	@RequestMapping(value="deleteForm")
	public String deleteForm(HttpServletRequest req , Model model) {
		System.out.println("deleteForm()");
		
		return "mypage/deleteForm";
		
	}	
	
	// ȸ�� Ż�� ó�� ������	
	@RequestMapping(value="deletePro")
	public String deletePro(HttpServletRequest req , Model model) {
		System.out.println("deletePro()");
		
		service.deletePro(req, model);
		
		return "mypage/deletePro";
		
	}	
	
	//���������� ����
	@RequestMapping(value="myReservation")
	public ModelAndView myReservation(HttpServletRequest req , ModelAndView mav) {
		System.out.println("myReservation()");
		
		RedirectView redirectView = new RedirectView("myPageReservationStart");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
		
	}
	
	//���������� ����
	@RequestMapping(value="faceImgUpload")
	public @ResponseBody String faceImgUpload(MultipartHttpServletRequest req , Model model) {
		System.out.println("faceImgUpload()");
		
		service.faceImgUpload(req,model);
		
		return "1";
		
	}
	
	

}
