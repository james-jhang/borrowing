package tw.taipei.gc.borrowing.usecase.user.repository;

import tw.taipei.gc.borrowing.usecase.DTO;

import java.util.List;

// TODO turn into "record"
public class UserDTO implements DTO {
    private String ID;
    private String name;
    private List<ReservationDTO> reservationDTOs;

    public String getID() {
        return this.ID;
    }

    public UserDTO setID(String ID) {
        this.ID = ID;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public UserDTO setReservationDTOs(List<ReservationDTO> reservationDTOs) {
        this.reservationDTOs = reservationDTOs;
        return this;
    }

    public List<ReservationDTO> getReservationDTOs() {
        return this.reservationDTOs;
    }
}
