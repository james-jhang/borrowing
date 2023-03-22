package tw.taipei.gc.borrowing.adapter.item.presenter.query;

public class ItemViewModel {
    private final String itemID;
    private final String name;

    public ItemViewModel(String itemID, String name) {
        this.itemID = itemID;
        this.name = name;
    }

    public String getItemID() {
        return this.itemID;
    }

    public String getName() {
        return this.name;
    }
}
