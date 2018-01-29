package kos.triple.project.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.persistence.chul.EpilogueDAO;
import kos.triple.project.vo.BannerVO;
import kos.triple.project.vo.EpilogueVO;
import kos.triple.project.vo.NoticeVO;
import kos.triple.project.vo.PlanVO;

@Repository
public class MainDAOImpl implements MainDAO{

	@Autowired
	SqlSession sqlSession;
	
	//öȯ���� daoimpl��
	@Override
	public List<EpilogueVO> myNewStory_proc(String mem_id) {
		
		MainDAO dao = sqlSession.getMapper(MainDAO.class);
		return dao.myNewStory_proc(mem_id);
	}
	
	//ȣ���� daoimpl��
	@Override
	public List<PlanVO> myNewPlan_proc(String mem_id) {
		MainDAO dao = sqlSession.getMapper(MainDAO.class);
		return dao.myNewPlan_proc(mem_id);
	}
	
	@Override
	public String getMyFaceImg_proc(String mem_id) {
		
		MainDAO dao = sqlSession.getMapper(MainDAO.class);
		String imgPath = dao.getMyFaceImg_proc(mem_id); 
		return imgPath;
	
	}

	@Override
	public BannerVO getBanner_proc(Map<String,Object> map) {
		MainDAO dao = sqlSession.getMapper(MainDAO.class);
		BannerVO vo = dao.getBanner_proc(map); 
		return vo;
	}

	@Override
	public int getBannerCount_proc(String bannerLocation) {
		int cnt = 0;
		MainDAO dao = sqlSession.getMapper(MainDAO.class);
		cnt = dao.getBannerCount_proc(bannerLocation); 
		return cnt;
	}

	@Override
	public NoticeVO getNewNotice_proc() {
		MainDAO dao = sqlSession.getMapper(MainDAO.class);
		return dao.getNewNotice_proc();
	}


}
