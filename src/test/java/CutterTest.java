import org.junit.Test;

import static org.junit.Assert.*;

public class CutterTest {

    private final Cutter cutter = new Cutter();

    @Test
    public void RR() {
        Paper paper = new Paper()
                .foldRight()
                .foldRight();

        assertEquals(2, cutter.cutHorizontal(paper));
        assertEquals(5, cutter.cutVertical(paper));
    }

    @Test
    public void RT() {
        Paper paper = new Paper()
                .foldLeft()
                .foldTop();

        assertEquals(3, cutter.cutHorizontal(paper));
        assertEquals(3, cutter.cutVertical(paper));
    }

    @Test
    public void TR() {
        Paper paper = new Paper()
                .foldTop()
                .foldRight();

        assertEquals(3, cutter.cutHorizontal(paper));
        assertEquals(3, cutter.cutVertical(paper));
    }

    @Test
    public void TRT() {
        Paper paper = new Paper()
                .foldTop()
                .foldRight()
                .foldTop();

        assertEquals(5, cutter.cutHorizontal(paper));
        assertEquals(3, cutter.cutVertical(paper));
    }

    @Test
    public void TT() {
        Paper paper = new Paper()
                .foldTop()
                .foldTop();

        assertEquals(2, cutter.cutVertical(paper));
        assertEquals(5, cutter.cutHorizontal(paper));
    }

    @Test
    public void TTT() {
        Paper paper = new Paper()
                .foldTop()
                .foldTop()
                .foldTop();

        assertEquals(2, cutter.cutVertical(paper));
        assertEquals(9, cutter.cutHorizontal(paper));
    }

    @Test
    public void LB_V() {
        assertEquals(3, cutter.cutVertical(
                new Paper()
                        .foldLeft()
                        .foldBottom()
        ));
    }
}