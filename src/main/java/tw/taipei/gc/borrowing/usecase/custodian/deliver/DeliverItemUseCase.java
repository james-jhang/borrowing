package tw.taipei.gc.borrowing.usecase.custodian.deliver;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.model.user.Custodian;
import tw.taipei.gc.borrowing.model.user.IOU;
import tw.taipei.gc.borrowing.model.user.Reservation;
import tw.taipei.gc.borrowing.model.user.User;
import tw.taipei.gc.borrowing.usecase.UseCase;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianDTO;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianDTOMapper;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;
import tw.taipei.gc.borrowing.usecase.custodian.repository.IOU.IOUDTOMapper;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTOMapper;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;
import tw.taipei.gc.borrowing.usecase.utils.DateHelper;

import java.util.Date;
import java.util.Optional;

public class DeliverItemUseCase extends UseCase<DeliverItemUseCaseInput, DeliverItemUseCaseOutput> {

    private final CustodianRepository custodianRepository;
    private final UserRepository userRepository;


    public DeliverItemUseCase(CustodianRepository custodianRepository, UserRepository userRepository, DomainEventBus domainEventBus) {
        super(domainEventBus);
        this.custodianRepository = custodianRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void execute(DeliverItemUseCaseInput input, DeliverItemUseCaseOutput output) {
        Optional<CustodianDTO> cusRes = this.custodianRepository.findByID(input.getCustodianID());
        Optional<UserDTO> userRes = this.userRepository.findByID(input.getUserID());
        String reservationID = input.getReservationID();
        if (cusRes.isPresent()) {
            if (userRes.isPresent()) {
                Custodian custodian = CustodianDTOMapper.toModel(cusRes.get());
                User user = UserDTOMapper.toModel(userRes.get());
                Optional<Reservation> reserRes = user.getReservations().stream()
                        .filter(reservation -> reservation.getID().toString().equals(reservationID))
                        .findFirst();
                // TODO remove null
                if (reserRes.isPresent()) {
                    Reservation reservation = reserRes.get();
                    IOU IOU = custodian.deliverItem(
                            reservation, new Date()
                    );
                    this.custodianRepository.createIOU(IOUDTOMapper.toDTO(IOU));
                    output.setIOUID(IOU.getID().toString());
                    output.setDeliveringDate(DateHelper.toString(IOU.getDeliveringDate()));
                    output.setCustodianID(custodian.getID().toString());
                    output.setUserID(user.getID().toString());
                    output.setItemID(reservation.getItemID().toString());
                    output.setStartDate(DateHelper.toString(reservation.getStartDate()));
                    output.setEndDate(DateHelper.toString(reservation.getEndDate()));
                }
            }
        }
        // TODO throw exceptions for all error cases
    }
}
