/**
 * Program: NFLDraft
 * File: AddPlayerScene.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nfldraft.classes.NFLPlayer;
import nfldraft.classes.Team;
import nfldraft.interfaces.IsSceneView;
import nfldraft.managers.NFLPlayerManager;
import nfldraft.managers.TeamManager;
import nfldraft.scenes.abstracts.AbstractPlayerListView;

public class AddPlayerScene extends AbstractPlayerListView implements IsSceneView{

    private Button addPlayer;
    public AddPlayerScene(Stage window, TeamManager teamManager, NFLPlayerManager playerManager) {
        super(window, "Add Player", teamManager, playerManager);
    }


    @Override
    public Scene loadScene() {
        setPageName("Player Manager");
        createScene(playerManager);
        disableButtons();
        return getScene();
    }
    
    @Override
    public Scene updateScene(){
        updateRosterList(playerManager);
        disableButtons();
        return getScene();
    }

    @Override
    protected final void addActions() {
        HBox actionsHbox = new HBox(50);
        actionsHbox.prefHeight(100);
        actionsHbox.prefWidth(400);
        addPlayer = new Button("Recruit Player");
        addPlayer.getStyleClass().add("primary");
        addPlayer.setOnAction(e -> {
            NFLPlayer currentPlayer = (NFLPlayer) roster.getSelectionModel().getSelectedItem();
            if(currentPlayer != null){
                teamManager.getCurrentTeam().addPlayer(currentPlayer);
                disableButtons();
                setMessage("You have added "+currentPlayer.getFullName()+" to your roster.");
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

    @Override
    protected void disableButtons() {
        addPlayer.setDisable(true);
    }

    @Override
    protected void enableButtons() {
        addPlayer.setDisable(false);
    }

    
    
}
