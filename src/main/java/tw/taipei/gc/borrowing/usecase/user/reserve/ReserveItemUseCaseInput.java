package tw.taipei.gc.borrowing.usecase.user.reserve;

import tw.taipei.gc.borrowing.usecase.UseCaseInput;

public class ReserveItemUseCaseInput implements UseCaseInput {
    private String userID;
    private String itemID;
    private String startDate;
    private String endDate;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getItemID() {
        return this.itemID;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
