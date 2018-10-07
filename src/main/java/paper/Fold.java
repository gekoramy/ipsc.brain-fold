package paper;

public enum Fold {
    TOP,
    RIGHT,
    BOTTOM,
    LEFT;

    public static Fold fromChar(char c) {
        switch (c) {
            case 'T':
                return TOP;
            case 'R':
                return RIGHT;
            case 'B':
                return BOTTOM;
            case 'L':
                return LEFT;
            default:
                throw new IllegalArgumentException("Invalid character : " + c);
        }
    }
}

