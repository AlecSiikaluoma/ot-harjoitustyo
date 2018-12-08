package domain;

/**
 * Created by alecsiikaluoma on 8.12.2018.
 */

import domain.Calculator.Operator;

public class Operation {

    private double value1;
    private double value2;
    private double result;
    private Operator operation;

    public Operation() {
        this.value1 = 0;
        this.value2 = 0;
        this.result = 0;
        this.operation = Operator.NONE;
    }

    public Operation(double val1, double val2, double result, String operation) {
        this.value1 = val1;
        this.value2 = val2;
        this.result = result;
        this.operation = Operator.valueOf(operation);
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
