package kos.triple.project.persistence.joon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.AirPlaneVO;
import kos.triple.project.vo.AirPortVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.AirReservationSearchVO;
import kos.triple.project.vo.AirSaleVO;
import kos.triple.project.vo.MapVO;
import kos.triple.project.vo.RouteVO;
import kos.triple.project.vo.SeatPriceVO;

@Repository
public class AirReservationDAOImpl implements AirReservationDAO{

	@Inject
	SqlSession sqlSession;
	
	private final String nameSpace = "kos.triple.project.persistence.joon.AirReservationDAO";
	
	@Override
	public int getListCount(Map<String, Object> map) {
		
		int cnt = 0;
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.getListCount(map);
		return cnt;
	}
	
	@Override
	public List<AirPortVO> getAirPortInfo_proc() {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		
		List<AirPortVO> voList = dao.getAirPortInfo_proc();
	
		return voList;
	}

	@Override
	public List<AirPlaneVO> getAirPlane_proc() {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		
		List<AirPlaneVO> voList = dao.getAirPlane_proc();
		
		return voList;
	}

	@Override
	public int addAirPlane_proc(AirPlaneVO vo) {
		
		int cnt = 0;
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.addAirPlane_proc(vo);
		return cnt;
	}

	@Override
	public int getLastAirPlaneNo_proc() {
		int cnt = 0;
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.getLastAirPlaneNo_proc();
		return cnt;
	}

	@Override
	public int deleteAirPlane_proc(String airPlaneNo) {
		
		int cnt = 0;
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.deleteAirPlane_proc(airPlaneNo);
		System.out.println("삭제가능여부" + cnt);
		return cnt;
	}

	@Override
	public AirPlaneVO getAirPlaneOne_proc(String airPlaneNo) {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		AirPlaneVO vo = dao.getAirPlaneOne_proc(airPlaneNo);
		
		return vo;
	}

	@Override
	public int modifyAirPlane_proc(AirPlaneVO vo) {
		
		int cnt = 0;
			
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.modifyAirPlane_proc(vo);
		
		return cnt;
	}

	@Override
	public List<AirPlaneVO> getAirPlaneAll_proc() {
		
		List<AirPlaneVO> voList;
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		voList = dao.getAirPlaneAll_proc();
		return voList;
	}

	@Override
	public AirPortVO getAirPortInfoOne_proc(String airPortName) {
		
		AirPortVO vo;
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		vo = dao.getAirPortInfoOne_proc(airPortName);
		
		return vo;
	}

	@Override
	public int setRoute_proc(Map<String, Object> map) {
		
		int cnt = 0 ;
		
		cnt = sqlSession.insert(nameSpace+".setRoute_proc_step1",map);
		String no = sqlSession.selectOne(nameSpace+".getLastRouteNo");
		String routeNo="R"+no;
		map.put("routeNo",routeNo);
		cnt = sqlSession.update(nameSpace+".setRoute_proc_step2",map);
		
		return cnt;
	
	}

	@Override
	public void setRouteCancel_proc(String airPlaneNo) {
		int cnt = 0;
		//배정을취소할 노선코드를 가져온다.
		String routeNo = sqlSession.selectOne(nameSpace+".setRouteCancel_proc_step1",airPlaneNo);
		
		//항공기의 노선번호를 null 로 변경한다.
		cnt = sqlSession.update(nameSpace+".setRouteCancel_proc_step2",airPlaneNo);
		
		//route테이블의 노선을 지운다.
		cnt = sqlSession.delete(nameSpace+".setRouteCancel_proc_step3",routeNo);
	}

	@Override
	public SeatPriceVO getSeatDefaultPrice_proc() {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		SeatPriceVO vo = dao.getSeatDefaultPrice_proc();
		return vo;
	}

	@Override
	public int setSeatPrice_proc(SeatPriceVO vo, String airPlaneNo) {
		//기본 가격을 업데이트한다.
		sqlSession.update(nameSpace+".setSeatPrice_proc_step1",vo);
		//비행기에 기본가격을 셋한다. 코드번호 SEATCODE_1
		sqlSession.update(nameSpace+".setSeatPrice_proc_step2",airPlaneNo);
		return 0;
	}

	@Override
	public int setCustomSeatPrice_proc(SeatPriceVO vo, String airPlaneNo) {
		
		int cnt = 0;
		
		sqlSession.insert(nameSpace+".setCustomSeatPrice_proc_step1",vo);
		
		int sequence = sqlSession.selectOne(nameSpace+".setCustomSeatPrice_proc_step2");
		String seatPriceCode = vo.getSeatPriceCode()+Integer.toString(sequence);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("seatPriceCode",seatPriceCode);
		map.put("airPlaneNo",airPlaneNo);
		
		sqlSession.selectOne(nameSpace+".setCustomSeatPrice_proc_step3",map);
		
		return cnt;
	}

	@Override
	public SeatPriceVO getSeatPriceInfo_proc(String airPlaneNo) {

		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		SeatPriceVO vo = dao.getSeatPriceInfo_proc(airPlaneNo);
		return vo;
	}

	@Override
	public int modifySeatPrice_proc(SeatPriceVO vo) {
		int cnt = 0;
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.modifySeatPrice_proc(vo);
		return cnt;
	}

	@Override
	public List<AirReservationSearchVO> airPlaneSearch(Map<String, Object> map) {

		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		List<AirReservationSearchVO> vo = dao.airPlaneSearch(map);
		return vo;
	}

	@Override
	public AirPortVO getAirPortLocation_proc(String airPortNo) {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		AirPortVO vo = dao.getAirPortLocation_proc(airPortNo);
		
		return vo;
	}

	@Override
	public AirReservationSearchVO getReserVationInfo_proc(String airPlaneNo) {
		
		AirReservationSearchVO vo;
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		vo = dao.getReserVationInfo_proc(airPlaneNo);
		return vo;
	}

	@Override
	public int airResProc_proc(AirReservationDetailVO vo) {
		int cnt = 0;
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.airResProc_proc(vo);
		
		return cnt;
	}

	@Override
	public int modifyAirPlane_remainSeat_proc(Map<String, Object> map) {
		int cnt = 0;
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.modifyAirPlane_remainSeat_proc(map);
		
		return cnt;
	}

	@Override
	public AirPlaneVO getRemainSeat_proc(String airPlaneNo) {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		AirPlaneVO vo = dao.getRemainSeat_proc(airPlaneNo);
		return vo;
	}

	@Override
	public String getRouteNo_proc(String airPlaneNo) {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		String routeNo = dao.getRouteNo_proc(airPlaneNo);
		return routeNo;
	}

	@Override
	public RouteVO getRouteInfo_proc(String routeNo) {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		RouteVO vo = dao.getRouteInfo_proc(routeNo);
		return vo;
	}

	@Override
	public List<AirReservationDetailVO> getMyPageReserAirPlane_proc(Map<String, Object> map) {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		List<AirReservationDetailVO> voList = dao.getMyPageReserAirPlane_proc(map);
		
		return voList;
	}

	@Override
	public List<AirReservationDetailVO> getAirReserVationList_proc(Map<String, Object> map) {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		List<AirReservationDetailVO> vo = dao.getAirReserVationList_proc(map);
		return vo;
	}

	@Override
	public int airResCancelProc_proc(Map<String, Object> map) {

		int cnt = 0;
		String airResNo = (String)map.get("airResNo");
		String airPlaneNo = (String)map.get("airPlaneNo");

		
		AirReservationDetailVO vo = sqlSession.selectOne(nameSpace+".airResCancelProc_proc_step1",airResNo);
		
		cnt = sqlSession.delete(nameSpace+".airResCancelProc_proc_step2",airResNo);
		if(cnt == 1) {
			int restore_nomal = 0;
			int restore_highClass = 0;
			int restore_premium = 0;
			
			int adult = vo.getAdult();
			int student = vo.getStudent();
			int baby = vo.getBaby();
			
			String seatLevel_adult = vo.getSeatLevel_adult();
			String seatLevel_student = vo.getSeatLevel_student();
			String seatLevel_baby = vo.getSeatLevel_baby();
			
			
			if(seatLevel_adult.equals("nomal")) {
				restore_nomal+=adult;
			}
			else if(seatLevel_adult.equals("highClass")) {
				restore_highClass +=adult;
			}
			else if(seatLevel_adult.equals("premium")) {
				restore_premium +=adult;
			}
			
			if(seatLevel_student.equals("nomal")) {
				restore_nomal+=student;
			}
			else if(seatLevel_student.equals("highClass")) {
				restore_highClass +=student;
			}
			else if(seatLevel_student.equals("premium")) {
				restore_premium +=student;
			}
			
			if(seatLevel_baby.equals("nomal")) {
				restore_nomal+=baby;
			}
			else if(seatLevel_baby.equals("highClass")) {
				restore_highClass +=baby;
			}
			else if(seatLevel_baby.equals("premium")) {
				restore_premium +=baby;
			}
			
			map.clear();
			
			map.put("airPlaneNo", airPlaneNo);
			map.put("nomal",restore_nomal);
			map.put("highClass",restore_highClass);
			map.put("premium",restore_premium);
			map.forEach((k,v)->{
				System.out.println(k + " : " + v);
			});
			sqlSession.update(nameSpace+".airResCancelProc_proc_step3",map);
		}
		
		return cnt;
	}

	@Override
	public int setDefaultPriceUpdate_proc(Map<String, Object> map) {
		int cnt = 0;
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.setDefaultPriceUpdate_proc(map);
		return cnt;
	}

	//항공 전체결산 맵
	@Override
	public Map<String, Object> getChatData_Air(Map<String,Object> parameter) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		//항공예약건수를 가져온다.
		int res_air_count = sqlSession.selectOne(nameSpace+".getChatData_Air_chart1");
		int total_air_price = sqlSession.selectOne(nameSpace+".getChatData_Air_chart2");
		
		map.put("res_air_count",res_air_count);
		map.put("total_air_price",total_air_price);
		
		List<AirSaleVO> vo = sqlSession.selectList(nameSpace+".getChatData_Air_chart3",(String)parameter.get("year"));
		
		map.put("01",0);
		map.put("02",0);
		map.put("03",0);
		map.put("04",0);
		map.put("05",0);
		map.put("06",0);
		map.put("07",0);
		map.put("08",0);
		map.put("09",0);
		map.put("10",0);
		map.put("11",0);
		map.put("12",0);
		
		for (AirSaleVO i : vo) {
			System.out.println( i.getKey() + " : " + i.getValue());
			map.put(i.getKey(),i.getValue());
		}
		
		
		
		System.out.println("-------------------");
		
		map.forEach((k,v)->{System.out.println(k + " : " + v);});
		
		
		System.out.println(res_air_count);
		System.out.println(total_air_price);
		
		
		System.out.println("-------------------");
		
		return map;
	
	}

	
	@Override
	public List<MapVO> getChatDataCustom_Air1(Map<String, Object> parameter) {
	
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		
		List<MapVO> resList = dao.getChatDataCustom_Air1(parameter);
				
		return resList;
	}

	
	@Override
	public List<MapVO> getChatDataCustom_Air2(Map<String, Object> parameter) {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		
		List<MapVO> resList = dao.getChatDataCustom_Air2(parameter);
				
		return resList;
	}
	

	@Override
	public List<MapVO> getChatDataCustom_Air3(Map<String, Object> parameter) {
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		
		List<MapVO> resList = dao.getChatDataCustom_Air3(parameter);
				
		return resList;
	}

	@Override
	public int deadPlaneCollection_proc() {
		int cnt = 0;
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.deadPlaneCollection_proc();
		
		return cnt;
	}

	@Override
	public int getAirTotalPrice_proc() {
		int cnt = 0;
		
		AirReservationDAO dao = sqlSession.getMapper(AirReservationDAO.class);
		cnt = dao.getAirTotalPrice_proc();
		
		return cnt;
	}

	
	
}
