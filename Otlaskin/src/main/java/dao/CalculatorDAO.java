package dao;

import domain.Operation;

import java.util.List;

/**
 * Created by alecsiikaluoma on 13.12.2018.
 * Implements an interface for manipulating calculator data.
 */
public interface CalculatorDAO {

    /**
     * Gets all operations from the database.
     * @return Returns them as a list of operations.
     */
    List<Operation> getAll();

    /**
     * Deletes all operations from the database.
     */
    void deleteAll();

    /**
     * Adds an operation to database.
     * @param operation Operation as an operation object which provides information about values and which operation.
     */
    void add(Operation operation);

}
