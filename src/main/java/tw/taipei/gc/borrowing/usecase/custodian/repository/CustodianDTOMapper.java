package tw.taipei.gc.borrowing.usecase.custodian.repository;

import tw.taipei.gc.borrowing.model.user.Custodian;
import tw.taipei.gc.borrowing.model.user.IOU;
import tw.taipei.gc.borrowing.model.user.Reservation;
import tw.taipei.gc.borrowing.usecase.custodian.repository.IOU.IOUDTO;
import tw.taipei.gc.borrowing.usecase.custodian.repository.IOU.IOUDTOMapper;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTOMapper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class CustodianDTOMapper {
    public static CustodianDTO toDTO(Custodian custodian) {
        CustodianDTO custodianDTO = new CustodianDTO();
        List<IOUDTO> IOUList = new ArrayList<>();
        for (IOU IOU : custodian.getIOUs()) {
            IOUList.add(IOUDTOMapper.toDTO(IOU));
        }
        List<ReservationDTO> reservationDTOList = new ArrayList<>();
        for (Reservation reservation : custodian.getReservations()) {
            reservationDTOList.add(ReservationDTOMapper.toDTO(reservation));
        }
        custodianDTO.setID(custodian.getID().toString())
                .setName(custodian.getName())
                .setIOUDTOs(IOUList)
                .setReservationDTOs(reservationDTOList);
        return custodianDTO;
    }

    public static Custodian toModel(CustodianDTO custodianDTO) {
        List<IOU> IOUs = new LinkedList<>();
        for (IOUDTO IOUDTO : custodianDTO.getIOUDTOs()) {
            IOUs.add(IOUDTOMapper.toModel(IOUDTO));
        }
        List<Reservation> reservations = new LinkedList<>();
        for (ReservationDTO reservationDTO : custodianDTO.getReservationDTOS()) {
            reservations.add(ReservationDTOMapper.toModel(reservationDTO));
        }
        return new Custodian(
                UUID.fromString(custodianDTO.getID()),
                custodianDTO.getName(),
                IOUs,
                reservations
        );
    }
}
