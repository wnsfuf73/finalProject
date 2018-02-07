package kos.triple.project.mobile;

import java.util.List;
import java.util.Map;

import kos.triple.project.mobile.vo.AirReservationSearchVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.RouteVO;

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

	//
	int setRemainSeatUpdate(Map<String,Object> map);
	
	


}
