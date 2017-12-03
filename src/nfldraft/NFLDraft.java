/**
 * Program: NFLDraft
 * File: NFLDraft.java
 * Summary:
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

    Stage window;
    TeamManager teamManager = new TeamManager();
    NFLPlayerManager playerManager = new NFLPlayerManager();
    SceneManager sceneManager;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        sceneManager = new SceneManager(window, teamManager, playerManager);
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
