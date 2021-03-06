package kos.triple.project.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MainService {

	//베스트여행기를 가져온다.
	void getHomePageBestTravel(HttpServletRequest req, Model model);
	
	//프로필 이미지를 가져온다.
	void getMyFaceImg(HttpServletRequest req, Model model);

	//배너이미지를 가져온다.
	void getBanner(HttpServletRequest req, Model model);

	//지정된 위치의 배너의 개수를 가져온다.
	void getBannerCount(HttpServletRequest req, Model model);

	//메인접속시 팝업(최신 공지사항 1건 가져온다)
	void getNewNotice(HttpServletRequest req, Model model);

	
	//철환이형 서비스로 옯긴다.
	void myNewStory(HttpServletRequest req, Model model);

	//철환이형 서비스로 옮긴다. 마이페이지 자신의 이야기
	void myEpilogueList(HttpServletRequest req, Model model);

	//철환이형 서비스로 옮긴다. 마이페이지 이야기 삭제
	void deleteMyStory(HttpServletRequest req, Model model);
	
	//호선이 서비스로 옯긴다.
	void myNewPlan(HttpServletRequest req, Model model);

	


	
}
