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
    private long value;

    private Operations nextOperation;

    public enum Operations {
        ADDITION, SUBSTRACTION
    }

    @FXML
    private TextField input;

    public void setMain(Main main) {

        this.main = main;
    }

    private void operate() {
        if (nextOperation == Operations.ADDITION) {
            String[] values = input.getText().split("\\+");
            if(values.length >= 2) {
                int value1 = Integer.parseInt(values[0]);
                int value2 = Integer.parseInt(values[1]);
                value = value1 + value2;
            }
        } else if (nextOperation == Operations.SUBSTRACTION) {
            String[] values = input.getText().split("\\-");
            if(values.length >= 2) {
                int value1 = Integer.parseInt(values[0]);
                int value2 = Integer.parseInt(values[1]);
                value = value1 - value2;
            }
        }
        input.setText("" + value);
        operationPending = false;
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
            this.operationPending = true;
            input.setText(input.getText() + "+");
            nextOperation = Operations.ADDITION;
        } else {
            operate();
            if(nextOperation != Operations.ADDITION) {
                input.setText(input.getText() + "+");
            }
        }
    }

    @FXML
    public void substraction() {
        if(!operationPending) {
            this.operationPending = true;
            input.setText(input.getText() + "-");
            nextOperation = Operations.SUBSTRACTION;
        } else {
           operate();
            if(nextOperation != Operations.SUBSTRACTION) {
                input.setText(input.getText() + "-");
            }
        }
    }

}
