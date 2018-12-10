package domain;

import dao.CalculatorDAO;

import java.util.List;

public class Calculator {

    private double value;
    private boolean empty;

    private final CalculatorDAO calculatorDao;


    public enum Operator {
        ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION, NONE
    }

    /**
     * Initalizes new calculator with state 0 and set empty flag true. Use database object to save operations
     */
    public Calculator(CalculatorDAO dao) {
        this.calculatorDao = dao;
        this.value = 0;
        this.empty = true;
    }

    /**
     * Initalizes new calculator with vaue and set empty flag true. Use database object to save operations.
     * @return Initial value.
     */
    public Calculator(CalculatorDAO dao, double value) {
        this.calculatorDao = dao;
        this.value = value;
        this.empty = true;
    }

    public List<Operation> getHistory() {
        return this.calculatorDao.getAll();
    }

    public void clearData() {
        this.calculatorDao.deleteAll();
    }

    /**
     * @return Calculator's current state.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Clears the calculator by setting state 0 and empty flag true.
     */
    public void clear() {
        this.value = 0;
        this.empty = true;
    }

    /**
     * Allows to set calculator state manually.
     * @param val State to be updated.
     */
    public void init(double val) {
        this.value = val;
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
     * Performs substraction operation with parameter and current state.
     * @param val Value to be substracted
     */
    public void subsctraction(double val) {
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
