package tw.taipei.gc.borrowing.adapter.item.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.usecase.item.ItemRepository;

public class InMemoryItemRepository implements ItemRepository {

    private final List<Item> entities;

    public InMemoryItemRepository() {
        entities = new ArrayList<Item>();
    }

    @Override
    public List<Item> findAll() {
        return entities;
    }

    @Override
    public Optional<Item> findById(String id) {
        Item target = null;
        for (Item item : entities) {
            if (item.getID().toString() == id) {
                target = item;
                break;
            }
        }
        return Optional.ofNullable(target);
    }

    @Override
    public Optional<Item> findFirstByName(String name) {
        Item target = null;
        for (Item item : entities) {
            if (item.getName() == name) {
                target = item;
                break;
            }
        }
        return Optional.ofNullable(target);
    }

    @Override
    public Optional<Item> save(Item item) {
        entities.add(item);
        return Optional.ofNullable(item);
    }

    @Override
    public boolean remove(Item item) {
        return entities.remove(item);
    }

}
