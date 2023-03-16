package tw.taipei.gc.borrowing.usecase.user.member.reserve;

import tw.taipei.gc.borrowing.usecase.UseCaseInput;

public class ReserveItemUseCaseInput implements UseCaseInput {
    private String userID;
    private String itemID;

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getItemID() {
        return this.itemID;
    }
}
