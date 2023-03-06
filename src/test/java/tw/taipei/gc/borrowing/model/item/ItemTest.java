package tw.taipei.gc.borrowing.model.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    public void create_an_item() {
        Item item = new Item("酒精噴瓶");
        assertNotNull(item.getID());
        assertNotEquals("", item.getID());
        assertEquals("酒精噴瓶", item.getName());
    }
}
