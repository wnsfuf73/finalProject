package kos.triple.project.mobile.vo;

import java.sql.Timestamp;

public class AirReservationSearchVO {

    private String airPlaneNo;//
    private String airPlaneName;
    private int premium;
    private int highClass;
    private int nomal;
    private String routeNo;//
    private String route1;
    private String route2;
    private String route3;
    private Timestamp startTime;
    private Timestamp midTime;
    private Timestamp arrivalTime;
    private String seatPriceCode;//
    private int distance1;
    private int distance2;
    private int resultDistance;
    private int premium_A;
    private int premium_B;
    private int premium_C;
    private int highClass_A;
    private int highClass_B;
    private int highClass_C;
    private int nomal_A;
    private int nomal_B;
    private int nomal_C;

    public AirReservationSearchVO(){

    }
    

    public AirReservationSearchVO(String airPlaneNo, String airPlaneName, int premium, int highClass, int nomal,
			String routeNo, String route1, String route2, String route3, Timestamp startTime, Timestamp midTime,
			Timestamp arrivalTime, String seatPriceCode, int distance1,int distance2 , int resultDistance,int premium_A, int premium_B, int premium_C, int highClass_A,
			int highClass_B, int highClass_C, int nomal_A, int nomal_B, int nomal_C) {
		super();
		this.airPlaneNo = airPlaneNo;
		this.airPlaneName = airPlaneName;
		this.premium = premium;
		this.highClass = highClass;
		this.nomal = nomal;
		this.routeNo = routeNo;
		this.route1 = route1;
		this.route2 = route2;
		this.route3 = route3;
		this.startTime = startTime;
		this.midTime = midTime;
		this.arrivalTime = arrivalTime;
		this.seatPriceCode = seatPriceCode;
		this.premium_A = premium_A;
		this.premium_B = premium_B;
		this.premium_C = premium_C;
		this.highClass_A = highClass_A;
		this.highClass_B = highClass_B;
		this.highClass_C = highClass_C;
		this.nomal_A = nomal_A;
		this.nomal_B = nomal_B;
		this.nomal_C = nomal_C;
		this.distance1 = distance1;
		this.distance2 = distance2;
		this.resultDistance = resultDistance;
	}


	public String getRouteNo() {
		return routeNo;
	}


	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}


	public String getSeatPriceCode() {
		return seatPriceCode;
	}


	public void setSeatPriceCode(String seatPriceCode) {
		this.seatPriceCode = seatPriceCode;
	}


	public int getResultDistance() {
		return resultDistance;
	}


	public void setResultDistance(int resultDistance) {
		this.resultDistance = resultDistance;
	}


	public String getAirPlaneName() {
        return airPlaneName;
    }

    public void setAirPlaneName(String airPlaneName) {
        this.airPlaneName = airPlaneName;
    }

    public String getAirPlaneNo() {
        return airPlaneNo;
    }

    public void setAirPlaneNo(String airPlaneNo) {
        this.airPlaneNo = airPlaneNo;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }
    
    public int getDistance1() {
		return distance1;
	}


	public void setDistance1(int distance1) {
		this.distance1 = distance1;
	}


	public int getDistance2() {
		return distance2;
	}


	public void setDistance2(int distance2) {
		this.distance2 = distance2;
	}


	public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getHighClass() {
        return highClass;
    }

    public void setHighClass(int highClass) {
        this.highClass = highClass;
    }

    public int getHighClass_A() {
        return highClass_A;
    }

    public void setHighClass_A(int highClass_A) {
        this.highClass_A = highClass_A;
    }

    public int getHighClass_B() {
        return highClass_B;
    }

    public void setHighClass_B(int highClass_B) {
        this.highClass_B = highClass_B;
    }

    public int getHighClass_C() {
        return highClass_C;
    }

    public void setHighClass_C(int highClass_C) {
        this.highClass_C = highClass_C;
    }

    public Timestamp getMidTime() {
        return midTime;
    }

    public void setMidTime(Timestamp midTime) {
        this.midTime = midTime;
    }

    public int getNomal() {
        return nomal;
    }

    public void setNomal(int nomal) {
        this.nomal = nomal;
    }

    public int getNomal_A() {
        return nomal_A;
    }

    public void setNomal_A(int nomal_A) {
        this.nomal_A = nomal_A;
    }

    public int getNomal_B() {
        return nomal_B;
    }

    public void setNomal_B(int nomal_B) {
        this.nomal_B = nomal_B;
    }

    public int getNomal_C() {
        return nomal_C;
    }

    public void setNomal_C(int nomal_C) {
        this.nomal_C = nomal_C;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public int getPremium_A() {
        return premium_A;
    }

    public void setPremium_A(int premium_A) {
        this.premium_A = premium_A;
    }

    public int getPremium_B() {
        return premium_B;
    }

    public void setPremium_B(int premium_B) {
        this.premium_B = premium_B;
    }

    public int getPremium_C() {
        return premium_C;
    }

    public void setPremium_C(int premium_C) {
        this.premium_C = premium_C;
    }

    public String getRoute1() {
        return route1;
    }

    public void setRoute1(String route1) {
        this.route1 = route1;
    }

    public String getRoute2() {
        return route2;
    }

    public void setRoute2(String route2) {
        this.route2 = route2;
    }

    public String getRoute3() {
        return route3;
    }

    public void setRoute3(String route3) {
        this.route3 = route3;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
