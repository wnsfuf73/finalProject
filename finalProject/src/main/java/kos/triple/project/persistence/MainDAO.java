package kos.triple.project.persistence;

import java.util.List;
import java.util.Map;

import kos.triple.project.vo.BannerVO;
import kos.triple.project.vo.EpilogueMyVO;
import kos.triple.project.vo.EpilogueVO;
import kos.triple.project.vo.NoticeVO;
import kos.triple.project.vo.PlanVO;

public interface MainDAO {

	//������ �̹����� �����´�.
	public String getMyFaceImg_proc(String mem_id);

	//�����ġ�� ���� �̹��� ��θ� �����´�.
	public BannerVO getBanner_proc(Map<String,Object> map);

	//������ ��ġ�� ��ʼ��� �����´�.
	public int getBannerCount_proc(String bannerLocation);

	//�ֽŰ��������� �����´�.
	public NoticeVO getNewNotice_proc();

	//����Ʈ�����
	public EpilogueVO getHomePageBestTravel();
	
	//öȯ���� dao��
	public List<EpilogueVO> myNewStory_proc(String mem_id);

	//öȯ���� dao��
	public List<EpilogueMyVO> myEpilogueList_proc(Map<String,Object> map);

	//öȯ���� dao��
	public int getTotalCount(Map<String, Object> map);
	
	//öȯ���� dao��
	public String getEpilogue_Img1(int epilogueNo);
	
	//öȯ���� dao��
	public int deleteMyStory_proc(int epilogueNo);
	
	//ȣ���� dao��
	public List<PlanVO> myNewPlan_proc(String mem_id);





	
	
}
