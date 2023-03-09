package tw.taipei.gc.borrowing.usecase.item.repository;

import tw.taipei.gc.borrowing.model.item.Item;

import java.util.UUID;

public class ItemDTOMapper {
    public static ItemDTO toDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO(
                item.getID().toString(),
                item.getName());
        return itemDTO;
    }

    public static Item toModel(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getName());
        item.setID(UUID.fromString(itemDTO.getID()));
        return item;
    }
}
