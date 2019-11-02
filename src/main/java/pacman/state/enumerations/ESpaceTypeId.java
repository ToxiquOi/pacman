package pacman.state.enumerations;

public enum ESpaceTypeId {
    EMPTY(0),
    GUM(1),
    SUPERGUM(2),
    GRAVEYARD(3),
    START(4),
    UNKNOWN(5);

    private final int code;

    ESpaceTypeId(int code) {
        this.code = code;
    }

    public static ESpaceTypeId fromCode(int code) {
        switch(code) {
            case 0: return EMPTY;
            case 1: return GUM;
            case 2: return SUPERGUM;
            case 3: return GRAVEYARD;
            case 4: return START;
            case 5: return UNKNOWN;
            default: break;
        }
        throw new IllegalArgumentException("Unvalid code: " + code);
    }
}
