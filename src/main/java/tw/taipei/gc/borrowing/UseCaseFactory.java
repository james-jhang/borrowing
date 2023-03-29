package tw.taipei.gc.borrowing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.custodian.deliver.DeliverItemUseCase;
import tw.taipei.gc.borrowing.usecase.custodian.register.RegisterCustodianUseCase;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCase;
import tw.taipei.gc.borrowing.usecase.item.delete.DeleteItemUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCase;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;
import tw.taipei.gc.borrowing.usecase.user.register.RegisterUserUseCase;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;
import tw.taipei.gc.borrowing.usecase.user.reserve.ReserveItemUseCase;


@Component
public class UseCaseFactory {
    private static DomainEventBus domainEventBus = new DomainEventBus();
    private static ItemRepository itemRepository;
    private static UserRepository userRepository;
    private static CustodianRepository custodianRepository;

    @Autowired
    public UseCaseFactory(ItemRepository itemRepository, UserRepository userRepository, CustodianRepository custodianRepository) {
        UseCaseFactory.itemRepository = itemRepository;
        UseCaseFactory.userRepository = userRepository;
        UseCaseFactory.custodianRepository = custodianRepository;
    }


    public static RegisterUserUseCase RegisterMemberUseCase() {
        return new RegisterUserUseCase(
                userRepository,
                domainEventBus
        );
    }

    public static RegisterCustodianUseCase RegisterCustodianUseCase() {
        return new RegisterCustodianUseCase(
                custodianRepository,
                domainEventBus
        );
    }

    public static CreateItemUseCase CreateItemUseCase() {
        return new CreateItemUseCase(
                itemRepository,
                domainEventBus
        );
    }

    public static ListAllItemsUseCase ListAllItemsUseCase() {
        return new ListAllItemsUseCase(
                itemRepository,
                domainEventBus
        );
    }

    public static QueryItemByIDUseCase QueryItemByIDUseCase() {
        return new QueryItemByIDUseCase(
                itemRepository,
                domainEventBus
        );
    }

    public static DeleteItemUseCase DeleteItemUseCase() {
        return new DeleteItemUseCase(
                itemRepository,
                domainEventBus
        );
    }

    public static ReserveItemUseCase ReserveItemUseCase() {
        return new ReserveItemUseCase(
                userRepository,
                itemRepository,
                domainEventBus
        );
    }

    public static DeliverItemUseCase DeliverItemUseCase() {
        return new DeliverItemUseCase(
                custodianRepository,
                userRepository,
                domainEventBus
        );
    }
}
