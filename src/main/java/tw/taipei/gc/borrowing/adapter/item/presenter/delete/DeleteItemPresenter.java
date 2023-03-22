package tw.taipei.gc.borrowing.adapter.item.presenter.delete;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.item.delete.DeleteItemUseCaseOutput;

public class DeleteItemPresenter implements DeleteItemUseCaseOutput, Presenter<ItemViewModel> {
    private String itemID;

    @Override
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public String getItemID() {
        return this.itemID;
    }

    @Override
    public ItemViewModel viewModel() {
        return new ItemViewModel(this.itemID);
    }

}

