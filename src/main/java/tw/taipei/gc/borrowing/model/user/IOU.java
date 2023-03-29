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
    private final Date deliveringDate;
    private boolean isItemReturned;
    private Date returningDate;

    public IOU(Date deliveringDate, UUID custodianID, UUID userID, UUID itemID, Date startDate, Date endDate) {
        this.deliveringDate = deliveringDate;
        this.custodianID = custodianID;
        this.userID = userID;
        this.itemID = itemID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isItemReturned = false;
    }

    public IOU(UUID ID, Date deliveringDate, UUID custodianID, UUID userID, UUID itemID, Date startDate, Date endDate, boolean isItemReturned, Date returningDate) {
        super(ID);
        this.deliveringDate = deliveringDate;
        this.custodianID = custodianID;
        this.userID = userID;
        this.itemID = itemID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isItemReturned = isItemReturned;
        this.returningDate = returningDate;
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

    public boolean isItemReturned() {
        return this.isItemReturned;
    }

    public void itemReturned(Date returningDate) {
        this.isItemReturned= true;
        this.returningDate = returningDate;
    }

    public Date getDeliveringDate() {
        return this.deliveringDate;
    }

    public Date getReturningDate() {
        return this.returningDate;
    }
}
