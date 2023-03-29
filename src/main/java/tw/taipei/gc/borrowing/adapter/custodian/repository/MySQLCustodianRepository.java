package tw.taipei.gc.borrowing.adapter.custodian.repository;

import tw.taipei.gc.borrowing.adapter.database.MySQLDBHelper;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianDTO;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;
import tw.taipei.gc.borrowing.usecase.custodian.repository.IOU.IOUDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLCustodianRepository implements CustodianRepository {

    private CustodianDTO getCustodian(Connection conn, ResultSet custodianRes) throws SQLException {
        String custodianID = custodianRes.getString("id");
        String custodianName = custodianRes.getString("name");
        PreparedStatement IOUStmt = conn.prepareStatement(
                "SELECT * FROM ious WHERE custodian_id=?"
        );
        IOUStmt.setString(1, custodianID);
        ResultSet IOURes = IOUStmt.executeQuery();
        List<IOUDTO> IOUDTOs = new ArrayList<>();
        while (IOURes.next()) {
            IOUDTO IOUDTO = new IOUDTO();
            IOUDTO.setID(IOURes.getString("id"))
                    .setCustodianID(IOURes.getString("custodian_id"))
                    .setDeliveringDate(IOURes.getString("delivering_date"))
                    .setUserID(IOURes.getString("user_id"))
                    .setItemID(IOURes.getString("item_id"))
                    .setStartDate(IOURes.getString("start_date"))
                    .setEndDate(IOURes.getString("end_date"));
            String returningDate = IOURes.getString("returning_date");
            if (returningDate.isEmpty()) {
                IOUDTO.setItemReturned(false);
            } else {
                IOUDTO.setItemReturned(true).setReturningDate(returningDate);
            }
            IOUDTOs.add(IOUDTO);
        }
        PreparedStatement reserStmt = conn.prepareStatement(
                "SELECT * FROM reservations WHERE user_id=?"
        );
        reserStmt.setString(1, custodianID);
        ResultSet reservationRes = reserStmt.executeQuery();
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        while (reservationRes.next()) {
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setID(reservationRes.getString("id"))
                    .setUserID(reservationRes.getString("user_id"))
                    .setItemID(reservationRes.getString("item_id"))
                    .setStartDate(reservationRes.getString("start_date"))
                    .setEndDate(reservationRes.getString("end_date"));
            reservationDTOs.add(reservationDTO);
        }
        CustodianDTO custodianDTO = new CustodianDTO();
        custodianDTO.setID(custodianID)
                .setName(custodianName)
                .setReservationDTOs(reservationDTOs)
                .setIOUDTOs(IOUDTOs);
        return custodianDTO;
    }
    @Override
    public List<CustodianDTO> findAll() {
        List<CustodianDTO> custodianDTOs = new ArrayList<>();
        try (Connection conn = MySQLDBHelper.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(
                    "SELECT * FROM custodians"
            );
            while (res.next()) {
                custodianDTOs.add(getCustodian(conn, res));
            }
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
        return custodianDTOs;
    }

    @Override
    public Optional<CustodianDTO> findByID(String id) {
        CustodianDTO target = null;
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM custodians WHERE id=?"
            );
            stmt.setString(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                target = getCustodian(conn, res);
            }
            //                TODO NoSuchElementException
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
        return Optional.ofNullable(target);
    }

    @Override
    public void create(CustodianDTO custodianDTO) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement userStmt = conn.prepareStatement(
                    "INSERT INTO custodians(id, name) VALUES (?, ?)"
            );
            userStmt.setString(1, custodianDTO.getID());
            userStmt.setString(2, custodianDTO.getName());
            userStmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void update(CustodianDTO custodianDTO) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement userStmt = conn.prepareStatement(
                    "UPDATE custodians SET name=? WHERE id=?"
            );
            userStmt.setString(1, custodianDTO.getName());
            userStmt.setString(2, custodianDTO.getID());
            userStmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void remove(String custodianID) {
        try(Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM custodians WHERE id=?"
            );
            stmt.setString(1, custodianID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void createIOU(IOUDTO IOUDTO) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO ious(id, delivering_date, custodian_id, user_id, item_id, start_date, end_date, returning_date) VALUE (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            stmt.setString(1, IOUDTO.getID());
            stmt.setString(2, IOUDTO.getDeliveringDate());
            stmt.setString(3, IOUDTO.getCustodianID());
            stmt.setString(4, IOUDTO.getUserID());
            stmt.setString(5, IOUDTO.getItemID());
            stmt.setString(6, IOUDTO.getStartDate());
            stmt.setString(7, IOUDTO.getEndDate());
            stmt.setString(8, IOUDTO.getReturningDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void updateIOU(IOUDTO IOUDTO) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE ious SET returning_date=? WHERE id=?"
            );
            stmt.setString(1, IOUDTO.getReturningDate());
            stmt.setString(2, IOUDTO.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void createReservation(ReservationDTO reservationDTO) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO reservations(id, user_id, item_id, start_date, end_date) VALUES (?, ?, ?, ?, ?)"
            );
            stmt.setString(1, reservationDTO.getID());
            stmt.setString(2, reservationDTO.getUserID());
            stmt.setString(3, reservationDTO.getItemID());
            stmt.setString(4, reservationDTO.getStartDate());
            stmt.setString(5, reservationDTO.getEndDate());
            stmt.executeUpdate();
        }  catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void updateReservation(ReservationDTO reservationDTO) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE reservations SET user_id=?, item_id=?, start_date=?, end_date=? WHERE id=?"
            );
            stmt.setString(1, reservationDTO.getUserID());
            stmt.setString(2, reservationDTO.getItemID());
            stmt.setString(3, reservationDTO.getStartDate());
            stmt.setString(4, reservationDTO.getEndDate());
            stmt.setString(5, reservationDTO.getID());
            stmt.executeUpdate();
        }  catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void removeReservation(ReservationDTO reservationDTO) {
        try(Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM reservations WHERE id=?"
            );
            stmt.setString(1, reservationDTO.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }
}
