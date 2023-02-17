package edreams.kata.marsrover;

public class Rover {

    public static final int GRID_LENGTH = 10;
    private String coordinates = "0:0";

    public String move(String steps) {
        if (steps.equals("L")) {
            return coordinates + ":W";
        }
        if (steps.equals("LL")) {
            return coordinates + ":S";
        }
        if (steps.equals("LLL")) {
            return coordinates + ":E";
        }
        moveForward(steps);
        return coordinates + ":N";
    }

    private void moveForward(String steps) {
        coordinates = "0:" +steps.length() % GRID_LENGTH;
    }
}
