package edreams.kata.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RoverTest {

    @Test
    void one_movement_forward() {
        String steps = "M";
        Rover rover = new Rover();

        String position = rover.move(steps);

        assertEquals("0:1:N", position);
    }

    @Test
    void no_movement_forward() {
        String steps = "";
        Rover rover = new Rover();

        String position = rover.move(steps);

        assertEquals("0:0:N", position);
    }

    @Test
    void two_movements_forward() {
        String steps = "MM";
        Rover rover = new Rover();

        String position = rover.move(steps);

        assertEquals("0:2:N", position);
    }

    @Test
    void ten_movements_forward_should_go_back_to_start_position() {
        String steps = generateString("M", 10);
        Rover rover = new Rover();

        String position = rover.move(steps);

        assertEquals("0:0:N", position);
    }

    @Test
    void more_than_ten_movements_forward_wraps_around_the_grid() {
        String steps = generateString("M", 12);
        Rover rover = new Rover();

        String position = rover.move(steps);

        assertEquals("0:2:N", position);
    }

    private String generateString(String symbol, int lengthS) {
        StringBuilder steps = new StringBuilder(symbol);
        while (steps.length() < lengthS) {
            steps.append(symbol);
        }
        return steps.toString();
    }
}
