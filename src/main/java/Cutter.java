public class Cutter {

    private final Folds folds = new Folds();
    private final Power power = new Power();

    int cutHorizontal(Paper paper) {
        if (paper.t == 0 && paper.b == 0)
            return 2;

        int horizontal = paper.t + paper.b;

        return power.get(horizontal + 1) - folds.get(horizontal);
    }

    int cutVertical(Paper paper) {
        if (paper.r == 0 && paper.l == 0)
            return 2;

        int vertical = paper.r + paper.l;

        return power.get(vertical + 1) - folds.get(vertical);
    }
}
