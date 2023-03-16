package tw.taipei.gc.borrowing.adapter.user.presenter.reserve;

import tw.taipei.gc.borrowing.usecase.user.reserve.ReserveItemUseCaseOutput;

// TODO make "Presenter" as an interface
public class ReserveItemPresenter implements ReserveItemUseCaseOutput {
    private String reservationID;
    private String userID;
    private String itemID;
    private String startDate;
    private String endDate;

    public ReservationViewModel viewModel() {
        return new ReservationViewModel(
                reservationID,
                userID,
                itemID,
                startDate,
                endDate
        );
    }

    @Override
    public String getReservationID() {
        return this.reservationID;
    }

    @Override
    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    @Override
    public String getUserID() {
        return this.userID;
    }

    @Override
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String getItemID() {
        return this.itemID;
    }

    @Override
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String getStartDate() {
        return this.startDate;
    }

    @Override
    public String getEndDate() {
        return this.endDate;
    }
}
