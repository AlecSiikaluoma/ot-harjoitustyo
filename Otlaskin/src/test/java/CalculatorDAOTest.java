import dao.CalculatorDAO;
import domain.Calculator;
import domain.Operation;
import org.junit.Test;
import org.junit.Assert;


import java.util.List;

/**
 * Created by alecsiikaluoma on 10.12.2018.
 */
public class CalculatorDAOTest {

    CalculatorDAO db;

    @Test
    public void add() {
        db = new CalculatorDAO();

        Operation op = new Operation(5555,3333,1111, Calculator.Operator.ADDITION);
        db.add(op);
        List<Operation> data = db.getAll();
        int count = 0;
        for (Operation x : data) {
            if (x.getValue1() == 5555 && x.getValue2() == 3333 && x.getResult() == 1111) {
                count++;
            }
        }
        Assert.assertTrue(count > 0);
        db.deleteAll();
    }

    @Test
    public void deleteAll() {
        db = new CalculatorDAO();
        Operation op = new Operation(5555,3333,1111, Calculator.Operator.ADDITION);
        db.add(op);
        db.deleteAll();
        Assert.assertEquals(db.getAll().size(), 0);
    }

    @Test
    public void getAll() {
        db = new CalculatorDAO();
        db.deleteAll();

        Operation op = new Operation(5555,3333,1111, Calculator.Operator.ADDITION);
        db.add(op);
        op = new Operation(4444,3333,1111, Calculator.Operator.ADDITION);
        db.add(op);
        Assert.assertEquals(db.getAll().size(), 2);

        db.deleteAll();
    }


}
