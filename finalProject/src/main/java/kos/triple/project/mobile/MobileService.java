package kos.triple.project.mobile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MobileService {

	//로그인통과확인
	void loginConfirm(HttpServletRequest req);

	//로그인여부확인
	void startRedirect(HttpServletRequest req);

	//해당기기와 아이디를 동기화
	void phoneSync(HttpServletRequest req);

	//로그인상태인경우 메인액티비티로 넘어갈때 아이디값을 가져온다.
	void getSavedId(HttpServletRequest req);

	//로그아웃을 처리한다.
	void mobileLogout(HttpServletRequest req);

	//조건에 맞는 항공편을 가져온다.
	void airPlaneSearch(HttpServletRequest req);

	//STEP1 정보를 가져온다.
	void getReserVationInfo(HttpServletRequest req);

	//항공 예약을 한다
	void mobileReservationProc(HttpServletRequest req);

	
	
}
