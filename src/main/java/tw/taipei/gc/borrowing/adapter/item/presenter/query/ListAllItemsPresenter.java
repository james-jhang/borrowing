package tw.taipei.gc.borrowing.adapter.item.presenter.query;

import java.util.List;

import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCaseOutput;

import java.util.ArrayList;

public class ListAllItemsPresenter implements ListAllItemsUseCaseOutput {

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

    public List<FindAllItemsViewModel> viewModel() {
        List<FindAllItemsViewModel> itemViewModels = new ArrayList<>();
        for (ListAllItemsUseCaseOutput.ItemViewObject item : this.items) {
            itemViewModels.add(
                    new FindAllItemsViewModel(item.getID(), item.getName()));
        }
        return itemViewModels;
    }

    public static class FindAllItemsViewModel {
        private String ID;
        private String name;

        public FindAllItemsViewModel(String ID, String name) {
            this.ID = ID;
            this.name = name;
        }

        public String getID() {
            return this.ID;
        }

        public String getName() {
            return this.name;
        }
    }

}
