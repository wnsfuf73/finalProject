package kos.triple.project.mobile.vo;

import java.sql.Timestamp;

public class MyResStayReservationVO {

    private int stayResNo;
    private String hotelName;
    private String roomName;
    private Timestamp check_in;
    private Timestamp check_out;
    private int price;
    private Timestamp stayResDate;

    public MyResStayReservationVO() {
    }

    public MyResStayReservationVO(int stayResNo, String hotelName, String roomName, Timestamp check_in, Timestamp check_out,
                                  int price, Timestamp stayResDate) {
        super();
        this.stayResNo = stayResNo;
        this.hotelName = hotelName;
        this.roomName = roomName;
        this.check_in = check_in;
        this.check_out = check_out;
        this.price = price;
        this.stayResDate = stayResDate;
    }

    public int getStayResNo() {
        return stayResNo;
    }

    public void setStayResNo(int stayResNo) {
        this.stayResNo = stayResNo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Timestamp getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Timestamp check_in) {
        this.check_in = check_in;
    }

    public Timestamp getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Timestamp check_out) {
        this.check_out = check_out;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getStayResDate() {
        return stayResDate;
    }

    public void setStayResDate(Timestamp stayResDate) {
        this.stayResDate = stayResDate;
    }

}
