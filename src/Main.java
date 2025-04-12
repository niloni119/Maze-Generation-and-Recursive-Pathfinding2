import java.util.*;

public class Main {
    private static final int W = 1;
    private static final int P = 0;
    private int n;
    private int[][] m;
    private Random r = new Random();
    private int sx = 0, sy = 1;
    private int ex, ey;

    public Main(int n) {
        this.n = n + 2;
        this.m = new int[this.n][this.n];
        this.ex = this.n - 1;
        this.ey = this.n - 2;
        gen(); // generate maze right after creation
    }

    private void gen() {
        // will implement later
    }
}
