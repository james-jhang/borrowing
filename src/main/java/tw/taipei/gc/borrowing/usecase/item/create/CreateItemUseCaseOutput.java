package tw.taipei.gc.borrowing.usecase.item.create;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface CreateItemUseCaseOutput extends UseCaseOutput {

    void setItemID(String itemID);

    String getItemID();

    void setName(String name);

    String getName();
}
