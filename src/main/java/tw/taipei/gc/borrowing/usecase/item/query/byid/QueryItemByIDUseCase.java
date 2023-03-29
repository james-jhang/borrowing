package tw.taipei.gc.borrowing.usecase.item.query.byid;

import tw.taipei.gc.borrowing.model.item.Item;

import java.util.Optional;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTO;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTOMapper;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;

public class QueryItemByIDUseCase extends UseCase<QueryItemByIDUseCaseInput, QueryItemByIDUseCaseOutput> {

    private final ItemRepository itemRepository;

    public QueryItemByIDUseCase(ItemRepository itemRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(QueryItemByIDUseCaseInput input, QueryItemByIDUseCaseOutput output) {
        Optional<ItemDTO> result = this.itemRepository.findByID(input.getID());
        if (result.isPresent()) {
            Item item = ItemDTOMapper.toModel(result.get());
            output.setItemID(item.getID().toString());
            output.setName(item.getName());
        }
    }
}
