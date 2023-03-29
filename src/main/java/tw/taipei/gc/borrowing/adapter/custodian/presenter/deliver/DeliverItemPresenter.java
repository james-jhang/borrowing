package tw.taipei.gc.borrowing.adapter.custodian.presenter.deliver;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.custodian.deliver.DeliverItemUseCaseOutput;

public class DeliverItemPresenter implements DeliverItemUseCaseOutput, Presenter<IOUViewModel> {
    private String IOUID;
    private String deliveringDate;
    private String custodianID;
    private String userID;
    private String itemID;
    private String startDate;
    private String endDate;

    @Override
    public IOUViewModel viewModel() {
        return new IOUViewModel(
                this.IOUID,
                this.deliveringDate,
                this.custodianID,
                this.userID,
                this.itemID,
                this.startDate,
                this.endDate,
                false,
                ""
        );
        // TODO what the returningDate should be? the item has not been returned yet.
    }

    @Override
    public void setIOUID(String IOUID) {
        this.IOUID = IOUID;
    }

    @Override
    public String getIOUID() {
        return this.IOUID;
    }

    @Override
    public void setCustodianID(String custodianID) {
        this.custodianID = custodianID;
    }

    @Override
    public String getCustodianID() {
        return this.custodianID;
    }

    @Override
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String getUserID() {
        return this.userID;
    }

    @Override
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public String getItemID() {
        return this.itemID;
    }

    @Override
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String getStartDate() {
        return this.startDate;
    }

    @Override
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String getEndDate() {
        return this.endDate;
    }

    @Override
    public void setDeliveringDate(String deliveringDate) {
        this.deliveringDate = deliveringDate;
    }

    @Override
    public String getDeliveringDate() {
        return this.deliveringDate;
    }
}
