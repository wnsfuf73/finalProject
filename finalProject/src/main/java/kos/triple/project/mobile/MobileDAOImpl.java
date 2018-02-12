package kos.triple.project.mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.mobile.vo.AirReservationSearchVO;
import kos.triple.project.mobile.vo.EpilogueMobileCourseVO;
import kos.triple.project.mobile.vo.EpilogueMobileVO;
import kos.triple.project.mobile.vo.MyResAirSummaryVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.CarInfoVO;
import kos.triple.project.vo.RouteVO;
import kos.triple.project.vo.WhereVO;

@Repository
public class MobileDAOImpl implements MobileDAO{

	@Autowired
	SqlSession sqlSession;
	private final String nameSpace = "kos.triple.project.mobile.MobileDAO";
	//로그인가능여부확인
	@Override
	public int loginConfirm_proc(Map<String, Object> map) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.loginConfirm_proc(map);
	}

	//해당기기의 로그인여부확인
	@Override
	public int startRedirect_proc(String phone) {
		int count = sqlSession.selectOne(nameSpace+".startRedirect_proc_beforeTask", phone);
		if(count==0) {
			return count;
		}
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.startRedirect_proc(phone);
	}

	//모바일정보와 동기화
	@Override
	public int phoneSync_proc(Map<String, Object> map) {
		String mem_id = map.get("mem_id").toString();
		
		int cnt = sqlSession.delete(nameSpace+".phoneSync_proc_step1",mem_id);
		map.put("islogin",1);
		cnt = sqlSession.insert(nameSpace+".phoneSync_proc_step2",map);
		
		return cnt;
	}

	@Override
	public String getSavedId_proc(String phonenumber) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getSavedId_proc(phonenumber);
	}

	@Override
	public int mobileLogout_proc(Map<String,Object> map ) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.mobileLogout_proc(map);
	}

	@Override
	public String getAirportNo_proc(String location) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getAirportNo_proc(location);
	}

	@Override
	public List<AirReservationSearchVO> airPlaneSearch_proc(Map<String, Object> map) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.airPlaneSearch_proc(map);
	}

	@Override
	public String getAirportName_proc(String routeNo) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getAirportName_proc(routeNo);
	}

	@Override
	public AirReservationSearchVO getReserVationInfo_proc(String airPlaneNo) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getReserVationInfo_proc(airPlaneNo);
	}

	@Override
	public RouteVO getRouteInfo(String airPlaneNo) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getRouteInfo(airPlaneNo);
	}

	@Override
	public int reservationComplete_proc(AirReservationDetailVO vo) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.reservationComplete_proc(vo);
	}

	@Override
	public int setRemainSeatUpdate(Map<String,Object> map) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.setRemainSeatUpdate(map);
	}

	@Override
	public List<String> mobileGetMyPageStartInfo_proc(String mem_id) {
		List<String> data = new ArrayList<String>();
		String tmp = null;
		String[] mapperName = { ".mobileGetMyPageStartInfo_proc_step1" //항공
							,".mobileGetMyPageStartInfo_proc_step2" //숙박
							,".mobileGetMyPageStartInfo_proc_step3" //렌트
							};
		
		for(String i : mapperName) {
			tmp = Integer.toString(sqlSession.selectOne(nameSpace+i,mem_id));
			data.add(tmp);
		}
		
		tmp = sqlSession.selectOne(nameSpace+".mobileGetMyPageStartInfo_proc_step4",mem_id); //프로필이미지
		data.add(tmp);
		
		return data;
	}

	@Override
	public List<MyResAirSummaryVO> mobileGetMyAirReservationList_proc(String mem_id) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.mobileGetMyAirReservationList_proc(mem_id);
	}

	@Override
	public String getAirPlaneName(String airPlaneNo) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getAirPlaneName(airPlaneNo);
	}

	@Override
	public int mobileCancelReservationAir(Map<String, Object> map) {

		int cnt = 0;
		String airResNo = (String)map.get("airResNo");
		String airPlaneNo = (String)map.get("airPlaneNo");

		AirReservationDetailVO vo = sqlSession.selectOne(nameSpace+".mobileCancelReservationAir_step1",airResNo);
		
		cnt = sqlSession.delete(nameSpace+".mobileCancelReservationAir_step2",airResNo);
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
			sqlSession.update(nameSpace+".mobileCancelReservationAir_step3",map);
		}
		
		return cnt;
		
	}

	@Override
	public List<CarInfoVO> mobileRentList_proc(Map<String, Object> map) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.mobileRentList_proc(map);
	}

	@Override
	public List<EpilogueMobileVO> getMobileStory_proc() {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getMobileStory_proc();
	}

	@Override
	public String getEpilogueFrontImage(int epilogueNo) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getEpilogueFrontImage(epilogueNo);
	}
	
	@Override
	public EpilogueMobileVO getMobileStoryDetail_proc(int epilogueNo) {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getMobileStoryDetail_proc(epilogueNo);
	}
	
	@Override
	public List<EpilogueMobileCourseVO> getMobileStoryDetailCourse_proc(int epilogueNo){
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getMobileStoryDetailCourse_proc(epilogueNo);
	}

	@Override
	public List<WhereVO> getMobileWhereAll_proc() {
		MobileDAO dao = sqlSession.getMapper(MobileDAO.class);
		return dao.getMobileWhereAll_proc();
	}

	@Override
	public List<WhereVO> getMobileWhereArea_proc(String area) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("area",area);
		return sqlSession.selectList(nameSpace+".getMobileWhereArea_proc",map);
	}
	
}
