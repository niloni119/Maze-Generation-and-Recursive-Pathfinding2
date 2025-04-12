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

    public ArrayList<int[]> sol() {
        ArrayList<int[]> p = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[n][n];
        HashMap<String, int[]> cm = new HashMap<>();
        int[] start = {sx, sy};
        q.offer(start);
        v[sy][sx] = true;

        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int x = c[0], y = c[1];

            if (x == ex && y == ey) {
                while (c != null) {
                    p.add(c);
                    String key = Arrays.toString(c);
                    c = cm.get(key);
                }
                Collections.reverse(p);
                break;
            }

            for (int i = 0; i < d.length; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!v[ny][nx] && m[ny][nx] == P) {
                        int[] next = {nx, ny};
                        q.add(next);
                        v[ny][nx] = true;
                        cm.put(Arrays.toString(next), c);
                    }
                }
            }
        }
        return p;
    }

    public void prt(ArrayList<int[]> p) {
        System.out.println("Maze with the path:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isp = false;
                for (int k = 0; k < p.size(); k++) {
                    int[] s = p.get(k);
                    if (s[0] == j && s[1] == i) {
                        isp = true;
                        break;
                    }
                }
                if (isp) {
                    System.out.print("* ");
                } else if (m[i][j] == W) {
                    System.out.print("[]");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 11;
        Main mg = new Main(n);
        ArrayList<int[]> p = mg.sol();
        mg.prt(p);  // print the maze with the solution path
    }
}
