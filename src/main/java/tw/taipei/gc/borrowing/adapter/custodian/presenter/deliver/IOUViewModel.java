package tw.taipei.gc.borrowing.adapter.custodian.presenter.deliver;

public class IOUViewModel {
    private final String IOUID;
    private final String custodianID;
    private final String userID;
    private final String itemID;
    private final String startDate;
    private final String endDate;

    public IOUViewModel(String IOUID, String custodianID, String userID, String itemID, String startDate, String endDate) {
        this.IOUID = IOUID;
        this.custodianID = custodianID;
        this.userID = userID;
        this.itemID = itemID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getIOUID() {
        return IOUID;
    }

    public String getCustodianID() {
        return custodianID;
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
