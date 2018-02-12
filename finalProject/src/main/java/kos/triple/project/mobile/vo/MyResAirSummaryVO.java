package kos.triple.project.mobile.vo;

import java.sql.Timestamp;

public class MyResAirSummaryVO {

	private int airResNo;
	private int memsize;
	private String paymethod;
	private int price;
	private String airPlaneNo;
	private String startLocation;
	private String endLocation;
	private Timestamp startTime;
	private Timestamp resTime;
	private String selectInfo;
	private String airPlaneName;

	public MyResAirSummaryVO() {
	}

	public MyResAirSummaryVO(int airResNo, int memsize, String paymethod, int price, String airPlaneNo,
			String startLocation, String endLocation, Timestamp startTime, Timestamp resTime
			,String selectInfo,String airPlaneName) {
		super();
		this.airResNo = airResNo;
		this.memsize = memsize;
		this.paymethod = paymethod;
		this.price = price;
		this.airPlaneNo = airPlaneNo;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.startTime = startTime;
		this.resTime = resTime;
		this.selectInfo = selectInfo;
		this.airPlaneName = airPlaneName;
	}
	
	
	public String getAirPlaneName() {
		return airPlaneName;
	}

	public void setAirPlaneName(String airPlaneName) {
		this.airPlaneName = airPlaneName;
	}

	public String getSelectInfo() {
		return selectInfo;
	}

	public void setSelectInfo(String selectInfo) {
		this.selectInfo = selectInfo;
	}

	public int getAirResNo() {
		return airResNo;
	}

	public void setAirResNo(int airResNo) {
		this.airResNo = airResNo;
	}

	public int getMemsize() {
		return memsize;
	}

	public void setMemsize(int memsize) {
		this.memsize = memsize;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAirPlaneNo() {
		return airPlaneNo;
	}

	public void setAirPlaneNo(String airPlaneNo) {
		this.airPlaneNo = airPlaneNo;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getResTime() {
		return resTime;
	}

	public void setResTime(Timestamp resTime) {
		this.resTime = resTime;
	}

}
