package tw.taipei.gc.borrowing.model.item;

import tw.taipei.gc.borrowing.model.common.Entity;

import java.util.UUID;

public class Item extends Entity {
    private String name;
    private UUID reservationID;
    private UUID IOUID;

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

    public UUID getReservationID() {
        return reservationID;
    }

    public void setReservationID(UUID reservationID) {
        this.reservationID = reservationID;
    }

    public UUID getIOUID() {
        return IOUID;
    }

    public void setIOUID(UUID IOUID) {
        this.IOUID = IOUID;
    }
}
