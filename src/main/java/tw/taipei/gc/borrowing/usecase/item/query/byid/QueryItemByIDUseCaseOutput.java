package tw.taipei.gc.borrowing.usecase.item.query.byid;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface QueryItemByIDUseCaseOutput extends UseCaseOutput {
    void setItemID(String itemID);

    void setName(String name);

    String getItemID();

    String getItemName();
}
