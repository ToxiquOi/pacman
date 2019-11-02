package pacman.state.enumerations;

public enum EGhostState {
    TRACK(0),
    EYES(1),
    FLEE(2);

    private int code;

    EGhostState(int code) {
        this.code = code;
    }
}
