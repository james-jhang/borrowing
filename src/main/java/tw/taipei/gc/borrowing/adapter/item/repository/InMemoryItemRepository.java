package tw.taipei.gc.borrowing.adapter.item.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTO;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;

public class InMemoryItemRepository implements ItemRepository {

    private final List<ItemDTO> entities;

    public InMemoryItemRepository() {
        entities = new ArrayList<ItemDTO>();
    }

    @Override
    public List<ItemDTO> findAll() {
        return entities;
    }

    @Override
    public Optional<ItemDTO> findById(String id) {
        ItemDTO target = null;
        for (ItemDTO item : entities) {
            if (item.getID().equals(id)) {
                target = item;
                break;
            }
        }
        return Optional.ofNullable(target);
    }

    @Override
    public Optional<ItemDTO> findFirstByName(String name) {
        ItemDTO target = null;
        for (ItemDTO item : entities) {
            if (item.getName() == name) {
                target = item;
                break;
            }
        }
        return Optional.ofNullable(target);
    }

    @Override
    public Optional<ItemDTO> save(ItemDTO item) {
        entities.add(item);
        return Optional.ofNullable(item);
    }

    @Override
    public boolean remove(ItemDTO item) {
        return entities.remove(item);
    }

}
