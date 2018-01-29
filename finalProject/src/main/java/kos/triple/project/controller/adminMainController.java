package kos.triple.project.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.service.hee.BannerService;
import kos.triple.project.service.hong.CarService;
import kos.triple.project.service.joon.AirReservationService;
import kos.triple.project.service.soon.stayReservationService;


@Controller
public class adminMainController {
	
		@Autowired
		AirReservationService air_Service;
	
		@Autowired
		CarService car_Service;
		
		@Autowired
		stayReservationService stay_Service;
		
		@Autowired
		BannerService bservice;
		
		
		//main������
		@RequestMapping(value="userManage")
		public String userManage() {
			System.out.println("userManage()");
			return "main/adminMain/site/userManage";
		}
		
		//��ü���
		@RequestMapping(value="salePage")
		public String sale_click(HttpServletRequest req , Model model) {
			System.out.println("salePage()");
			
			air_Service.getChatData_Air(req,model);
			car_Service.getCharData_Car(req,model);
			stay_Service.getCharData_Stay(req,model);
			
			return "main/adminMain/sale/salePage";
		}
		
		// ��� ���� ���� String homeManage
		@RequestMapping(value="banner")
		public String banner(HttpServletRequest req, Model model) {
			System.out.println("banner()");
			
			bservice.bannerList(req, model);
			
			return "main/adminMain/homePage/banner";
		}
		
		// ��� ���
		@RequestMapping(value="registerBanner")
		public String registerBanner(HttpServletRequest req, Model model) {
			System.out.println("registerBanner()");
			
			int bannerNo = 0;
			
			if(req.getParameter("bannerNo")!= null) {
				bannerNo = Integer.parseInt(req.getParameter("bannerNo"));
			}
			
			model.addAttribute("bannerNo", bannerNo);
				
			return "main/adminMain/homePage/registerBanner";
		}
		
		// ��� ��� ó��
		@RequestMapping(value = "registerBannerPro")
		public String registerBannerPro(MultipartHttpServletRequest req, Model model) {
			System.out.println("registerBannerPro");
			
			bservice.registerBannerPro(req, model);
				
			return "main/adminMain/homePage/registerBannerPro";
		}	
		
		
		// ��� �� ���� ó��
		@RequestMapping(value="deleteBannerPro")
		public String deleteBannerPro(HttpServletRequest req, Model model) {
			System.out.println("deleteBannerPro");
			
			bservice.deleteBannerPro(req, model);
			
			return "main/adminMain/homePage/deleteBannerPro"; 
		}
		
		// ��� �� ���� �� ������
		@RequestMapping(value="updateBannerView")
		public String updateBannerView(HttpServletRequest req, Model model) {
			System.out.println("updateBannerView");
			
			bservice.updateBannerView(req, model);
			
			return "main/adminMain/homePage/updateBannerView"; 
		}		
		
		// ��� �� ���� ó��
		@RequestMapping(value="updateBannerPro")
		public String updateBannerPro(MultipartHttpServletRequest req, Model model) {
			System.out.println("updateBannerPro");
			
			bservice.updateBannerPro(req, model);
			
			return "main/adminMain/homePage/updateBannerPro"; 
		}
		
		
}
