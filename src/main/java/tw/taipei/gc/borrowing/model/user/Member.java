package tw.taipei.gc.borrowing.model.user;

import java.util.LinkedList;
import java.util.List;

import tw.taipei.gc.borrowing.model.item.Item;

public class Member extends User {

    private List<Reservation> reservations;

    public Member(String name) {
        super(name);
        this.reservations = new LinkedList<>();
    }

    public Reservation reserve(Item item) {
        Reservation reserve = new Reservation(this, item);
        this.reservations.add(reserve);
        return reserve;
    }
}
