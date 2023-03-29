package tw.taipei.gc.borrowing.adapter.item.repository;

import tw.taipei.gc.borrowing.adapter.database.MySQLDBHelper;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemDTO;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLItemRepository implements ItemRepository {
    @Override
    public List<ItemDTO> findAll() {
        List<ItemDTO> itemDTOs = new ArrayList<>();
        try (Connection conn = MySQLDBHelper.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(
                    "SELECT * FROM items"
            );
            while (res.next()) {
                itemDTOs.add(new ItemDTO(
                        res.getString("id"),
                        res.getString("name")
                ));
            }
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
        return itemDTOs;
    }

    @Override
    public Optional<ItemDTO> findByID(String itemID) {
        ItemDTO target = null;
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM items WHERE id=?"
            );
            stmt.setString(1, itemID);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                target = new ItemDTO(
                        res.getString("id"),
                        res.getString("name")
                );
            }
            //                TODO NoSuchElementException
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
        return Optional.ofNullable(target);
    }

    @Override
    public void create(ItemDTO itemDTO) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO items(id, name) VALUES (?, ?)"
            );
            stmt.setString(1, itemDTO.getID());
            stmt.setString(2, itemDTO.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void update(ItemDTO itemDTO) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE items SET name=? WHERE id=?"
            );
            stmt.setString(1, itemDTO.getName());
            stmt.setString(2, itemDTO.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }

    @Override
    public void remove(String itemID) {
        try (Connection conn = MySQLDBHelper.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM items WHERE id=?"
            );
            stmt.setString(1, itemID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            MySQLDBHelper.printException(e);
        }
    }
}
