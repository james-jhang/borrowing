package tw.taipei.gc.borrowing.usecase.item.query;

public class ItemViewObject {
    private String ID;
    private String name;

    public ItemViewObject(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return this.ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
