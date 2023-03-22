package tw.taipei.gc.borrowing.adapter.item.presenter.create;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCaseOutput;

public class CreateItemPresenter implements CreateItemUseCaseOutput, Presenter<CreateItemViewModel> {
    private String itemID;
    private String name;

    @Override
    public CreateItemViewModel viewModel() {
        return new CreateItemViewModel(
                this.itemID,
                this.name
        );
    }

    @Override
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public String getItemID() {
        return this.itemID;
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
