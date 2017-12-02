/**
 * Program: NFLDraft
 * File: HasPlayers.java
 * Summary:
 * Author: James Ray
 * Date: Dec 2, 2017
 */
package nfldraft.interfaces;

import java.util.ArrayList;
import nfldraft.classes.NFLPlayer;

public interface HasPlayers {
    abstract ArrayList<NFLPlayer> getPlayers();
}
