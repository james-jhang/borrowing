package tw.taipei.gc.borrowing.usecase.custodian.repository;

import tw.taipei.gc.borrowing.usecase.custodian.repository.IOU.IOUDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;

import java.util.List;

public class CustodianDTO extends UserDTO {
    private List<IOUDTO> IOUDTOs;

    public CustodianDTO setID(String ID) {
        this.ID = ID;
        return this;
    }

    public CustodianDTO setName(String name) {
        this.name = name;
        return this;
    }

    public CustodianDTO setIOUDTOs(List<IOUDTO> IOUDTOs) {
        this.IOUDTOs = IOUDTOs;
        return this;
    }

    public CustodianDTO setReservationDTOs(List<ReservationDTO> reservationDTOs) {
        this.reservationDTOs = reservationDTOs;
        return this;
    }

    public List<IOUDTO> getIOUDTOs() {
        return this.IOUDTOs;
    }

}
