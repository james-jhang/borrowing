package tw.taipei.gc.borrowing.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tw.taipei.gc.borrowing.model.item.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserTest {
    @Test
    public void user_can_make_a_reservation_for_an_item() {
        User user = new User("James");
        Item item = new Item("簡報筆");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date startDate = dateFormat.parse("2023/03/01");
            Date endDate = dateFormat.parse("2023/03/06");
            Reservation reservation = user.reserve(
                    item, startDate, endDate
            );
            assertEquals(user.getID(), reservation.getUserID());
            assertEquals(item.getID(), reservation.getItemID());
            assertEquals(startDate, reservation.getStartDate());
            assertEquals(endDate, reservation.getEndDate());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
