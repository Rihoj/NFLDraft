/**
 * Program: NFLDraft
 * File: Player.java
 * Summary: Controls the player and allows players to be generated.
 * Author: James Ray
 * Date: Nov 18, 2017
 */
package nfldraft.classes;

import nfldraft.helpers.NameHelper;
import nfldraft.interfaces.PositionInterface;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class NFLPlayer {

    //First name of the player.
    private String firstName;
    //Last name of the player.
    private String lastName;
    //Age of the player.
    private int age;
    //Team class the player belongs to.
    private Team team;
    //Position the player has.
    private PositionInterface position;

    //Generate a new player with random data without a team.
    public NFLPlayer() {
        firstName = NameHelper.generateFirstName();
        lastName = NameHelper.generateLastName();
        age = ThreadLocalRandom.current().nextInt(18, 46);
        int randNum = ThreadLocalRandom.current().nextInt(1, 3);
        switch (randNum) {
            case 1:
                position = new OffensePosition();
                break;
            case 2:
                position = new DefensePosition();
                break;
        }

    }

    //Create a new player with specified data including team.
    public NFLPlayer(String firstName, String lastName, int age, Team team, PositionInterface position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
        this.position = position;
    }

    //Create a new player with specified data without a team.
    public NFLPlayer(String firstName, String lastName, int age, PositionInterface position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
    }

    //return the first name of the player
    public String getFirstName() {
        return firstName;
    }

    //return the last name of the player
    public String getLastName() {
        return lastName;
    }

    //return the full name of the player
    public String getFullName() {
        return firstName + " " + lastName;
    }

    //return the age of the player.
    public int getAge() {
        return age;
    }

    //Return the team the player belongs to.
    public Team getTeam() {
        return team;
    }

    //set the team the player belongs to.
    public void setTeam(Team team) {
        this.team = team;
    }

    //Removes player from team.
    public void leaveTeam(){
        if(team != null){
            team = null;
            team.removePlayer(this);
        }
    }

    //get the position the player has.
    public PositionInterface getPosition() {
        return position;
    }

    //set the position the player has.
    public void setPosition(PositionInterface position) {
        this.position = position;
    }

    //Return all statistics for the player.
    public Map<String, Integer> getAllStats() {
        return position.getStats();
    }
}
