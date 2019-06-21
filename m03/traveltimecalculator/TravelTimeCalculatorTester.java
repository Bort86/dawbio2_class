package cat.proven.traveltimecalculator;

import cat.proven.traveltimecalculator.model.TravelTimeCalculator;
import java.util.Arrays;

/**
 * Tester for TravelTimeCalculator model class.
 * The only purpose of this code is performing some tests on model services.
 * TODO: remove this class for production release.
 * @author Jose
 */
public class TravelTimeCalculatorTester {

    public static void main(String[] args) {
        // instantiate model.
        TravelTimeCalculator ttc = new TravelTimeCalculator();
        // perform some tests.
        System.out.println("Road types: "+Arrays.asList(ttc.getRoadTypes()));
        System.out.println("Motorway speed: "+ttc.getSpeedLimit("motorway"));
        System.out.println("Non existent road type speed: "+ttc.getSpeedLimit("unknowntype"));
        boolean b = false;
        System.out.println("Setting speed limit of motorway to 110");
        b = ttc.setSpeedLimit("motorway", 110.0);
        System.out.println("Speed set: " +b);
        System.out.println("Setting speed limit of unknown road type to 110");
        b = ttc.setSpeedLimit("unknowntype", 110.0);
        System.out.println("Speed set: " +b);
        System.out.println("Motorway speed: "+ttc.getSpeedLimit("motorway"));
        System.out.println("Calculating time for distance=500km by motorway");
        System.out.format("Time (h): %.2f\n",ttc.calculateTime(500.0, "motorway"));
        System.out.println("Road types: "+Arrays.asList(ttc.getRoadTypes()));
    }
    
}
