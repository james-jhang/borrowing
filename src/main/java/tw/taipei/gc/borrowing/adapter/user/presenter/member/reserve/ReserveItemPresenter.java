package tw.taipei.gc.borrowing.adapter.user.presenter.member.reserve;

import tw.taipei.gc.borrowing.usecase.user.member.reserve.ReserveItemUseCaseOutput;

// TODO make "Presenter" as an interface
public class ReserveItemPresenter implements ReserveItemUseCaseOutput {
    private String reservationID;
    private String userID;
    private String itemID;

    @Override
    public String getReservationID() {
        return this.reservationID;
    }

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

    public ReservationViewModel viewModel() {
        return new ReservationViewModel(
                reservationID,
                userID,
                itemID
        );
    }

}
