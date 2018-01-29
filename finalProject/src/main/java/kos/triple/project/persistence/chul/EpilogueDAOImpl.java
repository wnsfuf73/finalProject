package kos.triple.project.persistence.chul;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.EpilogueDetailVO;
import kos.triple.project.vo.EpilogueFrontVO;
import kos.triple.project.vo.EpilogueVO;
import kos.triple.project.vo.Epilogue_LikeVO;
import kos.triple.project.vo.Epilogue_commentVO;
import kos.triple.project.vo.Epilogue_courseVO;
import kos.triple.project.vo.WhereVO;

@Repository
public class EpilogueDAOImpl implements EpilogueDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	//  return type of location method will be changed to List<Trip_location_info>.
	@Override
	public List<WhereVO> location(Map<String, Object> map) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.location(map);
	}

	/*@Override
	public int getNumOfEpil() {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class); 
		
		return eDao.getNumOfEpil();
	}*/

	@Override
	public int initialInsertPro(Map<String, Object> map) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);

		return eDao.initialInsertPro(map);
	}

	@Override
	public int insertEpilCoursePro(Map<String, Object> map) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.insertEpilCoursePro(map);
	}

	@Override
	public int getNumOfEpilCourse(Map<String, Object> map1) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getNumOfEpilCourse(map1);
	}

	@Override
	public List<Epilogue_courseVO> getListOfEpilCourse(Map<String, Object> map2) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getListOfEpilCourse(map2);
	}

	@Override
	public int getNumOfVisitOrder(Map<String, Object> map) {
		
		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getNumOfVisitOrder(map);
	}

	@Override
	public int writeEpilogueProDao(Map<String, Object> map) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.writeEpilogueProDao(map);
	}

	@Override
	public List<EpilogueVO> previewEpilViewDao(Map<String, Object> map) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.previewEpilViewDao(map);
	}

	@Override
	public int getNumOfEpil(Map<String, Object> kindMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getNumOfEpil(kindMap);
	}

	@Override
	public List<EpilogueVO> printEpilogueListPro(Map<String, Object> numMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.printEpilogueListPro(numMap);
	}

	@Override
	public List<EpilogueVO> getDetailEpilInfo(Map<String, Object> map) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getDetailEpilInfo(map);
	}

	@Override
	public EpilogueVO detailEpilViewDao(Map<String, Object> epilMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.detailEpilViewDao(epilMap);
	}

	@Override
	public int writeEpiloguePro(Map<String, Object> map) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.writeEpiloguePro(map);
	}

	@Override
	public int insertEpilogueCourse(Map<String, Object> map) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.insertEpilogueCourse(map);
	}

	@Override
	public int getLocationNum(Map<String, Object> map) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getLocationNum(map);
	}

	@Override
	public Epilogue_courseVO getOneEpilCourseDao(Map<String, Object> epilMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getOneEpilCourseDao(epilMap);
	}

	@Override
	public int epilNumGenerator() {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.epilNumGenerator();
	}

	@Override
	public int updateCourseInfoPro(Map<String, Object> epil) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.updateCourseInfoPro(epil);
	}

	@Override
	public int getNumOfLike(Map<String, Object> numberMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getNumOfLike(numberMap);
	}

	@Override
	public int getNumOfCmt(Map<String, Object> numberMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getNumOfCmt(numberMap);
	}

	@Override
	public int getNumOfEpilCourseSearch(Map<String, Object> searchMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getNumOfEpilCourseSearch(searchMap);
	}

	@Override
	public List<EpilogueVO> printEpilogueListSearch(Map<String, Object> searchMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.printEpilogueListSearch(searchMap);
	}

	@Override
	public int updateReadCount(Map<String, Object> epilMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.updateReadCount(epilMap);
	}

	@Override
	public int getNumOfEpilCour(Map<String, Object> epilMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.getNumOfEpilCour(epilMap);
	}

	@Override
	public List<EpilogueVO> printEpilogueListProTest(Map<String, Object> numMap) {

		EpilogueDAO eDao = sqlSession.getMapper(EpilogueDAO.class);
		
		return eDao.printEpilogueListProTest(numMap);
		
	}
	
	@Override
	public List<EpilogueDetailVO> getEpilogDetail(String num) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		String epilogNum = num;
		List<EpilogueDetailVO> list =  dao.getEpilogDetail(epilogNum);
		
		return list;
	}

	@Override
	public EpilogueVO getEpilog(int num) {
		
		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		int epilogNum = num;
		EpilogueVO vo =  dao.getEpilog(epilogNum);
		
		return vo;
		
	}

	@Override
	public int epilogueTotalCount(Map<String, Object> map) {
		int totalCount = 0;
		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		totalCount = dao.epilogueTotalCount(map);
		return totalCount;
	}

	@Override
	public List<EpilogueFrontVO> getAllEpilogueList_proc(Map<String, Object> map) {
		
		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		List<EpilogueFrontVO> voList =  dao.getAllEpilogueList_proc(map);
		
		return voList;
	}

	@Override
	public int getCommentCount(int num) {
		int count = 0;
		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		count = dao.getCommentCount(num);
		return count;
	}

	@Override
	public List<String> getCourses(int num) {
		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		List<String> visitList = dao.getCourses(num);
		return visitList;
	}

	@Override
	public List<Epilogue_LikeVO> getDetailLike_proc(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Epilogue_commentVO> getDetailComment(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRepresentImg(int num) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.getRepresentImg(num);
	}

	@Override
	public int getLikeCount(int num) {
		
		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.getLikeCount(num);
	}

	@Override
	public List<Epilogue_commentVO> getCommentList_proc(Epilogue_commentVO commentVO) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.getCommentList_proc(commentVO);
	}

	@Override
	public int insertComment_proc(Epilogue_commentVO commentVO) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.insertComment_proc(commentVO);
	}

	@Override
	public int updateComment_proc(Epilogue_commentVO commentVO) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.updateComment_proc(commentVO);
	}

	@Override
	public int deleteComment_proc(Epilogue_commentVO commentVO) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.deleteComment_proc(commentVO);
	}

	@Override
	public List<Epilogue_LikeVO> likeListFunction_proc(String epilogueNo) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.likeListFunction_proc(epilogueNo);
	}

	@Override
	public int isExistLike(Map<String, Object> likeMap) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.isExistLike(likeMap);
	}

	@Override
	public int deleteEpilogueLike_proc(Map<String, Object> likeMap) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.deleteEpilogueLike_proc(likeMap);
	}

	@Override
	public int insertEpilogueLike_proc(Map<String, Object> likeMap) {

		EpilogueDAO dao = sqlSession.getMapper(EpilogueDAO.class);
		
		return dao.insertEpilogueLike_proc(likeMap);
	}
	
}
