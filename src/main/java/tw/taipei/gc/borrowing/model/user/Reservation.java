package tw.taipei.gc.borrowing.model.user;

import tw.taipei.gc.borrowing.model.common.Entity;

import java.util.Date;
import java.util.UUID;

public class Reservation extends Entity {
    private final UUID userID;
    private final UUID itemID;
    private Date startDate;
    private Date endDate;

    public Reservation(UUID userID, UUID itemID, Date startDate, Date endDate) {
        super();
        this.userID = userID;
        this.itemID = itemID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Reservation(UUID ID, UUID userID, UUID itemID, Date startDate, Date endDate) {
        super(ID);
        this.userID = userID;
        this.itemID = itemID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getUserID() {
        return userID;
    }

    public UUID getItemID() {
        return itemID;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }
}
