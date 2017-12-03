/**
 * Program: NFLDraft
 * File: IsSceneView.java
 * Summary: Tells the class that it must have these methods to be able to be used in the scenemanager.
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.interfaces;

import javafx.scene.Scene;
import nfldraft.managers.SceneManager;

public interface IsSceneView {

    /**
     * Load the scene for the first time building.
     *
     * @return Scene
     */
    abstract public Scene loadScene();

    /**
     * Update any elements that might need to be updated after switch.
     *
     * @return Scene
     */
    abstract public Scene updateScene();

    /**
     * Add the scene manager to the class for easier use of switching scenes.
     *
     * @param sceneManager
     */
    abstract public void addSceneManager(SceneManager sceneManager);

    /**
     * Get the window name of for the scene.
     *
     * @return String
     */
    abstract public String getWindowName();
}
