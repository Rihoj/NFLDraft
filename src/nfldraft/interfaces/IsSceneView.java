/**
 * Program: NFLDraft
 * File: IsSceneView.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.interfaces;

import javafx.scene.Scene;
import nfldraft.managers.SceneManager;

/**
 *
 * @author james
 */
public interface IsSceneView {
    abstract public Scene loadScene();
    abstract public Scene updateScene();
    abstract public void addSceneManager(SceneManager sceneManager);
    abstract public String getWindowName();
}
