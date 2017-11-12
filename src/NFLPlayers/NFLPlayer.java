/** Program: NFLDraft
 * File: NFLPlayer.java
 * Summary: NFLPlayer abstract class.
 * Author: James Ray
 * Date: November 11, 2017
 */
package NFLPlayers;

import java.util.Map;

/**
 *
 * @author james
 */
abstract class NFLPlayer {

    Player player;
    public NFLPlayer(Player newPlayer) {
        player = newPlayer;
    }

    public int getStat(String stat){
        Map<String, Integer> stats = player.getStats();
        return stats.getOrDefault(stat, 0);
    }

}
