package tw.taipei.gc.borrowing.model.user;

import tw.taipei.gc.borrowing.model.common.Entity;
import tw.taipei.gc.borrowing.model.item.Item;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class User extends Entity {
    private String name;
    private final List<Reservation> reservations;


    public User(String name) {
        super();
        this.name = name;
        this.reservations = new LinkedList<>();
    }

    public User(String ID, String name, List<Reservation> reservations) {
        this.ID = UUID.fromString(ID);
        this.name = name;
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reservation reserve(Item item) {
        Reservation reserve = new Reservation(this.getID(), item.getID());
        this.reservations.add(reserve);
        return reserve;
    }

    public List<Reservation> getReservations() {
        return this.reservations;
    }
}
