package edreams.kata.marsrover;

import java.util.HashMap;
import java.util.Map;

public class Rover {

    public static final int GRID_LENGTH = 10;
    private String coordinates = "0:0";
    private String orientation = "N";

    public String move(String steps) {
        if (steps.contains("L")) {
            rotateLeft(steps);
        }
        if (steps.contains("R")) {
            rotateRight(steps);
        }
        if (steps.contains("M")) {
            moveForward(steps);
        }
        return coordinates + ":" + orientation;
    }

    private void moveForward(String steps) {
        coordinates = "0:" + steps.length() % GRID_LENGTH;
    }

    private void rotateLeft(String steps) {
        Map<String, String> nextOrientations = new HashMap<>();
        nextOrientations.put("N", "W");
        nextOrientations.put("W", "S");
        nextOrientations.put("S", "E");
        nextOrientations.put("E", "N");

        for (int i = 0; i < steps.length(); i++) {
            orientation = nextOrientations.get(orientation);
        }
    }

    private void rotateRight(String steps) {
        Map<String, String> nextOrientations = new HashMap<>();
        nextOrientations.put("N", "E");
        nextOrientations.put("E", "S");

        for (int i = 0; i < steps.length(); i++) {
            orientation = nextOrientations.get(orientation);
        }
    }

}
