package tw.taipei.gc.borrowing.model.user;

import tw.taipei.gc.borrowing.model.common.Entity;

import java.util.UUID;

public class Reservation extends Entity {
    private final UUID userID;
    private final UUID itemID;

    public Reservation(UUID userID, UUID itemID) {
        super();
        this.userID = userID;
        this.itemID = itemID;
    }

    public Reservation(UUID ID, UUID userID, UUID itemID) {
        super(ID);
        this.userID = userID;
        this.itemID = itemID;
    }

    public UUID getUserID() {
        return userID;
    }

    public UUID getItemID() {
        return itemID;
    }
}
