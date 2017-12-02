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
import nfldraft.managers.TeamManager;

public class NFLDraft extends Application {

    Stage window;
    TeamManager teamManager = new TeamManager();
    NFLPlayerManager playerManager = new NFLPlayerManager();

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
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
            RosterScene rosterScene = new RosterScene(window, teamManager, playerManager);
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

    

    public static MenuBar getMenuBar(Stage window) {
        MenuItem closeFileMenuItem = new MenuItem("Close");
        closeFileMenuItem.setOnAction(e -> window.close());
        Menu fileMenu = new Menu("File", null, closeFileMenuItem);
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");
        MenuBar menuBar = new MenuBar(fileMenu, editMenu, helpMenu);
        return menuBar;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
