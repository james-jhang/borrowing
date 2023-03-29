package tw.taipei.gc.borrowing.usecase.custodian.repository;


import tw.taipei.gc.borrowing.usecase.IRepository;
import tw.taipei.gc.borrowing.usecase.custodian.repository.IOU.IOUDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;

public interface CustodianRepository extends IRepository<CustodianDTO> {
    void createReservation(ReservationDTO reservationDTO);
    void updateReservation(ReservationDTO reservationDTO);
    void removeReservation(ReservationDTO reservationDTO);
    void createIOU(IOUDTO IOUDTO);
    void updateIOU(IOUDTO IOUDTO);
}
