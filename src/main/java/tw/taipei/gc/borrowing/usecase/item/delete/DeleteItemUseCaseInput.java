package tw.taipei.gc.borrowing.usecase.item.delete;

import tw.taipei.gc.borrowing.usecase.UseCaseInput;

public class DeleteItemUseCaseInput implements UseCaseInput {
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
