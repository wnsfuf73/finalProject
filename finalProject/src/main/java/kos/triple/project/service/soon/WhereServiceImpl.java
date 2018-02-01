package kos.triple.project.service.soon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.etc.ServerSetting;
import kos.triple.project.persistence.soon.WhereDAO;
import kos.triple.project.vo.WhereVO;

@Service
public class WhereServiceImpl implements WhereService {

	@Autowired
	WhereDAO dao;

	@Override
	public void Where_main(HttpServletRequest req, Model model) {
		String area = req.getParameter("area");
		String thema = req.getParameter("thema");

		System.out.println(area + "|" + thema);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("area", area);
		map.put("thema", thema);

		ArrayList<WhereVO> vo_spots = dao.where_spot(map);
		model.addAttribute("vo_spots", vo_spots);
		model.addAttribute("area", area);
		model.addAttribute("thema", thema);
	}

	@Override
	public void detail_view(HttpServletRequest req, Model model) {
		String location_num = req.getParameter("location_num");

		WhereVO vo = dao.detail_view(location_num);
		model.addAttribute("vo", vo);
	}

	@Override
	public void detail_view_score(HttpServletRequest req, Model model) {
		String location_num = req.getParameter("location_num");
		String like_score = req.getParameter("like_score");
		String normal_score = req.getParameter("normal_score");
		String bad_score = req.getParameter("bad_score");
		System.out.println("���ƿ� ��ġ : " + like_score);
		System.out.println("���� ���� : " + normal_score);
		System.out.println("�Ⱦ� ���� : " + bad_score);

		int cnt = 0;

		if (like_score.equals("1")) {
			cnt = dao.like_score(location_num);
			System.out.println("���ƿ�");
		} else if (normal_score.equals("1")) {
			cnt = dao.normal_score(location_num);
			System.out.println("�����̿���");
		} else if (bad_score.equals("1")) {
			cnt = dao.bad_score(location_num);
			System.out.println("�Ⱦ��");
		}
		model.addAttribute("cnt", cnt);
		model.addAttribute("location_num", location_num);
	}

	@Override
	public void search(HttpServletRequest req, Model model) {
		String search = req.getParameter("search");
		System.out.println("�˻� 1: " + search);
		// �Խñ� ��� ��ȸ
		ArrayList<WhereVO> vo_search = dao.search(search);
		model.addAttribute("vo_search", vo_search); // ū �ٱ��� : �Խñ� ���, ���� �ٱ��� : �Խñ� 1��

	}

	///////////////////////////////// ������/////////////////////////////////

	@Override
	public void Where_list(HttpServletRequest req, Model model) {
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

			ArrayList<WhereVO> vos = dao.where_list(map);
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
	public void Where_add(MultipartHttpServletRequest req, Model model) {
		
		MultipartFile file1 = req.getFile("where_Images1");
		MultipartFile file2 = req.getFile("where_Images2");
		MultipartFile file3 = req.getFile("where_Images3");
		MultipartFile file4 = req.getFile("where_Images4");

		System.out.println("�̹��� Ȯ��");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/where/trip_location"); // ����

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\where\\trip_location\\"; // ����
		// ���
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String fileName1 = null;
		String fileName2 = null;
		String fileName3 = null;
		String fileName4 = null;

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

			String location_name = req.getParameter("where_Name");
			String location_addr = req.getParameter("where_Address");
			String detail_info = req.getParameter("where_Info");
			String location_web = req.getParameter("where_Web");
			String x_coordinate = req.getParameter("where_X");
			String y_coordinate = req.getParameter("where_Y");
			String open_time = req.getParameter("where_Open");
			String close_time = req.getParameter("where_Close");
			String area = req.getParameter("where_Area");
			String thema_category = req.getParameter("where_Thema");

			WhereVO dto = new WhereVO();

			dto.setLocation_img1(fileName1);
			dto.setLocation_img2(fileName2);
			dto.setLocation_img3(fileName3);
			dto.setLocation_img4(fileName4);
			dto.setLocation_name(location_name);
			dto.setLocation_addr(location_addr);
			dto.setDetail_info(detail_info);
			dto.setLocation_web(location_web);
			dto.setX_coordinate(x_coordinate);
			dto.setY_coordinate(y_coordinate);
			dto.setOpen_time(open_time);
			dto.setClose_time(close_time);
			dto.setArea(area);
			dto.setThema_category(thema_category);

			int cnt = dao.where_add(dto);

			model.addAttribute("cnt", cnt);

	}

	@Override
	public void Where_check(HttpServletRequest req, Model model) {
		String location_num = req.getParameter("location_num");

		WhereVO vo = dao.where_check(location_num);
		model.addAttribute("vo", vo);
	}

	@Override
	public void Where_delete(HttpServletRequest req, Model model) {
		String location_num = req.getParameter("location_num");

		int cnt = dao.delete(location_num);

		model.addAttribute("cnt", cnt);

	}

	@Override
	public void Where_modify(HttpServletRequest req, Model model) {
		String location_num = req.getParameter("location_num");

		WhereVO vo = dao.modify(location_num);
		model.addAttribute("vo", vo);
	}

	@Override
	public void Where_modify_Pro(MultipartHttpServletRequest req, Model model) {
		
		String location_num = req.getParameter("location_num");
		String location_name = req.getParameter("where_Name");
		String location_addr = req.getParameter("where_Address");
		String detail_info = req.getParameter("where_Info");
		String location_web = req.getParameter("where_Web");
		String x_coordinate = req.getParameter("where_X");
		String y_coordinate = req.getParameter("where_Y");
		String open_time = req.getParameter("where_Open");
		String close_time = req.getParameter("where_Close");
		String area = req.getParameter("where_Area");
		String thema_category = req.getParameter("where_Thema");
		
		Map<String,Object> imgMap = new HashMap<String,Object>();
		imgMap.put("location_num", location_num);
		
		MultipartFile file1 = req.getFile("where_Images1");
		MultipartFile file2 = req.getFile("where_Images2");
		MultipartFile file3 = req.getFile("where_Images3");
		MultipartFile file4 = req.getFile("where_Images4");

		String saveDir = req.getSession().getServletContext().getRealPath("/resources/images/where/trip_location"); // ����

		String realDir = ServerSetting.imgPath+"\\src\\main\\webapp\\resources\\images\\where\\trip_location\\"; // ����
		// ���
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String fileName1 = null;
		String fileName2 = null;
		String fileName3 = null;
		String fileName4 = null;
		
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
		

		WhereVO dto = new WhereVO();

		dto.setLocation_img1(fileName1);
		dto.setLocation_img2(fileName2);
		dto.setLocation_img3(fileName3);
		dto.setLocation_img4(fileName4);
		
		dto.setLocation_num(location_num);
		dto.setLocation_name(location_name);
		dto.setLocation_addr(location_addr);
		dto.setDetail_info(detail_info);
		dto.setLocation_web(location_web);
		dto.setX_coordinate(x_coordinate);
		dto.setY_coordinate(y_coordinate);
		dto.setOpen_time(open_time);
		dto.setClose_time(close_time);
		dto.setArea(area);
		dto.setThema_category(thema_category);

		int cnt = dao.modify_pro(dto);

		model.addAttribute("cnt", cnt);

	}

}
