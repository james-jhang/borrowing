package tw.taipei.gc.borrowing.adapter.user.repository;

import tw.taipei.gc.borrowing.adapter.database.MySQLDBHelper;
import tw.taipei.gc.borrowing.usecase.user.repository.UserDTO;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;
import tw.taipei.gc.borrowing.usecase.user.repository.reservation.ReservationDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLUserRepository implements UserRepository {

    private UserDTO getUser(Connection conn, ResultSet userRes) throws SQLException {
        String userID = userRes.getString("id");
        String userName = userRes.getString("name");
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM reservations WHERE user_id=?"
        );
        stmt.setString(1, userID);
        ResultSet reservationRes = stmt.executeQuery();
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
        UserDTO userDTO = new UserDTO();
        userDTO.setID(userID)
                .setName(userName)
                .setReservationDTOs(reservationDTOs);
        return userDTO;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOs = new ArrayList<>();
        try (Connection conn = MySQLDBHelper.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(
                    "SELECT * FROM users"
            );
            while (res.next()) {
                userDTOs.add(getUser(conn, res));
            }
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
        return userDTOs;
    }

    @Override
    public Optional<UserDTO> findByID(String id) {
        UserDTO target = null;
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM users WHERE id=?"
            );
            stmt.setString(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                target = getUser(conn, res);
            }
            //                TODO NoSuchElementException
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
        return Optional.ofNullable(target);
    }

    @Override
    public void create(UserDTO userDTO) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement userStmt = conn.prepareStatement(
                    "INSERT INTO users(id, name) VALUES (?, ?)"
            );
            userStmt.setString(1, userDTO.getID());
            userStmt.setString(2, userDTO.getName());
            userStmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void update(UserDTO userDTO){
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement userStmt = conn.prepareStatement(
                    "UPDATE users SET name=? WHERE id=?"
            );
            userStmt.setString(1, userDTO.getName());
            userStmt.setString(2, userDTO.getID());
            userStmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void remove(String userID) {
        try(Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM users WHERE id=?"
            );
            stmt.setString(1, userID);
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
