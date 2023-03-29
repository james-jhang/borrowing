package tw.taipei.gc.borrowing.adapter.user.repository;

import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, UserDTO> users;

    public InMemoryUserRepository() {
        this.users = new HashMap<>();
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOs = new ArrayList<>();
        this.users.forEach((userID, userDTO) -> userDTOs.add(userDTO));
        return userDTOs;
    }

    @Override
    public Optional<UserDTO> findByID(String id) {
        return Optional.ofNullable(this.users.get(id));
    }

    @Override
    public void create(UserDTO userDTO) {
        this.users.put(userDTO.getID(), userDTO);
    }

    @Override
    public void update(UserDTO userDTO) {
        UserDTO target = this.users.get(userDTO.getID());
        target.setName(userDTO.getName());
    }

    @Override
    public void remove(String userID) {
        this.users.remove(userID);
    }


    @Override
    public void createReservation(ReservationDTO reservationDTO) {
        UserDTO target = this.users.get(reservationDTO.getUserID());
        target.getReservationDTOs().add(reservationDTO);
    }

    @Override
    public void updateReservation(ReservationDTO reservationDTO) {
        // TODO reservation cannot change user id
        UserDTO target = this.users.get(reservationDTO.getUserID());
        target.getReservationDTOs().stream().filter(
                reservation -> reservation.getID().equals(reservationDTO.getID())
        ).findFirst().ifPresentOrElse(
                reservation -> {
                    reservation.setItemID(reservationDTO.getItemID());
                    reservation.setStartDate(reservationDTO.getStartDate());
                    reservation.setEndDate(reservationDTO.getEndDate());
                },
                () -> {
                    throw new NoSuchElementException(
                            String.format("Cannot find reservation with id: %S when updating reservation", reservationDTO.getID()));
                }
        );
    }

    @Override
    public void removeReservation(ReservationDTO reservationDTO) {
        UserDTO target = this.users.get(reservationDTO.getUserID());
        target.getReservationDTOs().removeIf(
                reservation -> reservation.getID().equals(reservationDTO.getID())
        );
    }
}
