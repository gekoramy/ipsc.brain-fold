import org.junit.Test;
import paper.Cutter;
import paper.Fold;
import paper.Paper;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class IPSCTest {
    private static final Cutter cutter = new Cutter();

    @Test
    public void contest() {
        final InputStream inp = IPSCTest.class.getResourceAsStream("b1.in");
        final InputStream ver = IPSCTest.class.getResourceAsStream("b1.out");

        try (
                final Scanner scanInp = new Scanner(inp);
                final Scanner scanVer = new Scanner(ver)
        ) {
            int n = scanInp.nextInt();
            scanInp.nextLine();
            scanInp.nextLine();

            String calculated = IntStream.range(0, n)
                    .mapToObj(i -> {
                        int folds = scanInp.nextInt();
                        scanInp.nextLine();

                        Paper paper = Paper.foldIt(
                                scanInp.nextLine()
                                        .chars()
                                        .limit(folds)
                                        .mapToObj(c -> (char) c)
                                        .map(Fold::fromChar)
                        );

                        switch (scanInp.nextLine()) {
                            case "BT":
                            case "TB":
                                return cutter.cutVertical(paper);

                            case "LR":
                            case "RL":
                                return cutter.cutHorizontal(paper);

                            default:
                                throw new InputMismatchException();
                        }
                    })
                    .map(i -> i.mod(BigInteger.valueOf(1000000007)))
                    .map(BigInteger::toString)
                    .collect(Collectors.joining("\n"));

            String correct = IntStream.range(0, n)
                    .mapToObj(i -> scanVer.nextLine())
                    .collect(Collectors.joining("\n"));

            assertEquals(correct, calculated);
        }
    }
}
