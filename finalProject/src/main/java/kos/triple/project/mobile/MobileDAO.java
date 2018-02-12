package kos.triple.project.mobile;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kos.triple.project.mobile.vo.AirReservationSearchVO;
import kos.triple.project.mobile.vo.EpilogueMobileCourseVO;
import kos.triple.project.mobile.vo.EpilogueMobileVO;
import kos.triple.project.mobile.vo.MyResAirSummaryVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.CarInfoVO;
import kos.triple.project.vo.RouteVO;
import kos.triple.project.vo.WhereVO;

public interface MobileDAO {

	//�α��ΰ��ɿ���Ȯ��
	int loginConfirm_proc(Map<String, Object> map);

	//�ش����� �α��ο���Ȯ��
	int startRedirect_proc(String phone);

	//����ϱ��� �α�����������ȭ
	int phoneSync_proc(Map<String, Object> map);

	//����Ͽ� �̹� �α��ε��ִ°�� ����Ⱦ��̵� �����´�.
	String getSavedId_proc(String phonenumber);

	//����Ͽ� �α׾ƿ��� ó���Ѵ�.
	int mobileLogout_proc(Map<String,Object> map );

	//�����̸��� ���׹�ȣ�� �����´�.
	String getAirportNo_proc(String location);
	
	//���׹�ȣ�� �����̸����� �����´�.
	String getAirportName_proc(String routeNo);

	//���ǿ��´� �װ����� �����´�.
	List<AirReservationSearchVO> airPlaneSearch_proc(Map<String, Object> map);

	//STEP1�� �ʿ��� ���� �����´�.
	AirReservationSearchVO getReserVationInfo_proc(String airPlaneNo);

	//�뼱������ �����´�.
	RouteVO getRouteInfo(String airPlaneNo);

	//������ Ȯ���Ѵ�.
	int reservationComplete_proc(AirReservationDetailVO vo);

	//�¼��������� ������Ʈ�Ѵ�.
	int setRemainSeatUpdate(Map<String,Object> map);

	//���������� ���۵�����(������Ǽ� , �������̹���)�� �����´�
	List<String> mobileGetMyPageStartInfo_proc(String mem_id);

	//�������������� �װ������ϰ����´�(�ּ�����)
	List<MyResAirSummaryVO> mobileGetMyAirReservationList_proc(String mem_id);

	//�װ����ȣ�� �̸��� �����´�.
	String getAirPlaneName(String airPlaneNo);

	//����Ͽ��� �װ������� ����Ѵ�.
	int mobileCancelReservationAir(Map<String, Object> map);

	/* �̾߱� */
	
	//��ü�̾߱⸦ �����´�.
	List<EpilogueMobileVO> getMobileStory_proc();
	
	//�̾߱��� ��ǥ�̹����� �����´�.
	String getEpilogueFrontImage(int epilogueNo);
	
	//�̾߱� �Ѱ��� �����´�.
	EpilogueMobileVO getMobileStoryDetail_proc(int epilogueNo);
	
	//�̾߱⿡ ��ϵ� �ڽ����� �����´�.
	List<EpilogueMobileCourseVO> getMobileStoryDetailCourse_proc(int epilogueNo);
	
	/* �̾߱� */
	
	/* ������ ���� */
	
	//������ ������ �����´�.
	List<WhereVO> getMobileWhereAll_proc();
	
	//������ ������ �����´�. ������
	List<WhereVO> getMobileWhereArea_proc(String area);

	/* ������ ���� */
	
	/* ��Ʈ�������� �����´�. */
	List<CarInfoVO> mobileRentList_proc(Map<String, Object> map);






	


}
