package edreams.kata.marsrover;

public class Position {
    public static final int GRID_LENGTH = 10;

    private int y = 0;
    private int x = 0;

    public Position(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public void moveForward(String direction) {
        if (direction.equals("E")) {
            x = increaseCoordinate(x);
        }
        if (direction.equals("N")) {
            y = increaseCoordinate(y);
        }
        if (direction.equals("W")) {
            x = decreaseCoordinate(x);
        }
        if (direction.equals("S")) {
            y = decreaseCoordinate(y);
        }
    }

    public String asString() {
        return x + ":" + y;
    }

    private int decreaseCoordinate(int coordinate) {
        coordinate--;
        return fixCoordinateOutOfGreed(coordinate);
    }

    private int increaseCoordinate(int coordinate) {
        coordinate++;
        return fixCoordinateOutOfGreed(coordinate);
    }

    private int fixCoordinateOutOfGreed(int coordinate) {
        if (coordinate < 0) {
            return GRID_LENGTH - 1;
        }
        return coordinate >= GRID_LENGTH ? 0 : coordinate;
    }
}
