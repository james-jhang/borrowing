package tw.taipei.gc.borrowing.usecase.item;

import tw.taipei.gc.borrowing.adapter.item.InMemoryItemRepository;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCase;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCaseInput;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCaseOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateItemUseCaseTest {
    private ItemRepository itemRepository;
    private DomainEventBus eventBus;

    @BeforeEach
    public void given() {
        itemRepository = new InMemoryItemRepository();
        eventBus = new DomainEventBus();
    }

    @Test
    public void the_created_item_id_should_follow_the_standard_classification() {
        CreateItemUseCase createItemUseCase = new CreateItemUseCase(this.itemRepository, this.eventBus);
        CreateItemUseCaseInput createItemUseCaseInput = new CreateItemUseCaseInput();
        CreateItemUseCaseOutput createItemUseCaseOutput = new CreateItemUseCaseOutput();

        createItemUseCaseInput.setName("酒精噴瓶");

        createItemUseCase.execute(createItemUseCaseInput, createItemUseCaseOutput);

        List<Item> items = itemRepository.findAll();
        assertEquals(1, items.size());
        Item bottle = items.get(0);
        assertEquals("酒精噴瓶", bottle.getName());

        String itemID = createItemUseCaseOutput.getItemID();
        assertNotNull(itemID);
        assertNotEquals("", itemID);
    }
}
