package pacman.state.enumerations;

public enum EDirection {
    NONE(0),
    NORTH(1),
    SOUTH(2),
    EAST(3),
    WEST(4);

    private final int code;

    EDirection(int code) {
        this.code = code;
    }
}
