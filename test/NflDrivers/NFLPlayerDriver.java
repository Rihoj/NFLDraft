/**
 * Program: NFLDraft
 * File: NFLPlayerDriver.java
 * Summary: Test class for NFL Player
 * Author: James Ray
 * Date: Nov 18, 2017
 */
package NflDrivers;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import nfldraft.classes.*;
import nfldraft.interfaces.PositionInterface;

/**
 *
 * @author james
 */
public class NFLPlayerDriver {

    private static int errorCount = 0;
    private static int successCount = 0;
    private static final int NUMER_OF_TEAMS = 2;
    private static final int NUMBER_OF_PLAYERS = 5;

    public static void main(String[] args) {
        logOut("Begining tests for NFLPlayer.");
        logOut("");
        logOut("Checking NFLPlayer dependencies.");
        if (createPositionTest()) {
            logOut("Create Position Test succeded.");
            successCount++;
        } else {
            logError("Failed Create Position Test.");
            errorCount++;
        }
        if (createTeamTest()) {
            logOut("Create Team Test succeded.");
            successCount++;
        } else {
            logError("Failed create Team Test.");
            errorCount++;
        }
        if (errorCount == 0) {
            logOut("");
            logOut("Begining Create Player constructor test.");
            if (createPlayerTest()) {
                logOut("Create Player Test succeded");
                successCount++;
                continueTest();
            } else {
                logError("Create Player Test Failed. Full test was cancled.");
                errorCount++;
            }
        } else {
            logError("Could not continue as dependencies failed.");
        }
        logOut("");
        logOut("Tests are complete with the following stats.");
        logOut("Successes: " + Integer.toString(successCount));
        logError("Errors: " + Integer.toString(errorCount));

    }

    //Tests the constructors for positions.
    private static boolean createPositionTest() {
        boolean testStatus = false;
        try {
            PositionInterface defensePosition = new DefensePosition();
            logOut("Created Defense Postion with stats of " + defensePosition.getStats() + ".");
            PositionInterface defensePositionWithData = new DefensePosition(1, 2, 3, 4, 5);
            logOut("Created Defense Postion with defined stats of " + defensePositionWithData.getStats() + ".");

            PositionInterface offensePosition = new OffensePosition();
            logOut("Created Offense Postion with stats of " + offensePosition.getStats() + ".");
            PositionInterface offensePositionWithData = new OffensePosition(1, 2, 3, 4, 5);
            logOut("Created Offense Postion with defined stats of " + offensePositionWithData.getStats() + ".");

            testStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testStatus;
    }

    //Tests the constructors for a team.
    private static boolean createTeamTest() {
        boolean testStatus = false;
        try {
            Team team = new Team();
            logOut("Team with name: " + team.getName() + " and owner: " + team.getOwner() + " created");

            Team teamWithData = new Team("Rockets", "John Doe");
            logOut("Team with name: " + teamWithData.getName() + " and owner: " + teamWithData.getOwner() + " created");
            testStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testStatus;
    }

    private static void continueTest() {
        if(fullTest()){
            logOut("Full test succeeded");
            successCount++;
        }else{
            errorCount++;
        }
    }

    //Test NFLPlayer constructors
    private static boolean createPlayerTest() {
        boolean testStatus = false;
        try {
            NFLPlayer player = new NFLPlayer();
            logOut("Player " + player.getFullName() + " was created with the position of "+player.getPosition().getPositionType() +".");
            String firstName = "James";
            String lastName = "Ray";
            int age = 25;
            PositionInterface defensePosition = new DefensePosition();
            NFLPlayer defensePlayer = new NFLPlayer(firstName, lastName, age, defensePosition);
            logOut("Player " + defensePlayer.getFullName() + " was created with the position of "+defensePlayer.getPosition().getPositionType() +".");

            PositionInterface offensePosition = new OffensePosition();
            NFLPlayer offensePlayer = new NFLPlayer(firstName, lastName, age, offensePosition);
            logOut("Player " + offensePlayer.getFullName() + " was created with the position of "+offensePlayer.getPosition().getPositionType() +".");

            Team team = new Team();
            NFLPlayer teamPlayer = new NFLPlayer(firstName, lastName, age, team, offensePosition);
            logOut("Player " + teamPlayer.getFullName() + " was created with the team name of " + team.getName());
            testStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testStatus;
    }

    //Run a full test to make sure the everything functions as expected.
    private static boolean fullTest() {
        boolean testStatus = false;
        logOut("");
        logOut("");
        logOut("BeginingFull Test.");
        try {
            Team[] teams = new Team[NUMER_OF_TEAMS];
            logOut("");
            logOut("");
            logOut("Creating teams.");
            for(int i=0; i < NUMER_OF_TEAMS; i++){
                logOut("");
                teams[i] = new Team();
                logOut("Team created. Name: "+teams[i].getName()+ " Owner: "+teams[i].getOwner());
                logOut("Creating players and adding them to a team.");
                logOut("");
                for (int j = 0; j < NUMBER_OF_PLAYERS; j++) {
                    teams[i].addPlayer(new NFLPlayer());
                }
                logOut("Players created and added to team.");
                logOut("Listing players in team.");
                logOut("");
                List<NFLPlayer> players = new CopyOnWriteArrayList<NFLPlayer>();
                teams[i].getPlayers().forEach((player)->{
                    players.add(player);
                    logOut("Player first name: "+player.getFirstName());
                    logOut("Player last name: "+player.getLastName());
                    logOut("Player full name: "+player.getFullName());
                    logOut("Player age: "+player.getAge());
                    logOut("Player team: "+player.getTeam().getName());
                    logOut("Player position: "+player.getPosition().getPositionType());
                    logOut("Player stats: "+player.getAllStats());
                    logOut("");
                });

                logOut("Fire all players.");
                Iterator<NFLPlayer> playerIterator = players.iterator();
                while(playerIterator.hasNext()){
                    NFLPlayer player = playerIterator.next();
                    logOut("Removing player with name: "+player.getFullName());
                    teams[i].firePlayer(player);
                }
            }
            testStatus = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testStatus;
    }

    //Print line to System out and wait 500 ms to make sure text is in the right order.
    private static void logOut(String message) {
        System.out.println(message);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Print line to System err and wait 500 ms to make sure text is in the right order.
    private static void logError(String message) {
        System.err.println(message);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
