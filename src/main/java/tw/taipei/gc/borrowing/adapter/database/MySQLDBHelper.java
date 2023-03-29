package tw.taipei.gc.borrowing.adapter.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLDBHelper {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BorrowingDBTest",
                    "root",
                    "yxul4dj4"
            );
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return conn;
    }

    public static void printException(SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }
}
