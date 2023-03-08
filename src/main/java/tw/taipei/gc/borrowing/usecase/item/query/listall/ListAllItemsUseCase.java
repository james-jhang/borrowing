package tw.taipei.gc.borrowing.usecase.item.query.listall;

import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.item.ItemRepository;

public class ListAllItemsUseCase extends UseCase<ListAllItemsUseCaseInput, ListAllItemsUseCaseOutput> {

    private ItemRepository itemRepository;

    public ListAllItemsUseCase(ItemRepository itemRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(ListAllItemsUseCaseInput input, ListAllItemsUseCaseOutput output) {
        for (Item item : this.itemRepository.findAll()) {
            output.addItem(
                    item.getID().toString(),
                    item.getName());
        }
    }

}
