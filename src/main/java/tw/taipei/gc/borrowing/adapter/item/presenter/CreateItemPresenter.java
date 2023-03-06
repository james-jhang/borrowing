package tw.taipei.gc.borrowing.adapter.item.presenter;

import tw.taipei.gc.borrowing.adapter.item.restfulapi.ItemViewModel;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCaseOutput;

public class CreateItemPresenter implements CreateItemUseCaseOutput {

    private String ID;
    private String name;

    public ItemViewModel viewModel() {
        ItemViewModel viewModel = new ItemViewModel();
        viewModel.setID(this.ID);
        viewModel.setName(this.name);
        return viewModel;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
