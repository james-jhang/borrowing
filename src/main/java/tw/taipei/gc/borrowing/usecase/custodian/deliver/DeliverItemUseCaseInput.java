package tw.taipei.gc.borrowing.usecase.custodian.deliver;

import tw.taipei.gc.borrowing.usecase.UseCaseInput;

public class DeliverItemUseCaseInput implements UseCaseInput {
    private String custodianID;
    private String reservationID;
    private String userID;

    public void setCustodianID(String custodianID) {
        this.custodianID = custodianID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getCustodianID() {
        return custodianID;
    }

    public String getReservationID() {
        return reservationID;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
