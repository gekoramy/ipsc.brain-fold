import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Power {

    private final Map<Integer, BigInteger> folds = new HashMap<>();

    public Power() {
        folds.put(1, BigInteger.valueOf(2));
    }

    public BigInteger get(int n) {
        return folds.computeIfAbsent(n, i -> (get(i - 1).multiply(BigInteger.valueOf(2))));
    }
}
