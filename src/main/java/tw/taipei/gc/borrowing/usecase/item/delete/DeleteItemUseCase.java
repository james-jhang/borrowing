package tw.taipei.gc.borrowing.usecase.item.delete;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;

public class DeleteItemUseCase extends UseCase<DeleteItemUseCaseInput, DeleteItemUseCaseOutput> {

    private final ItemRepository itemRepository;

    public DeleteItemUseCase(ItemRepository itemRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(DeleteItemUseCaseInput input, DeleteItemUseCaseOutput output) {
        String itemID = input.getID();
        // TODO how to design exceptions with CA?
        this.itemRepository.remove(itemID);
        output.setItemID(itemID);
    }
}
