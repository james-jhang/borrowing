package tw.taipei.gc.borrowing.usecase.item.query.listall;


import tw.taipei.gc.borrowing.usecase.UseCaseOutput;
import tw.taipei.gc.borrowing.usecase.item.query.ItemViewObject;

import java.util.List;

public interface ListAllItemsUseCaseOutput extends UseCaseOutput {
    public void addItem(String ID, String name);

    public List<ItemViewObject> results();
}