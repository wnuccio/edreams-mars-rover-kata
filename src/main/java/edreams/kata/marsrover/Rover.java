package edreams.kata.marsrover;

public class Rover {

    public String move(String steps) {
        return "0:" + steps.length() % 10 + ":N";
    }

}
