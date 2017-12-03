/**
 * Program: NFLDraft
 * File: AbstractScene.java
 * Summary: A Base scene construction to base other scenes on.
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.scenes.abstracts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import nfldraft.managers.*;

public class AbstractScene {

    //
    protected Stage window;
    protected VBox root;
    protected HBox content;
    protected Label pageName = new Label();
    private final String windowName;
    protected NFLPlayerManager playerManager;
    protected TeamManager teamManager;
    protected SceneManager sceneManager;
    Scene scene;

    public AbstractScene(String windowName, TeamManager teamManager, NFLPlayerManager playerManager) {
        this.windowName = windowName;
        this.playerManager = playerManager;
        this.teamManager = teamManager;
        createScene();
    }

    private void createScene(){
        root = new VBox(20);
        root.setPadding(new Insets(10));
        root.prefHeight(480);
        root.prefWidth(800);
        root.setAlignment(Pos.CENTER);

        Image logo = new Image("/resources/logo.png");
        ImageView imageView = new ImageView(logo);
        imageView.setPreserveRatio(true);
        pageName.setFont(new Font(20));
        content = new HBox(50);
        content.prefHeight(480);
        content.prefWidth(800);
        root.getChildren().addAll(imageView, pageName, content);
        scene = new Scene(root);
        scene.getStylesheets().add("resources/css/bootstrap3.css");
    }

    public final Scene getScene(){
        return scene;
    }
    protected final void setPageName(String pageName) {
        this.pageName.setText(pageName);
    }
    public final String getWindowName(){
        return windowName;
    }
    public void addSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

}
