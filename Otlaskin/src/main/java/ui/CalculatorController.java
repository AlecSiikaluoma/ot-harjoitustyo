package ui;

import dao.CalculatorDAO;
import domain.CalculatorMemory;
import domain.Operation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import domain.Calculator;
import domain.Calculator.Operator;
import javafx.scene.control.Label;
import javafx.scene.paint.*;

import java.util.List;

/**
 * Created by alecsiikaluoma on 26.11.2018.
 */
public class CalculatorController extends FlowPane {

    private Main main;
    private Calculator calculator;
    private CalculatorMemory memory;

    public CalculatorController() {
        CalculatorDAO dao = new CalculatorDAO();
        calculator = new Calculator(dao);
        this.memory = calculator.getMemory();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private TextField input;

    @FXML
    private VBox history;

    @FXML
    public void clear() {
        input.setText("");
        calculator.clear();
        memory.clearNextOperation();
    }

    @FXML
    public void input(ActionEvent event) {
        Button source = (Button) event.getSource();
        int number = Integer.parseInt(source.getText());
        input.setText(input.getText() + number);
        if(!memory.operationPending()) {
            calculator.init(Double.parseDouble(input.getText()));
        }
    }

    @FXML
    public void results() {
        operate();
    }

    @FXML
    public void addition() {
        evaluate(Operator.ADDITION);
    }

    @FXML
    public void substraction() {
        evaluate(Operator.SUBSTRACTION);
    }

    @FXML
    public void multiplication() {
        evaluate(Operator.MULTIPLICATION);
    }

    @FXML
    public void division() {
        evaluate(Operator.DIVISION);
    }

    @FXML
    public void makeDecimal() {
        if(memory.operationPending()) {
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
        if(!memory.operationPending()) {
            this.calculator.multiplication(-1);
            reloadValue();
        }
    }

    @FXML
    public void clearData() {
        this.calculator.clearHistory();
        this.reloadHistory();
    }

    private void reloadHistory() {
        history.getChildren().clear();
        history.setPadding(new Insets(10));
        List<Operation> historyData = this.calculator.getHistory();
        for(Operation o : historyData) {
            Button lab = new Button();
            lab.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    clear();
                    calculator.init(o.getResult());
                    input.setText(o.getResult() + "");
                }
            });

            String text = "";
            text += o.getValue1();
            text += operatorToValue(o.getOperator());
            text += o.getValue2();
            text += "=";
            text += o.getResult();
            Pane pane = new Pane();
            pane.getChildren().add(lab);
            lab.setText(text);
            this.history.getChildren().add(pane);
        }
    }

    private String operatorToValue(Operator o) {
        String operationCharacter = "";
        switch (o) {
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
        return operationCharacter;
    }

    private void reloadValue() {
        this.input.setText("" + calculator.getValue());
    }

    private void operate() {
        if(!memory.operationPending()) {
            return ;
        }
        String text = input.getText();
        if(input.getText().substring(0,1).equals("-")) {
            text = input.getText().substring(1,input.getText().length());
        }
        String[] values = text.split("\\+|x|\\/|\\-");
        if(values.length >= 2) {
            double value = Double.parseDouble(values[1]);
            calculator.performFromMemory(value);
        }
        this.reloadHistory();
        input.setText("" + calculator.getValue());
        memory.clearNextOperation();
    }

    private void evaluate(Operator operator) {
        String operationCharacter = operatorToValue(operator);
        if(!memory.operationPending()) {
            this.calculator.init(Double.parseDouble(input.getText()));
        } else {
            operate();
        }
        input.setText(input.getText() + operationCharacter);
        memory.setNextOperation(operator);
    }



}
