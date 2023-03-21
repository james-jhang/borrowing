package tw.taipei.gc.borrowing.usecase.custodian.deliver;

import org.junit.jupiter.api.Test;
import tw.taipei.gc.borrowing.adapter.custodian.presenter.deliver.DeliverItemPresenter;
import tw.taipei.gc.borrowing.adapter.custodian.repository.InMemoryCustodianRepository;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.adapter.user.repository.InMemoryUserRepository;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.model.user.Custodian;
import tw.taipei.gc.borrowing.model.user.Reservation;
import tw.taipei.gc.borrowing.model.user.User;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianDTOMapper;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTOMapper;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTOMapper;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;
import tw.taipei.gc.borrowing.usecase.utils.DateHelper;

import static org.junit.jupiter.api.Assertions.*;

public class DeliverItemUseCaseTest {

    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private CustodianRepository custodianRepository;
    private DomainEventBus domainEventBus;

    private User user;
    private Custodian custodian;
    private Item item;

    public DeliverItemUseCaseTest() {
        userRepository = new InMemoryUserRepository();
        custodianRepository = new InMemoryCustodianRepository();
        itemRepository = new InMemoryItemRepository();
        domainEventBus = new DomainEventBus();
        custodian = new Custodian("James");
        user = new User("Olivia");
        item = new Item("Pen");
        user.reserve(
                item,
                DateHelper.toDate("2023/03/02"),
                DateHelper.toDate("2023/03/05")
        );
        userRepository.save(UserDTOMapper.toDTO(user));
        custodianRepository.save(CustodianDTOMapper.toDTO(custodian));
        itemRepository.save(ItemDTOMapper.toDTO(item));
    }


    @Test
    public void deliver_a_reserved_item() {
        DeliverItemUseCase deliverItemUseCase = new DeliverItemUseCase(custodianRepository, userRepository, domainEventBus);
        DeliverItemUseCaseInput deliverItemUseCaseInput = new DeliverItemUseCaseInput();
        DeliverItemUseCaseOutput deliverItemUseCaseOutput = new DeliverItemPresenter();

        Reservation reservation = user.getReservations().get(0);
        deliverItemUseCaseInput.setCustodianID(
                custodian.getID().toString()
        );
        deliverItemUseCaseInput.setUserID(
                user.getID().toString()
        );
        deliverItemUseCaseInput.setReservationID(
                reservation.getID().toString()
        );
        deliverItemUseCase.execute(deliverItemUseCaseInput, deliverItemUseCaseOutput);

        assertNotEquals(null, deliverItemUseCaseOutput.getIOUID());
        assertEquals(custodian.getID().toString(), deliverItemUseCaseOutput.getCustodianID());
        assertEquals(user.getID().toString(), deliverItemUseCaseOutput.getUserID());
        assertEquals(item.getID().toString(), deliverItemUseCaseOutput.getItemID());
        assertEquals(DateHelper.toString(reservation.getStartDate()), deliverItemUseCaseOutput.getStartDate());
        assertEquals(DateHelper.toString(reservation.getEndDate()), deliverItemUseCaseOutput.getEndDate());
    }
}
