package kos.triple.project.persistence.soon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kos.triple.project.vo.Reservation_StayVO;
import kos.triple.project.vo.StayRoomVO;
import kos.triple.project.vo.StayVO;
import kos.triple.project.vo.StayVO;
import kos.triple.project.vo.WhereVO;

public interface stayReservationDAO {
	// ������ �˻�
	public ArrayList<StayVO> stay_search(Map<String, Object> map);
	
	// ������ �� ����
	public StayVO stay_view(String stay_no);
	
	// ������ ���� ����
	public StayRoomVO stay_room_view(String room_no);
	
	// ������ ���� ��¥ �˻�
	public List<Reservation_StayVO> date();
	
	// ������ ���� ���� ó��
	public int stay_room_reservation(Map<String, Object> map);
	
	// ������ ���� ���� ���
	public void stayResCancel(String reservation_no);
	
	// ���� ������
	
	// ���� ����
	public int rentReservationCnt();
	
	// ���� ���
	public ArrayList<Reservation_StayVO> reservation_staylist(Map<String, Object> map);
	
	//������

	// ������ �߰�
	public int stay_add(StayVO vo);

	// ������ ����
	public int getCountCnt();

	// ������ ���
	public ArrayList<StayVO> stay_list(Map<String, Integer> map);

	// ������ ���� ����
	public StayVO stay_list_view(String stay_no);

	// ������ ����
	public int modify(StayVO vo);

	// ������ ����(�̹���)
	public int updateImg(Map<String, Object> imgMap);

	// ������ ����
	public int delete(String stay_no);

	// ������ ���� �߰�
	public int stay_room_add(StayVO vo);

	// ������ ���� ���
	public ArrayList<StayVO> stay_room_list(String stay_no);

	// ������ ���� ���� ����
	public StayVO stay_room_list_view(String room_no);

	// ������ ���� ����
	public int stay_room_modify(StayVO vo);

	// ������ ���� ����(�̹���)
	public int room_updateImg(Map<String, Object> imgMap);
	
	// ������ ���� ����
	public int stay_room_delete(String room_no);
	
	// ���� ���� ��Ȳ
	public ArrayList<Reservation_StayVO> stay_reservation_list(Map<String, Object> map);
	
	// ���� ���� ���(����)
	public int getTotalSale();
	
	// ���� ���� ���(���� �׷���)
	public Map<String, Object> getFirstChart();
	
	// ���� ���� ���(�� �׷���)
	public Map<String, Object> getSecondChart();
	
	// ���� ���� ���(��¥�� �Ǹŷ�)
	public Map<String, Object> getFinalChart(String year);

	//ù��° ��Ʈ -> ���չ���
	public int getFirstChartAll();

	//�ι�° ��Ʈ -> ���չ���
	public int getSecondChartAll();

	//����° ��Ʈ -> ���չ���
	public Map<String, Object> getFinalChartAll(String year);
	
	
}
