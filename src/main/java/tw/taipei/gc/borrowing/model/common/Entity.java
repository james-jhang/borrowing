package tw.taipei.gc.borrowing.model.common;

import java.util.UUID;

public abstract class Entity {

    protected UUID id;

    public Entity() {
        this.id = UUID.randomUUID();
    }

    public UUID getID() {
        return this.id;
    }

}
