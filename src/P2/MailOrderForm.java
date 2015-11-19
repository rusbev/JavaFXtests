package P2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by jmackay2 on 10/29/2015.
 */
public class MailOrderForm extends Application {

    // These objects must be visible to the inner class
    TextField tfName = new TextField();
    TextField tfAddress = new TextField();
    TextField tfCity = new TextField();
    TextField tfState = new TextField();
    TextField tfZip = new TextField();
    Label lbArea = new Label();
    Label lbPerimiter = new Label();

    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));

        // Set horizontal and vertical gaps between elements
        pane.setHgap(5);
        pane.setVgap(5);

        // Add Name label and field
        pane.add(new Label("Name:"), 1, 0);
        pane.add(tfName, 2, 0);

        // Add Address label and field
        pane.add(new Label("Address:"), 1, 1);
        pane.add(tfAddress, 2, 1);

        //Add City label and field
        pane.add(new Label("City:"), 1, 2);
        pane.add(tfCity, 2, 2);

        //Add State label and field
        pane.add(new Label("State:"), 3, 2);
        pane.add(tfState, 4, 2);

        //Add Zip label and field
        pane.add(new Label("ZIP:"), 5, 2);
        pane.add(tfZip, 6, 2);

        // Add a button
        Button btAdd = new Button("Ugh");
        pane.add(btAdd, 1, 3);
        GridPane.setHalignment(btAdd, HPos.LEFT);

        // Add a button
        Button bt2 = new Button("Ehh");
        pane.add(bt2, 2, 3);

        // Add a button
        Button bt3 = new Button("Arrg");
        pane.add(bt3, 3, 3);

        // Add a button
        Button bt4 = new Button("Woof");
        pane.add(bt4, 4, 3);

        // Set a handler for the button
        ButtonHandlerClass handler1 = new ButtonHandlerClass();
        btAdd.setOnAction(handler1);

        // Add the name label field at the bottom
        pane.add(lbArea, 1, 4);

        // Add the name label field at the bottom
        pane.add(lbPerimiter, 1, 5);

        // Put the pane in the scene
        Scene scene = new Scene(pane, 750, 200);

        // Set the stage up, put the scene on the stage and show it
        primaryStage.setTitle("Address Log and Secret Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // This inner class defines the action when the button is pressed
    class ButtonHandlerClass implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            // DOES THE MATH

            try {
                double intLength = new Double(tfName.getText()).doubleValue();
                double intWidth = new Double(tfAddress.getText()).doubleValue();

                // Build a string from the two text fields
                String Area =	tfName.getText() + " " +
                        tfAddress.getText() + " ";
                // Display the name in a label field
                lbArea.setText("Area: " + intLength * intWidth);

                String Perimiter =	tfName.getText() + " " +
                        tfAddress.getText() + " ";
                // Display the name in a label field
                lbPerimiter.setText("Perimiter: " + ((2*intLength) + (2*intWidth)));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null,"Input must be a number.");
            }
        }
    }
}