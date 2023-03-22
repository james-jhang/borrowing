package tw.taipei.gc.borrowing.adapter.item.presenter.create;


public class CreateItemViewModel {
    private final String itemID;
    private final String name;

    public CreateItemViewModel(String itemID, String name) {
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