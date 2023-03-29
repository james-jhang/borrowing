package tw.taipei.gc.borrowing.usecase.user.repository;

import tw.taipei.gc.borrowing.model.user.Reservation;
import tw.taipei.gc.borrowing.model.user.User;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTOMapper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class UserDTOMapper {
    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        List<ReservationDTO> reservationDTOList = new ArrayList<>();
        for (Reservation reservation : user.getReservations()) {
            reservationDTOList.add(ReservationDTOMapper.toDTO(reservation));
        }
        userDTO.setID(user.getID().toString())
                .setName(user.getName())
                .setReservationDTOs(reservationDTOList);
        return userDTO;
    }

    public static User toModel(UserDTO userDTO) {
        List<Reservation> reservations = new LinkedList<>();
        for (ReservationDTO reservationDTO : userDTO.getReservationDTOs()) {
            reservations.add(ReservationDTOMapper.toModel(reservationDTO));
        }
        return new User(
                UUID.fromString(userDTO.getID()),
                userDTO.getName(),
                reservations
        );
    }
}
