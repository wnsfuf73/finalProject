package kos.triple.project.persistence.chul;

import java.util.List;
import java.util.Map;

import kos.triple.project.vo.EpilogueDetailVO;
import kos.triple.project.vo.EpilogueFrontVO;
import kos.triple.project.vo.EpilogueVO;
import kos.triple.project.vo.Epilogue_LikeVO;
import kos.triple.project.vo.Epilogue_commentVO;
import kos.triple.project.vo.Epilogue_courseVO;
import kos.triple.project.vo.WhereVO;

public interface EpilogueDAO {
	
	// ������ �˻� ��޿��� ������ �˻��Ҷ� ���� �޼ҵ�.
	// location_name �� �������� ã�´�.
	public List<WhereVO> location(Map<String, Object> map);
	
	// ���� epliogue (�̾߱�) �� �ۼ��� ���� ������ ���ϴ� �۾�.
	/*public int getNumOfEpil();*/
	
	// �̾߱� �ۼ��� �����ڸ��� epilogue ���̺� ��(epilogueNo+1)�� ���� �α��� �� ������ id�� ����.
	// ������ ������� ������ epilogue_course �ۼ��� ������ �ۼ��Ϸ�����������
	// epilogue ���̺��� update�ϴ� ������� �ϼ��ؾ���.
	public int initialInsertPro(Map<String, Object> map);
	
	// epilogue_course ���̺� insert�ϴ� �۾�.
	public int insertEpilCoursePro(Map<String, Object> map);
	
	// ���� �ı� (epilogueNo)�� ���� epilogue_course(�ڽ���)�� ������ �������� �޼ҵ�
	// �ֳ��ϸ� rnum�� �ִ������ �����ֱ� ���ؼ�
	public int getNumOfEpilCourse(Map<String, Object> map1);
	
	// ���� �ı⿡ ����  epilogue_course�� ����� �������� �޼ҵ�
	public List<Epilogue_courseVO> getListOfEpilCourse(Map<String, Object> map2);
	
	// ���� �̾߱⿡ �� ���� �ڽ��� �ִ��� �������� �޼ҵ�. �ڽ������ �湮������ �����ֱ� ���ؼ�
	public int getNumOfVisitOrder(Map<String, Object> map);
	
	// �ۼ��� ����⸦ epilogue �� update �ϴ� �۾�.
	public int writeEpilogueProDao(Map<String, Object> map);
	
	public List<EpilogueVO> previewEpilViewDao(Map<String, Object> map);

	public int getNumOfEpil(Map<String, Object> kindMap);
	
	public List<EpilogueVO> printEpilogueListPro(Map<String, Object> numMap);

	public List<EpilogueVO> getDetailEpilInfo(Map<String, Object> map);

	public EpilogueVO detailEpilViewDao(Map<String, Object> epilMap);

	public int writeEpiloguePro(Map<String, Object> map);
	
	public int insertEpilogueCourse(Map<String, Object> map);
	
	public int getLocationNum(Map<String, Object> map);
	
	public Epilogue_courseVO getOneEpilCourseDao(Map<String, Object> epilMap);
	
	public int epilNumGenerator();
	
	public int updateCourseInfoPro(Map<String, Object> epil);
	
	public int getNumOfLike(Map<String, Object> numberMap);
	
	public int getNumOfCmt(Map<String, Object> numberMap);
	
	public int getNumOfEpilCourseSearch(Map<String, Object> searchMap);
	
	public List<EpilogueVO> printEpilogueListSearch(Map<String, Object> searchMap);
	
	public int updateReadCount(Map<String, Object> epilMap);
	
	public int getNumOfEpilCour(Map<String, Object> epilMap);
	
	public List<EpilogueVO> printEpilogueListProTest(Map<String, Object> numMap);

	public List<EpilogueDetailVO> getEpilogDetail(String num);
	
	public EpilogueVO getEpilog(int num);

	/* ���θ��� �޼ҵ�  */
	
	//��ü���� ������ �����´�.
	public int epilogueTotalCount(Map<String, Object> map);

	//�۸���� �����´�.
	public List<EpilogueFrontVO> getAllEpilogueList_proc(Map<String, Object> map);
	
	//�ۿ����� ��ۼ��� �����´�.
	public int getCommentCount(int num);

	//�ۿ����� �ڽ��� ������� �����´�.
	public List<String> getCourses(int num);
	// �󼼺��� - ���ƿ� �󼼺���
	public List<Epilogue_LikeVO> getDetailLike_proc(int num);
	// �󼼺��� - ��� �󼼺���
	public List<Epilogue_commentVO> getDetailComment(int num);

	public String getRepresentImg(int num);

	public int getLikeCount(int num);

	public List<Epilogue_commentVO> getCommentList_proc(Epilogue_commentVO commentVO);

	public int insertComment_proc(Epilogue_commentVO commentVO);

	public int updateComment_proc(Epilogue_commentVO commentVO);

	public int deleteComment_proc(Epilogue_commentVO commentVO);

	public int isExistLike(Map<String, Object> likeMap);

	public int deleteEpilogueLike_proc(Map<String, Object> likeMap);

	public List<Epilogue_LikeVO> likeListFunction_proc(String epilogueNo);

	public int insertEpilogueLike_proc(Map<String, Object> likeMap);
}


