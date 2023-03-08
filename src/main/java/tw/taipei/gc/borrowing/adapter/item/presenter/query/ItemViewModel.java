package tw.taipei.gc.borrowing.adapter.item.presenter.query;

public class ItemViewModel {
    private String ID;
    private String name;

    public ItemViewModel(String ID, String name) {
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
