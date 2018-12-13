package dao;

import domain.Calculator;
import domain.Operation;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by alecsiikaluoma on 8.12.2018.
 * This class is a database object which is used to interface with the database tables.
 */
public class DatabaseCalculatorDAO implements CalculatorDAO {

    private final static String DEFAULT_DATABASE_PATH = "db/calculator.db";
    private String path;

    /**
     * Init database path.
     */
    public DatabaseCalculatorDAO() {
        this.path = this.DEFAULT_DATABASE_PATH;
    }

    /**
     * Gets the operation history from database.
     * @return A list of operation objects.
     */
    public List<Operation> getAll() {
        ArrayList<Operation> operations = new ArrayList<>();
        String sql = "SELECT value1, value2, result, operation FROM calculator;";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + this.path);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    operations.add(new Operation(rs.getDouble("value1"), rs.getDouble("value2"), rs.getDouble("result"), Calculator.Operator.valueOf(rs.getString("operation"))));

                }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return operations;
    }

    /**
     * Deletes all the history.
     */
    public void deleteAll() {
        String sql = "DELETE FROM calculator;";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + this.path);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Add one operation to the history.
     * @param operation Operation to be added
     */
    public void add(Operation operation) {
        String sql = "INSERT INTO calculator(value1, value2, result, operation) VALUES (?,?,?,?);";
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + this.path);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, operation.getValue1());
            pstmt.setDouble(2, operation.getValue2());
            pstmt.setDouble(3, operation.getResult());
            pstmt.setString(4, operation.getOperator().name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


}
