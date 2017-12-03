/**
 * Program: NFLDraft
 * File: SceneManager.java
 * Summary:
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

    protected Stage window;
    private final Map<String, IsSceneView> scenes = new HashMap<>();
    private final Map<String, String> sceneTitles = new HashMap<>();
    private final Map<String, Boolean> sceneLoaded = new HashMap<>();

    public SceneManager(Stage window, TeamManager teamManager, NFLPlayerManager playerManager) {
        this.window = window;
        setupScenes(teamManager, playerManager);
    }

    private void setupScenes(TeamManager teamManager, NFLPlayerManager playerManager) {
        TeamSelectScene teamSelect = new TeamSelectScene(window, teamManager, playerManager);
        teamSelect.addSceneManager(this);
        addScene("TeamSelect", teamSelect);
        RosterScene rosterScene = new RosterScene(window, teamManager, playerManager);
        rosterScene.addSceneManager(this);
        addScene("Roster", rosterScene);
        AddPlayerScene addPlayerScene = new AddPlayerScene(window, teamManager, playerManager);
        addPlayerScene.addSceneManager(this);
        addScene("AddPlayer", addPlayerScene);
    }

    private void addScene(String sceneName, IsSceneView scene){
        scenes.put(sceneName, scene);
        sceneTitles.put(sceneName, scene.getWindowName());
        sceneLoaded.put(sceneName, false);
    }

    public void switchScene(String scene) {
        if(sceneLoaded.get(scene)){
            window.setScene(scenes.get(scene).updateScene());
            window.setTitle("NFLDraft - " + sceneTitles.get(scene));
        }else{
            sceneLoaded.replace(scene, true);
            window.setScene(scenes.get(scene).loadScene());
            window.setTitle("NFLDraft - " + sceneTitles.get(scene));
        }
    }
}
