/**
 * Program: NFLDraft
 * File: PositionInterface.java
 * Summary: An interface for positions.
 * Author: James Ray
 * Date: Nov 18, 2017
 */
package nfldraft.interfaces;

import java.util.Map;

public interface PositionInterface {

    //All positions must have statistics and be able to return them as a Map<String, Integer>
    public Map<String, Integer> getStats();

    //returns the position type
    public String getPositionType();

}
