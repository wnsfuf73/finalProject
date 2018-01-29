package kos.triple.project.service.hong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface CarService {
	
	//렌트카 추가
	public void rentAdd(MultipartHttpServletRequest req, Model model);
	
	//렌트카 조회
	public void rentCar(HttpServletRequest req, Model model);
	
	//렌트카 삭제
	public void rentDelete(HttpServletRequest req, Model model);
	
	//렌트카 상세 조회
	public void getViewDetail(HttpServletRequest req, Model model);
	
	//렌트카 예약하기
	public void rentReservation(HttpServletRequest req, Model model);
	
	//호트스 예약 조회
	public void rentReservationList(HttpServletRequest req, Model model);

	//게스트 렌트 예약 조회 리스트를 가져온다
	public void rentReservationList_myPage(HttpServletRequest req, Model model);
	
	//렌트카 예약 취소
	public void carResCancel(HttpServletRequest req, Model model);
	
	//렌트카 반납
	public void carResReturn(HttpServletRequest req, Model model);
	
	//결산 전체통합용
	public void getCharData_Car(HttpServletRequest req, Model model);
	
	//결산 커스텀용
	public void rentTotal(HttpServletRequest req, Model model);
	
	

}
