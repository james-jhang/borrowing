package tw.taipei.gc.borrowing.usecase.custodian.deliver;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface DeliverItemUseCaseOutput extends UseCaseOutput {
    void setIOUID(String toString);

    String getIOUID();
    void setCustodianID(String custodianID);
    String getCustodianID();
    void setUserID(String userID);
    String getUserID();
    void setItemID(String itemID);
    String getItemID();
    void setStartDate(String startDate);
    String getStartDate();
    void setEndDate(String endDate);
    String getEndDate();
}
