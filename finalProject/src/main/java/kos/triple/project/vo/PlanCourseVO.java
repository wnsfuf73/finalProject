package kos.triple.project.vo;

import java.sql.Date;

public class PlanCourseVO {
	
	private String planTitle;		//��ȹ��
	private int plan_courseNo;		//�ڽ���ȣ
	private String location_num;	//�湮���
	private int planOrder;			//�湮����
	private Date dday;				//�湮 ��¥
	private int planNo; 			//��ȹ��ȣ
	private String location_name;	//������
	
	
	
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
