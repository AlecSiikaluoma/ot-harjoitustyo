/**
 * Created by alecsiikaluoma on 27.11.2018.
 */
import dao.DatabaseCalculatorDAO;
import domain.Calculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;
    private DatabaseCalculatorDAO dao = new DatabaseCalculatorDAO();

    @Test
    public void performFromMemoryAddition() {
        calculator = new Calculator(dao);
        calculator.init(5);
        calculator.getMemory().setNextOperation(Calculator.Operator.ADDITION);
        calculator.performFromMemory(5);
        assertEquals(calculator.getValue(), 10, 0);
    }

    @Test
    public void performFromMemorySubtraction() {
        calculator = new Calculator(dao);
        calculator.init(5);
        calculator.getMemory().setNextOperation(Calculator.Operator.SUBSTRACTION);
        calculator.performFromMemory(2);
        assertEquals(calculator.getValue(), 3, 0);
    }

    @Test
    public void performFromMemoryDivision() {
        calculator = new Calculator(dao);
        calculator.init(10);
        calculator.getMemory().setNextOperation(Calculator.Operator.DIVISION);
        calculator.performFromMemory(5);
        assertEquals(calculator.getValue(), 2, 0);
    }

    @Test
    public void performFromMemoryMultiplication() {
        calculator = new Calculator(dao);
        calculator.init(5);
        calculator.getMemory().setNextOperation(Calculator.Operator.MULTIPLICATION);
        calculator.performFromMemory(5);
        assertEquals(calculator.getValue(), 25, 0);
    }

    @Test
    public void addition() {
        calculator = new Calculator(dao);
        calculator.init(10);
        calculator.addition(5);
        assertEquals(calculator.getValue(), 15.0, 0);
        calculator.addition(25);
        assertEquals(calculator.getValue(), 40.0, 0);
    }

    @Test
    public void substraction() {
        calculator = new Calculator(dao);
        calculator.init(10);
        calculator.subtraction(5);
        assertEquals(calculator.getValue(), 5.0, 0);
        calculator.subtraction(3);
        assertEquals(calculator.getValue(), 2.0, 0);
    }

    @Test
    public void multiplication() {
        calculator = new Calculator(dao);
        calculator.init(10);
        calculator.multiplication(5);
        assertEquals(calculator.getValue(), 50.0, 0);
        calculator.multiplication(2);
        assertEquals(calculator.getValue(), 100.0, 0);
    }

    @Test
    public void division() {
        calculator = new Calculator(dao);
        calculator.init(20);
        calculator.division(2);
        assertEquals(calculator.getValue(), 10.0, 0);
        calculator.division(2);
        assertEquals(calculator.getValue(), 5.0, 0);
    }


    @Test
    public void clear() {
        calculator = new Calculator(dao);
        calculator.init(10.0);
        calculator.addition(5.0);
        calculator.clear();
        assertEquals(calculator.getValue(), 0.0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideByZero() {
        calculator = new Calculator(dao, 5);
        calculator.division(0);
    }

}
