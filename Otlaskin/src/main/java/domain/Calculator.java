package domain;

public class Calculator {

    private double value;
    private boolean empty;

    /**
     * Initalizes new calculator with state 0 and sets empty flag true.
     */
    public Calculator() {
        this.value = 0;
        this.empty = true;
    }

    /**
     * Initalizes new calculator with vaue and sets empty flag true.
     * @return Initial value.
     */
    public Calculator(double value) {
        this.value = value;
        this.empty = true;
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
        value = value + val;
    }

    /**
     * Performs substraction operation with parameter and current state.
     * @param val Value to be substracted
     */
    public void subsctraction(double val) {
        value = value - val;
    }

    /**
     * Performs multiplication operation with parameter and current state.
     * @param val Value to be multiplied by.
     */
    public void multiplication(double val) {
        value = value * val;
    }

    /**
     * Performs division operation with parameter and current state.
     * @param val Dividing value.
     */
    public void division(double val) {
        if(val == 0.0) {
            throw new IllegalArgumentException("Tried to divide by zero");
        }
        value = value / val;
    }

}
