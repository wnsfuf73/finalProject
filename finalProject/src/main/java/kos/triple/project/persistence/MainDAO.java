package kos.triple.project.persistence;

import java.util.List;
import java.util.Map;

import kos.triple.project.vo.BannerVO;
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

	//öȯ���� dao��
	public List<EpilogueVO> myNewStory_proc(String mem_id);

	//ȣ���� dao��
	public List<PlanVO> myNewPlan_proc(String mem_id);

	
}
