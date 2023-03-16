package tw.taipei.gc.borrowing.usecase.user.reserve;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface ReserveItemUseCaseOutput extends UseCaseOutput {
    String getReservationID();

    void setReservationID(String reservationID);

    String getUserID();

    void setUserID(String userID);

    String getItemID();

    void setItemID(String itemID);

    void setStartDate(String startDate);

    void setEndDate(String endDate);

    String getStartDate();

    String getEndDate();
}
