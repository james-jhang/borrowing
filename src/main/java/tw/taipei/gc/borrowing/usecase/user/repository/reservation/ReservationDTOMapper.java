package tw.taipei.gc.borrowing.usecase.user.repository.reservation;

import tw.taipei.gc.borrowing.model.user.Reservation;
import tw.taipei.gc.borrowing.usecase.utils.DateHelper;

import java.util.UUID;

public class ReservationDTOMapper {
    public static ReservationDTO toDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setID(reservation.getID().toString())
                .setUserID(reservation.getUserID().toString())
                .setItemID(reservation.getItemID().toString())
                .setStartDate(DateHelper.toString(reservation.getStartDate()))
                .setEndDate(DateHelper.toString(reservation.getEndDate()));
        return reservationDTO;
    }

    public static Reservation toModel(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation(
                UUID.fromString(reservationDTO.getID()),
                UUID.fromString(reservationDTO.getUserID()),
                UUID.fromString(reservationDTO.getItemID()),
                DateHelper.toDate(reservationDTO.getStartDate()),
                DateHelper.toDate(reservationDTO.getEndDate())
        );
        reservation.setID(UUID.fromString(reservationDTO.getID()));
        return reservation;
    }
}
