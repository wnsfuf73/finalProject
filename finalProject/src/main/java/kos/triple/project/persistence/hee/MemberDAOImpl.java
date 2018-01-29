package kos.triple.project.persistence.hee;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import kos.triple.project.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	private JavaMailSender mailSender;
	
	// 회원 가입 처리
	@Override
	public int inputMemberPro(MemberVO vo) {

		int cnt = 0;

		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		cnt = dao.inputMemberPro(vo);
		
		return cnt;
	}

	// 아이디 중복 확인 체크
	@Override
	public int idCheck(String mem_id) {

		int cnt = 0;

		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		
		cnt = dao.idCheck(mem_id);	

		if(cnt == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}

	// 로그인 처리
	@Override
	public int loginPro(Map<String, Object> map) {

		int cnt = 0;

		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);

		int idChkCnt = dao.idCheck((String) map.get("mem_id"));
		
		System.out.println("4 아이디 : " + map.get("mem_id"));

		if (idChkCnt == 1) {

			int pwdChkCnt = dao.loginPro(map);

			if (pwdChkCnt == 1) {

				cnt = 1;
				
			} else {

				cnt = 0;
			}
		}else {
			
			cnt = -1;
		}
		
		return cnt;
	}

	// 회원 상세 정보 가져오기
	@Override
	public MemberVO getMemberInfo(String mem_id) {

		MemberVO vo = null;
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		vo = dao.getMemberInfo(mem_id);
		
		return vo;
	}

	// 아이디 찾기 처리
	public MemberVO getId(Map<String, Object> map) {
		
		MemberVO vo = null;
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		vo = dao.getId(map);
				
		return vo;
	}
	
	// 비밀번호 찾기 처리
	public int getPwd(Map<String, Object> map) {
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		int cnt = dao.getPwd(map);
		return cnt;
	}

	// 회원 정보 수정
	@Override
	public int updateMember(MemberVO vo) {

		int cnt = 0;
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		cnt = dao.updateMember(vo);
		
		return cnt;
	}

	// 회원 탈퇴
	@Override
	public int deleteMember(String mem_id) {

		int cnt = 0;
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		cnt = dao.deleteMember(mem_id);
		
		return cnt;
	}

	@Override
	public void sendMail(String email, String key) {
	
		try{
			
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("admin@donghang.com");
            message.setTo(email);
            message.setSubject(" 비밀번호 찾기 인증메일");
            message.setText("인증번호를 입력하세요 : " + key + "<br>");
 
            mailSender.send(message);
       
		}catch(Exception e){
            e.printStackTrace();
        }   
	
	}

	// 인증키 생성
	@Override
	public int setMemberKey(Map<String, Object> map) {
		
		int cnt = 0;
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		cnt = dao.setMemberKey(map);
		
		return cnt;
	}

	// 인증키 확인 처리
	@Override
	public String inputKeyPro(String mem_id) {
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		String getKey = dao.inputKeyPro(mem_id);
		
		return getKey;
	}

	// 인증번호 확인 후 비밀번호 변경
	@Override
	public int setUserPassword_proc(MemberVO vo) {
		
		int cnt = 0;
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		cnt = dao.setUserPassword_proc(vo);
		
		return cnt;
	}

	@Override
	public int faceImgUpload_proc(MemberVO vo) {
		
		int cnt = 0;
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		cnt = dao.faceImgUpload_proc(vo);
		
		return cnt;
	}


}
