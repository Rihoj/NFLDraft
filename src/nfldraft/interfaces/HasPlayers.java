/**
 * Program: NFLDraft
 * File: HasPlayers.java
 * Summary: Tells the class that it must support getting players.
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.interfaces;

import java.util.ArrayList;
import nfldraft.classes.NFLPlayer;

public interface HasPlayers {

    /**
     * Tells the implementing class that it must support getting players through the
     * getPlayer method.
     *
     * @return ArrayList<NFLPlayer>
     */
    abstract ArrayList<NFLPlayer> getPlayers();
}
