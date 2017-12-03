/**
 * Program: NFLDraft
 * File: SceneManager.java
 * Summary: Manages scene creation and scene switching for cleaner code.
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.managers;

import java.util.HashMap;
import java.util.Map;
import javafx.stage.Stage;
import nfldraft.interfaces.IsSceneView;
import nfldraft.scenes.AddPlayerScene;
import nfldraft.scenes.RosterScene;
import nfldraft.scenes.TeamSelectScene;

public class SceneManager {

    //the main stage that every scene will be loaded into.
    protected Stage window;
    //A map of the scene's class.
    private final Map<String, IsSceneView> scenes = new HashMap<>();
    //A map of the titles of the scene for easy window name changes.
    private final Map<String, String> sceneTitles = new HashMap<>();
    //A map of if the scene had been previously loaded and just needs updated.
    private final Map<String, Boolean> sceneLoaded = new HashMap<>();

    /**
     * Constructor to setup the Scene Manager.
     *
     * @param window
     * @param teamManager
     * @param playerManager
     */
    public SceneManager(Stage window, TeamManager teamManager, NFLPlayerManager playerManager) {
        this.window = window;
        setupScenes(teamManager, playerManager);
    }

    /**
     * Creates the scenes and adds them to the scene manager.
     *
     * @param teamManager
     * @param playerManager
     */
    private void setupScenes(TeamManager teamManager, NFLPlayerManager playerManager) {
        TeamSelectScene teamSelect = new TeamSelectScene(teamManager, playerManager);
        teamSelect.addSceneManager(this);
        addScene("TeamSelect", teamSelect);
        RosterScene rosterScene = new RosterScene(teamManager, playerManager);
        rosterScene.addSceneManager(this);
        addScene("Roster", rosterScene);
        AddPlayerScene addPlayerScene = new AddPlayerScene(teamManager, playerManager);
        addPlayerScene.addSceneManager(this);
        addScene("AddPlayer", addPlayerScene);
    }

    /**
     * Adds the scene to the manager's maps.
     *
     * @param sceneName
     * @param scene
     */
    private void addScene(String sceneName, IsSceneView scene) {
        scenes.put(sceneName, scene);
        sceneTitles.put(sceneName, scene.getWindowName());
        sceneLoaded.put(sceneName, false);
    }

    /**
     * Loads or updates the scene based on if the scene is loaded.
     *
     * @param scene
     */
    public void switchScene(String scene) {
        if (sceneLoaded.get(scene)) {
            window.setScene(scenes.get(scene).updateScene());
            window.setTitle("NFLDraft - " + sceneTitles.get(scene));
        } else {
            sceneLoaded.replace(scene, true);
            window.setScene(scenes.get(scene).loadScene());
            window.setTitle("NFLDraft - " + sceneTitles.get(scene));
        }
    }
}
