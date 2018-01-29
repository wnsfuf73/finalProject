package kos.triple.project.service.hee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BannerService {
	
	// ��ʱ� ���
	public void bannerList(HttpServletRequest req, Model model);
	
	// ��ʱ� ���� �� ������
	public void updateBannerView(HttpServletRequest req, Model model);
	
	// ��ʱ� ���� ó�� ������
	public void updateBannerPro(MultipartHttpServletRequest req, Model model);
	
	// ��ʱ� �ۼ� ó�� ������
	public void registerBannerPro(MultipartHttpServletRequest req, Model model);
	
	// ��ʱ� ���� ó�� ������
	public void deleteBannerPro(HttpServletRequest req, Model model);
}
