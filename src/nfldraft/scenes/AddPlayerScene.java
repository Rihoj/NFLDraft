/**
 * Program: NFLDraft
 * File: AddPlayerScene.java
 * Summary: This is the scene that displays the players from the player manager and allows TEAM CEOs to recruit players.
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import nfldraft.classes.NFLPlayer;
import nfldraft.interfaces.IsSceneView;
import nfldraft.managers.NFLPlayerManager;
import nfldraft.managers.TeamManager;
import nfldraft.scenes.abstracts.AbstractPlayerListView;

public class AddPlayerScene extends AbstractPlayerListView implements IsSceneView {

    //Create the button for viewing players.
    private Button addPlayer;

    /**
     * Build up the Add Player Scene class.
     *
     * @param teamManager
     * @param playerManager
     */
    public AddPlayerScene(TeamManager teamManager, NFLPlayerManager playerManager) {
        super("Add Player", teamManager, playerManager);
    }

    /**
     * Creates and returns the scene.
     *
     * @return Scene
     */
    @Override
    public Scene loadScene() {
        setPageName("Player Manager");
        createScene(playerManager);
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
        updateRosterList(playerManager);
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
        addPlayer = new Button("Recruit Player");
        addPlayer.getStyleClass().add("primary");
        addPlayer.setOnAction(e -> {
            NFLPlayer currentPlayer = (NFLPlayer) roster.getSelectionModel().getSelectedItem();
            if (currentPlayer != null) {
                teamManager.getCurrentTeam().addPlayer(currentPlayer);
                disableButtons();
                setMessage("You have added " + currentPlayer.getFullName() + " to your roster.");
            }
        });
        Button returnToRoster = new Button("Return to Roster");
        returnToRoster.getStyleClass().add("primary");
        returnToRoster.setOnAction(e -> {
            sceneManager.switchScene("Roster");
        });
        actionsHbox.getChildren().addAll(addPlayer, returnToRoster);
        rightVbox.getChildren().add(actionsHbox);
    }

    /**
     * Disable any buttons that can not be used when no player is selected.
     */
    @Override
    protected void disableButtons() {
        addPlayer.setDisable(true);
    }

    /**
     * Enable any buttons that can be used when a player is selected.
     */
    @Override
    protected void enableButtons() {
        addPlayer.setDisable(false);
    }

}
