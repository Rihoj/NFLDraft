/**
 * Program: NFLDraft
 * File: AbstractScene.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes.abstracts;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nfldraft.NFLDraft;
import nfldraft.managers.*;

public class AbstractScene {

    protected Stage window;
    protected VBox root;
    protected HBox content;
    private final String windowName;
    private final boolean withMenuBar;
    protected NFLPlayerManager playerManager;
    protected TeamManager teamManager;

    public AbstractScene(Stage window, String windowName, TeamManager teamManager, NFLPlayerManager playerManager, boolean withMenuBar) {
        this.window = window;
        this.windowName = windowName;
        this.withMenuBar = withMenuBar;
        this.playerManager = playerManager;
        this.teamManager = teamManager;
        createScene();
    }

    public AbstractScene(Stage window, String windowName, TeamManager teamManager, NFLPlayerManager playerManager) {
        this.window = window;
        this.windowName = windowName;
        this.playerManager = playerManager;
        this.teamManager = teamManager;
        this.withMenuBar = true;
        createScene();
    }

    private void createScene(){
        root = new VBox();
        root.prefHeight(480);
        root.prefWidth(800);

        content = new HBox(50);
        content.prefHeight(480);
        content.prefWidth(800);
        if(withMenuBar){
            root.getChildren().addAll(NFLDraft.getMenuBar(window), content);
        }else{
            root.getChildren().addAll(content);
        }
        Scene scene = new Scene(root, 800, 480);
        scene.getStylesheets().add("resources/css/bootstrap3.css");
        window.setTitle("NFLDraft - "+windowName);
        window.setScene(scene);
    }
}
