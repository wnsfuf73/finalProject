package kos.triple.project.mobile;

import java.util.List;
import java.util.Map;

import kos.triple.project.mobile.vo.AirReservationSearchVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.RouteVO;

public interface MobileDAO {

	//로그인가능여부확인
	int loginConfirm_proc(Map<String, Object> map);

	//해당기기의 로그인여부확인
	int startRedirect_proc(String phone);

	//모바일기기와 로그인정보동기화
	int phoneSync_proc(Map<String, Object> map);

	//모바일에 이미 로그인되있는경우 저장된아이디를 가져온다.
	String getSavedId_proc(String phonenumber);

	//모바일에 로그아웃을 처리한다.
	int mobileLogout_proc(Map<String,Object> map );

	//공항이름을 공항번호로 가져온다.
	String getAirportNo_proc(String location);
	
	//공항번호를 공항이름으로 가려온다.
	String getAirportName_proc(String routeNo);

	//조건에맞는 항공편을 가져온다.
	List<AirReservationSearchVO> airPlaneSearch_proc(Map<String, Object> map);

	//STEP1에 필요한 값을 가져온다.
	AirReservationSearchVO getReserVationInfo_proc(String airPlaneNo);

	//노선정보를 가져온다.
	RouteVO getRouteInfo(String airPlaneNo);

	//예약을 확정한다.
	int reservationComplete_proc(AirReservationDetailVO vo);

	//
	int setRemainSeatUpdate(Map<String,Object> map);
	
	


}
