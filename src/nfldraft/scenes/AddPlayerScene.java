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

    private Team team;

    public AddPlayerScene(Stage window, TeamManager teamManager, NFLPlayerManager playerManager) {
        super(window, "Add Player", teamManager, playerManager);
    }


    @Override
    public Scene loadScene() {
        setPageName("Player Manager");
        createScene(playerManager);
        return getScene();
    }
    
    public Scene updateScene(){
        updateRosterList(playerManager);
        return getScene();
    }

    @Override
    protected final void addActions() {
        HBox actionsHbox = new HBox(50);
        actionsHbox.prefHeight(100);
        actionsHbox.prefWidth(400);
        Button addPlayer = new Button("Recruit Player");
        addPlayer.getStyleClass().add("primary");
        addPlayer.setOnAction(e -> {
            NFLPlayer currentPlayer = (NFLPlayer) roster.getSelectionModel().getSelectedItem();
            if(currentPlayer != null){
                teamManager.getCurrentTeam().addPlayer(currentPlayer);
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
    
}
