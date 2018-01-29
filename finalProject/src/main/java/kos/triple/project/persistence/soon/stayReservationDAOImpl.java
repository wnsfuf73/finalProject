package kos.triple.project.persistence.soon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.MapVO;
import kos.triple.project.vo.Reservation_StayVO;
import kos.triple.project.vo.StayRoomVO;
import kos.triple.project.vo.StayVO;

@Repository
public class stayReservationDAOImpl implements stayReservationDAO {

	@Inject
	SqlSession sqlSession;
	
	private final String namespace = "kos.triple.project.persistence.soon.stayReservationDAO";
	
	@Override
	public ArrayList<StayVO> stay_search(Map<String, Object> map) {
		ArrayList<StayVO> vos = null; // 큰 바구니

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vos = dao.stay_search(map);
		
		return vos;
	}
	
	@Override
	public StayVO stay_view(String stay_no) {
		StayVO vo = null;
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vo = dao.stay_view(stay_no);
			
		return vo;
	}
	
	@Override
	public StayRoomVO stay_room_view(String room_no) {
		StayRoomVO vo = null;
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vo = dao.stay_room_view(room_no);
			
		return vo;
	}
	
	@Override
	public List<Reservation_StayVO> date(){
		List<Reservation_StayVO> vos = null;
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vos = dao.date();
		
		return vos;
	}
	
	@Override
	public int stay_room_reservation(Map<String, Object> map) {
		int cnt = 0;
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.stay_room_reservation(map);
		
		return cnt;
	}
	
	@Override
	public void stayResCancel(String reservation_no) {
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		dao.stayResCancel(reservation_no);
	}

	
	// 마이 페이지
	@Override
	public int rentReservationCnt() {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.rentReservationCnt();

		return cnt;
	}
	
	@Override
	public ArrayList<Reservation_StayVO> reservation_staylist(Map<String, Object> map) {
		ArrayList<Reservation_StayVO> vos = null;
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vos = dao.reservation_staylist(map);
		
		return vos;
	}
	
	//관리자

	@Override
	public int stay_add(StayVO vo) {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.stay_add(vo);

		return cnt;
	}

	@Override
	public int getCountCnt() {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.getCountCnt();

		return cnt;
	}

	@Override
	public ArrayList<StayVO> stay_list(Map<String, Integer> map) {
		ArrayList<StayVO> vos = null;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vos = dao.stay_list(map);

		return vos;
	}

	@Override
	public StayVO stay_list_view(String stay_no) {
		StayVO vo = null;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vo = dao.stay_list_view(stay_no);

		return vo;
	}

	@Override
	public int modify(StayVO vo) {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.modify(vo);

		return cnt;
	}

	@Override
	public int updateImg(Map<String, Object> imgMap) {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.updateImg(imgMap);
		
		return cnt;
	}

	@Override
	public int delete(String stay_no) {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.delete(stay_no);

		return cnt;
	}

	@Override
	public int stay_room_add(StayVO vo) {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.stay_room_add(vo);
		
		return cnt;
	}

	@Override
	public ArrayList<StayVO> stay_room_list(String stay_no) {
		ArrayList<StayVO> vos = null;
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vos = dao.stay_room_list(stay_no);
		
		return vos;
	}

	@Override
	public StayVO stay_room_list_view(String room_no) {
		StayVO vo = null;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vo = dao.stay_room_list_view(room_no);

		return vo;
	}

	@Override
	public int stay_room_modify(StayVO vo) {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.stay_room_modify(vo);

		return cnt;
	}

	@Override
	public int room_updateImg(Map<String, Object> imgMap) {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.room_updateImg(imgMap);
		
		return cnt;
	}

	@Override
	public int stay_room_delete(String room_no) {
		int cnt = 0;

		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.stay_room_delete(room_no);

		return cnt;
	}

	@Override
	public ArrayList<Reservation_StayVO> stay_reservation_list(Map<String, Object> map) {
		ArrayList<Reservation_StayVO> vos = null;
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		vos = dao.stay_reservation_list(map);
		
		return vos;
	}

	@Override
	public int getTotalSale() {
		int cnt = 0;
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		cnt = dao.getTotalSale();
		
		return cnt;
	}

	@Override
	public Map<String, Object> getFirstChart() {
		Map<String, Object> m = new HashMap<String, Object>();
		
		List<MapVO> price = sqlSession.selectList(namespace+".getFirstChart");
		
		m.put("total", 0);
		m.put("호텔", 0);
		m.put("펜션", 0);
		m.put("리조트", 0);
		m.put("게스트하우스", 0);
		
		for (MapVO i : price) {
	         m.put(i.getKey(),i.getValue());
	         System.out.println("kind : " + i.getKey());
	         System.out.println("value : " + i.getValue());
	      }
			
		return m;
	}
	
	@Override
	public Map<String, Object> getSecondChart() {
		Map<String, Object> m = new HashMap<String, Object>();
		
		List<MapVO> kind = sqlSession.selectList(namespace+".getSecondChart");
		
		m.put("total", 0);
		m.put("호텔", 0);
		m.put("펜션", 0);
		m.put("리조트", 0);
		m.put("게스트하우스", 0);
		
		for (MapVO i : kind) {
	         m.put(i.getKey(),i.getValue());
	      }
			
		return m;
	}
	
	@Override
	public Map<String, Object> getFinalChart(String year) {
		Map<String, Object> m = new HashMap<String, Object>();
		
		List<MapVO> date = sqlSession.selectList(namespace+".getFinalChart", year);
		
		m.put("total", 0);
		m.put("01", 0);
		m.put("02", 0);
		m.put("03", 0);
		m.put("04", 0);
		m.put("05", 0);
		m.put("06", 0);
		m.put("07", 0);
		m.put("08", 0);
		m.put("09", 0);
		m.put("10", 0);
		m.put("11", 0);
		m.put("12", 0);
		
		for (MapVO i : date) {
	         m.put(i.getKey(),i.getValue());
	      }
			
		return m;
	}

	@Override
	public int getFirstChartAll() {
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		int result = dao.getFirstChartAll();
		return result;
	}

	@Override
	public int getSecondChartAll() {
		
		stayReservationDAO dao = sqlSession.getMapper(stayReservationDAO.class);
		int result = dao.getSecondChartAll();
		return result;
	
	}

	@Override
	public Map<String, Object> getFinalChartAll(String year) {
		
		Map<String, Object> m = new HashMap<String, Object>();
		List<MapVO> list = sqlSession.selectList(namespace+".getFinalChartAll",year);
		
		m.put("01", 0);
		m.put("02", 0);
		m.put("03", 0);
		m.put("04", 0);
		m.put("05", 0);
		m.put("06", 0);
		m.put("07", 0);
		m.put("08", 0);
		m.put("09", 0);
		m.put("10", 0);
		m.put("11", 0);
		m.put("12", 0);
		
		for(MapVO i : list) {
			m.put(i.getKey(), i.getValue());
		}
		
		m.forEach((k,v)->{
			System.out.println(k + " : " + v);
		});
		
		return m;
	}

}
