import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import jdk.nashorn.internal.runtime.OptimisticReturnFilters;
import org.omg.CORBA.INTERNAL;

import java.io.IOException;

/**
 * Created by alecsiikaluoma on 26.11.2018.
 */
public class CalculatorController extends FlowPane {


    private Main main;
    private boolean operationPending = false;
    private Calculator calculator;

    private Operations nextOperation = Operations.NONE;

    public enum Operations {
        ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION, NONE
    }

    public CalculatorController() {
        calculator = new Calculator();
    }

    @FXML
    private TextField input;

    public void setMain(Main main) {
        this.main = main;
    }

    private void operate() {
        if(this.nextOperation == Operations.NONE) {
            return ;
        }
        if (nextOperation == Operations.ADDITION) {
            String[] values = input.getText().split("\\+");
            if(values.length >= 2) {
                int value1 = Integer.parseInt(values[0]);
                int value2 = Integer.parseInt(values[1]);
                calculator.addition(value2);
            }
        } else if (nextOperation == Operations.SUBSTRACTION) {
            String[] values = input.getText().split("\\-");
            if(values.length >= 2) {
                int value1 = Integer.parseInt(values[0]);
                int value2 = Integer.parseInt(values[1]);
                calculator.subsctraction(value2);
            }
        } else if (nextOperation == Operations.MULTIPLICATION) {
            String[] values = input.getText().split("\\-");
            if(values.length >= 2) {
                int value1 = Integer.parseInt(values[0]);
                int value2 = Integer.parseInt(values[1]);
                calculator.multiplication(value2);
            }
        } else if (nextOperation == Operations.DIVISION) {
            String[] values = input.getText().split("\\-");
            if(values.length >= 2) {
                int value1 = Integer.parseInt(values[0]);
                int value2 = Integer.parseInt(values[1]);
                calculator.division(value2);
            }
        }
        input.setText("" + calculator.getValue());
        operationPending = false;
        nextOperation = Operations.NONE;
    }

    @FXML
    public void clear() {
        input.setText("");
        calculator.clear();
        operationPending = false;
        nextOperation = Operations.NONE;
    }

    @FXML
    public void input(ActionEvent event) {
        Button source = (Button) event.getSource();
        System.out.println(source.getText());
        int number = Integer.parseInt(source.getText());
        input.setText(input.getText() + number);
    }

    @FXML
    public void results() {
        operate();
    }

    @FXML
    public void addition() {
        if(!operationPending) {
            this.calculator.init(Integer.parseInt(input.getText()));
            this.operationPending = true;
            input.setText(input.getText() + "+");
            nextOperation = Operations.ADDITION;
        } else {
            operate();
            input.setText(input.getText() + "+");
            operationPending = true;
            nextOperation = Operations.ADDITION;
        }
    }

    @FXML
    public void substraction() {
        if(!operationPending) {
            this.calculator.init(Integer.parseInt(input.getText()));
            this.operationPending = true;
            input.setText(input.getText() + "-");
            nextOperation = Operations.SUBSTRACTION;
        } else {
           operate();
           input.setText(input.getText() + "-");
           operationPending = true;
            nextOperation = Operations.SUBSTRACTION;
        }
    }

    @FXML
    public void multiplication() {
        if(!operationPending) {
            this.calculator.init(Integer.parseInt(input.getText()));
            this.operationPending = true;
            input.setText(input.getText() + "-");
            nextOperation = Operations.MULTIPLICATION;
        } else {
            operate();
            input.setText(input.getText() + "-");
            operationPending = true;
            nextOperation = Operations.MULTIPLICATION;
        }
    }

    @FXML
    public void division() {
        if(!operationPending) {
            this.calculator.init(Integer.parseInt(input.getText()));
            this.operationPending = true;
            input.setText(input.getText() + "-");
            nextOperation = Operations.DIVISION;
        } else {
            operate();
            input.setText(input.getText() + "-");
            operationPending = true;
            nextOperation = Operations.DIVISION;
        }
    }

}
