package tw.taipei.gc.borrowing.model.common;

import java.util.UUID;

public abstract class Entity {

    protected UUID ID;

    public Entity() {
        this.ID = UUID.randomUUID();
    }

    public UUID getID() {
        return this.ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }
}
