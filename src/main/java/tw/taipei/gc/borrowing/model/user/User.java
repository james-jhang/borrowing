package tw.taipei.gc.borrowing.model.user;

import tw.taipei.gc.borrowing.model.common.Entity;
import tw.taipei.gc.borrowing.model.item.Item;

import java.util.Date;
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

    public User(UUID ID, String name, List<Reservation> reservations) {
        this.ID = ID;
        this.name = name;
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reservation reserve(Item item, Date startDate, Date endDate) {
        Reservation reserve = new Reservation(
                this.getID(),
                item.getID(),
                startDate,
                endDate
        );
        this.reservations.add(reserve);
        return reserve;
    }

    public List<Reservation> getReservations() {
        return this.reservations;
    }
}
