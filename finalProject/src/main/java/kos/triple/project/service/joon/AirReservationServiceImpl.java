package kos.triple.project.service.joon;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kos.triple.project.etc.DistanceCal;
import kos.triple.project.etc.PageCalculator;
import kos.triple.project.persistence.joon.AirReservationDAO;
import kos.triple.project.vo.AirPlaneVO;
import kos.triple.project.vo.AirPortVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.AirReservationSearchVO;
import kos.triple.project.vo.MapVO;
import kos.triple.project.vo.RouteVO;
import kos.triple.project.vo.SeatPriceVO;

@Service
public class AirReservationServiceImpl implements AirReservationService{

	@Autowired
	AirReservationDAO dao;
	
	//����������������
	@Override
	public void getAirPortInfo(HttpServletRequest req, Model model) {
		
		List<AirPortVO> airPortList = dao.getAirPortInfo_proc();
		
		model.addAttribute("airPortList",airPortList);
		
	}

	//�װ������ΰ�������
	@Override
	public void getAirPlane(HttpServletRequest req, Model model) {
		
		List<AirPlaneVO> airPlaneList = dao.getAirPlane_proc();
	
		model.addAttribute("airPlaneList",airPlaneList);

	}
	
	@Override
	public void getAirPlaneOne(HttpServletRequest req) {
		
		String airPlaneNo = req.getParameter("airPlaneNo");
		
		AirPlaneVO airPlane = dao.getAirPlaneOne_proc(airPlaneNo);
		req.setAttribute("airPlane",airPlane);
		
	}
	

	//�װ��� �߰�
	@Override
	public void addAirPlane(HttpServletRequest req) {

		int cnt = 0;
		
		String airPlaneName = req.getParameter("airPlaneName");
		String seatPriceCode = req.getParameter("seatPriceCode");
		
		AirPlaneVO vo = new AirPlaneVO();
		vo.setAirPlaneNo("AIRPLANE_");
		vo.setAirPlaneName(airPlaneName);
		if(seatPriceCode.equals("small")) {
			vo.setPremium(2);
			vo.setHighClass(8);
			vo.setNomal(18);
			vo.setAirPlaneSize("small");
		}
		else if(seatPriceCode.equals("large")) {
			vo.setPremium(8);
			vo.setHighClass(12);
			vo.setNomal(30);
			vo.setAirPlaneSize("large");
		}
		
		
		
		cnt = dao.addAirPlane_proc(vo);
		
		if(cnt==1) {
			
			int num = dao.getLastAirPlaneNo_proc();
	
			String tmp ="���װ���";
			
			StringBuffer str = new StringBuffer(
			"<tr>"+
				"<td>"+vo.getAirPlaneNo()+num+"</td>"+
				"<td>"+vo.getAirPlaneName()+"</td>"+
				"<td>"+vo.getPremium()+"</td>"+
				"<td>"+vo.getHighClass()+"</td>"+
				"<td>"+vo.getNomal()+"</td>"+
				"<td>"+(vo.getPremium()+vo.getHighClass()+vo.getNomal())+"</td>"+
				"<td>"+(seatPriceCode.equals("small")?"����":"����")+"</td>"+
				"<td>"+tmp.toString()+"</td>"+
			"</tr>");
			
			req.setAttribute("result",str.toString());
		}
		else {
			req.setAttribute("result","error");
		}
		
		
		
	}

	@Override
	public void deleteAirPlane(HttpServletRequest req) {
		
		int cnt = 0;
		
		String airPlaneNo = req.getParameter("deleteNo");

		cnt = dao.deleteAirPlane_proc(airPlaneNo);
		
	}

	@Override
	public void modifyAirPlane(HttpServletRequest req) {
		
		int cnt = 0;
		
		String airPlaneNo = req.getParameter("modifyAirPlaneNo");
		String airPlaneName = req.getParameter("modifyAirPlaneName");
		String airPlaneSize = req.getParameter("modifyAirPlaneSize");
		
		System.out.println("airPNo" + airPlaneNo);
		System.out.println("airPName" + airPlaneName);
		System.out.println("airPsize" + airPlaneSize);
		
		AirPlaneVO vo = new AirPlaneVO();
		
		vo.setAirPlaneNo(airPlaneNo);
		vo.setAirPlaneName(airPlaneName);
		if(airPlaneSize.equals("small")) {
			vo.setPremium(2);
			vo.setHighClass(8);
			vo.setNomal(18);
			vo.setAirPlaneSize("small");
		}
		else if(airPlaneSize.equals("large")) {
			vo.setPremium(8);
			vo.setHighClass(12);
			vo.setNomal(30);
			vo.setAirPlaneSize("large");
		}
		
		
		cnt = dao.modifyAirPlane_proc(vo);
		System.out.println("������� : " + cnt);
	}

	@Override
	public void getAirPlaneAll(HttpServletRequest req, Model model) {

		List<AirPlaneVO> voList = dao.getAirPlaneAll_proc();
		model.addAttribute("voList",voList);
	}

	@Override
	public void getMoveDistance(HttpServletRequest req) {

		String from = req.getParameter("from");
		String to = req.getParameter("to");
		
		AirPortVO fromAirPort = dao.getAirPortInfoOne_proc(from);
		AirPortVO toAirPort =  dao.getAirPortInfoOne_proc(to);
		
		double from_xPos = fromAirPort.getxPos();
		double from_yPos = fromAirPort.getyPos();
		
		double to_xPos = toAirPort.getxPos();
		double to_yPos = toAirPort.getyPos();
		
		DistanceCal dis = new DistanceCal(from_xPos, from_yPos, to_xPos, to_yPos);
		String distance = Double.toString(dis.getDistance());
		
		req.setAttribute("distance",distance);
	}

	@Override
	public void setRoute(HttpServletRequest req) {
		
		String airPlaneNo = req.getParameter("airPlaneNo");
		String startAirPortNo = req.getParameter("startLocation");
		String midAirPortNo = req.getParameter("midLocation");
		String endAirPortNo = req.getParameter("endLocation");
		
		double stepOneDistence = Double.parseDouble(req.getParameter("stepOne"));
		double stepTwoDistence = Double.parseDouble(req.getParameter("stepTwo"));
		
		String airPortNo = startAirPortNo;

		AirPortVO fromAirPort = dao.getAirPortLocation_proc(airPortNo);

		System.out.println(":����������1:" + airPortNo);
		airPortNo = endAirPortNo;
		AirPortVO toAirPort =  dao.getAirPortLocation_proc(airPortNo);

		System.out.println(":����������2:" + airPortNo);
		
		double from_xPos = fromAirPort.getxPos();
		double from_yPos = fromAirPort.getyPos();
		double to_xPos = toAirPort.getxPos();
		double to_yPos = toAirPort.getyPos();
			
		DistanceCal dis = new DistanceCal(from_xPos, from_yPos, to_xPos, to_yPos);
		String resultDistance = Double.toString(dis.getDistance());
		
		String sTime = req.getParameter("startTime");
		System.out.println(sTime);
		String[] tmp = sTime.split("T");
		String startTimeStamp = tmp[0]+" "+tmp[1];
		//var x = "2017 01-15 03:20"
		System.out.println("������ : " + midAirPortNo); //�ΰ����� �Ѿ�� (���°��)
		System.out.println(stepOneDistence);
		System.out.println(stepTwoDistence);
		
		double midTime = (stepOneDistence/500.0);
		double arrivalTime = (stepTwoDistence/500.0);
		
		//���������� ���µ� �ɸ��� �ð��� ��
		int hour1;
		double min1;
		
		//���������� ���������� ���µ� �ɸ��� �ð��� ��
		int hour2;
		double min2;
		
		if(midTime<1) {
			hour1 = 0;
			min1 = midTime*60;
		}
		else {
			hour1 = (int)midTime;
			min1 = (midTime-(int)midTime)*60;
		}
		
		if(arrivalTime<1) {
			hour2 = 0;
			min2 = arrivalTime*60;
		}
		else {
			hour2 = (int)arrivalTime;
			min2 = (arrivalTime-(int)arrivalTime)*60;
		}
		
		System.out.println("��߽ð�");
		System.out.println(startTimeStamp);
		System.out.println(hour1+":"+(int)min1);
		System.out.println(hour2+":"+(int)min2);
										 //"2017-01-15 24:03:60:0.0"
		Timestamp st = Timestamp.valueOf(startTimeStamp+":0.0");
		Calendar cal = Calendar.getInstance();
		
		cal.setTimeInMillis(st.getTime());
		cal.add(Calendar.HOUR,hour1);
		cal.add(Calendar.MINUTE,(int)min1);
		Timestamp mt = new Timestamp(cal.getTime().getTime());

		cal.setTimeInMillis(mt.getTime());
		cal.add(Calendar.HOUR,hour2);
		cal.add(Calendar.MINUTE,(int)min2);
		Timestamp at = new Timestamp(cal.getTime().getTime());
		
		
	  	Map<String ,Object> map = new HashMap<String,Object>();
		map.put("airPlaneNo",airPlaneNo);
		map.put("startAirPortNo",startAirPortNo);
		map.put("midAirPortNo",midAirPortNo);
		map.put("endAirPortNo",endAirPortNo);
		
		map.put("startTime",st);
		map.put("midTime",mt);
		map.put("arrivalTime",at);
		map.put("stepOneDistence",stepOneDistence);
		map.put("stepTwoDistence",stepTwoDistence);
		map.put("resultDistance",resultDistance);
		
		int cnt = dao.setRoute_proc(map);
		
		
	}

	@Override
	public void setRouteCancel(HttpServletRequest req) {
		
		String airPlaneNo = req.getParameter("airPlaneNo");
		dao.setRouteCancel_proc(airPlaneNo);
	}

	@Override
	public void getSeatDefaultPrice(HttpServletRequest req, Model model) {
		SeatPriceVO vo = dao.getSeatDefaultPrice_proc();
		model.addAttribute("seatPrice",vo);	
	}

	@Override
	public void setSeatPrice(HttpServletRequest req) {

		SeatPriceVO vo = new SeatPriceVO();
		String airPlaneNo = req.getParameter("airPlaneNo");
		vo.setNomal_A(Integer.parseInt( req.getParameter("nomal_a")));
		vo.setNomal_B(Integer.parseInt( req.getParameter("nomal_b")));
		vo.setNomal_C(Integer.parseInt( req.getParameter("nomal_c")));
		vo.setHighClass_A(Integer.parseInt(req.getParameter("highClass_a")));
		vo.setHighClass_B(Integer.parseInt(req.getParameter("highClass_b")));
		vo.setHighClass_C(Integer.parseInt(req.getParameter("highClass_c")));
		vo.setPremium_A(Integer.parseInt(req.getParameter("premium_a")));
		vo.setPremium_B(Integer.parseInt(req.getParameter("premium_b")));
		vo.setPremium_C(Integer.parseInt(req.getParameter("premium_c")));
	
		dao.setSeatPrice_proc(vo,airPlaneNo);
	}

	@Override
	public void setCustomSeatPrice(HttpServletRequest req) {

		SeatPriceVO vo = new SeatPriceVO();
		String airPlaneNo = req.getParameter("airPlaneNo");
		vo.setNomal_A(Integer.parseInt( req.getParameter("nomal_a")));
		vo.setNomal_B(Integer.parseInt( req.getParameter("nomal_b")));
		vo.setNomal_C(Integer.parseInt( req.getParameter("nomal_c")));
		vo.setHighClass_A(Integer.parseInt(req.getParameter("highClass_a")));
		vo.setHighClass_B(Integer.parseInt(req.getParameter("highClass_b")));
		vo.setHighClass_C(Integer.parseInt(req.getParameter("highClass_c")));
		vo.setPremium_A(Integer.parseInt(req.getParameter("premium_a")));
		vo.setPremium_B(Integer.parseInt(req.getParameter("premium_b")));
		vo.setPremium_C(Integer.parseInt(req.getParameter("premium_c")));
		vo.setSeatPriceCode("SEATPRICECODE_");
		
		dao.setCustomSeatPrice_proc(vo,airPlaneNo);
		
	}

	@Override
	public void getSeatPriceInfo(HttpServletRequest req) {
		
		String airPlaneNo = req.getParameter("airPlaneNo");
		SeatPriceVO vo = dao.getSeatPriceInfo_proc(airPlaneNo);
		
		req.setAttribute("seatPriceVO",vo);
	}

	@Override
	public void modifySeatPrice(HttpServletRequest req) {
		
		SeatPriceVO vo = new SeatPriceVO();
		//String airPlaneNo = req.getParameter("airPlaneNo");
		String seatPriceCode = req.getParameter("seatPriceCode");
		
		vo.setNomal_A(Integer.parseInt( req.getParameter("nomal_a")));
		vo.setNomal_B(Integer.parseInt( req.getParameter("nomal_b")));
		vo.setNomal_C(Integer.parseInt( req.getParameter("nomal_c")));
		vo.setHighClass_A(Integer.parseInt(req.getParameter("highClass_a")));
		vo.setHighClass_B(Integer.parseInt(req.getParameter("highClass_b")));
		vo.setHighClass_C(Integer.parseInt(req.getParameter("highClass_c")));
		vo.setPremium_A(Integer.parseInt(req.getParameter("premium_a")));
		vo.setPremium_B(Integer.parseInt(req.getParameter("premium_b")));
		vo.setPremium_C(Integer.parseInt(req.getParameter("premium_c")));
		vo.setSeatPriceCode(seatPriceCode);
		
		int cnt = dao.modifySeatPrice_proc(vo);
		
	}

	@Override
	public void airPlaneSearch(HttpServletRequest req, Model model) {
		
		String sl = req.getParameter("seatLevel");
		String sk = req.getParameter("startAirport_Key");
		String ek = req.getParameter("endAirport_Key");
		String sfd = req.getParameter("s_fromDate");
		String std = req.getParameter("s_toDate");
			
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("seatLevel",sl);
		map.put("startAirport_Key",sk);
		map.put("endAirport_Key",ek);
		map.put("s_fromDate",sfd);
		map.put("s_toDate",std);
		
		
		Map<String,String> renameMap = new HashMap<String,String>();
		renameMap.put("AIRPORT_1", "����");
		renameMap.put("AIRPORT_2", "�뱸");
		renameMap.put("AIRPORT_3", "�λ�");
		renameMap.put("AIRPORT_4", "����");
		renameMap.put("AIRPORT_5", "û��");
		
		System.out.println("map.foreach");
		map.forEach((k,v)->{
			System.out.println(k + " : " + v);
		});
		
		
		if(map.get("startAirport_Key").equals("noSelect")) {
			map.put("startAirport_Key", null);
		}
		if(map.get("endAirport_Key").equals("noSelect")) {
			map.put("endAirport_Key",null);
		}
		if(map.get("s_fromDate").equals("")) {
			map.put("s_fromDate",null);
		}
		if(map.get("s_toDate").equals("")) {
			map.put("s_toDate",null);
		}
		
		List<AirReservationSearchVO> vo = dao.airPlaneSearch(map);
		
		for (AirReservationSearchVO i : vo) {
			RouteVO r = i.getR();
			r.setRoute1( (String)renameMap.get(r.getRoute1() ) );
			r.setRoute2( (String)renameMap.get(r.getRoute2() ) );
			r.setRoute3( (String)renameMap.get(r.getRoute3() ) );
			i.setR(r);
		}
			
		model.addAttribute("searchResultVO",vo);
	}

	@Override
	public void getReserVationInfo(HttpServletRequest req, Model model) {
		
		String airPlaneNo = req.getParameter("airPlaneNo");
		System.out.println("pNum : " + airPlaneNo);
		AirReservationSearchVO vo = dao.getReserVationInfo_proc(airPlaneNo);
		
		Map<String,String> renameMap = new HashMap<String,String>();
		renameMap.put("AIRPORT_1", "����");
		renameMap.put("AIRPORT_2", "�뱸");
		renameMap.put("AIRPORT_3", "�λ�");
		renameMap.put("AIRPORT_4", "����");
		renameMap.put("AIRPORT_5", "û��");
		
		RouteVO r = vo.getR();
		r.setRoute1( (String)renameMap.get(r.getRoute1() ) );
		r.setRoute2( (String)renameMap.get(r.getRoute2() ) );
		r.setRoute3( (String)renameMap.get(r.getRoute3() ) );
		vo.setR(r);
		
		model.addAttribute("vo",vo);
	}

	@Override
	public void airResProc(HttpServletRequest req, Model model) {
		
		int cnt = 0;
		
		String airPlaneNo = req.getParameter("airPlaneNo");
		String startLocation = req.getParameter("startLocation");
		String endLocation = req.getParameter("endLocation");
		
		String price = req.getParameter("price");
		price = price==null ? "0" : price;
		
		String seatLevel_adult = req.getParameter("seatLevel_adult");
		String seatLevel_student = req.getParameter("seatLevel_student");
		String seatLevel_baby = req.getParameter("seatLevel_baby");
		
		String adult = req.getParameter("adult");
		adult = adult==null ? "0" : adult;
		
		String student = req.getParameter("student");
		student = student==null ? "0" : student;
		
		String baby = req.getParameter("baby");
		baby = baby==null ? "0" : baby;
		
		String memSize = req.getParameter("memSize");
		memSize = memSize==null ? "0" : memSize;

		String mem_id = req.getParameter("mem_id");
		String payMethod = req.getParameter("payMethod");
		
		String startTime = req.getParameter("startTime");
		String endTime = req.getParameter("endTime");
		startTime = startTime.replace("�� ",":");
		startTime = startTime.replace("��",":0.0");
		endTime = endTime.replace("�� ",":");
		endTime = endTime.replace("��",":0.0");
		
		System.out.println("----------------------------");
		System.out.println(startTime);
		System.out.println(endTime);
		System.out.println("----------------------------");
		AirReservationDetailVO vo = new AirReservationDetailVO();
		
		vo.setAirPlaneNo(airPlaneNo);
		vo.setStartLocation(startLocation);
		vo.setEndLocation(endLocation);
		
		vo.setStartTime(Timestamp.valueOf(startTime));
		vo.setEndTime(Timestamp.valueOf(endTime));
		
		vo.setPrice(Integer.parseInt(price));
		vo.setSeatLevel_adult(seatLevel_adult);
		vo.setSeatLevel_student(seatLevel_student);
		vo.setSeatLevel_baby(seatLevel_baby);
		vo.setAdult(Integer.parseInt(adult));
		vo.setStudent(Integer.parseInt(student));
		vo.setBaby(Integer.parseInt(baby));
		vo.setMemSize(Integer.parseInt(memSize));
		vo.setMem_id(mem_id);
		vo.setPayMethod(payMethod);
		vo.setResTime(Timestamp.valueOf(LocalDateTime.now()));
		
		
		
		AirPlaneVO testVO = dao.getRemainSeat_proc(airPlaneNo);
		
		System.out.println("���� �¼��� : "  + testVO.getNomal());
		System.out.println("���� �¼��� : "  + testVO.getHighClass());
		System.out.println("���� �¼��� : "  + testVO.getPremium());
		
		int nomal_total = 0;
		int highClass_total = 0;
		int premium_total = 0;
		String seatLevel = vo.getSeatLevel_adult();
		if(!seatLevel.equals("noSelect")) {
			if(seatLevel.equals("nomal")) {
				nomal_total += vo.getAdult();
			}
			else if(seatLevel.equals("highClass")) {
				highClass_total += vo.getAdult();
			}
			else if(seatLevel.equals("premium")){
				premium_total += vo.getAdult();
			}
		}
		seatLevel = vo.getSeatLevel_student();
		if(!seatLevel.equals("noSelect")) {
			if(seatLevel.equals("nomal")) {
				nomal_total += vo.getStudent();
			}
			else if(seatLevel.equals("highClass")) {
				highClass_total += vo.getStudent();
			}
			else if(seatLevel.equals("premium")){
				premium_total += vo.getStudent();
			}
		}
		seatLevel = vo.getSeatLevel_baby();
		if(!seatLevel.equals("noSelect")) {
			if(seatLevel.equals("nomal")) {
				nomal_total += vo.getBaby();
			}
			else if(seatLevel.equals("highClass")) {
				highClass_total += vo.getBaby();
			}
			else if(seatLevel.equals("premium")){
				premium_total += vo.getBaby();
			}
		}
		
		System.out.println("===========");
		System.out.println(nomal_total);
		System.out.println(highClass_total);
		System.out.println(premium_total);
		
		int nomal_token = 0;
		int highClass_token = 0;
		int premium_token = 0;
		
		nomal_token = ( testVO.getNomal() - nomal_total >=0 ) ? 1 : 0 ;
				
		highClass_token = (testVO.getHighClass() - highClass_total >=0 ) ? 1 : 0 ;
		
		premium_token = (testVO.getPremium() - premium_total >=0) ? 1 : 0 ;
		
		
		System.out.println("===== token ====");
		System.out.println(nomal_token);
		System.out.println(highClass_token);
		System.out.println(premium_token);
		
		if(nomal_token==1 && highClass_token==1 && premium_token==1) {
			cnt = 1 ;
		}else {
			cnt = 0 ;
		}
		
		System.out.println("cnt : " + cnt);
		
		if(cnt==1) {
			cnt = dao.airResProc_proc(vo);
		}
		else {
			model.addAttribute("nomal_token",nomal_token);
			model.addAttribute("highClass_token",highClass_token);
			model.addAttribute("premium_token",premium_token);
			String routeNo = dao.getRouteNo_proc(vo.getAirPlaneNo());
			RouteVO route = dao.getRouteInfo_proc(routeNo);
			model.addAttribute("route",route);
			model.addAttribute("startTime" , startTime);
			model.addAttribute("endTime" , endTime);
			model.addAttribute("vo",vo);
			return;
		}
		
		if(cnt==1) {
			//�ش������� ���� �¼����� ������Ʈ�Ѵ�.
			
			int nomal = 0;
			int highClass = 0;
			int premium = 0;
			
			if(vo.getAdult()>0) {
				switch(vo.getSeatLevel_adult()) {
					case "nomal" : nomal += vo.getAdult(); break;
					case "highClass" : highClass += vo.getAdult(); break;
					case "premium" : premium += vo.getAdult(); break;
				}
			}
			
			if(vo.getStudent()>0){
				switch(vo.getSeatLevel_student()) {
					case "nomal" : nomal += vo.getStudent(); break;
					case "highClass" : highClass += vo.getStudent(); break;
					case "premium" : premium += vo.getStudent(); break;
				}
			}
			
			if(vo.getBaby()>0){
				switch(vo.getSeatLevel_baby()) {
					case "nomal" : nomal += vo.getBaby(); break;
					case "highClass" : highClass += vo.getBaby(); break;
					case "premium" : premium += vo.getBaby(); break;
				}
			}	
			
  			Map<String,Object> map = new HashMap<String,Object>();
			map.put("airPlaneNo",airPlaneNo);
			map.put("nomal", nomal);
			map.put("highClass", highClass);
			map.put("premium", premium);
			
			dao.modifyAirPlane_remainSeat_proc(map);
			
			String routeNo = dao.getRouteNo_proc(vo.getAirPlaneNo());
			RouteVO route = dao.getRouteInfo_proc(routeNo);
			model.addAttribute("route",route);
			
		}
		
		model.addAttribute("startTime" , startTime);
		model.addAttribute("endTime" , endTime);
		model.addAttribute("vo",vo);
		
		model.addAttribute("nomal_token",nomal_token);
		model.addAttribute("highClass_token",highClass_token);
		model.addAttribute("premium_token",premium_token);
		
	}

	@Override
	public void getRemainSeat(HttpServletRequest req) {
		
		String airPlaneNo = req.getParameter("airPlaneNo");
		
		AirPlaneVO vo = dao.getRemainSeat_proc(airPlaneNo);
		
		req.setAttribute("vo",vo);
	}

	@Override
	public void getMyPageReserAirPlane(HttpServletRequest req , Model model) {
		
		int pageSize = 3;  		//�� �������� ����� �� ����
		int pageBlock = 3; 		//�Ѻ��� ������ ����		
		int dataTotalCount = 0; 	   		

		String pageNum = req.getParameter("requestPage");  //������ ��ȣ

		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("method","getMyPageReserAirPlane");
		map.put("mem_id",mem_id);
		
		dataTotalCount = dao.getListCount(map);
		
		if(pageNum == null) {
			pageNum = "1"; //ù�������� 1�������� ����
		}		
		
		System.out.println("123123123123123123123123213123");
		PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), dataTotalCount, pageBlock, pageSize);
		
		map.put("start",p.getStart());
		map.put("end",p.getEnd());
		
		List<AirReservationDetailVO> voList = dao.getMyPageReserAirPlane_proc(map);
		
		
		req.setAttribute("blockStartNumber_air",p.getBlockStartNumber() );
		req.setAttribute("blockEndNumber_air",p.getBlockEndNumber() );
		req.setAttribute("pageNum_air",p.getRequestPage());
		req.setAttribute("startPage_air", p.getStartPage());
		req.setAttribute("endPage_air",p.getEndPage());
		req.setAttribute("voList_air",voList);
		
		
	}

	@Override
	public void getAirReserVationList(HttpServletRequest req, Model model) {

		int pageSize = 3;  		//�� �������� ����� �� ����
		int pageBlock = 3; 		//�Ѻ��� ������ ����		
		int dataTotalCount = 0; 	   		

		String pageNum = req.getParameter("requestPage");  //������ ��ȣ

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("method","getAirReserVationList");
		
		dataTotalCount = dao.getListCount(map);
		
		if(pageNum == null) {
			pageNum = "1"; //ù�������� 1�������� ����
		}		
		

		PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), dataTotalCount, pageBlock, pageSize);
		
		map.put("start",p.getStart());
		map.put("end",p.getEnd());
		
		List<AirReservationDetailVO> voList = dao.getAirReserVationList_proc(map);
		
		model.addAttribute("blockStartNumber",p.getBlockStartNumber() );
		model.addAttribute("blockEndNumber",p.getBlockEndNumber() );
		model.addAttribute("pageNum",p.getRequestPage());
		model.addAttribute("startPage", p.getStartPage());
		model.addAttribute("endPage",p.getEndPage());
		model.addAttribute("voList",voList);
	}

	@Override
	public void airResCancelProc(HttpServletRequest req, Model model) {

		String airPlaneNo = req.getParameter("airplaneNo");
		String airResNo = req.getParameter("airResNo");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("airPlaneNo",airPlaneNo);
		map.put("airResNo",airResNo);
		
		int cnt = dao.airResCancelProc_proc(map);
		
	}

	@Override
	public void setDefaultPriceUpdate(HttpServletRequest req, Map<String, Object> map) {
		
		int cnt = 0 ;
		cnt = dao.setDefaultPriceUpdate_proc(map);
		req.setAttribute("isSuccess", cnt);
	
	}

	@Override
	public void getChatData_Air(HttpServletRequest req, Model model) {
		
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		String year = req.getParameter("year") == null ? Integer.toString(Calendar.getInstance().get(Calendar.YEAR)) : req.getParameter("year");
		parameterMap.put("year",year);
		
		
		resultMap = dao.getChatData_Air(parameterMap);
		
		
		model.addAttribute("air_resultMap",resultMap);
		
	}

	@Override
	public void getChatDataCustom_Air1(HttpServletRequest req, Model model) {
		Map<String , Object> parameterMap = new HashMap<String , Object>();
		//�Ķ���� �� end
		
		Map<String ,Object> resMap = new HashMap<String,Object>();
		//�� ������ �¿� ���� �ʱ�ȭ
		resMap.put("��",0);
		resMap.put("ȭ",0);
		resMap.put("��",0);
		resMap.put("��",0);
		resMap.put("��",0);
		resMap.put("��",0);
		resMap.put("��",0);
		resMap.put("��ü",0);
		
		List<MapVO> list = dao.getChatDataCustom_Air1(parameterMap);
		for(MapVO i : list) {
			resMap.put(i.getKey(), i.getValue());
		}
		
		
		System.out.println("-----------------------1---------------------��");
		resMap.forEach( (k,v)->{
			System.out.println(k+" : " + v);
		});
		System.out.println("-----------------------1---------------------��1");
		model.addAttribute("firstChat",resMap);
	}
	
	@Override
	public void getChatDataCustom_Air2(HttpServletRequest req, Model model) {

		Map<String , Object> parameterMap = new HashMap<String , Object>();
		//�Ķ���� �� end
		
		Map<String ,Object> resMap = new HashMap<String,Object>();
		//�� ������ �¿� ���� �ʱ�ȭ
		resMap.put("������ü",0);
		resMap.put("�ſ�ī��",0);
		resMap.put("�������Ա�",0);
		resMap.put("�ڵ���",0);
		resMap.put("��ü",0);
		
		List<MapVO> list = dao.getChatDataCustom_Air2(parameterMap);
		
		for(MapVO i : list) {
			resMap.put(i.getKey(), i.getValue());
		}
		
		
		System.out.println("-----------------------2---------------------��");
		resMap.forEach( (k,v)->{
			System.out.println(k+" : " + v);
		});
		System.out.println("-----------------------2---------------------��2");
		
		model.addAttribute("secondChat",resMap);
	}

	@Override
	public void getChatDataCustom_Air3(HttpServletRequest req, Model model) {
		
		Map<String , Object> parameterMap = new HashMap<String , Object>();
		String year = req.getParameter("year");
		if(year==null) {
			int tmp = Calendar.getInstance().get(Calendar.YEAR);
			year = Integer.toString(tmp);
		}
		
		//�Ķ���� �� end
		parameterMap.put("year",year);
	
		Map<String ,Object> resMap = new HashMap<String,Object>();
		
		//�� ������ �¿� ���� �ʱ�ȭ
		resMap.put("01",0);
		resMap.put("02",0);
		resMap.put("03",0);
		resMap.put("04",0);
		resMap.put("05",0);
		resMap.put("06",0);
		resMap.put("07",0);
		resMap.put("08",0);
		resMap.put("09",0);
		resMap.put("10",0);
		resMap.put("11",0);
		resMap.put("12",0);
		
		List<MapVO> list = dao.getChatDataCustom_Air3(parameterMap);
		for(MapVO i : list) {
			resMap.put(i.getKey(), i.getValue());
		}
		
		
		System.out.println("-----------------------3---------------------");
		resMap.forEach( (k,v)->{
			System.out.println(k+" : " + v);
		});
		System.out.println("-----------------------3---------------------��3");
		
		model.addAttribute("finalChat",resMap);
	}

	@Override
	public void deadPlaneCollection(HttpServletRequest req, Model model) {
			dao.deadPlaneCollection_proc();
	}
	
}