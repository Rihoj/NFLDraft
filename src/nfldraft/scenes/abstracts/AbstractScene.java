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
import nfldraft.managers.*;

public class AbstractScene {

    //The root of the scene
    protected VBox root;
    //The main content of the scene
    protected HBox content;
    //The page name
    protected Label pageName = new Label();
    //The window title
    private final String windowName;
    //The playerManager;
    protected NFLPlayerManager playerManager;
    //The team manager
    protected TeamManager teamManager;
    //The sceneManager
    protected SceneManager sceneManager;
    //The scene that is being built
    Scene scene;

    /**
     * Generates the base scene.
     * @param windowName
     * @param teamManager
     * @param playerManager
     */
    public AbstractScene(String windowName, TeamManager teamManager, NFLPlayerManager playerManager) {
        this.windowName = windowName;
        this.playerManager = playerManager;
        this.teamManager = teamManager;
        createScene();
    }

    /**
     * Generates the layout for the base scene.
     */
    private void createScene() {
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

    /**
     * Returns the scene that was created.
     * @return Scene
     */
    public final Scene getScene() {
        return scene;
    }

    /**
     * sets the page name text.
     * @param pageName
     */
    protected final void setPageName(String pageName) {
        this.pageName.setText(pageName);
    }

    /**
     * Gets the window name.
     * @return String
     */
    public final String getWindowName() {
        return windowName;
    }

    /**
     * Adds the scene manager for easy scene switching.
     * @param sceneManager
     */
    public void addSceneManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

}
