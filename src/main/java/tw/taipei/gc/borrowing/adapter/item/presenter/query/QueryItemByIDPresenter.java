package tw.taipei.gc.borrowing.adapter.item.presenter.query;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.item.query.ItemViewObject;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCaseOutput;

public class QueryItemByIDPresenter implements QueryItemByIDUseCaseOutput, Presenter<ItemViewModel> {
    private String ID;
    private String name;

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ItemViewObject getItem() {
        return new ItemViewObject(this.ID, this.name);
    }

    public ItemViewModel viewModel() {
        if (this.ID != null) {
            return new ItemViewModel(this.ID, this.name);
        } else {
            return null;
        }
    }
}
