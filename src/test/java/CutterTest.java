import org.junit.Test;
import paper.Cutter;
import paper.Paper;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static paper.Fold.TOP;
import static paper.Fold.RIGHT;
import static paper.Fold.BOTTOM;
import static paper.Fold.LEFT;

public class CutterTest {

    private final Cutter cutter = new Cutter();

    @Test
    public void RR() {
        Paper paper = Paper.foldIt(RIGHT, RIGHT);

        assertEquals(BigInteger.valueOf(2), cutter.cutHorizontal(paper));
        assertEquals(BigInteger.valueOf(5), cutter.cutVertical(paper));
    }

    @Test
    public void RT() {
        Paper paper = Paper.foldIt(RIGHT, TOP);

        assertEquals(BigInteger.valueOf(3), cutter.cutHorizontal(paper));
        assertEquals(BigInteger.valueOf(3), cutter.cutVertical(paper));
    }

    @Test
    public void TR() {
        Paper paper = Paper.foldIt(TOP, RIGHT);

        assertEquals(BigInteger.valueOf(3), cutter.cutHorizontal(paper));
        assertEquals(BigInteger.valueOf(3), cutter.cutVertical(paper));
    }

    @Test
    public void TRT() {
        Paper paper = Paper.foldIt(TOP, RIGHT, TOP);

        assertEquals(BigInteger.valueOf(5), cutter.cutHorizontal(paper));
        assertEquals(BigInteger.valueOf(3), cutter.cutVertical(paper));
    }

    @Test
    public void TT() {
        Paper paper = Paper.foldIt(TOP, TOP);

        assertEquals(BigInteger.valueOf(2), cutter.cutVertical(paper));
        assertEquals(BigInteger.valueOf(5), cutter.cutHorizontal(paper));
    }

    @Test
    public void TTT() {
        Paper paper = Paper.foldIt(TOP, TOP, TOP);

        assertEquals(BigInteger.valueOf(2), cutter.cutVertical(paper));
        assertEquals(BigInteger.valueOf(9), cutter.cutHorizontal(paper));
    }

    @Test
    public void TTTT() {
        Paper paper = Paper.foldIt(TOP, TOP, TOP, TOP);

        assertEquals(BigInteger.valueOf(2), cutter.cutVertical(paper));
        assertEquals(BigInteger.valueOf(17), cutter.cutHorizontal(paper));
    }

    @Test
    public void LB_V() {
        assertEquals(BigInteger.valueOf(3), cutter.cutVertical(
                Paper.foldIt(LEFT, BOTTOM)
        ));
    }
}