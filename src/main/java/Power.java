import java.util.HashMap;
import java.util.Map;

public class Power {

    private final Map<Integer, Integer> folds = new HashMap<>();

    public Power() {
        folds.put(1, 2);
    }

    public int get(int n) {
        return folds.computeIfAbsent(n, i -> get(i - 1) * 2);
    }
}
