/**
 * Program: NFLDraft
 * File: Player.java
 * Summary: Controls the player and allows players to be generated.
 * Author: James Ray
 * Date: Nov 18, 2017
 */
package nfldraft.classes;

import java.util.Map;
import nfldraft.helpers.NameHelper;
import java.util.concurrent.ThreadLocalRandom;

public abstract class NFLPlayer {

    //First name of the player.
    private String firstName;
    //Last name of the player.
    private String lastName;
    //Age of the player.
    private int age;
    //Team class the player belongs to.
    private Team team;

    //Generate a new player with random data without a team.
    public NFLPlayer() {
        firstName = NameHelper.generateFirstName();
        lastName = NameHelper.generateLastName();
        age = ThreadLocalRandom.current().nextInt(18, 46);
    }

    @Override
    public String toString() {
        return getFullName();
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

    //Set the first name of the player
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Set the last name of the player
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //set the age of the player
    public void setAge(int age) {
        this.age = age;
    }

    //Removes player from team.
    public void leaveTeam() {
        if (team != null) {
            team.removePlayer(this);
            team = null;
        }
    }

    //All positions must have statistics and be able to return them as a Map<String, Integer>
    abstract public Map<String, Integer> getStats();

    //returns the position type
    abstract public String getPositionType();
}
