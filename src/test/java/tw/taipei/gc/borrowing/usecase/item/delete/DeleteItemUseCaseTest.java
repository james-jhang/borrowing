package tw.taipei.gc.borrowing.usecase.item.delete;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.taipei.gc.borrowing.adapter.item.presenter.delete.DeleteItemPresenter;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTOMapper;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteItemUseCaseTest {
    private ItemRepository itemRepository;
    private DomainEventBus eventBus;
    private Item pen;


    @BeforeEach
    public void given() {
        itemRepository = new InMemoryItemRepository();
        eventBus = new DomainEventBus();
        this.pen = new Item("原子筆");
        itemRepository.save(ItemDTOMapper.toDTO(this.pen));
    }

    @Test
    public void delete_an_item(){
        DeleteItemUseCase deleteItemUseCase = new DeleteItemUseCase(this.itemRepository, this.eventBus);
        DeleteItemUseCaseInput deleteItemUseCaseInput = new DeleteItemUseCaseInput();
        DeleteItemUseCaseOutput deleteItemUseCaseOutput = new DeleteItemPresenter();

        deleteItemUseCaseInput.setID(this.pen.getID().toString());
        deleteItemUseCase.execute(deleteItemUseCaseInput, deleteItemUseCaseOutput);

        assertEquals(this.pen.getID().toString(), deleteItemUseCaseOutput.getID());
        assertEquals(0, itemRepository.findAll().size());
    }
}
