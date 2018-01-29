package kos.triple.project.persistence.soon;

import java.util.ArrayList;
import java.util.Map;

import kos.triple.project.vo.WhereVO;

public interface WhereDAO {
	// �α� ���
	public ArrayList<WhereVO> where_spot(Map<String, Object> map);
	
	// ��� �� ����
	public WhereVO detail_view(String location_num);
	
	// ���ƿ�
	public int like_score(String location_num);
	
	// �����̿���
	public int normal_score(String location_num);
	
	// �Ⱦ��
	public int bad_score(String location_num);
	
	// �˻�
	public ArrayList<WhereVO> search(String search);

	///////////////////////////////// ������/////////////////////////////////
	// ��� ���
	public ArrayList<WhereVO> where_list(Map<String, Integer> map); 
	
	// ��� ����
	public int getCountCnt();
	
	// ��� �߰�
	public int where_add(WhereVO dto);

	// ��� Ȯ��
	public WhereVO where_check(String location_num);

	// ��� ����
	public int delete(String location_num);
	
	// ��� ����
	public WhereVO modify(String location_num);
	
	// ��� ���� - 2
	public int modify_pro(WhereVO dto);

	//��� ���� - �̹�����
	public int updateImg(Map<String, Object> imgMap);
	
}
