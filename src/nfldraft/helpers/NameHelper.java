/**
 * Program: NFLDraft
 * File: NameHelper.java
 * Summary: A helper class to generate names.
 * Author: James Ray
 * Date: Nov 18, 2017
 */
package nfldraft.helpers;

import java.util.concurrent.ThreadLocalRandom;

public class NameHelper {

    //First names to generate from. Provided by: https://www.babble.com/pregnancy/1000-most-popular-boy-names/
    private static final String[] FIRST_NAMES = {
        "Noah", "Liam", "Mason", "Jacob", "William", "Ethan", "James", "Alexander", "Michael", "Benjamin", "Elijah", "Daniel", "Aiden", "Logan",
        "Matthew", "Lucas", "Jackson", "David", "Oliver", "Jayden", "Joseph", "Gabriel", "Samuel", "Carter", "Anthony", "John", "Dylan", "Luke"
    };
    //Last names to generate from. Provided by: https://en.geneanet.org/genealogy/1/Surname.php
    private static final String[] LAST_NAMES = {
        "Smith", "Jones", "Brown", "Johnson", "Williams", "Miller", "Taylor", "Wilson", "Davis", "White", "Clark", "Hall", "Thomas", "Thompson",
        "Moore", "Hill", "Walker", "Anderson", "Wright", "Martin", "Wood", "Allen", "Robinson", "Lewis", "Scott", "Young", "Jackson", "Adams",
        "Tryniski", "Green", "Evans", "King", "Baker", "John", "Harris", "Roberts", "Campbell", "James", "Stewart", "Lee", "County", "Turner"
    };

    //List of possible team names. Provided by: https://en.wikipedia.org/wiki/List_of_U.S._state_mammals
    private static final String[] TEAM_NAMES = {
        "Black Bears", "Ring-tailed Cats", "White-tailed Deers", "Grizzly Bears", "Bighorn Sheep",
        "Panthers", "Bison", "Malamutes", "Grey Foxes", "Gray Squirrels", "Main Coons", "Calicos",
        "Boston Terriers", "Dolphins", "Mules", "Chinooks", "Beavers", "Great Danes", "Coyotes"
    };

    //Generate a first name from the list of possible first names.
    public static String generateFirstName() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, FIRST_NAMES.length);
        return FIRST_NAMES[randomNum];
    }

    //Generate a last name from the list of possible last names.
    public static String generateLastName() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, LAST_NAMES.length);
        return LAST_NAMES[randomNum];
    }

    //Generate both first and last names and return as a single string.
    public static String generateFullName() {
        return generateFirstName() + " " + generateLastName();
    }

    //Generate a team name.
    public static String generateTeamName() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, TEAM_NAMES.length);
        return TEAM_NAMES[randomNum];
    }
}
