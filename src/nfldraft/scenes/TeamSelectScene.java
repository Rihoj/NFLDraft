/**
 * Program: NFLDraft
 * File: AbstractScene.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import nfldraft.scenes.abstracts.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import nfldraft.classes.Team;
import nfldraft.interfaces.IsSceneView;
import nfldraft.managers.*;

public class TeamSelectScene extends AbstractScene implements IsSceneView {

    public TeamSelectScene(Stage window, TeamManager teamManager, NFLPlayerManager playerManager) {
        super(window, "Choose Team", teamManager, playerManager);
    }

    @Override
    public Scene loadScene() {
        setPageName("Choose your team!");
        createScene();
        return getScene();
    }

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

    @Override
    public Scene updateScene() {
        return getScene();
    }
    
}
