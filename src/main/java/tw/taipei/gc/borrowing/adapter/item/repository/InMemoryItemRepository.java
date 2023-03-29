package tw.taipei.gc.borrowing.adapter.item.repository;

import java.util.*;

import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTO;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;

public class InMemoryItemRepository implements ItemRepository {

    private final Map<String, ItemDTO> items;

    public InMemoryItemRepository() {
        items = new HashMap<>();
    }

    @Override
    public List<ItemDTO> findAll() {
        List<ItemDTO> itemDTOs = new ArrayList<>();
        this.items.forEach((itemID, itemDTO) ->
            itemDTOs.add(itemDTO)
        );
        return itemDTOs;
    }

    @Override
    public Optional<ItemDTO> findByID(String itemID) {
        return Optional.ofNullable(this.items.get(itemID));
    }

    @Override
    public void create(ItemDTO itemDTO) {
        this.items.put(itemDTO.getID(), itemDTO);
    }

    @Override
    public void remove(String itemID) {
        this.items.remove(itemID);
    }

    @Override
    public void update(ItemDTO itemDTO) {
        this.items.put(itemDTO.getID(), itemDTO);
    }
}
