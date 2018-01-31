package kos.triple.project.service.hee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kos.triple.project.etc.AuthenticationKeyCreate;
import kos.triple.project.etc.ServerSetting;
import kos.triple.project.persistence.hee.MemberDAO;
import kos.triple.project.vo.MemberVO;
import kos.triple.project.vo.RentCarVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;

	// ȸ�� ���� ó��HttpServletRequest 
	@Override
	public void inputMemberPro(HttpServletRequest req, Model model) {
		
		
		MemberVO vo = new MemberVO();

		vo.setMem_id(req.getParameter("mem_id"));
		vo.setName(req.getParameter("name"));
		vo.setPassword(req.getParameter("password"));

		String email = req.getParameter("email");
		String[] tmp = email.split("@");

		vo.setEmail1(tmp[0]);
		vo.setEmail2(tmp[1]);

		vo.setSex(req.getParameter("sex"));

		/*String phone =req.getParameter("phone");
		String p1 = phone.substring(0, 3);
		String p2 = phone.substring(3, 7);
		String p3 = phone.substring(7);

		vo.setPhone1(p1);
		vo.setPhone2(p2);
		vo.setPhone3(p3);
		 */
		vo.setPhone1("010");
		vo.setPhone2("1111");
		vo.setPhone3("1111");
		
		vo.setBirth(req.getParameter("birth"));
		vo.setGrade("�Ϲ�");
		
		vo.setFaceImg(""); //null
		vo.setIntroduce(""); // null

		System.out.println("id" + vo.getMem_id());
		System.out.println(vo.getName());

		System.out.println("pwd" + vo.getPassword());

		System.out.println(vo.getEmail1());
		System.out.println(vo.getEmail2());

		System.out.println(vo.getSex());

		System.out.println("p1" + vo.getPhone1());
		System.out.println(vo.getPhone2());
		System.out.println(vo.getPhone3());

		System.out.println(vo.getBirth());

		System.out.println(vo.getGrade());

		int cnt = dao.inputMemberPro(vo);

		model.addAttribute("cnt", cnt);
	}

	// ���̵� �ߺ� Ȯ��
	@Override
	public void confirmId(HttpServletRequest req, Model model) {
		int cnt = 0;
		String id = req.getParameter("id");
		System.out.println("idCheck() �� : " + id);
		
		cnt = dao.idCheck(id);
		
		req.setAttribute("cnt",Integer.toString(cnt) );
		
	}

	// �α��� ó��
	@Override
	public void loginPro(HttpServletRequest req, Model model) {

		String mem_id = req.getParameter("mem_id");  // userId
		String password = req.getParameter("password");// userPassowrd

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", mem_id);
		map.put("password", password);

		int cnt = dao.loginPro(map);

		if (cnt == 1) {
			if (mem_id.equals("host")) {
				model.addAttribute("token", "admin");
			} else {
				model.addAttribute("token", "user");
			}
			req.getSession().setAttribute("mem_id", mem_id);
		}

		model.addAttribute("cnt", cnt);
	}

	// ȸ�� �� ���� ��������
	@Override
	public void getMemberInfo(HttpServletRequest req, Model model) {

		String mem_id = (String) req.getSession().getAttribute("mem_id");
		String password = req.getParameter("password"); // userPassword

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", mem_id);
		map.put("password", password);

		int cnt = dao.loginPro(map);

		if (cnt == 1) {

			MemberVO vo = dao.getMemberInfo(mem_id);

			model.addAttribute("vo", vo);
		}

		model.addAttribute("cnt", cnt);
	}

	// ���̵� ã��
	@Override
	public void getId(HttpServletRequest req, Model model) {

		String name = req.getParameter("name");
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("email1", email1);
		map.put("email2", email2);

		MemberVO vo = dao.getId(map);

		model.addAttribute("vo", vo);

	}
	
	// ��й�ȣ ã��
	@Override
	public void getPwd(HttpServletRequest req, Model model) {
		String name = req.getParameter("name");
		String mem_id = req.getParameter("mem_id");
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("mem_id", mem_id);
		map.put("email1", email1);
		map.put("email2", email2);
			
		
		//eee
		int cnt = dao.getPwd(map);
		
		//ȸ�������� �´°��
		if(cnt==1) {
			//����Ű����
			String key = new AuthenticationKeyCreate().getKey();
			
			//sendEmail(emailAddr,key); 
			
			map.put("authentication_key",key);
			cnt = dao.setMemberKey(map);
			
			model.addAttribute("mem_id",mem_id);
			model.addAttribute("cnt", cnt);
			
			//�̸��� ������ �õ��Ѵ�
			dao.sendMail(email1+"@"+email2, key);
		}
		else {
			//ȸ�������� ���� �ʴ°��
			model.addAttribute("cnt", cnt);
		}

	}
	
	// ����Ű �Է� Ȯ��
	@Override
	public void inputkeyPro(HttpServletRequest req, Model model) {
		
		String key = req.getParameter("key");
		String mem_id = req.getParameter("mem_id");
		
		String getAuthenticationKey  = dao.inputKeyPro(mem_id);
		
		if(key.equals(getAuthenticationKey)) {
			//����
			model.addAttribute("mem_id",mem_id);
			model.addAttribute("cnt",1);
		}
		else {
			//�ٸ���...
			model.addAttribute("cnt",0);
		}
		
	}

	// ������ȣ Ȯ�� �� ��й�ȣ ����
	@Override
	public void setUserPassword(HttpServletRequest req, Model model) {
		
		String password = req.getParameter("password");
		String mem_id = req.getParameter("mem_id");
		
		MemberVO vo = new MemberVO();
		vo.setPassword(password);
		vo.setMem_id(mem_id);
		
		int cnt = dao.setUserPassword_proc(vo);

		req.setAttribute("cnt",cnt);
		
	}
	
	// �̸��� üũ
	@Override
	public void findPwdEmailChk(HttpServletRequest req, Model model) {

		MemberVO vo = new MemberVO();
		
		String email = req.getParameter("email");
		
		String[] tmp = email.split("@");

		vo.setEmail1(tmp[0]);
		vo.setEmail2(tmp[1]);
		
		req.getSession().setAttribute("email", email);

		System.out.println("email : " + email);

		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();

		for (int i = 0; i < 6; i++) {
			int rIndex = rnd.nextInt(2);
			switch (rIndex) {
			case 0:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 1:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}

		String key = temp.toString();// StringBuffer ������ Key�� String���� ��ȯ
		
		req.getSession().setAttribute("key", key);
		
		model.addAttribute("cnt", 1);
	}
	
	// ȸ�� ���� ���� �� ������
	@Override
	public void modifyView(HttpServletRequest req, Model model) {
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		String password = req.getParameter("password");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", mem_id);
		map.put("password", password);
		
		int cnt = dao.loginPro(map);
		
		if(cnt == 1) {
			
			MemberVO vo = dao.getMemberInfo(mem_id);
			System.out.println("--------------");
			System.out.println(vo.getSex());
			model.addAttribute("vo", vo);
		}
		
		
		model.addAttribute("cnt", cnt);
	}

	
	// ȸ�� ���� ���� ó��
	@Override
	public void modifyPro(MultipartHttpServletRequest req, Model model) {
		
		MemberVO vo = new MemberVO();
		
		// ���̵�
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		
		vo.setMem_id(mem_id);
		
		// ��й�ȣ
		String password= req.getParameter("password");
		vo.setPassword(password);
		//vo.setPassword(req.getParameter("password"));
		
		// �̸�
		String name= req.getParameter("name");
		vo.setName(name);
		//vo.setName(req.getParameter("name"));
		
		// ��ȭ��ȣ
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		String phone3 = req.getParameter("phone3");
		
		vo.setPhone1(phone1);
		vo.setPhone2(phone2);
		vo.setPhone3(phone3);
		
		/*vo.setPhone1(req.getParameter("phone1"));
		vo.setPhone2(req.getParameter("phone2"));
		vo.setPhone3(req.getParameter("phone3"));*/
		
		
		// �̸���
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		
		vo.setEmail1(email1);
		vo.setEmail2(email2);
		
		/*	vo.setEmail1(req.getParameter("email1"));
		vo.setEmail2(req.getParameter("email2"));*/
		
		// ����
		String birth=req.getParameter("birth");
		vo.setBirth(birth);
		
		/*	vo.setBirth(req.getParameter("birth"));*/
		
		
		// ���
		String grade = req.getParameter("grade");
		vo.setGrade(grade);
		
		// �Ұ�

		String introduce = req.getParameter("introduce");
		vo.setIntroduce(introduce);
		
		int cnt = dao.updateMember(vo);
		
		model.addAttribute("cnt", cnt);
		
	}

	// ȸ�� Ż�� ó��
	@Override
	public void deletePro(HttpServletRequest req, Model model) {
		
		String mem_id = (String)req.getSession().getAttribute("mem_id");
		String password = req.getParameter("password");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", mem_id);
		map.put("password", password);
		
		int selectCnt = dao.loginPro(map);
		int deleteCnt = 0;
		
		if(selectCnt == 1) {
			deleteCnt = dao.deleteMember(mem_id);
		}
		
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("deleteCnt", deleteCnt);
		
	}

	@Override
	public void faceImgUpload(MultipartHttpServletRequest req, Model model) {

		MultipartFile file = req.getFile("uploadFile");
		
		int maxSize = 10 * 1024 * 1024;
		
		String saveDir = req.getRealPath("/resources/images/userFaceImg/");
		
		String realDir = ServerSetting.imgPath+"/src/main/webapp/resources/images/userFaceImg/";
		
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
				
			MemberVO vo = new MemberVO();
			
			String fileName = file.getOriginalFilename();
			
			vo.setMem_id((String)req.getSession().getAttribute("mem_id"));
			vo.setFaceImg(fileName);
			
			int cnt = dao.faceImgUpload_proc(vo);
			
			model.addAttribute("cnt", cnt);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

		
	
}
