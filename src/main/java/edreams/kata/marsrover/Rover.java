package edreams.kata.marsrover;

import java.util.HashMap;
import java.util.Map;

public class Rover {
    private Position position = new Position(0, 0);
    private String direction = "N";

    public String move(String steps) {
        processAllCommands(steps);
        return getState();
    }

    private String getState() {
        return position.asString() + ":" + direction;
    }

    private void processAllCommands(String steps) {
        for (char command: steps.toCharArray()) {
            processCommand(String.valueOf(command));
        }
    }

    private void processCommand(String command) {
        if (command.equals("L")) {
            rotateLeft(command);
        }
        if (command.equals("R")) {
            rotateRight(command);
        }
        if (command.equals("M")) {
            position.moveForward(direction);
        }
    }

    private void rotateLeft(String steps) {
        Map<String, String> nextOrientations = new HashMap<>();
        nextOrientations.put("N", "W");
        nextOrientations.put("W", "S");
        nextOrientations.put("S", "E");
        nextOrientations.put("E", "N");

        for (int i = 0; i < steps.length(); i++) {
            direction = nextOrientations.get(direction);
        }
    }

    private void rotateRight(String steps) {
        Map<String, String> nextOrientations = new HashMap<>();
        nextOrientations.put("N", "E");
        nextOrientations.put("E", "S");
        nextOrientations.put("S", "W");
        nextOrientations.put("W", "N");

        for (int i = 0; i < steps.length(); i++) {
            direction = nextOrientations.get(direction);
        }
    }

}
