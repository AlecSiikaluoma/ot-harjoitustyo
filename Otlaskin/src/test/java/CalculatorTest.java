/**
 * Created by alecsiikaluoma on 27.11.2018.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void addition() {
        calculator = new Calculator();
        calculator.init(10);
        calculator.addition(5);
        assertEquals(calculator.getValue(), 15);
        calculator.addition(25);
        assertEquals(calculator.getValue(), 40);
    }

    @Test
    public void substraction() {
        calculator = new Calculator();
        calculator.init(10);
        calculator.subsctraction(5);
        assertEquals(calculator.getValue(), 5);
        calculator.subsctraction(3);
        assertEquals(calculator.getValue(), 2);
    }

    @Test
    public void multiplication() {
        calculator = new Calculator();
        calculator.init(10);
        calculator.multiplication(5);
        assertEquals(calculator.getValue(), 50);
        calculator.multiplication(2);
        assertEquals(calculator.getValue(), 100);
    }

    @Test
    public void division() {
        calculator = new Calculator();
        calculator.init(20);
        calculator.division(2);
        assertEquals(calculator.getValue(), 10);
        calculator.division(2);
        assertEquals(calculator.getValue(), 5);
    }




}
