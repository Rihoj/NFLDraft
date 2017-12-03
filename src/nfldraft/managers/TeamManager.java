/**
 * Program: NFLDraft
 * File: NFLPlayerManager.java
 * Summary: Create and manage all players.
 * Author: James Ray
 * Date: Nov 19, 2017
 */
package nfldraft.managers;

import java.util.ArrayList;
import nfldraft.classes.Team;

public class TeamManager {

    //The default number of players to create in createPlayers
    private static final int DEFAULT_CREATE_TEAMS = 5;
    //The number of offensive players to create.
    private static final int NUMBER_OF_TEAMS = 10;
    //Array list of all players
    private ArrayList<Team> teams = new ArrayList<>();

    private Team currentTeam;

    //Create the default set of players.
    public TeamManager() {
        for (int i = 0; i < NUMBER_OF_TEAMS; i++) {
            teams.add(new Team());
        }
    }

    //Return the NFLPlayerManager as a string.
    @Override
    public String toString() {
        String returnString = "Teams: \n";
        for (int i = 0; i < teams.size(); i++) {
            returnString += teams.get(i).toString() + "\n\n";
        }
        return returnString;
    }

    //Create DEFAULT_CREATE_PLAYERS number of players
    public ArrayList<Team> createTeams() {
        for (int i = 0; i < DEFAULT_CREATE_TEAMS; i++) {
            teams.add(new Team());
        }
        return teams;
    }

    //Create numberOfPlayers number of players
    public ArrayList<Team> createTeams(int numberOfTeams) {
        for (int i = 0; i < numberOfTeams; i++) {
            teams.add(new Team());
        }
        return teams;
    }

    //remove a specific player from the manager.
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    //removes all players from manager.
    public void removeAllTeams() {
        teams.clear();
    }

    //Return all players.
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * Returns the currently selected team.
     *
     * @return
     */
    public Team getCurrentTeam() {
        if (currentTeam != null) {
            return currentTeam;
        } else {
            return teams.get(0);
        }
    }

    /**
     * Sets the currently selected team.
     *
     * @param currentTeam
     */
    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

}
