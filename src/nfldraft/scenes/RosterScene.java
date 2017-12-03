/**
 * Program: NFLDraft
 * File: RosterScene.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
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
    protected final void addActions() {
        HBox actionsHbox = new HBox(50);
        actionsHbox.prefHeight(100);
        actionsHbox.prefWidth(200);
        Button addPlayer = new Button("View Players");
        addPlayer.getStyleClass().add("primary");
        addPlayer.setOnAction(e -> {
            sceneManager.switchScene("AddPlayer");
        });
        rightVbox.getChildren().add(addPlayer);
    }

}
