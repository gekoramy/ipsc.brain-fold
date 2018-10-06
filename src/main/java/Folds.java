import java.util.HashMap;
import java.util.Map;

public class Folds {

    private final Map<Integer, Integer> folds = new HashMap<>();

    public Folds() {
        folds.put(1, 1);
    }

    public int get(int n) {
        return folds.computeIfAbsent(n, i -> get(i - 1) * 2 + 1);
    }
}
