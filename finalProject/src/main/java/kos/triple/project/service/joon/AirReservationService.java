package kos.triple.project.service.joon;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface AirReservationService {

	//����������������
	public void getAirPortInfo(HttpServletRequest req, Model model);

	//�װ��� ��������(�װ����������� ���Խ�) 
	public void getAirPlane(HttpServletRequest req, Model model);
	
	//�װ��� ���
	public void addAirPlane(HttpServletRequest req);

	//�װ��� ����
	public void deleteAirPlane(HttpServletRequest req);

	//�װ��� ���� ��������
	public void getAirPlaneOne(HttpServletRequest req);

	//�װ��� ���� �����ϱ�
	public void modifyAirPlane(HttpServletRequest req);

	//�װ��� ��� ��������(�������� ���� ���Խ�)
	public void getAirPlaneAll(HttpServletRequest req, Model model);

	//�� ���׻����� �Ÿ��� ���Ѵ�.
	public void getMoveDistance(HttpServletRequest req);

	//����� ��θ� �����Ѵ�.
	public void setRoute(HttpServletRequest req);

	//��μ����� ����Ѵ�.
	public void setRouteCancel(HttpServletRequest req);

	//�⺻������ �����´�
	public void getSeatDefaultPrice(HttpServletRequest req, Model model);

	//�⺻�������� ����å���Ѵ�(������������)
	public void setSeatPrice(HttpServletRequest req);

	//�Էµ� �������� ����å���Ѵ�(������������)
	public void setCustomSeatPrice(HttpServletRequest req);

	//å���� ���������� �����´�.
	public void getSeatPriceInfo(HttpServletRequest req);

	//å���� ���������� �����Ѵ�.
	public void modifySeatPrice(HttpServletRequest req);

	//�װ����� ��ȸ�Ѵ�.
	public void airPlaneSearch(HttpServletRequest req, Model model);

	//�����ϱ����� �װ���,��Ʈ,���� ������ �����´� (���������������´�)
	public void getReserVationInfo(HttpServletRequest req, Model model);

	//�����ϷḦ ��������(����)
	public void airResProc(HttpServletRequest req, Model model);

	//���� �¼��� �����´�.
	public void getRemainSeat(HttpServletRequest req);

	//���������� �װ����� ����� �����´�.
	public void getMyPageReserAirPlane(HttpServletRequest req , Model model);

	//�װ� ���� ����� �����´�.
	public void getAirReserVationList(HttpServletRequest req, Model model);

	//�װ� ������ ����Ѵ�.
	public void airResCancelProc(HttpServletRequest req, Model model);

	//�⺻������ ������Ʈ�Ѵ�.
	public void setDefaultPriceUpdate(HttpServletRequest req , Map<String, Object> map);

	//�װ� ��Ʈ�����͸� �����´�. ��ü���
	public void getChatData_Air(HttpServletRequest req, Model model);

	//�װ� ��Ʈ�����͸� �����´�. �װ���
	public void getChatDataCustom_Air1(HttpServletRequest req, Model model);
	public void getChatDataCustom_Air2(HttpServletRequest req, Model model);
	public void getChatDataCustom_Air3(HttpServletRequest req, Model model);
	//�װ��� �˻�

	//������ �Ϸ�� ������ ����
	public void deadPlaneCollection(HttpServletRequest req, Model model);
	
	//�װ�����
	
}