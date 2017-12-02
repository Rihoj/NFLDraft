/**
 * Program: NFLDraft
 * File: RosterScene.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nfldraft.managers.*;
import nfldraft.scenes.abstracts.AbstractPlayerListView;

public class RosterScene extends AbstractPlayerListView {

    public RosterScene(Stage window, TeamManager teamManager, NFLPlayerManager playerManager) {
        super(window, "Roster", teamManager, playerManager);
        createScene(teamManager.getCurrentTeam());
    }

    @Override
    protected final void addActions() {
        HBox actionsHbox = new HBox(50);
        actionsHbox.prefHeight(100);
        actionsHbox.prefWidth(200);
        Button addPlayer = new Button("View Players");
        addPlayer.getStyleClass().add("primary");
        addPlayer.setOnAction(e -> {
            AddPlayerScene addPlayerScene = new AddPlayerScene(window, teamManager, playerManager);
        });
        rightVbox.getChildren().add(addPlayer);
    }

}
