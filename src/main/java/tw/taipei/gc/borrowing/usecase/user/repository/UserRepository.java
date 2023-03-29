package tw.taipei.gc.borrowing.usecase.user.repository;

import tw.taipei.gc.borrowing.usecase.IRepository;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;

public interface UserRepository extends IRepository<UserDTO> {
    void createReservation(ReservationDTO reservationDTO);
    void updateReservation(ReservationDTO reservationDTO);
    void removeReservation(ReservationDTO reservationDTO);
}
