package tw.taipei.gc.borrowing.usecase.user.repository.reservation;

import tw.taipei.gc.borrowing.usecase.DTO;

public class ReservationDTO implements DTO {
    private String ID;
    private String userID;
    private String itemID;
    private String startDate;
    private String endDate;

    public String getID() {
        return ID;
    }

    public ReservationDTO setID(String ID) {
        this.ID = ID;
        return this;
    }

    public String getUserID() {
        return userID;
    }

    public ReservationDTO setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public String getItemID() {
        return itemID;
    }

    public ReservationDTO setItemID(String itemID) {
        this.itemID = itemID;
        return this;
    }

    public ReservationDTO setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public ReservationDTO setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }
}
