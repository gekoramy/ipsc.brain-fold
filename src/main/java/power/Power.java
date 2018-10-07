package power;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Power {

    private static final Map<BigInteger, Base> BASES = new HashMap<>();

    public static Base base(BigInteger base) {
        return BASES.computeIfAbsent(base, Base::new);
    }
}
