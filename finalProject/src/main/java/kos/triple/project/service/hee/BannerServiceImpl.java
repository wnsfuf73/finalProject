package kos.triple.project.service.hee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.etc.ServerSetting;
import kos.triple.project.persistence.hee.BannerDAO;
import kos.triple.project.vo.BannerVO;

@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	BannerDAO dao;
	
	// 배너글 목록
	@Override
	public void bannerList(HttpServletRequest req, Model model) {
		int pageSize = 5; 		// 한 페이지당 출력할 문의글 개수
		int pageBlock = 3; 		// 한 블럭당 페이지 개수
		
		int cnt = 0;			// 글 개수
		int start = 0;			// 현재 페이지의 문의글 시작 번호
		int end = 0;			// 현재 페이지의 문의글 마지막 번호
		int number = 0;			// 출력할 문의글 번호

		String pageNum = null;	// 페이지 번호
		int currentPage = 0;	// 현재 페이지
		
		int pageCount = 0;		// 페이지 개수
		int startPage = 0;		// 시작 페이지
		int endPage = 0;		// 마지막 페이지
		
		// 배너글 개수 구하기
		cnt = dao.getBannerCnt();
		pageNum = req.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum="1"; //첫 페이지를 1페이지로 설정
		}
		
		// 현재 페이지 currentPage
		currentPage = (Integer.parseInt(pageNum));

		// 페이지 개수
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0); // 페이지 개수 + 나머지

		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작번호

		end = start + pageSize - 1;// 현재 페이지 끝번호

		if (end > cnt)
			end = cnt;

		number = cnt - (currentPage - 1) * pageSize; // 최신글(큰페이지가)출력할 글 번호

		System.out.println("number: " + number);
		System.out.println("cnt: " + cnt);
		System.out.println("currentPage: " + currentPage);
		System.out.println("pageSize:" + pageSize);	
		
		if(cnt > 0) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", start);
			map.put("end", end);
			
			ArrayList<BannerVO> vos = dao.getBannerList(map);
			model.addAttribute("vos", vos);		
		}
		
		startPage = (currentPage / pageBlock) * pageBlock + 1; 
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock;

		endPage = startPage + pageBlock - 1; 
		if (endPage > pageCount)
			endPage = pageCount;

		model.addAttribute("cnt", cnt); 
		model.addAttribute("number", number); 
		model.addAttribute("pageNum", pageNum); 
		
		if (cnt > 0) {

			model.addAttribute("startPage", startPage); 
			model.addAttribute("endPage", endPage); 
			model.addAttribute("pageBlock", pageBlock); 
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("currentPage", currentPage);
		}
	
	}


	// 수정 상세페이지
	@Override
	public void updateBannerView(HttpServletRequest req, Model model) {

		int bannerNo = Integer.parseInt(req.getParameter("bannerNo"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		BannerVO vo = dao.getDetailBannerContent(bannerNo);
		
		model.addAttribute("vo", vo);
		model.addAttribute("pageNum", pageNum);
		
	}

	// 수정 처리 페이지
	@Override
	public void updateBannerPro(MultipartHttpServletRequest req, Model model) {

		int bannerNo = Integer.parseInt(req.getParameter("bannerNo"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bannerNo", bannerNo);
		
		MultipartFile file = req.getFile("bannerImg");
		
		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/banner");
		System.out.println(saveDir + "saveDir");
		String realDir = ServerSetting.imgPath+"/src/main/webapp/resources/images/banner/";
		System.out.println(realDir + "realDir");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		String fileName = null;	
		
		try {
			
			file.transferTo(new File(saveDir + file.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file.getOriginalFilename());
			fos = new FileOutputStream(realDir + file.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName = file.getOriginalFilename();
			map.put("bannerImg", fileName);
			dao.updateBannerImg(map);
		} 
		catch (IOException e) {
			fileName = "banner1.png";
			e.printStackTrace();
		}		
		
		BannerVO vo = new BannerVO();
		
		// 추가
		//HttpSession session = req.getSession();
		
		vo.setBannerNo(bannerNo);
		vo.setBannerName(req.getParameter("bannerName"));
		vo.setBannerImg(fileName);
		/*vo.setBannerImg(req.getParameter("bannerImg"));*/
		vo.setBannerContent(req.getParameter("bannerContent"));
		vo.setBannerLocation(req.getParameter("bannerLocation"));
		vo.setBannerLink(req.getParameter("bannerLink"));
		
		
		int cnt = dao.updateBanner(vo);
		
		model.addAttribute("bannerNo", bannerNo);
		model.addAttribute("cnt", cnt);
		model.addAttribute("pageNum", pageNum);
	}

	// 배너글 작성(추가) 처리
	@Override
	public void registerBannerPro(MultipartHttpServletRequest req, Model model) {
		
		MultipartFile file = req.getFile("bannerImg");
		
		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/banner");
	
		String realDir = ServerSetting.imgPath+"/src/main/webapp/resources/images/banner/";
		
		
		System.out.println(file.getOriginalFilename() + "fileName");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		String fileName = null;	
		
		try {
			
			file.transferTo(new File(saveDir + file.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file.getOriginalFilename());
			fos = new FileOutputStream(realDir + file.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName = file.getOriginalFilename();
		} 
		catch (IOException e) {
			fileName = "bannerDefault.jpg";
			e.printStackTrace();
		}		
		
		BannerVO vo = new BannerVO();
		// 추가
	//	HttpSession session = req.getSession();
		
		vo.setBannerName(req.getParameter("bannerName"));
		/*vo.setBannerImg(req.getParameter("bannerImg"));*/
		vo.setBannerImg(fileName);
		vo.setBannerContent(req.getParameter("bannerContent"));
		vo.setBannerLocation(req.getParameter("bannerLocation"));
		vo.setBannerLink(req.getParameter("bannerLink"));
		int bannerSeq = dao.getBannerSeq(vo.getBannerLocation());
		vo.setSeq(bannerSeq);
		vo.setBannerNo(0);
		
		int cnt = dao.registerBanner(vo);
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("vo", vo);
	}

	// 배너글 삭제 처리
	@Override
	public void deleteBannerPro(HttpServletRequest req, Model model) {

		int bannerNo = Integer.parseInt(req.getParameter("bannerNo"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		int[] bannerNoList = dao.getBannerNumberList(bannerNo);
		
		//해당배너삭제
		int deleteBannerCnt = dao.deleteBanner(bannerNo);
		
		
		//나머지배너 순서업데이트...
		BannerVO vo = new BannerVO();
		int index = 1;
		for(int i : bannerNoList) {
			if(i!=bannerNo) {
				vo.setBannerNo(i);
				vo.setSeq(index);
				dao.updateBannerSequence(vo);
				index++;
			}
		}
		
		model.addAttribute("deleteBannerCnt", deleteBannerCnt);
		model.addAttribute("pageNum", pageNum);
	}


}
