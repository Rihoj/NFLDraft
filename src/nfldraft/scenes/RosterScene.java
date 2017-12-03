/**
 * Program: NFLDraft
 * File: RosterScene.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nfldraft.classes.NFLPlayer;
import nfldraft.interfaces.IsSceneView;
import nfldraft.managers.*;
import nfldraft.scenes.abstracts.AbstractPlayerListView;

public class RosterScene extends AbstractPlayerListView implements IsSceneView {

    public RosterScene(Stage window, TeamManager teamManager, NFLPlayerManager playerManager) {
        super(window, "Roster", teamManager, playerManager);
    }

    @Override
    public Scene loadScene() {
        createScene(teamManager.getCurrentTeam());
        setPageName(teamManager.getCurrentTeam().getName() + " Roster");
        return getScene();
    }

    @Override
    public Scene updateScene(){
        updateRosterList(teamManager.getCurrentTeam());
        return getScene();
    }
    @Override
    protected final void addActions() {
        HBox actionsHbox = new HBox(50);
        actionsHbox.prefHeight(100);
        actionsHbox.prefWidth(400);
        Button addPlayer = new Button("View Players");
        addPlayer.getStyleClass().add("primary");
        addPlayer.setOnAction(e -> {
            sceneManager.switchScene("AddPlayer");
        });

        Button removePlayer = new Button("Remove Player");
        removePlayer.getStyleClass().add("primary");
        removePlayer.setOnAction(e -> {
            teamManager.getCurrentTeam().firePlayer((NFLPlayer) roster.getSelectionModel().getSelectedItem());
            updateRosterList(teamManager.getCurrentTeam());
        });


        actionsHbox.getChildren().addAll(addPlayer, removePlayer);
        rightVbox.getChildren().add(actionsHbox);
    }

}
