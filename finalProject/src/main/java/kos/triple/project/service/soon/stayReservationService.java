package kos.triple.project.service.soon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface stayReservationService {

	// ������ �˻�
	public void stay_search(HttpServletRequest req, Model model);

	// ������ �� ����
	public void stay_view(HttpServletRequest req, Model model);

	// ������ ���� �˻�
	public void stay_room_search(HttpServletRequest req, Model model);

	// ������ ���� �󼼺���
	public void stay_room_view(HttpServletRequest req, Model model);

	// ������ ���� ����
	public void stay_room_reservation(HttpServletRequest req, Model model);
	
	// ������ ���� ���� ���
	public void stayResCancel(HttpServletRequest req, Model model);
	
	// ���� ������
	public void getMyPageReserStay(HttpServletRequest req, Model model);

	// ������
	// ������ �߰�
	public void stay_add(MultipartHttpServletRequest req, Model model);

	// ������ ���
	public void stay_list(HttpServletRequest req, Model model);

	// ������ ���� ����
	public void stay_list_view(HttpServletRequest req, Model model);

	// ������ ����
	public void modify(MultipartHttpServletRequest req, Model model);

	// ������ ����
	public void delete(HttpServletRequest req, Model model);

	// ������ ���� �߰�
	public void stay_room_add(MultipartHttpServletRequest req, Model model);

	// ������ ���� ���
	public void stay_room_list(HttpServletRequest req, Model model);

	// ������ ���� ���� ����
	public void stay_room_list_view(HttpServletRequest req, Model model);

	// ������ ���� ����
	public void stay_room_modify(MultipartHttpServletRequest req, Model model);

	// ������ ����
	public void stay_room_delete(HttpServletRequest req, Model model);
	
	// ���� ���� ��Ȳ
	public void stay_reservation_list(HttpServletRequest req, Model model);
	
	// ���� ���� ���
	public void stay_reservation_total(HttpServletRequest req, Model model);

	// ���� ���� ��� -> ����
	public void getCharData_Stay(HttpServletRequest req, Model model);
}
