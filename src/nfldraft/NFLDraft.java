/**
 * Program: NFLDraft
 * File: NFLDraft.java
 * Summary:
 * Author: James Ray
 * Date: Nov 30, 2017
 */
package nfldraft;

import nfldraft.scenes.RosterScene;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nfldraft.classes.Team;
import nfldraft.managers.NFLPlayerManager;
import nfldraft.managers.SceneManager;
import nfldraft.managers.TeamManager;

public class NFLDraft extends Application {

    Stage window;
    TeamManager teamManager = new TeamManager();
    NFLPlayerManager playerManager = new NFLPlayerManager();
    SceneManager sceneManager;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        sceneManager = new SceneManager(window, teamManager, playerManager);
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25));
        root.setPrefSize(320, 200);
        root.setStyle("-fx-background-color: #eeeeee;");

        ObservableList<Team> oTeamList = FXCollections.observableList(teamManager.getTeams());
        ChoiceBox teamSelector = new ChoiceBox(oTeamList);
        teamSelector.getStyleClass().add("primary");
        root.getChildren().add(teamSelector);

        Button teamSelect = new Button("Choose Team");
        teamSelect.setOnAction(e -> {
            teamManager.setCurrentTeam((Team) teamSelector.getValue());
            sceneManager.switchScene("Roster");
        });
        teamSelect.setAlignment(Pos.CENTER);
        teamSelect.getStyleClass().add("primary");
        root.getChildren().add(teamSelect);

        Scene scene = new Scene(root, 320, 200);
        scene.getStylesheets().add("resources/css/bootstrap3.css");
        primaryStage.setTitle("NFL Draft - Choose Team");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
