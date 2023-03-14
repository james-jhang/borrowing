package tw.taipei.gc.borrowing.adapter;

import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.adapter.user.repository.InMemoryUserRepository;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCase;
import tw.taipei.gc.borrowing.usecase.item.delete.DeleteItemUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCase;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;
import tw.taipei.gc.borrowing.usecase.user.member.register.RegisterMemberUseCase;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;

public class UseCaseFactory {
    private static UseCaseFactory _instance;
    private static DomainEventBus eventBus;
    private static ItemRepository itemRepository;
    private static UserRepository userRepository;

    private UseCaseFactory() {
        eventBus = new DomainEventBus();
        itemRepository = new InMemoryItemRepository();
        userRepository = new InMemoryUserRepository();
    }

    public static UseCaseFactory getInstance() {
        if (_instance == null) {
            _instance = new UseCaseFactory();
        }
        return _instance;
    }

    public RegisterMemberUseCase RegisterMemberUseCase() {
        return new RegisterMemberUseCase(userRepository, eventBus);
    }

    public CreateItemUseCase CreateItemUseCase() {
        return new CreateItemUseCase(itemRepository, eventBus);
    }

    public ListAllItemsUseCase ListAllItemsUseCase() {
        return new ListAllItemsUseCase(itemRepository, eventBus);
    }

    public QueryItemByIDUseCase QueryItemByIDUseCase() {
        return new QueryItemByIDUseCase(itemRepository, eventBus);
    }

    public DeleteItemUseCase DeleteItemUseCase() {
        return new DeleteItemUseCase(itemRepository, eventBus);
    }
}
