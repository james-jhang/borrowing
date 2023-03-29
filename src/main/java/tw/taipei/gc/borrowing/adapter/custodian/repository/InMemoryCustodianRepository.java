package tw.taipei.gc.borrowing.adapter.custodian.repository;

import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianDTO;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;
import tw.taipei.gc.borrowing.usecase.custodian.repository.IOU.IOUDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;

import java.util.*;

public class InMemoryCustodianRepository implements CustodianRepository {

    private final Map<String, CustodianDTO> custodians;

    public InMemoryCustodianRepository() {
        this.custodians = new HashMap<>();
    }

    @Override
    public List<CustodianDTO> findAll() {
        List<CustodianDTO> custodianDTOs = new ArrayList<>();
        this.custodians.forEach((custodianID, custodianDTO) ->
            custodianDTOs.add(custodianDTO)
        );
        return custodianDTOs;
    }

    @Override
    public Optional<CustodianDTO> findByID(String id) {
        return Optional.ofNullable(this.custodians.get(id));
    }

    @Override
    public void create(CustodianDTO custodianDTO) {
        this.custodians.put(custodianDTO.getID(), custodianDTO);
    }

    @Override
    public void update(CustodianDTO custodianDTO) {
        CustodianDTO target = this.custodians.get(custodianDTO.getID());
        target.setName(custodianDTO.getName());
    }

    @Override
    public void remove(String custodianID) {
        this.custodians.remove(custodianID);
    }

    @Override
    public void createIOU(IOUDTO IOUDTO) {
        CustodianDTO custodianDTO = this.custodians.get(IOUDTO.getCustodianID());
        custodianDTO.getIOUDTOs().add(IOUDTO);
    }

    @Override
    public void updateIOU(IOUDTO IOUDTO) {
        CustodianDTO custodianDTO = this.custodians.get(IOUDTO.getCustodianID());
        custodianDTO.getIOUDTOs().stream().filter(
                IOU -> IOU.getID().equals(IOUDTO.getID())
        ).findFirst().ifPresentOrElse(
                IOU -> {
                    IOU.setItemReturned(IOUDTO.isItemReturned());
                    IOU.setReturningDate(IOUDTO.getReturningDate());
                },
                () -> {
                    throw new NoSuchElementException(
                        String.format("Cannot find IOU with id: %S when updating IOU", IOUDTO.getID()));
                }
        );
    }

    @Override
    public void createReservation(ReservationDTO reservationDTO) {
        CustodianDTO target = this.custodians.get(reservationDTO.getUserID());
        target.getReservationDTOs().add(reservationDTO);
    }

    @Override
    public void updateReservation(ReservationDTO reservationDTO) {
        // TODO reservation cannot change user id
        CustodianDTO target = this.custodians.get(reservationDTO.getUserID());
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
        CustodianDTO target = this.custodians.get(reservationDTO.getUserID());
        target.getReservationDTOs().removeIf(
                reservation -> reservation.getID().equals(reservationDTO.getID())
        );
    }
}
