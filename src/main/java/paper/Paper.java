package paper;

public class Paper {

    final int t;
    final int r;
    final int b;
    final int l;

    public Paper() {
        this.t = 0;
        this.r = 0;
        this.b = 0;
        this.l = 0;
    }

    private Paper(int t, int r, int b, int l) {
        this.t = t;
        this.r = r;
        this.b = b;
        this.l = l;
    }

    public Paper foldLeft() {
        return new Paper(t, r, b, l + 1);
    }

    public Paper foldRight() {
        return new Paper(t, r + 1, b, l);
    }

    public Paper foldTop() {
        return new Paper(t + 1, r, b, l);
    }

    public Paper foldBottom() {
        return new Paper(t, r, b + 1, l);
    }
}
