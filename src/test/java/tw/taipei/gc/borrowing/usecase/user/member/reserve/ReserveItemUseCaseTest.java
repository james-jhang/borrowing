package tw.taipei.gc.borrowing.usecase.user.member.reserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.adapter.user.presenter.member.reserve.ReserveItemPresenter;
import tw.taipei.gc.borrowing.adapter.user.repository.InMemoryUserRepository;
import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.model.user.Member;
import tw.taipei.gc.borrowing.model.user.User;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTOMapper;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTOMapper;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ReserveItemUseCaseTest {

    private User member;

    private Item item;
    private UserRepository userRepository;
    private ItemRepository itemRepository;
    private DomainEventBus eventBus;

    @BeforeEach
    public void given() {
        userRepository = new InMemoryUserRepository();
        itemRepository = new InMemoryItemRepository();
        eventBus = new DomainEventBus();
        member = new Member("Olivia");
        item = new Item("Pen");
        userRepository.save(UserDTOMapper.toDTO(member));
        itemRepository.save(ItemDTOMapper.toDTO(item));
    }

    @Test
    public void reserve_an_item_that_has_not_been_reserved_by_other_member_yet() {
        ReserveItemUseCase reserveItemUseCase = new ReserveItemUseCase(userRepository, itemRepository, eventBus);
        ReserveItemUseCaseInput reserveItemUseCaseInput = new ReserveItemUseCaseInput();
        ReserveItemUseCaseOutput reserveItemUseCaseOutput = new ReserveItemPresenter();

        reserveItemUseCaseInput.setUserID(this.member.getID().toString());
        reserveItemUseCaseInput.setItemID(this.item.getID().toString());

        reserveItemUseCase.execute(reserveItemUseCaseInput, reserveItemUseCaseOutput);

        String reservationID = reserveItemUseCaseOutput.getReservationID();
        assertNotEquals(null, reservationID);
        assertNotEquals("", reservationID);
        assertEquals(this.member.getID().toString(), reserveItemUseCaseOutput.getUserID());
        assertEquals(this.item.getID().toString(), reserveItemUseCaseOutput.getItemID());

        // TODO where should the repository tests be placed?
        User olivia = UserDTOMapper.toModel(userRepository.findById(this.member.getID().toString()).get());
        assertEquals(reservationID, olivia.getReservations().get(0).getID().toString());
    }
}
