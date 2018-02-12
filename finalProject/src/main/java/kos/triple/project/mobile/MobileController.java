package kos.triple.project.mobile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kos.triple.project.mobile.vo.AirReservationSearchVO;
import kos.triple.project.mobile.vo.MyResAirSummaryVO;
import kos.triple.project.mobile.vo.MyResStayReservationVO;

@Controller
public class MobileController {
	
	@Autowired
	MobileService service;
	
	//�ش����� �α��ο���Ȯ��
	@RequestMapping(value="startRedirect")
	public @ResponseBody String startRedirect(HttpServletRequest req) {
		System.out.println("startRedirect()");
		service.startRedirect(req);
		String isLogin = (String)req.getAttribute("isLogin");
		return isLogin;
	}
	
	//�α��ΰ��ɿ���Ȯ��
	@RequestMapping(value="loginConfirm")
	public @ResponseBody String loginConfirm(HttpServletRequest req) {
		System.out.println("loginConfirm()");
		
		service.loginConfirm(req);
		String cnt = (String)req.getAttribute("cnt");
		return cnt;
	}
	
	
	//�ش� ���� ���̵� ����ȭ��Ų��.
	@RequestMapping(value="phoneSync")
	public @ResponseBody String phoneSync(HttpServletRequest req) {
		System.out.println("phoneSync()");
		service.phoneSync(req);
		String cnt = (String)req.getAttribute("cnt");
		return cnt;
	}
	
	//�α��λ����ΰ�� �ش���̵� �����´�.
	@RequestMapping(value="getSavedId")
	public @ResponseBody String getSavedId(HttpServletRequest req) {
		System.out.println("getSavedId()");
		service.getSavedId(req);
		String mem_id = (String)req.getAttribute("mem_id");
		return mem_id;
	}
		
	
	//�α׾ƿ��� ó���Ѵ�.
	@RequestMapping(value="mobileLogout")
	public @ResponseBody String mobileLogout(HttpServletRequest req) {
		System.out.println("mobileLogout()");
		service.mobileLogout(req);
		String cnt = (String)req.getAttribute("cnt");
		return cnt;
	}
	

	//�װ����� �˻��Ѵ�.
	@RequestMapping(value="mobileAirPlaneSearch")
	public @ResponseBody List<AirReservationSearchVO> mobileAirPlaneSearch(HttpServletRequest req) {
		System.out.println("mobileAirPlaneSearch()");
		
		service.airPlaneSearch(req);
	
		List<AirReservationSearchVO> searchList = (List<AirReservationSearchVO>)req.getAttribute("voList");
	
		
		return searchList;
		
	}
	
	@RequestMapping(value="mobileAirTiketBuyPageStep1")
	public @ResponseBody AirReservationSearchVO mobileAirTiketBuyPageStep1(HttpServletRequest req) {
		
		System.out.println("mobileAirTiketBuyPageStep1() ");
	
		service.getReserVationInfo(req);
		AirReservationSearchVO vo = (AirReservationSearchVO)req.getAttribute("vo");
		return vo;
		
	}
	
	@RequestMapping(value="mobileAirTiketBuyPageStep2")
	public String mobileAirTiketBuyPageStep2(HttpServletRequest req ,Model model) {
		
		System.out.println("mobileAirTiketBuyPageStep2() ");
	
		return "reservation/air/mobile/airTiketBuyPageStep2";
		
	}
	
	@RequestMapping(value="mobileReservationProc")
	public @ResponseBody String mobileReservationProc(HttpServletRequest req ) {
		System.out.println("mobileReservationProc() ");
		
		service.mobileReservationProc(req);
		String cnt = (String)req.getAttribute("cnt");
		return cnt;
	}
	
	
	@RequestMapping(value="mobileGetMyPageStartInfo")
	public @ResponseBody List<String> mobileGetMyPageStartInfo(HttpServletRequest req ) {
		System.out.println("mobileGetMyPageStartInfo() ");
		
		service.mobileGetMyPageStartInfo(req);
		@SuppressWarnings("unchecked")
		List<String> data = (List<String>)req.getAttribute("dataList");
		return data;
	}
	
	@RequestMapping(value="mobileGetMyAirReservationList")
	public @ResponseBody List<MyResAirSummaryVO> mobileGetMyAirReservationList(HttpServletRequest req ) {
		System.out.println("mobileGetMyAirReservationList() ");
		
		service.mobileGetMyAirReservationList(req);
		
		@SuppressWarnings("unchecked")
		List<MyResAirSummaryVO> voList 
		= (List<MyResAirSummaryVO>)req.getAttribute("voList");
		return voList;
	}
	
	
	@RequestMapping(value="mobileCancelReservationAir")
	public @ResponseBody String mobileCancelReservationAir(HttpServletRequest req ) {
		System.out.println("mobileCancelReservationAir() ");
		
		service.mobileCancelReservationAir(req);
		String cnt = (String)req.getAttribute("cnt");
	
		return cnt;
	}
	
	/* �̾߱� */
	@RequestMapping(value="getMobileStory")
	public @ResponseBody String getMobileStory(HttpServletRequest req ) {
		System.out.println("getMobileStory() ");
	
		service.getMobileStory(req);
		return "1";
	}
	
	
	/* ���� */
	
	@RequestMapping(value="mobileGetMyStayReservationList")
	public @ResponseBody List<MyResStayReservationVO> mobileGetMyStayReservationList(HttpServletRequest req ) {
		System.out.println("mobileGetMyStayReservationList() ");
	
		service.getMyStayReservationList(req);
		return (List<MyResStayReservationVO>)req.getAttribute("voList");
	}
	
	
	
	/* ���� */
	
}
