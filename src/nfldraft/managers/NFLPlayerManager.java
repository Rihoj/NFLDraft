/**
 * Program: NFLDraft
 * File: NFLPlayerManager.java
 * Summary: Create and manage all players.
 * Author: James Ray
 * Date: Nov 19, 2017
 */
package nfldraft.managers;

import java.util.ArrayList;
import nfldraft.classes.DefensivePlayer;
import nfldraft.classes.NFLPlayer;
import nfldraft.classes.OffensivePlayer;
import nfldraft.interfaces.HasPlayers;

public class NFLPlayerManager implements HasPlayers{

    //The default number of players to create in createPlayers
    private static final int DEFAULT_CREATE_PLAYERS = 3;
    //The number of offensive players to create.
    private static final int NUMBER_OF_OFFENSIVE_PLAYERS = 5;
    //The number of defensive players to create.
    private static final int NUMBER_OF_DEFENSIVE_PLAYERS = 5;
    //Array list of all players
    private ArrayList<NFLPlayer> players = new ArrayList<>();

    //Create the default set of players.
    public NFLPlayerManager() {
        for (int i = 0; i < NUMBER_OF_OFFENSIVE_PLAYERS; i++) {
            players.add(new OffensivePlayer());
        }
        for (int i = 0; i < NUMBER_OF_DEFENSIVE_PLAYERS; i++) {
            players.add(new DefensivePlayer());
        }
    }

    //Return the NFLPlayerManager as a string.
    @Override
    public String toString() {
        String returnString = "Players: \n";
        for (int i = 0; i < players.size(); i++) {
            returnString += players.get(i).toString() + "\n\n";
        }
        return returnString;
    }

    //Create DEFAULT_CREATE_PLAYERS number of players
    public ArrayList<NFLPlayer> createPlayers() {
        for (int i = 0; i < DEFAULT_CREATE_PLAYERS; i++) {
            players.add(new OffensivePlayer());
            players.add(new DefensivePlayer());
        }
        return players;
    }

    //Create numberOfPlayers number of players
    public ArrayList<NFLPlayer> createOffensivePlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new OffensivePlayer());
        }
        return players;
    }

    //Create numberOfPlayers number of players
    public ArrayList<NFLPlayer> createDefensivePlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new DefensivePlayer());
        }
        return players;
    }

    //remove a specific player from the manager.
    public void removePlayer(NFLPlayer player) {
        players.remove(player);
    }

    //removes all players from manager.
    public void removeAllPlayers() {
        players.clear();
    }

    //Return all players.
    public ArrayList<NFLPlayer> getPlayers() {
        return players;
    }

    public NFLPlayer getPlayer(NFLPlayer player){
        return player;
    }

}
