package kos.triple.project.service.hong;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import kos.triple.project.persistence.hong.CarDAO;
import kos.triple.project.vo.CarInfoVO;
import kos.triple.project.vo.RentCarVO;
import kos.triple.project.vo.Reservation_CarVO;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	CarDAO dao;

	//��Ʈī �߰�
	@Override
	public void rentAdd(MultipartHttpServletRequest req, Model model) {
		
		MultipartFile file = req.getFile("car_img");
		
		int maxSize = 10 * 1024 * 1024;
		
		String saveDir = req.getRealPath("/resources/images/car/");
		
		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\car\\";
		
		String encType = "UTF-8";
		
		try {
			file.transferTo(new File(saveDir+file.getOriginalFilename()));
            
            FileInputStream fis = new FileInputStream(saveDir + file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(realDir + file.getOriginalFilename());
            
            if(new File(realDir + saveDir).exists()) {

            	saveDir = saveDir + "_" + System.currentTimeMillis();

            }
            
            int data = 0;
			
			while((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
				
			RentCarVO vo = new RentCarVO();
			
			String rent_no = req.getParameter("rent_no");
			String use_km = req.getParameter("use_km");
			String car_count = req.getParameter("car_count");
			String insurance = req.getParameter("insurance");
			String car_num = req.getParameter("car_num");
			String fileName = file.getOriginalFilename();
			
			vo.setRent_no(rent_no);
			vo.setUse_km(use_km);
			vo.setCar_count(Integer.parseInt(car_count));
			vo.setInsurance(insurance);
			vo.setCar_num(car_num);
			vo.setCar_img(fileName);
			
			int cnt = dao.rentAdd(vo);
			
			model.addAttribute("cnt", cnt);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//��Ʈī ��ȸ
	@Override
	public void rentCar(HttpServletRequest req, Model model) {
		Map<String,Object> checkMap = new HashMap<String,Object>();
		int pageSize = 5;  		//�� �������� ����� �� ����
		int pageBlock = 3; 		//�Ѻ��� ������ ����		
		int cnt = 0; 	   		
		int number = 0;    		//����� �� ��ȣ
		String pageNum = null;  //������ ��ȣ

		pageNum = req.getParameter("requestPage");
		
		if(pageNum == null) {
			pageNum = "1"; //ù�������� 1�������� ����
		}		
								
		String car_kind = req.getParameter("car_kind");		
		String rental_day = req.getParameter("rental_day");
		String return_day = req.getParameter("return_day");			
		String rental_time = req.getParameter("rental_time");
		String return_time = req.getParameter("return_time");
		
		
		//�� ���� ���
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Date startDate = (Date) format.parse(rental_day); //�� ��� - ��߳�¥
			Date endDate = (Date) format.parse(return_day); //�� ��� - �ݳ���¥

			String rental_t[] = rental_time.split(":");
			String return_t[] = return_time.split(":");
		
			int rental_s = Integer.parseInt(rental_t[0]);
			int return_s = Integer.parseInt(return_t[0]);
			
			model.addAttribute("rental_s",rental_s);
			model.addAttribute("return_s",return_s);
			
			if(Integer.parseInt(return_t[0]) < Integer.parseInt(rental_t[0])) {
				int s_time = 24 - Integer.parseInt(rental_t[0]);
				int e_time = 24 - Integer.parseInt(return_t[0]);				
				int ch = e_time-s_time;			
	
				model.addAttribute("ch", ch);
			}else {				
				int t = Integer.parseInt(return_t[0]) - Integer.parseInt(rental_t[0]);	
				
				model.addAttribute("t", t);
			}					
			long diff = endDate.getTime() - startDate.getTime();
			long diffDats = diff / (24 * 60 * 60* 1000);
			
			model.addAttribute("diffDats", diffDats);
			
			//��Ʈī ���� �ߺ� ���ϱ�
			List<Reservation_CarVO> vo = dao.date();
			if(vo != null) {			
				for (Reservation_CarVO i : vo) {
					
					Date rental_d = format.parse(i.getRental_day()); //DB�� ����� ������¥
					Date return_d = format.parse(i.getReturn_day()); //DB�� ����� �ݳ���¥				
					Date rental_search = format.parse(rental_day); // ~~�Ϻ��� �˻��� ��¥
					Date return_search = format.parse(return_day); // ~~�ϱ��� �˻��� ��¥
					String rent_no= i.getRent_no(); //DB�� ����� ����������ȣ
					
					int rentalDate = rental_d.compareTo(rental_search); // A.compareTo(B) => A�� B���� ũ�ĸ� �����. A�� B���� ũ�� 1, A�� B�� ������ 0, A�� B���� ������ -1
					int returnDate = return_d.compareTo(return_search);
					int rentalDate_f = rental_d.compareTo(return_search);
					int returnDate_f = return_d.compareTo(rental_search);
					
					System.out.println("rent_no : " + rent_no);
					
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
				
					checkMap.put(rent_no, check);
									
				}

				model.addAttribute("checkMap",checkMap);
			}
			
		}catch(java.text.ParseException e){
			e.printStackTrace();
		}
		
		if(car_kind.equals("��ü") && car_kind != null) {
			cnt = dao.getArticleCnt();
			PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), cnt, pageBlock, pageSize);
			Map<String,Integer> map = new HashMap<String, Integer>();
			map.put("start", p.getStart());
			map.put("end", p.getEnd());		
			ArrayList<CarInfoVO> dtos = dao.rentCarAll(map);
			model.addAttribute("dtos", dtos);
			
		} else {
			cnt = dao.getArticleCntKind(car_kind);
			PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), cnt, pageBlock, pageSize);
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("start", p.getStart());
			map.put("end", p.getEnd());
			map.put("car_kind",car_kind);
			ArrayList<CarInfoVO> dtos = dao.rentCar(map);
			model.addAttribute("dtos", dtos);
		}
		
		model.addAttribute("car_kind", car_kind); //����
		model.addAttribute("rental_day", rental_day); //�����ð�
		model.addAttribute("return_day", return_day); //�ݳ��ð�
		model.addAttribute("rental_time",rental_time);//�����ð�
		model.addAttribute("return_time",return_time);//�ݳ��ð�
		model.addAttribute("cnt", cnt); //��Ʈī ����
		model.addAttribute("number", number); //�۹�ȣ
		
		if(cnt > 0) {
			PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), cnt, pageBlock, pageSize);
			model.addAttribute("startPage", p.getStartPage()); //����������
			model.addAttribute("endPage", p.getEndPage());//������������
			model.addAttribute("pageBlock", p.getBlockSize());//����� ������ ����
			model.addAttribute("pageCount", p.getContentCount());//������ ����
			model.addAttribute("pageNum", p.getRequestPage());//���� ������
			model.addAttribute("blockStartNumber", p.getBlockStartNumber());
			model.addAttribute("blockEndNumber", p.getBlockEndNumber());
			
		}
		
	}
	
	
	//��������
	@Override
	public void rentDelete(HttpServletRequest req, Model model) {
		
		String car_num = req.getParameter("car_num");
		System.out.println("ī�� : " + car_num);
		int cnt = dao.rentDelete(car_num);
		
		model.addAttribute("cnt", cnt);
		
	}
	
	//��Ʈ������������
	public void getViewDetail(HttpServletRequest req, Model model) {
		
		String car_num = req.getParameter("car_num");
		
		CarInfoVO vo = dao.getViewDetail(car_num);
		
		req.setAttribute("vo", vo);
	}

	//��Ʈī �����ϱ�
	@Override
	public void rentReservation(HttpServletRequest req, Model model) {
		
		String rental_day = req.getParameter("rental_day");
		String return_day = req.getParameter("return_day");
		String rental_time = req.getParameter("rental_time");
		String return_time = req.getParameter("return_time");
		String rent_no = req.getParameter("rent_no");
		String mem_id = req.getParameter("mem_id");
		String price = req.getParameter("total1");
		String paymethod = req.getParameter("payment");
		String name = req.getParameter("name");
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		String phone3 = req.getParameter("phone3");
		String driver_kind = req.getParameter("driver_kind");
		String driver1 = req.getParameter("driver1");
		String driver2 = req.getParameter("driver2");
		String driver3 = req.getParameter("driver3");
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		String car_name =req.getParameter("car_name");
		
		String[] totals = price.split(",");
		String price1="";
		
		for(String s : totals) {
			price1 += s;
		}
		int totalPrice = Integer.parseInt(price1);
		
		
		Reservation_CarVO vo = new Reservation_CarVO();
		
		vo.setRent_no(rent_no);
		vo.setRental_day(rental_day);
		vo.setReturn_day(return_day);
		vo.setRental_time(rental_time);
		vo.setReturn_time(return_time);
		vo.setMem_id(mem_id);
		vo.setPrice(totalPrice);
		vo.setPaymethod(paymethod);
		vo.setName(name);
		vo.setPhone1(phone1);
		vo.setPhone2(phone2);
		vo.setPhone3(phone3);
		vo.setDriver_kind(driver_kind);
		vo.setDriver1(driver1);
		vo.setDriver2(driver2);
		vo.setDriver3(driver3);
		vo.setEmail1(email1);
		vo.setEmail2(email2);
		vo.setCar_name(car_name);
		
		int cnt = dao.reservation_car(vo);
		
		model.addAttribute("cnt", cnt);		
		model.addAttribute("vo", vo);

	}

	//ȣ��Ʈ ���� ����Ʈ ��ȸ
	@Override
	public void rentReservationList(HttpServletRequest req, Model model) {
		Map<String,Object> map = new HashMap<String, Object>();
		
		int pageSize = 5;  		//�� �������� ����� �� ����
		int pageBlock = 3; 		//�Ѻ��� ������ ����	
		int cnt = 0;
		String pageNum = null;
		
		//���� ����Ʈ ���� ���ϱ�
		map.put("method", "rentReservationList");
		cnt = dao.rentReservationCnt(map);
		
		System.out.println("cnt : " + cnt);
		
		pageNum = req.getParameter("requestPage");
		
		if(pageNum == null) {
			pageNum = "1"; //ù�������� 1�������� ����
		}
		
		PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), cnt, pageBlock, pageSize);
					
		//��ȸ�ϱ�	
		map.put("start", p.getStart());
		map.put("end", p.getEnd());	
		ArrayList<Reservation_CarVO> dtos = dao.rentReservationList(map);
		req.setAttribute("dtos", dtos);
		req.setAttribute("cnt", cnt); //��Ʈī ����
	
		req.setAttribute("startPage", p.getStartPage()); //����������
		req.setAttribute("endPage", p.getEndPage());//������������
		req.setAttribute("pageBlock", p.getBlockSize());//����� ������ ����
		req.setAttribute("pageCount", p.getContentCount());//������ ����
		req.setAttribute("pageNum", p.getRequestPage());//���� ������
		req.setAttribute("blockStartNumber", p.getBlockStartNumber());
		req.setAttribute("blockEndNumber", p.getBlockEndNumber());
			
		
		
	}

	//���ฮ��Ʈ ��ȸ�ϱ� - �Խ�Ʈ
	@Override
	public void rentReservationList_myPage(HttpServletRequest req, Model model) {
	Map<String,Object> resMap = new HashMap<String, Object>();	
	Map<String,Object> map = new HashMap<String, Object>();
		
		int pageSize = 3;  		//�� �������� ����� �� ����
		int pageBlock = 3; 		//�Ѻ��� ������ ����	
		int dataTotalCount = 0;
		String pageNum = null;
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");

		//���� ����Ʈ ���� ���ϱ�
		map.put("method", "rentReservationList_myPage");
		map.put("mem_id",mem_id );
		dataTotalCount = dao.rentReservationCnt(map);

		pageNum = req.getParameter("requestPage");
		
		if(pageNum == null) {
			pageNum = "1"; //ù�������� 1�������� ����
		}

		PageCalculator p = new PageCalculator(Integer.parseInt(pageNum), dataTotalCount, pageBlock, pageSize);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();
		
		String today = format.format(date); //���ó�¥
		
		List<Reservation_CarVO> vo = dao.date();
			
		if(vo != null) {			
			for (Reservation_CarVO i : vo) {
				
				int resCheck = 0;
				
				String rental_day = i.getRental_day(); //������
				String return_day = i.getReturn_day(); //�ݳ���
				String rent_no = i.getRent_no();
							
				int rentalDay = today.compareTo(rental_day);
				int returnDay = today.compareTo(return_day);
			
				if(rentalDay < 0) {
					System.out.println("���� ��� ����");
					resCheck = 0;
				}else if(rentalDay >= 0 && returnDay <= 0) {
					System.out.println("�̿���");
					resCheck = 1;
				}
				
				resMap.put(rent_no, resCheck);
			}
			
			model.addAttribute("resMap", resMap);
						
		}
			
		map.put("start", p.getStart());
		map.put("end", p.getEnd());	
		ArrayList<Reservation_CarVO> dtos = dao.rentReservationList_myPage(map);
		req.setAttribute("dtos_car", dtos);	
		req.setAttribute("cnt_car", dataTotalCount); //��Ʈī ����
	 		
		req.setAttribute("startPage_car", p.getStartPage()); //����������
		req.setAttribute("endPage_car", p.getEndPage());//������������
		req.setAttribute("pageNum_car", p.getRequestPage());//���� ������
		req.setAttribute("blockStartNumber_car", p.getBlockStartNumber());
		req.setAttribute("blockEndNumber_car", p.getBlockEndNumber());
			
	}

	//��Ʈī ���� ���
	@Override
	public void carResCancel(HttpServletRequest req, Model model) {
		
		String rent_no = req.getParameter("rent_no");
		
		int cnt = dao.carResCancel(rent_no);
		
		model.addAttribute("cnt", cnt);
		
	}

	//��Ʈī �ݳ�
	@Override
	public void carResReturn(HttpServletRequest req, Model model) {
		
		String rent_no = req.getParameter("rent_no");
		
		int cnt = dao.carResReturn(rent_no);
		
		model.addAttribute("cnt", cnt);
		
	}

	//���
	@Override
	public void rentTotal(HttpServletRequest req, Model model) {
		
		Map<String,Object> priceMap = new HashMap<String, Object>();
		Map<String,Object> kindMap = new HashMap<String, Object>();
		Map<String,Object> dateMap = new HashMap<String, Object>();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy");		
		Date date = new Date();		
		String today = format.format(date); //���ó�¥	
		
		String year = req.getParameter("year");
		
		if(year == null) {
			year = today;
		} 
			
		priceMap = dao.rentPriceTotal();
		kindMap = dao.rentKindCount();
		dateMap = dao.rentDateTotal(year);	
		
		model.addAttribute("priceMap",priceMap);
		model.addAttribute("kindMap", kindMap);
		model.addAttribute("dateMap", dateMap);
		model.addAttribute("today", year);
	}

	@Override
	public void getCharData_Car(HttpServletRequest req, Model model) {
			
		Map<String,Object> car_fristChat = new HashMap<String, Object>();
		Map<String,Object> car_secondChat = new HashMap<String, Object>();
		Map<String,Object> car_finalChat = new HashMap<String, Object>();
		
		String year = req.getParameter("year") == null ? Integer.toString(Calendar.getInstance().get(Calendar.YEAR)) : req.getParameter("year");
		
		
		int count = dao.getFirstChat_car();
		car_fristChat.put("count", count);
		
		int price = dao.getSecondChat_car();
		car_secondChat.put("price",price);
		 
		car_finalChat = dao.getFinalChat_car(year);
		
		model.addAttribute("car_fristChat", car_fristChat);
		model.addAttribute("car_secondChat", car_secondChat);
		model.addAttribute("car_finalChat", car_finalChat);
	}

}