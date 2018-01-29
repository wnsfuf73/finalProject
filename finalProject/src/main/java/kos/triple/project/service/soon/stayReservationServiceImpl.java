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
	
	// ������ �˻�
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
	         
	         Date start_Day = (Date) formatter.parse(start_date); //�� ��� - ��߳�¥
	         Date end_Day = (Date) formatter.parse(end_date); //�� ��� - �ݳ���¥

	         long diff = end_Day.getTime() - start_Day.getTime();
	         long diffDats = diff / (24 * 60 * 60 * 1000);
	         
	         model.addAttribute("diffDats", diffDats);
	         
	         
	         List<Reservation_StayVO> vo = dao.date();
	         if(vo != null) {			
	         	for (Reservation_StayVO i : vo) {
	         		
	         		Date DBCheck_in = (Date) formatter.parse(i.getCheck_in()); //DB�� ����� ������¥
	         		Date DBCheck_out = (Date) formatter.parse(i.getCheck_out()); //DB�� ����� �ݳ���¥	
	         		System.out.println("DB üũ�� "+DBCheck_in);
	         		System.out.println("DB üũ�ƿ� "+DBCheck_out);
	         		Date Search_Check_in = (Date) formatter.parse(start_date); // ~~�Ϻ��� �˻��� ��¥
	         		Date Search_Check_out = (Date) formatter.parse(end_date); // ~~�ϱ��� �˻��� ��¥
	         		System.out.println("�˻� üũ�� "+Search_Check_in);
	         		System.out.println("�˻� üũ�ƿ� "+Search_Check_out);
	         		String room_no= i.getRoom_no(); //DB�� ����� ����������ȣ
	         		
	         		int rentalDate = DBCheck_in.compareTo(Search_Check_in); // A.compareTo(B) => A�� B���� ũ�ĸ� �����. A�� B���� ũ�� 1, A�� B�� ������ 0, A�� B���� ������ -1
	         		int returnDate = DBCheck_out.compareTo(Search_Check_out);
	         		int rentalDate_f = DBCheck_in.compareTo(Search_Check_out);
	         		int returnDate_f = DBCheck_out.compareTo(Search_Check_in);
	         			
	         		System.out.println("room_no : " + room_no);
	         			
	         		int check = 0;
	         											
	         		if(returnDate_f == -1) {
	         			if(rentalDate_f == -1 ) {
	         				if(rentalDate == -1 && returnDate == 1) {
	         					System.out.println("1.���� �Ұ���");
	         					check = 0;
	         				}else {
	         					System.out.println("1.���� ����");
	         					check = 1;
	         				}
	         			}else {
	         				System.out.println("2.���� �Ұ���");
	         				check = 2;
	         			}
	         		}else {
	         			if(rentalDate_f == 1){				
	         				System.out.println("2.���� ����");
	         				check = 3;
	         			}else {
	         				System.out.println("3.���� �Ұ���");
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
	
	// ���� ������
	@Override
	public void getMyPageReserStay(HttpServletRequest req, Model model) {
		int pageSize = 5;  		//�� �������� ����� �� ����
		int pageBlock = 3; 		//�Ѻ��� ������ ����	
		int number = 0;
		int cnt = 0;
		String pageNum = null;
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		//���� ����Ʈ ���� ���ϱ�
		cnt = dao.rentReservationCnt();
		
		pageNum = req.getParameter("requestPage");
		
		if(pageNum == null) {
			pageNum = "1"; //ù�������� 1�������� ����
		}
		
		PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), cnt, pageBlock, pageSize);
					
		//��ȸ�ϱ�
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start", p.getStart());
		map.put("end", p.getEnd());	
		map.put("mem_id", mem_id);
		
		Map<String, Object> checkMap = new HashMap<String, Object>();
		try {
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	         
	         Date date = new Date(); // ���� ��¥

	         List<Reservation_StayVO> vo = dao.date();
	         if(vo != null) {			
	         	for (Reservation_StayVO i : vo) {
	         		
	         		Date DBCheck_in = (Date) formatter.parse(i.getCheck_in()); //DB�� ����� ������¥
	         		Date DBCheck_out = (Date) formatter.parse(i.getCheck_out()); //DB�� ����� �ݳ���¥	
	         		
	         		String reservation_no= i.getReservation_no(); //DB�� ����� ����������ȣ
	         		
	         		// A.compareTo(B) => A�� B���� ũ�ĸ� �����. A�� B���� ũ�� 1, A�� B�� ������ 0, A�� B���� ������ -1
	         		int res_ready = DBCheck_in.compareTo(date); // DBüũ���� ���� ��¥���� Ŭ��
	         		int res_success = DBCheck_out.compareTo(date);// DBüũ�ƿ��� ���� ��¥���� Ŭ��
	         			
	         		System.out.println("reservation_no : " + reservation_no);
	         			
	         		int check = 0;
	         											
	         		if(res_ready == 1) {
	         			System.out.println("������");
	         			check = 0;
	         		} else if(res_ready == 0) {
	         			System.out.println("������");
	         			check = 1;
	         		} else {
	         			if(res_success == 1) {
	         				System.out.println("������");
	         				check = 1;
	         			} else {
	         				System.out.println("���� �Ϸ�");
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
		req.setAttribute("number_stay", number); //�۹�ȣ		
		req.setAttribute("cnt_stay", cnt); //���� ����
		if(cnt > 0) {
			req.setAttribute("startPage_stay", p.getStartPage()); //����������
			req.setAttribute("endPage_stay", p.getEndPage());//������������
			req.setAttribute("pageBlock_stay", p.getBlockSize());//����� ������ ����
			req.setAttribute("pageCount_stay", p.getContentCount());//������ ����
			req.setAttribute("pageNum_stay", p.getRequestPage());//���� ������
			req.setAttribute("blockStartNumber_stay", p.getBlockStartNumber());
			req.setAttribute("blockEndNumber_stay", p.getBlockEndNumber());
			
		}
		
	}
	
	
	// ������

	@Override
	public void stay_add(MultipartHttpServletRequest req, Model model) {
		MultipartFile file1 = req.getFile("stay_Images1");
		MultipartFile file2 = req.getFile("stay_Images2");
		MultipartFile file3 = req.getFile("stay_Images3");
		MultipartFile file4 = req.getFile("stay_Images4");
		MultipartFile file5 = req.getFile("stay_Images5");
		MultipartFile file6 = req.getFile("stay_Images6");

		System.out.println("�̹��� Ȯ��");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/stay/stay_location"); // ����

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\stay\\stay_location\\"; // ����
		// ���
		
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
		int pageSize = 10; // �� ������ �� ����� �� ����
		int pageBlock = 5; // �� �� �� ������ ����

		int cnt = 0; // ��� ����
		int start = 0; // ���� ������ �� ���� ��ȣ
		int end = 0; // ���� ������ �� ������ ��ȣ
		int number = 0; // ����� �� ��ȣ
		String pageNum = null; // ������ ��ȣ
		int currentPage = 0; // ���� ������

		int pageCount = 0; // ������ ����
		int startPage = 0; // ���� ������
		int endPage = 0; // ������ ������

		// ��� ���� ���ϱ�
		cnt = dao.getCountCnt();
		System.out.println("cnt : " + cnt);

		pageNum = req.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1"; // ù �������� 1�������� ����
		}

		currentPage = (Integer.parseInt(pageNum)); // ���� ������

		// pageCnt = 12 / 5 + 1; --> ������ 2���� 1�������� �Ҵ�ǹǷ� 3������
		pageCount = (cnt / pageSize) + (cnt % pageSize > 0 ? 1 : 0); // ������ ����

		// 1 = (1 - 1) * 5 + 1
		// 6 = (2 - 1) * 5 + 1
		// 12 = (3 - 1) * 5 + 1
		start = (currentPage - 1) * pageSize + 1; // ���� ������ ���� ��ȣ

		// 5 = 1 + 5 - 1;
		end = start + pageSize - 1; // ���� ������ ����ȣ

		System.out.println("start : " + start);
		System.out.println("end : " + end);

		if (end > cnt)
			end = cnt;

		// 20 = 21 - (5 - 1) * 5;
		number = cnt - (currentPage - 1) * pageSize; // ����� ��� ��ȣ --> �ֽ� ��(ū������)�� 1p

		System.out.println("number : " + number);
		System.out.println("cnt : " + cnt);
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageSize : " + pageSize);

		if (cnt > 0) {
			// ��� ���
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

		model.addAttribute("cnt", cnt); // ��� ����
		model.addAttribute("number", number); // �� ��ȣ
		model.addAttribute("pageNum", pageNum); // ������ ��ȣ

		if (cnt > 0) {
			model.addAttribute("startPage", startPage); // ���� ������
			model.addAttribute("endPage", endPage); // ������ ������
			model.addAttribute("pageBlock", pageBlock); // ����� ������ ����
			model.addAttribute("pageCount", pageCount); // ������ ����
			model.addAttribute("currentPage", currentPage); // ���� ������
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

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/stay/stay_location"); // ����

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\stay\\stay_location\\"; // ����
		// ���
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

		System.out.println("�̹��� Ȯ��");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/stay/stay_location_room"); // ����

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\stay\\stay_location_room\\"; // ����
		// ���
		
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

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/stay/stay_location_room"); // ����

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\stay\\stay_location_room\\"; // ����
		// ���
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
		int pageSize = 5;  		// �� �������� ����� �� ����
		int pageBlock = 3; 		// �Ѻ��� ������ ����	
		int number = 0;
		int cnt = 0;
		String pageNum = null;
		
		// ���� ����Ʈ ���� ���ϱ�
		cnt = dao.rentReservationCnt();
		
		pageNum = req.getParameter("requestPage");
		
		if(pageNum == null) {
			pageNum = "1"; // ù�������� 1�������� ����
		}
		
		PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), cnt, pageBlock, pageSize);

		// ��ȸ�ϱ�
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("start", p.getStart());
		map.put("end", p.getEnd());	
		
		Map<String, Object> checkMap = new HashMap<String, Object>();
		try {
	         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	         
	         Date date = new Date(); // ���� ��¥

	         List<Reservation_StayVO> vo = dao.date();
	         if(vo != null) {			
	         	for (Reservation_StayVO i : vo) {
	         		
	         		Date DBCheck_in = (Date) formatter.parse(i.getCheck_in()); //DB�� ����� ������¥
	         		Date DBCheck_out = (Date) formatter.parse(i.getCheck_out()); //DB�� ����� �ݳ���¥	
	         		
	         		String reservation_no= i.getReservation_no(); //DB�� ����� ����������ȣ
	         		
	         		// A.compareTo(B) => A�� B���� ũ�ĸ� �����. A�� B���� ũ�� 1, A�� B�� ������ 0, A�� B���� ������ -1
	         		int res_ready = DBCheck_in.compareTo(date); // DBüũ���� ���� ��¥���� Ŭ��
	         		int res_success = DBCheck_out.compareTo(date);// DBüũ�ƿ��� ���� ��¥���� Ŭ��
	         			
	         		System.out.println("reservation_no : " + reservation_no);
	         			
	         		int check = 0;
	         											
	         		if(res_ready == 1) {
	         			System.out.println("������");
	         			check = 0;
	         		} else if(res_ready == 0) {
	         			System.out.println("������");
	         			check = 1;
	         		} else {
	         			if(res_success == 1) {
	         				System.out.println("������");
	         				check = 1;
	         			} else {
	         				System.out.println("���� �Ϸ�");
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
		req.setAttribute("number_stay", number); //�۹�ȣ		
		req.setAttribute("cnt_stay", cnt); //���� ����
		
		req.setAttribute("startPage_stay", p.getStartPage()); //����������
		req.setAttribute("endPage_stay", p.getEndPage());//������������
		req.setAttribute("pageBlock_stay", p.getBlockSize());//����� ������ ����
		req.setAttribute("pageCount_stay", p.getContentCount());//������ ����
		req.setAttribute("pageNum_stay", p.getRequestPage());//���� ������
		req.setAttribute("blockStartNumber_stay", p.getBlockStartNumber());
		req.setAttribute("blockEndNumber_stay", p.getBlockEndNumber());
	}

	@Override
	@SuppressWarnings("unchecked")
	public void stay_reservation_total(HttpServletRequest req, Model model) {
		String year = req.getParameter("year");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        
        Date date = new Date(); // ���� ��¥
        
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