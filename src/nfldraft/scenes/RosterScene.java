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

    private Button removePlayer;
    public RosterScene(Stage window, TeamManager teamManager, NFLPlayerManager playerManager) {
        super(window, "Roster", teamManager, playerManager);
    }

    @Override
    public Scene loadScene() {
        createScene(teamManager.getCurrentTeam());
        setPageName(teamManager.getCurrentTeam().getName() + " Roster");
        disableButtons();
        return getScene();
    }

    @Override
    public Scene updateScene(){
        updateRosterList(teamManager.getCurrentTeam());
        disableButtons();
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

        removePlayer = new Button("Remove Player");
        removePlayer.getStyleClass().add("primary");
        removePlayer.setOnAction(e -> {
            NFLPlayer player = (NFLPlayer) roster.getSelectionModel().getSelectedItem();
            teamManager.getCurrentTeam().firePlayer(player);
            updateRosterList(teamManager.getCurrentTeam());
            setMessage("You have fired "+player.getFullName()+ " from your team.");
        });


        actionsHbox.getChildren().addAll(addPlayer, removePlayer);
        rightVbox.getChildren().add(actionsHbox);
    }

    @Override
    protected void disableButtons() {
        removePlayer.setDisable(true);
    }

    @Override
    protected void enableButtons() {
        removePlayer.setDisable(false);
    }


}
