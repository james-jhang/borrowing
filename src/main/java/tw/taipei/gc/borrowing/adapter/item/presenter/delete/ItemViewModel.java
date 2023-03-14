package tw.taipei.gc.borrowing.adapter.item.presenter.delete;


// TODO not sure why "DeleteItemViewModel" causes a compilation error
public class ItemViewModel {
    private final String ID;

    public ItemViewModel(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return this.ID;
    }
}
