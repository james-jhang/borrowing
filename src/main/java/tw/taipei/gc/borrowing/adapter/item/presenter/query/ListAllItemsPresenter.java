package tw.taipei.gc.borrowing.adapter.item.presenter.query;

import java.util.List;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.item.query.ItemViewObject;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCaseOutput;

import java.util.ArrayList;

public class ListAllItemsPresenter implements ListAllItemsUseCaseOutput, Presenter<List<ItemViewModel>> {

    private List<ItemViewObject> items;

    public ListAllItemsPresenter() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(String ID, String name) {
        this.items.add(new ItemViewObject(ID, name));
    }

    @Override
    public List<ItemViewObject> results() {
        return this.items;
    }

    @Override
    public List<ItemViewModel> viewModel() {
        List<ItemViewModel> itemViewModels = new ArrayList<>();
        for (ItemViewObject item : this.items) {
            itemViewModels.add(
                    new ItemViewModel(item.getID(), item.getName())
            );
        }
        return itemViewModels;
    }

}
