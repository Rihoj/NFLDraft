/**
 * Program: NFLDraft
 * File: OffensePosition.java
 * Summary: Controls the position "defense" and it's statistics.
 * Author: James Ray
 * Date: Nov 18, 2017
 */
package nfldraft.classes;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class OffensivePlayer extends NFLPlayer {

    //Number of passing yards a player has.
    private final int passingYards;
    //number of rushing yards a player has.
    private final int rushingYards;
    //number of receiving yards a player has.
    private final int receivingYards;
    //Number of touch downs a player has made.
    private final int touchDowns;
    //number of sacks a player has made.
    private final int sacks;
    //A map of the statistics for the player.
    private final Map<String, Integer> stats = new LinkedHashMap<>();

    //Randomly generate stats for this position.
    public OffensivePlayer() {
        super();
        passingYards = ThreadLocalRandom.current().nextInt(0, 500);
        rushingYards = ThreadLocalRandom.current().nextInt(0, 500);
        receivingYards = ThreadLocalRandom.current().nextInt(0, 500);
        touchDowns = ThreadLocalRandom.current().nextInt(0, 50);
        sacks = ThreadLocalRandom.current().nextInt(0, 75);
    }

    //Return the statistics for this player.
    @Override
    public Map<String, Integer> getStats() {
        stats.clear();
        stats.put("Passing Yards", passingYards);
        stats.put("Rushing Yards", rushingYards);
        stats.put("Receiving Yards", receivingYards);
        stats.put("Touch Downs", touchDowns);
        stats.put("Sacks", sacks);
        return stats;
    }

    //return the position type
    @Override
    public String getPositionType() {
        return "Offense";
    }

}
