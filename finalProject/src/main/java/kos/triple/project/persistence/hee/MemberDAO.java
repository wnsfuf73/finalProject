package kos.triple.project.persistence.hee;

import java.util.Map;

import kos.triple.project.vo.MemberVO;

public interface MemberDAO {
	
	// �α��� ó��
	public int loginPro(Map<String, Object> map);
	
	// ȸ�� ���� ��������
	public MemberVO getMemberInfo(String mem_id);
	
	// ȸ�� ���� ó��
	public int inputMemberPro(MemberVO vo);
		
	// ���̵� �ߺ� Ȯ�� üũ
	public int idCheck(String mem_id);
	
	// ���̵�  ã��
	public MemberVO getId(Map<String, Object> map); /*String name, String email1, String email2*/
	
	// ��й�ȣ ã��
	public int getPwd(Map<String, Object> map);
	
	// ȸ�� ���� ����
	public int updateMember(MemberVO vo);
	
	// ȸ�� Ż�� ó��
	public int deleteMember(String mem_id);
	
	// ��й�ȣ ã�� - �̸��� ������
	public void sendMail(String email, String key);

	// ����Ű ����
	public int setMemberKey(Map<String, Object> map);
	
	// ����Ű Ȯ�� ó��
	public String inputKeyPro(String mem_id);

	// ������ȣ Ȯ�� �� ��й�ȣ ����
	public int setUserPassword_proc(MemberVO vo);

	//ȸ���� ������ �̹����� ����
	public int faceImgUpload_proc(MemberVO vo);
	
	
}
