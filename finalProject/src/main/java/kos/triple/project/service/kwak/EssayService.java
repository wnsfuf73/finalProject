package kos.triple.project.service.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EssayService {
	//������ ����
	public void inserEssay(MultipartHttpServletRequest req, Model model);
	
	//������Ұ˻����
	public void reviewSearch(HttpServletRequest req, Model model);
	
	//���� ���� ó��
	public void reviewPro(MultipartHttpServletRequest req, Model model);
	
}
