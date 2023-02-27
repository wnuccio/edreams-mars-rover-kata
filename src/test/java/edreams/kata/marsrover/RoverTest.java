package edreams.kata.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RoverTest {

    @Test
    void no_movement_forward() {
        String commands = "";
        Rover rover = new Rover();

        String position = rover.move(commands);

        assertEquals("0:0:N", position);
    }

    @Test
    void one_movement_forward() {
        String commands = "M";
        Rover rover = new Rover();

        String position = rover.move(commands);

        assertEquals("0:1:N", position);
    }

    @Test
    void two_movements_forward() {
        String commands = "MM";
        Rover rover = new Rover();

        String position = rover.move(commands);

        assertEquals("0:2:N", position);
    }

    @Test
    void ten_movements_forward_should_go_back_to_start_position() {
        String commands = generateString("M", 10);
        Rover rover = new Rover();

        String position = rover.move(commands);

        assertEquals("0:0:N", position);
    }

    @Test
    void more_than_ten_movements_forward_wraps_around_the_grid() {
        String commands = generateString("M", 12);
        Rover rover = new Rover();

        String position = rover.move(commands);

        assertEquals("0:2:N", position);
    }

    @Test
    void change_direction_to_left() {
        String command = "L";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:W", position);
    }

    @Test
    void change_direction_to_left_two_times() {
        String command = "LL";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:S", position);
    }

    @Test
    void change_direction_to_left_three_times() {
        String command = "LLL";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:E", position);
    }

    @Test
    void change_direction_left_four_times() {
        String command = "LLLL";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:N", position);
    }

    @Test
    void change_direction_left_five_times() {
        String command = "LLLLL";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:W", position);
    }

    @Test
    void change_direction_to_right() {
        String command = "R";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:E", position);
    }

    @Test
    void change_direction_to_right_two_times() {
        String command = "RR";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:S", position);
    }

    @Test
    void change_direction_to_right_three_times() {
        String command = "RRR";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:W", position);
    }

    @Test
    void change_direction_to_right_four_times() {
        String command = "RRRR";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:N", position);
    }

    @Test
    void change_direction_to_right_five_times() {
        String command = "RRRRR";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:0:E", position);
    }

    @Test
    void move_forward_and_rotate_left() {
        String command = "ML";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("0:1:W", position);
    }

    @Test
    void move_to_the_right() {
        String command = "RM";
        Rover rover = new Rover();

        String position = rover.move(command);

        assertEquals("1:0:E", position);
    }

    private String generateString(String symbol, int lengthS) {
        StringBuilder commands = new StringBuilder(symbol);
        while (commands.length() < lengthS) {
            commands.append(symbol);
        }
        return commands.toString();
    }
}
