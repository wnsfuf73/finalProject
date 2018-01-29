package kos.triple.project.persistence.hong;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kos.triple.project.vo.CarInfoVO;
import kos.triple.project.vo.RentCarVO;
import kos.triple.project.vo.Reservation_CarVO;
import kos.triple.project.vo.rentTotalVO;

public interface CarDAO {
	
	//렌트카추가
	public int rentAdd(RentCarVO vo);
	
	//렌트카 갯수 구하기
	public int getArticleCnt();
	
	//렌트카 갯수 구하기(차종별로)
	public int getArticleCntKind(String car_kind);
	
	//렌트카 조회
	public ArrayList<CarInfoVO> rentCar(Map<String,Object> map);
	
	//렌트카 전체 조회
	public ArrayList<CarInfoVO> rentCarAll(Map<String,Integer> map);
	
	//차량삭제	
	public int rentDelete(String car_num);
	
	//차량상세정보가져오기
	public CarInfoVO getViewDetail(String car_num);
	
	//렌트카 예약
	public int reservation_car(Reservation_CarVO vo);
	
	//렌트예약 완료 - 차수량을 뺀다
	public int carMaineoseu(Reservation_CarVO vo);
	
	//예약 리스트 갯수 구하기
	public int rentReservationCnt(Map<String,Object> map);
	
	//예약리스트 조회하기
	public ArrayList<Reservation_CarVO> rentReservationList(Map<String, Object> map);

	//예약리스트 조회하기 - 게스트
	public ArrayList<Reservation_CarVO> rentReservationList_myPage(Map<String, Object> map);
	
	//렌트카 예약 취소
	public int carResCancel(String rent_no);
	
	//렌트카 예약 취소로 인한 차량 수량 증가
	public int carResCancel_rentCountAdd(String rent_no);
	
	//차량 날짜 조회(예약을 했을때 똑같은 날짜에 예약이 불가능하게, 다른 날짜 조회했을때 예약 가능하게)
	public List<Reservation_CarVO> date();
	
	//렌트카 반납
	public int carResReturn(String rent_no);
	
	//렌트카 반납 - 사용KM증가
	public int carUseKmUp(String rent_no);
	
	//차종별 결산
	public Map<String,Object> rentPriceTotal();
	
	//차종별 건수 
	public Map<String,Object> rentKindCount();
	
	//날짜별 건수
	public Map<String,Object> rentDateTotal(String year);

	//첫번째카트 -> 통합
	public int getFirstChat_car();
	
	//두번째카트 -> 통합
	public int getSecondChat_car();

	//세번째카트 -> 통합
	public Map<String, Object> getFinalChat_car(String year);
}
