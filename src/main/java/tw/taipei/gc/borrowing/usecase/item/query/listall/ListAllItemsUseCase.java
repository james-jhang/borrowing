package tw.taipei.gc.borrowing.usecase.item.query.listall;

import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTO;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTOMapper;

public class ListAllItemsUseCase extends UseCase<ListAllItemsUseCaseInput, ListAllItemsUseCaseOutput> {

    private ItemRepository itemRepository;

    public ListAllItemsUseCase(ItemRepository itemRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(ListAllItemsUseCaseInput input, ListAllItemsUseCaseOutput output) {
        for (ItemDTO itemDTO : this.itemRepository.findAll()) {
            Item item = ItemDTOMapper.toModel(itemDTO);
            output.addItem(
                    item.getID().toString(),
                    item.getName());
        }
    }

}
