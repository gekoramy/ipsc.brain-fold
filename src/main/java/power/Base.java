package power;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Base {

    private final BigInteger base;
    private final Map<Long, BigInteger> powers = new HashMap<>();

    Base(BigInteger base) {
        this.base = base;
        powers.put(0L, BigInteger.ONE);
        powers.put(1L, base);
        powers.put(2L, base.pow(2));
    }

    public BigInteger pow(long exp) {
        if (exp < 0) throw new IllegalArgumentException("exp cannot be negative");

        return powers.computeIfAbsent(exp, n -> isEven(n) ?
                Power.base(pow(2)).pow(n / 2) :
                base.multiply(Power.base(pow(2)).pow(n / 2)));
    }

    public Set<Long> stored() {
        return powers.keySet();
    }

    private boolean isEven(Long n) {
        return n % 2 == 0;
    }
}
