package edreams.kata.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RoverTest {

    private Rover rover;

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
        String commands = generateString("M", 10);

        String position = rover.move(commands);

        assertEquals("0:0:N", position);
    }

    @Test
    void more_than_ten_movements_forward_wraps_around_the_grid() {
        String commands = generateString("M", 12);

        String position = rover.move(commands);

        assertEquals("0:2:N", position);
    }

    @Test
    void change_direction_to_left() {
        String command = "L";

        String position = rover.move(command);

        assertEquals("0:0:W", position);
    }

    @Test
    void change_direction_to_left_two_times() {
        String command = "LL";

        String position = rover.move(command);

        assertEquals("0:0:S", position);
    }

    @Test
    void change_direction_to_left_three_times() {
        String command = "LLL";

        String position = rover.move(command);

        assertEquals("0:0:E", position);
    }

    @Test
    void change_direction_left_four_times() {
        String command = "LLLL";

        String position = rover.move(command);

        assertEquals("0:0:N", position);
    }

    @Test
    void change_direction_left_five_times() {
        String command = "LLLLL";

        String position = rover.move(command);

        assertEquals("0:0:W", position);
    }

    @Test
    void change_direction_to_right() {
        String command = "R";

        String position = rover.move(command);

        assertEquals("0:0:E", position);
    }

    @Test
    void change_direction_to_right_two_times() {
        String command = "RR";

        String position = rover.move(command);

        assertEquals("0:0:S", position);
    }

    @Test
    void change_direction_to_right_three_times() {
        String command = "RRR";

        String position = rover.move(command);

        assertEquals("0:0:W", position);
    }

    @Test
    void change_direction_to_right_four_times() {
        String command = "RRRR";

        String position = rover.move(command);

        assertEquals("0:0:N", position);
    }

    @Test
    void change_direction_to_right_five_times() {
        String command = "RRRRR";

        String position = rover.move(command);

        assertEquals("0:0:E", position);
    }

    @Test
    void move_forward_and_rotate_left() {
        String command = "ML";

        String position = rover.move(command);

        assertEquals("0:1:W", position);
    }

    @Test
    void move_to_the_right() {
        String command = "RM";

        String position = rover.move(command);

        assertEquals("1:0:E", position);
    }

    @Test
    void move_to_east_and_come_back() {
        String command = "RMLLM";

        String position = rover.move(command);

        assertEquals("0:0:W", position);
    }

    @BeforeEach
    void setUp() {
        rover = new Rover();
    }

    @Test
    void move_to_left_and_move_forward() {
        String command = "LM";

        String position = rover.move(command);

        assertEquals("9:0:W", position);
    }

    private String generateString(String symbol, int lengthS) {
        StringBuilder commands = new StringBuilder(symbol);
        while (commands.length() < lengthS) {
            commands.append(symbol);
        }
        return commands.toString();
    }
}
