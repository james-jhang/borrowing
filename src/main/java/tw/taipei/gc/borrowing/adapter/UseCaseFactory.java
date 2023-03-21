package tw.taipei.gc.borrowing.adapter;

import tw.taipei.gc.borrowing.adapter.custodian.repository.InMemoryCustodianRepository;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.adapter.user.repository.InMemoryUserRepository;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.custodian.deliver.DeliverItemUseCase;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCase;
import tw.taipei.gc.borrowing.usecase.item.delete.DeleteItemUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCase;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;
import tw.taipei.gc.borrowing.usecase.custodian.register.RegisterCustodianUseCase;
import tw.taipei.gc.borrowing.usecase.user.register.RegisterUserUseCase;
import tw.taipei.gc.borrowing.usecase.user.reserve.ReserveItemUseCase;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;

public class UseCaseFactory {
    private static UseCaseFactory _instance;
    private static DomainEventBus eventBus;
    private static ItemRepository itemRepository;
    private static UserRepository userRepository;
    private static CustodianRepository custodianRepository;

    private UseCaseFactory() {
        eventBus = new DomainEventBus();
        itemRepository = new InMemoryItemRepository();
        userRepository = new InMemoryUserRepository();
        custodianRepository = new InMemoryCustodianRepository();
    }

    public static UseCaseFactory getInstance() {
        if (_instance == null) {
            _instance = new UseCaseFactory();
        }
        return _instance;
    }

    public RegisterUserUseCase RegisterMemberUseCase() {
        return new RegisterUserUseCase(userRepository, eventBus);
    }

    public RegisterCustodianUseCase RegisterCustodianUseCase() {
        return new RegisterCustodianUseCase(custodianRepository, eventBus);
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

    public ReserveItemUseCase ReserveItemUseCase() {
        return new ReserveItemUseCase(userRepository, itemRepository, eventBus);
    }

    public DeliverItemUseCase DeliverItemUseCase() {
        return new DeliverItemUseCase(custodianRepository, userRepository, eventBus);
    }
}
