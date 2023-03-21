package tw.taipei.gc.borrowing.model.user;

import tw.taipei.gc.borrowing.model.common.Entity;

import java.util.Date;
import java.util.UUID;

public class IOU extends Entity {
    private final UUID custodianID;
    private final UUID userID;
    private final UUID itemID;
    private final Date startDate;
    private final Date endDate;

    public IOU(UUID custodianID, UUID userID, UUID itemID, Date startDate, Date endDate) {
        this.custodianID = custodianID;
        this.userID = userID;
        this.itemID = itemID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public IOU(UUID ID, UUID custodianID, UUID userID, UUID itemID, Date startDate, Date endDate) {
        super(ID);
        this.custodianID = custodianID;
        this.userID = userID;
        this.itemID = itemID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getCustodianID() {
        return custodianID;
    }

    public UUID getUserID() {
        return userID;
    }

    public UUID getItemID() {
        return itemID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
