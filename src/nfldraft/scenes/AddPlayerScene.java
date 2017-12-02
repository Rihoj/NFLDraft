/**
 * Program: NFLDraft
 * File: AddPlayerScene.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nfldraft.classes.NFLPlayer;
import nfldraft.classes.Team;
import nfldraft.managers.NFLPlayerManager;
import nfldraft.managers.TeamManager;
import nfldraft.scenes.abstracts.AbstractPlayerListView;

public class AddPlayerScene extends AbstractPlayerListView{

    private Team team;

    public AddPlayerScene(Stage window, TeamManager teamManager, NFLPlayerManager playerManager) {
        super(window, "Add Player", teamManager, playerManager);
        setPageName("Player Manager");
        createScene(playerManager);
    }

    @Override
    protected final void addActions() {
        HBox actionsHbox = new HBox(50);
        actionsHbox.prefHeight(100);
        actionsHbox.prefWidth(200);
        Button addPlayer = new Button("Recruit Player");
        addPlayer.getStyleClass().add("primary");
        addPlayer.setOnAction(e -> {
            teamManager.getCurrentTeam().addPlayer((NFLPlayer) roster.getSelectionModel().getSelectedItem());
            RosterScene rosterScene = new RosterScene(window, teamManager, playerManager);
        });
        rightVbox.getChildren().add(addPlayer);
    }
    
}
