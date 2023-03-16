package tw.taipei.gc.borrowing.adapter.user.presenter.member.reserve;

public class ReservationViewModel {
    private final String ID;
    private final String userID;
    private final String itemID;

    public ReservationViewModel(String id, String userID, String itemID) {
        ID = id;
        this.userID = userID;
        this.itemID = itemID;
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
}
