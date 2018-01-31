package kos.triple.project.persistence.joon;

import java.util.List;
import java.util.Map;

import kos.triple.project.vo.AirPlaneVO;
import kos.triple.project.vo.AirPortVO;
import kos.triple.project.vo.AirReservationDetailVO;
import kos.triple.project.vo.AirReservationSearchVO;
import kos.triple.project.vo.MapVO;
import kos.triple.project.vo.RouteVO;
import kos.triple.project.vo.SeatPriceVO;

public interface AirReservationDAO {

	//����������������
	public List<AirPortVO> getAirPortInfo_proc();

	//�װ���������������
	public List<AirPlaneVO> getAirPlane_proc();

	//�װ��� ����ϱ�
	public int addAirPlane_proc(AirPlaneVO vo);

	//���� ������ �װ���ȣ ��������(�װ����Ͽ� �ʿ�)
	public int getLastAirPlaneNo_proc();

	//�װ��� �����ϱ�
	public int deleteAirPlane_proc(String airPlaneNo);

	//�װ��� ��� ��������
	public AirPlaneVO getAirPlaneOne_proc(String airPlaneNo);

	//�װ��� ���� �����ϱ�
	public int modifyAirPlane_proc(AirPlaneVO vo);

	//��ϵ��װ��� ��� ��������
	public List<AirPlaneVO> getAirPlaneAll_proc();

	//�ϳ��� ���� ������ �����´�.
	public AirPortVO getAirPortInfoOne_proc(String airPortName);
	
	//�Ѱ����� ��ġ������ �����´�.
	public AirPortVO getAirPortLocation_proc(String airPortNo);
	
	//�뼱�������Ѵ�.
	public int setRoute_proc(Map<String, Object> map);

	//�뼱����������Ѵ�.
	public void setRouteCancel_proc(String airPlaneNo);

	//�⺻������ �����´�
	public SeatPriceVO getSeatDefaultPrice_proc();
	
	//������ �����Ѵ�.
	public int setSeatPrice_proc(SeatPriceVO vo, String airPlaneNo);

	//�Էµ� �������� �����Ѵ�.
	public int setCustomSeatPrice_proc(SeatPriceVO vo, String airPlaneNo);

	//����� ��������� �����´�
	public SeatPriceVO getSeatPriceInfo_proc(String airPlaneNo);

	//�¼������� �����Ѵ�.
	public int modifySeatPrice_proc(SeatPriceVO vo);

	//�װ����� �˻��Ѵ�.
	public List<AirReservationSearchVO> airPlaneSearch(Map<String,Object> map);

	//�����ϱ��� ������ ��������� �����´�.
	public AirReservationSearchVO getReserVationInfo_proc(String airPlaneNo);

	//������ �Ѵ�.
	public int airResProc_proc(AirReservationDetailVO vo);

	//���� �¼����� ������Ʈ�Ѵ�.
	public int modifyAirPlane_remainSeat_proc(Map<String, Object> map);

	//���� �¼����� �����´�.
	public AirPlaneVO getRemainSeat_proc(String airPlaneNo);

	//�װ��� �뼱��ȣ�� �����´�.
	public String getRouteNo_proc(String airPlaneNo);

	//�뼱�� ������ �����´�.
	public RouteVO getRouteInfo_proc(String routeNo);

	//�װ��������� �����´�.
	public List<AirReservationDetailVO> getMyPageReserAirPlane_proc(Map<String , Object> map);

	//select ����� �Ѱ����� ���ؿ´�.
	public int getListCount(Map<String,Object> map);

	//������������ -> �װ� �������� �����´�.
	public List<AirReservationDetailVO> getAirReserVationList_proc(Map<String, Object> map);

	//�װ����� ��Ҹ� �Ѵ�.
	public int airResCancelProc_proc(Map<String, Object> map);

	//�⺻������ ������Ʈ�Ѵ�.
	public int setDefaultPriceUpdate_proc(Map<String, Object> map);

	//�װ� ���1
	public Map<String, Object> getChatData_Air(Map<String,Object> parameter);

	//�װ� ���Ŀ����
	public List<MapVO> getChatDataCustom_Air1(Map<String, Object> parameter);
	public List<MapVO> getChatDataCustom_Air2(Map<String, Object> parameter);
	public List<MapVO> getChatDataCustom_Air3(Map<String, Object> parameter);
	//�װ������Ѿ��������´�.
	public int getAirTotalPrice_proc();
	
	//����Ϸ�� ����� ����
	public int deadPlaneCollection_proc();

	
	

	
}