package edreams.kata.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RoverTest {

    private Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover();
    }

    @Test
    void no_movement_forward() {
        String position = rover.move("");

        assertEquals("0:0:N", position);
    }

    @Test
    void one_movement_forward() {
        String position = rover.move("M");

        assertEquals("0:1:N", position);
    }

    @Test
    void two_movements_forward() {
        String position = rover.move("MM");

        assertEquals("0:2:N", position);
    }

    @Test
    void ten_movements_forward_should_go_back_to_start_position() {
        String commands = repeatCommand("M", 10);

        String position = rover.move(commands);

        assertEquals("0:0:N", position);
    }

    @Test
    void more_than_ten_movements_forward_wraps_around_the_grid() {
        String commands = repeatCommand("M", 12);

        String position = rover.move(commands);

        assertEquals("0:2:N", position);
    }

    @Test
    void change_direction_to_left() {
        String position = rover.move("L");

        assertEquals("0:0:W", position);
    }

    @Test
    void change_direction_to_left_two_times() {
        String position = rover.move("LL");

        assertEquals("0:0:S", position);
    }

    @Test
    void change_direction_to_left_three_times() {
        String position = rover.move("LLL");

        assertEquals("0:0:E", position);
    }

    @Test
    void change_direction_left_four_times() {
        String position = rover.move("LLLL");

        assertEquals("0:0:N", position);
    }

    @Test
    void change_direction_left_five_times() {
        String position = rover.move("LLLLL");

        assertEquals("0:0:W", position);
    }

    @Test
    void change_direction_to_right() {
        String position = rover.move("R");

        assertEquals("0:0:E", position);
    }

    @Test
    void change_direction_to_right_two_times() {
        String position = rover.move("RR");

        assertEquals("0:0:S", position);
    }

    @Test
    void change_direction_to_right_three_times() {
        String position = rover.move("RRR");

        assertEquals("0:0:W", position);
    }

    @Test
    void change_direction_to_right_four_times() {
        String position = rover.move("RRRR");

        assertEquals("0:0:N", position);
    }

    @Test
    void change_direction_to_right_five_times() {
        String position = rover.move("RRRRR");

        assertEquals("0:0:E", position);
    }

    @Test
    void move_forward_and_rotate_left() {
        String position = rover.move("ML");

        assertEquals("0:1:W", position);
    }

    @Test
    void move_to_the_right_move_forward() {
        String position = rover.move("RM");

        assertEquals("1:0:E", position);
    }

    @Test
    void move_to_east_and_come_back() {
        String position = rover.move("RMLLM");

        assertEquals("0:0:W", position);
    }

    @Test
    void move_to_left_and_move_forward() {
        String position = rover.move("LM");

        assertEquals("9:0:W", position);
    }

    @Test
    void move_to_north_and_come_back() {
        String position = rover.move("MLLM");

        assertEquals("0:0:S", position);
    }

    @Test
    void move_without_obstacles() {
        String position = rover.move("MMRMMLM");

        assertEquals("2:3:N", position);
    }

    private String repeatCommand(String symbol, int lengthS) {
        StringBuilder commands = new StringBuilder(symbol);
        while (commands.length() < lengthS) {
            commands.append(symbol);
        }
        return commands.toString();
    }
}
