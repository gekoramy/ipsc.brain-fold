import java.math.BigInteger;

public class Cutter {

    private final Folds folds = new Folds();
    private final Power power = new Power();

    BigInteger cutHorizontal(Paper paper) {
        if (paper.t == 0 && paper.b == 0)
            return BigInteger.valueOf(2);

        final int horizontal = paper.t + paper.b;
        return power.get(horizontal + 1).subtract(BigInteger.valueOf(folds.get(horizontal)));
    }

    BigInteger cutVertical(Paper paper) {
        if (paper.r == 0 && paper.l == 0)
            return BigInteger.valueOf(2);

        final int vertical = paper.r + paper.l;
        return power.get(vertical + 1).subtract(BigInteger.valueOf(folds.get(vertical)));
    }
}
