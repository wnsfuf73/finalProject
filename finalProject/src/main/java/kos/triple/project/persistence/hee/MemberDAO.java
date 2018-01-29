package kos.triple.project.persistence.hee;

import java.util.Map;

import kos.triple.project.vo.MemberVO;

public interface MemberDAO {
	
	// 로그인 처리
	public int loginPro(Map<String, Object> map);
	
	// 회원 정보 가져오기
	public MemberVO getMemberInfo(String mem_id);
	
	// 회원 가입 처리
	public int inputMemberPro(MemberVO vo);
		
	// 아이디 중복 확인 체크
	public int idCheck(String mem_id);
	
	// 아이디  찾기
	public MemberVO getId(Map<String, Object> map); /*String name, String email1, String email2*/
	
	// 비밀번호 찾기
	public int getPwd(Map<String, Object> map);
	
	// 회원 정보 수정
	public int updateMember(MemberVO vo);
	
	// 회원 탈퇴 처리
	public int deleteMember(String mem_id);
	
	// 비밀번호 찾기 - 이메일 보내기
	public void sendMail(String email, String key);

	// 인증키 생성
	public int setMemberKey(Map<String, Object> map);
	
	// 인증키 확인 처리
	public String inputKeyPro(String mem_id);

	// 인증번호 확인 후 비밀번호 변경
	public int setUserPassword_proc(MemberVO vo);

	//회원의 프로필 이미지를 저장
	public int faceImgUpload_proc(MemberVO vo);
	
	
}
