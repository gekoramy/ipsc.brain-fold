package paper;

import power.Base;
import power.Power;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Cutter {

    private static final Base TWO = Power.base(BigInteger.valueOf(2));
    private static final Map<Integer, BigInteger> PIECES = new HashMap<>();

    static {
        PIECES.put(0, BigInteger.valueOf(2));
    }

    private BigInteger cut(int folds) {
        return PIECES.computeIfAbsent(
                folds,
                n -> TWO.pow(folds + 1).subtract(
                        TWO.pow(folds).subtract(BigInteger.ONE)
                )
        );
    }

    public BigInteger cutHorizontal(Paper paper) {
        final int horizontal = paper.t + paper.b;
        return cut(horizontal);
    }

    public BigInteger cutVertical(Paper paper) {
        final int vertical = paper.r + paper.l;
        return cut(vertical);
    }
}
