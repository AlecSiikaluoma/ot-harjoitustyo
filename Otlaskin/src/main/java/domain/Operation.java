package domain;

/**
 * This class represent one operation that has been or is to be performed by the calculator.
 */

import domain.Calculator.Operator;

public class Operation {

    private double value1;
    private double value2;
    private double result;
    private Operator operation;

    /**
     * Creates an operation object with empty values.
     */
    public Operation() {
        this.value1 = 0;
        this.value2 = 0;
        this.result = 0;
        this.operation = Operator.NONE;
    }

    /**
     * Creates an operation object from parameters.
     * @param val1 The first value of the operation.
     * @param val2 The second values of the operation.
     * @param result Result of the operation as Operator objects.
     * @param operation The operation to be performed for values.
     */
    public Operation(double val1, double val2, double result, Operator operation) {
        this.value1 = val1;
        this.value2 = val2;
        this.result = result;
        this.operation = operation;
    }

    public double getValue1() {
        return value1;
    }

    public double getValue2() {
        return value2;
    }

    public double getResult() {
        return result;
    }

    public Operator getOperator() {
        return this.operation;
    }

}
