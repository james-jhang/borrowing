package tw.taipei.gc.borrowing.usecase.user.reserve;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.item.Item;
import tw.taipei.gc.borrowing.model.user.Reservation;
import tw.taipei.gc.borrowing.model.user.User;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTO;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTOMapper;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTOMapper;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;
import tw.taipei.gc.borrowing.usecase.utils.DateHelper;

import java.util.Optional;

public class ReserveItemUseCase extends UseCase<ReserveItemUseCaseInput, ReserveItemUseCaseOutput> {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public ReserveItemUseCase(UserRepository userRepository, ItemRepository itemRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(ReserveItemUseCaseInput input, ReserveItemUseCaseOutput output) {
        Optional<UserDTO> userRes = userRepository.findById(input.getUserID());
        Optional<ItemDTO> itemRes = itemRepository.findById(input.getItemID());
        if (userRes.isPresent()) {
            if (itemRes.isPresent()) {
                User user = UserDTOMapper.toModel(userRes.get());
                Item item = ItemDTOMapper.toModel(itemRes.get());
                Reservation reservation = user.reserve(
                        item,
                        DateHelper.toDate(input.getStartDate()),
                        DateHelper.toDate(input.getEndDate())
                );

                userRepository.save(UserDTOMapper.toDTO(user));
                output.setReservationID(reservation.getID().toString());
                output.setUserID(user.getID().toString());
                output.setItemID(item.getID().toString());
                output.setStartDate(DateHelper.toString(reservation.getStartDate()));
                output.setEndDate(DateHelper.toString(reservation.getEndDate()));
            } else {
                // TODO Re-design exception handling
                throw new RuntimeException("Cannot find item.");
            }
        } else {
            // TODO Re-design exception handling
            throw new RuntimeException("Cannot find user.");
        }
    }
}
