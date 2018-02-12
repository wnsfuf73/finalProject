package kos.triple.project.mobile.vo;

import java.sql.Timestamp;

public class EpilogueMobileVO {

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
	private String front_img;
	
	public EpilogueMobileVO() {}
	
	public EpilogueMobileVO(int epilogueNo, String title, String type, String kind, String content, int readCnt,
			String security, int goodCount, String mem_id, Timestamp reg_date , String front_img) {
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
		this.front_img = front_img;
	}
	
	public String getFront_img() {
		return front_img;
	}

	public void setFront_img(String front_img) {
		this.front_img = front_img;
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
	
	
	
	
}
