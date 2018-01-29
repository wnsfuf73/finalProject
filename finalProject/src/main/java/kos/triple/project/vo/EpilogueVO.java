package kos.triple.project.vo;

import java.sql.Timestamp;
import java.util.List;

public class EpilogueVO {
	private int epilogueNo;
	private String title;
	private String type;
	private String kind;
	private String content;
	private int readCnt;
	private String security;
	private int goodCount;
	private String mem_id;
	private Timestamp reg_date;
	
	private MemberVO member;
	private List<Epilogue_LikeVO> eLikes;
	private List<Epilogue_commentVO> eComments;
	
	private List<Epilogue_courseVO> courses;
	
	public EpilogueVO() {

	}

	public EpilogueVO(int epilogueNo, String title, String type, String kind, String content, int readCnt, String security,
			int goodCount, String mem_id, Timestamp reg_date, MemberVO member,
			List<Epilogue_LikeVO> eLikes, List<Epilogue_commentVO> eComments, List<Epilogue_courseVO> courses) {
		super();
		this.epilogueNo = epilogueNo;
		this.title = title;
		this.type = type;
		this.kind = kind;
		this.content = content;
		this.readCnt = readCnt;
		this.security = security;
		this.goodCount = goodCount;
		this.mem_id = mem_id;
		this.reg_date = reg_date;
		this.member = member;
		this.eLikes = eLikes;
		this.eComments = eComments;
		this.courses = courses;
	}

	public int getEpilogueNo() {
		return epilogueNo;
	}

	public void setEpilogueNo(int epilogueNo) {
		this.epilogueNo = epilogueNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public int getGoodCount() {
		return goodCount;
	}

	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}


	public List<Epilogue_LikeVO> geteLikes() {
		return eLikes;
	}

	public void seteLikes(List<Epilogue_LikeVO> eLikes) {
		this.eLikes = eLikes;
	}

	public List<Epilogue_commentVO> geteComments() {
		return eComments;
	}

	public void seteComments(List<Epilogue_commentVO> eComments) {
		this.eComments = eComments;
	}

	public List<Epilogue_courseVO> getCourses() {
		return courses;
	}

	public void setCourses(List<Epilogue_courseVO> courses) {
		this.courses = courses;
	}
	
}