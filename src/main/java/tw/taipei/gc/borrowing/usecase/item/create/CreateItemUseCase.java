package tw.taipei.gc.borrowing.usecase.item.create;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTOMapper;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;

public class CreateItemUseCase extends UseCase<CreateItemUseCaseInput, CreateItemUseCaseOutput> {

    private final ItemRepository itemRepository;

    public CreateItemUseCase(ItemRepository itemRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(CreateItemUseCaseInput input, CreateItemUseCaseOutput output) {
        Item item = new Item(input.getName());
        this.itemRepository.save(ItemDTOMapper.toDTO(item));
        output.setItemID(item.getID().toString());
        output.setName(item.getName());
    }

}
