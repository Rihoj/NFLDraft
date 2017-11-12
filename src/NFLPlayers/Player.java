/** Program: NFLDraft
 * File: Player.java
 * Summary: Interface for a player.
 * Author: James Ray
 * Date: November 11, 2017
 */
package NFLPlayers;

import java.util.Map;

/**
 *
 * @author james
 */
public interface Player {

    public String getFirstName();
    public String getLastName();
    public String getFullName();
    public int getAge();
    public String getTeam();
    public Map<String, Integer> getStats();
}
