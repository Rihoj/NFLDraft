/** Program: NFLDraft
 * File: OffensePlayer.java
 * Summary: Offense player class.
 * Author: James Ray
 * Date: November 11, 2017
 */
package NFLPlayers;

import java.util.HashMap;
import java.util.Map;

public class OffensePlayer implements Player {

    private String firstName;
    private String lastName;
    private int age;
    private String team;
    private int passingYards;
    private int rushingYards;
    private int receivingYards;
    private int touchDowns;
    private int sacks;
    private final Map<String, Integer> stats = new HashMap<>();

    /**
     * Create an Offensive player.
     *
     * @param initFirstName
     * @param initLastName
     * @param initAge
     * @param initTeam
     * @param initPassingYards
     * @param initRushingYards
     * @param initReceivingYards
     * @param initTouchDowns
     * @param initSacks
     */
    public OffensePlayer(String initFirstName, String initLastName, int initAge, String initTeam, int initPassingYards, int initRushingYards, int initReceivingYards, int initTouchDowns, int initSacks) {
        firstName = initFirstName;
        lastName = initLastName;
        age = initAge;
        team = initTeam;
        passingYards = initPassingYards;
        rushingYards = initRushingYards;
        receivingYards = initReceivingYards;
        touchDowns = initTouchDowns;
        sacks = initSacks;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getTeam() {
        return team;
    }

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

}
