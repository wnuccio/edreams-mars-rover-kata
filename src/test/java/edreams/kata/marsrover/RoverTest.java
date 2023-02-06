package edreams.kata.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RoverTest {

    @Test
    void one_movement_forward() {
        String steps = "M";
        Rover rover = new Rover();

        String position = rover.move(steps);

        assertEquals("0:1:N", position);
    }

}
