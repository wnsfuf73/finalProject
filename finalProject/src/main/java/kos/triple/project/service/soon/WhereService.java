package kos.triple.project.service.soon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface WhereService {
	// �α� ���
	public void Where_main(HttpServletRequest req, Model model);

	// ��� �� ����
	public void detail_view(HttpServletRequest req, Model model);

	// ��� �� ����
	public void detail_view_score(HttpServletRequest req, Model model);

	// �˻�
	public void search(HttpServletRequest req, Model model);

	///////////////////////////////// ������/////////////////////////////////
	// ��� ���
	public void Where_list(HttpServletRequest req, Model model);

	// ��� �߰�
	public void Where_add(MultipartHttpServletRequest req, Model model);

	// ��� Ȯ��
	public void Where_check(HttpServletRequest req, Model model);

	// ��� ����
	public void Where_delete(HttpServletRequest req, Model model);
	
	// ��� ���� -1
	public void Where_modify(HttpServletRequest req, Model model);
	
	// ��� ���� -2
	public void Where_modify_Pro(MultipartHttpServletRequest req, Model model);

}
