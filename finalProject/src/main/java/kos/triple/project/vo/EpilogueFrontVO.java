package kos.triple.project.vo;

import java.sql.Timestamp;
import java.util.List;

public class EpilogueFrontVO {

	private int seq;
	private int epilogueNo;
	private String title;
	private String type;
	private String kind;
	private String mem_id;
	private String img1;
	private Timestamp reg_date;
	private int readcnt;
	private int goodcount;

	private int commentCount;
	List<String> visitOrder;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getGoodcount() {
		return goodcount;
	}
	public void setGoodcount(int goodcount) {
		this.goodcount = goodcount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public List<String> getVisitOrder() {
		return visitOrder;
	}
	public void setVisitOrder(List<String> visitOrder) {
		this.visitOrder = visitOrder;
	}
	
	
	

}