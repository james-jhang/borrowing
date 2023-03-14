package tw.taipei.gc.borrowing.model.user;

import tw.taipei.gc.borrowing.model.common.Entity;

public class User extends Entity {
    private String name;

    public User(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
