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
	
	//회원가입처리
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
	
	// 아이디 중복
	@RequestMapping(value="idCheck")
	public @ResponseBody String idCheck(HttpServletRequest req , Model model) {
		System.out.println("idCheck()");
		
		String cnt = "0";
		
		service.confirmId(req, model);
		cnt = (String)req.getAttribute("cnt");
		
		return cnt;
	}

	//로그인처리
	@RequestMapping(value="login")
	public String login(HttpServletRequest req , Model model) {
		System.out.println("login()");
		
		service.loginPro(req, model);

		return "main/loginRedirect";
		
	}
	
	// 아이디 찾기
	@RequestMapping(value="findId")
	public String findId(HttpServletRequest req , Model model) {
		System.out.println("findId()");

		return "mypage/findId";
	}
	
	// 비밀번호 찾기  ******** 수정
	@RequestMapping(value="findPwd")
	public String findPwd(HttpServletRequest req , Model model) {
		System.out.println("findPwd()");

		return "mypage/findPwd";
	}
	
	// 비밀번호 찾기 결과 페이지(인증번호 란)
	@RequestMapping(value="findPwdResult")
	public String findPwdResult(HttpServletRequest req , Model model) {
		System.out.println("findPwdResult()");
		
		service.getPwd(req, model);
		
		return "mypage/findPwdResult";
		
	}
	
	// 비밀번호 찾기 이메일 코드 보내기 ******** 추가
	@RequestMapping(value="findPwdEmailChk")
	public String findPwdEmailChk(HttpServletRequest req , Model model) {
		System.out.println("findPwdEmailChk()");
		
		service.findPwdEmailChk(req, model);

		return "mypage/findPwdEmailChk";
	}	
	
	// 인증키 입력 확인 ************* 추가
	@RequestMapping(value="inputKeyPro")
	public String inputKeyPro(HttpServletRequest req , Model model) {
		System.out.println("inputKeyPro()");
		
		service.inputkeyPro(req, model);
		
		return "mypage/inputKeyPro";
		
	}
	
	// 비밀번호 변경 ************* 추가
	@RequestMapping(value="modifyPwd")
	public String modifyPwd(HttpServletRequest req , Model model) {
		System.out.println("modifyPwd()");
		
		String mem_id = req.getParameter("mem_id");
		model.addAttribute("mem_id",mem_id);
		
		return "mypage/modifyPwd";
	}	
		
	
	// 인증번호 확인 후 비밀번호 변경 처리
	@RequestMapping(value="modifyPwdProc")
	public String modifyPwdProc(HttpServletRequest req , Model model) {
		System.out.println("modifyPwdProc()");
		
		service.setUserPassword(req,model);
		
		int cnt = (Integer)req.getAttribute("cnt");
		
		model.addAttribute("successModifyPwd",cnt);
		
		return "mypage/modifyPwdProc";
	}
		
	
	// 아이디 찾기 결과 페이지
	@RequestMapping(value="findIdResult")
	public String findIdResult(HttpServletRequest req , Model model) {
		System.out.println("findIdResult()");
		
		service.getId(req, model);
		
		return "mypage/findIdResult";
		
	}
	
	
	// 마이 페이지
	@RequestMapping(value="myPageStart")
	public String myPageStart(HttpServletRequest req , Model model) {
		System.out.println("myPageStart()");
		
		return "mypage/myPageStart";
		
	}
	
	// 회원 정보 수정 폼
	@RequestMapping(value="modifyForm")
	public String modifyForm(HttpServletRequest req , Model model) {
		System.out.println("modifyForm()");
		
		return "mypage/modifyForm";
		
	}
	
	// 회원 정보 수정 상세 페이지
	@RequestMapping(value="modifyView")
	public String modifyView(HttpServletRequest req , Model model) {
		System.out.println("modifyView()");
		
		service.modifyView(req, model);
		
		return "mypage/modifyView";
		
	}
	
	// 회원 정보 수정 처리 페이지
	@RequestMapping(value="modifyPro")
	public String modifyPro(MultipartHttpServletRequest req , Model model) {
		System.out.println("modifyPro()");
		
		service.modifyPro(req, model);
		
		return "mypage/modifyPro";
		
	}

	// 회원 탈퇴 페이지
	@RequestMapping(value="deleteForm")
	public String deleteForm(HttpServletRequest req , Model model) {
		System.out.println("deleteForm()");
		
		return "mypage/deleteForm";
		
	}	
	
	// 회원 탈퇴 처리 페이지	
	@RequestMapping(value="deletePro")
	public String deletePro(HttpServletRequest req , Model model) {
		System.out.println("deletePro()");
		
		service.deletePro(req, model);
		
		return "mypage/deletePro";
		
	}	
	
	//마이페이지 예약
	@RequestMapping(value="myReservation")
	public ModelAndView myReservation(HttpServletRequest req , ModelAndView mav) {
		System.out.println("myReservation()");
		
		RedirectView redirectView = new RedirectView("myPageReservationStart");
		redirectView.setContextRelative(true);

		mav.setView(redirectView);
		return mav;
		
	}
	
	//마이페이지 예약
	@RequestMapping(value="faceImgUpload")
	public @ResponseBody String faceImgUpload(MultipartHttpServletRequest req , Model model) {
		System.out.println("faceImgUpload()");
		
		service.faceImgUpload(req,model);
		
		return "1";
		
	}
	
	

}
