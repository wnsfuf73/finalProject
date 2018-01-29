package kos.triple.project.persistence.hee;

import java.util.ArrayList;
import java.util.Map;

import kos.triple.project.vo.BannerVO;

public interface BannerDAO {
	
	// 배너 글 개수
	public int getBannerCnt();
	
	// 배너 글 목록 조회
	public ArrayList<BannerVO> getBannerList(Map<String, Object>map);
	
	// 배너 글 상세 페이지
	public BannerVO getDetailBannerContent(int bannerNo);

	// 배너 글 등록
	public int registerBanner(BannerVO vo);
	
	// 배너 글 삭제
	public int deleteBanner(int bannerNo);
	
	// 배너 글 수정
	public int updateBanner(BannerVO vo);
	
	// 배너 이미지 수정
	public int updateBannerImg(Map<String, Object> map);

	//특정배너위치의 배너순서를 가져온다.
	public int getBannerSeq(String bannerLocation);
}
