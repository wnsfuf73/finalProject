package kos.triple.project.vo;

public class AirReservationSearchVO {
	
	private RouteVO r;
	private AirPlaneVO a;
	private SeatPriceVO s;
	
	public AirReservationSearchVO() {

	}

	public AirReservationSearchVO(RouteVO r, AirPlaneVO a, SeatPriceVO s) {
		super();
		this.r = r;
		this.a = a;
		this.s = s;
	}

	public RouteVO getR() {
		return r;
	}

	public void setR(RouteVO r) {
		this.r = r;
	}

	public AirPlaneVO getA() {
		return a;
	}

	public void setA(AirPlaneVO a) {
		this.a = a;
	}

	public SeatPriceVO getS() {
		return s;
	}

	public void setS(SeatPriceVO s) {
		this.s = s;
	}
	
	
	
}
