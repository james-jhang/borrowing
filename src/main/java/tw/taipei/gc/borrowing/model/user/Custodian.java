package tw.taipei.gc.borrowing.model.user;

import tw.taipei.gc.borrowing.model.item.IOU;

import java.util.LinkedList;
import java.util.List;

public class Custodian extends User {

    private List<IOU> IOUs;

    public Custodian(String name) {
        super(name);
        this.IOUs = new LinkedList<>();
    }

    public IOU deliverItem(Reservation reservation) {
        // TODO make sure the reservation is ok (no conflict with other reservations)
        IOU iou = new IOU(
                this.getID(),
                reservation.getUserID(),
                reservation.getItemID(),
                reservation.getStartDate(),
                reservation.getEndDate()
        );
        this.IOUs.add(iou);
        return iou;
    }
}
