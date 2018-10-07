package paper;

import power.Base;
import power.Power;

import java.math.BigInteger;

public class Cutter {

    private static final Base TWO = Power.base(BigInteger.valueOf(2));

    public BigInteger cutHorizontal(Paper paper) {
        if (paper.t == 0 && paper.b == 0)
            return BigInteger.valueOf(2);

        final int horizontal = paper.t + paper.b;
        return TWO.pow(horizontal + 1).subtract(
                TWO.pow(horizontal).subtract(BigInteger.ONE)
        );
    }

    public BigInteger cutVertical(Paper paper) {
        if (paper.r == 0 && paper.l == 0)
            return BigInteger.valueOf(2);

        final int vertical = paper.r + paper.l;
        return TWO.pow(vertical + 1).subtract(
                TWO.pow(vertical).subtract(BigInteger.ONE)
        );
    }
}
