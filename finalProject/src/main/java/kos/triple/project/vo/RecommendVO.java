package kos.triple.project.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class RecommendVO {
	
	private int epilogueNo;
	private String title;
	private char type;
	private String kind;
	private String content;
	private int totalCount;
	private char security;
	private int goodCount;
	private String mem_id;
	private Timestamp reg_date;
	private int epilogue_courseNo;
	private String location_num;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private int visit_order;
	private Date dday;
	private WhereVO where;
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
	public char getType() {
		return type;
	}
	public void setType(char type) {
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public char getSecurity() {
		return security;
	}
	public void setSecurity(char security) {
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
	public int getEpilogue_courseNo() {
		return epilogue_courseNo;
	}
	public void setEpilogue_courseNo(int epilogue_courseNo) {
		this.epilogue_courseNo = epilogue_courseNo;
	}
	public String getLocation_num() {
		return location_num;
	}
	public void setLocation_num(String location_num) {
		this.location_num = location_num;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public int getVisit_order() {
		return visit_order;
	}
	public void setVisit_order(int visit_order) {
		this.visit_order = visit_order;
	}
	public Date getDday() {
		return dday;
	}
	public void setDday(Date dday) {
		this.dday = dday;
	}
	public WhereVO getWhere() {
		return where;
	}
	public void setWhere(WhereVO where) {
		this.where = where;
	}

	
}
