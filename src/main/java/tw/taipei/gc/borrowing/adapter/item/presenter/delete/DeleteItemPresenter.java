package tw.taipei.gc.borrowing.adapter.item.presenter.delete;

import tw.taipei.gc.borrowing.usecase.item.delete.DeleteItemUseCaseOutput;

public class DeleteItemPresenter implements DeleteItemUseCaseOutput {
    private String ID;

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    public ItemViewModel viewModel() {
        return new ItemViewModel(this.ID);
    }

}

