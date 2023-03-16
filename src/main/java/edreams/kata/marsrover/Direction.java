package edreams.kata.marsrover;

import java.util.HashMap;
import java.util.Map;

public class Direction {

    private String direction;

    public Direction(String direction) {
        this.direction = direction;
    }

    void rotateLeft() {
        Map<String, String> nextOrientations = new HashMap<>();
        nextOrientations.put("N", "W");
        nextOrientations.put("W", "S");
        nextOrientations.put("S", "E");
        nextOrientations.put("E", "N");

        direction = nextOrientations.get(direction);
    }

    void rotateRight() {
        Map<String, String> nextOrientations = new HashMap<>();
        nextOrientations.put("N", "E");
        nextOrientations.put("E", "S");
        nextOrientations.put("S", "W");
        nextOrientations.put("W", "N");

        direction = nextOrientations.get(direction);
    }

    public String asString() {
        return direction;
    }
}
