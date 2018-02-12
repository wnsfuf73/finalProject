package kos.triple.project.mobile;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kos.triple.project.mobile.vo.AirReservationSearchVO;
import kos.triple.project.mobile.vo.EpilogueMobileCourseVO;
import kos.triple.project.mobile.vo.EpilogueMobileVO;
import kos.triple.project.mobile.vo.MyResAirSummaryVO;
import kos.triple.project.mobile.vo.MyResStayReservationVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.CarInfoVO;
import kos.triple.project.vo.RouteVO;
import kos.triple.project.vo.WhereVO;

@Service
public class MobileServiceImpl implements MobileService {

	@Autowired
	MobileDAO dao;

	@Override
	public void loginConfirm(HttpServletRequest req) {

		String mem_id = req.getParameter("mem_id");
		String password = req.getParameter("password");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", mem_id);
		map.put("password", password);
		int cnt = dao.loginConfirm_proc(map);

		req.setAttribute("cnt", Integer.toString(cnt));
	}

	@Override
	public void startRedirect(HttpServletRequest req) {
		// ���۽� �α��� �Ǵ�
		String phone = req.getParameter("phonenumber");
		int isLogin = dao.startRedirect_proc(phone);
		req.setAttribute("isLogin", Integer.toString(isLogin));
	}

	// �ش���� ���̵� ����ȭ
	@Override
	public void phoneSync(HttpServletRequest req) {

		String phonenumber = (String) req.getParameter("phonenumber");
		String mem_id = (String) req.getParameter("mem_id");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phonenumber", phonenumber);
		map.put("mem_id", mem_id);

		int cnt = dao.phoneSync_proc(map);
		req.setAttribute("cnt", Integer.toString(cnt));
	}

	@Override
	public void getSavedId(HttpServletRequest req) {
		String phonenumber = req.getParameter("phonenumber");
		String mem_id = dao.getSavedId_proc(phonenumber);
		req.setAttribute("mem_id", mem_id);
	}

	@Override
	public void mobileLogout(HttpServletRequest req) {
		String mem_id = req.getParameter("logoutId");
		String phonenumber = req.getParameter("phonenumber");
		System.out.println(mem_id);
		System.out.println(phonenumber);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", mem_id);
		map.put("phonenumber", phonenumber);

		int cnt = dao.mobileLogout_proc(map);

		req.setAttribute("cnt", Integer.toString(cnt));
	}

	@Override
	public void airPlaneSearch(HttpServletRequest req) {

		String startLocation = req.getParameter("startLocation");
		String endLocation = req.getParameter("endLocation");
		String startDay = req.getParameter("startDay");
		String endDay = req.getParameter("endDay");
		String seatLevel = "all";

		startLocation = dao.getAirportNo_proc(startLocation);
		endLocation = dao.getAirportNo_proc(endLocation);

		System.out.println("----------------------");
		System.out.println(startLocation);
		System.out.println(endLocation);
		System.out.println(startDay);
		System.out.println(endDay);
		System.out.println("----------------------");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startAirport_Key", startLocation);
		map.put("endAirport_Key", endLocation);
		map.put("s_fromDate", startDay);
		map.put("s_toDate", endDay);

		/*
		 * if(map.get("startAirport_Key").equals("noSelect")) {
		 * map.put("startAirport_Key", null); }
		 * if(map.get("endAirport_Key").equals("noSelect")) {
		 * map.put("endAirport_Key",null); } if(map.get("s_fromDate").equals("")) {
		 * map.put("s_fromDate",null); } if(map.get("s_toDate").equals("")) {
		 * map.put("s_toDate",null); }
		 */

		List<AirReservationSearchVO> voList = dao.airPlaneSearch_proc(map);
		int index = 0;
		for (AirReservationSearchVO i : voList) {
			voList.get(index).setRoute1(dao.getAirportName_proc(i.getRoute1()));
			voList.get(index).setRoute2(dao.getAirportName_proc(i.getRoute2()));
			voList.get(index).setRoute3(dao.getAirportName_proc(i.getRoute3()));
			index++;
		}
		req.setAttribute("voList", voList);
	}

	@Override
	public void getReserVationInfo(HttpServletRequest req) {
		String airPlaneNo = req.getParameter("airplaneNo");
		System.out.println("pNum : " + airPlaneNo);
		AirReservationSearchVO vo = dao.getReserVationInfo_proc(airPlaneNo);

		Map<String, String> renameMap = new HashMap<String, String>();
		renameMap.put("AIRPORT_1", "����");
		renameMap.put("AIRPORT_2", "�뱸");
		renameMap.put("AIRPORT_3", "�λ�");
		renameMap.put("AIRPORT_4", "����");
		renameMap.put("AIRPORT_5", "û��");
		renameMap.put("direct", "����������");

		vo.setRoute1((String) renameMap.get(vo.getRoute1()));
		vo.setRoute2((String) renameMap.get(vo.getRoute2()));
		vo.setRoute3((String) renameMap.get(vo.getRoute3()));

		req.setAttribute("vo", vo);

	}

	@Override
	public void mobileReservationProc(HttpServletRequest req) {

		String airPlaneNo = req.getParameter("airPlaneNo");
		String ages = req.getParameter("ages");

		String seatLevel = req.getParameter("seatLevel");
		String startLocation = req.getParameter("startLocation");
		String endLocation = req.getParameter("endLocation");
		String memSize = req.getParameter("memSize");

		String priceTotal = req.getParameter("priceTotal");
		String payMethod = req.getParameter("payMethod");
		Timestamp startTime = null;
		Timestamp endTime = null;
		String mem_id = req.getParameter("mem_id");

		// ��߽ð� , �����ð��� �־��ش�.
		RouteVO rVO = dao.getRouteInfo(airPlaneNo);
		startTime = rVO.getStartTime();

		if (rVO.getRoute2().equals("direct")) {
			endTime = rVO.getArrivalTime();
		} else {
			String tmp = dao.getAirportName_proc(rVO.getRoute2());
			if (tmp.equals(endLocation)) {
				endTime = rVO.getMidTime();
			} else {
				endTime = rVO.getArrivalTime();
			}
		}
		// ��߽ð� , �����ð��� �־��ش�.

		// ������ ���� �����Ѵ�.
		String seatLevel_adult = "noSelect";
		String seatLevel_student = "noSelect";
		String seatLevel_baby = "noSelect";
		String adult = "0";
		String student = "0";
		String baby = "0";

		if (seatLevel.equals("�Ϲݼ�")) {
			seatLevel = "nomal";
		} else if (seatLevel.equals("��޼�")) {
			seatLevel = "highClass";
		} else if (seatLevel.equals("�����̾���")) {
			seatLevel = "premium";
		}

		if (ages.equals("����")) {
			seatLevel_adult = seatLevel;
			adult = memSize;
		} else if (ages.equals("�л�")) {
			seatLevel_student = seatLevel;
			student = memSize;
		} else if (ages.equals("����")) {
			seatLevel_baby = seatLevel;
			baby = memSize;
		}

		// ������ ���� �����Ѵ�.

		AirReservationDetailVO vo = new AirReservationDetailVO();

		vo.setAirPlaneNo(airPlaneNo);
		vo.setStartLocation(startLocation);
		vo.setEndLocation(endLocation);

		vo.setStartTime(startTime);
		vo.setEndTime(endTime);

		vo.setPrice(Integer.parseInt(priceTotal));
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

		// ���� insert
		int cnt = dao.reservationComplete_proc(vo);

		// ����� ���� �¼��� �ٿ��Ų��.
		if (cnt == 1) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("seatLevel", seatLevel);
			map.put("memSize", Integer.parseInt(memSize));
			map.put("airPlaneNo", airPlaneNo);
			System.out.println("-----------------");
			System.out.println(seatLevel);
			System.out.println(memSize);
			System.out.println(airPlaneNo);
			System.out.println("-----------------");
			cnt = dao.setRemainSeatUpdate(map);
		}

		req.setAttribute("cnt", Integer.toString(cnt));

	}

	@Override
	public void mobileGetMyPageStartInfo(HttpServletRequest req) {
		List<String> dataList = new ArrayList<String>();
		// �װ�����Ǽ�
		// ��Ʈ����Ǽ�
		// ���ڿ���Ǽ�
		// �������̹���
		String mem_id = req.getParameter("mem_id");
		dataList = dao.mobileGetMyPageStartInfo_proc(mem_id);
		req.setAttribute("dataList", dataList);
	}

	@Override
	public void mobileGetMyAirReservationList(HttpServletRequest req) {
		List<MyResAirSummaryVO> voList;
		String mem_id = (String) req.getParameter("mem_id");
		voList = dao.mobileGetMyAirReservationList_proc(mem_id);

		for (MyResAirSummaryVO i : voList) {
			if (!i.getAirPlaneNo().equals("finish")) {
				String airPlaneName = dao.getAirPlaneName(i.getAirPlaneNo());
				i.setAirPlaneName(airPlaneName);
			}
		}

		System.out.println("--------------------");
		for (MyResAirSummaryVO i : voList) {
			System.out.println(i.getAirPlaneName());
		}
		System.out.println("---------------");

		req.setAttribute("voList", voList);

	}

	@Override
	public void mobileCancelReservationAir(HttpServletRequest req) {

		String airPlaneNo = req.getParameter("airPlaneNo");
		String airResNo = req.getParameter("airResNo");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("airPlaneNo", airPlaneNo);
		map.put("airResNo", airResNo);

		int cnt = dao.mobileCancelReservationAir(map);
		req.setAttribute("cnt", Integer.toString(cnt));
	}

	/* �̾߱� */
	@Override
	public void getMobileStory(HttpServletRequest req) {

		List<EpilogueMobileVO> voList = dao.getMobileStory_proc();

		int index = 0;
		for (EpilogueMobileVO i : voList) {
			int epilogueNo = i.getEpilogueNo();
			System.out.println("step4" + epilogueNo);
			String imgPath = dao.getEpilogueFrontImage(epilogueNo);
			voList.get(index).setFront_img(imgPath);
			index++;
		}

		System.out.println("---------------------");
		for (int i = 0; i < voList.size(); i++) {
			System.out.println(voList.get(i).getFront_img());
		}

		req.setAttribute("voList", voList);
	}

	@Override
	public void mobileStoryDetail(HttpServletRequest req) {
		String epNum = req.getParameter("epilogueNo");
		System.out.println(epNum);
		int epilogueNo = Integer.parseInt(epNum);

		EpilogueMobileVO vo = dao.getMobileStoryDetail_proc(epilogueNo);
		List<EpilogueMobileCourseVO> course = dao.getMobileStoryDetailCourse_proc(epilogueNo);
		req.setAttribute("vo", vo);
		req.setAttribute("courseList", course);

	}

	@Override
	public void getMyStayReservationList(HttpServletRequest req) {
		String mem_id = req.getParameter("mem_id");
		List<MyResStayReservationVO> voList = dao.getMyStayReservationList(mem_id);
		req.setAttribute("voList", voList);
	}
	/* �̾߱� */

	/* ������ ���� */

	@Override
	public void getMobileWhereAll(HttpServletRequest req) {

		List<WhereVO> voList = dao.getMobileWhereAll_proc();

		req.setAttribute("voList", voList);
	}

	@Override
	public void mobileWhereArea(HttpServletRequest req) {

		String area = req.getParameter("area");
		List<WhereVO> voList = dao.getMobileWhereArea_proc(area);

		req.setAttribute("voList", voList);

	}

	/* ������ ���� */

	/* ��Ʈ */
	@Override
	public void mobileRentList(HttpServletRequest req) {

		String car_kind = req.getParameter("car_kind");
		String rental_day = req.getParameter("rental_day");
		String rental_time = req.getParameter("rental_time");

		String return_day = req.getParameter("return_day");
		String return_time = req.getParameter("return_time");

		System.out.println("--------------------");
		System.out.println(car_kind);
		System.out.println(rental_day);
		System.out.println(rental_time);
		System.out.println(return_day);
		System.out.println(return_time);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("car_kind", car_kind);
		map.put("rental_day", rental_day);
		map.put("rental_time", rental_time);
		map.put("return_day", return_day);
		map.put("return_time", return_time);

		List<CarInfoVO> voList = dao.mobileRentList_proc(map);
		req.setAttribute("voList", voList);

	}

	/* ��Ʈ */

}
