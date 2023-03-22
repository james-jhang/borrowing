package tw.taipei.gc.borrowing.usecase.item.create;

import tw.taipei.gc.borrowing.adapter.item.presenter.create.CreateItemPresenter;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTO;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;

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
    public void creating_an_item_should_generate_an_id_for_the_created_item() {
        CreateItemUseCase createItemUseCase = new CreateItemUseCase(this.itemRepository, this.eventBus);
        CreateItemUseCaseInput createItemUseCaseInput = new CreateItemUseCaseInput();
        CreateItemUseCaseOutput createItemUseCaseOutput = new CreateItemPresenter();

        createItemUseCaseInput.setName("酒精噴瓶");

        createItemUseCase.execute(createItemUseCaseInput, createItemUseCaseOutput);

        List<ItemDTO> items = itemRepository.findAll();
        assertEquals(1, items.size());
        ItemDTO bottle = items.get(0);
        assertEquals("酒精噴瓶", bottle.getName());

        String ID = createItemUseCaseOutput.getItemID();
        assertNotNull(ID);
        assertNotEquals("", ID);
        String name = createItemUseCaseOutput.getName();
        assertEquals("酒精噴瓶", name);
    }
}
