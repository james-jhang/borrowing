package tw.taipei.gc.borrowing.usecase.user.repository;

import tw.taipei.gc.borrowing.usecase.DTO;

// TODO turn into "record"
public class UserDTO implements DTO {
    private final String ID;
    private final String name;

    public UserDTO(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }
}
