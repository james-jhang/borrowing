package tw.taipei.gc.borrowing.model.user;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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

    public IOU deliverItem(Reservation reservation) {
        // TODO make sure the reservation is ok (no conflict with other reservations)
        IOU IOU = new IOU(
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
}
