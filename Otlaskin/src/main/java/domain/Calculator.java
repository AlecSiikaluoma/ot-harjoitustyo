package domain;

public class Calculator {

    private double value;
    private boolean empty;

    public Calculator() {
        this.value = 0;
        this.empty = true;
    }

    public double getValue() {
        return this.value;
    }

    public void clear() {
        this.value = 0;
        this.empty = true;
    }

    public void init(double val) {
        this.value = val;
    }

    public void addition(double val) {
        value = value + val;
    }

    public void subsctraction(double val) {
        value = value - val;
    }

    public void multiplication(double val) {
        value = value * val;
    }

    public void division(double val) {
        value = value / val;
    }

}
