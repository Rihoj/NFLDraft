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
        "Matthew", "Lucas", "Jackson", "David", "Oliver", "Jayden", "Joseph", "Gabriel", "Samuel", "Carter", "Anthony", "John", "Dylan", "Luke",
        "Henry", "Andrew", "Isaac", "Christopher", "Joshua", "Wyatt", "Sebastian", "Owen", "Caleb", "Nathan", "Ryan", "Jack", "Hunter", "Levi",
        "Christian", "Jaxon", "Julian", "Landon", "Grayson", "Jonathan", "Isaiah", "Charles", "Thomas", "Aaron", "Eli", "Connor", "Jeremiah",
        "Cameron", "Josiah", "Adrian", "Colton", "Jordan", "Brayden", "Nicholas", "Robert", "Angel", "Hudson", "Lincoln", "Evan", "Dominic",
        "Austin", "Gavin", "Nolan", "Parker", "Adam", "Chase", "Jace", "Ian", "Cooper", "Easton", "Kevin", "Jose", "Tyler", "Brandon", "Asher",
        "Jaxson", "Mateo", "Jason", "Ayden", "Zachary", "Carson", "Xavier", "Leo", "Ezra", "Bentley", "Sawyer", "Kayden", "Blake", "Nathaniel",
        "Ryder", "Theodore", "Elias"
    };
    //Last names to generate from. Provided by: https://en.geneanet.org/genealogy/1/Surname.php
    private static final String[] LAST_NAMES = {
        "Smith", "Jones", "Brown", "Johnson", "Williams", "Miller", "Taylor", "Wilson", "Davis", "White", "Clark", "Hall", "Thomas", "Thompson",
        "Moore", "Hill", "Walker", "Anderson", "Wright", "Martin", "Wood", "Allen", "Robinson", "Lewis", "Scott", "Young", "Jackson", "Adams",
        "Tryniski", "Green", "Evans", "King", "Baker", "John", "Harris", "Roberts", "Campbell", "James", "Stewart", "Lee", "County", "Turner",
        "Parker", "Cook", "Edwards", "Morris", "Mitchell", "Bell", "Ward", "Watson", "Morgan", "Davies", "Cooper", "Phillips", "Rogers", "Gray",
        "Hughes", "Harrison", "Carter", "Murphy", "Collins", "Henry", "Foster", "Richardson", "Russel", "Hamilton", "Shaw", "Bennett", "Howard",
        "Reed", "Fisher", "Marshall", "May", "Church", "Washington", "Kelly", "Price", "Murray", "William", "Palmer", "Stevens", "Cox", "Robertson",
        "Clarke", "Bailey", "George", "Nelson", "Mason", "Butler", "Mills", "Hunt", "Simpson", "Graham", "Henderson", "Ross", "Stone", "Porter"
    };

    //List of possible adjectives. Provided by: http://www.enchantedlearning.com/wordlist/adjectives.shtml
    private static final String[] TEAM_NAMES_PREFIX = {
        "Abandoned", "Able", "Absolute", "Adorable", "Adventurous", "Academic", "Acceptable", "Acclaimed", "Accomplished", "Accurate", "Aching",
        "Acidic", "Acrobatic", "Active", "Actual", "Adept", "Admirable", "Admired", "Adolescent", "Adorable", "Adored", "Advanced", "Afraid",
        "Affectionate", "Aged", "Aggravating", "Babyish", "Bad", "Back", "Baggy", "Bare", "Barren", "Basic", "Beautiful", "Belated", "Beloved",
        "Beneficial", "Better", "Best", "Bewitched", "Big", "Big-hearted", "Biodegradable", "Bite-sized", "Bitter", "Black", "Calculating", "Calm",
        "Candid", "Canine", "Capital", "Carefree", "Careful", "Careless", "Caring", "Cautious", "Cavernous", "Celebrated", "Charming", "Cheap",
        "Cheerful", "Cheery", "Chief", "Chilly", "Chubby", "Circular", "Classic", "Clean", "Clear", "Clear-cut", "Clever", "Close", "Closed",
        "Damaged", "Damp", "Dangerous", "Dapper", "Daring", "Darling", "Dark", "Dazzling", "Dead", "Deadly", "Deafening", "Dear", "Dearest",
        "Decent", "Decimal", "Decisive", "Deep", "Defenseless", "Defensive", "Defiant", "Deficient", "Definite", "Definitive", "Delayed",
        "Delectable", "Delicious"
    };
    //List of possible team names. Provided by: https://en.wikipedia.org/wiki/List_of_U.S._state_mammals
    private static final String[] TEAM_NAMES = {
        "Bears", "Cats", "Deers", "Grizzly Bears", "Bighorn Sheep", "Panthers", "Bison", "Malamutes", "Foxes", "Squirrels", "Main Coons",
        "Calicos", "Boston Terriers", "Dolphins", "Mules", "Chinooks", "Beavers", "Great Danes", "Coyotes", "Whales", "Seals", "Horses",
        "Manatees", "Raccoons", "Bats", "Spaniels", "Armadillos", "Longhorns", "Elks", "Orcas", "Marmots", "Cows", "Badgers", "Wolves"
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
        int randomNumPrefix = ThreadLocalRandom.current().nextInt(0, TEAM_NAMES_PREFIX.length);
        int randomNum = ThreadLocalRandom.current().nextInt(0, TEAM_NAMES.length);
        return TEAM_NAMES_PREFIX[randomNumPrefix] + " " + TEAM_NAMES[randomNum];
    }
}
