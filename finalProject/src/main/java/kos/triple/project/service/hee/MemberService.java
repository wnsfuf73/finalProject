package kos.triple.project.service.hee;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface MemberService {

	// 회원 가입 처리
	public void inputMemberPro(HttpServletRequest req, Model model);
	
	// 아이디 중복 확인
	public void confirmId(HttpServletRequest req, Model model);
	
	// 로그인 처리
	public void loginPro(HttpServletRequest req, Model model);
	
	// 회원 상세 정보 가져오기
	public void getMemberInfo(HttpServletRequest req, Model model);
	
	// 아이디 찾기
	public void getId(HttpServletRequest req, Model model);
	
	// 비밀번호 찾기
	public void getPwd(HttpServletRequest req, Model model);
	
	// 인증키 입력 확인
	public void inputkeyPro(HttpServletRequest req, Model model);

	//회원의 비밀번호를 변경
	public void setUserPassword(HttpServletRequest req, Model model);
	
	// 이메일 체크
	public void findPwdEmailChk(HttpServletRequest req, Model model);
	
	// 회원 정보 수정 상세 페이지
	public void modifyView(HttpServletRequest req, Model model);
	
	// 회원 정보 수정 처리
	public void modifyPro(MultipartHttpServletRequest req, Model model);
	
	// 회원 탈퇴 처리
	public void deletePro(HttpServletRequest req, Model model);

	//프로필이미지를 업로드
	public void faceImgUpload(MultipartHttpServletRequest req, Model model);



	




}
