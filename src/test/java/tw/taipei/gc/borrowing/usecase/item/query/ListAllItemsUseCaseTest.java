package tw.taipei.gc.borrowing.usecase.item.query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.item.ItemRepository;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCaseInput;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCaseOutput;
import tw.taipei.gc.borrowing.adapter.item.presenter.query.ListAllItemsPresenter;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class ListAllItemsUseCaseTest {
    private ItemRepository itemRepository;
    private DomainEventBus eventBus;

    @BeforeEach
    public void given() {
        itemRepository = new InMemoryItemRepository();
        eventBus = new DomainEventBus();
        itemRepository.save(new Item("木桌"));
        itemRepository.save(new Item("辦公椅"));
    }

    @Test
    public void querying_items_without_specific_conditions_should_return_all_items() {
        ListAllItemsUseCase queryItemUseCase = new ListAllItemsUseCase(itemRepository, eventBus);
        ListAllItemsUseCaseInput queryItemUseCaseInput = new ListAllItemsUseCaseInput();
        ListAllItemsUseCaseOutput queryItemUseCaseOutput = new ListAllItemsPresenter();

        queryItemUseCase.execute(queryItemUseCaseInput, queryItemUseCaseOutput);

        List<ItemViewObject> itemIDs = queryItemUseCaseOutput.results();
        assertEquals(2, itemIDs.size());
    }
}
