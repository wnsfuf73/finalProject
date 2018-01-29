package kos.triple.project.service.hee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BannerService {
	
	// 배너글 목록
	public void bannerList(HttpServletRequest req, Model model);
	
	// 배너글 수정 상세 페이지
	public void updateBannerView(HttpServletRequest req, Model model);
	
	// 배너글 수정 처리 페이지
	public void updateBannerPro(MultipartHttpServletRequest req, Model model);
	
	// 배너글 작성 처리 페이지
	public void registerBannerPro(MultipartHttpServletRequest req, Model model);
	
	// 배너글 삭제 처리 페이지
	public void deleteBannerPro(HttpServletRequest req, Model model);
}
