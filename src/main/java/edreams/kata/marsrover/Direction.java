package edreams.kata.marsrover;

import java.util.HashMap;
import java.util.Map;
 class Direction {

    private String direction;
    private final Map<String, String> nextOrientationToLeft;
    private final Map<String, String> nextOrientationToRight;

    private Direction() {
        this.direction = "N";

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

    String asString() {
        return direction;
    }

    boolean isEast() {
        return this.direction.equals("E");
    }

    static Direction north() {
        return new Direction();
    }

    boolean isNorth() {
        return this.direction.equals("N");
    }

    boolean isWest() {
        return this.direction.equals("W");
    }

    boolean isSouth() {
        return this.direction.equals("S");
    }
}
