package kos.triple.project.service.hong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface CarService {
	
	//��Ʈī �߰�
	public void rentAdd(MultipartHttpServletRequest req, Model model);
	
	//��Ʈī ��ȸ
	public void rentCar(HttpServletRequest req, Model model);
	
	//��Ʈī ����
	public void rentDelete(HttpServletRequest req, Model model);
	
	//��Ʈī �� ��ȸ
	public void getViewDetail(HttpServletRequest req, Model model);
	
	//��Ʈī �����ϱ�
	public void rentReservation(HttpServletRequest req, Model model);
	
	//ȣƮ�� ���� ��ȸ
	public void rentReservationList(HttpServletRequest req, Model model);

	//�Խ�Ʈ ��Ʈ ���� ��ȸ ����Ʈ�� �����´�
	public void rentReservationList_myPage(HttpServletRequest req, Model model);
	
	//��Ʈī ���� ���
	public void carResCancel(HttpServletRequest req, Model model);
	
	//��Ʈī �ݳ�
	public void carResReturn(HttpServletRequest req, Model model);
	
	//��� ��ü���տ�
	public void getCharData_Car(HttpServletRequest req, Model model);
	
	//��� Ŀ���ҿ�
	public void rentTotal(HttpServletRequest req, Model model);
	
	

}
