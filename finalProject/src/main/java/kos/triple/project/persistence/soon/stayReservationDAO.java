package kos.triple.project.persistence.soon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kos.triple.project.vo.Reservation_StayVO;
import kos.triple.project.vo.StayRoomVO;
import kos.triple.project.vo.StayVO;
import kos.triple.project.vo.StayVO;
import kos.triple.project.vo.WhereVO;

public interface stayReservationDAO {
	// 숙박지 검색
	public ArrayList<StayVO> stay_search(Map<String, Object> map);
	
	// 숙박지 상세 보기
	public StayVO stay_view(String stay_no);
	
	// 숙박지 객실 예약
	public StayRoomVO stay_room_view(String room_no);
	
	// 숙박찌 객실 날짜 검색
	public List<Reservation_StayVO> date();
	
	// 숙박지 객실 예약 처리
	public int stay_room_reservation(Map<String, Object> map);
	
	// 숙박지 객실 예약 취소
	public void stayResCancel(String reservation_no);
	
	// 마이 페이지
	
	// 예약 개수
	public int rentReservationCnt();
	
	// 예약 목록
	public ArrayList<Reservation_StayVO> reservation_staylist(Map<String, Object> map);
	
	//관리자

	// 숙박지 추가
	public int stay_add(StayVO vo);

	// 숙박지 개수
	public int getCountCnt();

	// 숙박지 목록
	public ArrayList<StayVO> stay_list(Map<String, Integer> map);

	// 숙박지 세부 관리
	public StayVO stay_list_view(String stay_no);

	// 숙박지 수정
	public int modify(StayVO vo);

	// 숙박지 수정(이미지)
	public int updateImg(Map<String, Object> imgMap);

	// 숙박지 삭제
	public int delete(String stay_no);

	// 숙박지 객실 추가
	public int stay_room_add(StayVO vo);

	// 숙박지 객실 목록
	public ArrayList<StayVO> stay_room_list(String stay_no);

	// 숙박지 객실 세부 관리
	public StayVO stay_room_list_view(String room_no);

	// 숙박지 객실 수정
	public int stay_room_modify(StayVO vo);

	// 숙박지 객실 수정(이미지)
	public int room_updateImg(Map<String, Object> imgMap);
	
	// 숙박지 객실 삭제
	public int stay_room_delete(String room_no);
	
	// 숙박 예약 현황
	public ArrayList<Reservation_StayVO> stay_reservation_list(Map<String, Object> map);
	
	// 숙박 예약 결산(가격)
	public int getTotalSale();
	
	// 숙박 예약 결산(막대 그래프)
	public Map<String, Object> getFirstChart();
	
	// 숙박 예약 결산(원 그래프)
	public Map<String, Object> getSecondChart();
	
	// 숙박 예약 결산(날짜별 판매량)
	public Map<String, Object> getFinalChart(String year);

	//첫번째 차트 -> 통합버전
	public int getFirstChartAll();

	//두번째 차트 -> 통합버전
	public int getSecondChartAll();

	//세번째 차트 -> 통합버전
	public Map<String, Object> getFinalChartAll(String year);
	
	
}
