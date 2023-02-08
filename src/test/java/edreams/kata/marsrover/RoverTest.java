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
    void two_movement_forward() {
        String steps = "MM";
        Rover rover = new Rover();

        String position = rover.move(steps);

        assertEquals("0:2:N", position);
    }

    @Test
    void trytest2() {
        assertTrue(true);
    }

    @Test
    void tryTest3() {
        assertTrue(true);
    }
}
