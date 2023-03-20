package edreams.kata.marsrover;

public class Position {
    public static final int GRID_LENGTH = 10;

    private int y;
    private int x;

    public Position(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public void moveForward(Direction direction) {
        if (direction.isEast()) {
            x = increaseCoordinate(x);
        }
        if (direction.isNorth()) {
            y = increaseCoordinate(y);
        }
        if (direction.isWest()) {
            x = decreaseCoordinate(x);
        }
        if (direction.isSouth()) {
            y = decreaseCoordinate(y);
        }
    }

    public String asString() {
        return x + ":" + y;
    }

    private int decreaseCoordinate(int coordinate) {
        coordinate--;
        return fixCoordinateOutOfGrid(coordinate);
    }

    private int increaseCoordinate(int coordinate) {
        coordinate++;
        return fixCoordinateOutOfGrid(coordinate);
    }

    private int fixCoordinateOutOfGrid(int coordinate) {
        if (coordinate < 0) {
            return GRID_LENGTH - 1;
        }
        return coordinate >= GRID_LENGTH ? 0 : coordinate;
    }
}
