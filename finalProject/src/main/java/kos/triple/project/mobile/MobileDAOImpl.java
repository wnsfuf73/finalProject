package kos.triple.project.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.mobile.vo.AirReservationSearchVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.RouteVO;

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
}
