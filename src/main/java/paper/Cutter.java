package paper;

import power.Base;
import power.Power;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Cutter {

    private static final Base TWO = Power.base(BigInteger.valueOf(2));
    private static final Map<Long, BigInteger> PIECES = new HashMap<>();

    static {
        PIECES.put(0L, BigInteger.valueOf(2));
    }

    private BigInteger cut(long folds) {
        return PIECES.computeIfAbsent(
                folds,
                n -> TWO.pow(n).add(BigInteger.ONE)
        );
    }

    public BigInteger cutHorizontal(Paper paper) {
        final long horizontal = paper.many(Fold.TOP) + paper.many(Fold.BOTTOM);
        return cut(horizontal);
    }

    public BigInteger cutVertical(Paper paper) {
        final long vertical = paper.many(Fold.RIGHT) + paper.many(Fold.LEFT);
        return cut(vertical);
    }
}
