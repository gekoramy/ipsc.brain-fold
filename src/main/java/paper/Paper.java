package paper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Paper {

    private final Map<Fold, Long> folds = new HashMap<>();

    public Paper() {
    }

    private Paper(Map<Fold, Long> folds) {
        this.folds.putAll(folds);
    }

    public static Paper foldIt(Stream<Fold> folds) {
        return new Paper(folds.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public static Paper foldIt(Fold... folds) {
        return foldIt(Arrays.stream(folds));
    }

    public long many(Fold fold) {
        return folds.computeIfAbsent(fold, k -> 0L);
    }
}
