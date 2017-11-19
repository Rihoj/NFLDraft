/**
 * Program: NFLDraft
 * File: NFLDraft.java
 * Summary: 
 * Author: James Ray
 * Date: Nov 18, 2017
 */

package nfldraft;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author james
 */
public class NFLDraft extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        Button btn2 = new Button();
        btn2.setText("Say 'Hello World2'");
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World2!");
            }
        });
        ObservableList<String> teams = 
                FXCollections.observableArrayList(
                        "Team 1",
                        "Team 2",
                        "Team 3"
                );
        ComboBox<String> teamComboBox = new ComboBox<String>();
        teamComboBox.setItems(teams);
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        HBox controlsHBox = new HBox(10, btn, btn2);
        HBox teamHBox = new HBox(10, teamComboBox);
        controlsHBox.setAlignment(Pos.CENTER);
        teamHBox.setAlignment(Pos.CENTER);
        root.setCenter(teamHBox);
        root.setBottom(controlsHBox);

        Scene scene = new Scene(root, 500, 250);

        primaryStage.setTitle("NFL Draft - Choose Team");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
