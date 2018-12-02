package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import domain.Calculator;

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

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private TextField input;

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
        int number = Integer.parseInt(source.getText());
        input.setText(input.getText() + number);
        if(!operationPending) {
            calculator.init(Double.parseDouble(input.getText()));
        }
    }

    @FXML
    public void results() {
        operate();
    }

    @FXML
    public void addition() {
        evaluate(Operations.ADDITION);
    }

    @FXML
    public void substraction() {
        evaluate(Operations.SUBSTRACTION);
    }

    @FXML
    public void multiplication() {
        evaluate(Operations.MULTIPLICATION);
    }

    @FXML
    public void division() {
        evaluate(Operations.DIVISION);
    }

    @FXML
    public void makeDecimal() {
        if(operationPending) {
            String text = input.getText();
            if(input.getText().substring(0,1).equals("-")) {
                text = input.getText().substring(1,input.getText().length());
            }
            String[] values = text.split("[x\\-\\+\\/]");
            input.setText(input.getText().substring(0, values[0].length()+2) + values[1] + ".");
        } else {
            input.setText(input.getText() + ".");
        }
    }

    @FXML
    public void negate() {
        if(!operationPending) {
            this.calculator.multiplication(-1);
            reloadValue();
        }
    }

    private void reloadValue() {
        this.input.setText("" + calculator.getValue());
    }

    private void operate() {
        if(this.nextOperation == Operations.NONE) {
            return ;
        }
        String text = input.getText();
        if(input.getText().substring(0,1).equals("-")) {
            text = input.getText().substring(1,input.getText().length());
        }
        if (nextOperation == Operations.ADDITION) {
            String[] values = text.split("\\+");
            if(values.length >= 2) {
                double value = Double.parseDouble(values[1]);
                calculator.addition(value);
            }
        } else if (nextOperation == Operations.SUBSTRACTION) {
            String[] values = text.split("\\-");
            if(values.length >= 2) {
                double value = Double.parseDouble(values[1]);
                calculator.subsctraction(value);
            }
        } else if (nextOperation == Operations.MULTIPLICATION) {
            String[] values = text.split("x");
            if(values.length >= 2) {
                double value = Double.parseDouble(values[1]);
                calculator.multiplication(value);
            }
        } else if (nextOperation == Operations.DIVISION) {
            String[] values = text.split("/");
            if(values.length >= 2) {
                double value = Double.parseDouble(values[1]);
                calculator.division(value);
            }
        }
        input.setText("" + calculator.getValue());
        operationPending = false;
        nextOperation = Operations.NONE;
    }

    private void evaluate(Operations operator) {
        String operationCharacter = "";
        switch (operator) {
            case ADDITION:
                operationCharacter = "+";
                break;
            case MULTIPLICATION:
                operationCharacter = "x";
                break;
            case DIVISION:
                operationCharacter = "/";
                break;
            case SUBSTRACTION:
                operationCharacter = "-";
                break;
            default:
                throw new Error("Operation not defined.");
        }
        if(!operationPending) {
            this.calculator.init(Double.parseDouble(input.getText()));
            this.operationPending = true;
            input.setText(input.getText() + operationCharacter);
            nextOperation = operator;
        } else {
            operate();
            input.setText(input.getText() + operationCharacter);
            operationPending = true;
            nextOperation = operator;
        }
    }



}
