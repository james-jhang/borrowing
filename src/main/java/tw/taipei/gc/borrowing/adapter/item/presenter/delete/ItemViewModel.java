package tw.taipei.gc.borrowing.adapter.item.presenter.delete;


// TODO not sure why "DeleteItemViewModel" causes a compilation error
public class ItemViewModel {
    private final String itemID;

    public ItemViewModel(String itemID) {
        this.itemID = itemID;
    }

    public String getItemID() {
        return this.itemID;
    }
}
