package tw.taipei.gc.borrowing.usecase.item.query.byid;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;
import tw.taipei.gc.borrowing.usecase.item.query.ItemViewObject;

public interface QueryItemByIDUseCaseOutput extends UseCaseOutput {
    public void setID(String ID);

    public void setName(String name);

    public ItemViewObject getItem();
}
