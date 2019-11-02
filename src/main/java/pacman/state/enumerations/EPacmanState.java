package pacman.state.enumerations;

public enum EPacmanState {
    NORMAL(0),
    SUPER(1),
    DEAD(2);

    private int code;

    EPacmanState(int code) {
        this.code = code;
    }
}
