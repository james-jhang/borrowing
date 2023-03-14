package tw.taipei.gc.borrowing.model.user;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import tw.taipei.gc.borrowing.model.item.Item;

public class MemberTest {
    @Test
    public void member_can_make_a_reservation_for_an_item() {
        Member member = new Member("James");
        Item item = new Item("簡報筆");
        Reservation reservation = member.reserve(item);
        assertTrue(member.getID().equals(reservation.getUser().getID()));
        assertTrue(item.getID().equals(reservation.getItem().getID()));
    }
}
