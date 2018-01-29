package kos.triple.project.service.hee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface MemberService {

	// ȸ�� ���� ó��
	public void inputMemberPro(HttpServletRequest req, Model model);
	
	// ���̵� �ߺ� Ȯ��
	public void confirmId(HttpServletRequest req, Model model);
	
	// �α��� ó��
	public void loginPro(HttpServletRequest req, Model model);
	
	// ȸ�� �� ���� ��������
	public void getMemberInfo(HttpServletRequest req, Model model);
	
	// ���̵� ã��
	public void getId(HttpServletRequest req, Model model);
	
	// ��й�ȣ ã��
	public void getPwd(HttpServletRequest req, Model model);
	
	// ����Ű �Է� Ȯ��
	public void inputkeyPro(HttpServletRequest req, Model model);

	//ȸ���� ��й�ȣ�� ����
	public void setUserPassword(HttpServletRequest req, Model model);
	
	// �̸��� üũ
	public void findPwdEmailChk(HttpServletRequest req, Model model);
	
	// ȸ�� ���� ���� �� ������
	public void modifyView(HttpServletRequest req, Model model);
	
	// ȸ�� ���� ���� ó��
	public void modifyPro(MultipartHttpServletRequest req, Model model);
	
	// ȸ�� Ż�� ó��
	public void deletePro(HttpServletRequest req, Model model);

	//�������̹����� ���ε�
	public void faceImgUpload(MultipartHttpServletRequest req, Model model);



	




}
