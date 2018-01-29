package kos.triple.project.service.soon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.etc.PageCalculator;
import kos.triple.project.etc.ServerSetting;
import kos.triple.project.persistence.soon.stayReservationDAO;
import kos.triple.project.vo.Reservation_CarVO;
import kos.triple.project.vo.Reservation_StayVO;
import kos.triple.project.vo.StayRoomVO;
import kos.triple.project.vo.StayVO;
import kos.triple.project.vo.StayVO;
import kos.triple.project.vo.WhereVO;

@Service
public class stayReservationServiceImpl implements stayReservationService {

	@Autowired
	stayReservationDAO dao;
	
	// 숙박지 검색
	@Override
	public void stay_search(HttpServletRequest req, Model model) {
		String search = req.getParameter("search");
		String stay_kind = req.getParameter("stay_kind");
		String stay_class = req.getParameter("stay_class");
		int standard = Integer.parseInt(req.getParameter("stay_people"));
		
		System.out.println("stay_kind"+stay_kind);
		System.out.println("stay_class"+stay_class);
		System.out.println("standard"+standard);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("stay_kind", stay_kind);
		map.put("stay_class", stay_class);
		map.put("standard", standard);
		
		ArrayList<StayVO> vos = dao.stay_search(map);
		
		model.addAttribute("vos", vos);
	}

	@Override
	public void stay_view(HttpServletRequest req, Model model) {
		String stay_no = req.getParameter("stay_no");
		
		StayVO vo = dao.stay_view(stay_no);
		
		model.addAttribute("vo", vo);
		
	}
	
	@Override
	public void stay_room_search(HttpServletRequest req, Model model) {
		String stay_no = req.getParameter("stay_no");
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		
		Map<String, Object> checkMap = new HashMap<String, Object>();
		try {
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	         
	         Date start_Day = (Date) formatter.parse(start_date); //일 계산 - 출발날짜
	         Date end_Day = (Date) formatter.parse(end_date); //일 계산 - 반납날짜

	         long diff = end_Day.getTime() - start_Day.getTime();
	         long diffDats = diff / (24 * 60 * 60 * 1000);
	         
	         model.addAttribute("diffDats", diffDats);
	         
	         
	         List<Reservation_StayVO> vo = dao.date();
	         if(vo != null) {			
	         	for (Reservation_StayVO i : vo) {
	         		
	         		Date DBCheck_in = (Date) formatter.parse(i.getCheck_in()); //DB에 저장된 빌린날짜
	         		Date DBCheck_out = (Date) formatter.parse(i.getCheck_out()); //DB에 저장된 반납날짜	
	         		System.out.println("DB 체크인 "+DBCheck_in);
	         		System.out.println("DB 체크아웃 "+DBCheck_out);
	         		Date Search_Check_in = (Date) formatter.parse(start_date); // ~~일부터 검색한 날짜
	         		Date Search_Check_out = (Date) formatter.parse(end_date); // ~~일까지 검색한 날짜
	         		System.out.println("검색 체크인 "+Search_Check_in);
	         		System.out.println("검색 체크아웃 "+Search_Check_out);
	         		String room_no= i.getRoom_no(); //DB에 저장된 차량고유번호
	         		
	         		int rentalDate = DBCheck_in.compareTo(Search_Check_in); // A.compareTo(B) => A가 B보다 크냐를 물어본다. A가 B보다 크면 1, A와 B가 같으면 0, A가 B보다 작으면 -1
	         		int returnDate = DBCheck_out.compareTo(Search_Check_out);
	         		int rentalDate_f = DBCheck_in.compareTo(Search_Check_out);
	         		int returnDate_f = DBCheck_out.compareTo(Search_Check_in);
	         			
	         		System.out.println("room_no : " + room_no);
	         			
	         		int check = 0;
	         											
	         		if(returnDate_f == -1) {
	         			if(rentalDate_f == -1 ) {
	         				if(rentalDate == -1 && returnDate == 1) {
	         					System.out.println("1.예약 불가능");
	         					check = 0;
	         				}else {
	         					System.out.println("1.예약 가능");
	         					check = 1;
	         				}
	         			}else {
	         				System.out.println("2.예약 불가능");
	         				check = 2;
	         			}
	         		}else {
	         			if(rentalDate_f == 1){				
	         				System.out.println("2.예약 가능");
	         				check = 3;
	         			}else {
	         				System.out.println("3.예약 불가능");
	         				check = 4;
	         			}
	         		}		
	         		checkMap.put(room_no, check);							
	         	}

	         	model.addAttribute("checkMap",checkMap);
	         }
	      }catch(java.text.ParseException e){
	         e.printStackTrace();
	      }
		ArrayList<StayVO> vos = dao.stay_room_list(stay_no);
		
		model.addAttribute("check_in", start_date);
		model.addAttribute("check_out", end_date);
		model.addAttribute("vos", vos);
		
	}
	
	@Override
	public void stay_room_view(HttpServletRequest req, Model model) {
		String room_no = req.getParameter("room_no");
		int total_price = Integer.parseInt(req.getParameter("total_price"));
		String check_in = req.getParameter("check_in");
		String check_out = req.getParameter("check_out");
		
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("stay_no", stay_no);
		map.put("room_no", room_no);*/
		
		StayRoomVO vo = dao.stay_room_view(room_no);
		
		model.addAttribute("vo", vo);
		model.addAttribute("total_price", total_price);
		model.addAttribute("check_in", check_in);
		model.addAttribute("check_out", check_out);
	}
	
	@Override
	public void stay_room_reservation(HttpServletRequest req, Model model) {
		String mem_id = req.getParameter("mem_id");
		String stay_no = req.getParameter("stay_no");
		String room_no = req.getParameter("room_no");
		String check_in = req.getParameter("check_in");
		String check_out = req.getParameter("check_out");
		int total_price = Integer.parseInt(req.getParameter("total_price"));
		String stay_people = req.getParameter("stay_people");
		String pay_method = req.getParameter("pay_method");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", mem_id);
		map.put("stay_no", stay_no);
		map.put("room_no", room_no);
		map.put("check_in", check_in);
		map.put("check_out", check_out);
		map.put("total_price", total_price);
		map.put("stay_people", stay_people);
		map.put("pay_method", pay_method);
		
		int cnt = dao.stay_room_reservation(map);
		
		model.addAttribute("cnt", cnt);
		
	}
	
	@Override
	public void stayResCancel(HttpServletRequest req, Model model) {
		String reservation_no = req.getParameter("reservation_no");
		
		dao.stayResCancel(reservation_no);
		
	}
	
	// 마이 페이지
	@Override
	public void getMyPageReserStay(HttpServletRequest req, Model model) {
		int pageSize = 5;  		//한 페이지당 출력할 글 개수
		int pageBlock = 3; 		//한블럭당 페이지 개수	
		int number = 0;
		int cnt = 0;
		String pageNum = null;
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		//예약 리스트 갯수 구하기
		cnt = dao.rentReservationCnt();
		
		pageNum = req.getParameter("requestPage");
		
		if(pageNum == null) {
			pageNum = "1"; //첫페이지를 1페이지로 설정
		}
		
		PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), cnt, pageBlock, pageSize);
					
		//조회하기
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start", p.getStart());
		map.put("end", p.getEnd());	
		map.put("mem_id", mem_id);
		
		Map<String, Object> checkMap = new HashMap<String, Object>();
		try {
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	         
	         Date date = new Date(); // 현재 날짜

	         List<Reservation_StayVO> vo = dao.date();
	         if(vo != null) {			
	         	for (Reservation_StayVO i : vo) {
	         		
	         		Date DBCheck_in = (Date) formatter.parse(i.getCheck_in()); //DB에 저장된 빌린날짜
	         		Date DBCheck_out = (Date) formatter.parse(i.getCheck_out()); //DB에 저장된 반납날짜	
	         		
	         		String reservation_no= i.getReservation_no(); //DB에 저장된 차량고유번호
	         		
	         		// A.compareTo(B) => A가 B보다 크냐를 물어본다. A가 B보다 크면 1, A와 B가 같으면 0, A가 B보다 작으면 -1
	         		int res_ready = DBCheck_in.compareTo(date); // DB체크인이 현재 날짜보다 클때
	         		int res_success = DBCheck_out.compareTo(date);// DB체크아웃이 현재 날짜보다 클때
	         			
	         		System.out.println("reservation_no : " + reservation_no);
	         			
	         		int check = 0;
	         											
	         		if(res_ready == 1) {
	         			System.out.println("예약중");
	         			check = 0;
	         		} else if(res_ready == 0) {
	         			System.out.println("숙박중");
	         			check = 1;
	         		} else {
	         			if(res_success == 1) {
	         				System.out.println("숙박중");
	         				check = 1;
	         			} else {
	         				System.out.println("숙박 완료");
	         				check = 2;
	         			}
	         		}
	         		checkMap.put(reservation_no, check);							
	         	}

	         	model.addAttribute("checkMap",checkMap);
	         }
	      }catch(java.text.ParseException e){
	         e.printStackTrace();
	    }
		
		ArrayList<Reservation_StayVO> dtos = dao.reservation_staylist(map);
		req.setAttribute("dtos_stay", dtos);
		req.setAttribute("number_stay", number); //글번호		
		req.setAttribute("cnt_stay", cnt); //예약 갯수
		if(cnt > 0) {
			req.setAttribute("startPage_stay", p.getStartPage()); //시작페이지
			req.setAttribute("endPage_stay", p.getEndPage());//마지막페이지
			req.setAttribute("pageBlock_stay", p.getBlockSize());//출력할 페이지 개수
			req.setAttribute("pageCount_stay", p.getContentCount());//페이지 개수
			req.setAttribute("pageNum_stay", p.getRequestPage());//현재 페이지
			req.setAttribute("blockStartNumber_stay", p.getBlockStartNumber());
			req.setAttribute("blockEndNumber_stay", p.getBlockEndNumber());
			
		}
		
	}
	
	
	// 관리자

	@Override
	public void stay_add(MultipartHttpServletRequest req, Model model) {
		MultipartFile file1 = req.getFile("stay_Images1");
		MultipartFile file2 = req.getFile("stay_Images2");
		MultipartFile file3 = req.getFile("stay_Images3");
		MultipartFile file4 = req.getFile("stay_Images4");
		MultipartFile file5 = req.getFile("stay_Images5");
		MultipartFile file6 = req.getFile("stay_Images6");

		System.out.println("이미지 확인");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/stay/stay_location"); // 저장

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\stay\\stay_location\\"; // 저장
		// 경로
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String fileName1 = null;
		String fileName2 = null;
		String fileName3 = null;
		String fileName4 = null;
		String fileName5 = null;
		String fileName6 = null;

		try {
			
			file1.transferTo(new File(saveDir + file1.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file1.getOriginalFilename());
			fos = new FileOutputStream(realDir + file1.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName1 = file1.getOriginalFilename();
		} 
		catch (IOException e) {
			fileName1 = "default.jpg";
		}
		
		try {
		
			file2.transferTo(new File(saveDir + file2.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file2.getOriginalFilename());
			fos = new FileOutputStream(realDir + file2.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName2 = file2.getOriginalFilename();
		}
		catch (Exception e) {
			fileName2 = "default.jpg";
		}
		
		
		try {
			file3.transferTo(new File(saveDir + file3.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file3.getOriginalFilename());
			fos = new FileOutputStream(realDir + file3.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName3 = file3.getOriginalFilename();
		}
		catch (Exception e) {
			fileName3 = "default.jpg";
		}
		
		try {
			file4.transferTo(new File(saveDir + file4.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file4.getOriginalFilename());
			fos = new FileOutputStream(realDir + file4.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName4 = file4.getOriginalFilename();
		}
		catch (Exception e) {
			fileName4 = "default.jpg";
		}
		
		try {
			file5.transferTo(new File(saveDir + file5.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file5.getOriginalFilename());
			fos = new FileOutputStream(realDir + file5.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName5 = file5.getOriginalFilename();
		}
		catch (Exception e) {
			fileName5 = "default.jpg";
		}
		
		try {
			file6.transferTo(new File(saveDir + file6.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file6.getOriginalFilename());
			fos = new FileOutputStream(realDir + file6.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName6 = file6.getOriginalFilename();
		}
		catch (Exception e) {
			fileName6 = "default.jpg";
		}

			String stay_name = req.getParameter("stay_Name");
			String stay_address = req.getParameter("stay_Address");
			String stay_cellphone = req.getParameter("stay_tell");
			String stay_introduce = req.getParameter("stay_Info");
			String stay_kind = req.getParameter("stay_kind");
			String stay_class = req.getParameter("stay_class");
			String stay_general_details = req.getParameter("stay_general_details");
			String stay_amenities = req.getParameter("stay_amenities");
			String stay_service = req.getParameter("stay_service");
			String stay_internet = req.getParameter("stay_internet");
			String stay_parking = req.getParameter("stay_parking");
			String stay_check_in = req.getParameter("stay_check_in");
			String stay_check_out = req.getParameter("stay_check_out");
			String stay_x = req.getParameter("stay_X");
			String stay_y = req.getParameter("stay_Y");

			StayVO vo = new StayVO();

			vo.setStay_img1(fileName1);
			vo.setStay_img2(fileName2);
			vo.setStay_img3(fileName3);
			vo.setStay_img4(fileName4);
			vo.setStay_img5(fileName5);
			vo.setStay_img6(fileName6);
			
			vo.setStay_name(stay_name);
			vo.setStay_address(stay_address);
			vo.setStay_cellphone(stay_cellphone);
			vo.setStay_introduce(stay_introduce);
			vo.setStay_kind(stay_kind);
			vo.setStay_class(stay_class);
			vo.setStay_general_details(stay_general_details);
			vo.setStay_amenities(stay_amenities);
			vo.setStay_service(stay_service);
			vo.setStay_internet(stay_internet);
			vo.setStay_parking(stay_parking);
			vo.setStay_check_in(stay_check_in);
			vo.setStay_check_out(stay_check_out);
			vo.setStay_x(stay_x);
			vo.setStay_y(stay_y);

			int cnt = dao.stay_add(vo);

			model.addAttribute("cnt", cnt);
	}

	@Override
	public void stay_list(HttpServletRequest req, Model model) {
		int pageSize = 10; // 한 페이지 당 출력할 글 갯수
		int pageBlock = 5; // 한 블럭 당 페이지 갯수

		int cnt = 0; // 장소 갯수
		int start = 0; // 현재 페이지 글 시작 번호
		int end = 0; // 현재 페이지 글 마지막 번호
		int number = 0; // 출력할 글 번호
		String pageNum = null; // 페이지 번호
		int currentPage = 0; // 현재 페이지

		int pageCount = 0; // 페이지 갯수
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지

		// 장소 개수 구하기
		cnt = dao.getCountCnt();
		System.out.println("cnt : " + cnt);

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // 첫 페이지를 1페이지로 설정
		}

		currentPage = (Integer.parseInt(pageNum)); // 현재 페이지

		// pageCnt = 12 / 5 + 1; --> 나머지 2건이 1페이지로 할당되므로 3페이지
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0); // 페이지 갯수

		// 1 = (1 - 1) * 5 + 1
		// 6 = (2 - 1) * 5 + 1
		// 12 = (3 - 1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1; // 현재 페이지 시작 번호

		// 5 = 1 + 5 - 1;
		end = start + pageSize - 1; // 현재 페이지 끝번호

		System.out.println("start : " + start);
		System.out.println("end : " + end);

		if (end > cnt)
			end = cnt;

		// 20 = 21 - (5 - 1) * 5;
		number = cnt - (currentPage - 1) * pageSize; // 출력할 장소 번호 --> 최신 글(큰페이지)가 1p

		System.out.println("number : " + number);
		System.out.println("cnt : " + cnt);
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageSize : " + pageSize);

		if (cnt > 0) {
			// 장소 목록
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("start", start);
			map.put("end", end);

			ArrayList<StayVO> vos = dao.stay_list(map);
			model.addAttribute("vos", vos);

		}

		startPage = (currentPage / pageBlock) * pageBlock + 1; // (5/3) * 3 + 1 = 4;
		if (currentPage % pageBlock == 0)
			startPage -= pageBlock; // (5%3) == 0

		endPage = startPage + pageBlock - 1; // 4 + 3 - 1 = 6
		if (endPage > pageCount)
			endPage = pageCount;

		model.addAttribute("cnt", cnt); // 장소 갯수
		model.addAttribute("number", number); // 글 번호
		model.addAttribute("pageNum", pageNum); // 페이지 번호

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // 시작 페이지
			model.addAttribute("endPage", endPage); // 마지막 페이지
			model.addAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			model.addAttribute("pageCount", pageCount); // 페이지 갯수
			model.addAttribute("currentPage", currentPage); // 현재 페이지
		}
		
	}

	@Override
	public void stay_list_view(HttpServletRequest req, Model model) {
		String stay_no = req.getParameter("stay_no");

		StayVO vo = dao.stay_list_view(stay_no);
		model.addAttribute("vo", vo);
		
	}

	@Override
	public void modify(MultipartHttpServletRequest req, Model model) {
		String stay_no = req.getParameter("stay_no");
		
		String stay_name = req.getParameter("stay_Name");
		String stay_address = req.getParameter("stay_Address");
		String stay_cellphone = req.getParameter("stay_tell");
		String stay_introduce = req.getParameter("stay_Info");
		String stay_kind = req.getParameter("stay_kind");
		String stay_class = req.getParameter("stay_class");
		String stay_general_details = req.getParameter("stay_general_details");
		String stay_amenities = req.getParameter("stay_amenities");
		String stay_service = req.getParameter("stay_service");
		String stay_internet = req.getParameter("stay_internet");
		String stay_parking = req.getParameter("stay_parking");
		String stay_check_in = req.getParameter("stay_check_in");
		String stay_check_out = req.getParameter("stay_check_out");
		String stay_x = req.getParameter("stay_X");
		String stay_y = req.getParameter("stay_Y");
		
		Map<String,Object> imgMap = new HashMap<String,Object>();
		imgMap.put("stay_no", stay_no);
		
		MultipartFile file1 = req.getFile("stay_Images1");
		MultipartFile file2 = req.getFile("stay_Images2");
		MultipartFile file3 = req.getFile("stay_Images3");
		MultipartFile file4 = req.getFile("stay_Images4");
		MultipartFile file5 = req.getFile("stay_Images5");
		MultipartFile file6 = req.getFile("stay_Images6");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/stay/stay_location"); // 저장

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\stay\\stay_location\\"; // 저장
		// 경로
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String fileName1 = null;
		String fileName2 = null;
		String fileName3 = null;
		String fileName4 = null;
		String fileName5 = null;
		String fileName6 = null;
		
		try {
		
			file1.transferTo(new File(saveDir + file1.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file1.getOriginalFilename());
			fos = new FileOutputStream(realDir + file1.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName1 = file1.getOriginalFilename();
			imgMap.put("imgName",fileName1);
			imgMap.put("location","img1");
			
			dao.updateImg(imgMap);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
		
			file2.transferTo(new File(saveDir + file2.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file2.getOriginalFilename());
			fos = new FileOutputStream(realDir + file2.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName2 = file2.getOriginalFilename();
			imgMap.put("imgName",fileName2);
			imgMap.put("location","img2");
			
			dao.updateImg(imgMap);
		}
		catch (Exception e) {
			
		}
		
		
		try {
			file3.transferTo(new File(saveDir + file3.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file3.getOriginalFilename());
			fos = new FileOutputStream(realDir + file3.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();

			fileName3 = file3.getOriginalFilename();
			imgMap.put("imgName",fileName3);
			imgMap.put("location","img3");
			
			dao.updateImg(imgMap);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			file4.transferTo(new File(saveDir + file4.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file4.getOriginalFilename());
			fos = new FileOutputStream(realDir + file4.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName4 = file4.getOriginalFilename();
			imgMap.put("imgName",fileName4);
			imgMap.put("location","img4");
			
			dao.updateImg(imgMap);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			file5.transferTo(new File(saveDir + file5.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file5.getOriginalFilename());
			fos = new FileOutputStream(realDir + file5.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName5 = file5.getOriginalFilename();
			imgMap.put("imgName",fileName5);
			imgMap.put("location","img5");
			
			dao.updateImg(imgMap);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			file6.transferTo(new File(saveDir + file6.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file6.getOriginalFilename());
			fos = new FileOutputStream(realDir + file6.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName6 = file6.getOriginalFilename();
			imgMap.put("imgName",fileName6);
			imgMap.put("location","img6");
			
			dao.updateImg(imgMap);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		StayVO vo = new StayVO();

		vo.setStay_img1(fileName1);
		vo.setStay_img2(fileName2);
		vo.setStay_img3(fileName3);
		vo.setStay_img4(fileName4);
		vo.setStay_img5(fileName5);
		vo.setStay_img6(fileName6);
		
		vo.setStay_name(stay_name);
		vo.setStay_address(stay_address);
		vo.setStay_cellphone(stay_cellphone);
		vo.setStay_introduce(stay_introduce);
		vo.setStay_kind(stay_kind);
		vo.setStay_class(stay_class);
		vo.setStay_general_details(stay_general_details);
		vo.setStay_amenities(stay_amenities);
		vo.setStay_service(stay_service);
		vo.setStay_internet(stay_internet);
		vo.setStay_parking(stay_parking);
		vo.setStay_check_in(stay_check_in);
		vo.setStay_check_out(stay_check_out);
		vo.setStay_x(stay_x);
		vo.setStay_y(stay_y);

		vo.setStay_no(stay_no);
		
		int cnt = dao.modify(vo);

		model.addAttribute("cnt", cnt);
		
	}

	@Override
	public void delete(HttpServletRequest req, Model model) {
		String stay_no = req.getParameter("stay_no");

		int cnt = dao.delete(stay_no);

		model.addAttribute("cnt", cnt);
		
	}

	@Override
	public void stay_room_add(MultipartHttpServletRequest req, Model model) {
		MultipartFile file1 = req.getFile("room_img");

		System.out.println("이미지 확인");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/stay/stay_location_room"); // 저장

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\stay\\stay_location_room\\"; // 저장
		// 경로
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String fileName1 = null;

		try {
			
			file1.transferTo(new File(saveDir + file1.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file1.getOriginalFilename());
			fos = new FileOutputStream(realDir + file1.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName1 = file1.getOriginalFilename();
		} 
		catch (IOException e) {
			fileName1 = "default.jpg";
		}

			String stay_no = req.getParameter("stay_no");
			
			String room_name = req.getParameter("room_name");
			int standard = Integer.parseInt(req.getParameter("standard"));
			int sale_price = Integer.parseInt(req.getParameter("sale_price"));
			String room_info = req.getParameter("room_info");

			StayVO vo = new StayVO();

			vo.setRoom_img(fileName1);
			
			vo.setStay_no(stay_no);
			vo.setRoom_name(room_name);
			vo.setStandard(standard);
			vo.setSale_price(sale_price);
			vo.setRoom_info(room_info);

			int cnt = dao.stay_room_add(vo);

			model.addAttribute("cnt", cnt);
	}

	@Override
	public void stay_room_list(HttpServletRequest req, Model model) {
			String stay_no = req.getParameter("stay_no");
			
			ArrayList<StayVO> vos = dao.stay_room_list(stay_no);
			
			model.addAttribute("vos", vos);
	}

	@Override
	public void stay_room_list_view(HttpServletRequest req, Model model) {
		String room_no = req.getParameter("room_no");

		StayVO vo = dao.stay_room_list_view(room_no);
		model.addAttribute("vo", vo);
		
	}

	@Override
	public void stay_room_modify(MultipartHttpServletRequest req, Model model) {
		String room_no = req.getParameter("room_no");
		
		String room_name = req.getParameter("room_name");
		int standard = Integer.parseInt(req.getParameter("standard"));
		int sale_price = Integer.parseInt(req.getParameter("sale_price"));
		String room_info = req.getParameter("room_info");
		
		Map<String,Object> imgMap = new HashMap<String,Object>();
		imgMap.put("room_no", room_no);
		
		MultipartFile file1 = req.getFile("room_img");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/stay/stay_location_room"); // 저장

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\stay\\stay_location_room\\"; // 저장
		// 경로
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String fileName1 = null;
		
		try {
		
			file1.transferTo(new File(saveDir + file1.getOriginalFilename()));
			fis = new FileInputStream(saveDir + file1.getOriginalFilename());
			fos = new FileOutputStream(realDir + file1.getOriginalFilename());
			int data = 0;

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
			fileName1 = file1.getOriginalFilename();
			imgMap.put("imgName",fileName1);
			imgMap.put("location","img1");
			
			dao.room_updateImg(imgMap);
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		StayVO vo = new StayVO();

		vo.setRoom_img(fileName1);
		
		vo.setRoom_name(room_name);
		vo.setStandard(standard);
		vo.setSale_price(sale_price);
		vo.setRoom_info(room_info);

		vo.setRoom_no(room_no);
		
		int cnt = dao.stay_room_modify(vo);

		model.addAttribute("cnt", cnt);
		
	}

	@Override
	public void stay_room_delete(HttpServletRequest req, Model model) {
		String room_no = req.getParameter("room_no");

		int cnt = dao.stay_room_delete(room_no);

		model.addAttribute("cnt", cnt);
	}

	@Override
	public void stay_reservation_list(HttpServletRequest req, Model model) {
		int pageSize = 5;  		// 한 페이지당 출력할 글 개수
		int pageBlock = 3; 		// 한블럭당 페이지 개수	
		int number = 0;
		int cnt = 0;
		String pageNum = null;
		
		// 예약 리스트 갯수 구하기
		cnt = dao.rentReservationCnt();
		
		pageNum = req.getParameter("requestPage");
		
		if(pageNum == null) {
			pageNum = "1"; // 첫페이지를 1페이지로 설정
		}
		
		PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), cnt, pageBlock, pageSize);

		// 조회하기
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start", p.getStart());
		map.put("end", p.getEnd());	
		
		Map<String, Object> checkMap = new HashMap<String, Object>();
		try {
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	         
	         Date date = new Date(); // 현재 날짜

	         List<Reservation_StayVO> vo = dao.date();
	         if(vo != null) {			
	         	for (Reservation_StayVO i : vo) {
	         		
	         		Date DBCheck_in = (Date) formatter.parse(i.getCheck_in()); //DB에 저장된 빌린날짜
	         		Date DBCheck_out = (Date) formatter.parse(i.getCheck_out()); //DB에 저장된 반납날짜	
	         		
	         		String reservation_no= i.getReservation_no(); //DB에 저장된 차량고유번호
	         		
	         		// A.compareTo(B) => A가 B보다 크냐를 물어본다. A가 B보다 크면 1, A와 B가 같으면 0, A가 B보다 작으면 -1
	         		int res_ready = DBCheck_in.compareTo(date); // DB체크인이 현재 날짜보다 클때
	         		int res_success = DBCheck_out.compareTo(date);// DB체크아웃이 현재 날짜보다 클때
	         			
	         		System.out.println("reservation_no : " + reservation_no);
	         			
	         		int check = 0;
	         											
	         		if(res_ready == 1) {
	         			System.out.println("예약중");
	         			check = 0;
	         		} else if(res_ready == 0) {
	         			System.out.println("숙박중");
	         			check = 1;
	         		} else {
	         			if(res_success == 1) {
	         				System.out.println("숙박중");
	         				check = 1;
	         			} else {
	         				System.out.println("숙박 완료");
	         				check = 2;
	         			}
	         		}
	         		checkMap.put(reservation_no, check);							
	         	}

	         	model.addAttribute("checkMap",checkMap);
	         }
	      }catch(java.text.ParseException e){
	         e.printStackTrace();
	    }
     
		
		ArrayList<Reservation_StayVO> dtos = dao.stay_reservation_list(map);
		req.setAttribute("dtos_stay", dtos);
		req.setAttribute("number_stay", number); //글번호		
		req.setAttribute("cnt_stay", cnt); //예약 갯수
		
		req.setAttribute("startPage_stay", p.getStartPage()); //시작페이지
		req.setAttribute("endPage_stay", p.getEndPage());//마지막페이지
		req.setAttribute("pageBlock_stay", p.getBlockSize());//출력할 페이지 개수
		req.setAttribute("pageCount_stay", p.getContentCount());//페이지 개수
		req.setAttribute("pageNum_stay", p.getRequestPage());//현재 페이지
		req.setAttribute("blockStartNumber_stay", p.getBlockStartNumber());
		req.setAttribute("blockEndNumber_stay", p.getBlockEndNumber());
	}

	@Override
	@SuppressWarnings("unchecked")
	public void stay_reservation_total(HttpServletRequest req, Model model) {
		String year = req.getParameter("year");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        
        Date date = new Date(); // 현재 날짜
        
        String now_date = formatter.format(date);
        
        if(year == null) {
        	year = now_date;
        }
		
		int totalSale = dao.getTotalSale();
		model.addAttribute("totalSale", totalSale);

		Map<String, Object> map = (Map<String, Object>) dao.getFirstChart();
		model.addAttribute("firstChat", map);
		
		Map<String, Object> map2 = (Map<String, Object>) dao.getSecondChart();
		model.addAttribute("secondChart", map2);
		
		Map<String, Object> map3 = (Map<String, Object>) dao.getFinalChart(year);
		model.addAttribute("fianlChart", map3);
		
		model.addAttribute("today", year);
		
	}

	@Override
	public void getCharData_Stay(HttpServletRequest req, Model model) {
		
		Map<String,Object> stay_fristChat = new HashMap<String, Object>();
		Map<String,Object> stay_secondChat = new HashMap<String, Object>();
		Map<String,Object> stay_finalChat = new HashMap<String, Object>();
		
		String year = req.getParameter("year") == null ? Integer.toString(Calendar.getInstance().get(Calendar.YEAR)) : req.getParameter("year");
		
		int firstChatValue = dao.getFirstChartAll();
		stay_fristChat.put("firstChatValue", 0);
		stay_fristChat.put("firstChatValue", firstChatValue);
		
		int secondChatValue = dao.getSecondChartAll();
		stay_secondChat.put("secondChatValue", 0);
		stay_secondChat.put("secondChatValue", secondChatValue);
		
		stay_finalChat = dao.getFinalChartAll(year);
		
		model.addAttribute("stay_fristChat", stay_fristChat);
		model.addAttribute("stay_secondChat", stay_secondChat);
		model.addAttribute("stay_finalChat", stay_finalChat);
		
	}

}