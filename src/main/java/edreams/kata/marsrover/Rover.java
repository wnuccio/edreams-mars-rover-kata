package edreams.kata.marsrover;

import java.util.HashMap;
import java.util.Map;

public class Rover {

    public static final int GRID_LENGTH = 10;
    private int y = 0;
    private int x = 0;
    private String orientation = "N";

    public String move(String steps) {
        for (char command: steps.toCharArray()) {
            processCommand(String.valueOf(command));
        }
        return x + ":" + y + ":" + orientation;
    }

    private void processCommand(String command) {
        if (command.equals("L")) {
            rotateLeft(command);
        }
        if (command.equals("R")) {
            rotateRight(command);
        }
        if (command.equals("M")) {
            moveForward();
        }
    }

    private void moveForward() {
        y++;
        if (y >= GRID_LENGTH) {
            y = 0;
        }
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
        nextOrientations.put("S", "W");
        nextOrientations.put("W", "N");

        for (int i = 0; i < steps.length(); i++) {
            orientation = nextOrientations.get(orientation);
        }
    }

}
