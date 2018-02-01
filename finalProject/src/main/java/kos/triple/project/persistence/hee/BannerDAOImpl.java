package kos.triple.project.persistence.hee;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.BannerVO;

@Repository
public class BannerDAOImpl implements BannerDAO{

	
	@Autowired
	public SqlSession sqlSession;
	
	// 배너 글 개수
	@Override
	public int getBannerCnt() {

		int cnt = 0;
		
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);
		cnt = dao.getBannerCnt();
		return cnt;
	}

	// 배너 글 목록 조회
	@Override
	public ArrayList<BannerVO> getBannerList(Map<String, Object> map) {
		
		ArrayList<BannerVO>	vos = null;	
		
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);	
		vos = dao.getBannerList(map);	
		
		return vos;
	}

	// 배너 글 상세 페이지
	@Override
	public BannerVO getDetailBannerContent(int bannerNo) {

		BannerVO vo = null;
		
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);
		vo = dao.getDetailBannerContent(bannerNo);
	
		return vo;
	}

	// 배너 글 등록
	@Override
	
	public int registerBanner(BannerVO vo) {

		int cnt = 0;
		
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);
		cnt = dao.registerBanner(vo);
		
		return cnt;
	}

	// 배너 삭제
	@Override
	public int deleteBanner(int bannerNo) {

		int cnt = 0;
		
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);
		cnt = dao.deleteBanner(bannerNo);
		
		return cnt;
	}

	// 배너 수정
	@Override
	public int updateBanner(BannerVO vo) {

		int cnt = 0;
		
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);
		cnt = dao.updateBanner(vo);
		
		return cnt;
	}
	
	// 배너 이미지 수정
	public int updateBannerImg(Map<String, Object> map) {
		
		int cnt = 0;
		
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);
		cnt = dao.updateBannerImg(map);
		
		return cnt;	
	
	}

	@Override
	public int getBannerSeq(String bannerLocation) {
		int cnt = 0 ;
		
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);
		cnt = dao.getBannerSeq(bannerLocation);
		return cnt;
	}

	@Override
	public int[] getBannerNumberList(int bannerNo) {
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);
		int[] cnt = dao.getBannerNumberList(bannerNo);
		return cnt;	
		
	}

	//배너순서를 업데이트한다.
	@Override
	public int updateBannerSequence(BannerVO vo) {
		int cnt = 0 ;
		BannerDAO dao = sqlSession.getMapper(BannerDAO.class);
		cnt = dao.updateBannerSequence(vo);
		return cnt;
		
	}

}
