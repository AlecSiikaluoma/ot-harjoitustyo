import domain.Calculator;
import domain.CalculatorMemory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by alecsiikaluoma on 10.12.2018.
 */
public class CalculatorMemoryTest {

    CalculatorMemory mem;

    @Test
    public void setNext() {
        mem = new CalculatorMemory();
        mem.setNextOperation(Calculator.Operator.ADDITION);
        assertEquals(mem.getNextOperation(), Calculator.Operator.ADDITION);
    }

    @Test
    public void clearNext() {
        mem = new CalculatorMemory();
        mem.setNextOperation(Calculator.Operator.ADDITION);
        mem.clearNextOperation();
        assertEquals(mem.getNextOperation(), Calculator.Operator.NONE);
    }

    @Test
    public void operationPending() {
        mem = new CalculatorMemory();
        mem.setNextOperation(Calculator.Operator.ADDITION);
        assertTrue(mem.operationPending());
    }

    @Test
    public void operationNotPending() {
        mem = new CalculatorMemory();
        mem.setNextOperation(Calculator.Operator.ADDITION);
        mem.clearNextOperation();
        assertFalse(mem.operationPending());
    }

}
