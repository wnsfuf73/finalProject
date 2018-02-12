package kos.triple.project.mobile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MobileService {

	//�α������Ȯ��
	void loginConfirm(HttpServletRequest req);

	//�α��ο���Ȯ��
	void startRedirect(HttpServletRequest req);

	//�ش���� ���̵� ����ȭ
	void phoneSync(HttpServletRequest req);

	//�α��λ����ΰ�� ���ξ�Ƽ��Ƽ�� �Ѿ�� ���̵��� �����´�.
	void getSavedId(HttpServletRequest req);

	//�α׾ƿ��� ó���Ѵ�.
	void mobileLogout(HttpServletRequest req);

	//���ǿ� �´� �װ����� �����´�.
	void airPlaneSearch(HttpServletRequest req);

	//STEP1 ������ �����´�.
	void getReserVationInfo(HttpServletRequest req);

	//�װ� ������ �Ѵ�
	void mobileReservationProc(HttpServletRequest req);

	//����� ���������� ���۵����͸� �����´�.
	void mobileGetMyPageStartInfo(HttpServletRequest req);

	//�������������� �װ������ϰ����´�(�ּ�����)
	void mobileGetMyAirReservationList(HttpServletRequest req);

	//����Ͽ��� �װ������� ����Ѵ�.
	void mobileCancelReservationAir(HttpServletRequest req);

	//�̾߱⸦ �����´�.
	void getMobileStory(HttpServletRequest req);

	
	/* ���� */
	//���� �������� �����´�.
	void getMyStayReservationList(HttpServletRequest req);


	/* ���� */
	
}
