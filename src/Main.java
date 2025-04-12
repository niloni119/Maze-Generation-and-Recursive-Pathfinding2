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

        int[][] d = {{0, 2}, {2, 0}, {-2, 0}, {0, -2}};

        while (!s.isEmpty()) {
            int[] c = s.peek();
            x = c[0];
            y = c[1];
            ArrayList<int[]> ns = new ArrayList<>();

            for (int[] i : d) {
                int nx = x + i[0];
                int ny = y + i[1];
                if (nx > 0 && ny > 0 && nx < n - 1 && ny < n - 1 && m[ny][nx] == W) {
                    ns.add(new int[]{nx, ny});
                }
            }

            if (!ns.isEmpty()) {
                int[] nt = ns.get(r.nextInt(ns.size()));
                int mx = (x + nt[0]) / 2;
                int my = (y + nt[1]) / 2;
                m[my][mx] = P;
                m[nt[1]][nt[0]] = P;
                s.push(nt);
            } else {
                s.pop();
            }
        }

        m[sy][sx] = P;
        m[ey][ex] = P;
    }
}
