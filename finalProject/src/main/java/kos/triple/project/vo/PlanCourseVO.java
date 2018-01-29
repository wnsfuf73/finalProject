package kos.triple.project.vo;

import java.sql.Date;

public class PlanCourseVO {
	
	private String planTitle;		//계획명
	private int plan_courseNo;		//코스번호
	private String location_num;	//방문장소
	private int planOrder;			//방문순서
	private Date dday;				//방문 날짜
	private int planNo; 			//계획번호
	private String location_name;	//지역명
	
	
	
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public String getPlanTitle() {
		return planTitle;
	}
	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}
	public int getPlan_courseNo() {
		return plan_courseNo;
	}
	public void setPlan_courseNo(int plan_courseNo) {
		this.plan_courseNo = plan_courseNo;
	}
	public String getLocation_num() {
		return location_num;
	}
	public void setLocation_num(String location_num) {
		this.location_num = location_num;
	}
	public int getPlanOrder() {
		return planOrder;
	}
	public void setPlanOrder(int planOrder) {
		this.planOrder = planOrder;
	}
	public Date getDday() {
		return dday;
	}
	public void setDday(Date dday) {
		this.dday = dday;
	}
	public int getPlanNo() {
		return planNo;
	}
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}
	
}
