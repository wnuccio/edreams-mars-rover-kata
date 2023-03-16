package edreams.kata.marsrover;

import java.util.HashMap;
import java.util.Map;

public class Direction {

    private String direction;
    private final Map<String, String> nextOrientationToLeft;
    private final Map<String, String> nextOrientationToRight;

    public Direction(String direction) {
        this.direction = direction;

        nextOrientationToLeft = new HashMap<>();
        nextOrientationToLeft.put("N", "W");
        nextOrientationToLeft.put("W", "S");
        nextOrientationToLeft.put("S", "E");
        nextOrientationToLeft.put("E", "N");

        nextOrientationToRight = new HashMap<>();
        nextOrientationToRight.put("N", "E");
        nextOrientationToRight.put("E", "S");
        nextOrientationToRight.put("S", "W");
        nextOrientationToRight.put("W", "N");
    }

    void rotateLeft() {
        direction = nextOrientationToLeft.get(direction);
    }

    void rotateRight() {
        direction = nextOrientationToRight.get(direction);
    }

    public String asString() {
        return direction;
    }
}
