/**
 * Program: NFLDraft
 * File: RosterScene.java
 * Summary: This is the scene that displays the team roster.
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import nfldraft.classes.NFLPlayer;
import nfldraft.interfaces.IsSceneView;
import nfldraft.managers.*;
import nfldraft.scenes.abstracts.AbstractPlayerListView;

public class RosterScene extends AbstractPlayerListView implements IsSceneView {

    //creates a button variable for removing players
    private Button removePlayer;

    /**
     * Builds up the class preparing it to be loaded.
     *
     * @param teamManager
     * @param playerManager
     */
    public RosterScene(TeamManager teamManager, NFLPlayerManager playerManager) {
        super("Roster", teamManager, playerManager);
    }

    /**
     * Creates and returns the scene.
     *
     * @return
     */
    @Override
    public Scene loadScene() {
        createScene(teamManager.getCurrentTeam());
        setPageName(teamManager.getCurrentTeam().getName() + " Roster");
        disableButtons();
        return getScene();
    }

    /**
     * Updates and returns the scene.
     *
     * @return Scene
     */
    @Override
    public Scene updateScene() {
        updateRosterList(teamManager.getCurrentTeam());
        disableButtons();
        return getScene();
    }

    /**
     * Add action buttons to the scene.
     */
    @Override
    protected final void addActions() {
        HBox actionsHbox = new HBox(50);
        actionsHbox.prefHeight(100);
        actionsHbox.prefWidth(400);
        Button viewPlayers = new Button("View Players");
        viewPlayers.getStyleClass().add("primary");
        viewPlayers.setOnAction(e -> {
            sceneManager.switchScene("AddPlayer");
        });

        removePlayer = new Button("Remove Player");
        removePlayer.getStyleClass().add("primary");
        removePlayer.setOnAction(e -> {
            NFLPlayer player = (NFLPlayer) roster.getSelectionModel().getSelectedItem();
            teamManager.getCurrentTeam().firePlayer(player);
            updateRosterList(teamManager.getCurrentTeam());
            setMessage("You have fired " + player.getFullName() + " from your team.");
        });

        actionsHbox.getChildren().addAll(viewPlayers, removePlayer);
        rightVbox.getChildren().add(actionsHbox);
    }

    /**
     * Disable any buttons that can not be used when no player is selected.
     */
    @Override
    protected void disableButtons() {
        removePlayer.setDisable(true);
    }

    /**
     * Enable any buttons that can be used when a player is selected.
     */
    @Override
    protected void enableButtons() {
        removePlayer.setDisable(false);
    }

}
