package kos.triple.project.persistence.hee;

import java.util.ArrayList;
import java.util.Map;

import kos.triple.project.vo.BannerVO;

public interface BannerDAO {
	
	// ��� �� ����
	public int getBannerCnt();
	
	// ��� �� ��� ��ȸ
	public ArrayList<BannerVO> getBannerList(Map<String, Object>map);
	
	// ��� �� �� ������
	public BannerVO getDetailBannerContent(int bannerNo);

	// ��� �� ���
	public int registerBanner(BannerVO vo);
	
	// ��� �� ����
	public int deleteBanner(int bannerNo);
	
	// ��� �� ����
	public int updateBanner(BannerVO vo);
	
	// ��� �̹��� ����
	public int updateBannerImg(Map<String, Object> map);

	//Ư�������ġ�� ��ʼ����� �����´�.
	public int getBannerSeq(String bannerLocation);
}
