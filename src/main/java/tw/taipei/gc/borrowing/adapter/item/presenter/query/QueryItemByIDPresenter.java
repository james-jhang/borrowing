package tw.taipei.gc.borrowing.adapter.item.presenter.query;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCaseOutput;

public class QueryItemByIDPresenter implements QueryItemByIDUseCaseOutput, Presenter<ItemViewModel> {
    private String itemID;
    private String name;

    @Override
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getItemID() {
        return this.itemID;
    }

    @Override
    public String getItemName() {
        return this.name;
    }

    public ItemViewModel viewModel() {
        return new ItemViewModel(this.itemID, this.name);
    }
}
