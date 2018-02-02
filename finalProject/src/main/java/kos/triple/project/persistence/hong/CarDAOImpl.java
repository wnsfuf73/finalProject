package kos.triple.project.persistence.hong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.CarInfoVO;
import kos.triple.project.vo.MapVO;
import kos.triple.project.vo.RentCarVO;
import kos.triple.project.vo.Reservation_CarVO;
import kos.triple.project.vo.rentTotalVO;

@Repository
public class CarDAOImpl implements CarDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "kos.triple.project.persistence.hong.CarDAO";
	
	//렌트카 추가
	@Override
	public int rentAdd(RentCarVO vo) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.rentAdd(vo);
		
		return cnt;
	}
	
	//렌트카 갯수구하기
	@Override
	public int getArticleCnt() {
		int cnt = 0;
				
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.getArticleCnt();
		
		return cnt;
	}
	
	//렌트카 갯수 구하기(차종별로)
	@Override
	public int getArticleCntKind(String car_kind) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.getArticleCntKind(car_kind);
		
		return cnt;
	}

	//렌트카 조회
	@Override
	public ArrayList<CarInfoVO> rentCar(Map<String,Object> map) {
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		ArrayList<CarInfoVO> dtos = dao.rentCar(map);
		
		return dtos;
	}

	//렌트카 전체 조회
	@Override
	public ArrayList<CarInfoVO> rentCarAll(Map<String,Integer> map) {
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		ArrayList<CarInfoVO> dtos = dao.rentCarAll(map);
		
		return dtos;
	}
	
	//렌트카 삭제
	@Override
	public int rentDelete(String car_num) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);

		cnt = dao.rentDelete(car_num);
		
		return cnt;
	}

	//렌트카 상세정보
	public CarInfoVO getViewDetail(String car_num) {
		
		CarInfoVO vo = null;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);

		vo = dao.getViewDetail(car_num);
		
		return vo;
	}

	//렌트카 예약
	@Override
	public int reservation_car(Reservation_CarVO vo) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);	
		cnt = dao.reservation_car(vo);
		dao.carMaineoseu(vo);
		
		return cnt;
	}

	//렌트예약 완료 - 차수량을 뺀다
	@Override
	public int carMaineoseu(Reservation_CarVO vo) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.carMaineoseu(vo);
		
		return cnt;
	}

	//예약리스트 갯수 구하기
	@Override
	public int rentReservationCnt(Map<String,Object> map) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.rentReservationCnt(map);
		
		return cnt;
	}

	//예약리스트 조회하기
	@Override
	public ArrayList<Reservation_CarVO> rentReservationList(Map<String, Object> map) {
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		ArrayList<Reservation_CarVO> dtos = dao.rentReservationList(map);
		
		return dtos;
	}

	//예약리스트 조회하기 - 게스트
	@Override
	public ArrayList<Reservation_CarVO> rentReservationList_myPage(Map<String, Object> map) {

		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		ArrayList<Reservation_CarVO> dtos = dao.rentReservationList_myPage(map);
		
		return dtos;
	}

	//렌트카 예약 취소
	@Override
	public int carResCancel(String rent_no) {

		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		dao.carResCancel_rentCountAdd(rent_no);
		cnt = dao.carResCancel(rent_no);
		
		return cnt;
	}

	//렌트카 예약 취소로 인한 차량 수량 증가
	@Override
	public int carResCancel_rentCountAdd(String rent_no) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		cnt = dao.carResCancel_rentCountAdd(rent_no);
		
		return cnt;
	}

	//차량 날짜 조회(예약을 했을때 똑같은 날짜에 예약이 불가능하게, 다른 날짜 조회했을때 예약 가능하게)
	@Override
	public List<Reservation_CarVO> date() {
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		List<Reservation_CarVO> vo = dao.date();
		
		return vo;
	}

	//렌트카 반납
	@Override
	public int carResReturn(String rent_no) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		dao.carUseKmUp(rent_no);
		cnt = dao.carResCancel_rentCountAdd(rent_no);
		
		return cnt;
		
	}

	//렌트카 반납 - 사용KM증가
	@Override
	public int carUseKmUp(String rent_no) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.carUseKmUp(rent_no);
		
		return cnt;
	}

	//차종별 결산 결산
	@Override
	public Map<String, Object> rentPriceTotal() {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<MapVO> price = sqlSession.selectList(namespace+".carKindTotal");
		
		map.put("소형",0);
		map.put("중형",0);
		map.put("대형",0);
		map.put("SUV",0);
		map.put("스포츠",0);
		map.put("total",0);

		for (MapVO i : price) {
			map.put(i.getKey(),i.getValue());
			System.out.println("key : " + i.getKey());
			System.out.println("value : " + i.getValue());
		}
		
		return map;
	}

	//차종별 건수 
	@Override
	public Map<String, Object> rentKindCount() {
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<MapVO> car_kind = sqlSession.selectList(namespace+".carKindSelect");
		
		map.put("소형",0);
		map.put("중형",0);
		map.put("대형",0);
		map.put("SUV",0);
		map.put("스포츠",0);
		map.put("total",0);
		
		for (MapVO i : car_kind) {
			map.put(i.getKey(), i.getValue());
		}
		
		return map;
	}

	//날짜별 가격
	@Override
	public Map<String, Object> rentDateTotal(String year) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<MapVO> datePrice = sqlSession.selectList(namespace+".rentDateTotal",year);
		
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
		
		for (MapVO i : datePrice) {
			map.put(i.getKey(), i.getValue());
		}
		
		return map;
	}

	@Override
	public int getFirstChat_car() {

		int count_car = sqlSession.selectOne(namespace+".getFirstChat_car");
		return count_car;
	}

	@Override
	public int getSecondChat_car() {

		int price_car = sqlSession.selectOne(namespace+".getSecondChat_car");
		return price_car;
	}

	@Override
	public Map<String, Object> getFinalChat_car(String year) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MapVO> list = sqlSession.selectList(namespace+".getFinalChat_car",year);
		
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
		
		for(MapVO i : list) {
			map.put(i.getKey(),i.getValue());
		}
		
		return map;
	}

	


}