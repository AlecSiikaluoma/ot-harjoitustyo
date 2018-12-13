package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import ui.CalculatorController;
import org.sqlite.JDBC;

import java.sql.*;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Otlaskin.fxml"));
            FlowPane pane = loader.load();
            CalculatorController calculatorController = loader.getController();
            calculatorController.setMain(this);
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();

            //Initialize database
            this.initDatabase();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initDatabase() {
        Connection connection = null;
        try
        {
            // create a database connection
            Class.forName("org.sqlite.JDBC");
            //connection = DriverManager.getConnection(this.getClass().getResource("calculator.db").toString());
            connection = DriverManager.getConnection("jdbc:sqlite:db/calculator.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(10);

            // create
            statement.executeUpdate("create table if not exists calculator (id integer primary key, value1 real, value2 real, result real, operation string)");
        }
        catch(SQLException | ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}