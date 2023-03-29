package tw.taipei.gc.borrowing.model.custodian;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.model.user.Custodian;
import tw.taipei.gc.borrowing.model.user.IOU;
import tw.taipei.gc.borrowing.model.user.Reservation;
import tw.taipei.gc.borrowing.model.user.User;
import tw.taipei.gc.borrowing.usecase.utils.DateHelper;

public class CustodianTest
{
    @Test
    public void an_IOU_should_be_made_when_custodian_delivers_the_reserved_item() {
        Item item = new Item("Pen");
        User user = new User("Olivia");
        Custodian custodian = new Custodian("James");
        Reservation reservation = user.reserve(
                item,
                DateHelper.toDate("2023/03/30"),
                DateHelper.toDate("2023/04/07")
        );
        IOU IOU = custodian.deliverItem(
                reservation,
                DateHelper.toDate("2023/03/29")
        );
        assertEquals(IOU.getDeliveringDate(), DateHelper.toDate("2023/03/29"));
        assertEquals(IOU.getCustodianID(), custodian.getID());
        assertEquals(IOU.getUserID(), user.getID());
        assertEquals(IOU.getItemID(), item.getID());
        assertEquals(IOU.getStartDate(), DateHelper.toDate("2023/03/30"));
        assertEquals(IOU.getEndDate(), DateHelper.toDate("2023/04/07"));
        assertFalse(IOU.isItemReturned());
        // TODO what value should be assigned to the returningDate when the item has not been returned yet?
        assertNull(IOU.getReturningDate());
        assertTrue(reservation.isDelivered());
        assertEquals(reservation.getDeliveringCustodianID(), custodian.getID());
    }

    @Test
    public void an_IOU_should_be_made_invalid_when_the_delivered_item_is_returned() {
        Item item = new Item("Pen");
        User user = new User("Olivia");
        Custodian custodian = new Custodian("James");
        Reservation reservation = user.reserve(
                item,
                DateHelper.toDate("2023/03/30"),
                DateHelper.toDate("2023/04/07")
        );
        IOU IOU = custodian.deliverItem(
                reservation,
                DateHelper.toDate("2023/03/30")
        );
        custodian.returnItem(
                item,
                DateHelper.toDate("2023/04/07")
        );
        assertTrue(IOU.isItemReturned());
        assertEquals(IOU.getReturningDate(), DateHelper.toDate("2023/04/07"));
    }
}
