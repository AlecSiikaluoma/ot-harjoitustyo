package domain;

import dao.CalculatorDAO;
import dao.DatabaseCalculatorDAO;

import java.util.List;

/***
 * This class represents the calculator, its operations and state.
 */
public class Calculator {

    private double value;
    private CalculatorMemory memory;

    private final CalculatorDAO calculatorDao;

    public enum Operator {
        ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION, NONE
    }

    /**
     * Initalizes new calculator with state 0 and saves database object to save operations
     */
    public Calculator(CalculatorDAO dao) {
        this.calculatorDao = dao;
        this.value = 0;
        this.memory = new CalculatorMemory();
    }

    /**
     * Initializes new calculator with value and saves database object to save operations.
     */
    public Calculator(CalculatorDAO dao, double value) {
        this.calculatorDao = dao;
        this.value = value;
        this.memory = new CalculatorMemory();
    }

    public CalculatorMemory getMemory() {
        return this.memory;
    }

    public List<Operation> getHistory() {
        return this.calculatorDao.getAll();
    }

    public double getValue() {
        return this.value;
    }


    /**
     * Clears the calculator history.
     */
    public void clearHistory() {
        this.calculatorDao.deleteAll();
    }


    /**
     * Clears the calculator by setting state 0 and empty flag true.
     */
    public void clear() {
        this.value = 0;
        this.memory.clearNextOperation();
    }

    /**
     * Allows to set calculator state manually.
     * @param val State to be updated.
     */
    public void init(double val) {
        this.value = val;
    }

    /**
     * Performs the next operation specified for the calculator.
     * @param val This value is used in performing the operation.
     */
    public void performFromMemory(double val) {
        if(memory.getNextOperation() == Operator.NONE) {
            return ;
        }
        switch (memory.getNextOperation()) {
            case ADDITION:
                this.addition(val);
                break;
            case SUBSTRACTION:
                this.subtraction(val);
                break;
            case MULTIPLICATION:
                this.multiplication(val);
                break;
            case DIVISION:
                this.division(val);
                break;
        }
    }

    /**
     * Performs addition operation with parameter and current state.
     * @param val Value to be added.
     */
    public void addition(double val) {
        double value1 = this.value;
        value = value + val;
        saveOperation(value1, val, Operator.ADDITION);
    }

    /**
     * Performs subtraction operation with parameter and current state.
     * @param val Value to be subtracted
     */
    public void subtraction(double val) {
        double value1 = this.value;
        value = value - val;
        saveOperation(value1, val, Operator.SUBSTRACTION);
    }

    /**
     * Performs multiplication operation with parameter and current state.
     * @param val Value to be multiplied by.
     */
    public void multiplication(double val) {
        double value1 = this.value;
        value = value * val;
        saveOperation(value1, val, Operator.MULTIPLICATION);
    }

    /**
     * Performs division operation with parameter and current state.
     * @param val Dividing value.
     */
    public void division(double val) {
        double value1 = this.value;
        if(val == 0.0) {
            throw new IllegalArgumentException("Tried to divide by zero");
        }
        value = value / val;
        saveOperation(value1, val, Operator.DIVISION);
    }


    private void saveOperation(double val1, double val2, Operator operator) {
        Operation o = new Operation(val1, val2, this.value, operator);
        calculatorDao.add(o);
    }

}
