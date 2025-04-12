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
        gen();
    }

    private void gen() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = W;
            }
        }

        int x = 1;
        int y = 1;
        Stack<int[]> s = new Stack<>();
        m[x][y] = P;
        s.push(new int[]{x, y});
    }
}
