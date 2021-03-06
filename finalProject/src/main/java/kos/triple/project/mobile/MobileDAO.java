package kos.triple.project.mobile;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kos.triple.project.mobile.vo.AirReservationSearchVO;
import kos.triple.project.mobile.vo.EpilogueMobileCourseVO;
import kos.triple.project.mobile.vo.EpilogueMobileVO;
import kos.triple.project.mobile.vo.MyResAirSummaryVO;
import kos.triple.project.mobile.vo.MyResStayReservationVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.CarInfoVO;
import kos.triple.project.vo.RouteVO;
import kos.triple.project.vo.WhereVO;

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

	//좌석남은수를 업데이트한다.
	int setRemainSeatUpdate(Map<String,Object> map);

	//마이페이지 시작데이터(각예약건수 , 프로필이미지)를 가져온다
	List<String> mobileGetMyPageStartInfo_proc(String mem_id);

	//마이페이지에서 항공예약목록가져온다(최소정보)
	List<MyResAirSummaryVO> mobileGetMyAirReservationList_proc(String mem_id);

	//항공기번호로 이름을 가져온다.
	String getAirPlaneName(String airPlaneNo);

	//모바일에서 항공예약을 취소한다.
	int mobileCancelReservationAir(Map<String, Object> map);

	/* 숙박 */
	/* 이야기 */
	
	//숙박 예약목록을 가져온다.
	List<MyResStayReservationVO> getMyStayReservationList(String mem_id);
	//전체이야기를 가져온다.
	List<EpilogueMobileVO> getMobileStory_proc();
	
	//이야기의 대표이미지를 가져온다.
	String getEpilogueFrontImage(int epilogueNo);
	
	//이야기 한건을 가져온다.
	EpilogueMobileVO getMobileStoryDetail_proc(int epilogueNo);
	
	//이야기에 등록된 코스들을 가져온다.
	List<EpilogueMobileCourseVO> getMobileStoryDetailCourse_proc(int epilogueNo);
	
	/* 이야기 */
	
	/* 여행지 정보 */
	
	//여행지 정보를 가져온다.
	List<WhereVO> getMobileWhereAll_proc();
	
	//여행지 정보를 가져온다. 지역별
	List<WhereVO> getMobileWhereArea_proc(String area);

	/* 여행지 정보 */
	
	/* 렌트예약목록을 가져온다. */
	List<CarInfoVO> mobileRentList_proc(Map<String, Object> map);






	

	/* 숙박 */


}
