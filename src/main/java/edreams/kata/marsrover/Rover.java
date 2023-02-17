package edreams.kata.marsrover;

public class Rover {

    public static final int GRID_LENGTH = 10;

    private String coordinates = "0:0";
    private String orientation = "N";

    public String move(String steps) {
        if (steps.contains("L")) {
            rotateLeft(steps);
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
        if (steps.equals("L")) {
            orientation = "W";
        }
        if (steps.equals("LL")) {
            orientation = "S";
        }
        if (steps.equals("LLL")) {
            orientation = "E";
        }
        if (steps.equals("LLLL")) {
            orientation = "N";
        }
    }
}
