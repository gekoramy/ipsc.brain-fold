package power;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Base {

    private final BigInteger base;
    private final Map<Integer, BigInteger> powers = new HashMap<>();

    Base(BigInteger base) {
        this.base = base;
        powers.put(0, BigInteger.ONE);
        powers.put(1, base);
        powers.put(2, base.pow(2));
    }

    public BigInteger pow(int exp) {
        if (exp < 0) throw new IllegalArgumentException("exp cannot be negative");

        return powers.computeIfAbsent(exp, n -> isEven(n) ?
                Power.base(pow(2)).pow(n / 2) :
                base.multiply(Power.base(pow(2)).pow(n / 2)));
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }
}
