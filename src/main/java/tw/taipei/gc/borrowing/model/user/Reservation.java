package tw.taipei.gc.borrowing.model.user;

import tw.taipei.gc.borrowing.model.common.Entity;
import tw.taipei.gc.borrowing.model.item.Item;

public class Reservation extends Entity {
    private User user;
    private Item item;

    public Reservation(User user, Item item) {
        super();
        this.user = user;
        this.item = item;
    }

    public User getUser() {
        return user;

    }

    public Item getItem() {
        return item;
    }
}
