package edreams.kata.marsrover;

public class Rover {

    public static final int GRID_LENGTH = 10;

    public String move(String steps) {
        if (steps.equals("L")) {
            return "0:0:W";
        }
        return "0:" + steps.length() % GRID_LENGTH + ":N";
    }

}
