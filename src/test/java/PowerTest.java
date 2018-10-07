import org.junit.Test;
import power.Base;
import power.Power;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PowerTest {

    private static final int n = 45;
    private static final Stream<BigInteger> BIG_INTEGERS = IntStream.range(0, n).mapToObj(BigInteger::valueOf);

    private void check(BigInteger base, int exp) {
        assertEquals(base.pow(exp), Power.base(base).pow(exp));
    }

    @Test
    public void once_invoked_should_store_base() {
        assertFalse(Power.stored().contains(BigInteger.TEN));
        Power.base(BigInteger.TEN);
        assertTrue(Power.stored().contains(BigInteger.TEN));
    }

    @Test
    public void once_calculated_should_store_result() {
        Base one = Power.base(BigInteger.ONE);

        assertFalse(one.stored().contains(5L));
        one.pow(5L);
        assertTrue(one.stored().contains(5L));
    }

    @Test
    public void check_equality() {
        BIG_INTEGERS.forEach(base -> IntStream.range(0, n).forEach(exp -> check(base, exp)));
    }
}