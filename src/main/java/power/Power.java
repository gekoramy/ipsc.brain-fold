package power;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Power {

    private static final Map<BigInteger, Base> BASES = new HashMap<>();

    public static Base base(BigInteger base) {
        return BASES.computeIfAbsent(base, Base::new);
    }

    public static Set<BigInteger> stored() {
        return BASES.keySet();
    }
}
