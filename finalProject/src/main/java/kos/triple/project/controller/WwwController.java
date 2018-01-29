package kos.triple.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kos.triple.project.service.hong.CarService;
import kos.triple.project.service.joon.AirReservationService;
import kos.triple.project.service.soon.stayReservationService;

@Controller
public class WwwController {
	
	@Autowired
	AirReservationService air_service;
	
	@Autowired
	CarService car_service;
	
	@Autowired
	stayReservationService stay_service;

	//������ ���� (�װ�,��Ʈ,���� ���� ��� ź��)
	@RequestMapping(value="myPageReservationStart")
	public String myPageStart(HttpServletRequest req , Model model){	
		
		//�������������� �װ��������� �����ͼ� ��Ʈī ��Ʈ�ѷ��� �ѱ��...
		
		air_service.getMyPageReserAirPlane(req,model);
		car_service.rentReservationList_myPage(req,model);
		stay_service.getMyPageReserStay(req, model);
		
		return "mypage/reservation/myReservation";
		
	}
	
	
	//�װ� ���� ����Ʈ-�Խ�Ʈ(ajax)
	@RequestMapping(value="getAirResList")
	public String getAirResList(HttpServletRequest req,  Model model){	
		System.out.println("getAirResList()");
		//�������������� �װ���������
		air_service.getMyPageReserAirPlane(req,model);

		return "mypage/reservation/air/airResListTable";
		
	}

	//��Ʈ ���� ����Ʈ-�Խ�Ʈ(ajax)
	@RequestMapping(value="getCarResList")
	public String getCarResList(HttpServletRequest req, Model model) {
		
		car_service.rentReservationList_myPage(req, model);
		
		return "mypage/reservation/car/carResListTable";
	}

	// ���� ���� ����Ʈ-�Խ�Ʈ(ajax)
	@RequestMapping(value = "getStayResList")
	public String getStayResList(HttpServletRequest req, Model model) {

		stay_service.getMyPageReserStay(req, model);

		return "mypage/reservation/stay/stayResListTable";
	}
	
	
	
}
