package kos.triple.project.persistence;

import java.util.List;
import java.util.Map;

import kos.triple.project.vo.BannerVO;
import kos.triple.project.vo.EpilogueMyVO;
import kos.triple.project.vo.EpilogueVO;
import kos.triple.project.vo.NoticeVO;
import kos.triple.project.vo.PlanVO;

public interface MainDAO {

	//프로필 이미지를 가져온다.
	public String getMyFaceImg_proc(String mem_id);

	//배너위치에 대한 이미지 경로를 가져온다.
	public BannerVO getBanner_proc(Map<String,Object> map);

	//지정된 위치의 배너수를 가져온다.
	public int getBannerCount_proc(String bannerLocation);

	//최신공지사항을 가져온다.
	public NoticeVO getNewNotice_proc();

	//베스트여행기
	public EpilogueVO getHomePageBestTravel();
	
	//철환이형 dao로
	public List<EpilogueVO> myNewStory_proc(String mem_id);

	//철환이형 dao로
	public List<EpilogueMyVO> myEpilogueList_proc(Map<String,Object> map);

	//철환이형 dao로
	public int getTotalCount(Map<String, Object> map);
	
	//철환이형 dao로
	public String getEpilogue_Img1(int epilogueNo);
	
	//철환이형 dao로
	public int deleteMyStory_proc(int epilogueNo);
	
	//호선이 dao로
	public List<PlanVO> myNewPlan_proc(String mem_id);





	
	
}
