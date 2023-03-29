package tw.taipei.gc.borrowing.model.user;

import org.junit.jupiter.api.Test;

import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.usecase.utils.DateHelper;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void user_can_make_a_reservation_for_an_item() {
        User user = new User("James");
        Item item = new Item("簡報筆");
        Date startDate = DateHelper.toDate("2023/03/01");
        Date endDate = DateHelper.toDate("2023/03/06");
        Reservation reservation = user.reserve(
                item, startDate, endDate
        );
        assertEquals(user.getID(), reservation.getUserID());
        assertEquals(item.getID(), reservation.getItemID());
        assertEquals(startDate, reservation.getStartDate());
        assertEquals(endDate, reservation.getEndDate());
        assertFalse(reservation.isDelivered());
        assertNull(reservation.getDeliveringCustodianID());
    }
}
