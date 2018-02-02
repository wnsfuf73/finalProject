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
	
	//��Ʈī �߰�
	@Override
	public int rentAdd(RentCarVO vo) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.rentAdd(vo);
		
		return cnt;
	}
	
	//��Ʈī �������ϱ�
	@Override
	public int getArticleCnt() {
		int cnt = 0;
				
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.getArticleCnt();
		
		return cnt;
	}
	
	//��Ʈī ���� ���ϱ�(��������)
	@Override
	public int getArticleCntKind(String car_kind) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.getArticleCntKind(car_kind);
		
		return cnt;
	}

	//��Ʈī ��ȸ
	@Override
	public ArrayList<CarInfoVO> rentCar(Map<String,Object> map) {
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		ArrayList<CarInfoVO> dtos = dao.rentCar(map);
		
		return dtos;
	}

	//��Ʈī ��ü ��ȸ
	@Override
	public ArrayList<CarInfoVO> rentCarAll(Map<String,Integer> map) {
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		ArrayList<CarInfoVO> dtos = dao.rentCarAll(map);
		
		return dtos;
	}
	
	//��Ʈī ����
	@Override
	public int rentDelete(String car_num) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);

		cnt = dao.rentDelete(car_num);
		
		return cnt;
	}

	//��Ʈī ������
	public CarInfoVO getViewDetail(String car_num) {
		
		CarInfoVO vo = null;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);

		vo = dao.getViewDetail(car_num);
		
		return vo;
	}

	//��Ʈī ����
	@Override
	public int reservation_car(Reservation_CarVO vo) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);	
		cnt = dao.reservation_car(vo);
		dao.carMaineoseu(vo);
		
		return cnt;
	}

	//��Ʈ���� �Ϸ� - �������� ����
	@Override
	public int carMaineoseu(Reservation_CarVO vo) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.carMaineoseu(vo);
		
		return cnt;
	}

	//���ฮ��Ʈ ���� ���ϱ�
	@Override
	public int rentReservationCnt(Map<String,Object> map) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.rentReservationCnt(map);
		
		return cnt;
	}

	//���ฮ��Ʈ ��ȸ�ϱ�
	@Override
	public ArrayList<Reservation_CarVO> rentReservationList(Map<String, Object> map) {
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		ArrayList<Reservation_CarVO> dtos = dao.rentReservationList(map);
		
		return dtos;
	}

	//���ฮ��Ʈ ��ȸ�ϱ� - �Խ�Ʈ
	@Override
	public ArrayList<Reservation_CarVO> rentReservationList_myPage(Map<String, Object> map) {

		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		ArrayList<Reservation_CarVO> dtos = dao.rentReservationList_myPage(map);
		
		return dtos;
	}

	//��Ʈī ���� ���
	@Override
	public int carResCancel(String rent_no) {

		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		dao.carResCancel_rentCountAdd(rent_no);
		cnt = dao.carResCancel(rent_no);
		
		return cnt;
	}

	//��Ʈī ���� ��ҷ� ���� ���� ���� ����
	@Override
	public int carResCancel_rentCountAdd(String rent_no) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		cnt = dao.carResCancel_rentCountAdd(rent_no);
		
		return cnt;
	}

	//���� ��¥ ��ȸ(������ ������ �Ȱ��� ��¥�� ������ �Ұ����ϰ�, �ٸ� ��¥ ��ȸ������ ���� �����ϰ�)
	@Override
	public List<Reservation_CarVO> date() {
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		
		List<Reservation_CarVO> vo = dao.date();
		
		return vo;
	}

	//��Ʈī �ݳ�
	@Override
	public int carResReturn(String rent_no) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		dao.carUseKmUp(rent_no);
		cnt = dao.carResCancel_rentCountAdd(rent_no);
		
		return cnt;
		
	}

	//��Ʈī �ݳ� - ���KM����
	@Override
	public int carUseKmUp(String rent_no) {
		
		int cnt = 0;
		
		CarDAO dao = sqlSession.getMapper(CarDAO.class);
		cnt = dao.carUseKmUp(rent_no);
		
		return cnt;
	}

	//������ ��� ���
	@Override
	public Map<String, Object> rentPriceTotal() {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<MapVO> price = sqlSession.selectList(namespace+".carKindTotal");
		
		map.put("����",0);
		map.put("����",0);
		map.put("����",0);
		map.put("SUV",0);
		map.put("������",0);
		map.put("total",0);

		for (MapVO i : price) {
			map.put(i.getKey(),i.getValue());
			System.out.println("key : " + i.getKey());
			System.out.println("value : " + i.getValue());
		}
		
		return map;
	}

	//������ �Ǽ� 
	@Override
	public Map<String, Object> rentKindCount() {
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<MapVO> car_kind = sqlSession.selectList(namespace+".carKindSelect");
		
		map.put("����",0);
		map.put("����",0);
		map.put("����",0);
		map.put("SUV",0);
		map.put("������",0);
		map.put("total",0);
		
		for (MapVO i : car_kind) {
			map.put(i.getKey(), i.getValue());
		}
		
		return map;
	}

	//��¥�� ����
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