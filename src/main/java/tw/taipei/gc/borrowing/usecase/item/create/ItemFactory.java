package tw.taipei.gc.borrowing.usecase.item.create;

import tw.taipei.gc.borrowing.model.item.Item;

public class ItemFactory {
    private static ItemFactory _instance = new ItemFactory();

    private ItemFactory() {
    }

    public static ItemFactory getInstance() {
        return _instance;
    }

    // public Item createItem(ItemClass )

}
