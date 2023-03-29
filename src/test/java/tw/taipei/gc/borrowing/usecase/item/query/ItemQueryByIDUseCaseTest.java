package tw.taipei.gc.borrowing.usecase.item.query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCaseInput;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCaseOutput;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTOMapper;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;
import tw.taipei.gc.borrowing.adapter.item.presenter.query.QueryItemByIDPresenter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemQueryByIDUseCaseTest {
    private ItemRepository itemRepository;
    private DomainEventBus eventBus;
    private Item table;
    private Item chair;

    @BeforeEach
    public void given() {
        itemRepository = new InMemoryItemRepository();
        eventBus = new DomainEventBus();
        this.table = new Item("木桌");
        this.chair = new Item("辦公椅");
        itemRepository.create(ItemDTOMapper.toDTO(this.table));
        itemRepository.create(ItemDTOMapper.toDTO(this.chair));
    }

    @Test
    public void querying_item_by_id_should_return_the_detail_of_the_item() {
        QueryItemByIDUseCase queryItemByIDUseCase = new QueryItemByIDUseCase(this.itemRepository, this.eventBus);
        QueryItemByIDUseCaseInput queryItemByIDUseCaseInput = new QueryItemByIDUseCaseInput();
        QueryItemByIDUseCaseOutput queryItemByIDUseCaseOutput = new QueryItemByIDPresenter();

        queryItemByIDUseCaseInput.setID(this.chair.getID().toString());
        queryItemByIDUseCase.execute(queryItemByIDUseCaseInput, queryItemByIDUseCaseOutput);

        assertEquals(this.chair.getID().toString(), queryItemByIDUseCaseOutput.getItemID());
        assertEquals(this.chair.getName(), queryItemByIDUseCaseOutput.getItemName());
    }
}
