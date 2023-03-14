package tw.taipei.gc.borrowing.usecase.item.delete;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTO;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;

import java.util.Optional;

public class DeleteItemUseCase extends UseCase<DeleteItemUseCaseInput, DeleteItemUseCaseOutput> {

    private ItemRepository itemRepository;

    public DeleteItemUseCase(ItemRepository itemRepository, DomainEventBus domainEventBus){
        super(domainEventBus);
        this.itemRepository = itemRepository;
    }
    @Override
    public void execute(DeleteItemUseCaseInput input, DeleteItemUseCaseOutput output) {
        String ID = input.getID();
        Optional<ItemDTO> res = this.itemRepository.findById(ID);
        if (res.isPresent()) {
            // TODO how to design exceptions with CA?
            this.itemRepository.remove(res.get());
            output.setID(ID);
        } else {
            // TODO how to design exceptions with CA?
        }
    }
}
