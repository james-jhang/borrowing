package tw.taipei.gc.borrowing.usecase.item.create;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public class CreateItemUseCaseOutput implements UseCaseOutput {

    private String itemID;

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemID() {
        return this.itemID;
    }
}
