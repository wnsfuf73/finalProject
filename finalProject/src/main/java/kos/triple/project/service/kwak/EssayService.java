package kos.triple.project.service.kwak;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface EssayService {
	//에세이 저장
	public void inserEssay(MultipartHttpServletRequest req, Model model);
	
	//리뷰장소검색결과
	public void reviewSearch(HttpServletRequest req, Model model);
	
	//리뷰 저장 처리
	public void reviewPro(MultipartHttpServletRequest req, Model model);
	
}
