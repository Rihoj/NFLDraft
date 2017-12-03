/**
 * Program: NFLDraft
 * File: AbstractScene.java
 * Summary: This controls the team select scene.
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nfldraft.scenes.abstracts.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import nfldraft.classes.Team;
import nfldraft.interfaces.IsSceneView;
import nfldraft.managers.*;

public class TeamSelectScene extends AbstractScene implements IsSceneView {

    /**
     * Constructor for class.
     *
     * @param teamManager
     * @param playerManager
     */
    public TeamSelectScene(TeamManager teamManager, NFLPlayerManager playerManager) {
        super("Choose Team", teamManager, playerManager);
    }

    /**
     * Load the scene.
     *
     * @return Scene
     */
    @Override
    public Scene loadScene() {
        setPageName("Choose your team!");
        createScene();
        return getScene();
    }

    /**
     * Creates the scene.
     */
    private void createScene() {
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
    }

    /**
     * No updates were needed but still need to return the scene.
     *
     * @return
     */
    @Override
    public Scene updateScene() {
        return getScene();
    }

}
