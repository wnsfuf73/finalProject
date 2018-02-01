package kos.triple.project.service.kwak;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.etc.ServerSetting;
import kos.triple.project.persistence.kwak.EssayDAO;
import kos.triple.project.vo.EssayVO;
import kos.triple.project.vo.ReviewVO;
import kos.triple.project.vo.WhereVO;

@Service
public class EssayServiceImpl implements EssayService {
	
	@Autowired
	EssayDAO dao;

	//에세이 저장
	@Override
	public void inserEssay(MultipartHttpServletRequest req, Model model) {
		
		MultipartFile file = req.getFile("essayImg");
		
		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/essay/");
		
		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\essay\\";

		try {
			file.transferTo(new File(saveDir+file.getOriginalFilename()));
	         
	    	 FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
	         FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());
	         
	         int data = 0;
	         
	         while((data = fis.read()) != -1) {
	            fos.write(data);
	         }
	         fis.close();
	         fos.close();
	         
	         //바구니 생성
	         EssayVO dto = new EssayVO();
	         
	         //바구니에 담는다.
	         dto.setEssayTitle(req.getParameter("title"));
	         System.out.println(req.getParameter("title"));
	         
	         dto.setEssayContent(req.getParameter("content"));
	         System.out.println(req.getParameter("content"));
	         
	         dto.setEssayImg(file.getOriginalFilename());
	         System.out.println(file.getOriginalFilename());
	         
	         dto.setSecurity(Integer.parseInt(req.getParameter("invi")));
	         System.out.println(Integer.parseInt(req.getParameter("invi")));
	         
	         dto.setMem_id((String)req.getSession().getAttribute("mem_id"));
	         System.out.println((String)req.getSession().getAttribute("mem_id"));
	         
	         //insertEssay()
	         int cnt = dao.insertEssay(dto);
	         
	         //jsp로 넘기기	         
	         model.addAttribute("cnt",cnt);
	         
		}catch(Exception e) {
	          e.printStackTrace();
	    }
		
	}

	//검색결과
	@Override
	public void reviewSearch(HttpServletRequest req, Model model) {
		String reviewSearch = req.getParameter("reviewSearch");
		System.out.println("검색어 : "+reviewSearch);
		
		//목록검색
		ArrayList<WhereVO> dtos = dao.reviewSearch(reviewSearch);
		req.setAttribute("dtos",dtos);
	}

	//리뷰 저장 처리
	@Override
	public void reviewPro(MultipartHttpServletRequest req, Model model) {
		MultipartFile file = req.getFile("simg");
		
		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/review/");
		
		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\review\\";
				
		try {
			
			file.transferTo(new File(saveDir+file.getOriginalFilename()));
	         
	    	 FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
	         FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());
	         
	         int data = 0;
	         
	         while((data = fis.read()) != -1) {
	            fos.write(data);
	         }
	         fis.close();
	         fos.close();
	         
	         //바구니 생성
	         ReviewVO dto = new ReviewVO();
	         
	         System.out.println("----------review---------------------");
	         System.out.println(req.getParameter("searchcontent"));	         
	         System.out.println(Integer.parseInt(req.getParameter("reviewview")));	         
	         System.out.println(Integer.parseInt(req.getParameter("fun")));	         
	         System.out.println(Integer.parseInt(req.getParameter("near")));	         
	         System.out.println(Integer.parseInt(req.getParameter("price")));	         
	         System.out.println(req.getParameter("review_text"));	         
	         System.out.println(file.getOriginalFilename());
	         dto.setMem_id((String) req.getSession().getAttribute("mem_id"));
	         System.out.println(req.getParameter("location_num"));
	         
	         //바구니에 저장
	         dto.setLocation_num(req.getParameter("searchcontent"));	         
	         dto.setReviewview(Integer.parseInt(req.getParameter("reviewview")));	         
	         dto.setFun(Integer.parseInt(req.getParameter("fun")));	         
	         dto.setNear(Integer.parseInt(req.getParameter("near")));	         
	         dto.setPrice(Integer.parseInt(req.getParameter("price")));	         
	         dto.setContent(req.getParameter("review_text"));	         
	         dto.setReviewImg(file.getOriginalFilename());
	         dto.setMem_id((String) req.getSession().getAttribute("mem_id"));
	         dto.setLocation_num(req.getParameter("location_num"));
	         
	         String time = req.getParameter("review_date") ; 
	         //"2017-06-25 13:12:0.0"
	         dto.setRegdate(Date.valueOf(time));
	         System.out.println(Date.valueOf(time));
	         
	         int cnt = dao.insertReview(dto);
	         
	         model.addAttribute("cnt", cnt);
	         System.out.println("insertReviewCnt" + cnt);
	         
		}catch(Exception e) {
	          e.printStackTrace();
	    }
		
	}

}
