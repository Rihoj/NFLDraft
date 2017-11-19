/**
 * Program: NFLDraft
 * File: DefencePosition.java
 * Summary: Controls the position "defense" and it's statistics.
 * Author: James Ray
 * Date: Nov 18, 2017
 */
package nfldraft.classes;

import nfldraft.interfaces.PositionInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class DefensePosition implements PositionInterface {

    //Number of tackles the player has made.
    private final int tackles;
    //Number of rushing yards for player.
    private final int rushingYards;
    //Number of Interceptions the player has made.
    private final int interceptions;
    //Number of kick returns the player has made.
    private final int kickReturns;
    //Number of sacks the player has made.
    private final int sacks;
    //A map of all stats for the player.
    private final Map<String, Integer> stats = new HashMap<>();

    //Randomly generate stats for this position.
    public DefensePosition() {
        tackles = ThreadLocalRandom.current().nextInt(0, 300);
        rushingYards = ThreadLocalRandom.current().nextInt(0, 500);
        interceptions = ThreadLocalRandom.current().nextInt(0, 200);
        kickReturns = ThreadLocalRandom.current().nextInt(0, 50);
        sacks = ThreadLocalRandom.current().nextInt(0, 75);
    }

    //Create the position with predefined stats
    public DefensePosition(int passingYards, int rushingYards, int receivingYards, int touchDowns, int sacks) {
        this.tackles = passingYards;
        this.rushingYards = rushingYards;
        this.interceptions = receivingYards;
        this.kickReturns = touchDowns;
        this.sacks = sacks;
    }

    //Return the statistics for this player.
    @Override
    public Map<String, Integer> getStats() {
        stats.clear();
        stats.put("Tackles", tackles);
        stats.put("Rushing Yards", rushingYards);
        stats.put("Interceptions", interceptions);
        stats.put("Kick Returns", kickReturns);
        stats.put("Sacks", sacks);
        return stats;
    }

}
