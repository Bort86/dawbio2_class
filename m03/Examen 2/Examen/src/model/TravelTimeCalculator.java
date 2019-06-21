package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jose
 */
public class TravelTimeCalculator {
    /**
     * the map from road types to speed limits.
     */
    private final Map<String, Double> speedLimits;

    public TravelTimeCalculator() {
        //initialize values of speed limits and road types.
        this.speedLimits = new HashMap<>();
        this.speedLimits.put("urban", 50.0);
        this.speedLimits.put("motorway", 100.0);
        this.speedLimits.put("highway", 120.0);
    }
    
    /**
     * gets the names of the road types.
     * @return the types of the roads.
     */
    public String [] getRoadTypes() {
        String [] types = this.speedLimits.keySet().stream().toArray(String[]::new);
        return types;
    }
    
    /**
     * gets speed limit of the given road type.
     * @param roadType the type of the road.
     * @return its speed limit, if found, null otherwise,
     */
    public Double getSpeedLimit(String roadType) {
        return this.speedLimits.get(roadType);
    }
    
    /**
     * sets the speed limit of the given road type, only if it exists.
     * @param roadType the type of the road.
     * @param speed the speed of the road.
     * @return true if set, false otherwise.
     */
    public boolean setSpeedLimit(String roadType, Double speed) {
        if (this.getSpeedLimit(roadType)==null) {
            return false;
        }
        this.speedLimits.put(roadType, speed);
        return true;
    }
    
    /**
     * calculates estimated time of travel.
     * @param distance the distance to travel, in km.
     * @param roadType the type of the road.
     * @return the estiimated time of travelling, in hours.
     */
    public Double calculateTime(Double distance, String roadType) {
        Double speed = this.getSpeedLimit(roadType);
        Double time = distance/speed;
        return time;
    }
    
}
