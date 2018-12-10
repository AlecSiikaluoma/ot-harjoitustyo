package domain;

/**
 * Created by alecsiikaluoma on 10.12.2018.
 */

import domain.Calculator.Operator;

public class CalculatorMemory {

    private Operator nextOperation;

    public CalculatorMemory() {
        this.nextOperation = Operator.NONE;
    }

    /**
     * Sets the next operation to be the given parameter.
     * @param operator Whatever operation is to be performed next.
     */
    public void setNextOperation(Operator operator) {
        this.nextOperation = operator;
    }

    /**
     * Clears the next operation variable.
     */
    public void clearNextOperation() {
        this.nextOperation = Operator.NONE;
    }

    /**
     * @return The next operation to be performed.
     */
    public Operator getNextOperation() {
        return this.nextOperation;
    }

    /**
     * Checks if there is an operation waiting to be done.
     * @return True if an operation is waiting to be executed.
     */
    public boolean operationPending() {
        return nextOperation != Operator.NONE;
    }


}
