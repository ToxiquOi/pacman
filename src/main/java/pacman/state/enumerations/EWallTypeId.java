package pacman.state.enumerations;

public enum EWallTypeId {
    TOPLEFT(0),
    TOPRIGHT(1),
    BOTTOMLEFT(2),
    BOTTOMRIGHT(3),
    HORIZONTAL(4),
    VERTICAL(5);

    private final int code;

    EWallTypeId(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static EWallTypeId fromCode(int code) {
        switch(code) {
            case 0: return TOPLEFT;
            case 1: return TOPRIGHT;
            case 2: return BOTTOMLEFT;
            case 3: return BOTTOMRIGHT;
            case 4: return HORIZONTAL;
            case 5: return VERTICAL;
        }
        throw new IllegalArgumentException("Code "+code+" invalide");
    }
}
