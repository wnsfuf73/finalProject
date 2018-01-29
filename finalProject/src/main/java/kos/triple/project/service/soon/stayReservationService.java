package kos.triple.project.service.soon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface stayReservationService {

	// 숙박지 검색
	public void stay_search(HttpServletRequest req, Model model);

	// 숙박지 상세 보기
	public void stay_view(HttpServletRequest req, Model model);

	// 숙박지 객실 검색
	public void stay_room_search(HttpServletRequest req, Model model);

	// 숙박지 객실 상세보기
	public void stay_room_view(HttpServletRequest req, Model model);

	// 숙박지 객실 예약
	public void stay_room_reservation(HttpServletRequest req, Model model);
	
	// 숙박지 객실 예약 취소
	public void stayResCancel(HttpServletRequest req, Model model);
	
	// 마이 페이지
	public void getMyPageReserStay(HttpServletRequest req, Model model);

	// 관리자
	// 숙박지 추가
	public void stay_add(MultipartHttpServletRequest req, Model model);

	// 숙박지 목록
	public void stay_list(HttpServletRequest req, Model model);

	// 숙박지 세부 관리
	public void stay_list_view(HttpServletRequest req, Model model);

	// 숙박지 수정
	public void modify(MultipartHttpServletRequest req, Model model);

	// 숙박지 삭제
	public void delete(HttpServletRequest req, Model model);

	// 숙박지 객실 추가
	public void stay_room_add(MultipartHttpServletRequest req, Model model);

	// 숙박지 객실 목록
	public void stay_room_list(HttpServletRequest req, Model model);

	// 숙박지 객실 세부 관리
	public void stay_room_list_view(HttpServletRequest req, Model model);

	// 숙박지 객실 수정
	public void stay_room_modify(MultipartHttpServletRequest req, Model model);

	// 숙박지 삭제
	public void stay_room_delete(HttpServletRequest req, Model model);
	
	// 숙박 예약 현황
	public void stay_reservation_list(HttpServletRequest req, Model model);
	
	// 숙박 예약 결산
	public void stay_reservation_total(HttpServletRequest req, Model model);

	// 숙박 예약 결산 -> 통합
	public void getCharData_Stay(HttpServletRequest req, Model model);
}
