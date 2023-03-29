package tw.taipei.gc.borrowing.model.user;

import tw.taipei.gc.borrowing.model.item.Item;

import java.util.*;

public class Custodian extends User {

    private List<IOU> IOUs;

    public Custodian(String name) {
        super(name);
        this.IOUs = new LinkedList<>();
    }

    public Custodian(UUID ID, String name, List<IOU> IOUs, List<Reservation> reservations) {
        super(ID, name, reservations);
        this.IOUs = IOUs;
    }

    public IOU deliverItem(Reservation reservation, Date deliveringDate) {
        // TODO make sure the reservation is ok (no conflict with other reservations)
        reservation.delivered(this.ID);
        IOU IOU = new IOU(
                deliveringDate,
                this.getID(),
                reservation.getUserID(),
                reservation.getItemID(),
                reservation.getStartDate(),
                reservation.getEndDate()
        );
        this.IOUs.add(IOU);
        return IOU;
    }

    public List<IOU> getIOUs() {
        return this.IOUs;
    }

    public void returnItem(Item item, Date returningDate) {
        // TODO declare an interface for checked exception?
        this.IOUs.stream()
                .filter(IOU -> IOU.getItemID().equals(item.getID()))
                .findAny()
                .ifPresentOrElse(
                        IOU -> IOU.itemReturned(returningDate),
                        () -> {
                            throw new NoSuchElementException(
                                    String.format("No corresponding IOU for the item (name: %s, ID: %s).", item.getName(), item.getID().toString())
                            );
                        }
                );
    }
}
