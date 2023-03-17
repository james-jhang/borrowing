package tw.taipei.gc.borrowing.adapter.item.presenter.delete;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.item.delete.DeleteItemUseCaseOutput;

public class DeleteItemPresenter implements DeleteItemUseCaseOutput, Presenter<ItemViewModel> {
    private String ID;

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public ItemViewModel viewModel() {
        return new ItemViewModel(this.ID);
    }

}

