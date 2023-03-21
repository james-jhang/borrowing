package tw.taipei.gc.borrowing.usecase.custodian.repository.IOU;

import tw.taipei.gc.borrowing.usecase.DTO;

public class IOUDTO implements DTO {
    private String ID;
    private String custodianID;
    private String userID;
    private String itemID;
    private String startDate;
    private String endDate;

    public String getID() {
        return ID;
    }

    public IOUDTO setID(String ID) {
        this.ID = ID;
        return this;
    }

    public String getCustodianID() {
        return custodianID;
    }

    public IOUDTO setCustodianID(String custodianID) {
        this.custodianID = custodianID;
        return this;
    }

    public String getUserID() {
        return userID;
    }

    public IOUDTO setUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public String getItemID() {
        return itemID;
    }

    public IOUDTO setItemID(String itemID) {
        this.itemID = itemID;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public IOUDTO setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public IOUDTO setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }
}
