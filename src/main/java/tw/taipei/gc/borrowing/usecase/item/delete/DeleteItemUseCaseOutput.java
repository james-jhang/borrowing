package tw.taipei.gc.borrowing.usecase.item.delete;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface DeleteItemUseCaseOutput extends UseCaseOutput {
    void setItemID(String itemID);
    String getItemID();
}
