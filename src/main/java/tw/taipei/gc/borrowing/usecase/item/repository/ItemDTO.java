package tw.taipei.gc.borrowing.usecase.item.repository;

import tw.taipei.gc.borrowing.usecase.DTO;

public class ItemDTO implements DTO {
    private String ID;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

}
