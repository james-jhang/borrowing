package tw.taipei.gc.borrowing.adapter.custodian.presenter.deliver;

public class IOUViewModel {
    private final String IOUID;
    private final String deliveringDate;
    private final String custodianID;
    private final String userID;
    private final String itemID;
    private final String startDate;
    private final String endDate;
    private final boolean isItemReturned;
    private final String returningDate;

    public IOUViewModel(String IOUID, String deliveringDate, String custodianID, String userID, String itemID, String startDate, String endDate, boolean isItemReturned, String returningDate) {
        this.IOUID = IOUID;
        this.deliveringDate = deliveringDate;
        this.custodianID = custodianID;
        this.userID = userID;
        this.itemID = itemID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isItemReturned = isItemReturned;
        this.returningDate = returningDate;
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

    public String getDeliveringDate() {
        return deliveringDate;
    }

    public boolean isItemReturned() {
        return isItemReturned;
    }

    public String getReturningDate() {
        return returningDate;
    }
}
