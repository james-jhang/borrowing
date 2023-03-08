package tw.taipei.gc.borrowing.usecase.item.query.byid;

import tw.taipei.gc.borrowing.usecase.UseCaseInput;

public class QueryItemByIDUseCaseInput implements UseCaseInput {
    private String ID;

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return this.ID;
    }
}
