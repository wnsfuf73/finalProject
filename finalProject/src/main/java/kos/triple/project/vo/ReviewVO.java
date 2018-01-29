package kos.triple.project.vo;

import java.sql.Date;

public class ReviewVO {
	
	private int reviewNo;			//리뷰번호
	private int reviewview;			//경치
	private int fun;				//재미
	private int near;				//접근성
	private int price;				//비용
	private String content;			//내용
	private String reviewImg;		//이미지
	private Date regdate;		//방문일자
	private String mem_id;			//아이디
	private String location_num;	//방문장소
	private String location_name;	//방문장소이름
	
	
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getReviewview() {
		return reviewview;
	}
	public void setReviewview(int reviewview) {
		this.reviewview = reviewview;
	}
	public int getFun() {
		return fun;
	}
	public void setFun(int fun) {
		this.fun = fun;
	}
	public int getNear() {
		return near;
	}
	public void setNear(int near) {
		this.near = near;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getLocation_num() {
		return location_num;
	}
	public void setLocation_num(String location_num) {
		this.location_num = location_num;
	}

}
