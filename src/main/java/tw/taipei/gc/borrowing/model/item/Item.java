package tw.taipei.gc.borrowing.model.item;

import tw.taipei.gc.borrowing.model.common.Entity;

public class Item extends Entity {
    private String name;

    public Item(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
