/**
 * Program: NFLDraft
 * File: NFLDraft.java
 * Summary: The main class to start the program.
 * Author: James Ray
 * Date: Nov 30, 2017
 */
package nfldraft;

import javafx.application.Application;
import javafx.stage.Stage;
import nfldraft.managers.NFLPlayerManager;
import nfldraft.managers.SceneManager;
import nfldraft.managers.TeamManager;

public class NFLDraft extends Application {

    //Create the TeamManager. Auto creates teams.
    TeamManager teamManager = new TeamManager();
    //Create the NFLPlayerManager. Auto Creates players.
    NFLPlayerManager playerManager = new NFLPlayerManager();
    //Create the SceneManager. Creates builds and loads sences.
    SceneManager sceneManager;

    /**
     * Assigns the window, set up the sceneManager, switches to first scene, and displays
     * the window.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        sceneManager = new SceneManager(primaryStage, teamManager, playerManager);
        sceneManager.switchScene("TeamSelect");
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
