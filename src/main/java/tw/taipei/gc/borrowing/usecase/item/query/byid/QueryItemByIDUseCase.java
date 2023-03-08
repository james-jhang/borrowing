package tw.taipei.gc.borrowing.usecase.item.query.byid;

import tw.taipei.gc.borrowing.model.item.Item;

import java.util.Optional;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.item.ItemRepository;

public class QueryItemByIDUseCase extends UseCase<QueryItemByIDUseCaseInput, QueryItemByIDUseCaseOutput> {

    private ItemRepository itemRepository;

    public QueryItemByIDUseCase(ItemRepository itemRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(QueryItemByIDUseCaseInput input, QueryItemByIDUseCaseOutput output) {
        Optional<Item> result = this.itemRepository.findById(input.getID());
        if (result.isPresent()) {
            Item item = result.get();
            output.setID(item.getID().toString());
            output.setName(item.getName());
        }
    }
}
