package tw.taipei.gc.borrowing.adapter.user.presenter.reserve;

public class ReservationViewModel {
    private final String ID;
    private final String userID;
    private final String itemID;
    private final String startDate;
    private final String endDate;

    public ReservationViewModel(String ID, String userID, String itemID, String startDate, String endDate) {
        this.ID = ID;
        this.userID = userID;
        this.itemID = itemID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getID() {
        return ID;
    }

    public String getUserID() {
        return userID;
    }

    public String getItemID() {
        return itemID;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
