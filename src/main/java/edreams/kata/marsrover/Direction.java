package edreams.kata.marsrover;

import java.util.HashMap;
import java.util.Map;

public class Direction {

    private String direction;

    public Direction(String direction) {
        this.direction = direction;
    }

    void rotateLeft(String steps) {
        Map<String, String> nextOrientations = new HashMap<>();
        nextOrientations.put("N", "W");
        nextOrientations.put("W", "S");
        nextOrientations.put("S", "E");
        nextOrientations.put("E", "N");

        for (int i = 0; i < steps.length(); i++) {
            direction = nextOrientations.get(direction);
        }
    }

    void rotateRight(String steps) {
        Map<String, String> nextOrientations = new HashMap<>();
        nextOrientations.put("N", "E");
        nextOrientations.put("E", "S");
        nextOrientations.put("S", "W");
        nextOrientations.put("W", "N");

        for (int i = 0; i < steps.length(); i++) {
            direction = nextOrientations.get(direction);
        }
    }

    public String asString() {
        return direction;
    }
}
