package kos.triple.project.persistence.hong;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kos.triple.project.vo.CarInfoVO;
import kos.triple.project.vo.RentCarVO;
import kos.triple.project.vo.Reservation_CarVO;
import kos.triple.project.vo.rentTotalVO;

public interface CarDAO {
	
	//��Ʈī�߰�
	public int rentAdd(RentCarVO vo);
	
	//��Ʈī ���� ���ϱ�
	public int getArticleCnt();
	
	//��Ʈī ���� ���ϱ�(��������)
	public int getArticleCntKind(String car_kind);
	
	//��Ʈī ��ȸ
	public ArrayList<CarInfoVO> rentCar(Map<String,Object> map);
	
	//��Ʈī ��ü ��ȸ
	public ArrayList<CarInfoVO> rentCarAll(Map<String,Integer> map);
	
	//��������	
	public int rentDelete(String car_num);
	
	//������������������
	public CarInfoVO getViewDetail(String car_num);
	
	//��Ʈī ����
	public int reservation_car(Reservation_CarVO vo);
	
	//��Ʈ���� �Ϸ� - �������� ����
	public int carMaineoseu(Reservation_CarVO vo);
	
	//���� ����Ʈ ���� ���ϱ�
	public int rentReservationCnt(Map<String,Object> map);
	
	//���ฮ��Ʈ ��ȸ�ϱ�
	public ArrayList<Reservation_CarVO> rentReservationList(Map<String, Object> map);

	//���ฮ��Ʈ ��ȸ�ϱ� - �Խ�Ʈ
	public ArrayList<Reservation_CarVO> rentReservationList_myPage(Map<String, Object> map);
	
	//��Ʈī ���� ���
	public int carResCancel(String rent_no);
	
	//��Ʈī ���� ��ҷ� ���� ���� ���� ����
	public int carResCancel_rentCountAdd(String rent_no);
	
	//���� ��¥ ��ȸ(������ ������ �Ȱ��� ��¥�� ������ �Ұ����ϰ�, �ٸ� ��¥ ��ȸ������ ���� �����ϰ�)
	public List<Reservation_CarVO> date();
	
	//��Ʈī �ݳ�
	public int carResReturn(String rent_no);
	
	//��Ʈī �ݳ� - ���KM����
	public int carUseKmUp(String rent_no);
	
	//������ ���
	public Map<String,Object> rentPriceTotal();
	
	//������ �Ǽ� 
	public Map<String,Object> rentKindCount();
	
	//��¥�� �Ǽ�
	public Map<String,Object> rentDateTotal(String year);

	//ù��°īƮ -> ����
	public int getFirstChat_car();
	
	//�ι�°īƮ -> ����
	public int getSecondChat_car();

	//����°īƮ -> ����
	public Map<String, Object> getFinalChat_car(String year);
}
