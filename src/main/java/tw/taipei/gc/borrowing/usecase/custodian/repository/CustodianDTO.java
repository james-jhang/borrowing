package tw.taipei.gc.borrowing.usecase.custodian.repository;

import tw.taipei.gc.borrowing.usecase.DTO;
import tw.taipei.gc.borrowing.usecase.custodian.repository.IOU.IOUDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;

import java.util.List;

public class CustodianDTO implements DTO {
    private String ID;
    private String name;
    private List<IOUDTO> IOUDTOs;
    private List<ReservationDTO> reservationDTOS;

    public String getID() {
        return this.ID;
    }

    public CustodianDTO setID(String ID) {
        this.ID = ID;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustodianDTO setName(String name) {
        this.name = name;
        return this;
    }

    public CustodianDTO setIOUDTOs(List<IOUDTO> IOUDTOs) {
        this.IOUDTOs = IOUDTOs;
        return this;
    }

    public CustodianDTO setReservationDTOs(List<ReservationDTO> reservationDTOS) {
        this.reservationDTOS = reservationDTOS;
        return this;
    }

    public List<IOUDTO> getIOUDTOs() {
        return IOUDTOs;
    }

    public List<ReservationDTO> getReservationDTOS() {
        return reservationDTOS;
    }
}
