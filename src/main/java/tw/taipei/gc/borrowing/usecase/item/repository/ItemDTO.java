package tw.taipei.gc.borrowing.usecase.item.repository;

import tw.taipei.gc.borrowing.usecase.DTO;

public class ItemDTO implements DTO {
    private final String ID;
    private final String name;

    public ItemDTO(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }
}
