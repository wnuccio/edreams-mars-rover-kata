package edreams.kata.marsrover;

public class Rover {
    private Position position = new Position(0, 0);
    private Direction direction = Direction.north();

    public String move(String steps) {
        processAllCommands(steps);
        return getState();
    }

    private String getState() {
        return position.asString() + ":" + direction.asString();
    }

    private void processAllCommands(String steps) {
        for (char command: steps.toCharArray()) {
            processCommand(String.valueOf(command));
        }
    }

    private void processCommand(String command) {
        if (command.equals("L")) {
            direction.rotateLeft();
        }
        if (command.equals("R")) {
            direction.rotateRight();
        }
        if (command.equals("M")) {
            position.moveForward(direction.asString());
        }
    }
}
